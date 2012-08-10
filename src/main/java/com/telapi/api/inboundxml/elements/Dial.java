package com.telapi.api.inboundxml.elements;

import java.util.ArrayList;
import java.util.List;

import com.telapi.api.domain.enums.HttpMethod;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias("Dial")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"number"})
@SuppressWarnings("unused")
public class Dial implements ResponseElement {
	
	@XStreamImplicit
	private List<DialElement> elements;
	
	private String number;
	
	@XStreamAsAttribute
	private String action;
	@XStreamAsAttribute
	private String method;
	@XStreamAsAttribute
	private Long timeout;
	@XStreamAsAttribute
	private Boolean hangupOnStar;
	@XStreamAsAttribute
	private Long timeLimit;
	@XStreamAsAttribute
	private String callerId;
	@XStreamAsAttribute
	private Boolean hideCallerId;
	@XStreamAsAttribute
	private String callerName;
	@XStreamAsAttribute
	private String dialMusic;
	@XStreamAsAttribute
	private String callbackUrl;
	@XStreamAsAttribute
	private String callbackMethod;
	@XStreamAsAttribute
	private Boolean confirmSound;
	@XStreamAsAttribute
	private String digitsMatch;
	@XStreamAsAttribute
	private Boolean straightToVm;
	@XStreamAsAttribute
	private String heartbeatUrl;
	@XStreamAsAttribute
	private String heartbeatMethod;
	@XStreamAsAttribute
	private String forwardedFrom;
	
	protected Dial() {
		elements = new ArrayList<DialElement>();
	}
	
	public static Dial createDial(String number, String action, HttpMethod method, Long timeout, Boolean hangupOnStar, Long timeLimit, String callerId, Boolean hideCallerId, String callerName, String dialMusic, String callbackUrl, HttpMethod callbackMethod, Boolean confirmSound, String digitsMatch, Boolean straightToVm, String heartbeatUrl, HttpMethod heartbeatMethod, String forwardedFrom) {
		Dial d = new Dial();
		d.number = number;
		d.action = action;
		d.method = method == null ? null : method.toString();
		d.timeout = timeout;
		d.hangupOnStar = hangupOnStar;
		d.timeLimit = timeLimit;
		d.callerId = callerId;
		d.hideCallerId = hideCallerId;
		d.callerName = callerName;
		d.dialMusic = dialMusic;
		d.callbackUrl = callbackUrl;
		d.callbackMethod = callbackMethod == null ? null : callbackMethod.toString();
		d.confirmSound = confirmSound;
		d.digitsMatch = digitsMatch;
		d.straightToVm = straightToVm;
		d.heartbeatUrl = heartbeatUrl;
		d.heartbeatMethod = heartbeatMethod == null ? null : heartbeatMethod.toString();
		d.forwardedFrom = forwardedFrom;
		return d;
	}
	
	public static Dial createDial(String number) {
		Dial d = new Dial();
		d.number = number;
		return d;
	}
	
	public static Dial createDial() {
		return new Dial();
	}
	
	public Dial number(String number, String sendDigits, String url, HttpMethod callbackMethod) {
		Number n = Number.createNumber(number, sendDigits, url, callbackMethod);
		elements.add(n);
		return this;
	}
	
	public Dial conference(String conferenceName, Boolean muted, Boolean beep, Boolean startConferenceOnEnter, Boolean endConferenceOnExit, Long maxParticipants, String waitUrl, HttpMethod waitMethod, Boolean hangupOnStar, String callbackUrl, HttpMethod callbackMethod, String waitSound, HttpMethod waitSoundMethod, String digitsMatch, Boolean stayAlone) {
		Conference c = Conference.createConference(conferenceName, muted, beep, startConferenceOnEnter, endConferenceOnExit, maxParticipants, waitUrl, waitMethod, hangupOnStar, callbackUrl, callbackMethod, waitSound, waitSoundMethod, digitsMatch, stayAlone);
		elements.add(c);
		return this;
	}
	
	public Dial conference(String conferenceName) {
		Conference c = Conference.createConference(conferenceName);
		elements.add(c);
		return this;
	}
	
	public Dial sip(String sipAddress, String sendDigits, String url, HttpMethod method) {
		Sip s = Sip.createSip(sipAddress, sendDigits, url, method);
		elements.add(s);
		return this;
	}
	
	public Dial sip(String sipAddress) {
		Sip s = Sip.createSip(sipAddress, null, null, null);
		elements.add(s);
		return this;
	}
	
}
