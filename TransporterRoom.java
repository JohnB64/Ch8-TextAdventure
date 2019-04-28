
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Chooses a random room and and sends the player to that room.
 *
 * @author John Burkert
 * @version April 22nd 2019
 */
public class TransporterRoom extends Room
{
    private Room randomroom;
    /**
     * Constructor for objects of class TransporterRoom
     */
    public TransporterRoom(String description) {
        
         super(description);
         Random room = new Random();
    }    
    
    /**
     * Returns a random room
     */
    public Room getExit(String direction)
    {
        return findRandomRoom();
    }

    /**
     * Randomly chooses a random room
     */
    private Room findRandomRoom()
    {

        return randomroom;
    }
    
    
}
