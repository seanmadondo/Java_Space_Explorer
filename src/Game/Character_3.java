package Game;

/** 
 * This class initializes data for character 3 of the 6 characters that depend on the characters_Command class.
 * Attributes initialized are --> name,health,repair_skill,search_skill,hunger,tired,count, plague, immune
 */
public class Character_3 extends characters_Command
{
	
	
	public Character_3() 
	{
		super("", 100, 80, 20, 0, 0, 2, false, false);
	}
}
