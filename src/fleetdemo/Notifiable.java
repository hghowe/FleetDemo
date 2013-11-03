package fleetdemo;

/**
 * a type of object that can be send a "handleNotification" message, 
 * typically sent from a NotifiedActorWorld.
 * @author harlan.howe
 */
public interface Notifiable 
{
    public void handleNotification(String message);
}
