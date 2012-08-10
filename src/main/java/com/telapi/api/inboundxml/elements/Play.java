package com.telapi.api.inboundxml.elements;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("Play")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"resource"})
@SuppressWarnings("unused")
public class Play implements ResponseElement, GatherElement{
	
	private String resource;
	@XStreamAsAttribute
	private Long loop;
	
	protected Play() {
		
	}
	
	static Play createPlay(Long loop, String resource) {
		Play p = new Play();
		p.loop = loop;
		p.resource = resource;
		return p;
	}

}
