package com.tc.da;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.tc.da.cp.ConnectionPool;

public abstract class DataAccess {

	protected ConnectionPool cp;

	public DataAccess(ConnectionPool cp) {
		super();
		this.cp = cp;
	}

	public abstract List<Map<String, String>> generalQuery(String sql) throws SQLException;
	
}
