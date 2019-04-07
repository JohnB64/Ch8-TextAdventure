/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.10
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room cell, hallway, hanger, storage, ship, escape;
        
        Item cellKey[] = {new Item("Key")};
        
        Stuffs bed[] = {new Stuffs("Bed")};
        Stuffs toilet[] = {new Stuffs("Toilet")};
        
        
        
        
      
        // create the rooms
        cell = new Room("in a Prison Cell");
        hallway = new Room("in the Hallway");
        hanger = new Room("in the SpaceShip Hanger");
        storage = new Room("in the Sorage Room");
        ship = new Room("in a SpaceShip");
        escape = new Room("Have Escaped");
        
        
        
        
        // initialise room exits
        cell.setExit("cell_door", hallway);
        cell.setExit("window", hallway);

        hallway.setExit("hanger_door", hanger);
        hallway.setExit("storage_door", storage);

        hanger.setExit("spaceship_area", ship);

        ship.setExit("spaceship_cockpit", escape);
        
        
        
        cell = addItems(cell, cellKey);
        
        cell = addStuff(cell, bed);
        cell = addStuff(cell, toilet);
        
        

        

        currentRoom = cell;  // start game outside
    }
    
    private Room addItems(Room room, Item items[]) {
        
        
        //Implement a while loop here instead.
        
        for(int i = 0; i < items.length; i++) {
            
            room.addItem(items[i]);
            
        }
        
        return room;
        
        
    }
    
    private Room addStuff(Room room, Stuffs stuffs[]) {
        
        
        //Implement a while loop here instead.
        
        for(int i = 0; i < stuffs.length; i++) {
            
            room.addStuff(stuffs[i]);
            
        }
        
        return room;
        
        
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to your new life for eternity!");
        System.out.println("You have been imprisoned till the end of time");
        System.out.println("for blowing up an entire galaxy.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case ENTER:
                enterRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
                
            case LOOK:
                lookAround(command);
                break;
                
            case EXAMINE:
                examineRoom(command);
                break;
                
            case EAT:
                eatFood(command);
                break;
                
            case TRY:
                trySomething(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void enterRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to enter...
            System.out.println("Enter where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }
    
    
    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void trySomething(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to enter...
            System.out.println("Try What?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom != null) {
            System.out.println("There is nothing to do!");
        }
        else {
            
            currentRoom = nextRoom;
            System.out.println("Needs Key");
            
        }
        
    }
    
    /** 
     * Gives description of current room.
     */
    private void lookAround(Command command) 
    {
        System.out.println(currentRoom.getLongDescription());
    }
    
    private void examineRoom(Command command) 
    {

        
        System.out.println(currentRoom.getStuffInRoom());
        
        
    }
    
    private void eatFood(Command command) 
    {
        System.out.println("You have nothing to eat");
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
