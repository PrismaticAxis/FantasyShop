import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Shop
{

	public static void main(String[] args)
	{
		final char SILVER = '\u00A7';
		final String[] CATEGORIES = 
			{"Armor", "Weapons", "Kits", "Potions", "Miscellaneous"};
		
		//needs initial values
		Player player = new Player();
		Scanner input = new Scanner(System.in);
		
		System.out.println("  x)\t[Exit]");
		System.out.println("  h)\t[Help]");
		System.out.println("inv)\t[View Inventory]");
		System.out.println();
		
		for (int i = 0; i < CATEGORIES.length; i++)
		{
			System.out.print(i + 1);
			System.out.print(")\t");
			System.out.print(CATEGORIES[i]);
			System.out.println();
		}
		
		System.out.println();
		System.out.println(
				"[Funds: " + SILVER + player.getFunds() + ']');
	}
	
	public static Armor[] stockArmor() throws FileNotFoundException
	{
		int items = 6;
		Armor[] armor = new Armor[items];
		
		File file = new File("src/Armor.txt");
		Scanner input = new Scanner(file);
		
		for (int i = 0; i < armor.length; i++)
		{
				String name = input.nextLine();
				int rating = input.nextInt();
				int cost = input.nextInt();
				String notes = input.nextLine();
				
				armor[i] = new Armor(name, cost, rating, notes);
		}
		
		//add long descriptions (incomplete)
		armor[0].setLongDescription("");
		armor[1].setLongDescription("");
		armor[2].setLongDescription("");
		armor[3].setLongDescription("");
		armor[4].setLongDescription("");
		armor[5].setLongDescription("");
		
		return armor;
	}

}
