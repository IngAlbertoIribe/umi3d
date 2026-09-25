package umi3d;

import simbad.sim.*;
import javax.vecmath.Vector3d;
import simbad.sim.RangeSensorBelt;

public class MyRobot extends Agent {
    RangeSensorBelt bumpers;
    int sensorNum=0;
    public MyRobot (Vector3d position, String name) {     
        super(position,name);
    }
    public void initBehavior() {
    
    }
    
    public void performBehavior() {
        if (collisionDetected()) {
            // stop the robot
            setTranslationalVelocity(0.0);
            setRotationalVelocity(0);
        } else {
            System.out.print("Valor de sensor 0---"+bumpers.getMeasurement(sensorNum));
            // progress at 0.5 m/s
            setTranslationalVelocity(0.5);
            // frequently change orientation 
            if ((getCounter() % 100)==0) 
               setRotationalVelocity(Math.PI/2 * (0.5 - Math.random()));
        }
        
    }
}