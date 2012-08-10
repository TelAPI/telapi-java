package com.telapi.api.inboundxml.elements;

import com.telapi.api.domain.enums.HttpMethod;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("Conference")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"conferenceName"})
@SuppressWarnings("unused")
public class Conference implements DialElement{
	
	private String conferenceName;
	
	@XStreamAsAttribute
	private Boolean muted;
	@XStreamAsAttribute
	private Boolean beep;
	@XStreamAsAttribute
	private Boolean startConferenceOnEnter;
	@XStreamAsAttribute
	private Boolean endConferenceOnExit;
	@XStreamAsAttribute
	private Long maxParticipants;
	@XStreamAsAttribute
	private String waitUrl;
	@XStreamAsAttribute
	private String waitMethod;
	@XStreamAsAttribute
	private Boolean hangupOnStar;
	@XStreamAsAttribute
	private String callbackUrl;
	@XStreamAsAttribute
	private String callbackMethod;
	@XStreamAsAttribute
	private String waitSound;
	@XStreamAsAttribute
	private String waitSoundMethod;
	@XStreamAsAttribute
	private String digitsMatch;
	@XStreamAsAttribute
	private Boolean stayAlone;

	protected Conference() {
		
	}
	
	static Conference createConference(String conferenceName, Boolean muted, Boolean beep, Boolean startConferenceOnEnter, Boolean endConferenceOnExit, Long maxParticipants, String waitUrl, HttpMethod waitMethod, Boolean hangupOnStar, String callbackUrl, HttpMethod callbackMethod, String waitSound, HttpMethod waitSoundMethod, String digitsMatch, Boolean stayAlone) {
		Conference c = new Conference();
		c.conferenceName = conferenceName;
		c.muted = muted;
		c.beep = beep;
		c.startConferenceOnEnter = startConferenceOnEnter;
		c.endConferenceOnExit = endConferenceOnExit;
		c.maxParticipants = maxParticipants;
		c.waitUrl = waitUrl;
		c.waitMethod = waitMethod == null ? null : waitMethod.toString();
		c.hangupOnStar = hangupOnStar;
		c.callbackUrl = callbackUrl;
		c.callbackMethod = callbackMethod == null ? null : callbackMethod.toString();
		c.waitSound = waitSound;
		c.waitSoundMethod = waitSoundMethod == null ? null : waitSoundMethod.toString();
		c.digitsMatch = digitsMatch;
		c.stayAlone = stayAlone;
		
		return c;
	}
	
	static Conference createConference(String conferenceName) {
		Conference c = new Conference();
		c.conferenceName = conferenceName;
		return c;
	}

}
