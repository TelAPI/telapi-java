package com.telapi.api.inboundxml.elements;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("Pause")
@SuppressWarnings("unused")
public class Pause implements ResponseElement, GatherElement {
	
	@XStreamAsAttribute
	private Long length;
	
	protected Pause() {
		
	}
	
	static Pause createPause(Long length) {
		Pause p = new Pause();
		p.length = length;
		return p;
	}

}
