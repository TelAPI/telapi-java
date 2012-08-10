package com.telapi.api.inboundxml.elements;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("Hangup")
@SuppressWarnings("unused")
public class Hangup implements ResponseElement {
	
	@XStreamAsAttribute
	private Long schedule;
	
	protected Hangup() {
		
	}
	
	static Hangup createHangup(Long schedule) {
		Hangup h = new Hangup();
		h.schedule = schedule;
		return h;
	}

}
