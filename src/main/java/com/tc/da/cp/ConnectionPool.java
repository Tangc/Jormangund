package com.tc.da.cp;

import java.sql.Connection;
import java.sql.SQLException;

import com.tc.da.cp.config.DBConfig;

public abstract class ConnectionPool {

	protected DBConfig dbconfig;

	public ConnectionPool(DBConfig dbconfig) {
		super();
		this.dbconfig = dbconfig;
	}
	
	/**
	 * 获得数据库连接
	 * @return
	 */
	public abstract Connection getConnection() throws SQLException;
	
	/**
	 * 释放数据库连接
	 * @param conn
	 */
	public abstract void releaseConnection(Connection conn);
	
}
