package com.tc.da.cp.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.tc.da.cp.ConnectionPool;
import com.tc.da.cp.config.DBConfig;

/**
 * 默认连接池，实际上只有一条连接，是最简单的实现
 * @author tangchao
 *
 */
public class DefaultConnectionPool extends ConnectionPool {

	private Connection conn;
	private String driver;
	private String dburl;
	private String dbusername;
	private String dbpassword;
	
	public DefaultConnectionPool(DBConfig dbconfig) {
		super(dbconfig);
		init();
	}
	
	/**
	 * 初始化数据库相关属性
	 */
	private void init(){
		driver = "";
		dburl = "";
		dbusername = "";
		dbpassword = "";
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		//TODO
		conn = DriverManager.getConnection(dburl, dbusername, dbpassword);
		return null;
	}

	@Override
	public void releaseConnection(Connection conn) {
		//TODO
		
	}

}
