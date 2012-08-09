package com.telapi.api.domain.enums.util;

import java.util.Map;
import java.util.Map.Entry;

public class EnumUtil {

	public static <T> T getValue(String s, Map<T, String> map, T unknown) {
		if (s == null) return null;
		for (Entry<T, String> entry : map.entrySet()) {
			if (entry.getValue().equals(s)) {
				return entry.getKey();
			}
		}
		return unknown;
	}
}
