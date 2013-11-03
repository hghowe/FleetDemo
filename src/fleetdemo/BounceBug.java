
package fleetdemo;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;

/**
 * A bug that drops Dying flowers instead of regular ones and which
 * might be told to turn a specific amount by its Fleet.
 * @author harlan.howe
 */
public class BounceBug extends Bug
{
    
    private Fleet myFleet;
    /**
     * creates this bug with a random direction and color.
     */
    public BounceBug()
    {
        super();
        setDirection((int)(Math.random()*8)*45);
        setColor(new Color((float)(Math.random()),
                           (float)(Math.random()),
                           (float)(Math.random()),
                           (float)1.0));
    }
    
    public void setMyFleet(Fleet f)
    {
        myFleet = f;
    }
    
    /**
     * if, for some reason, we need to remove this bug from the grid,
     * we'll remove it from the Fleet, too.
     */
    public void removeSelfFromGrid()
    {
        super.removeSelfFromGrid();
        myFleet.remove(this);
    }
    
    
    /**
     * turns this bug by the specified angle.
     * @param angle 
     */
    public void bounce(int angle)
    {
        setDirection((getDirection()+angle)%Location.FULL_CIRCLE);        
    }
    
    
    // This is just like the default move() method, except it drops
    //    DyingFlowers.
    public void move()
      {
        Grid<Actor> gr = getGrid();
        if (gr == null)
          return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
          moveTo(next);
        else
          removeSelfFromGrid();
        Flower flower = new DyingFlower(getColor());
        flower.putSelfInGrid(gr, loc);
    }
    
    
}
    
