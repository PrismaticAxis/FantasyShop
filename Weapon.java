
public class Weapon extends Merchandise
{
	
	private String range; //generally "Melee" or "Ranged"
	private int power;
	
	
	
	public Weapon()
	{
		this("", 0);
	}
	
	public Weapon(String name, int cost)
	{
		this(name, cost, "Melee", 0);
	}
	
	public Weapon(String name, int cost, String range, int power)
	{
		setName(name);
		setCost(cost);
		setRange(range);
		setPower(power);
	}
	
	
	
	public String getRange()
	{
		return range;
	}
	
	public void setRange(String range)
	{
		this.range = range;
	}
	
	public int getPower()
	{
		return power;
	}
	
	public void setPower(int power)
	{
		if (power > 0)
			this.power = power;
		else
			this.power = 0;
	}
	
}
