package com.mission.ShortURLService.utils;

import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public final class BASE62Utils {
	public static String HEAD;
	public static String BASE62;

	@Value("${shorten-url-suffix}")
	public void setHEAD(String head) {
		HEAD = head;
	}
	@Value("${shorten-algorithm-BASE62}")
	public void setBASE62(String base62) {
		BASE62 = base62;
	}

	public static String encode(Integer value) {

		StringBuilder sb = new StringBuilder(HEAD);
		BigInteger val = new BigInteger("62");
		BigInteger zero = new BigInteger("0");
		BigInteger intVal = new BigInteger("100000000");
		intVal = intVal.add(new BigInteger(value.toString()));
		do {
			int i = intVal.mod(val).intValue();
			sb.append(BASE62.charAt(i));
			intVal = intVal.divide(val);
		} while (intVal.compareTo(zero) == 1);
		return sb.toString();
	}

	public static Integer decode(String value) {
		Integer result = 0;
		Integer power = 1;
		for (int i = 0; i < value.length(); i++) {
			int digit = BASE62.indexOf(value.charAt(i));
			result += digit * power;
			power *= 62;
		}
		return result;
	}

}
