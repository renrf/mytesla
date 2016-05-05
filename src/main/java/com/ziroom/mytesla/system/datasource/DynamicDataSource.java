/**
 * 
 */
package com.ziroom.mytesla.system.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 配置读取数据库的数据源
 * @author liuys
 * 2015年8月11日
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey()
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return DynamicDataSourceHolder.getDataSouce();
	}

}
