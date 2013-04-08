/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easj.jrpg.stalkrlib;

import easj.jrpg.stalkrlib.enums.*;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.xml.bind.ParseConversionEvent;

/**
 *
 * @author Philip
 */
public class User
{
	// Class global variables
	private UUID _uniqueid;
	private String _email;
	private String _username;
	private String _password;
	private String _firstname;
	private String _lastname;
	private Date _birthday;
	private GeoLocation _location;
	private Description _description;
	private ArrayList<Description> _preferences;

	private Map<String, Boolean> _alteredfields;

	// Constructors
	public User()
	{
		_uniqueid = UUID.randomUUID();
		_preferences = new ArrayList<Description>();
		setDefaultValues();
		setAlteredValues();
	}
	public User(UUID uuid)
	{
		_uniqueid = uuid;
		_preferences = new ArrayList<Description>();
		setAlteredValues();
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(_uniqueid)															.append("|");
		sb.append(_email)																.append("|");
		sb.append(_username)															.append("|");
		sb.append(_password)															.append("|");
		sb.append(_firstname)															.append("|");
		sb.append(_lastname)															.append("|");
		sb.append(Long.toString(Toolbelt.DateToUTS(_birthday)))							.append("|");
		sb.append(Float.toString(_location.getLatitude()))								.append("|");
		sb.append(Float.toString(_location.getLongitude()))								.append("|");
		sb.append(Long.toString(Toolbelt.DateToUTS(_location.getTimeStamp())))			.append("|");
		sb.append(Long.toString(Toolbelt.DateToUTS(_description.getTimeStamp())))		.append("|");
		sb.append(_description.getTitle())												.append("|");
		sb.append(Integer.toString(_description.getAge().getMin()))						.append("|");
		sb.append(Integer.toString(_description.getAge().getMax()))						.append("|");
		sb.append(_description.getGender().toString())									.append("|");
		sb.append(_description.getSexuality().toString())								.append("|");
		sb.append(_description.getArea().toString())									.append("|");
		sb.append(_description.getSmoking().toString())									.append("|");
		sb.append(_description.getDrinking().toString())								;
		for (Description p : _preferences)
		{
			sb.append("{");
			sb.append(p.getUniqueID().toString())										.append("|");
			sb.append(Long.toString(Toolbelt.DateToUTS(p.getTimeStamp())))				.append("|");
			sb.append(p.getTitle())														.append("|");
			sb.append(Integer.toString(p.getAge().getMin()))							.append("|");
			sb.append(Integer.toString(p.getAge().getMax()))							.append("|");
			sb.append(p.getGender().toString())											.append("|");
			sb.append(p.getSexuality().toString())										.append("|");
			sb.append(p.getArea().toString())											.append("|");
			sb.append(p.getSmoking().toString())										.append("|");
			sb.append(p.getDrinking().toString())										;
		}
		
		return sb.toString();
	}
	
