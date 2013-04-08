/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javalibtest;

import stalkrlib.*;
import stalkrlib.Description.*;
import java.util.ArrayList;
import java.util.Date;
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
		User u1 = new User(UUID.randomUUID().toString());
		u1.setEmail("JohnnyBoye@email.com");
		u1.setUsername("Johnnyboy");
		u1.setPassword("admin1234");
		u1.setFirstName("Johnny");
		u1.setLastName("Boye");
		u1.setBirthdate(new Date(new Date().getTime() - 1000000));
		u1.setLastLocation(new Location(22.33F, 33.22F, new Date(new Date().getTime() - 1500)));
		Description d1 = new Description();
		d1.setTimestamp(new Date(new Date().getTime() - 4000));
		d1.setTitle("Description");
		d1.setAge(new Range(23, -1));
		d1.setGender(EnumMapper.stringToEnumList(Gender.OTHER, "01000"));
		d1.setSexuality(EnumMapper.stringToEnumList(Sexuality.ASEXUAL, "0100"));
		d1.setArea(EnumMapper.stringToEnumList(Area.NOTSPECIFIED, "01000"));
		d1.setSmoking(EnumMapper.stringToEnumList(Smoking.NO, "001"));
		d1.setDrinking(EnumMapper.stringToEnumList(Drinking.NO, "01"));
		u1.setDescription(d1);
		Description p1 = new Description();
		p1.setTimestamp(new Date(new Date().getTime() - 4200));
		p1.setTitle("My preference");
		p1.setAge(new Range(20, 30));
		p1.setGender(EnumMapper.stringToEnumList(Gender.OTHER, "11111"));
		p1.setSexuality(EnumMapper.stringToEnumList(Sexuality.ASEXUAL, "1111"));
		p1.setArea(EnumMapper.stringToEnumList(Area.NOTSPECIFIED, "11111"));
		p1.setSmoking(EnumMapper.stringToEnumList(Smoking.NO, "111"));
		p1.setDrinking(EnumMapper.stringToEnumList(Drinking.NO, "11"));
		u1.getPreferences().add(p1);

		System.out.println("Converting user \"" + u1.getUsername() + "\" to string:");
		System.out.println("Email: " + u1.getEmail());
		System.out.println("Description title: " + u1.getDescription().getTitle());
		System.out.println("Minimum age: " + u1.getDescription().getAge().getMin());
		System.out.println("Sexuality: " + EnumMapper.enumListToString(Sexuality.ASEXUAL, u1.getDescription().getSexuality()));
		System.out.println("Sexuality pref: " + EnumMapper.enumListToString(Sexuality.ASEXUAL, u1.getPreference(0).getSexuality()));
		System.out.println("Preferenece title: " + u1.getPreference(0).getTitle());
		
		System.out.println("");
		
		String s = u1.toString();
		System.out.println(s);
		
		System.out.println("");
		
		User u2 = User.fromString(s);
		System.out.println("..and back again...");
		System.out.println("Email: " + u2.getEmail());
		System.out.println("Description title: " + u2.getDescription().getTitle());
		System.out.println("Minimum age: " + u2.getDescription().getAge().getMin());
		System.out.println("Sexuality: " + EnumMapper.enumListToString(Sexuality.ASEXUAL, u2.getDescription().getSexuality()));
		System.out.println("Sexuality pref: " + EnumMapper.enumListToString(Sexuality.ASEXUAL, u2.getPreference(0).getSexuality()));
		System.out.println("Preferenece title: " + u2.getPreference(0).getTitle());
	}
}
