/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_project;
import java.lang.Math;
import java.util.Random;
/**
 *
 * @author Denis
 */
public class Problem{

    public double griewank(int d, double[] x) {
        double rez1 = 0;
        double rez2 = 1;
        double rez;
        for(int i=1; i <= d; ++i) {
            rez1 = rez1 + (x[i-1] * x[i-1]);
        }
        rez1 = rez1/4000;
        
        for(int i=1;i <= d;++i) {
            rez2 = rez2 * Math.cos(x[i-1] / Math.sqrt(i));
        }
        
        rez = 1 + rez1 - rez2; 
        return rez;
        
     
    }
    
    public double[] getDomain(int x) {
        double[] domain = new double[]{-600,600};
        return domain;
    }
   
    public static double getRandomDoubleBetweenRange(double min, double max){
        double x = (Math.random()*((max-min)+1))+min;
        return x;
    }
    
}
