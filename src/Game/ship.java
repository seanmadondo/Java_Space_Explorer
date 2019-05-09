package Game;

import java.util.ArrayList;

public class ship 
{
	public String shipName = "ship";
	public int shield_level = 100;
	public int parts_missing;
	
	ArrayList<characters_Command> pilots = new ArrayList <characters_Command>();
	
	public void set_ship_name(String name)
	{
		if (name.length() == 0)
		{
			throw new IllegalArgumentException("Just type anything!");
		} else 
		{
			shipName = name;
		}
	}
	
	public int get_parts_missing(int days)
	{
		if (days >= 2 && days <= 6)
		{
			parts_missing = (days * 2)/3;
			return parts_missing;
		} else
		{
			throw new InputSetupException("Only number 2-6!");
		}
		
	}
	
	public void add_pilots(characters_Command pilot)
	{
		if (pilots.size() <= 3)
		{
			pilots.add(pilot);
		} else
		{
			throw new InputSetupException("select only 4 or less pilots");
		}
	}
	
	public void sleep(characters_Command character)
	{
		character.pilot_tired -= 20;
		character.actionCount -= 1;
	}
	
	public void eat (Food_and_Med_Command food, characters_Command character)
	{
		food.item_quantity -= 1;
		character.pilot_health += food.heal_level;
		character.pilot_hunger -= food.hunger_reduction;
		character.actionCount -= 1;
	}
	
	public void repair_shield(characters_Command character)
	{
		shield_level += character.pilot_repiar_skill;
		character.actionCount -= 1;
	}
	
	public void search (characters_Command character)
	{
		//produce random number and if the number is bigger or equal to the search skill, get part. If not, apply bad things.
		//if missing parts == 0, ship goes back to the earth and finish the game.
		character.actionCount -= 1;
	}
	
	public void fly(characters_Command character1, characters_Command character2)
	{
		character1.actionCount -= 1;
		character2.actionCount -= 1;
		//encounter astroid belt
		//encounter pirate
	}
	
	public void next_day()
	{
		//keep the crew array
		//reset action counts
		//crew tired
		//crew hungry
	}
}
