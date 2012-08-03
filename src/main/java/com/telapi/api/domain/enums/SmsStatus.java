package com.telapi.api.domain.enums;

import org.codehaus.jackson.annotate.JsonCreator;


public enum SmsStatus {
	SENT, SENDING;
	
	@JsonCreator
	public static SmsStatus forValue(String s) {
		if (s == null) return null;
		if (s.equals("sent")) return SENT;
		if (s.equals("sending")) return SENDING;
		return null;
	}
}
