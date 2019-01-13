package com.yufb.top.dsconfig;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class DynamicDataSourceContextHolder {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceContextHolder.class);

    private static Lock lock = new ReentrantLock();

    private static int counter = 0;


    private static final ThreadLocal<String> CONTEXT_HOLDER = ThreadLocal.withInitial(DataSourceKey.master::name);


    public static List<Object> dataSourceKeys = new ArrayList<>();


    public static List<Object> slaveDataSourceKeys = new ArrayList<>();


    public static void setDataSourceKey(String key) {
        CONTEXT_HOLDER.set(key);
    }


    public static void useMasterDataSource() {
        CONTEXT_HOLDER.set(DataSourceKey.master.name());
    }


    public static void useSlaveDataSource() {
        lock.lock();

        try {
            int datasourceKeyIndex = counter % slaveDataSourceKeys.size();
            CONTEXT_HOLDER.set(String.valueOf(slaveDataSourceKeys.get(datasourceKeyIndex)));
            counter++;
        } catch (Exception e) {
            logger.error("Switch slave datasource failed, error message is {}", e.getMessage());
            useMasterDataSource();
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static String getDataSourceKey() {
        return CONTEXT_HOLDER.get();
    }


    public static void clearDataSourceKey() {
        CONTEXT_HOLDER.remove();
    }


    public static boolean containDataSourceKey(String key) {
        return dataSourceKeys.contains(key);
    }
}
