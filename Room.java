import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "Space Prison Escape" application. 
 * "Space Prison Escape" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author John Burkert
 * @version April 15th 2019
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.10
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.

    private ArrayList<Item> Items;
    
    private ArrayList<Stuffs> Stuffs;
    
    private ArrayList<Npc> Npc;
    
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        Items = new ArrayList<Item>();
        Stuffs = new ArrayList<Stuffs>();
        Npc = new ArrayList<Npc>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the cell.
     *     Exits: hallway
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getItems() + getExitString();
    }
    
    /**
     * Return stuff that is in the current room.
     * @return stuff in room
     */
    public String getStuffInRoom()
    {
        return getStuff();
    }
    
    /** 
     * Gets items from the array and lists them.
     */
    public String getItems() {
        
        String itemsAvailable = "Items:"+ "\n";
        
        for(Item items : Items) {
            
            itemsAvailable += items.getInfo();
            
        }
        
        return itemsAvailable;
        
    }
    
    
    /** 
     * Gets stuff from the array and lists them.
     */
    public String getStuff() {
        
        String stuffAvailable = "Stuff in Room:";
        for(Stuffs stuffs : Stuffs) {
            
            stuffAvailable += stuffs.getStuffInfo();
            
        }
        
        return stuffAvailable;
        
    }
    
    /** 
     * Gets npcs from the array and lists them.
     */
    public String getNpc() {
        
        String npcAvailable = "Npc's in Room:";
        for(Npc npcs : Npc) {
            
            npcAvailable += npcs.getNpcInfo();
            
        }
        
        return npcAvailable;
        
    }

    /** 
     * Adds items to the array.
     */
    public void addItem(Item items) {
        
        Items.add(items);
        
    }
    
    /** 
     * Adds stuff to the array.
     */
    public void addStuff(Stuffs stuff) {
        
        Stuffs.add(stuff);
        
    }
    
    /** 
     * Adds npcs to the array.
     */
    public void addNpc(Npc npc) {
        
        Npc.add(npc);
        
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

