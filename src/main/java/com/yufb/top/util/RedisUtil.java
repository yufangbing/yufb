package com.yufb.top.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author yufangbing
 *
 */
@Component
public class RedisUtil {
	
		@Autowired
		private StringRedisTemplate redisTemplate;
		
		/**
		 * 添加键值对
		 * @param key
		 * @param value
		 * @param expireTime   过期时间（以秒为单位
		 * @return
		 */
		public boolean setKeyValue(final String key,String value,long expireTime){
			boolean flag=false;
			try{
				ValueOperations<String,String> operations=redisTemplate.opsForValue();
				operations.set(key, value);
				redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
				flag=true;
			}catch(Exception e){
				// TODO: handle exception
			}
			return flag;
		}
		
		/**
		 * 添加键值对
		 * @param key
		 * @param value
		 * @return
		 */
		public boolean setKeyValue(final String key,String value){
			boolean flag=false;
			try{
				ValueOperations<String,String> operations=redisTemplate.opsForValue();
				operations.set(key, value);
				flag=true;
			}catch(Exception e){
				// TODO: handle exception
			}
			return flag;
		}
		
		/**
		 * 添加list
		 * @param key
		 * @param value
		 * @param expireTime    过期时间（以秒为单位
		 * @return
		 */
		public boolean setKeyList(final String key,List<String> value,long expireTime){
			boolean flag=false;
			try{
				ListOperations<String, String> operations=redisTemplate.opsForList();
				operations.rightPushAll(key, value);
				redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
				flag=true;
			}catch(Exception e){
				// TODO: handle exception	
			}
			return flag;
		}
		
		/**
		 * 添加list
		 * @param key
		 * @param value
		 * @return
		 */
		public boolean setKeyList(final String key,List<String> value){
			boolean flag=false;
			try{
				ListOperations<String,String> operations=redisTemplate.opsForList();
				operations.rightPushAll(key, value);
				flag=true;
			}catch(Exception e){
				// TODO: handle exception	
			}
			return flag;
		}
		
		/**
		 * 获取指定键的值
		 * @param key
		 * @return
		 */
		public String getKeyValue(final String key){
			String result=null;
			result=redisTemplate.opsForValue().get(key);
			return result;
		}
		
		/**
		 * 获取指定键的值
		 * @param key
		 * @return
		 */
		public List<String> getListValue(final String key){
			ListOperations<String,String> list =redisTemplate.opsForList(); 
			return redisTemplate.opsForList().range(key, 0, list.size(key));
		}
		/**
		 * 获取指定下标之间的list
		 * @param key
		 * @param begin
		 * @param end
		 * @return
		 */
		public List<String> getKeyList(final String key,long begin,long end){
			List<String> result=null;
			result=redisTemplate.opsForList().range(key, begin, end);
			return result;
		}
		
		/**
		 * 是否存在相应的键值
		 * @param key
		 * @return
		 */
		public boolean exists(final String key){
			return redisTemplate.hasKey(key);
		}
		
		/**
		 * 删除对应的缓存
		 * @param key
		 */
		public void remove(final String key){
			if(redisTemplate.hasKey(key)){
				redisTemplate.delete(key);
			}
		}
		
		/**
		 * 删除多个缓存
		 * @param keys
		 */
		public void removeList(List<String> keys){
			if(keys.size()>0){
				redisTemplate.delete(keys);
			}
		}

	/**
	 * 递增key值对应的value
	 * @param key
	 */
	public long countIncrement(String key){
		return redisTemplate.opsForValue().increment(key,1);
	}
	
	/**
	 * @author yufangbing
	 * 把redis当消息队列使用
	 * @param key
	 * @param value
	 * @return
	 */
	public Long lpush(final String key,String value){
		long result = redisTemplate.execute(new RedisCallback<Long>(){

			@Override
			public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				Long count =  redisConnection.lPush(serializer.serialize(key), serializer.serialize(value));
				return count;
			}
			
		});
		return result;
	}
	/**
	 * @author yufangbing
	 * 把redis当消息队列使用
	 * @param key
	 * @param value
	 * @return
	 */
	public Long rpush(final String key,String value){
		long result = redisTemplate.execute(new RedisCallback<Long>(){
			@Override
			public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				Long count =  redisConnection.rPush(serializer.serialize(key), serializer.serialize(value));
				return count;
			}
		});
		return result;
	}
	/**
	 * @author yufangbing
	 * 把redis当消息队列使用
	 * @param key
	 * @return
	 */
	public String lpop(final String key){
		String result = redisTemplate.execute(new RedisCallback<String>(){
			@Override
			public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				byte[] res =  redisConnection.lPop(serializer.serialize(key));
				return serializer.deserialize(res);
			}
		});
		return result;
	}
	/**
	 * @author yufangbing
	 * 把redis当消息队列使用
	 * @param key
	 * @return
	 */
	public String rpop(final String key){
		String result = redisTemplate.execute(new RedisCallback<String>(){
			@Override
			public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
				RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
				byte[] res =  redisConnection.rPop(serializer.serialize(key));
				return serializer.deserialize(res);
			}
		});
		return result;
	}
	
}
