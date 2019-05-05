package Game;

public class outpost 
{
	public int crew_money;
	
	public void set_money (int num)
	{
		crew_money = num;
	}
	
	public int get_money() {
		return crew_money;
	}
	
	public void buy (Food_and_Med_Command item)
	{
		crew_money -= item.item_price;
		item.item_quantity += 1;
	}
}
