/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easj.jrpg.stalkrlib;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Philip
 */
public class Tools
{
	public static long DateToUTS(Date date)
	{
		return (date.getTime() / 1000);
	}
	
	public static Date UTStoDate(long uts)
	{
		return new Date(uts * 1000);
	}
	
	public static String UserToString(User u, boolean admin)
	{
		StringBuilder sb = new StringBuilder();
		
		try
		{
			GeoLocation l = u.getLocation();
			Description d = u.getDescription();

			sb.append(u.getUniqueID())												.append("|");
			sb.append(u.getEmail())													.append("|");
			sb.append(u.getUsername())												.append("|");
			if (admin) { sb.append(u.getPassword()); } sb							.append("|");
			sb.append(u.getFirstName())												.append("|");
			sb.append(u.getLastName())												.append("|");
			sb.append(Long.toString(Tools.DateToUTS(u.getBirthday())))				.append("|");
			sb.append(Float.toString(l.getLatitude()))								.append("|");
			sb.append(Float.toString(l.getLongitude()))								.append("|");
			sb.append(Long.toString(Tools.DateToUTS(l.getTimeStamp())))				.append("|");
			sb.append(Long.toString(Tools.DateToUTS(d.getTimeStamp())))				.append("|");
			sb.append(d.getTitle())													.append("|");
			sb.append(Integer.toString(d.getAge().getMin()))						.append("|");
			sb.append(Integer.toString(d.getAge().getMax()))						.append("|");
			sb.append(d.getGender().toString())										.append("|");
			sb.append(d.getSexuality().toString())									.append("|");
			sb.append(d.getArea().toString())										.append("|");
			sb.append(d.getSmoking().toString())									.append("|");
			sb.append(d.getDrinking().toString())									;
			for (Description p : u.getPreferences())
			{
				sb.append("{");
				sb.append(p.getUniqueID().toString())								.append("|");
				sb.append(Long.toString(Tools.DateToUTS(p.getTimeStamp())))			.append("|");
				sb.append(p.getTitle())												.append("|");
				sb.append(Integer.toString(p.getAge().getMin()))					.append("|");
				sb.append(Integer.toString(p.getAge().getMax()))					.append("|");
				sb.append(p.getGender().toString())									.append("|");
				sb.append(p.getSexuality().toString())								.append("|");
				sb.append(p.getArea().toString())									.append("|");
				sb.append(p.getSmoking().toString())								.append("|");
				sb.append(p.getDrinking().toString())								;
			}
		}
		catch (Exception e)
		{
			sb = new StringBuilder();
		}
		finally
		{
			return sb.toString();
		}
	}
	
