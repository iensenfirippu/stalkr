/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javalibtest;

import easj.jrpg.stalkrlib.Toolbelt;
import easj.jrpg.stalkrlib.User;
import java.util.ArrayList;
import java.util.Date;

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
		
		User u1 = users.get(0);
		System.out.println("Converting user \"" + u1.getUsername() + "\" to string:");
		System.out.println("Email: " + u1.getEmail());
		System.out.println("Description title: " + u1.getDescription().getTitle());
		System.out.println("Minimum age: " + u1.getDescription().getAge().getMin());
		System.out.println("Sexuality pref: " + u1.getDescription().getSexuality().ToStringList().toString());
		System.out.println("Sexuality pref: " + u1.getPreference(0).getSexuality().ToStringList().toString());
		System.out.println("Prefernece title: " + u1.getPreference(0).getTitle());
		
		System.out.println("");
		
		String s = u1.toString();
		System.out.println(s);
		
		System.out.println("");
		
		User u2 = User.fromString(s);
		System.out.println("..and back again...");
		System.out.println("Email: " + u2.getEmail());
		System.out.println("Description title: " + u2.getDescription().getTitle());
		System.out.println("Minimum age: " + u2.getDescription().getAge().getMin());
		System.out.println("Sexuality: " + u2.getDescription().getSexuality().ToStringList().toString());
		System.out.println("Sexuality pref: " + u2.getPreference(0).getSexuality().ToStringList().toString());
		System.out.println("Prefernece title: " + u2.getPreference(0).getTitle());
	}
}
