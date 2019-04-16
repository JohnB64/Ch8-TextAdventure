/**
 * Representations for all the valid command words for the game
 * along with a string in a particular language.
 * 
 * @author John Burkert
 * @version April 15th 2019
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.10
 */
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    QUIT("quit"), HELP("cheats"), UNKNOWN("?"), ENTER("enter"), LOOK("look"), EXAMINE("examine"),
    EAT("eat"), BACK("back"), CODE("4815162342");
    
    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}