	public static User UserFromString(String s)
	{
		User u = null;
		try
		{
			String[] parts = s.split("\\{");
			String[] ss = parts[0].split("\\|");

			u = new User(UUID.fromString(ss[0]));
			u.setEmail(ss[1]);
			u.setUsername(ss[2]);
			u.setPassword(ss[3]);
			u.setFirstName(ss[4]);
			u.setLastName(ss[5]);
			u.setBirthday(Tools.UTStoDate(Long.parseLong(ss[6])));
			u.setLocation(new GeoLocation(
				Float.parseFloat(ss[7]), 
				Float.parseFloat(ss[8]), 
				Tools.UTStoDate(Long.parseLong(ss[9]))
			));
			Description d = new Description(UUID.fromString(ss[0]));
			d.setTimeStamp(Tools.UTStoDate(Long.parseLong(ss[10])));
			d.setTitle(ss[11]);
			d.getAge().set(Integer.parseInt(ss[12]), (Integer.parseInt(ss[13])));
			d.getGender().loadString(ss[14]);
			d.getSexuality().loadString(ss[15]);
			d.getArea().loadString(ss[16]);
			d.getSmoking().loadString(ss[17]);
			d.getDrinking().loadString(ss[18]);
			u.setDescription(d);

			// Add preference descriptions if available
			if (parts.length > 1)
			{
				// Make sure the list is empty
				//u.getPreferences().clear();
			
				for (int i = 1; i < parts.length; i++)
				{
					ss = parts[i].split("\\|");

					Description p = new Description(UUID.fromString(ss[0]));
					p.setTimeStamp(Tools.UTStoDate(Long.parseLong(ss[1])));
					p.setTitle(ss[2]);
					p.getAge().set(Integer.parseInt(ss[3]), (Integer.parseInt(ss[4])));
					p.getGender().loadString(ss[5]);
					p.getSexuality().loadString(ss[6]);
					p.getArea().loadString(ss[7]);
					p.getSmoking().loadString(ss[8]);
					p.getDrinking().loadString(ss[9]);
					u.getPreferences().add(p);
				}
			}
		}
		catch (Exception e)
		{
			u = null;
		}
		finally
		{
			return u;
		}
	}
	
//	public static ArrayList<User> getTestUsers()
//	{
//		ArrayList<User> users = new ArrayList<User>();
//		
//		User u1 = new User();
//		u1.setEmail("JohnnyBoye@email.com");
//		u1.setUsername("Johnnyboy");
//		u1.setPassword("admin1234");
//		u1.setFirstName("Johnny");
//		u1.setLastName("Boye");
//		u1.setBirthday(new Date(new Date().getTime() - 1000000));
//		u1.setLocation(new GeoLocation(22.33F, 33.22F));
//		Description d1 = new Description();
//		d1.setTimeStamp(new Date(new Date().getTime() - 4000));
//		d1.setTitle("Description");
//		d1.setAge(new Range(23));
//		d1.setGender(GenderList.FromString("01000"));
//		d1.setSexuality(SexualityList.FromString("0100"));
//		d1.setArea(AreaList.FromString("01000"));
//		d1.setSmoking(SmokingList.FromString("001"));
//		d1.setDrinking(DrinkingList.FromString("01"));
//		u1.setDescription(d1);
//		Description p1 = new Description();
//		p1.setTimeStamp(new Date(new Date().getTime() - 4200));
//		p1.setTitle("My preference");
//		p1.setAge(new Range(20, 30));
//		p1.setGender(GenderList.FromString("11111"));
//		p1.setSexuality(SexualityList.FromString("1111"));
//		p1.setArea(AreaList.FromString("11111"));
//		p1.setSmoking(SmokingList.FromString("111"));
//		p1.setDrinking(DrinkingList.FromString("11"));
//		u1.getPreferences().add(p1);
//		u1.resetAlteredValues();
//		users.add(u1);
//		
//		User u2 = new User();
//		u2.setEmail("JohnDoe69@gmail.com");
//		u2.setUsername("JohnDoe69");
//		u2.setPassword("admin1234");
//		u2.setFirstName("John");
//		u2.setLastName("Doe");
//		u2.setBirthday(new Date(new Date().getTime() - 1006200));
//		u2.setLocation(new GeoLocation(11.22F, 22.11F));
//		Description d2 = new Description();
//		d2.setTimeStamp(new Date(new Date().getTime() - 3800));
//		d2.setTitle("Description");
//		d2.setAge(new Range(35));
//		d2.setGender(GenderList.FromString("01000"));
//		d2.setSexuality(SexualityList.FromString("0001"));
//		d2.setArea(AreaList.FromString("00010"));
//		d2.setSmoking(SmokingList.FromString("010"));
//		d2.setDrinking(DrinkingList.FromString("01"));
//		u2.setDescription(d2);
//		Description p2 = new Description();
//		p2.setTimeStamp(new Date(new Date().getTime() - 5000));
//		p2.setTitle("Yo momma!");
//		p2.setAge(new Range(20, 35));
//		p2.setGender(GenderList.FromString("00111"));
//		p2.setSexuality(SexualityList.FromString("0011"));
//		p2.setArea(AreaList.FromString("01111"));
//		p2.setSmoking(SmokingList.FromString("110"));
//		p2.setDrinking(DrinkingList.FromString("10"));
//		u2.getPreferences().add(p2);
//		u2.resetAlteredValues();
//		users.add(u2);
//		
//		User u3 = new User();
//		u3.setEmail("JaneDogsbollock@gmail.com");
//		u3.setUsername("DogsBollock");
//		u3.setPassword("admin1234");
//		u3.setFirstName("Jane");
//		u3.setLastName("bollock");
//		u3.setBirthday(new Date(new Date().getTime() - 996200));
//		u3.setLocation(new GeoLocation(20.30F, 30.20F));
//		Description d3 = new Description();
//		d3.setTimeStamp(new Date(new Date().getTime() - 13800));
//		d3.setTitle("Description");
//		d3.setAge(new Range(27));
//		d3.setGender(GenderList.FromString("00100"));
//		d3.setSexuality(SexualityList.FromString("0100"));
//		d3.setArea(AreaList.FromString("10000"));
//		d3.setSmoking(SmokingList.FromString("100"));
//		d3.setDrinking(DrinkingList.FromString("10"));
//		u3.setDescription(d3);
//		Description p3 = new Description();
//		p3.setTimeStamp(new Date(new Date().getTime() - 15000));
//		p3.setTitle("Thi hi fnis");
//		p3.setAge(new Range(27, 27));
//		p3.setGender(GenderList.FromString("01100"));
//		p3.setSexuality(SexualityList.FromString("0111"));
//		p3.setArea(AreaList.FromString("01011"));
//		p3.setSmoking(SmokingList.FromString("100"));
//		p3.setDrinking(DrinkingList.FromString("10"));
//		u3.getPreferences().add(p3);
//		u3.resetAlteredValues();
//		users.add(u3);
//		
//		User u4 = new User();
//		u4.setEmail("JodyGoodall@yahoo.co.uk");
//		u4.setUsername("Good4All");
//		u4.setPassword("admin1234");
//		u4.setFirstName("Jody");
//		u4.setLastName("Goodall");
//		u4.setBirthday(new Date(new Date().getTime() - 1011200));
//		u4.setLocation(new GeoLocation(10.53F, 50.27F));
//		Description d4 = new Description();
//		d4.setTimeStamp(new Date(new Date().getTime() - 7800));
//		d4.setTitle("Description");
//		d4.setAge(new Range(31));
//		d4.setGender(GenderList.FromString("00100"));
//		d4.setSexuality(SexualityList.FromString("0010"));
//		d4.setArea(AreaList.FromString("00010"));
//		d4.setSmoking(SmokingList.FromString("111"));
//		d4.setDrinking(DrinkingList.FromString("11"));
//		u4.setDescription(d4);
//		Description p4 = new Description();
//		p4.setTimeStamp(new Date(new Date().getTime() - 9500));
//		p4.setTitle("Thi hi fnis");
//		p4.setAge(new Range(30, 35));
//		p4.setGender(GenderList.FromString("00100"));
//		p4.setSexuality(SexualityList.FromString("0010"));
//		p4.setArea(AreaList.FromString("00010"));
//		p4.setSmoking(SmokingList.FromString("111"));
//		p4.setDrinking(DrinkingList.FromString("11"));
//		u4.getPreferences().add(p4);
//		u4.resetAlteredValues();
//		users.add(u4);
//		
//		User u5 = new User();
//		u5.setEmail("james4mayor@irulez.org");
//		u5.setUsername("TheJames");
//		u5.setPassword("admin1234");
//		u5.setFirstName("James");
//		u5.setLastName("Nellson");
//		u5.setBirthday(new Date(new Date().getTime() - 1020200));
//		u5.setLocation(new GeoLocation(11.03F, 25.11F));
//		Description d5 = new Description();
//		d5.setTimeStamp(new Date(new Date().getTime() - 7100));
//		d5.setTitle("Description");
//		d5.setAge(new Range(22));
//		d5.setGender(GenderList.FromString("01000"));
//		d5.setSexuality(SexualityList.FromString("0100"));
//		d5.setArea(AreaList.FromString("00001"));
//		d5.setSmoking(SmokingList.FromString("100"));
//		d5.setDrinking(DrinkingList.FromString("10"));
//		u5.setDescription(d5);
//		Description p5 = new Description();
//		p5.setTimeStamp(new Date(new Date().getTime() - 8400));
//		p5.setTitle("Thi hi fnis");
//		p5.setAge(new Range(30, 50));
//		p5.setGender(GenderList.FromString("00100"));
//		p5.setSexuality(SexualityList.FromString("0100"));
//		p5.setArea(AreaList.FromString("11111"));
//		p5.setSmoking(SmokingList.FromString("111"));
//		p5.setDrinking(DrinkingList.FromString("11"));
//		u5.getPreferences().add(p5);
//		u5.resetAlteredValues();
//		users.add(u5);
//		
//		return users;
//	}
}
