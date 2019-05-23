package Game;

/** 
 * This class initializes data for character 1 of the 6 characters that depend on the characters_Command class.
 * Attributes initialized are --> name,health,repair_skill,search_skill,hunger,tired,count, plague, immune
 */

public class Character_1 extends characters_Command{
	/**
	 * initialize character attributes
	 */

	public Character_1() 
	{
		super("", 100, 10, 50, 0, 0, 2, false, false);
	}
}
