
/**
 * Write a description of class Npc here.
 *
 * @author John Burkert
 * @version April 12th 2019
 */
public class Npc
{
    
    private String npcInfo;

    /**
     * Constructor for objects of class Npc
     */
    public Npc()
    {
        npcInfo = "";
    }

    /**
     * Constructor for objects of class Npc with parameters
     */
    public Npc(String information)
    {
        npcInfo = information;
    }
    
    /**
     * Returns information for npcs in a room.
     * 
     * @return info for npc
     */
    public String getNpcInfo() {
        
     String npc = "" + this.npcInfo + "\n";
     
     return npc;
        
    }
}
