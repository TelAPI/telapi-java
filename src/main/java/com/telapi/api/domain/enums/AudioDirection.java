package com.telapi.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.telapi.api.domain.enums.util.EnumUtil;

public enum AudioDirection {
	IN, OUT;
	
	private static Map<AudioDirection, String> map;
	
	static {
		map = new HashMap<AudioDirection, String>();
		map.put(IN, "in");
		map.put(OUT, "out");
	}
	
	@JsonCreator
	public static AudioDirection forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
}