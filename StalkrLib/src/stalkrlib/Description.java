package stalkrlib;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Rasmus 'Sommer' Larsen
 */
public class Description {
    
    public enum Gender{ OTHER, MALE, FEMALE, HERMAPHRODITE, TRANSGENDER }
    public enum Area{ NOTSPECIFIED, JYLLAND, FYN, SJAELLAND, BORNHOLM }
    public enum Smoking{ NO, YES, OCCASIONALLY }
    public enum Drinking{ NO, YES }
    public enum Sexuality{ ASEXUAL, HETERO, HOMO, BISEXUAL }
    
    private ArrayList<Enum> gender;
    private Range age;
    private ArrayList<Enum> area;
    private ArrayList<Enum> smoking;
    private ArrayList<Enum> drinking;
    private ArrayList<Enum> sexuality;
    private String id;
	private String title;
	private Date timestamp;

    public Description(){
    
    }

    public Description(String id, String title, Date timestamp, ArrayList<Enum> gender, Range age, ArrayList<Enum> area, ArrayList<Enum> smoking, ArrayList<Enum> drinking, ArrayList<Enum> sexuality) {
        this.gender = gender;
        this.age = age;
        this.area = area;
        this.smoking = smoking;
        this.drinking = drinking;
        this.sexuality = sexuality;
        this.id = id;
		this.title = title;
		this.timestamp = timestamp;
    }
    
     public Description(String title, Date timestamp, ArrayList<Enum> gender, Range age, ArrayList<Enum> area, ArrayList<Enum> smoking, ArrayList<Enum> drinking, ArrayList<Enum> sexuality) {
        this.gender = gender;
        this.age = age;
        this.area = area;
        this.smoking = smoking;
        this.drinking = drinking;
        this.sexuality = sexuality;
        this.id = UUID.randomUUID().toString();
		this.title = title;
		this.timestamp = timestamp;
    }
    
    public double comparePreference(Description stranger){        
        return -1.0;
    }

    public ArrayList<Enum> getGender() {
        return gender;
    }

    public void setGender(ArrayList<Enum> gender) {
        this.gender = gender;
    }

    public Range getAge() {
        return age;
    }

    public void setAge(Range age) {
        this.age = age;
    }

    public ArrayList<Enum> getArea() {
        return area;
    }

    public void setArea(ArrayList<Enum> area) {
        this.area = area;
    }

    public ArrayList<Enum> getSmoking() {
        return smoking;
    }

    public void setSmoking(ArrayList<Enum> smoking) {
        this.smoking = smoking;
    }

    public ArrayList<Enum> getDrinking() {
        return drinking;
    }

    public void setDrinking(ArrayList<Enum> drinking) {
        this.drinking = drinking;
    }

    public ArrayList<Enum> getSexuality() {
        return sexuality;
    }

    public void setSexuality(ArrayList<Enum> sexuality) {
        this.sexuality = sexuality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
