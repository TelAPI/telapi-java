package com.telapi.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.telapi.api.domain.enums.util.EnumUtil;

public enum TranscriptionType {
	AUTO, SILVER, GOLD, PLATINUM;
	
	private static Map<TranscriptionType, String> map;
	
	static {
		map = new HashMap<TranscriptionType, String>();
		map.put(AUTO, "auto");
		map.put(SILVER, "silver");
		map.put(GOLD, "gold");
		map.put(PLATINUM, "platinum");
	}
	
	@JsonCreator
	public static TranscriptionType forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
	
}
