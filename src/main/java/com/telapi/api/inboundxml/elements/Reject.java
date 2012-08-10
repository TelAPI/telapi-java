package com.telapi.api.inboundxml.elements;

import com.telapi.api.inboundxml.elements.enums.RejectReason;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("Reject")
@SuppressWarnings("unused")
public class Reject implements ResponseElement {
	
	@XStreamAsAttribute
	private String reason;
	
	protected Reject() {
		
	}
	
	static Reject createReject(RejectReason reason) {
		Reject r = new Reject();
		r.reason = reason == null ? null : reason.toString();
		return r;
	}

}
