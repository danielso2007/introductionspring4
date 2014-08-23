package br.com.estudo.introductionspring4.lang.util;

public final class Check {

	public static boolean isNotNull(Object obj) {
		if (obj == null) {
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
	}
	
	public static boolean isNull(Object obj) {
		return !isNotNull(obj);
	}
	
	public static boolean isNotEmpty(String str) {
		if (str == null || str.isEmpty()) {
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
	}
	
	public static boolean isEmpty(String str) {
		return !isNotEmpty(str);
	}
	
}
