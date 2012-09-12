package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.CnamDip;
import com.telapi.api.domain.list.CnamDipList;
import com.telapi.api.exceptions.TelapiException;

public class CnamLookupExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			CnamDipList cnamList = conn.cnamLookup("{E_164_number}");
			for(CnamDip cnamDip : cnamList) {
				System.out.println(cnamDip.getSid());
			}
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
