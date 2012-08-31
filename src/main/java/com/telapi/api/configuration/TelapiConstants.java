package com.telapi.api.configuration;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class TelapiConstants {
	public static final String BASE_URL = "https://api.telapi.com/";
	public static final String API_VERSION = "2011-07-01";
	
	public static final SimpleDateFormat queryDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat jsonDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
	
}
