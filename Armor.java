
public class Armor extends Merchandise
{
	private int rating;
	private String notes;
	
	
	
	Armor()
	{
		this("", 0);
	}
	
	Armor(String name, int cost)
	{
		this(name, cost, 1, "");
	}
	
	Armor(String name, int cost, int rating, String notes)
	{
		super(name, cost);
		setRating(rating);
	}
	
	
	
	public int getRating()
	{
		return rating;
	}
	
	public void setRating(int rating)
	{
		this.rating = rating;
	}
	
}
