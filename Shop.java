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
		mainMenu();
	}
	
	public static void mainMenu()
	{
		try
		{
			Scanner input = new Scanner(System.in);
			
			System.out.println("Main Menu");
			printMenu(CATEGORIES);
			
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
				armorMenu();
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
	
	public static void armorMenu() throws FileNotFoundException
	{
		try
		{
			Armor[] armor = stockArmor();
			String[] armorNames = new String[armor.length];
			for (int i = 0; i < armorNames.length; i++)
				armorNames[i] = armor[i].getName();
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("Armor");
			System.out.println("b)\t[Back]");
			printMenu(armorNames);
			
			String choice = input.next();
			
			switch (choice)
			{
			case "b":
				mainMenu();
				break;
			case "x":
				break;
			case "h":
				break;
			case "i":
				break;
			case "1":
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			case "6":
				break;
			default:
				throw new Exception("Invalid input");
			}
			
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			armorMenu();
		}
	}
	
	public static void printMenu(String[] options)
	{
		System.out.println("x)\t[Exit]");
		System.out.println("h)\t[Help]");
		System.out.println("i)\t[View Inventory]");
		System.out.println();
		
		for (int i = 0; i < options.length; i++)
		{
			System.out.print(i + 1);
			System.out.print(")\t");
			System.out.print(options[i]);
			System.out.println();
		}
		
		System.out.println();
		System.out.println(
				"[Funds: " + SILVER + player.getFunds() + ']');
		
		System.out.println();
		System.out.println(">");
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
