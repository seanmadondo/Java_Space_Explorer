package Game;

import java.util.ArrayList;

public class Gui_manager 
{
	public ship s = new ship();
	
	public int numDays;
	public String shipName = "ship";
	public int shield_level = 100;
	public int parts_missing;
	public int crew_money = 100;
	public int crew_money_copy = crew_money;
	public int total_item_price = 0;
	public int quantity1 = 0;
	public String search_result;
	
	public Character_1 char_1 = new Character_1();
	public Character_2 char_2 = new Character_2();
	public Character_3 char_3 = new Character_3();
	public Character_4 char_4 = new Character_4();
	public Character_5 char_5 = new Character_5();
	public Character_6 char_6 = new Character_6();
	
	public food1 f1 = new food1();
	public food2 f2 = new food2();
	public food3 f3 = new food3();
	public food4 f4 = new food4();
	public food5 f5 = new food5();
	public food6 f6 = new food6();
	public health_potion_1 med1 = new health_potion_1();
	public health_potion_2 med2 = new health_potion_2();
	public health_potion_3 med3 = new health_potion_3();
	
	public characters_Command current_char;
	
	ArrayList<characters_Command> pilots = new ArrayList <characters_Command>();
	ArrayList<characters_Command> flying_pilots = new ArrayList <characters_Command>();
	ArrayList<Food_and_Med_Command> foods = new ArrayList <Food_and_Med_Command>();
	ArrayList<Food_and_Med_Command> foodsBuyList = new ArrayList <Food_and_Med_Command>();
	

}
