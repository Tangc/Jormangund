package com.tc.da.cp.config.impl;

import java.util.HashMap;
import java.util.Map;

import com.tc.da.cp.config.DBConfig;

/**
 * 从properties配置文件中获取数据库的配置
 * @author tangchao
 *
 */
public class PropertiesDBConfig extends DBConfig {

	private Map<String, String> params;
	
	/**
	 * 默认路径是在
	 */
	private String propertyfilepath;
	
	public PropertiesDBConfig() {
		propertyfilepath = ""; //defaultpath
		params = new HashMap<String, String>();
		loadProperties();
	}
	
	public PropertiesDBConfig(String propertyfilepath) {
		super();
		this.propertyfilepath = propertyfilepath;
		params = new HashMap<String, String>();
		loadProperties();
	}
	
	public void loadProperties(){
		//TODO
		System.out.println(propertyfilepath);
	}

	@Override
	public String getParam(String key) {
		//params.get(key)
		return null;
	}

	@Override
	public Map<String, String> getParams() {
		//return params
		return null;
	}

}
