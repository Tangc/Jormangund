package com.tc.da;

import java.util.List;

import com.tc.da.cp.ConnectionPool;

public class ORMDataAccess<T> {

	private ConnectionPool cp;
	
	public ORMDataAccess(ConnectionPool cp) {
		super();
		this.cp = cp;
	}
	
	
	public T get(int id){
		
		return null;
	}
	
	public List<T> getAll(){
		
		return null;
	}
	
	public List<T>getLimit(int start, int offset){
		
		return null;
	}
	
	public int update(T t){
		
		return 0;
	}
	
	public int delete(int id){
		
		return 0;
	}
	
	//
	private String buildSelect(){
		//SELECT c1,c2 FROM t [WHERE id=?][LIMIT ?,?]
		return "";
	}
	
	private String buildUpdate(){
		//UPDATE t SET c1=v1[,c2=v2...] WHERE id=?
		return "";
	}
	
	private String buildDelete(){
		//DELETE FROM t WHERE id=?
		return ""; 
	}
}
