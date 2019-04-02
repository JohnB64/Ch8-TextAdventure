
/**
 * Write a description of class Key here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String itemInfo;

    /**
     * Constructor for objects of class Key
     */
    public Item()
    {
        itemInfo = "";
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
