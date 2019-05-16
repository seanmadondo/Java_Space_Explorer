package Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class ship 
{
	public int numDays;
	public String shipName = "ship";
	public int shield_level = 100;
	public int parts_missing;
	public int crew_money = 100;
	public int crew_money_copy = crew_money;
	public int total_item_price = 0;
	public int quantity1 = 0;
	public String search_result;
	
	Character_1 char_1 = new Character_1();
	Character_2 char_2 = new Character_2();
	Character_3 char_3 = new Character_3();
	Character_4 char_4 = new Character_4();
	Character_5 char_5 = new Character_5();
	Character_6 char_6 = new Character_6();
	
	food1 f1 = new food1();
	food2 f2 = new food2();
	food3 f3 = new food3();
	food4 f4 = new food4();
	food5 f5 = new food5();
	food6 f6 = new food6();
	
	ArrayList<characters_Command> pilots = new ArrayList <characters_Command>();
	ArrayList<characters_Command> flying_pilots = new ArrayList <characters_Command>();
	ArrayList<Food_and_Med_Command> foods = new ArrayList <Food_and_Med_Command>();
	ArrayList<Food_and_Med_Command> foodsBuyList = new ArrayList <Food_and_Med_Command>();
	Map<String, characters_Command> crew = new HashMap<String, characters_Command>();
	Food_and_Med_Command[] food_list = new Food_and_Med_Command[] {f1, f2, f3};
	
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
			numDays = days;
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
	
	public void remove_pilots(characters_Command pilot, int index)
	{
		pilots.remove(index);
	}
	
	public void add_foods(Food_and_Med_Command item)
	{
		if (crew_money < 0 || item.item_price > crew_money_copy || item.item_price > crew_money)
		{
			throw new InputSetupException("low balance");
		} else
		{
			foodsBuyList.add(item);
			crew_money_copy -= item.item_price;
			total_item_price += item.item_price;
		}
	}
	
	public void remove_foods(Food_and_Med_Command item)
	{
		Iterator<Food_and_Med_Command> i = foodsBuyList.iterator();
		if (foodsBuyList.isEmpty())
		{
			throw new InputSetupException("You don't have anything in list");
		} else {
			while(i.hasNext()) 
			{
				Food_and_Med_Command e = i.next();
				if( e.equals(item))
				{
					i.remove();
					total_item_price -= e.item_price;
					crew_money_copy += e.item_price;
				}
			}
		}
	}
	
	public void sleep(characters_Command character)
	{
		if (character.pilot_tired >= 20)
		{
			character.pilot_tired -= 20;
		} else
		{
			character.pilot_tired = 0;
		}
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
		if (character.actionCount >= 1)
		{
			String[] item = new String[] {"item", "None", "damage10", "item", "None", "plague", "part", "None","money10", "money15", "None",};
			Random rand = new Random();
			int n = rand.nextInt(10);
			if (item[n] == "None")
			{
				search_result = "None";
				throw new InputSetupException("You found nothing!");
			}
			switch(n)
			{
				case 0:
					search_result = " found an item";
					int index = rand.nextInt(5);
					add_foods(food_list[index]);
				case 2:
					search_result = " got a damaged of 10";
					character.pilot_health -= 10;
				case 3:
					search_result = " found an item";
					int index1 = rand.nextInt(5);
					add_foods(food_list[index1]);
				case 5:
					search_result = " got space plague";
					character.plague_immune = false;
				case 6:
					search_result = " found a part";
					parts_missing -= 1;
				case 8:
					search_result = " found $10";
					crew_money += 10;
				case 9:
					search_result = " found $15";
					crew_money += 15;
			}
			character.actionCount -= 1;
		} else 
		{
			throw new InputSetupException("The character has no action count!");
		}
	}
	
	public void fly(characters_Command character1, characters_Command character2)
	{
		character1.actionCount -= 1;
		character2.actionCount -= 1;
		//encounter astroid belt
		//encounter pirate
	}
	
	public void next_day(characters_Command character)
	{
		//reset action counts
		//crew tired
		//crew hungry
	}
}
