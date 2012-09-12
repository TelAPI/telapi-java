package com.telapi.api.example;

import java.util.List;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.Participant;
import com.telapi.api.exceptions.TelapiException;

public class ListParticipantsExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
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
