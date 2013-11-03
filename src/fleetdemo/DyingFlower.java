/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fleetdemo;

import info.gridworld.actor.Flower;
import java.awt.Color;

/**
 * A flower of a limited lifetime.
 * @author harlan.howe
 */
public class DyingFlower extends Flower{
    
    public DyingFlower(Color c)
    {
        super(c);
    }
    
    /**
     * darkens like a normal flower, but dies if it gets to black.
     */
    public void act()
    {
        super.act();
        if (getColor().equals(Color.BLACK))
            removeSelfFromGrid();
    }
    
}