	public static User fromString(String s)
	{
		String[] parts = s.split("\\{");
		String[] ss = parts[0].split("\\|");
		
		User u = new User(UUID.fromString(ss[0]));
		u.setEmail(ss[1]);
		u.setUsername(ss[2]);
		u.setPassword(ss[3]);
		u.setFirstName(ss[4]);
		u.setLastName(ss[5]);
		u.setBirthday(Toolbelt.UTStoDate(Long.parseLong(ss[6])));
		GeoLocation l = new GeoLocation(
			Float.parseFloat(ss[7]), 
			Float.parseFloat(ss[8]), 
			Toolbelt.UTStoDate(Long.parseLong(ss[9]))
		);
		u.setLocation(l);
		Description d = new Description(UUID.fromString(ss[0]));
		d.setTimeStamp(Toolbelt.UTStoDate(Long.parseLong(ss[10])));
		d.setTitle(ss[11]);
		Range dr = new Range(Integer.parseInt(ss[12]), (Integer.parseInt(ss[13])));
		d.setAge(dr);
		d.setGender(GenderList.FromString(ss[14]));
		d.setSexuality(SexualityList.FromString(ss[15]));
		d.setArea(AreaList.FromString(ss[16]));
		d.setSmoking(SmokingList.FromString(ss[17]));
		d.setDrinking(DrinkingList.FromString(ss[18]));
		u.setDescription(d);
		
		for (int i = 1; i < parts.length; i++)
		{
			ss = parts[i].split("\\|");
			
			Description p = new Description(UUID.fromString(ss[0]));
			p.setTimeStamp(Toolbelt.UTStoDate(Long.parseLong(ss[1])));
			p.setTitle(ss[2]);
			Range pr = new Range(Integer.parseInt(ss[3]), (Integer.parseInt(ss[4])));
			p.setAge(pr);
			p.setGender(GenderList.FromString(ss[5]));
			p.setSexuality(SexualityList.FromString(ss[6]));
			p.setArea(AreaList.FromString(ss[7]));
			p.setSmoking(SmokingList.FromString(ss[8]));
			p.setDrinking(DrinkingList.FromString(ss[9]));
			u.getPreferences().add(p);
		}
		
		return u;
	}
	
	// Constructor called methods
	private void setDefaultValues()
	{
		_birthday = new Date(0);
		_location = new GeoLocation();
		_description = new Description();
	}
	
	private void setAlteredValues()
	{
		_alteredfields = new HashMap<String, Boolean>();
		_alteredfields.put("uniqueid", false);
		_alteredfields.put("email", false);
		_alteredfields.put("username", false);
		_alteredfields.put("password", false);
		_alteredfields.put("firstname", false);
		_alteredfields.put("lastname", false);
		_alteredfields.put("birthday", false);
		_alteredfields.put("location", false);
		_alteredfields.put("description", false);
		_alteredfields.put("preference", false);
	}
	
	public void resetAlteredValues()
	{
		_alteredfields.clear();
		_alteredfields.put("uniqueid", false);
		_alteredfields.put("email", false);
		_alteredfields.put("username", false);
		_alteredfields.put("password", false);
		_alteredfields.put("firstname", false);
		_alteredfields.put("lastname", false);
		_alteredfields.put("birthday", false);
		_alteredfields.put("location", false);
		_alteredfields.put("description", false);
		_alteredfields.put("preference", false);
		
		_description.resetAlteredFields();
		for (Description p : _preferences)
		{
			p.resetAlteredFields();
		}
	}

	// Properties
	public UUID getUniqueID() { return _uniqueid; }
	public String getEmail() { return _email; }
	public void setEmail(String value) { _alteredfields.put("email", true); _email = value; }
	public String getUsername() { return _username; }
	public void setUsername(String value) { _alteredfields.put("username", true); _username = value; }
	public String getPassword() { return _password; }
	public void setPassword(String value) { _alteredfields.put("password", true); _password = value; }
	public String getFirstName() { return _firstname; }
	public void setFirstName(String value) { _alteredfields.put("firstname", true); _firstname = value; }
	public String getLastName() { return _lastname; }
	public void setLastName(String value) { _alteredfields.put("lastname", true); _lastname = value; }
	public String getFullName() { return _lastname + ", " + _firstname; }
	public Date getBirthday() { return _birthday; }
	public void setBirthday(Date value) { _alteredfields.put("birthday", true); _birthday = value; }
	public GeoLocation getLocation() { return _location; }
	public void setLocation(GeoLocation value) { _alteredfields.put("location", true); _location = value; }
	public Description getDescription() { return _description; }
	public void setDescription(Description value) { _alteredfields.put("description", true); _description = value; }
	public Description getPreference(int index) { return _preferences.get(index); }
	public ArrayList<Description> getPreferences() { return _preferences; }
	public void setPreferences(ArrayList<Description> value) { _alteredfields.put("preference", true); _preferences = value; }
}
