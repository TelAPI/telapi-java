package com.telapi.api.inboundxml.elements;

import com.telapi.api.domain.enums.HttpMethod;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("Number")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"number"})
@SuppressWarnings("unused")
public class Number implements DialElement{
	
	private String number;
	
	@XStreamAsAttribute
	private String sendDigits;
	@XStreamAsAttribute
	private String url;
	@XStreamAsAttribute
	private String method;
	
	protected Number() {
		
	}
	
	static Number createNumber(String number, String sendDigits, String url, HttpMethod method) {
		Number n = new Number();
		n.number = number;
		n.sendDigits = sendDigits;
		n.url = url;
		n.method = method == null ? null : method.toString();
		return n;
	}
	
}
