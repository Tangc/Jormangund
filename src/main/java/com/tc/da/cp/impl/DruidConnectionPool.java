package com.tc.da.cp.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.tc.da.cp.ConnectionPool;
import com.tc.da.cp.config.DBConfig;

/**
 * 建议使用Druid连接池
 * @see https://github.com/alibaba/druid
 * @author tangchao
 *
 */
public class DruidConnectionPool extends ConnectionPool {
	
	
	public DruidConnectionPool(DBConfig dbconfig) {
		super(dbconfig);
	}

	@Override
	public Connection getConnection() throws SQLException {
		return null;
	}

	@Override
	public void releaseConnection(Connection conn) {

	}

}
