package easj.jrpg.test;


import easj.jrpg.mappers.UserMapper;

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
        UserMapper um = new UserMapper();
        System.out.println("" + um.userExists("JohnDoe69"));
    }
}
