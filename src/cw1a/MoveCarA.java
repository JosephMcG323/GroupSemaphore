/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw1a;

/**
 *
 * @author csf14fep
 */
public class MoveCarA extends Thread {
    
    String carname;
    int exitdirection;
     roadjunction roadjunction;
     
     public MoveCarA(String name, int direction, roadjunction junction)
     {
         this.roadjunction = junction;
         this.carname = name;
         this.exitdirection = direction;
         
     }
     
    public void run()
    {
        roadjunction.CarAProcess(carname, exitdirection);
        
    }
    
    
    
    
}
