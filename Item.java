
/**
 * The Item class has info that gives you the name for an item and the weight for an item.
 *
 * @author John Burkert
 * @version April 12th 2019
 */
public class Item
{
    
    private String itemInfo;
    private int itemWeight;

    /**
     * Constructor for objects of class Item
     */
    public Item()
    {
        itemInfo = "";
        itemWeight = 0;
    }

    /**
     * Constructor for objects of class Item with parameters.
     */
    public Item(String information, int weight)
    {
        itemInfo = information;
        itemWeight = weight;
    }
    /**
     * Returns information for an item and it's weight in a room.
     * 
     * @return info for item and weight.
     */
    public String getInfo() {
        
     String item = "" + this.itemInfo + "\n";
     item += "Weight: " + this.itemWeight + "\n";

     return item;
        
    }
}
