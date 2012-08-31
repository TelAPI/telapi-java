package com.telapi.api.inboundxml.elements;

import java.util.ArrayList;
import java.util.List;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.inboundxml.elements.enums.Voice;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("GetSpeech")
@SuppressWarnings("unused")
public class GetSpeech implements ResponseElement {

	@XStreamImplicit
	private List<GatherElement> elements;

	@XStreamAsAttribute
	private String grammar;
	@XStreamAsAttribute
	private String action;
	@XStreamAsAttribute
	private String method;
	@XStreamAsAttribute
	private Long timeout;
	@XStreamAsAttribute
	private Boolean playBeep;

	protected GetSpeech() {
		elements = new ArrayList<GatherElement>();
	}

	/**
	 * Creates a new GetSpeech element. The GetSpeech element is used to
	 * translate a callers voice into text. That translated text is then
	 * submitted to an action URL for further processing and use in your
	 * application.
	 * 
	 * @param grammar
	 *            The URL of an XML file defining acceptable words and phrases
	 *            that a user might say during the call. For information on
	 *            creating grammar files see this 
	 *            <a href='http://www.w3.org/TR/speech-grammar/'>W3 reference</a>.
	 * @param action
	 *            A URL where the converted voice text will be forwarded.
	 * @param method
	 *            Method used to request the action URL. Defaults to POST.
	 * @param timeout
	 *            Amount of seconds GetSpeech should wait in silence before
	 *            requesting the action URL. Defaults to 5.
	 * @param playBeep
	 *            Specifies if a beep should play back to the caller when
	 *            GetSpeech begins. Defaults to false.
	 * @return A new GetSpeech element.
	 */
	public static GetSpeech createGetSpeech(String grammar, String action,
			HttpMethod method, Long timeout, Boolean playBeep) {
		GetSpeech g = new GetSpeech();
		g.grammar = grammar;
		g.action = action;
		g.method = method == null ? null : method.toString();
		g.timeout = timeout;
		g.playBeep = playBeep;
		return g;
	}

	/**
	 * Convenience method for creating a new GetSpeech element.
	 * @see #createGetSpeech(String, String, HttpMethod, Long, Boolean)
	 * @param grammar
	 *            The URL of an XML file defining acceptable words and phrases
	 *            that a user might say during the call. For information on
	 *            creating grammar files see this 
	 *            <a href='http://www.w3.org/TR/speech-grammar/'>W3 reference</a>.
	 * @param action A URL where the converted voice text will be forwarded.
	 * @return A new GetSpeech element.
	 */
	public static GetSpeech createGetSpeech(String grammar, String action) {
		GetSpeech g = new GetSpeech();
		g.grammar = grammar;
		g.action = action;
		return g;
	}

	/**
	 * @see Response#play(Long, String)
	 * @param loop
	 * @param resource
	 * @return
	 */
	public GetSpeech play(Long loop, String resource) {
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
	public GetSpeech say(String text, Voice voice, Long loop) {
		elements.add(Say.createSay(text, voice, loop));
		return this;
	}
	
	/**
	 * @see Response#say(String)
	 * @param text
	 * @return
	 */
	public GetSpeech say(String text) {
		elements.add(Say.createSay(text, null, null));
		return this;
	}

	/**
	 * @see Response#pause(Long)
	 * @param length
	 * @return
	 */
	public GetSpeech pause(Long length) {
		elements.add(Pause.createPause(length));
		return this;
	}

	/**
	 * @see Response#pause()
	 * @return
	 */
	public GetSpeech pause() {
		elements.add(Pause.createPause(null));
		return this;
	}

}
