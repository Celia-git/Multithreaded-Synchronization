
package src;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Celia Hough Project 4: Java Programming of OS Concepts
 * CPSC.2800.40676 11/09/2023
 *
 * Project 4-2
 *
 */
public class Car extends Thread {
    private String name;
    private Bridge bridge;
    private boolean crossing = false;


    public Car(String name, Bridge bridge) {
        this.name = name;
        this.bridge = bridge;
    }

    // Override from Thread: run this car 
    public void run(){
        System.out.println(String.format("%s is waiting", this.name));
        // Attempt to cross bridge
        bridge.crossBridge(this);
    }
    
    // Simulate crosssing the bridge
    public void crossBridge(int crossingTime) throws InterruptedException{
        
        setCrossing(true);
        System.out.println(String.format("%s is crossing the bridge", this.name));
        // Sleep the thread for time it takes to cross
        sleep(crossingTime);
        setCrossing(false);
        System.out.println(String.format("%s has crossed the bridge", this.name));
        
    }

    
    public Bridge getBridge() {
        return bridge;
    }

    public void setBridge(Bridge bridge) {
        this.bridge = bridge;
    }
    
    public boolean isCrossing() {
        return crossing;
    }

    public void setCrossing(boolean crossing) {
        this.crossing = crossing;
    }
     
}
