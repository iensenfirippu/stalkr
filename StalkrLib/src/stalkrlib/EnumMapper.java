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

public class EnumMapper <T extends Enum>{
    
    public ArrayList<Enum> stringToEnumList(T e, String s){
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
    
    public String enumListToString(T e, ArrayList<Enum> enums){
        Enum[] ea = e.getClass().getEnumConstants();
        String s = "";
        for(int i = 0; i < ea.length; i++){
            if(enums.get(i) == ea[i]){
                s = s + "1";
            }
            else{
                s = s + "0";
            }
        }
        return s;
    }

    
    
    
}