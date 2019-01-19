package com.yufb.top.util;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastJsonSerializer implements RedisSerializer<Object> {

	@Override
	public byte[] serialize(Object source) throws SerializationException {
		
		if (source == null) {
			return new byte[0];
		}
		return JSON.toJSONBytes(source, SerializerFeature.DisableCircularReferenceDetect);
		 
	}

	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		return (bytes == null ? null : JSON.parseObject(bytes, Object.class, Feature.DisableCircularReferenceDetect));
	}

}
