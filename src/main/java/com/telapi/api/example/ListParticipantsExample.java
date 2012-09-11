package com.telapi.api.example;

import java.util.List;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.Participant;
import com.telapi.api.exceptions.TelapiException;

public class ListParticipantsExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("ACbf75172498784edc98406f494ec7abec");
		conf.setAuthToken("11e457ff63174f3e94bd6cb9b7812021");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			List<Participant> participantsList = conn.listParticipants("{ConferenceSid}");
			for(Participant participant : participantsList) {
				System.out.println(participant.getCallSid());
			}
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
