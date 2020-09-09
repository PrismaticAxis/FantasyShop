import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Shop
{

	final static char SILVER = '\u00A7';
	final static String[] CATEGORIES = 
		{"Armor", "Weapons", "Kits", "Potions", "Miscellaneous"};
	
	static Player player = new Player();
	
	
	
	public static void main(String[] args) throws FileNotFoundException
	{
		mainMenu();
	}
	
	
	
	public static void printMenu(String[] options)
	{
		System.out.println("x)\t[Finish shopping and exit]");
		System.out.println("h)\t[Help]");
		System.out.println("i)\t[View inventory]");
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
	
	public static void printMenu(Merchandise[] options)
	{
		evergreenMenuOptions();
		System.out.println();
		
		System.out.println("\tName\t\t\tCost");
		System.out.println();
		
		for (int i = 0; i < options.length; i++)
		{
			System.out.print(i + 1);
			System.out.print(")\t");
			System.out.print(options[i].getName());
			if (options[i].getName().length() < 8)
				System.out.print("\t");
			if (options[i].getName().length() < 16)
				System.out.print("\t");
			System.out.print("\t");
			System.out.print(SILVER + "" + options[i].getCost());
			System.out.println();
		}
		
		System.out.println();
		System.out.println(
				"[Funds: " + SILVER + player.getFunds() + ']');
		
		System.out.println();
		System.out.println(">");
	}
	
	public static void printMenu(Armor[] options)
	{
		evergreenMenuOptions();
		System.out.println();
		
		System.out.println("\tName\t\tCost\t\tRating");
		System.out.println();
		
		for (int i = 0; i < options.length; i++)
		{
			System.out.print(i + 1);
			System.out.print(")\t");
			System.out.print(options[i].getName());
			System.out.print("\t");
			if(options[i].getName().length() < 7) //even things out for shorter names
				System.out.print("\t");
			System.out.print(SILVER + "" + options[i].getCost());
			System.out.print("\t\t");
			System.out.print(options[i].getRating());
			System.out.println();
		}
		
		System.out.println();
		System.out.println(
				"[Funds: " + SILVER + player.getFunds() + ']');
		
		System.out.println();
		System.out.println(">");
	}
	
	public static void printMenu(Weapon[] options)
	{
		evergreenMenuOptions();
		System.out.println();
		
		System.out.println("\tName\t\tCost\t\tPower\tType");
		System.out.println();
		
		for (int i = 0; i < options.length; i++)
		{
			System.out.print(i + 1);
			System.out.print(")\t");
			System.out.print(options[i].getName());
			System.out.print("\t");
			if (options[i].getName().length() < 8)
				System.out.print("\t");
			System.out.print(SILVER);
			System.out.print(options[i].getCost());
			System.out.print("\t");
			System.out.print("\t");
			System.out.print(options[i].getPower());
			System.out.print("\t");
			System.out.print(options[i].getRange());
			System.out.println();
		}
		
		System.out.println();
		System.out.println(
				"[Funds: " + SILVER + player.getFunds() + ']');
		
		System.out.println();
		System.out.println(">");
	}
	
	public static void printMenu(Potion[] options)
	{
		evergreenMenuOptions();
		System.out.println();
		
		System.out.println("\tName\t\t\tCost\tShort Description");
		System.out.println();
		
		for (int i = 0; i < options.length; i++)
		{
			System.out.print(i + 1);
			System.out.print(")\t");
			System.out.print(options[i].getName());
			System.out.print("\t");
			if (options[i].getName().length() < 16)
				System.out.print("\t");
			System.out.print(SILVER + "" + options[i].getCost());
			System.out.print("\t");
			System.out.print(options[i].getShortDescription().trim());
			System.out.println();
		}
		
		System.out.println();
		System.out.println(
			"[Funds: " + SILVER + player.getFunds() + ']');
		
		System.out.println();
		System.out.println(">");
	}
	
	public static void evergreenMenuOptions()
	{
		System.out.println("b)\t[Back]");
		System.out.println("x)\t[Finish shopping and exit]");
		System.out.println("h)\t[Help]");
		System.out.println("i)\t[View inventory]");
		System.out.println();
	}
	
	public static void exit()
	{
		try
		{
			Scanner input = new Scanner(System.in);
			
			System.out.print("Are you sure? (y/n) ");
			String choice = input.next();
			switch (choice)
			{
			case "y":
				System.out.println("Thank you for shopping.\n"
						+ "Good luck on your adventure!");
				System.exit(0);
			case "n":
				mainMenu();
			default:
				throw new Exception("Invalid input");
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			exit();
		}
	}
	
	public static void help()
	{
		try
		{
			Scanner input = new Scanner(System.in);
			
			System.out.println("- General -");
			System.out.println(
				"Input is always a single character, and lowercase for\n"
				+ "letters. If you keep getting 'Ivalid input'\n"
				+ "messages, check that you're only using lowercase,\n"
				+ "and that there aren't any extra spaces in your input.");
			System.out.println();
			System.out.println("- Buying and Selling -");
			System.out.println(
				"To buy an item, simply browse to the one you want, and\n"
				+ "input its menu number. You'll be provided with a\n"
				+ "description of the item and asked if you're sure.\n"
				+ "Enter 'y' to confirm, or 'n' if you decide not to\n"
				+ "(or 'b'; going back has the same effect).");
			System.out.println();
			System.out.println(
				"To sell an item, first view your inventory (using 'i').\n"
				+ "Enter an item's number to view its details, then\n"
				+ "enter 's' (you'll be asked to confirm; once again,\n"
				+ "enter 'y' to finalize the sale). Effectively, you're\n"
				+ "just saying you changed your mind about buying the\n"
				+ "item (since you haven't technically left the shop\n"
				+ "yet), so you'll get the full price back.");
			System.out.println();
			System.out.println("- Finishing Up -");
			System.out.println(
				"When you're done shopping, simply enter 'x'. You'll\n"
				+ "be asked if you're sure you want to leave. Enter 'y'\n"
				+ "to confirm and exit, or 'n' to continue shopping.");
			System.out.println();
			
			evergreenMenuOptions();
			System.out.println(">");
			
			String choice = input.next();
			switch (choice)
			{
			case "b":
				mainMenu();
			case "x":
				exit();
			case "h":
				help();
			case "i":
				viewInventory();
			default:
				throw new Exception("Invalid input");
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			help();
		}
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
				exit();
			case "h":
				help();
			case "i":
				viewInventory();
			case "1":	//Armor
				armorMenu();
			case "2":	//Weapons
				weaponMenu();
			case "3":	//Kits
				kitMenu();
			case "4":	//Potions
				potionMenu();
			case "5":	//Misc
				miscMenu();
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
	
	public static void armorMenu()
	{
		try
		{
			Armor[] armor = stockArmor();
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("Armor");
			printMenu(armor);
			
			String choice = input.next();
			
			switch (choice)
			{
			case "b":
				mainMenu();
			case "x":
				exit();
			case "h":
				help();
				break;
			case "i":
				viewInventory();
			default:
				if (Integer.parseInt(choice) > 0
					&& Integer.parseInt(choice) <= armor.length)
				{
					viewDetailsInShop(
							armor[Integer.parseInt(choice) - 1]);
				}
					
				else
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
	
	public static void weaponMenu()
	{
		try
		{
			Weapon[] weapons = stockWeapons();
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("Weapons");
			printMenu(weapons);

			String choice = input.next();
			
			switch (choice)
			{
			case "b":
				mainMenu();
			case "x":
				exit();
			case "h":
				help();
				break;
			case "i":
				viewInventory();
				break;
			default:
				if (Integer.parseInt(choice) > 0 &&
					Integer.parseInt(choice) <= weapons.length)
				{
					viewDetailsInShop(
							weapons[Integer.parseInt(choice) - 1]);
				}
				else
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
			weaponMenu();
		}
	}
	
	public static void kitMenu()
	{
		try
		{
			Kit[] kits = stockKits();
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("Kits");
			printMenu(kits);
			
			String choice = input.next();
			
			switch (choice)
			{
			case "b":
				mainMenu();
			case "x":
				exit();
			case "h":
				help();
			case "i":
				viewInventory();
			default:
				if (Integer.parseInt(choice) > 0 &&
					Integer.parseInt(choice) <= kits.length)
				{
					viewDetailsInShop(
						kits[Integer.parseInt(choice) - 1]);
				}
				else
					throw new Exception("Invalid input");
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			kitMenu();
		}
	}
	
	public static void potionMenu()
	{
		try
		{
			Potion[] potions = stockPotions();
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("Potions");
			printMenu(potions);
			
			String choice = input.next();
			
			switch (choice)
			{
			case "b":
				mainMenu();
			case "x":
				exit();
			case "h":
				help();
			case "i":
				viewInventory();
			default:
				if (Integer.parseInt(choice) > 0 &&
					Integer.parseInt(choice) <= potions.length)
				{
					viewDetailsInShop(
						potions[Integer.parseInt(choice) - 1]);
				}
				else
					throw new Exception("Invalid input");
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			potionMenu();
		}
	}

	public static void miscMenu()
	{
		try
		{
			Merchandise[] merch = stockMisc();
			
			Scanner input = new Scanner(System.in);
			
			System.out.println("Miscellaneous");
			printMenu(merch);
			
			String choice = input.next();
			
			switch (choice)
			{
			case "b":
				mainMenu();
			case "x":
				exit();
			case "h":
				help();
			case "i":
				viewInventory();
			default:
				if (Integer.parseInt(choice) > 0 &&
					Integer.parseInt(choice) <= merch.length)
				{
					viewDetailsInShop(
						merch[Integer.parseInt(choice) - 1]);
				}
				else
					throw new Exception("Invalid input");
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			miscMenu();
		}
	}
	
	
	
	public static void viewDetailsInShop(Merchandise item)
	{
		try
		{
			Scanner input = new Scanner(System.in);
			
			evergreenMenuOptions();
			
			System.out.println(item.getName());
			System.out.println();
			System.out.println(item.getLongDescription());
			System.out.println();
			System.out.print(SILVER + "" + item.getCost()
				+ ". Sound good? (y/n)");
			System.out.println(
				"\t\t[Funds: " + SILVER + player.getFunds() + ']');
			System.out.println(">");
			
			String choice = input.next();
			switch (choice)
			{
			case "b":
				kitMenu();
			case "x":
				exit();
			case "h":
				help();
			case "i":
				viewInventory();
			case "y":
				if (player.hasEnoughFunds(item))
				{
					player.buy(item);
					System.out.println("Thank you.");
					kitMenu();
				}	
				else
				{
					System.out.println(
							"Sorry, you don't have enough money.");
					viewDetailsInShop(item);
				}
			case "n":
				kitMenu();
			default:
				throw new Exception("Invalid input");
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			kitMenu();
		}
	}
	
	public static void viewDetailsInShop(Armor item)
	{
		try
		{
			Scanner input = new Scanner(System.in);
			
			evergreenMenuOptions();
			
			System.out.println(item.getName() + " (Armor Rating: "
					+ item.getRating() + ")");
			System.out.println();
			System.out.println(item.getLongDescription());
			System.out.println();
			System.out.print(SILVER + "" + item.getCost()
				+ ". Sound good? (y/n)");
			System.out.println(
				"\t\t[Funds: " + SILVER + player.getFunds() + ']');
			System.out.println(">");
			
			String choice = input.next();
			switch (choice)
			{
			case "b":
				armorMenu();
			case "x":
				exit();
			case "h":
				help();
			case "i":
				viewInventory();
			case "y":
				if (player.hasEnoughFunds(item))
				{
					player.buy(item);
					System.out.println("Thank you.");
					armorMenu();
				}	
				else
				{
					System.out.println(
							"Sorry, you don't have enough money.");
					viewDetailsInShop(item);
				}
			case "n":
				armorMenu();
			default:
				throw new Exception("Invalid input");
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			viewDetailsInShop(item);
		}
	}
	
	//incomplete (delete help() break)
	public static void viewDetailsInShop(Weapon item)
	{
		try
		{
			Scanner input = new Scanner(System.in);
			
			evergreenMenuOptions();
			
			System.out.println(item.getName() + " (" +
				item.getRange().trim() + ", Power: "
				+ item.getPower() + ")");
			System.out.println();
			System.out.println(item.getLongDescription());
			System.out.println();
			System.out.print(SILVER + "" + item.getCost()
				+ ". Sound good? (y/n)");
			System.out.println(
				"\t\t[Funds: " + SILVER + player.getFunds() + ']');
			System.out.println(">");
			
			String choice = input.next();
			switch (choice)
			{
			case "b":
				weaponMenu();
			case "x":
				exit();
			case "h":
				help();
			case "i":
				viewInventory();
			case "y":
				if (player.hasEnoughFunds(item))
				{
					player.buy(item);
					System.out.println("Thank you.");
					weaponMenu();
				}
				else
				{
					System.out.println(
						"Sorry, you don't have enough money.");
					viewDetailsInShop(item);
				}
			case "n":
				weaponMenu();
			default:
				throw new Exception("Invalid input");	
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			viewDetailsInShop(item);
		}
	}

	public static void viewDetailsInShop(Potion item)
	{
		try
		{
			Scanner input = new Scanner(System.in);
			
			evergreenMenuOptions();
			
			System.out.println(item.getName());
			System.out.println();
			System.out.println(item.getLongDescription());
			System.out.println();
			System.out.print(SILVER + "" + item.getCost()
				+ ". Are you sure? (y/n)");
			System.out.println(
				"\t\t[Funds: " + SILVER + player.getFunds() + ']');
			System.out.println(">");
			
			String choice = input.next();
			
			switch (choice)
			{
			case "b":
				potionMenu();
			case "x":
				exit();
			case "h":
				help();
			case "i":
				viewInventory();
			case "y":
				if (player.hasEnoughFunds(item))
				{
					player.buy(item);
					System.out.println("Thank you.");
					potionMenu();
				}
				else
				{
					System.out.println(
						"Sorry, you don't have enough money");
					viewDetailsInShop(item);
				}
			case "n":
				potionMenu();
			default:
				throw new Exception("Invalid input");
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			viewDetailsInShop(item);
		}
	}
	
	public static void viewInventory()
	{
		try
		{
			Scanner input = new Scanner(System.in);
			
			evergreenMenuOptions();
			
			System.out.println("Inventory:");
			
			if (player.itemsInInventory == 0)
			{
				System.out.println("- [Empty]");
				System.out.println();
			}
			else
			{
				for (int i = 0; i < player.itemsInInventory; i++)
					System.out.println(
							(i + 1) + ")\t" + player.inventory[i].getName());
				
				System.out.println();
				System.out.println("(Enter item number to view details)");
			}
			
			System.out.println(">");
			
			String choice = input.next();
			switch (choice)
			{
			case "b":
				mainMenu();
			case "x":
				exit();
			case "h": //remove break after help() is done
				help();
				break;
			case "i":
				viewInventory();
			default:
				if (Integer.parseInt(choice) > 0 &&
						Integer.parseInt(choice) <= player.itemsInInventory)
					viewDetailsInInventory(Integer.parseInt(choice) - 1);
				else
					throw new Exception("Invalid input");
				break;
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			viewInventory();
		}
	}
	
	public static void viewDetailsInInventory(int index)
	{
		try
		{
			Scanner input = new Scanner(System.in);
			
			evergreenMenuOptions();
			
			System.out.println(player.inventory[index].getName());
			System.out.println();
			System.out.println(player.inventory[index].getLongDescription());
			System.out.println();
			System.out.println("('s' to sell)");
			System.out.print(">");
			
			String choice = input.next();
			switch (choice)
			{
			case "b":
				armorMenu();
			case "x":
				exit();
			case "h":
				help();	//remove break when help() is done
				break;
			case "i":
				viewInventory(); //remove break when viewInventory() is done
				break;
			case "s":
				System.out.println("Are you sure? (" + SILVER
					+ player.getFunds() + " -> " + SILVER + (player.getFunds()
					+ player.inventory[index].getCost()) + ")");
				System.out.print(">");
				String sellChoice = input.next();
				if (sellChoice.equals("y"))
				{
					player.sell(index);
					System.out.println("Thank you.");
					viewInventory();
				}
				else if (sellChoice.equals("n"))
					viewDetailsInInventory(index);
				else
					throw new Exception("Invalid input");
			default:
				throw new Exception("Invalid input");
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			viewDetailsInInventory(index);
		}
	}
	
	//incomplete (delete help() break)
	
	
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
		
		armor[0].setLongDescription(
				"Made from layers of thick cloth and padding,\n"
				+ "this armor is surprisingly effective when you\n"
				+ "don't have access to the stronger stuff.");
		armor[1].setLongDescription(
				"Imported armor made from the scaly hides of a\n"
				+ "species of giant lizard from the Sorovali deserts\n"
				+ "to the south. Not as protective as metal armor,\n"
				+ "but rather stylish (depending on who you ask), and\n"
				+ "can usually get the job done.");
		armor[2].setLongDescription(
				"Made of many tiny, interlocking metal rings, mail\n"
				+ "provides excellent protection from sharp edges, and\n"
				+ "generally good defense all around, especially if\n"
				+ "you can't afford the steep prices of full plate.");
		armor[3].setLongDescription(
				"Don't let the cloth-like exterior fool you. This\n"
				+ "armor is actually composed of segmented metal\n"
				+ "plates, riveted to a firm cloth exterior. While\n"
				+ "still falling a bit shy of the protection offered\n"
				+ "by full plate, brigandine will still help you\n"
				+ "keep your innards where they're supposed to be,\n"
				+ "and look good doing it.");
		armor[4].setLongDescription(
				"Composed of large pieces of solid metal, this armor\n"
				+ "is phenomenally good at keeping nasty pointy\n"
				+ "things out of your body. Sturdy construction, an\n"
				+ "intimidating look, and a hefty price tag are what\n"
				+ "you can expect of armor of this caliber.");
		armor[5].setLongDescription(
				"A beautiful and intimidating suit of what other\n"
				+ "nations might call 'enchanted armor,' this\n"
				+ "gloriously practical work of art is made from the\n"
				+ "rare and expensive metal lumite. As long as you can\n"
				+ "keep it infused with Elmarian ink, it'll prove\n"
				+ "stronger and far lighter than steel. Some say\n"
				+ "they've even noticed an increase in strength and\n"
				+ "mobility while wearing it. Make sure you keep it\n"
				+ "infused, though; without ink, the metal is brittle\n"
				+ "and heavy.");
		
		return armor;
	}

	//incomplete (needs long descriptions)
	//incomplete (needs long descriptions)
	public static Weapon[] stockWeapons() throws FileNotFoundException
	{
		int items = 30;
		Weapon[] weapons = new Weapon[items];
		
		File file = new File("src/Weapon.txt");
		Scanner input = new Scanner(file);
		
		for (int i = 0; i < weapons.length; i++)
		{
			String name = input.nextLine();
			int power = input.nextInt();
			int cost = input.nextInt();
			String range = input.nextLine();
			
			weapons[i] = new Weapon(name, cost, range, power);
		}
		
		weapons[0].setLongDescription(
				"");
		weapons[1].setLongDescription(
				"");
		weapons[2].setLongDescription(
				"");
		weapons[3].setLongDescription(
				"");
		weapons[4].setLongDescription(
				"");
		weapons[5].setLongDescription(
				"");
		weapons[6].setLongDescription(
				"");
		weapons[7].setLongDescription(
				"");
		weapons[8].setLongDescription(
				"");
		weapons[9].setLongDescription(
				"");
		weapons[10].setLongDescription(
				"");
		weapons[11].setLongDescription(
				"");
		weapons[12].setLongDescription(
				"");
		weapons[13].setLongDescription(
				"");
		weapons[14].setLongDescription(
				"");
		weapons[15].setLongDescription(
				"");
		weapons[16].setLongDescription(
				"");
		weapons[17].setLongDescription(
				"");
		weapons[18].setLongDescription(
				"");
		weapons[19].setLongDescription(
				"");
		weapons[20].setLongDescription(
				"");
		weapons[21].setLongDescription(
				"");
		weapons[22].setLongDescription(
				"");
		weapons[23].setLongDescription(
				"");
		weapons[24].setLongDescription(
				"");
		weapons[25].setLongDescription(
				"");
		weapons[26].setLongDescription(
				"");
		weapons[27].setLongDescription(
				"");
		weapons[28].setLongDescription(
				"");
		weapons[29].setLongDescription(
				"");
		
		return weapons;
	}

	//incomplete (needs long descriptions)
	public static Kit[] stockKits() throws FileNotFoundException
	{
		int items = 8;
		Kit[] kits = new Kit[items];
		
		File file = new File("src/Kits.txt");
		Scanner input = new Scanner(file);
		
		for (int i = 0; i < kits.length; i++)
		{
			String name = input.nextLine();
			int cost = input.nextInt();
			String blank = input.nextLine();
			
			kits[i] = new Kit(name, cost);
		}
		
		kits[0].setLongDescription("");
		kits[1].setLongDescription("");
		kits[2].setLongDescription("");
		kits[3].setLongDescription("");
		kits[4].setLongDescription("");
		kits[5].setLongDescription("");
		kits[6].setLongDescription("");
		kits[7].setLongDescription("");
		
		return kits;
	}
	
	//incomplete (needs long descriptions)
	public static Potion[] stockPotions() throws FileNotFoundException
	{
		int items = 10;
		Potion[] potions = new Potion[items];
		
		File file = new File("src/Potions.txt");
		Scanner input = new Scanner(file);
		
		for (int i = 0; i < potions.length; i++)
		{
			String name = input.nextLine();
			int cost = input.nextInt();
			String descript = input.nextLine();
			
			potions[i] = new Potion(name, 4, cost, descript);
		}
		
		potions[0].setLongDescription("");
		potions[1].setLongDescription("");
		potions[2].setLongDescription("");
		potions[3].setLongDescription("");
		potions[4].setLongDescription("");
		potions[5].setLongDescription("");
		potions[6].setLongDescription("");
		potions[7].setLongDescription("");
		potions[8].setLongDescription("");
		potions[9].setLongDescription("");
		
		return potions;
	}
	
	//incomplete (needs long descriptions)
	public static Merchandise[] stockMisc() throws FileNotFoundException
	{
		int items = 34;
		Merchandise[] merch = new Merchandise[items];
		
		File file = new File("src/MiscItems.txt");
		Scanner input = new Scanner(file);
		
		for (int i = 0; i < merch.length; i++)
		{
			String name = input.nextLine();
			int cost = input.nextInt();
			String blank = input.nextLine();
			
			merch[i] = new Kit(name, cost);
			System.out.println(merch[i].getName());
			System.out.println(merch[i].getCost());
		}
		
		 merch[0].setLongDescription("");
		 merch[1].setLongDescription("");
		 merch[2].setLongDescription("");
		 merch[3].setLongDescription("");
		 merch[4].setLongDescription("");
		 merch[5].setLongDescription("");
		 merch[6].setLongDescription("");
		 merch[7].setLongDescription("");
		 merch[8].setLongDescription("");
		 merch[9].setLongDescription("");
		merch[10].setLongDescription("");
		merch[11].setLongDescription("");
		merch[12].setLongDescription("");
		merch[13].setLongDescription("");
		merch[14].setLongDescription("");
		merch[15].setLongDescription("");
		merch[16].setLongDescription("");
		merch[17].setLongDescription("");
		merch[18].setLongDescription("");
		merch[19].setLongDescription("");
		merch[20].setLongDescription("");
		merch[21].setLongDescription("");
		merch[22].setLongDescription("");
		merch[23].setLongDescription("");
		merch[24].setLongDescription("");
		merch[25].setLongDescription("");
		merch[26].setLongDescription("");
		merch[27].setLongDescription("");
		merch[28].setLongDescription("");
		merch[29].setLongDescription("");
		merch[30].setLongDescription("");
		merch[31].setLongDescription("");
		merch[32].setLongDescription("");
		merch[33].setLongDescription("");
		
		return merch;
	}
	
}
