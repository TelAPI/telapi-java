package com.telapi.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.telapi.api.domain.enums.util.EnumUtil;

public enum CallInterruptStatus {
	CANCELED, COMPLETED;
	
	private static Map<CallInterruptStatus, String> map;
	
	static {
		map = new HashMap<CallInterruptStatus, String>();
		map.put(CANCELED, "canceled");
		map.put(COMPLETED, "completed");
	}
	
	@JsonCreator
	public static CallInterruptStatus forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
}
