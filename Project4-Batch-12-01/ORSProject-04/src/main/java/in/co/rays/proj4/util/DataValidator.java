package in.co.rays.proj4.util;

import java.util.Date;
import java.util.regex.Pattern;

public class DataValidator {

	private static final Pattern EMAIL_PATTERN = Pattern
			.compile("^[_A-Za-z0-9+\\-]+(\\.[_A-Za-z0-9+\\-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	public static boolean isNull(String val) {
		return val == null || val.trim().isEmpty();
	}

	public static boolean isNotNull(String val) {
		return !isNull(val);
	}

	public static boolean isInteger(String val) {
		if (isNotNull(val)) {
			try {
				Integer.parseInt(val);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return false;
	}

	public static boolean isLong(String val) {
		if (isNotNull(val)) {
			try {
				Long.parseLong(val);
				return true;
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return false;
	}

	public static boolean isEmail(String val) {
		return isNotNull(val) && EMAIL_PATTERN.matcher(val).matches();
	}

	public static boolean isDate(String val) {
		if (isNotNull(val)) {
			Date d = DataUtility.getDate(val);
			return d != null;
		}
		return false;
	}

}
