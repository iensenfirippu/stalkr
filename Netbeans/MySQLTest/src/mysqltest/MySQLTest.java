/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqltest;

/**
 *
 * @author Philip
 */
public class MySQLTest
{
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		MySQLAccess doa = new MySQLAccess();
		try
		{
			doa.readDataBase();
		}
		catch (Exception e)
		{
			// Do nothing
		}
	}
}
