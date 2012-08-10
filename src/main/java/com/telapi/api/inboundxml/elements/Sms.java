package com.telapi.api.inboundxml.elements;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.inboundxml.elements.enums.Voice;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("Sms")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"text"})
@SuppressWarnings("unused")
public class Sms implements ResponseElement {

	private String text;
	
	@XStreamAsAttribute
	private String to;
	@XStreamAsAttribute
	private String from;
	@XStreamAsAttribute
	private String action;
	@XStreamAsAttribute
	private String method;
	@XStreamAsAttribute
	private String statusCallback;
	
	protected Sms() {
		
	}
	
	static Sms createSms(String text, String to, String from, String action, HttpMethod method, String statusCallback) {
		Sms s = new Sms();
		s.text = text;
		s.to = to;
		s.from = from;
		s.action = action;
		s.method = method == null ? null : method.toString();
		s.statusCallback = statusCallback;
		return s;
	}

}
