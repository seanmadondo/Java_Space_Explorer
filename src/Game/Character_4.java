package Game;

/** 
 * This class initializes data for character 4 of the 6 characters that depend on the characters_Command class.
 * Attributes initialized are --> name,health,repair_skill,search_skill,hunger,tired,count, plague, immune
 */
public class Character_4 extends characters_Command
{
	
	public Character_4() 
	{
		super("", 100, 70, 30, 0, 0, 2, false, false);
	}

}
