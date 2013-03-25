package easj.jrpg.test;


import easj.jrpg.mappers.UserMapper;
import java.util.Date;
import stalkrlib.Description;
import stalkrlib.Description.Area;
import stalkrlib.Description.Drinking;
import stalkrlib.Description.Gender;
import stalkrlib.Description.Sexuality;
import stalkrlib.Description.Smoking;
import stalkrlib.Location;
import stalkrlib.Range;
import stalkrlib.User;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sommer
 */
public class Test {
    public static void main(String[] args){
        Description desc = new Description(Gender.values()[0], new Range(20,-1), 
                Area.values()[0],Smoking.values()[0],Drinking.values()[0],Sexuality.values()[0]);
        Description pref = new Description(Gender.values()[0], new Range(18,27), 
                Area.values()[0],Smoking.values()[0],Drinking.values()[0],Sexuality.values()[0]);
        User u = new User("SOMMERLOLOL", "Sommer", "hjort", "Rasmus", new Date(), 
                "sommerawesome@gmail.com", desc, pref, 
                new Location(7.14f,7.14f,new Date()));
        UserMapper um = new UserMapper();
        um.createUser(u);
        System.out.println("User made(?)");
    }
}
