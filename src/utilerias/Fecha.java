package utilerias;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fecha {

	public static final String DATE_FORMAT_NOW = "dd/MM/yyyy HH:mm:ss";

	public static String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}

	public static String now(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(cal.getTime());
	}

}
