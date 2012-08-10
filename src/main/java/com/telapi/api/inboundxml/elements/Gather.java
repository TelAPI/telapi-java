package com.telapi.api.inboundxml.elements;

import java.util.ArrayList;
import java.util.List;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.inboundxml.elements.enums.Voice;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Gather")
@SuppressWarnings("unused")
public class Gather implements ResponseElement {
	
	@XStreamImplicit
	private List<GatherElement> elements;
	
	@XStreamAsAttribute
	private String action;
	@XStreamAsAttribute
	private String method;
	@XStreamAsAttribute
	private Long timeout;
	@XStreamAsAttribute
	private String finishOnKey;
	@XStreamAsAttribute
	private Long numDigits;
	
	protected Gather() {
		elements = new ArrayList<GatherElement>();
	}
	
	public static Gather createGather(String action, HttpMethod method, Long timeout, String finishOnKey, Long numDigits) {
		Gather g = new Gather();
		g.action = action;
		g.method = method == null ? null : method.toString();
		g.timeout = timeout;
		g.finishOnKey = finishOnKey;
		g.numDigits = numDigits;
		return g;
	}
	
	public static Gather createGather(String action) {
		Gather g = new Gather();
		g.action = action;
		return g;
	}
	
	public Gather play(Long loop, String resource) {
		elements.add(Play.createPlay(loop, resource));
		return this;
	}
	
	public Gather say(String text, Voice voice, Long loop) {
		elements.add(Say.createSay(text, voice, loop));
		return this;
	}
	
	public Gather pause(Long length) {
		elements.add(Pause.createPause(length));
		return this;
	}
	
	public Gather pause() {
		elements.add(Pause.createPause(null));
		return this;
	}
	
}
