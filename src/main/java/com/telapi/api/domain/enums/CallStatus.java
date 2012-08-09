package com.telapi.api.domain.enums;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;

import com.telapi.api.domain.enums.util.EnumUtil;

public enum CallStatus {
	QUEUED, RINGING, IN_PROGRESS, COMPLETED, FAILED, BUSY, NO_ANSWER, UNKNOWN;
	
	private static Map<CallStatus, String> map;
	
	static {
		map = new HashMap<CallStatus, String>();
		map.put(QUEUED, "queued");
		map.put(RINGING, "ringing");
		map.put(IN_PROGRESS, "in-progress");
		map.put(COMPLETED, "completed");
		map.put(FAILED, "failed");
		map.put(BUSY, "busy");
		map.put(NO_ANSWER, "no-answer");
	}
	
	@JsonCreator
	public static CallStatus forValue(String s) {
		return EnumUtil.getValue(s, map, UNKNOWN);
	}
	
	@Override
	public String toString() {
		return map.get(this);
	}
}