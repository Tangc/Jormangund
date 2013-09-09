package com.tc.da;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tc.da.cp.ConnectionPool;
import com.tc.da.cp.config.DBConfig;
import com.tc.da.cp.config.impl.PropertiesDBConfig;
import com.tc.da.cp.impl.DruidConnectionPool;

public class TestGeneralDataAccess extends TestCase {

	private DBConfig dbconfig;
	private ConnectionPool cp;
	private GeneralDataAccess da;
	
	@Before
	public void setUp(){
		try {
			dbconfig = new PropertiesDBConfig();
			cp = new DruidConnectionPool(dbconfig);
			da = new GeneralDataAccess(cp);
		} catch (IOException e) {
		}
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
