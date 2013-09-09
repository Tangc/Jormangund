package com.tc.da.cp.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tc.da.cp.config.DBConfig;
import com.tc.da.cp.config.impl.PropertiesDBConfig;

public class TestSingleConnectionPool extends TestCase {

	private DBConfig dbconfig;
	private SingleConnectionPool cp;
	
	@Before
	public void setUp(){
		try {
			dbconfig = new PropertiesDBConfig("");
			cp = new SingleConnectionPool(dbconfig);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_0(){
		try {
			Connection conn = cp.getConnection();
			
			assertEquals(true, conn != null);
			assertEquals(dbconfig.getParam("dbdriver"), conn.getMetaData().getDriverName());
			assertEquals(dbconfig.getParam("dburl"), conn.getMetaData().getURL());
			assertEquals(dbconfig.getParam("dbusername"), conn.getMetaData().getUserName());
			
			cp.releaseConnection(conn);
			
			assertEquals(true, conn.isClosed());
			assertEquals(true, conn == null);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown(){
		
	}
}
