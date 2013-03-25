package stalkrlib;

import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    private Gender gender;
    private Range age;
    private Area area;
    private Smoking smoking;
    private Drinking drinking;
    private Sexuality sexuality;
    private UUID id;

    public Description(Gender gender, Range age, Area area, Smoking smoking, Drinking drinking, Sexuality sexuality) {
        this.gender = gender;
        this.age = age;
        this.area = area;
        this.smoking = smoking;
        this.drinking = drinking;
        this.sexuality = sexuality;
        this.id = UUID.randomUUID();
    }
    
    public double comparePreference(Description stranger){        
        int searchParams = 6;
        int matches = 0;
        
        try {
            if(age.isWithinRange(stranger.age.getMin())){
                matches++;
            }
        } 
        catch (MaxIsMinException ex) {
            return 0;
        }
        
        if(gender == stranger.gender){
            matches++;
        }
        
        if(area == stranger.area){
            matches++;
        }
        
        if(smoking == stranger.smoking){
            matches++;
        }
        
        if(drinking == stranger.drinking){
            matches++;
        }
        
        if(sexuality == stranger.sexuality){
            matches++;
        }
        
        return (matches / searchParams) * 100;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Range getAge() {
        return age;
    }

    public void setAge(Range age) {
        this.age = age;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Smoking getSmoking() {
        return smoking;
    }

    public void setSmoking(Smoking smoking) {
        this.smoking = smoking;
    }

    public Drinking getDrinking() {
        return drinking;
    }

    public void setDrinking(Drinking drinking) {
        this.drinking = drinking;
    }

    public Sexuality getSexuality() {
        return sexuality;
    }

    public void setSexuality(Sexuality sexuality) {
        this.sexuality = sexuality;
    }

    public UUID getId() {
        return id;
    }

}
