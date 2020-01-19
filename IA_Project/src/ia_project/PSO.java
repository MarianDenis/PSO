/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia_project;
import java.util.Random;
import java.lang.Math;
/**
 *
 * @author Denis
 */
public class PSO {
 
    public Particle optimize(Problem problem, Parameters parameters) {
        
        
        Particle[] swarm = this.initSwarm(problem, parameters);
        Particle socialBest = getSocialBest(problem, swarm);
        
        for(int i=0; i <parameters.nrOfIterations; ++i) {
           for(int j=0; j < swarm.length; ++j) {
              
               
               double r1 = new Random().nextDouble();
               double r2 = new Random().nextDouble();
               
              
               for(int k=0; k<parameters.d; ++k) {
                   
                   swarm[j].velocity[k] = parameters.w * swarm[j].velocity[k] +
                           parameters.c1 * r1 * (swarm[j].personalBest.position[k] - swarm[j].position[k]) +
                           parameters.c2 * r2 * (socialBest.position[k] - swarm[j].position[k]);
                   
            
                   swarm[j].velocity[k] = new Functii().limit(swarm[j].velocity[k], -parameters.maxVelocity, parameters.maxVelocity);
                   
                   swarm[j].position[k] = swarm[j].position[k] + swarm[j].velocity[k];
             
                   swarm[j].position[k] = new Functii().limit(swarm[j].position[k],
                               problem.getDomain(k)[0], problem.getDomain(k)[1]);
                   }
                   
             
                   swarm[j].cost = problem.griewank(parameters.d ,swarm[j].position);
                   
                   if(swarm[j].cost <= swarm[j].personalBest.cost) {
                      
                       swarm[j].personalBest = new Particle(swarm[j].position,swarm[j].cost, swarm[j].velocity);
                       if(swarm[j].cost < socialBest.cost) {
                           socialBest = new Particle(swarm[j].position,swarm[j].cost, swarm[j].velocity);
                    }
                }           
           }
        }
        return socialBest;
    }
    
    public Particle[] initSwarm(Problem problem, Parameters parameters) {

        Particle[] swarm = new Particle[parameters.nrOfParticles];
       
        for(int i=0;i < parameters.nrOfParticles; ++i) {
            Particle p = new Particle(parameters.d);
   
            for(int j=0; j < parameters.d; ++j){
                double[] limite = new double[2];
                limite[0] = problem.getDomain(j)[0];
                limite[1] = problem.getDomain(j)[1];
                p.position[j] = Problem.getRandomDoubleBetweenRange(limite[0], limite[1]);
               
                p.velocity[j] = 0;
            }
           
            
            p.cost = problem.griewank(parameters.d, p.position);    
            p.personalBest = p;
            swarm[i] = p;
        }
        
        return swarm;
    }
    
    public Particle getSocialBest(Problem problem ,Particle[] swarm) {
        double min = swarm[0].cost;
        int index = 0;
        for(int i=1; i<swarm.length; ++i){
           
            if (min > swarm[i].cost){
                min = swarm[i].cost;
                index = i;
            }
        }
        return swarm[index];
    }
}
