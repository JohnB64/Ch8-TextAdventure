
/**
 * Write a description of class Key here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Objects
{
    // instance variables - replace the example below with your own
    private String objectInfo;

    /**
     * Constructor for objects of class Key
     */
    public Objects()
    {
        objectInfo = "";
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Objects(String information)
    {
        objectInfo = information;
    }
    
    public String getObjectInfo() {
        
     String object = "" + this.objectInfo + "\n";
     
     return object;
        
    }
}
