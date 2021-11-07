package com.week7.jdbc.work3.datasource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultiDataSource extends AbstractRoutingDataSource{
    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    /**
     * 返回当前数据源
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }

    /**
     * 设置dataSourceKey的值
     * @param dataSource
     */
    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }
    /**
     * 清除dataSourceKey的值
     */
    public static void toDefault() {
        dataSourceKey.remove();
    }

}
