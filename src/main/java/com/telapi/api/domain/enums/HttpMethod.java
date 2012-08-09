package com.telapi.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.telapi.api.domain.enums.util.EnumUtil;

public enum HttpMethod {
	GET, POST;
	
	private static Map<HttpMethod, String> map;
	
	static {
		map = new HashMap<HttpMethod, String>();
		map.put(GET, "GET");
		map.put(POST, "POST");
	}
	
	@JsonCreator
	public static HttpMethod forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
}
