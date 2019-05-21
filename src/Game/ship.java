package Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class ship
{
	public int score;
	public int numDays;
	public String shipName = "ship";
	public int shield_level = 100;
	public int parts_missing;
	public int crew_money = 100;
	public int crew_money_copy = crew_money;
	public int total_item_price = 0;
	public String search_result;
	public boolean astroidBelt = false;
	public boolean pirate = false;
	
	public characters_Command current_char;
	public Food_and_Med_Command current_food;
	
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
	public health_potion_1 med1 = new health_potion_1();
	public health_potion_2 med2 = new health_potion_2();
	public health_potion_3 med3 = new health_potion_3();
	
	public int quantity1 = 0;
	public int quantity2 = 0;
	public int quantity3 = 0;
	public int quantity4 = 0;
	public int quantity5 = 0;
	public int quantity6 = 0;
	public int quantity7 = 0;
	public int quantity8 = 0;
	public int quantity9 = 0;
	
	
	ArrayList<characters_Command> pilots = new ArrayList <characters_Command>();
	ArrayList<characters_Command> flying_pilots = new ArrayList <characters_Command>();
	ArrayList<Food_and_Med_Command> foods = new ArrayList <Food_and_Med_Command>();
	ArrayList<Food_and_Med_Command> foodsBuyList = new ArrayList <Food_and_Med_Command>();
	Map<String, characters_Command> crew = new HashMap<String, characters_Command>();
	Food_and_Med_Command[] food_list = new Food_and_Med_Command[] {f1, f2, f3, f4, f5, f6};
	
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
//		if (foodsBuyList.isEmpty())
//		{
//			throw new InputSetupException("select foods?");
//		}
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
					score += 15;
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
	
	public void search (characters_Command character)
	{
		if (character.actionCount >= 1)
		{
			String[] item = new String[] {"item", "None", "damage10", "item", "damage10", "plague","money10", "money15", "damage20", "None", "None", "None", "None"};
			Random rand = new Random();
			int n = rand.nextInt(12);
			int parts = rand.nextInt(100);
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
				character.pilot_health -= 10;
				if (character.pilot_health < 0)
				{
					search_result = " is not coming back...";
					score -= 20;
				}
			} else if (item[n] == "plague")
			{
				if (character.carry_plague == true)
				{
					search_result = " came back damaged(-40)...";
					character.pilot_health -= 40;
					if (character.pilot_health < 0)
					{
						search_result = " is not coming back...";
						score -= 20;
					}
				} else
				{
					search_result = " is infected with space plague...";
					character.carry_plague = true;
				}
			} else if (item[n] == "money10")
			{
				search_result = " came back with $10!";
				crew_money += 10;
			} else if (item[n] == "money15")
			{
				search_result = " came back with $15!";
				crew_money += 15;
			}
			if (parts <= 15)
			{
				search_result = " came back with a missing part!";
				parts_missing -= 1;
			}
			character.actionCount -= 1;
			score += 50;
		} else 
		{
			throw new InputSetupException("The character has no action count!");
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
			if (n <= 35)
			{
				astroidBelt = true;
				shield_level -= n;
				astroidBelt = false;
			}
			int n1 = random.nextInt(100);
			if (n1 <= 15) 
			{
				if (shield_level < 70)
				{
					pirate = true;
					//parts_missing += 1;
					int random_pilot = random.nextInt(1);
					flying_pilots.get(random_pilot).pilot_health -= 15;
					pirate = false;
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
		//reset action counts
		for(characters_Command i : pilots)
		{
			i.actionCount = 2;
			i.pilot_tired += 20;
			i.pilot_hunger += 20;
			score -= 10;
			if (i.pilot_tired > 70)
			{
				i.pilot_health -= 5;
			}
			if (i.pilot_hunger > 60)
			{
				i.pilot_health -= 5;
				i.pilot_tired += 10;
			}
			if (i.carry_plague == true)
			{
				if (i.pilot_hunger > 60 || i.pilot_tired > 70)
				{
					i.pilot_health -= 50;
				} else
				{
					i.pilot_health -= 30;
				}
			}
		}
		//crew tired
		//crew hungry
	}
}
