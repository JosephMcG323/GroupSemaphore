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
public class roadjunction {
    
    

    private final String[] slots = {"[..]", "[..]", "[..]", "[..]", "[..]", "[..]", "[..]", "[..]", "[..]",
        "[..]", "[..]", "[..]" , "[..]" , "[..]" , "[..]"  };

    // declare array to hold the Binary Semaphores for access to track slots (sections)
    private final MageeSemaphore slotSem[] = new MageeSemaphore[16];
    private final MageeSemaphore numCarsOnJunction;
    
    private final MageeSemaphore PrintLock;

    
    Activity thecarActivity;
    
    public roadjunction()
    {
        thecarActivity = new Activity(slots);
        for (int i = 0; i <= 12; i++) {
            slotSem[i] = new MageeSemaphore(1);
        }

        
        numCarsOnJunction = new MageeSemaphore(3);
        PrintLock =  new MageeSemaphore(1);
        
    }

    
    
    public void  CarAProcess (String name, int exitDirection) {
     // car moves to junction
     // Wait for slot [8] to be empty 
      slotSem[8].P();
      PrintLock.P();
      slots[8]= "[" + name + "]";
      
      thecarActivity.addMovedTo(8);
      PrintLock.V();

      

    // wait if the junction is full
    numCarsOnJunction.P();
    
    slotSem[6].P();
    
    PrintLock.P();
      slots[6]= slots[8];
      slots[8] = "[..]";
      thecarActivity.addMovedTo(6);  
      PrintLock.V();
      slotSem[8].V();
      
    // decide which direction to take
    switch (exitDirection) {
            case 0:
    	 // Wait for slot [7] to be empty 
                
      slotSem[7].P();
      PrintLock.P();
      slots[7]= slots[6];
      slots[6] = "[..]";
      thecarActivity.addMovedTo(7);  
      PrintLock.V();
      slotSem[6].V();
      numCarsOnJunction.V();
      
      slots[7] = "[..]";
      slotSem[7].V();
      
      
                break;
            case 1:
    	 // Wait for slot [1] to be empty 
    	 slotSem[1].P();
         
         PrintLock.P();
         
    	 slots[1] = slots[6];
         slots[6] = "[..]";
         thecarActivity.addMovedTo(1);
         PrintLock.V();
         slotSem[6].V();
         
         slotSem[9].P();
         PrintLock.P();
         slots[9] = slots[1];
         slots[1] = "[..]";
         thecarActivity.addMovedTo(9);
         PrintLock.V();
         slotSem[1].V();
         
         numCarsOnJunction.V();
         
         PrintLock.P();
         slots[9] = "[..]";
      slotSem[9].V();
      
         PrintLock.V();
         
         

	
                break;
            case 2:
                
                slotSem[1].P();
                PrintLock.P();
         
         
    	 slots[1] = slots[6];
         slots[6] = "[..]";
         thecarActivity.addMovedTo(1);
         PrintLock.V();
         slotSem[6].V();
         
         
         slotSem[2].P();
         PrintLock.P();
    	 slots[2] = slots[1];
         slots[1] = "[..]";
         thecarActivity.addMovedTo(2);
         PrintLock.V();
         slotSem[1].V();
         
        slotSem[3].P();
        PrintLock.P();
         slots[3] = slots[2];
         slots[2] = "[..]";
         thecarActivity.addMovedTo(3);
         PrintLock.V();
         slotSem[2].V();
         
         numCarsOnJunction.V();
         
         PrintLock.P();
         
         slots[3] = "[..]";
      slotSem[3].V();
            
      PrintLock.V();
                break;
            default:
                System.out.println("Invalid Direction");
        } 

} 
    public void  CarBProcess (String name, int exitDirection) {
     // car moves to junction
     // Wait for slot [8] to be empty 
      slotSem[0].P();
      PrintLock.P();
      slots[0]= "[" + name + "]";
      
      thecarActivity.addMovedTo(0);
      PrintLock.V();

      

    // wait if the junction is full
    numCarsOnJunction.P();
    
    slotSem[1].P();
    
    PrintLock.P();
      slots[1]= slots[0];
      slots[0] = "[..]";
      thecarActivity.addMovedTo(1);  
      PrintLock.V();
      slotSem[0].V();
      
    // decide which direction to take
    switch (exitDirection) {
            case 0:
    	 // Wait for slot [7] to be empty 
                
      slotSem[9].P();
      PrintLock.P();
      slots[9]= slots[1];
      slots[1] = "[..]";
      thecarActivity.addMovedTo(9);  
      PrintLock.V();
      slotSem[1].V();
      numCarsOnJunction.V();
      
      slots[9] = "[..]";
      slotSem[9].V();
      
      
                break;
            case 1:
    	 // Wait for slot [1] to be empty 
    	 slotSem[2].P();
         
         PrintLock.P();
         
    	 slots[2] = slots[1];
         slots[1] = "[..]";
         thecarActivity.addMovedTo(2);
         PrintLock.V();
         slotSem[1].V();
         
         slotSem[3].P();
         PrintLock.P();
         slots[3] = slots[2];
         slots[2] = "[..]";
         thecarActivity.addMovedTo(3);
         PrintLock.V();
         slotSem[2].V();
         
         numCarsOnJunction.V();
         
         PrintLock.P();
         slots[3] = "[..]";
      slotSem[3].V();
      
         PrintLock.V();
         
         

	
                break;
            case 2:
                
                slotSem[2].P();
                PrintLock.P();
         
         
    	 slots[2] = slots[1];
         slots[1] = "[..]";
         thecarActivity.addMovedTo(2);
         PrintLock.V();
         slotSem[1].V();
         
         
         slotSem[5].P();
         PrintLock.P();
    	 slots[5] = slots[2];
         slots[2] = "[..]";
         thecarActivity.addMovedTo(5);
         PrintLock.V();
         slotSem[2].V();
         
        slotSem[11].P();
        PrintLock.P();
         slots[11] = slots[5];
         slots[5] = "[..]";
         thecarActivity.addMovedTo(11);
         PrintLock.V();
         slotSem[5].V();
         
         numCarsOnJunction.V();
         
         PrintLock.P();
         
         slots[11] = "[..]";
      slotSem[11].V();
            
      PrintLock.V();
                break;
            default:
                System.out.println("Invalid Direction");
        } 

} 
    
