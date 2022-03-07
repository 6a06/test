package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormat {

	public static String sdf(LocalDateTime d) {
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd/HH:mm");
		String s=dtf.format(d);
		return s;
	}
}
