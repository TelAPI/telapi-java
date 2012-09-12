package com.telapi.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.telapi.api.domain.enums.util.EnumUtil;

public enum PhoneNumberType {
	LOCAL, INTERNATIONAL, TOLL_FREE, UNKNOWN;
	
	private static Map<PhoneNumberType, String> map;
	
	static {
		map = new HashMap<PhoneNumberType, String>();
		map.put(LOCAL, "local");
		map.put(INTERNATIONAL, "international");
		map.put(TOLL_FREE, "toll-free");
	}
	
	@JsonCreator
	public static PhoneNumberType forValue(String s) {
		return EnumUtil.getValue(s, map, UNKNOWN);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
}