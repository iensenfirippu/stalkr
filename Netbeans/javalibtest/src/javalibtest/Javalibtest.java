/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javalibtest;

import java.util.ArrayList;
import java.util.Date;
import stalkrlib.*;
import stalkrlib.enums.*;

/**
 *
 * @author Philip
 */
public class Javalibtest
{
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args)
	{
		ArrayList<User> users = Toolbelt.getTestUsers();
		
		for (User u : users)
		{
			System.out.println("Found user: " + u.getUsername());
		}
	}
}
