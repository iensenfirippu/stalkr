package stalkrlib;

import java.util.Date;

/**
 *
 * @author Rasmus 'Sommer' Larsen
 */
public class Location {
    
    private float latitude;
    private float longitude;
    private Date time;

    public Location(float latitude, float longitude, Date time) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
