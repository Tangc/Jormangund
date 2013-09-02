package com.tc.da.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tc.da.DataAccess;
import com.tc.da.cp.ConnectionPool;
import com.tc.da.cp.config.DBConfig;
import com.tc.da.cp.config.impl.XmlDBConfig;
import com.tc.da.cp.impl.DruidConnectionPool;

public class TestDefaultDataAccess extends TestCase {

	private DBConfig dbconfig;
	private ConnectionPool cp;
	private DataAccess da;
	
	@Before
	public void setUp(){
		dbconfig = new XmlDBConfig();
		cp = new DruidConnectionPool(dbconfig);
		da = new DefaultDataAccess(cp);
	}
	
	@After
	public void tearDown(){
		
	}
	
	@Test
	public void testGeneralQuery(){
		try {
			List<Map<String, String>> listmap = da.generalQuery("SELECT 1 as one");
			
			assertEquals(1, listmap.size());
			assertEquals("1", listmap.get(0).get("one"));
		} catch (SQLException e) {
			//TODO
		}
	}
}
