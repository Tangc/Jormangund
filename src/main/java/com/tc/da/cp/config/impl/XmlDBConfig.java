package com.tc.da.cp.config.impl;

import java.util.HashMap;
import java.util.Map;

import com.tc.da.cp.config.DBConfig;

public class XmlDBConfig extends DBConfig {

	private Map<String, String> params;
	
	private String xmlfilepath;
	
	public XmlDBConfig() {
		super();
		this.xmlfilepath = ""; //defaultpath
		params = new HashMap<String, String>();
		loadXml();
	}
	
	public XmlDBConfig(String xmlfilepath) {
		super();
		this.xmlfilepath = xmlfilepath;
		params = new HashMap<String, String>();
		loadXml();
	}
	
	public void loadXml(){
		//TODO
		System.out.println(xmlfilepath);
	}
	
	@Override
	public String getParam(String key) {
		//
		return null;
	}

	@Override
	public Map<String, String> getParams() {
		
		return null;
	}

}
