
/**
 * Write a description of class Key here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Npc
{
    // instance variables - replace the example below with your own
    private String npcInfo;

    /**
     * Constructor for objects of class Key
     */
    public Npc()
    {
        npcInfo = "";
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Npc(String information)
    {
        npcInfo = information;
    }
    
    public String getNpcInfo() {
        
     String npc = "" + this.npcInfo + "\n";
     
     return npc;
        
    }
}
