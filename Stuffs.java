
/**
 * Write a description of class Key here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Stuffs
{
    // instance variables - replace the example below with your own
    private String stuffInfo;

    /**
     * Constructor for objects of class Key
     */
    public Stuffs()
    {
        stuffInfo = "";
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Stuffs(String information)
    {
        stuffInfo = information;
    }
    
    public String getStuffInfo() {
        
     String stuff = "" + this.stuffInfo + "\n";
     
     return stuff;
        
    }
}