     public void  CarCProcess (String name, int exitDirection) {
     // car moves to junction
     // Wait for slot [8] to be empty 
      slotSem[10].P();
      PrintLock.P();
      slots[10]= "[" + name + "]";
      
      thecarActivity.addMovedTo(10);
      PrintLock.V();

      

    // wait if the junction is full
    numCarsOnJunction.P();
    
    slotSem[2].P();
    
    PrintLock.P();
      slots[2]= slots[10];
      slots[10 ] = "[..]";
      thecarActivity.addMovedTo(2);  
      PrintLock.V();
      slotSem[10].V();
      
    // decide which direction to take
    switch (exitDirection) {
            case 0:
    	 // Wait for slot [7] to be empty 
                
      slotSem[3].P();
      PrintLock.P();
      slots[3]= slots[2];
      slots[2] = "[..]";
      thecarActivity.addMovedTo(3);  
      PrintLock.V();
      slotSem[2].V();
      numCarsOnJunction.V();
      
      slots[3] = "[..]";
      slotSem[3].V();
      
      
                break;
            case 1:
    	 // Wait for slot [1] to be empty 
    	 slotSem[5].P();
         
         PrintLock.P();
         
    	 slots[5] = slots[2];
         slots[2] = "[..]";
         thecarActivity.addMovedTo(5);
         PrintLock.V();
         slotSem[2].V();
         
         slotSem[11].P();
         PrintLock.P();
         slots[11] = slots[5];
         slots[5] = "[..]";
         thecarActivity.addMovedTo(11);
         PrintLock.V();
         slotSem[5].V();
         
         numCarsOnJunction.V();
         
         PrintLock.P();
         slots[11] = "[..]";
      slotSem[11].V();
      
         PrintLock.V();
         
         

	
                break;
            case 2:
                
                slotSem[5].P();
                PrintLock.P();
         
         
    	 slots[5] = slots[2];
         slots[2] = "[..]";
         thecarActivity.addMovedTo(5);
         PrintLock.V();
         slotSem[2].V();
         
         
         slotSem[6].P();
         PrintLock.P();
    	 slots[6] = slots[1];
         slots[5] = "[..]";
         thecarActivity.addMovedTo(6);
         PrintLock.V();
         slotSem[5].V();
         
        slotSem[7].P();
        PrintLock.P();
         slots[7] = slots[6];
         slots[6] = "[..]";
         thecarActivity.addMovedTo(7);
         PrintLock.V();
         slotSem[6].V();
         
         numCarsOnJunction.V();
         
         PrintLock.P();
         
         slots[7] = "[..]";
      slotSem[7].V();
            
      PrintLock.V();
                break;
            default:
                System.out.println("Invalid Direction");
        } 

} 
     
