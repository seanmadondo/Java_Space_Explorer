package Game;

/**
 * @author jle147
 *@author sma297
 *This class behaves as the parent class of all game characters. The class holds information that the character needs to be able to implement throughout the
 *course of the game. The characters_Command is beneficial for code reuse as all characters (pilots) can be reached through here.
 */

public class characters_Command
{

	public String pilot_name;
	public int pilot_health;
	public int pilot_repiar_skill;
	public int pilot_search_skill;
	public int pilot_hunger;
	public int pilot_tired;
	public int actionCount;
	public boolean carry_plague;
	public boolean plague_immune;
	
	/**
	 * initializes the Pilot attributes
	 * Attributes initialized are --> name,health,repair_skill,search_skill,hunger,tired,count, plague, immune
	 */
	public characters_Command (String name, int health, int repair_skill, int search_skill, int hunger, int tired, int count, boolean plaue, boolean immune) 
	{
		
		pilot_name = name;
		pilot_health = health;
		pilot_repiar_skill = repair_skill;
		pilot_search_skill = search_skill;
		pilot_hunger = hunger;
		pilot_tired = tired;
		actionCount = count;
		carry_plague = plaue;
		plague_immune = immune;
	}

	/**
	 * Sets the pilots name
	 * @param name -the desired name of the pilots by the user.
	 */
	public void set_pilot_name (characters_Command character, String name)
	{
		character.pilot_name = name;
	}
	
	/**
	 * Sets the pilot to be immune to plague
	 * @param character - takes the pilot that is to be made immune.
	 */
	public void set_space_plague_immune (characters_Command character)
	{
		character.plague_immune = true;
		character.carry_plague = false;
	}
}
