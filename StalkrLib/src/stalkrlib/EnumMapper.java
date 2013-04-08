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

public class EnumMapper {
    
    public static ArrayList<Enum> stringToEnumList(Enum e, String s){
        Enum[] ea = e.getClass().getEnumConstants();
        char[] ca = s.toCharArray();
        ArrayList<Enum> enums = new ArrayList();
        for(int i = 0; i < ea.length; i++){
            if(ca[i] == '1'){
                enums.add(ea[i]);
            }
        }
        return enums;
    }
    
    public static String enumListToString(Enum e, ArrayList<Enum> enums){
        Enum[] ea = e.getClass().getEnumConstants();
        String s = "";
        int j = 0;
        for(int i = 0; i < ea.length; i++){
            if(j == enums.size()){
                s = s + "0";
            }
            else if(enums.get(j) == ea[i]){
                s = s + "1";
                j++;
            }
            else{
                s = s + "0";
            }
        }
        return s;
    }
    
}