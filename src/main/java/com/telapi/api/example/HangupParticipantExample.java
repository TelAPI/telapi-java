package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.Participant;
import com.telapi.api.exceptions.TelapiException;

public class HangupParticipantExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			Participant participant = conn.hangupParticipant("{ConferenceSid}", "{CallSid}");
			System.out.println(participant.getCallSid());
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
