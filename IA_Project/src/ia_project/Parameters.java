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
public class Parameters {
    
    public int nrOfParticles;
    public int d;
    public double maxVelocity;
    public double w;    //inertia
    public double c1;
    public double c2;
    public int nrOfIterations;
    
    public Parameters(int nrOfParticles, int d, double maxVelocity, double w,
            double c1, double c2, int nrOfIterations) {
        
        this.nrOfParticles = nrOfParticles;
        this.d = d;
        this.maxVelocity = maxVelocity;
        this.w = w;
        this.c1 = c1;
        this.c2 = c2;
        this.nrOfIterations = nrOfIterations;
    }
    
    public Parameters() {
        
    }
}
