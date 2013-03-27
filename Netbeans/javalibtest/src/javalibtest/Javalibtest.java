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
		User u = new User();
		u.setEmail("me@iensenfirippu.dk");
		u.setUsername("iensensama");
		u.setPassword("Always1234");
		u.setFirstName("Philip");
		u.setLastName("Jensen");
		u.setBirthday(new Date());
		
		GeoLocation l = new GeoLocation(2.2F, 3.3F);
		u.setLocation(l);
		
		Description d = new Description();
		d.setTimeStamp(new Date());
		d.setTitle("Default");
		d.setAge(new Range(26));
		d.setGender(new GenderList(GenderType.MALE));
		d.setSexuality(new SexualityList(SexualityType.HETERO));
		d.setArea(new AreaList(AreaType.SJAELLAND));
		d.setSmoking(new SmokingList(SmokingType.NO));
		d.setDrinking(new DrinkingList(DrinkingType.YES));
		u.setDescription(d);
		
		Description p = new Description();
		p.setTimeStamp(new Date());
		p.setTitle("Default");
		p.setAge(new Range(25, 40));
		p.setGender(GenderList.FromString("11111"));
		p.setSexuality(SexualityList.FromString("1111"));
		p.setArea(AreaList.FromString("11111"));
		p.setSmoking(SmokingList.FromString("111"));
		p.setDrinking(DrinkingList.FromString("11"));
		u.getPreferences().add(p);
		
		u.resetAlteredValues();
		
		String sexstring = "";
		for (SexualityType t : u.getPreferences().get(0).getSexuality().getList())
		{
			sexstring += t.toString() + ", ";
		}
		System.out.println("You can...");
		System.out.println("Iterate over the enum lists: " + sexstring);
		System.out.println("And import/export binary strings: " + u.getPreferences().get(0).getSexuality().toString());
	}
}
