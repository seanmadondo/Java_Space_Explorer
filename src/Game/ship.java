package Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * @author jle147
 *
 *
 */
public class ship
{
	/**
	 * The score of the game
	 */
	public int score;
	/**
	 * The number of days that is input from the user
	 */
	public int numDays;
	/**
	 * The ship's name ("ship" is default)
	 */
	public String shipName = "ship";
	/**
	 * the ship's shield_level (initially 100)
	 */
	public int shield_level = 100;
	/**
	 * number of parts that the player have to find to win
	 */
	public int parts_missing;
	/**
	 * total money that the crew has (initially 100)
	 */
	public int crew_money = 100;
	/**
	 * copy of the crew's money
	 * used for function that is used to buy items
	 */
	public int crew_money_copy = crew_money;
	/**
	 * total cost of the user's shopping list
	 */
	public int total_item_price = 0;
	/**
	 * result of current character's search result
	 */
	public String search_result;
	/**
	 * boolean variable that decides if the ship encounters asteroid belt by certain chance
	 *
	 */
	public boolean astroidBelt = false;
	/**
	 * boolean variable that decides if the ship encounters space pirates by certain chance
	 */
	public boolean pirate = false;
	/**
	 * object variable that stores the current character
	 */
	public characters_Command current_char;
	/**
	 * object variable that stores the current food
	 */
	public Food_and_Med_Command current_food;
	/**
	 * character 1 to 6 initialization
	 */
	Character_1 char_1 = new Character_1();
	Character_2 char_2 = new Character_2();
	Character_3 char_3 = new Character_3();
	Character_4 char_4 = new Character_4();
	Character_5 char_5 = new Character_5();
	Character_6 char_6 = new Character_6();
	/**
	 * food 1 to 6 and
	 * medicine 1 to 3 initialization
	 */
	food1 f1 = new food1();
	food2 f2 = new food2();
	food3 f3 = new food3();
	food4 f4 = new food4();
	food5 f5 = new food5();
	food6 f6 = new food6();
	health_potion_1 med1 = new health_potion_1();
	health_potion_2 med2 = new health_potion_2();
	health_potion_3 med3 = new health_potion_3();
	/**
	 * integer variables to store quantities of items
	 */
	public int quantity1 = 0;
	public int quantity2 = 0;
	public int quantity3 = 0;
	public int quantity4 = 0;
	public int quantity5 = 0;
	public int quantity6 = 0;
	public int quantity7 = 0;
	public int quantity8 = 0;
	public int quantity9 = 0;
	
	/**
	 * array of current characters objects
	 */
	ArrayList<characters_Command> pilots = new ArrayList <characters_Command>();
	/**
	 * array of current flying characters objects
	 */
	ArrayList<characters_Command> flying_pilots = new ArrayList <characters_Command>();
	/**
	 * array of item objects that crew owns
	 */
	ArrayList<Food_and_Med_Command> foods = new ArrayList <Food_and_Med_Command>();
	/**
	 * array of item objects to buy (shopping list)
	 */
	ArrayList<Food_and_Med_Command> foodsBuyList = new ArrayList <Food_and_Med_Command>();
	/**
	 * 
	 */
	Map<String, characters_Command> crew = new HashMap<String, characters_Command>();
	Food_and_Med_Command[] food_list = new Food_and_Med_Command[] {f1, f2, f3, f4, f5, f6};
	
