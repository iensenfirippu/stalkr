package stalkrlib;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import stalkrlib.Description.*;

/**
 *
 * @author Rasmus 'Sommer' Larsen
 */
public class User {
    private String username;
    private String password;
    
    private String id;
    private String firstname;
    private String lastname;
	@Deprecated
	private String display;
    private Date birthdate;
    private String email;
    private Description description;
    @Deprecated
	private Description preference;
    private ArrayList<Description> preferences;
    
    private Location lastLocation;
	
    public User(String id) {
        this.id = id;
		preferences = new ArrayList<Description>();
    }
    
    /**
     * Constructor to make new User with no preference profile.
     * 
     * @param username
     * @param password
     * @param firstname
     * @param lastname
     * @param birthdate
     * @param email 
     */
    public User(String username, String display, String password, String firstname, String lastname, Date birthdate, String email) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.display = display;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.email = email;
		preferences = new ArrayList<Description>();
    }

    /**
     * Constructor to make (or clone) a full User object with a preference profile.
     * 
     * @param username
     * @param password
     * @param name
     * @param birthdate
     * @param email
     * @param description
     * @param preference
     * @param lastLocation 
     */
    public User(String username, String display, String password, String firstname, String lastname, Date birthdate, String email, Description description, Description preference, Location lastLocation) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.display = display;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.email = email;
        this.description = description;
		preferences = new ArrayList<Description>();
        this.preferences.add(preference);
        this.lastLocation = lastLocation;
    }
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.id)																			.append("|");
		sb.append(this.email)																		.append("|");
		sb.append(this.username)																	.append("|");
		sb.append(this.password)																	.append("|");
		sb.append(this.firstname)																	.append("|");
		sb.append(this.lastname)																	.append("|");
		sb.append(Long.toString(this.birthdate.getTime() / 1000))									.append("|");
		sb.append(Float.toString(this.lastLocation.getLatitude()))									.append("|");
		sb.append(Float.toString(this.lastLocation.getLongitude()))										.append("|");
		sb.append(Long.toString(this.lastLocation.getTime().getTime()))								.append("|");
		sb.append(Long.toString(this.description.getTimestamp().getTime()))							.append("|");
		sb.append(this.description.getTitle())														.append("|");
		sb.append(Integer.toString(this.description.getAge().getMin()))								.append("|");
		sb.append(Integer.toString(this.description.getAge().getMax()))								.append("|");
		sb.append(EnumMapper.enumListToString(Gender.OTHER, this.description.getGender()))			.append("|");
		sb.append(EnumMapper.enumListToString(Sexuality.ASEXUAL, this.description.getSexuality()))	.append("|");
		sb.append(EnumMapper.enumListToString(Area.NOTSPECIFIED, this.description.getArea()))		.append("|");
		sb.append(EnumMapper.enumListToString(Smoking.NO, this.description.getSmoking()))			.append("|");
		sb.append(EnumMapper.enumListToString(Drinking.NO, this.description.getDrinking()))			;
		for (Description p : this.preferences)
		{
			sb.append("{");
			sb.append(p.getId())																	.append("|");
			sb.append(Long.toString(p.getTimestamp().getTime() / 1000))								.append("|");
			sb.append(p.getTitle())																	.append("|");
			sb.append(Integer.toString(p.getAge().getMin()))										.append("|");
			sb.append(Integer.toString(p.getAge().getMax()))										.append("|");
			sb.append(EnumMapper.enumListToString(Gender.OTHER, p.getGender()))						.append("|");
			sb.append(EnumMapper.enumListToString(Sexuality.ASEXUAL, p.getSexuality()))				.append("|");
			sb.append(EnumMapper.enumListToString(Area.NOTSPECIFIED, p.getArea()))					.append("|");
			sb.append(EnumMapper.enumListToString(Smoking.NO, p.getSmoking()))						.append("|");
			sb.append(EnumMapper.enumListToString(Drinking.NO, p.getDrinking()))					;
		}
		
		return sb.toString();
	}
	
	public static User fromString(String s)
	{
		String[] parts = s.split("\\{");
		String[] ss = parts[0].split("\\|");
		
		User u = new User(ss[0]);
		u.setEmail(ss[1]);
		u.setUsername(ss[2]);
		u.setPassword(ss[3]);
		u.setFirstName(ss[4]);
		u.setLastName(ss[5]);
		u.setBirthdate(new Date(Long.parseLong(ss[6]) * 1000));
		Location l = new Location(
			Float.parseFloat(ss[7]), 
			Float.parseFloat(ss[8]), 
			new Date(Long.parseLong(ss[9]))
		);
		u.setLastLocation(l);
		Description d = new Description();
		d.setId(ss[0]);
		d.setTimestamp(new Date(Long.parseLong(ss[10]) * 1000));
		d.setTitle(ss[11]);
		Range dr = new Range(Integer.parseInt(ss[12]), (Integer.parseInt(ss[13])));
		d.setAge(dr);
		d.setGender(EnumMapper.stringToEnumList(Gender.OTHER, ss[14]));
		d.setSexuality(EnumMapper.stringToEnumList(Sexuality.ASEXUAL, ss[15]));
		d.setArea(EnumMapper.stringToEnumList(Area.NOTSPECIFIED, ss[16]));
		d.setSmoking(EnumMapper.stringToEnumList(Smoking.NO, ss[17]));
		d.setDrinking(EnumMapper.stringToEnumList(Drinking.NO, ss[18]));
		u.setDescription(d);
		
		for (int i = 1; i < parts.length; i++)
		{
			ss = parts[i].split("\\|");
			
			Description p = new Description();
			p.setId(ss[0]);
			p.setTimestamp(new Date(Long.parseLong(ss[1]) * 1000));
			p.setTitle(ss[2]);
			Range pr = new Range(Integer.parseInt(ss[3]), (Integer.parseInt(ss[4])));
			p.setAge(pr);
			p.setGender(EnumMapper.stringToEnumList(Gender.OTHER, ss[5]));
			p.setSexuality(EnumMapper.stringToEnumList(Sexuality.ASEXUAL, ss[6]));
			p.setArea(EnumMapper.stringToEnumList(Area.NOTSPECIFIED, ss[7]));
			p.setSmoking(EnumMapper.stringToEnumList(Smoking.NO, ss[8]));
			p.setDrinking(EnumMapper.stringToEnumList(Drinking.NO, ss[9]));
			u.getPreferences().add(p);
		}
		
		return u;
	}

	@Deprecated
    public String getDisplay() {
        return display;
    }

	@Deprecated
    public void setDisplay(String display) {
        this.display = display;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

	@Deprecated
    public Description getPreference() {
        return preferences.get(0);
    }

	@Deprecated
    public void setPreference(Description preference) {
        this.preferences.set(0, preference);
    }

    public Description getPreference(int index) {
        return preferences.get(index);
    }

    public ArrayList<Description> getPreferences() {
        return preferences;
    }

    public void setPreferences(ArrayList<Description> preferences) {
        this.preferences = preferences;
    }

    public Location getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(Location lastLocation) {
        this.lastLocation = lastLocation;
    }
    
}
