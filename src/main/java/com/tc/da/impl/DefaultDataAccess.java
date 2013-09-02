package com.tc.da.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tc.da.DataAccess;
import com.tc.da.cp.ConnectionPool;
import com.tc.da.rshandler.IResultSetHandler;
import com.tc.da.rshandler.ListMapResultSetHandler;

public class DefaultDataAccess extends DataAccess {

	public DefaultDataAccess(ConnectionPool cp) {
		super(cp);
	}

	@Override
	public List<Map<String, String>> generalQuery(String sql) throws SQLException {
		IResultSetHandler<List<Map<String, String>>> handler = new ListMapResultSetHandler();
		return generalQuery(sql, handler);
	}
	
	public List<Map<String, String>> generalQuery(String sql, IResultSetHandler<List<Map<String, String>>> handler){
		List<Map<String, String>> listmap = new ArrayList<Map<String,String>>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = cp.getConnection();
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			listmap = handler.handle(rs);
			rs.close();
		}catch(SQLException e){
			//TODO
		}finally{
			closePstmt(pstmt);
			cp.releaseConnection(conn);
		}
		return listmap;
	}
	

	private void closePstmt(PreparedStatement pstmt){
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				//TODO
			}
		}
	}
	
}
