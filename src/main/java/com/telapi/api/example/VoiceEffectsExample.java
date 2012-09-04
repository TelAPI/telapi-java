package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.Call;
import com.telapi.api.domain.enums.AudioDirection;
import com.telapi.api.exceptions.TelapiException;

public class VoiceEffectsExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("ACbf75172498784edc98406f494ec7abec");
		conf.setAuthToken("11e457ff63174f3e94bd6cb9b7812021");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			Call call = conn.voiceEffects("{CallSid}", AudioDirection.OUT, 2.0, 11L, 0L, null);
			System.out.println(call.getSid());
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
