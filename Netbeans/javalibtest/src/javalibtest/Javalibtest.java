/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javalibtest;

import easj.jrpg.stalkrlib.*;
import easj.jrpg.stalkrlib.EnumList.*;
import easj.jrpg.mappers.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
		UserMapper um = new UserMapper();
		
		// Test verifyLogin
		boolean result = um.verifyLogin("JohnDoe69", "1234");
		if (result) { System.out.println("login successful"); }
		else { System.out.println("LOGIN NOT SUCCESSFUL"); }
		
		// Test getUsers
		//ArrayList<User> users = getUsers("");
		ArrayList<User> users = new ArrayList<User>();
		String[] usersasstrings = um.getUsers("");
		for (String userstring : usersasstrings)
		{
			users.add(Tools.UserFromString(userstring));
		}
		for (User u : users)
		{
			System.out.println("Get Users" + Tools.UserToString(u, true));
		}
		
		// Test getUser
		User u = Tools.UserFromString(um.getUser(users.get(0).getUniqueID().toString()));
		System.out.println("Get User" + Tools.UserToString(u, true));
		
		// Test saveUser (update)
		u.getDescription().setTitle("No...");
		result = um.saveUser(Tools.UserToString(u, true));
		if (result) { System.out.println("Update successful"); }
		else { System.out.println("UPDATE NOT SUCCESSFUL"); }
		
		System.out.println("Please verify in database, then press enter to continue.");
		try { System.in.read(); } catch (Exception e) {} 
		
		// Test saveUser (insert)
		u = new User();
		u.setUsername("Delete me!");
		result = um.saveUser(Tools.UserToString(u, true));
		if (result) { System.out.println("Insert successful"); }
		else { System.out.println("INSERT NOT SUCCESSFUL"); }
		
		System.out.println("Please verify in database, then press enter to continue.");
		try { System.in.read(); } catch (Exception e) {} 
		
		// Test deleteUser
		result = um.deleteUser(u.getUniqueID().toString());
		if (result) { System.out.println("Delete successful"); }
		else { System.out.println("DELETE NOT SUCCESSFUL"); }
	}
	
	private static ArrayList<User> getUsers(String string)
	{
		javalibtest.WS _service = new javalibtest.WS();
		javalibtest.StalkrWebService _port = _service.getStalkrWebServicePort();
		
		ArrayList<User> userlist = new ArrayList<User>();
		List<String> usersasstrings = _port.getUsers(string);
		for (String userstring : usersasstrings)
		{
			userlist.add(Tools.UserFromString(userstring));
		}
		return userlist;
	}
}
