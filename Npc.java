
/**
 * Write a description of class Npc here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Npc
{
    // instance variables - replace the example below with your own
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
