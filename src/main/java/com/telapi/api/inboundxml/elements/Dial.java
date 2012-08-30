package com.telapi.api.inboundxml.elements;

import java.util.ArrayList;
import java.util.List;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.inboundxml.parameters.DialParameters;
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
	
	/**
	 * Creates a new Dial element. The Dial element starts an outgoing dial from
	 * the current call. Once the dial is complete, the next element in the
	 * InboundXML document will be processed unless the action attribute is set.
	 * In that case the result of the dial is submitted as a GET or POST
	 * (depending on the method attribute) to the action URL, and the call
	 * continues using the InboundXML of that URL.
	 * 
	 * By default the outgoing call will timeout if it is not answered after 30
	 * seconds; however, the timeout attribute can be used to set a custom time.
	 * The length of the call is limited by the timeLimit attribute, which is 4
	 * hours (14400 seconds) by default.
	 * 
	 * Setting the hangupOnStar attribute to 'true' will allow the original call
	 * to terminate the outgoing call without having to hang up by dialing '*'.
	 * The original call then continues with the current InboundXML document, or
	 * if a URL was passed, the response from the action attribute.
	 * 
	 * The callerId attribute can be set to any number, and will default to the
	 * caller id of the original caller. The number to be dialed should be
	 * nested within the Dial element. For more options, use the Number or
	 * Conference elements instead of a simple phone number.
	 * 
	 * @param number The number which is to be dialed. If used, no other element can be appended to the Dial element.
	 * @param action URL where some parameters specific to Dial will be sent for further processing. The calling party can be redirected here upon the hang up of the B leg caller.
	 * @param method Method used to request the action URL. Defaults to POST.
	 * @param timeout The number of seconds calls made with <Dial> are allowed silence before ending. Defaults to 30.
	 * @param hangupOnStar Boolean value specifying if pressing * should end the dial. Defaults to false.
	 * @param timeLimit The duration in seconds a call made through <Dial> should occur for before ending. Defaults to 14400.
	 * @param callerId  Number to display as calling. Defaults to the ID of phone being used. Defaults to the caller's caller ID.
	 * @param hideCallerId Boolean value specifying if the caller ID should be hidden or not. Defaults to false.
	 * @param dialMusic URL containing an audio file that can be played during the dial.
	 * @param callbackUrl URL requested once the dialed call connects.
	 * @param callbackMethod Method used to request the callback URL. Defaults to POST.
	 * @param confirmSound Boolean value specifying if a sound should play when dial is successful. Defaults to false.
	 * @param digitsMatch Specifies digits that TelAPI should listen for and send to the callbackUrl if a caller inputs them. Separate additional digits or digit patterns with a comma. Allowed values are digits, # and *.
	 * @param straightToVm Boolean value specifying if call should be redirected to voice mail immediately. Defaults to false.
	 * @param heartbeatUrl A URL TelAPI can request every 60 seconds during the call to notify of elapsed time and pass other general information.
	 * @param heartbeatMethod Method used to request the heartbeat URL. Defaults to POST.
	 * @param forwardedFrom Specifies the number to list the call as forwarded from.
	 * @return A new Dial element.
	 */
	public static Dial createDial(String number, String action, HttpMethod method, Long timeout, Boolean hangupOnStar, Long timeLimit, String callerId, Boolean hideCallerId, String dialMusic, String callbackUrl, HttpMethod callbackMethod, Boolean confirmSound, String digitsMatch, Boolean straightToVm, String heartbeatUrl, HttpMethod heartbeatMethod, String forwardedFrom) {
		Dial d = new Dial();
		d.number = number;
		d.action = action;
		d.method = method == null ? null : method.toString();
		d.timeout = timeout;
		d.hangupOnStar = hangupOnStar;
		d.timeLimit = timeLimit;
		d.callerId = callerId;
		d.hideCallerId = hideCallerId;
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
	
	/**
	 * Convenience method for creating a Dial element.
	 * @see #createDial(String, String, HttpMethod, Long, Boolean, Long, String, Boolean, String, String, String, HttpMethod, Boolean, String, Boolean, String, HttpMethod, String)
	 * @param number  
	 * @return A new Dial element.
	 */
	public static Dial createDial(DialParameters params) {
		Dial d = createDial(params.getNumber(), params.getAction(),
				params.getMethod(), params.getTimeout(),
				params.getHangupOnStar(), params.getTimeLimit(),
				params.getCallerId(), params.getHideCallerId(),
				params.getDialMusic(), params.getCallbackUrl(),
				params.getCallbackMethod(), params.getConfirmSound(),
				params.getDigitsMatch(), params.getStraightToVm(),
				params.getHeartbeatUrl(), params.getHeartbeatMethod(),
				params.getForwardedFrom());
		return d;
	}
	
	/**
	 * Convenience method for creating a Dial element.
	 * @see #createDial(String, String, HttpMethod, Long, Boolean, Long, String, Boolean, String, String, String, HttpMethod, Boolean, String, Boolean, String, HttpMethod, String)
	 * @param number  
	 * @return A new Dial element.
	 */
	public static Dial createDial(String number) {
		Dial d = new Dial();
		d.number = number;
		return d;
	}
	
	/**
	 * Convenience method for creating a Dial element.
	 * @see #createDial(String, String, HttpMethod, Long, Boolean, Long, String, Boolean, String, String, String, HttpMethod, Boolean, String, Boolean, String, HttpMethod, String)
	 * @return A new Dial element.
	 */
	public static Dial createDial() {
		return new Dial();
	}
	
	/**
	 * Creates a Number element. The Number element must be nested within the
	 * Dial element. It can be used to send DTFM tones or redirect to
	 * InboundXML when called parties when they are answered. Number can also
	 * be used to dial multiple phones simultaneously by using additional
	 * Number elements. If multiple Number elements are used to specify
	 * additional calls, the first call to answer is connected, and the rest of
	 * the outgoing calls are canceled.
	 * 
	 * @param number The number to be called (required).
	 * @param sendDigits Specifies which DTFM tones to play to the called party. w indicates a half second pause.
	 * @param url URL that the called party can be directed to before the call beings.
	 * @param callbackMethod Method used to request the url. Defaults to POST.
	 * @return The Dial element to which the current Number element will be
	 *         added.
	 */
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
