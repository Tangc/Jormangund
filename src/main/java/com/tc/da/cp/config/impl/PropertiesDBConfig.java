package com.tc.da.cp.config.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

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
	
	public PropertiesDBConfig() throws IOException {
		propertyfilepath = ""; //defaultpath
		params = new HashMap<String, String>(16);
		loadProperties();
	}
	
	public PropertiesDBConfig(String propertyfilepath) throws IOException {
		super();
		this.propertyfilepath = propertyfilepath;
		params = new HashMap<String, String>(16);
		loadProperties();
	}
	
	public void loadProperties() throws IOException{
//		TODO log
//		System.out.println(propertyfilepath);
		InputStream in = new FileInputStream(new File(propertyfilepath));
		Properties config = new Properties();
		config.load(in);
		for(Entry<Object, Object> entry: config.entrySet()){
			String k = entry.getKey().toString();
			String v = entry.getValue().toString();
			params.put(k, v);
		}
	}

	@Override
	public String getParam(String key) {
		return params.get(key);
	}

	@Override
	public Map<String, String> getParams() {
		return params;
	}

}
