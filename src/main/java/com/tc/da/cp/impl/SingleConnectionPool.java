package com.tc.da.cp.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import com.tc.da.cp.ConnectionPool;
import com.tc.da.cp.config.DBConfig;

/**
 * 单一连接池，实际上只有一条连接，是最简单的实现
 * @author tangchao
 *
 */
public class SingleConnectionPool extends ConnectionPool {

//	private static Logger logger = Logger.getLogger(FakeConnectionPool.class);
	
	private Connection conn;
	private String driver;
	private String dburl;
	private String dbusername;
	private String dbpassword;
	
	public SingleConnectionPool(DBConfig dbconfig) throws ClassNotFoundException {
		super(dbconfig);
		init();
	}
	
	/**
	 * 初始化数据库相关属性
	 * @throws ClassNotFoundException 
	 */
	private void init() throws ClassNotFoundException{
		driver = dbconfig.getParam("dbdrier");
		dburl = dbconfig.getParam("dburl");
		dbusername = dbconfig.getParam("dbusername");
		dbpassword = dbconfig.getParam("dbpassword");
		//
		Class.forName(driver);
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		conn = DriverManager.getConnection(dburl, dbusername, dbpassword);
		return conn;
	}

	@Override
	public void releaseConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			//TODO
		}
	}

}
