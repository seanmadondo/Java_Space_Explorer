package Game;

public class Food_and_Med_Command
{
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
