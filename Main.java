

import Car;
import Bridge;

/**
 *
 * @author Celia Hough Project 4: Java Programming of OS Concepts
 * CPSC.2800.40676 11/09/2023
 *
 * Project 4-2
 *
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a traffic jam at the bridge
        int trafficSize = 15;
        
        Bridge bridge = new Bridge();
        
        // Simulate vehicles travelling
        for (int i=0; i < trafficSize; i++){
            Car westboundVehicle = new Car(String.format("westbound car %d", i), bridge);
            Car eastboundVehicle = new Car(String.format("eastbound car %d", i), bridge);
            westboundVehicle.start();
            eastboundVehicle.start();
        }
        
    }
    
}

