/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw1a;

import java.util.concurrent.Semaphore;

/**
 *
 * @author csf14fep
 */
public class MageeSemaphore {
    
    
    
    private Semaphore sem;
	
   public MageeSemaphore (int initialCount) 
   {
	sem = new Semaphore(initialCount);
   } // end constructor
	
   public void P() 
   {
	try {
	    sem.acquire();
	} catch (InterruptedException ex) {System.out.println("Interrupted when waiting");}
   } // end P()
	
   public void V() 
   {
	sem.release();
   } // end V()


    
}
