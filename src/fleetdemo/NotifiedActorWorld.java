package fleetdemo;


import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import java.util.HashSet;
import java.util.Set;

/**
 * A variation on ActorWorld that sends a message to one or more 
 * "Notifiable" objects whenever a step is happening.
 * @author harlan.howe
 */
public class NotifiedActorWorld extends ActorWorld
{
    private Set<Notifiable> objectsToNotify;
    public final static String STEP_BEGIN_MESSAGE = "Step Begin";
    
    public NotifiedActorWorld()
    {
        super();
        objectsToNotify = new HashSet<Notifiable>();
    }
    
    public NotifiedActorWorld(Grid<Actor> grid)
    {
        super(grid);
        objectsToNotify = new HashSet<Notifiable>();
    }
    /**
     * adds a notifiable object to the list of objects to notify.
     * @post recipient is now in the list of objects exactly once.
     * @param recipient, a Notifiable.
     * @return whether the recipient was added.
     */
    public boolean addRecipient(Notifiable recipient)
    {
        return objectsToNotify.add(recipient);
    }
    
    /**
     * removes a notifiable object from the list of objects to notify.
     * @post recipient is not in the list of objects.
     * @param recipient, a Notifiable
     * @return whether the object was originally in the list.
     */
    public boolean removeRecipient(Notifiable recipient)
    {
        return objectsToNotify.remove(recipient);
    }
    
    /**
     * removes all recipents from the list of objects to notify.
     * @post objectsToNotify is now empty.
     */
    public void clearRecipents()
    {
        objectsToNotify.clear();
    }
    
    /**
     * gets the size of the list of objects to notify
     * @return how many objects will be notified.
     */
    public int numRecipients()
    {
        return objectsToNotify.size();
    }
    
    /**
     * Calls each notifiable in the list of objects to notifiy 
     * and send the message.
     * @param message 
     */
    public void sendNotification(String message)
    {
        for (Notifiable n:objectsToNotify)
        {
            n.handleNotification(message);
        }
    }
    
    /**
     * just like the ActorWorld step() method, but it sends out a
     * STEP_BEGIN_MESSAGE to all the objects to notify first.
     */
    public void step()
    {
        sendNotification(STEP_BEGIN_MESSAGE);
        super.step();
    }
}
