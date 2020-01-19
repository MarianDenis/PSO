/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_project;

/**
 *
 * @author Denis
 */
public class Functii {
    public double limit(double val, double min, double max) {
        if(val < min) {
            return min;
        } else if (val > max){
            return max;
        } else {
            return val;
        }
    }
    
}
