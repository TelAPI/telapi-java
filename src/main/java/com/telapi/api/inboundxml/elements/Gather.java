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

	/**
	 * Creates a Gather element. The Gather element allows callers to input
	 * digits to the call using their keypads which are then sent via POST or
	 * GET to a URL for further processing. There are many ways to get creative
	 * with Gather but its most common use case is in creating IVR menus. This
	 * is accomplished by nesting prompts for input from the caller using the
	 * Say or Play elements.
	 * 
	 * By default an unlimited number of digits can be gathered, the Gather will
	 * timeout after 5 seconds pass without any new digits or once the '#' key
	 * is pressed, and the gathered digits will be submitted to the current
	 * InboundXML document. This default behavior of Gather can be altered using
	 * its provided element attributes.
	 * 
	 * @param action URL where the gathered digits will be sent for further processing (required).
	 * @param method Method used to request the action URL. Defaults to POST.
	 * @param timeout The number of seconds Gather should wait for digits to be entered before requesting the action URL. Timeout resets with each new digit input. Defaults to 5.
	 * @param finishOnKey The key a caller can press to end the Gather. Allowed values are digits, # and *. Defaults to #.
	 * @param numDigits The maximum number of digits to Gather. A number greater than or equal to 0. Defaults to no limit.
	 * @return The Gather element which is being created.
	 */
	public static Gather createGather(String action, HttpMethod method,
			Long timeout, String finishOnKey, Long numDigits) {
		Gather g = new Gather();
		g.action = action;
		g.method = method == null ? null : method.toString();
		g.timeout = timeout;
		g.finishOnKey = finishOnKey;
		g.numDigits = numDigits;
		return g;
	}

	/**
	 * Convenience method for creating a new Gather element.
	 * @param action URL where the gathered digits will be sent for further processing (required).
	 * @return The Gather element which is being created.
	 */
	public static Gather createGather(String action) {
		Gather g = new Gather();
		g.action = action;
		return g;
	}

	/**
	 * @see Response#play(Long, String)
	 * @param loop
	 * @param resource
	 * @return
	 */
	public Gather play(Long loop, String resource) {
		elements.add(Play.createPlay(loop, resource));
		return this;
	}

	/**
	 * @see Response#say(String, Voice, Long)
	 * @param text
	 * @param voice
	 * @param loop
	 * @return
	 */
	public Gather say(String text, Voice voice, Long loop) {
		elements.add(Say.createSay(text, voice, loop));
		return this;
	}
	
	/**
	 * @see Response#say(String)
	 * @param text
	 * @return
	 */
	public Gather say(String text) {
		elements.add(Say.createSay(text, null, null));
		return this;
	}

	/**
	 * @see Response#pause(Long)
	 * @param length
	 * @return
	 */
	public Gather pause(Long length) {
		elements.add(Pause.createPause(length));
		return this;
	}

	/**
	 * @see Response#pause()
	 * @return
	 */
	public Gather pause() {
		elements.add(Pause.createPause(null));
		return this;
	}

}
