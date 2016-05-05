/**
 * 
 */
package com.ziroom.mytesla.system.datasource;

/**
 * 设置数据源
 * @author liuys
 * 2015年8月11日
 */
public class DynamicDataSourceHolder {

	public static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void putDataSource(String name) {
        holder.set(name);
    }

    public static String getDataSouce() {
        return holder.get();
    }
}
