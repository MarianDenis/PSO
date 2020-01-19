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
public class Particle {
    
    public double[] position;
    public double cost;
    public double[] velocity;
    public Particle personalBest;
    
    public Particle(double[] position, double cost, double[] velocity, Particle personalBest) {
        this.position = new double[position.length];
        this.position[0] = position[0];
        this.position[1] = position[1];
        this.cost = cost;
        
        this.velocity = new double[velocity.length];
        this.velocity[0] = velocity[0];
        this.velocity[1] = velocity[1];
        this.personalBest = personalBest;
    }
    
    public Particle(int d) {
        this.position = new double[d];
        this.cost = 0;
        this.velocity = new double[d];
        this.personalBest = null;
    }
    
    public Particle(double[] position, double cost, double[] velocity) {
        this.position = new double[position.length];
        for(int i=0;i<position.length;++i) {
            this.position[i] = position[i];
        }
        
        this.cost = cost;
        
        this.velocity = new double[velocity.length];
        for(int i=0;i<velocity.length;++i) {
            this.velocity[i] = position[i];
        }
        
        this.personalBest = null;
    }
    
}
