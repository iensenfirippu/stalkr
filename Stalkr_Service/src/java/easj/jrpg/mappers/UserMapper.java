/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package easj.jrpg.mappers;

import java.util.Date;
import stalkrlib.User;

/**
 *
 * @author Sommer
 */
public class UserMapper {
    private static final String IP_ADDRESS = "localhost";
    private static final int IP_PORT = 8123;
    
    public static void connect(){
        //NYI
    }
    
    public static void disconnect(){
        //NYI
    }
    
    public static void updateUser(int userID, String name){
        //NYI
    }
    
    public static User getUserByUsername(String username){
        //NYI
        return null;
    }
    
    public static User getUserByID(int ID){
        //NYI
        return null;
    }
    
    public static User[] getMatches(String username){
        //NYI
        double threshold = 0;
        
        User user1 = new User("Sommer", "Hjort11", "Rasmus Sommer", new Date(), "sommerawesome@gmail.com");
        User user2 = new User("Jonaz", "Hjort11", "Jonaz van der Zee", new Date(), "phandazee@gmail.com");
        User user3 = new User("Glenn", "Hjort11", "Glenn Brodersen", new Date(), "derpderp@gmail.com");
        User[] users = {user2, user3};
        User[] matches = {};
        int i = 0;
        
        for(User u : users){
            if(user1.getPreference().comparePreference(u.getDescription()) >= threshold){
                matches[i] = u;
                i++;
            }
        }
        
        return matches;
    }
}
