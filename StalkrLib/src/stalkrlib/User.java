package stalkrlib;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Rasmus 'Sommer' Larsen
 */
public class User {
    private String username;
    private String password;
    
    private UUID id;
    private String name;
    private Date birthdate;
    private String email;
    private Description description;
    private Description preference;
    
    private Location lastLocation;
    
    /**
     * Constructor to make new User with no preference profile.
     * 
     * @param username
     * @param password
     * @param name
     * @param birthdate
     * @param email 
     */
    public User(String username, String password, String name, Date birthdate, String email) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthdate = birthdate;
        this.email = email;
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
    public User(UUID id, String username, String password, String name, Date birthdate, String email, Description description, Description preference, Location lastLocation) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthdate = birthdate;
        this.email = email;
        this.description = description;
        this.preference = preference;
        this.lastLocation = lastLocation;
    }

    public UUID getId() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Description getPreference() {
        return preference;
    }

    public void setPreference(Description preference) {
        this.preference = preference;
    }

    public Location getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(Location lastLocation) {
        this.lastLocation = lastLocation;
    }
    
}
