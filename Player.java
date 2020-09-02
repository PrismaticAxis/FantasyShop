/**
 * 
 * @author	Stephen Lovell
 * @since	01 Sep 2020
 *
 */
public class Player
{
	private int funds;
	public Merchandise[] inventory;
	public int itemsInInventory;
	
	
	
	public Player()
	{
		
	}
	
	//needs initialization values
	public Player(int funds, int inventorySize)
	{
		setFunds(funds);
		inventory = new Merchandise[inventorySize];
	}
	
	
	
	public int getFunds()
	{
		return funds;
	}
	
	public void setFunds(int amount)
	{
		funds = amount;
	}
}
