package stalkrlib;

import java.util.ArrayList;
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

    public Description(Gender gender, Range age, Area area, Smoking smoking, Drinking drinking, Sexuality sexuality) {
        this.gender = gender;
        this.age = age;
        this.area = area;
        this.smoking = smoking;
        this.drinking = drinking;
        this.sexuality = sexuality;
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
    
}
