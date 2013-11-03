
package fleetdemo;

import java.util.HashSet;
import java.util.Set;

/**
 * A collection of BounceBugs that checks the status of each one
 * and potentially sends an instruction to all of them;
 * you might wish to modify this for use with other types of actors.
 * @author harlan.howe
 */
public class Fleet implements Notifiable
{
    private Set<BounceBug> bugList;
    
    public Fleet()
    {
        bugList = new HashSet<BounceBug>();
    }
    
    public void add(BounceBug bBug)
    {
        bugList.add(bBug);
    }
    
    public void remove(BounceBug bBug)
    {
        bugList.remove(bBug);
    }
    
    public int numBugs()
    {
        return bugList.size();
    }
    
    public void clear()
    {
        bugList.clear();
    }
    
    /**
     * receives a "message" from the NotifiedActorWorld that a new step()
     * is starting. For this example, if any of the bugs have a world edge or an 
     * impassable object in front of them, then they ALL turn by (the same) 
     * random amount.
     * @param message - in this program, this will only be 
     *                  NotifiedActorWorld.STEP_BEGIN_MESSAGE, but other
     *                  programs could use additional messages.
     */
    public void handleNotification(String message)
    {
        if (message.equals(NotifiedActorWorld.STEP_BEGIN_MESSAGE))
        {
            // ---------------------------------------
            // this is the part you would customize.
            // I've written some demo code.
            for (BounceBug bb:bugList)
            {
                if (!bb.canMove())
                {
                    int angle = (int)(Math.random()*8)*45;
                    for (BounceBug bb2:bugList)
                    {
                        bb2.bounce(angle); // turns each bug by "angle"
                    }
                    break; // stop checking whether bugs can move.
                }
            }
            // end custom zone.
            //-----------------------------------------
        }
    }
}
