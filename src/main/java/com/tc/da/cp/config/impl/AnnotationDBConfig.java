package com.tc.da.cp.config.impl;

import java.util.HashMap;
import java.util.Map;

import com.tc.da.cp.config.DBConfig;

public class AnnotationDBConfig extends DBConfig {

	private Map<String, String> params;
	
	private Class<?> annotationClass;
	
	public AnnotationDBConfig() {
		super();
		params = new HashMap<String, String>();
		annotationClass = this.getClass(); //注解默认在本类，可扩展到其他类
		//
		loadAnnotations();
	}
	
	public void loadAnnotations(){
		//TODO
		System.out.println(annotationClass.getSimpleName());
	}

	@Override
	public String getParam(String key) {
		//TODO
		return null;
	}

	@Override
	public Map<String, String> getParams() {
		//TODO
		return null;
	}

}
