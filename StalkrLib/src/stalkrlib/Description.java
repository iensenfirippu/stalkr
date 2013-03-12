package stalkrlib;

/**
 *
 * @author Rasmus 'Sommer' Larsen
 */
public class Description {
    
    public enum Gender{ MALE, FEMALE, BOTH, NONE }
    public enum Area{ JYLLAND, FYN, SJÆLLAND, BORNHOLM }
    
    private Gender gender;
    private int age;
    private Area area;

    public Description(Gender gender, int age, Area area) {
        this.gender = gender;
        this.age = age;
        this.area = area;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    
    public double comparePreference(Description stranger){        
        int searchParams = 3;
        int matches = 0;
        
        if(this.gender == stranger.getGender()){
            matches++;
        }
        
        if(this.area == stranger.getArea()){
            matches++;
        }
        
        if(this.age == stranger.getAge()){
            matches++;
        }
        
        return (matches / searchParams) * 100;
    }
    
}
