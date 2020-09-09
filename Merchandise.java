/**
 * The catch-all class for all items in the shop.
 * 
 *	@author Stephen Lovell
 *	@since	01 Sep 2020
 */
public class Merchandise
{
	private String name;
	private int cost;
	private String longDescription;
	
	
	public Merchandise()
	{
		this("", 0);
	}
	
	public Merchandise(String name, int cost)
	{
		setName(name);
		setCost(cost);
	}
	
	
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getCost()
	{
		return cost;
	}
	
	public void setCost(int cost)
	{
		this.cost = cost;
	}
	
	public String getLongDescription()
	{
		return longDescription;
	}
	
	public void setLongDescription(String description)
	{
		longDescription = description;
	}
}
