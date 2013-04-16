/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javalibtest;

import com.sun.org.apache.xpath.internal.operations.Equals;
import easj.jrpg.Match;
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
		ArrayList<Match> matches = new ArrayList<>();
		matches.add(new Match("1A6747B2-931C-11E2-AE68-D7146188709B", "1234", 12));
		matches.add(new Match("2234", "1234", 54));
		matches.add(new Match("3234", "1234", 35));
		matches.add(new Match("4234", "1234", 75));
		matches.add(new Match("5234", "1234", 64));
		matches.add(new Match("6234", "1234", 23));
		
		Match match = new Match("1A6747B2-931C-11E2-AE68-D7146188709B", "1234", 99);
		
		for (int i = 0; i < matches.size();)
		{
			Match m = matches.get(i);
			if (m.getId() == match.getId())
			{
				if (m.getPercentage() > match.getPercentage())
				{
					match.setPercentage(m.getPercentage());
				}
				matches.remove(i);
			}
			else
			{
				i++;
			}
		}
		matches.add(match);
		
		for (Match m : matches)
		{
			System.out.println(m.toString());
		}
		
		//UserMapper um = new UserMapper();
		
		/*
		um.saveUser("1a6747b2-931c-11e2-ae68-d7146188709b|phandazee@gmail.com2|Jonazzy|9876|Jonaz|van der Zee|0|4.12|7.14|1365917198|1365962624|Description|43|43|01000|0010|00100|010|01{8b9e9d44-4411-434f-b5cc-5b803a3dc4f6|18000|NOT A TEST|45|60|01000|0010|00001|000|00{25dfd8b6-9ca1-4b94-b36c-5b6b61ca0bda|1366043054|A secret title|18|30|00011|1011|00100|111|11");
		um.saveUser("2aed9276-931c-11e2-9857-dc146188709b|jamesjohnson@jubiipost.dk|JamesJohnson43|3456|James|Johnson|378|9.4|2.2|1366065108|123456|Description|43|43|00000|0100|01000|000|00{722bfd5e-931b-11e2-9a5c-54146188709b|123456789|HERE GOES EVERYT|22|33|01000|0100|00010|010|01");
		um.saveUser("406a84d8-931c-11e2-9c5d-e0146188709b|martinhansen@jubiipost.dk|Martin6|5678|Martin|Hansen|469469|11.2|3.4|1366065025|123456|Description|29|29|01000|0001|00001|010|01{918446d4-931b-11e2-a016-67146188709b|123456789|A title|22|45|01000|0010|00100|000|01");
		um.saveUser("453b6888-9597-11e2-8012-90ca6088709b|bertamus@jubiipost.dk|Bertamus|4567|Berta|Larsen|797|14.12|14.2|1366065003|1366049152||43|43|00100|0010|00100|010|01{538a40bc-9597-11e2-81cd-96ca6088709b|123456789|Preference|77|98|00000|0010|00001|000|00");
		um.saveUser("9b0b2b31-2a67-4172-aea7-acf2bd80532d|test@test.nu|test1234|test1234|test|1234|616204|5.0|5.0|1366059932|1366059893||24|99|10000|1000|10000|100|10{0ca808ae-99c1-4104-9a02-ad1ac99c8179|1366059931|Anyone|18|99|11111|1111|11111|111|11");
		um.saveUser("edea3e9a-da70-4a52-b1be-68df86b1afda|johndoe@jubiipost.dk|JohnDoe69|1234|John|Doe|3723|10.5|5.1|1365905261|1365||43|43|01000|0100|01000|100|10{57008f04-b8e3-464b-8253-1fa44fcea113|0|Default|20|30|01000|0100|01000|100|10");
		*/
		
		//um.getMatches(um.getUser("9b0b2b31-2a67-4172-aea7-acf2bd80532d"));
		
		/*// Test verifyLogin
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
		else { System.out.println("DELETE NOT SUCCESSFUL"); }*/
	}
	
	private static ArrayList<User> getUsers(String string)
	{
		easj.jrpg.WS _service = new easj.jrpg.WS();
		easj.jrpg.StalkrWebService _port = _service.getStalkrWebServicePort();
		
		ArrayList<User> userlist = new ArrayList<User>();
		List<String> usersasstrings = _port.getUsers(string);
		for (String userstring : usersasstrings)
		{
			userlist.add(Tools.UserFromString(userstring));
		}
		return userlist;
	}
	
	private static ArrayList<String> getMatches(String id)
	{
		easj.jrpg.WS _service = new easj.jrpg.WS();
		easj.jrpg.StalkrWebService _port = _service.getStalkrWebServicePort();
		
		return (ArrayList)_port.getMatches(id);
	}
}
