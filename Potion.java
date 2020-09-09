
public class Potion extends Merchandise
{
	private int currentDoses;
	private int maxDoses;
	private String shortDescription;
	
	
	
	public Potion()
	{
		this("", 0);
	}
	
	public Potion(String name, int cost)
	{
		this(name, 1, cost);
	}
	
	public Potion(String name, int doses, int cost)
	{
		this(name, doses, cost, "");
	}
	
	public Potion(String name, int doses, int cost, String descript)
	{
		super(name, cost);
		setMaxDoses(doses);
		setCurrentDoses(doses);
		setShortDescription(descript);
	}
	
	
	
	public int getCurrentDoses()
	{
		return currentDoses;
	}
	
	public void setCurrentDoses(int doses)
	{
		if (doses > 0 && doses <= maxDoses)
			currentDoses = doses;
		else if (doses < 0)
			currentDoses = 0;
		else if (doses > maxDoses)
			currentDoses = maxDoses;
	}
	
	public int getMaxDoses()
	{
		return maxDoses;
	}
	
	public void setMaxDoses(int max)
	{
		if (max > 0)
			maxDoses = max;
		else
			maxDoses = 1;
	}
	
	public String getShortDescription()
	{
		return shortDescription;
	}
	
	public void setShortDescription(String descript)
	{
		shortDescription = descript;
	}
}
