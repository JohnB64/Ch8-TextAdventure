/**
 *  This class is the main class of the "Space Prison Escape" application. 
 *  "Space Prison Escape" is a very simple, text based adventure game.  Users 
 *  can try to escape the prison, which is not very hard at all.
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 *  
 * @author John Burkert
 * @version April 15th 2019
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.10
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room pastRoom;
    
    
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }
    
    public static void main(String[] args) {
        
        Game game = new Game();
        game.play();
        
    }

    /**
     * Create all the rooms and link their exits together.
     * Create all the items and link with rooms.
     * Create all the stuff and link with rooms.
     */
    private void createRooms()
    {
        Room cell, cell2, cell3, cell4, hallway, hanger, cargo, vehicle, 
        office, storage, spaceship, ship, escape, airlock, bathroom;
        
        
        Item cellKey[] = {new Item("•Key 🔑", 2)};
        Item keyCard[] = {new Item("•KeyCard 💳", 0)};
        Item stuffedAnimal[] = {new Item("•StuffedAnimal 🐶", 4)};
        Item toothBrush[] = {new Item("•ToothBrush", 2)};
        
        Stuffs bed[] = {new Stuffs("Bed🛏️")};
        Stuffs toilet[] = {new Stuffs("Toilet 🚽")};
        Stuffs box[] = {new Stuffs("Lots of Boxes 📦📦📦")};
        Stuffs cabinet[] = {new Stuffs("Cabinet 🗄")};
        Stuffs desk[] = {new Stuffs("Desk 💻🖥🖱⌨")};
        Stuffs chair[] = {new Stuffs("Office Chair 💺")};
        Stuffs nothing[] = {new Stuffs("Nothing")};
        Stuffs doors[] = {new Stuffs("Lots of Doors")};
        Stuffs sign[] = {new Stuffs("Sign")};
        
        
      
        // create the rooms
        cell = new Room("in a Prison Cell");
        cell2 = new Room("in Prison Cell 2");
        cell3 = new Room("in Prison Cell 3");
        cell4 = new Room("in Prison Cell 4");
        hallway = new Room("in the Hallway");
        hanger = new Room("in the SpaceShip Hanger");
        office = new Room("in the Office");
        storage = new Room("in the Storage Room");
        ship = new Room("in the SpaceShip Area");
        spaceship = new Room("in a SpaceShip");
        cargo = new Room("in the Cargo area");
        vehicle = new Room("in the Vehicle area");
        escape = new Room("Have Escapend👏");
        airlock = new Room("Dead☠");
        bathroom = new Room("in the Office Bathroom");
        
        
        
        
        // initialise room exits
        cell.setExit("cell_door", hallway);

        hallway.setExit("hanger_door", hanger);
        hallway.setExit("office_door", office);
        hallway.setExit("prison_cell_2", cell2);
        hallway.setExit("prison_cell_3", cell3);
        hallway.setExit("prison_cell_4", cell4);
        hallway.setExit("air_lock_door", airlock);
        
        //examine airlock door and have it say do not enter
        
        office.setExit("storage_door", storage);
        office.setExit("strange_door", airlock);
        office.setExit("bath_room", bathroom);

        hanger.setExit("spaceship_area", spaceship);
        hanger.setExit("cargo_area", cargo);
        hanger.setExit("vehicle_area", vehicle);
        
        spaceship.setExit("space_ship", ship);

        ship.setExit("spaceship_cockpit", escape);
        
        
        
        cell = addItems(cell, cellKey);
        cell2 = addItems(cell2, stuffedAnimal);
        cell2 = addItems(cell2, toothBrush);
        
        storage = addItems(storage, keyCard);
        
        cell = addStuff(cell, bed);
        cell = addStuff(cell, toilet);
        
        cell2 = addStuff(cell2, bed);
        cell2 = addStuff(cell2, toilet);
        
        cell3 = addStuff(cell3, bed);
        cell3 = addStuff(cell3, toilet);
        
        cell4 = addStuff(cell4, bed);
        cell4 = addStuff(cell4, toilet);
        
        hallway = addStuff(hallway, doors);
        
        office = addStuff(office, cabinet);
        office = addStuff(office, desk);
        office = addStuff(office, chair);
        office = addStuff(office, sign);
        
        storage = addStuff(storage, box);
        
        cargo = addStuff(cargo, box);
        
        

        

        currentRoom = cell;  // start game outside
        pastRoom = null;;
    }
    
    /** 
     * Adds items from the array.
     */
    private Room addItems(Room room, Item items[]) {
        
        
        //Implement a while loop here instead.
        
        for(int i = 0; i < items.length; i++) {
            
            room.addItem(items[i]);
            
        }
        
        return room;
        
        
    }
    
    /** 
     * Adds stuff from the array.
     */
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
        System.out.println("Thank you for playing.  Good bye. 👋");
    }
    
    

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to your new life for eternity!");
        System.out.println("You have been imprisoned till the end of time");
        System.out.println("for blowing up an entire galaxy. 🌌" + "\n");
        System.out.println("Lucky for you, the guard was sleeping");
        System.out.println("and you took the cell key" + "\n");
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
                
            case BACK:
                goBack(command);
                break;
                
            case TAKE:
                takeThat(command);
                break;
                
            case TALK:
                talkTo(command);
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
            pastRoom = currentRoom;
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }
    
    
    /** 
     * Try to open a door. If you have a key, you can enter the room,
     * otherwise tell them you cant.
     */
    private void trySomething(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to enter...
            System.out.println("Try what?");
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
    
    /** 
     * Goes back to previous room.
     */
    private void goBack(Command command) 
    {

         if(pastRoom != null) {
             
             currentRoom = pastRoom;
             System.out.println(currentRoom.getLongDescription());
             
            }

    }
    
    /** 
     * Shows stuff in the current room and the code on the sign.
     */
    private void examineRoom(Command command) 
    {
        if(command.hasSecondWord()){
            
            System.out.println("The code is 4815162342");
            
            return;
        
        }
        else {
            
            System.out.println(currentRoom.getStuffInRoom());
        
    }
    }
    
    /** 
     * Trys to eat food, but there is no food to be eaten.
     */
    private void takeThat(Command command) 
    {
        
    }
    
    /** 
     * Trys to eat food, but there is no food to be eaten.
     */
    private void talkTo(Command command) 
    {
        
    }
    
    /** 
     * Trys to eat food, but there is no food to be eaten.
     */
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
