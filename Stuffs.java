
/**
 * The Stuffs class has info that can be accesed when you examine the room
 *
 * @author John Burkert
 * @version April 12th 2019
 */
public class Stuffs
{
    // instance variables - replace the example below with your own
    private String stuffInfo;

    /**
     * Constructor for objects of class Stuffs
     */
    public Stuffs()
    {
        stuffInfo = "";
    }

    /**
     * Constructor for objects of class Stuffs with parameters.
     */
    public Stuffs(String information)
    {
        stuffInfo = information;
    }
    
    /**
     * Returns information for stuff in a room.
     * 
     * @return info for stuff
     */
    public String getStuffInfo() {
        
     String stuff = "" + this.stuffInfo + "\n";
     
     return stuff;
        
    }
}
