import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Shop
{

	final static char SILVER = '\u00A7';
	final static String[] CATEGORIES = 
		{"Armor", "Weapons", "Kits", "Potions", "Miscellaneous"};
	
	//needs initial values
	static Player player = new Player();
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Armor[] armor = stockArmor();
		mainMenu();
	}
	
	public static void mainMenu()
	{
		try
		{
			Scanner input = new Scanner(System.in);
			
			System.out.println("x)\t[Exit]");
			System.out.println("h)\t[Help]");
			System.out.println("i)\t[View Inventory]");
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
			
			System.out.println();
			System.out.println(">");
			
			String choice = input.next();
			switch (choice)
			{
			case "x":
				break;
			case "h":
				break;
			case "i":
				break;
			case "1":	//Armor
				break;
			case "2":	//Weapons
				break;
			case "3":	//Kits
				break;
			case "4":	//Potions
				break;
			case "5":	//Misc
				break;
			default:
				throw new Exception("\nInvalid input\n");
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			mainMenu();
		}
	}
	
	//to do: fill in long descriptions
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
