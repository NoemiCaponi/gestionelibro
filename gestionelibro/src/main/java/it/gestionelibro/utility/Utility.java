package it.gestionelibro.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class Utility {
	
	public static boolean validateInput(String codiceinput, String titoloinput, String prezzoinputstring,
			String dataarrivostring) {
			
		if (StringUtils.isBlank(codiceinput) || StringUtils.isBlank(titoloinput)
				|| !NumberUtils.isCreatable(prezzoinputstring) || StringUtils.isBlank(dataarrivostring)) {
			return false;
		}
		return true;
	}
	public static Date parseDateArrivoFromString(String dataArrivoStringParam) {
		if (StringUtils.isBlank(dataArrivoStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataArrivoStringParam);
		} catch (ParseException e) {
			return null;
		}
	}

}
