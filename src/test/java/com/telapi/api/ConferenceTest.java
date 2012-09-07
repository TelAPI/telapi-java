package com.telapi.api;

import org.junit.Test;

import com.telapi.api.domain.Conference;
import com.telapi.api.domain.ConferenceMember;
import com.telapi.api.domain.list.ConferenceList;
import com.telapi.api.exceptions.TelapiException;

public class ConferenceTest extends BaseTelapiTest {
	

	@Test
	public void testViewConference() throws TelapiException {
		ConferenceList conferences = connector.listConferences(null, null, null, null, null);
		Conference c = conferences.iterator().next();
		connector.viewConference(c.getSid());
	}

	@Test
	public void testListConferences() throws TelapiException {
		connector.listConferences("1", false, false, 0L, 10L);
	}

	@Test
	public void testMuteMember() throws TelapiException {
		Conference c = connector.listConferences(null, null, null, null, null).iterator().next();
		ConferenceMember member = c.getMembers().iterator().next();
		connector.muteMember(c.getSid(), member.getId());
	}

	@Test
	public void testUnMuteMember() throws TelapiException {
		Conference c = connector.listConferences(null, null, null, null, null).iterator().next();
		ConferenceMember member = c.getMembers().iterator().next();
		connector.unMuteMember(c.getSid(), member.getId());
	}

	@Test
	public void testDeafMember() throws TelapiException {
		Conference c = connector.listConferences(null, null, null, null, null).iterator().next();
		ConferenceMember member = c.getMembers().iterator().next();
		connector.deafMember(c.getSid(), member.getId());
	}

	@Test
	public void testUnDeafMember() throws TelapiException {
		Conference c = connector.listConferences(null, null, null, null, null).iterator().next();
		ConferenceMember member = c.getMembers().iterator().next();
		connector.unDeafMember(c.getSid(), member.getId());
	}

	@Test
	public void testPlayAudio() throws TelapiException {
		Conference c = connector.listConferences(null, null, null, null, null).iterator().next();
		ConferenceMember member = c.getMembers().iterator().next();
		connector.playAudioToConference(c.getSid(), member.getId(), testParameters.getMp3Url());
	}
	
	@Test
	public void testKickMember() throws TelapiException {
		Conference c = connector.listConferences(null, null, null, null, null).iterator().next();
		ConferenceMember member = c.getMembers().iterator().next();
		connector.kickMember(c.getSid(), member.getId());
	}
	
	@Test
	public void testHangupMember() throws TelapiException {
		Conference c = connector.listConferences(null, null, null, null, null).iterator().next();
		ConferenceMember member = c.getMembers().iterator().next();
		connector.hangupMember(c.getSid(), member.getId());
	}
}
