package com.telapi.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.telapi.api.domain.enums.util.EnumUtil;

public enum LogLevel {
	ERROR, WARNING, INFO;
	
	private static Map<LogLevel, String> map;
	
	static {
		map = new HashMap<LogLevel, String>();
		map.put(ERROR, "0");
		map.put(WARNING, "1");
		map.put(INFO, "2");
	}
	
	@JsonCreator
	public static LogLevel forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
}