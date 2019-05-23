package Game;
/**
 * @author jle147
 *@author sma297
 *This class behaves as the parent class food and medication classes. The class holds information that is required for the implementation of character health
 *throughout the course of the game. The Food_and_Med_Command is beneficial for code reuse as all of food and medication types  can be reached through here.
 */
public class Food_and_Med_Command
{
	/**
	 * initializes attributes heal_level, hunger_reduction, item_price, item_quantity.
	 */
	public int heal_level;
	public int hunger_reduction;
	public int item_price;
	public int item_quantity;

	
	public Food_and_Med_Command (int level, int reduction, int quantity, int price)
	{
		heal_level = level;
		hunger_reduction = reduction;
		item_quantity = quantity;
		item_price = price;
	}
}
