package com.telapi.api.inboundxml.elements;

import com.telapi.api.domain.enums.HttpMethod;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("Sip")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"sipAddress"})
@SuppressWarnings("unused")
public class Sip implements DialElement{
	
	private String sipAddress;
	
	@XStreamAsAttribute
	private String sendDigits;
	@XStreamAsAttribute
	private String url; 
	@XStreamAsAttribute
	private String method;
	
	protected Sip() {
		
	}
	
	static Sip createSip(String sipAddress, String sendDigits, String url, HttpMethod method) {
		Sip s = new Sip();
		s.sipAddress = sipAddress;
		s.sendDigits = sendDigits;
		s.url = url;
		s.method = method == null ? null : method.toString();
		return s;
	}

}
