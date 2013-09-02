package com.tc.da.rshandler;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListMapResultSetHandler implements IResultSetHandler<List<Map<String, String>>> {

	/**
	 * 把ResultSet结果集转化成List<Map<String, String>>的通用形式
	 */
	public List<Map<String, String>> handle(ResultSet rs) {
		List<Map<String, String>> listmap = new ArrayList<Map<String,String>>();
		if(rs!=null){
			try{
				ResultSetMetaData metadata = rs.getMetaData();
				int colcount = metadata.getColumnCount();
				while(rs.next()){
					Map<String, String> rowmap = new HashMap<String, String>();
					for(int col=1; col<=colcount; col++){
						rowmap.put(metadata.getColumnLabel(col), rs.getString(col));
					}
					listmap.add(rowmap);
				}
			}catch(SQLException e){
				//TODO
			}
		}
		return listmap;
	}


}
