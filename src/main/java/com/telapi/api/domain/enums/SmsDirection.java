package com.telapi.api.domain.enums;

import org.codehaus.jackson.annotate.JsonCreator;

public enum SmsDirection {
	OUTBOUND_API;

	@JsonCreator
	public static SmsDirection forValue(String s) {
		if (s == null) return null;
		if (s.equals("outbound-api")) return OUTBOUND_API;
		return null;
	}
	
}
