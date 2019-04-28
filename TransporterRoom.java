
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
        
        Random room = new Random();
        
       // Room randomroom = room.nextInt();

        randomroom = super.getExit("cell_door");
        randomroom = super.getExit("prison_cell_2");
        randomroom = super.getExit("prison_cell_3");
        randomroom = super.getExit("prison_cell_4");
        randomroom = super.getExit("your_cell");
        randomroom = super.getExit("hanger_door");
        randomroom = super.getExit("office_door");
        randomroom = super.getExit("center_hallway");
        randomroom = super.getExit("right_hallway");
        randomroom = super.getExit("left_hallway");
        randomroom = super.getExit("air_lock_door");
        randomroom = super.getExit("storage_door");
        randomroom = super.getExit("bathroom");
        randomroom = super.getExit("spaceship_area");
        randomroom = super.getExit("cargo_area");
        randomroom = super.getExit("vehicle_area");
        randomroom = super.getExit("space_ship");
        randomroom = super.getExit("spaceship_cockpit");
        
        
        
        return randomroom;
    }
    
    
}