     public void  CarDProcess (String name, int exitDirection) {
     // car moves to junction
     // Wait for slot [8] to be empty 
      slotSem[4].P();
      PrintLock.P();
      slots[4]= "[" + name + "]";
      
      thecarActivity.addMovedTo(4);
      PrintLock.V();

      

    // wait if the junction is full
    numCarsOnJunction.P();
    
    slotSem[5].P();
    
    PrintLock.P();
      slots[5]= slots[4];
      slots[4] = "[..]";
      thecarActivity.addMovedTo(5);  
      PrintLock.V();
      slotSem[4].V();
      
    // decide which direction to take
    switch (exitDirection) {
            case 0:
    	 // Wait for slot [7] to be empty 
                
      slotSem[11].P();
      PrintLock.P();
      slots[11]= slots[5];
      slots[5] = "[..]";
      thecarActivity.addMovedTo(11);  
      PrintLock.V();
      slotSem[5].V();
      numCarsOnJunction.V();
      
      slots[11] = "[..]";
      slotSem[11].V();
      
      
                break;
            case 1:
    	 // Wait for slot [1] to be empty 
    	 slotSem[6].P();
         
         PrintLock.P();
         
    	 slots[6] = slots[5];
         slots[5] = "[..]";
         thecarActivity.addMovedTo(6);
         PrintLock.V();
         slotSem[5].V();
         
         slotSem[7].P();
         PrintLock.P();
         slots[7] = slots[6];
         slots[6] = "[..]";
         thecarActivity.addMovedTo(7);
         PrintLock.V();
         slotSem[6].V();
         
         numCarsOnJunction.V();
         
         PrintLock.P();
         slots[7] = "[..]";
      slotSem[7].V();
      
         PrintLock.V();
         
         

	
                break;
            case 2:
                
                slotSem[6].P();
                PrintLock.P();
         
         
    	 slots[6] = slots[5];
         slots[5] = "[..]";
         thecarActivity.addMovedTo(6);
         PrintLock.V();
         slotSem[5].V();
         
         
         slotSem[1].P();
         PrintLock.P();
    	 slots[1] = slots[6];
         slots[6] = "[..]";
         thecarActivity.addMovedTo(1);
         PrintLock.V();
         slotSem[6].V();
         
        slotSem[9].P();
        PrintLock.P();
         slots[9] = slots[1];
         slots[1] = "[..]";
         thecarActivity.addMovedTo(9);
         PrintLock.V();
         slotSem[1].V();
         
         numCarsOnJunction.V();
         
         PrintLock.P();
         
         slots[9] = "[..]";
      slotSem[9].V();
            
      PrintLock.V();
                break;
            default:
                System.out.println("Invalid Direction");
        } 

} 
    
    
    
}



 
 

