package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.Notification;
import com.telapi.api.exceptions.TelapiException;

public class ViewNotificationExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			Notification notification = conn.viewNotification("{NotificationSid}");
			System.out.println(notification.getSid());
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
