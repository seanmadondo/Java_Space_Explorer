package Game;

/** 
 * This class initializes data for character 2 of the 6 characters that depend on the characters_Command class.
 * Attributes initialized are --> name,health,repair_skill,search_skill,hunger,tired,count, plague, immune
 */
public class Character_2 extends characters_Command
{
	
	public Character_2() 
	{
		super("", 100, 50, 30, 0, 0, 2, false, false);
	}

}
