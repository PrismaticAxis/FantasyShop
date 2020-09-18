/**
 * 
 * @author	Stephen Lovell
 * @since	
 * @param funds the amount of money the player has
 * @param inventory the items the player has bought
 * @param itemsInInventory the number of items the player has bought
 *
 */
public class Player
{
	private int funds;
	protected Merchandise[] inventory;
	protected int itemsInInventory;
	
	
	
	/**
	 * Creates a new Player with 5000 starting funds
	 * and an inventory size of 30
	 */
	public Player()
	{
		this(5000, 30);
	}
	
	/**
	 * Creates a new Player with the specified amount of starting funds
	 * and inventory size
	 * @param funds the starting amount of money
	 * @param inventorySize the number of items the player can have
	 * in their inventory
	 */
	public Player(int funds, int inventorySize)
	{
		setFunds(funds);
		inventory = new Merchandise[inventorySize];
	}
	
	
	
	/**
	 * Returns the amount of money the player has
	 * @return the amount of money the player has
	 */
	public int getFunds()
	{
		return funds;
	}
	
	/**
	 * Sets the amount of money the player has
	 * @param amount the amount of money to set
	 */
	public void setFunds(int amount)
	{
		funds = amount;
	}
	
	/**
	 * Checks whether the player can afford a particular item
	 * @param item the item the player is attempting to buy
	 * @return true if the players funds is greater than the item's cost
	 */
	public boolean hasEnoughFunds(Merchandise item)
	{
		return funds >= item.getCost();
	}
	
	/**
	 * Adds a specified item to the player's inventory, adjusts the
	 * count of items in the player's inventory, and subtract's the
	 * item's cost from the player's funds
	 * @param item the item being bought
	 */
	public void buy(Merchandise item)
	{
			funds = funds - item.getCost();
			inventory[itemsInInventory] = item;
			itemsInInventory++;
	}
	
	/**
	 * Sells the item at the specified index of the player's inventory
	 * and adds the item's cost to the player's funds
	 * @param index the index in the player's inventory that contains
	 * the item to be sold
	 */
	public void sell(int index)
	{
		setFunds(getFunds() + inventory[index].getCost());
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
