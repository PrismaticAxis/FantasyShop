
public abstract class Merchandise
{
	private String name;
	private int cost;
	
	
	
	public Merchandise()
	{
		
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
	
	
	
	public void getLongDescription(){}
}
