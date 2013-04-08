/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stalkrlib;

import java.util.ArrayList;

/**
 *
 * @author Sommer
 */
public class EnumTest {
    public enum Gender{ OTHER, MALE, FEMALE, HERMAPHRODITE, TRANSGENDER }

    public static void main(String[] args){
        new EnumTest();
    }
    
    public EnumTest() {
        String s = "11010";
        System.out.println("Original String: " + s);
        ArrayList<Enum> enums = EnumMapper.stringToEnumList(Gender.OTHER, s);
        System.out.println(enums.toString());
        String ns = EnumMapper.enumListToString(Gender.OTHER, enums);
        System.out.println(ns);
    }
    
    
    
}
