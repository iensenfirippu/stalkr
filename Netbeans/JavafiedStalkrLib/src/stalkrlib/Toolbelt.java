/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stalkrlib;

import java.util.Date;

/**
 *
 * @author Philip
 */
public class Toolbelt
{
	public static long DateToUTS(Date date)
	{
		return (date.getTime() / 1000);
	}
	
	public static Date UTStoDate(long uts)
	{
		return new Date(uts * 1000);
	}
}
