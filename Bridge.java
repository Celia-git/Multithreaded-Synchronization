
package src;

import src.Car;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
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
public class Bridge {

    private boolean inUse = false;
    private int crossingTime = 1000;
    private Lock lock = new ReentrantLock();

    // Simulate car crossing bridge
    public synchronized void crossBridge(Car car) {
        
        // Lock the bridge, Cross one car
        lock.lock();
        
        try {
            // Car Cross bridge
            car.crossBridge(crossingTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(Bridge.class.getName()).log(Level.SEVERE, null, ex);
        }
        setInUse(true);
        
         // Release the bridge whe  car is done crossing
        while (car.isCrossing()){
            try {
                lock.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Bridge.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setInUse(false);
        
        // Notify waiting threads
        synchronized(lock){
            lock.unlock();
            lock.notifyAll();
        }


    }

   
    
    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public int getCrossingTime() {
        return crossingTime;
    }

    public void setCrossingTime(int crossingTime) {
        this.crossingTime = crossingTime;
    }

}
