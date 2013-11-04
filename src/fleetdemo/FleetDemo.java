/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fleetdemo;

import info.gridworld.actor.Rock;
import info.gridworld.grid.BoundedGrid;

/**
 * The main class for this demo - it creates a world, a fleet and several 
 * BounceBugs.
 * @author harlan.howe
 */
public class FleetDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Note we are creating an Notified Actor World, not just an Actor World.
        NotifiedActorWorld naWorld = new NotifiedActorWorld(new BoundedGrid(40,40));
        Fleet myFleet = new Fleet(); // create a fleet group
        naWorld.addRecipient(myFleet); // tell the world to notify myFleet 
                                     //   whenever a new step() starts.
        
        for (int i=0; i<8; i++)
        {
            BounceBug b = new BounceBug();
            naWorld.add(b);
            myFleet.add(b);  // note: I'm adding this to the fleet, as well as 
                             //       to the world.
            b.setMyFleet(myFleet); // ...and telling the bug about the fleet.
        }
        
        // gratuitous rock2 for pedagogical reasons....
        for (int j=0; j<4; j++)
        {
            naWorld.add(new Rock());// this doesn't belong in the fleet, so I'm
                                    // only adding it to the world.
        } 
                                
        naWorld.show();
    }
}
