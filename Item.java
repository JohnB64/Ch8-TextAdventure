
/**
 * Write a description of class Item here.
 *
 * @author John Burkert
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
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
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Item(String information)
    {
        itemInfo = information;
    }
    
    public String getInfo() {
        
     String item = "" + this.itemInfo + "\n";
     
     return item;
        
    }
}
