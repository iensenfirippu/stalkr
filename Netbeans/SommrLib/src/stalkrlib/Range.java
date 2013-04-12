/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stalkrlib;

/**
 *
 * @author Sommer
 */
public class Range {
    
    private int min;
    private int max;
    
    public Range(int min, int max){
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
    public boolean isWithinRange(int i) throws MaxIsMinException {
        if(max < min){
            throw new MaxIsMinException();
        }
        else if(i >= min && i <= max){
            return true;
        }
        else{
            return false;
        }
    }
}
