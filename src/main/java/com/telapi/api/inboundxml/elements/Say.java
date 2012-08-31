package com.telapi.api.inboundxml.elements;

import com.telapi.api.inboundxml.elements.enums.Voice;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("Say")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"text"})
@SuppressWarnings("unused")
public class Say implements ResponseElement, GatherElement {

	@XStreamAsAttribute
	private Long loop;

	@XStreamAsAttribute
	private String voice;
	
	private String text;
	
	protected Say() {
		
	}
	
	static Say createSay(String text, Voice voice, Long loop) {
		Say p = new Say();
		p.loop = loop;
		p.text = text;
		p.voice = voice == null ? null : voice.toString();
		return p;
	}

}
