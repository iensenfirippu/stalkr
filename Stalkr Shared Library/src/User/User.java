/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.util.Date;

/**
 *
 * @author Jonaz
 */
public class User {
    public String username;
    public String password;
    public String name;
    public Date birthdate;
    public String email;
    public Description description;
    public Description preference;
    public Location lastLocation;

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
