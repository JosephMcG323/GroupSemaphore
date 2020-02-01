/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw1a;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author csf14fep
 */
public class CW1a {
    
    
    
    static final int A_car =10;
    static final int B_car = 10;
    static final int C_car = 10;
    static final int D_car = 10;
    static roadjunction Theroadjunction;
    

    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        // create a train track
        Theroadjunction = new roadjunction();

        System.out.println("STARTED");

        // create arrays to hold the trains 
        MoveCarA[] MoveCarA = new MoveCarA[A_car];
        
        MoveCarB[] MoveCarB = new MoveCarB[B_car];
        
        MoveCarC[] MoveCarC = new MoveCarC[C_car];
        
        MoveCarD[] MoveCarD = new MoveCarD[D_car];
        

        // create trains to enter the track
        for (int i = 0; i < A_car; i++) {
            
            MoveCarA[i] = new MoveCarA("A" + i, ThreadLocalRandom.current().nextInt(0,2+1), Theroadjunction);
        }
        for (int i = 0; i < B_car; i++) {
            
            MoveCarB[i] = new MoveCarB("B" + i, ThreadLocalRandom.current().nextInt(0,2+1), Theroadjunction);
        }
        
        for (int i = 0; i < C_car; i++) {
            
            MoveCarC[i] = new MoveCarC("C" + i, ThreadLocalRandom.current().nextInt(0,2+1), Theroadjunction);
        }
        for (int i = 0; i < D_car; i++) {
            
            MoveCarD[i] = new MoveCarD("D" + i, ThreadLocalRandom.current().nextInt(0,2+1), Theroadjunction);
        }

        // set the train processes running
        for (int i = 0; i < A_car; i++) {
            MoveCarA[i].start();
        } // end for 
        
        for (int i = 0; i < B_car; i++) {
            MoveCarB[i].start();
        } // end for 
        
        for (int i = 0; i < C_car; i++) {
            MoveCarC[i].start();
        }
        
         for (int i = 0; i < D_car; i++) {
            MoveCarD[i].start();
        }

	       // trains now travelling    
        //  wait for all the train threads to finish before printing out final message. 
        for (int i = 0; i < A_car; i++) {
            try {
                MoveCarA[i].join();
            } catch (InterruptedException ex) {
            }
        } // end for 

        for (int i = 0; i < B_car; i++) {
            try {
                MoveCarB[i].join();
            } catch (InterruptedException ex) {
            }
        } // end for    
        
        for (int i = 0; i < C_car; i++) {
            try {
                MoveCarC[i].join();
            } catch (InterruptedException ex) {
            }
        } 
        
         for (int i = 0; i < D_car; i++) {
            try {
                MoveCarD[i].join();
            } catch (InterruptedException ex) {
            }
        } 

        // Display all the train activity that took place
        Theroadjunction.thecarActivity.printActivities();

        // Final message
        System.out.println("All trains have successfully travelled 5 circuits of their track loop ");
    } // end main     

    private static int ThreadLocalRandom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

} // end TrainsOnTrack class

        
        
        
        
        
        // TODO code application logic here
   // }
    
//}
