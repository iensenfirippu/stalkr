package easj.jrpg;

import java.util.Date;

/**
 *
 */
public class Tools
{	
	public static long DTtoTS(Date date) { return DTtoTS(date, true); }
	public static long DTtoTS(Date date, boolean timestampinmilis)
	{
		long value = date.getTime();
		if (timestampinmilis) { value /= 1000; }
		return value;
	}
	
	public static Date DTfromTS(long uts) { return DTfromTS(uts, true); }
	public static Date DTfromTS(long uts, boolean timestampinmilis)
	{
		if (timestampinmilis) { uts *= 1000; }
		return new Date(uts);
	}
}
