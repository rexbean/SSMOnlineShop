package com.rex.onlineShop.dao.split;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Locale;
import java.util.Properties;

// in mybatis , the insert, delete , update are encapsulated in the update method
// Rowbounds and resultHandler is the return from query
@Intercepts({@Signature(type = Executor.class, method = "update", args= {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args= {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class DynamicDataSourceInterceptor implements Interceptor {
    // INSERT , UPDATE, DELETE using MASTER
    // SEARCH using SLAVE
    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceInterceptor.class);
    private static final String REGEX = ".*insert\\u0020.* | .*delete\\u0020.* | .*update\\u0020.*";
    @Override
    // Intercept at specific condition
    public Object intercept(Invocation invocation) throws Throwable {
        // whether this is a transaction
        Object[] objects = invocation.getArgs();
        MappedStatement ms = (MappedStatement) objects[0];
        String lookupKey = DynamicDataSourceHolder.DB_MASTER;
        boolean synchronizationActive = TransactionSynchronizationManager.isActualTransactionActive();
        if(!synchronizationActive){
            // READ Method
            if(ms.getSqlCommandType().equals(SqlCommandType.SELECT)){
                // if select Key is primary Key(SELECT LAST_INSERT_ID()), using MASTER
                if(ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)){
                    lookupKey = DynamicDataSourceHolder.DB_MASTER;
                } else {
                    BoundSql boundSql = ms.getSqlSource().getBoundSql(objects[1]);
                    String sql = boundSql.getSql().toLowerCase(Locale.US).replaceAll("[\\t\\n\\r]]"," ");
                    if(sql.matches(REGEX)){
                        lookupKey = DynamicDataSourceHolder.DB_MASTER;
                    } else {
                        lookupKey = DynamicDataSourceHolder.DB_SLAVE;
                    }
                }
            }
        } else {
            lookupKey = DynamicDataSourceHolder.DB_MASTER;
        }
        logger.debug("set the method[{}] use [{}] Strategy, SqlCommanType[{}]..",
                ms.getId(), lookupKey, ms.getSqlCommandType().name());
        DynamicDataSourceHolder.setDBType(lookupKey);
        return invocation.proceed();
    }

    @Override
    // determine return itself or agency
    public Object plugin(Object target) {
        // Executor is using for CRUD operations
        if(target instanceof Executor){
            return Plugin.wrap(target,this);
        } else {
            return target;
        }
    }

    @Override
    // do some configuration when initialization
    public void setProperties(Properties properties) {

    }
}
