package br.edu.fa7.controle_passagem.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private DateUtil() {
	}

	public static Date stringToDate(String date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(date);
		} catch (Exception e) {
			return null;
		}
	}
}