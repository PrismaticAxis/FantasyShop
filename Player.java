/**
 * 
 * @author	Stephen Lovell
 * @since	01 Sep 2020
 *
 */
public class Player
{
	private int funds;
	protected Merchandise[] inventory;
	protected int itemsInInventory;
	
	
	
	public Player()
	{
		this(5000, 30);
	}
	
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
	
	public boolean hasEnoughFunds(Merchandise item)
	{
		return funds >= item.getCost();
	}
	
	public void buy(Merchandise item)
	{
			funds = funds - item.getCost();
			inventory[itemsInInventory] = item;
			itemsInInventory++;
	}
	
	public void sell(int index)
	{
		inventory[index] = null;
		itemsInInventory--;
		while (index < itemsInInventory)
		{
			index++;
			inventory[index - 1] = inventory[index];
		}
		inventory[itemsInInventory] = null;
	}
	
}
