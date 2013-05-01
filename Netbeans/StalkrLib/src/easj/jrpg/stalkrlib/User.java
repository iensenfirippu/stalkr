/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easj.jrpg.stalkrlib;

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
	private String _email = "";
	private String _username = "";
	private String _password = "";
	private String _firstname = "";
	private String _lastname = "";
	private Date _birthday = new Date();
	private GeoLocation _location = new GeoLocation();
	private Description _description = new Description();
	private ArrayList<Description> _preferences = new ArrayList<Description>();

	private Map<String, Boolean> _alteredfields;

	// Constructors
	public User()
	{
		_uniqueid = UUID.randomUUID();
		setAlteredFields();
	}
	public User(UUID uuid)
	{
		_uniqueid = uuid;
		setAlteredFields();
	}
	
	private void setAlteredFields()
	{
		_alteredfields = new HashMap<String, Boolean>();
		resetAlteredFields();
	}
	
	public void resetAlteredFields()
	{
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
	
	@Override public String toString() { return _username; }

	// isChanged methods
	public boolean isChangedUniqueID() { return _alteredfields.get("uniqueid"); }
	public boolean isChangedEmail() { return _alteredfields.get("email"); }
	public boolean isChangedUsername() { return _alteredfields.get("username"); }
	public boolean isChangedPassword() { return _alteredfields.get("password"); }
	public boolean isChangedFirstName() { return _alteredfields.get("firstname"); }
	public boolean isChangedLastName() { return _alteredfields.get("lastname"); }
	public boolean isChangedBirthday() { return _alteredfields.get("birthday"); }
	public boolean isChangedLocation() { return _alteredfields.get("location"); }
	public boolean isChangedDescription() { return _alteredfields.get("description"); }
	public boolean isChangedPreferences() { return _alteredfields.get("preferences"); }

	// Accessor methods
	public UUID getUniqueID() { return _uniqueid; }
	public String getEmail() { return _email; }
	public String getUsername() { return _username; }
	public String getPassword() { return _password; }
	public String getFirstName() { return _firstname; }
	public String getLastName() { return _lastname; }
	public Date getBirthday() { return _birthday; }
	public GeoLocation getLocation() { return _location; }
	public Description getDescription() { return _description; }
	public ArrayList<Description> getPreferences() { return _preferences; }
	
	// Mutator methods
	public void setEmail(String value) { _alteredfields.put("email", true); _email = value; }
	public void setUsername(String value) { _alteredfields.put("username", true); _username = value; }
	public void setPassword(String value) { _alteredfields.put("password", true); _password = value; }
	public void setFirstName(String value) { _alteredfields.put("firstname", true); _firstname = value; }
	public void setLastName(String value) { _alteredfields.put("lastname", true); _lastname = value; }
	public void setBirthday(Date value) { _alteredfields.put("birthday", true); _birthday = value; }
	public void setLocation(GeoLocation value) { _alteredfields.put("location", true); _location = value; }
	public void setDescription(Description value) { _alteredfields.put("description", true); _description = value; }
	public void setPreferences(ArrayList<Description> value) { _alteredfields.put("preference", true); _preferences = value; }
	
	// Seudo fields
	public String getFullName() { return _lastname + ", " + _firstname; }
	
	// Deprecated fields
	@Deprecated public Description getPreference(int index) { return _preferences.get(index); }
	@Deprecated public void setPreference(Description value) { _alteredfields.put("preference", true); _preferences.clear(); _preferences.add(value); }
}