	/*
	 * @param name of the ship
	 */
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
		if (days >= 3 && days <= 10)
		{
			numDays = days;
			parts_missing = (days * 2)/3;
			return parts_missing;
		} else
		{
			throw new InputSetupException("Only number 3-10!");
		}
		
	}
	
	public void add_pilots(characters_Command pilot)
	{
		if (pilot == char_1)
		{
			pilot = new Character_1();
		} else if(pilot == char_2)
		{
			pilot = new Character_2();
		} else if(pilot == char_3)
		{
			pilot = new Character_3();
		} else if(pilot == char_4)
		{
			pilot = new Character_4();
		} else if(pilot == char_5)
		{
			pilot = new Character_5();
		} else if(pilot == char_6)
		{
			pilot = new Character_6();
		}
		
		if (pilots.size() <= 3)
		{
			pilots.add( pilot);
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
	
	public void buy_foods()
	{
		for (Food_and_Med_Command i : foodsBuyList)
		{
			if (i.equals(f1))
			{
				f1.item_quantity += 1;
			} else if (i.equals(f2))
			{
				f2.item_quantity += 1;
			} else if (i.equals(f3))
			{
				f3.item_quantity += 1;
			} else if (i.equals(f4))
			{
				f4.item_quantity += 1;
			} else if (i.equals(f5))
			{
				f5.item_quantity += 1;
			} else if (i.equals(f6))
			{
				f6.item_quantity += 1;
			} else if (i.equals(med1))
			{
				med1.item_quantity += 1;
			} else if (i.equals(med2))
			{
				med2.item_quantity += 1;
			} else if (i.equals(med3))
			{
				med3.item_quantity += 1;
			}
			score += foodsBuyList.size();
			foodsBuyList = new ArrayList <Food_and_Med_Command>();
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
	
	public int charTpyeTeller(characters_Command pilot)
	{
		int result = 0;
		if (pilot == char_1)
		{
			result = 1;
		} else if(pilot == char_2)
		{
			result = 2;
		} else if(pilot == char_2)
		{
			result = 2;
		} else if(pilot == char_3)
		{
			result = 3;
		} else if(pilot == char_4)
		{
			result = 4;
		} else if(pilot == char_5)
		{
			result = 5;
		} else if(pilot == char_6)
		{
			result = 6;
		} 
		return result;
	}
	
	public void sleep(characters_Command character)
	{
		if (character.actionCount < 1)
		{
			throw new InputSetupException("The characters have not enough action count!");
		} else 
		{
			if (character.pilot_tired >= 20)
			{
				character.pilot_tired -= 20;
			} else
			{
				character.pilot_tired = 0;
			}
			character.actionCount -= 1;
			score += 10;
		}
		
	}
	
	public void set_current_food(Food_and_Med_Command food)
	{
		if (food.item_quantity > 0)
		{
			current_food = food;
		} else 
		{
			throw new InputSetupException("you don't have this food! buy it from outpost");
		}
	}
	
	public void eat (Food_and_Med_Command food, characters_Command character)
	{
		if (character.actionCount < 1)
		{
			throw new InputSetupException("The characters have not enough action count!");
		} else 
		{
			if (food.equals(null))
			{
				throw new InputSetupException("You have to choose a food!");
			} else
			{
				food.item_quantity -= 1;
				character.pilot_health += food.heal_level;
				character.pilot_hunger -= food.hunger_reduction;
				if (food.equals(med3))
				{
					character.carry_plague = false;
					score += 10;
				}
				character.actionCount -= 1;
				score += 10;
			}
		}
	}
	
	public void repair_shield(characters_Command character)
	{
		if (character.actionCount < 1)
		{
			throw new InputSetupException("The characters have not enough action count!");
		} else
		{
			shield_level += character.pilot_repiar_skill;
			character.actionCount -= 1;
			score += 20;
		}
	}
	
	/*
	 * @return the search result
	 */
	public String search ()
	{
		if (current_char == null)
		{
			throw new InputSetupException("choose a character!");
		}else
		{
			if (current_char.actionCount < 1)
			{
				throw new InputSetupException("The character has no action count!");
			}else
			{
				String[] item = new String[] {"item", "None", "damage10", "item","part",  "damage10","money10","part", "money15", "plague", "damage10", "part", "None", "None","item", "None", "damage10", "item","money15", "damage10", "None","None", "damage10", "plague", "damage10", "None", "item","money15", "damage10", "None","None", "damage10", "plague", "damage10", "None","None", "damage10", "plague", "damage10", "None", "item","money15", "damage10", "None","None", "damage10", "plague", "plague", "damage10", "None", "item","money15", "damage10", "None","None", "damage10", "plague", "plague", "damage10", "None", "item","money15", "damage10", "None","None", "damage10", "plague"};
				Random rand = new Random();
				int n = rand.nextInt(item.length);
				
				for(int i=0; i <= current_char.pilot_search_skill; i+=10)
				{
					if (item[n] != "part")
					{
						n = rand.nextInt(item.length);
						System.out.println(item[n]);
					} else
					{
						break;
					}
				}
				
				if (item[n] == "None")
				{
					search_result = " came back with nothing...";
				} else if (item[n] == "item")
				{
					search_result = " came back with an food supply!";
					int index = rand.nextInt(5);
					food_list[index].item_quantity += 1;
				} else if (item[n] == "damage10")
				{
					search_result = " came back damaged(-10)...";
					current_char.pilot_health -= 10;
					if (current_char.pilot_health <= 0)
					{
						pilots.remove(current_char);
						current_char = null;
						search_result = " is not coming back...";
						score -= 20;
					}
				} else if (item[n] == "plague")
				{
					if (current_char.carry_plague == false)
					{
						search_result = " is infected with space plague...";
						current_char.carry_plague = true;
					} else
					{
						search_result = " came back damaged(-20)...";
						current_char.pilot_health -= 20;
						if (current_char.pilot_health <= 0)
						{
							pilots.remove(current_char);
							current_char = null;
							search_result = " is not coming back...";
							score -= 20;
						}
					}
				} else if (item[n] == "money10")
				{
					search_result = " came back with $10!";
					crew_money += 10;
				} else if (item[n] == "money15")
				{
					search_result = " came back with $15!";
					crew_money += 15;
				} else if (item[n] == "part")
				{
					search_result = " came back with a missing part!";
					parts_missing -= 1;
				}
				current_char.actionCount -= 1;
				score += 50;
				
				return search_result;
			}
		}
		
	}
	
	public void fly(characters_Command character1, characters_Command character2)
	{
		if (character1.actionCount < 1 || character2.actionCount < 1)
		{
			throw new InputSetupException("The characters have not enough action count!");
		} else
		{
			character1.actionCount -= 1;
			character2.actionCount -= 1;
			score += 40;
			
			Random random = new Random();
			int n = random.nextInt(100);
			if (n <= 45)
			{
				astroidBelt = true;
				shield_level -= n;
			}
			int n1 = random.nextInt(100);
			if (n1 <= 15 && n1 > 1) 
			{
				if (shield_level < 70)
				{
					pirate = true;
					//parts_missing += 1;
					int random_pilot = random.nextInt(1);
					flying_pilots.get(random_pilot).pilot_health -= 15;
				} else
				{
					pirate = false;
					int n2 = random.nextInt(30);
					shield_level -= n2;
				}
			}
		}
	}
	
	public void next_day()
	{
		current_food = null;
		current_char = null;
		flying_pilots.clear();
		numDays -= 1;
		//reset action counts
		for(characters_Command i : pilots)
		{
			i.actionCount = 2;
			i.pilot_tired += 10;
			i.pilot_hunger += 10;
			score -= 10;
			if (i.pilot_tired > 70)
			{
				i.pilot_health -= 5;
				if (i.pilot_health < 0)
				{
					pilots.remove(i);
					score -= 20;
				}
			}
			if (i.pilot_hunger > 60)
			{
				i.pilot_health -= 5;
				if (i.pilot_health < 0)
				{
					pilots.remove(i);
					score -= 20;
				}
				i.pilot_tired += 10;
			}
			if (i.carry_plague == true)
			{
				if (i.pilot_hunger > 60 || i.pilot_tired > 70)
				{
					i.pilot_health -= 50;
					if (i.pilot_health < 0)
					{
						pilots.remove(i);
						score -= 20;
					}
				} else
				{
					i.pilot_health -= 30;
					if (i.pilot_health < 0)
					{
						pilots.remove(i);
						score -= 20;
					}
				}
			}
		}
		//crew tired
		//crew hungry
	}
}
