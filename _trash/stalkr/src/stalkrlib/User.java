/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stalkrlib;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
		setDefaultValues();
		setAlteredValues();
	}
	public User(UUID uuid)
	{
		_uniqueid = uuid;
		setAlteredValues();
	}
	
	// Constructor called methods
	private void setDefaultValues()
	{
		_birthday = new Date(0);
		_location = new GeoLocation();
		_description = new Description();
		_preferences = new ArrayList<Description>();
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
	public ArrayList<Description> getPreferences() { return _preferences; }
	public void setPreferences(ArrayList<Description> value) { _alteredfields.put("preference", true); _preferences = value; }
}
