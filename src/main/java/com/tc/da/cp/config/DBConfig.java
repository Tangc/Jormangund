package com.tc.da.cp.config;

import java.util.Map;


public abstract class DBConfig {

	/**
	 * 得到数据库配置的参数
	 * @return
	 */
	public abstract String getParam(String key);
	
	/**
	 * 得到数据库配置的所有参数
	 * @return
	 */
	public abstract Map<String, String> getParams();
}
