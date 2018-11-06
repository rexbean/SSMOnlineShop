package com.rex.onlineShop.dao.split;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicDataSourceHolder {
    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceHolder.class);
    // keep thread safe
    private static ThreadLocal<String> contextHolder = new ThreadLocal<>();
    public static final String DB_MASTER = "master";
    public static final String DB_SLAVE = "slave";

    public static String getDBType(){
        String db = contextHolder.get();
        if(db == null){
            db = DB_MASTER;
        }
        return db;
    }

    /**
     * set db type
     * @param str db type
     */
    public static void setDBType(String str){
        logger.debug("using data source is " + str);
        contextHolder.set(str);
    }

    /**
     * clear database type
     */
    public static void clearDBType(){
        contextHolder.remove();
    }
}
