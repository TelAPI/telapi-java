package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.CarrierLookup;
import com.telapi.api.domain.list.CarrierLookupList;
import com.telapi.api.exceptions.TelapiException;

public class CarrierLookupExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("ACbf75172498784edc98406f494ec7abec");
		conf.setAuthToken("11e457ff63174f3e94bd6cb9b7812021");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			CarrierLookupList carrierLookups = conn.carrierLookup("{E_164_number}");
			for (CarrierLookup carrierLookup : carrierLookups) {
				System.out.println(carrierLookup.getSid());
			}
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
