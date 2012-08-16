package com.telapi.api;

import org.junit.Test;

import com.telapi.api.domain.Conference;
import com.telapi.api.domain.ConferenceMember;
import com.telapi.api.restproxies.ConferenceProxy;

public class ConferenceTest extends BaseTelapiTest<ConferenceProxy>{
	
	public ConferenceTest() {
		super(ConferenceProxy.class);
	}

	@Test
	public void testViewConference() {
	}

	@Test
	public void testListConferences() {
		proxy.listConferences(conf.getSid(), null, null, null, null, null).getEntity();
	}

	@Test
	public void testMuteMember() {
		Conference c = proxy.listConferences(conf.getSid(), null, null, null, null, null).getEntity().iterator().next();
		ConferenceMember member = c.getMembers().iterator().next();
		proxy.muteMember(conf.getSid(), c.getName(), member.getId()).getEntity();
	}

	@Test
	public void testUnMuteMember() {
		Conference c = proxy.listConferences(conf.getSid(), null, null, null, null, null).getEntity().iterator().next();
		ConferenceMember member = c.getMembers().iterator().next();
		proxy.unMuteMember(conf.getSid(), c.getName(), member.getId()).getEntity();
	}

	@Test
	public void testDeafMember() {
		Conference c = proxy.listConferences(conf.getSid(), null, null, null, null, null).getEntity().iterator().next();
		ConferenceMember member = c.getMembers().iterator().next();
		proxy.deafMember(conf.getSid(), c.getName(), member.getId()).getEntity();
	}

	@Test
	public void testUnDeafMember() {
		Conference c = proxy.listConferences(conf.getSid(), null, null, null, null, null).getEntity().iterator().next();
		ConferenceMember member = c.getMembers().iterator().next();
		proxy.unDeafMember(conf.getSid(), c.getName(), member.getId()).getEntity();
	}

	@Test
	public void testHangupMember() {
		Conference c = proxy.listConferences(conf.getSid(), null, null, null, null, null).getEntity().iterator().next();
		ConferenceMember member = c.getMembers().iterator().next();
		proxy.hangupMember(conf.getSid(), c.getName(), member.getId()).getEntity();
	}

	@Test
	public void testSpeakText() {
		Conference c = proxy.listConferences(conf.getSid(), null, null, null, null, null).getEntity().iterator().next();
		ConferenceMember member = c.getMembers().iterator().next();
		proxy.speakText(conf.getSid(), c.getName(), member.getId(), "Hello member.").getEntity();
	}

	@Test
	public void testPlayAudio() {
		Conference c = proxy.listConferences(conf.getSid(), null, null, null, null, null).getEntity().iterator().next();
		ConferenceMember member = c.getMembers().iterator().next();
		proxy.playAudio(conf.getSid(), c.getName(), member.getId(), testParameters.getMp3Url()).getEntity();
	}

	@Test
	public void testStartRecording() {
		Conference c = proxy.listConferences(conf.getSid(), null, null, null, null, null).getEntity().iterator().next();
		proxy.startRecording(conf.getSid(), c.getName()).getEntity();
	}

	@Test
	public void testStopRecording() {
		Conference c = proxy.listConferences(conf.getSid(), null, null, null, null, null).getEntity().iterator().next();
		proxy.stopRecording(conf.getSid(), c.getName()).getEntity();
	}
	
	@Test
	public void testKickMember() {
		Conference c = proxy.listConferences(conf.getSid(), null, null, null, null, null).getEntity().iterator().next();
		ConferenceMember member = c.getMembers().iterator().next();
		proxy.kickMember(conf.getSid(), c.getName(), member.getId()).getEntity();
	}
	
}
