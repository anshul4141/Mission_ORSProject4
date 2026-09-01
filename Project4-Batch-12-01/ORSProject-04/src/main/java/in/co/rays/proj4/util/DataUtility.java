package in.co.rays.proj4.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DataUtility {

	public static final String APP_DATE_FORMAT = "yyyy-MM-dd";
	public static final String APP_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";
	private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern(APP_DATE_FORMAT);
	private static final DateTimeFormatter TIME_FMT = DateTimeFormatter.ofPattern(APP_TIME_FORMAT);

	public static String getString(String val) {
		if (DataValidator.isNotNull(val)) {
			return val.trim();
		} else {
			return val;
		}
	}

	public static String getStringData(Object val) {
		if (val != null) {
			return val.toString();
		} else {
			return "";
		}
	}

	public static int getInt(String val) {
		if (DataValidator.isInteger(val)) {
			return Integer.parseInt(val);
		} else {
			return 0;
		}
	}

	public static long getLong(String val) {
		if (DataValidator.isLong(val)) {
			return Long.parseLong(val);
		} else {
			return 0;
		}
	}

	public static Date getDate(String val) {
		try {
			LocalDate ld = LocalDate.parse(val, DATE_FMT);
			return Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
		} catch (Exception e) {
			return null;
		}
	}

	public static String getDateString(Date date) {
		if (date == null)
			return "";
		try {
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(APP_DATE_FORMAT);
			return sdf.format(date);
		} catch (Exception e) {
			try {
				LocalDate ld = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				return DATE_FMT.format(ld);
			} catch (Exception ex) {
				return "";
			}
		}
	}

	public static Timestamp getTimestamp(String val) {
		try {
			LocalDateTime ldt = LocalDateTime.parse(val, TIME_FMT);
			return Timestamp.valueOf(ldt);
		} catch (Exception e) {
			return null;
		}
	}

	public static Timestamp getTimestamp(long l) {
		return new Timestamp(l);
	}

	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static long getTimestamp(Timestamp tm) {
		if (tm == null)
			return 0;
		return tm.getTime();
	}

	public static String exceptionToString(Exception e) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		e.printStackTrace(new PrintStream(baos));
		return baos.toString();
	}

}
