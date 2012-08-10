package com.telapi.api.inboundxml.elements.enums;

import java.util.HashMap;
import java.util.Map;

import com.telapi.api.domain.enums.util.EnumUtil;

public enum RejectReason {
	BUSY, REJECTED;
	
	private static Map<RejectReason, String> map;
	
	static {
		map = new HashMap<RejectReason, String>();
		map.put(BUSY, "busy");
		map.put(REJECTED, "rejected");
	}
	
	public static RejectReason forValue(String s) {
		return EnumUtil.getValue(s, map, null);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
}
