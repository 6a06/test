package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class nameMatch {
	public boolean nameMatching(String s) {
		Pattern p = Pattern.compile("[a-zA-Z_0-9]+");
		Matcher m = p.matcher(s);
		boolean result = m.matches();
		return result;
	}
}
