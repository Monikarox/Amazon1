package utilities;

import java.util.Date;
import java.sql.Timestamp;

public class TimeStamp {
	
	private TimeStamp() {
		
	}

	public static Timestamp getCurrentTimeStamp() {
		Date date = new Date();
		long time  = date.getTime();
		return new Timestamp(time);
	}
}
