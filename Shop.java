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
		System.out.print(">");
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
		System.out.print(">");
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
		System.out.print(">");
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
		System.out.print(">");
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
		System.out.print(">");
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
			System.out.print(">");
			
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
					if (item instanceof Kit)
						kitMenu();
					else
						miscMenu();
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
			case "h":
				help();
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
				help();
			case "i":
				viewInventory();
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
		
		weapons[0].setLongDescription( //Bill
			"Evolved from a farming implement used for cutting\n"
			+ "branches, the weapon version of the billhook is\n"
			+ "essentially a staff with a long, hooked blade on the\n"
			+ "end, often (as is the case here) with a spike on the\n"
			+ "tip to allow for thrusting as well as draw cuts.");
		weapons[1].setLongDescription( //Dagger
			"Essentially a knife, a dagger is a weapon meant more\n"
			+ "for backstabbing or finishing off an armored opponent\n"
			+ "that you have pinned than for use as a battlefield\n"
			+ "weapon unto itself. They're useful to have on hand,\n"
			+ "but as a backup, not a primary weapon.");
		weapons[2].setLongDescription( //Falchion
			"A short, single-edged sword. What it lacks in reach, it\n"
			+ "makes up for in solid chopping power.");
		weapons[3].setLongDescription( //Glaive
			"A single-edged blade on the end of a length of wood, the\n"
			+ "glaive is a good, general-use polearm, providing a\n"
			+ "variety of uses in combat.");
		weapons[4].setLongDescription( //Greataxe
			"Essentially we're taking a woodcutting axe here and\n"
			+ "adding a hefty bit of length to the handle to give you\n"
			+ "some good reach. And yes, it's not as bulky as people\n"
			+ "tend to say. What? Don't give me that look.");
		weapons[5].setLongDescription( //Greatsword
			"A very long sword. Seriously, at this length, you're\n"
			+ "fighting with it more like you would a polearm than\n"
			+ "you would a sword.");
		weapons[6].setLongDescription( //Halberd
			"A rather complex bit of machinery as melee weapons go,\n"
			+ "the halberd is a long length of wood with a very long\n"
			+ "spike on the end for stabbing, an axehead-like bit on\n"
			+ "one side for chopping (usually on the backswing), and\n"
			+ "a spike on the other side in case there's trouble over\n"
			+ "on that side.");
		weapons[7].setLongDescription( //Handaxe
			"A shorter-hafted axe not unlike a woodcutting axe. It's\n"
			+ "mobile and relatively easy to use, while allowing for\n"
			+ "big, powerful swings (if you're able to set them up\n"
			+ "right). Lacking in defensive capability, and perhaps\n"
			+ "a bit crude, the handaxe is nonetheless cheap and\n"
			+ "effective.");
		weapons[8].setLongDescription( //Longsword
			"The classic, double-edged, long, pointy piece of metal\n"
			+ "with a handle, the longsword is versatile and easy to\n"
			+ "carry, providing some of the reach of a polearm\n"
			+ "without being quite so cumbersome to carry about.\n"
			+ "Useable with either one hand or two.");
		weapons[9].setLongDescription( //Mace
			"At its simplest, the mace is basically just a metal\n"
			+ "club, though more often (as here), there will be\n"
			+ "different shapes in the head that enable one to\n"
			+ "concentrate the force of the swing into a finer point.");
		weapons[10].setLongDescription( //Maul
			"If you're looking for raw, blunt force, you're in a\n"
			+ "pretty good spot with this one, essentially a\n"
			+ "weaponized sledge hammer. Not our most popular weapon\n"
			+ "by a long shot, but it does have something of a cult\n"
			+ "following.");
		weapons[11].setLongDescription( //Morningstar
			"Often confused with the mace, the morningstar is\n"
			+ "basically a club with a spike-covered ball on the end.\n"
			+ "A vicious, if crude, weapon that implements an\n"
			+ "interesting mix of bludgeoning and piercing damage, the"
			+ "morningstar will definitely work if that's what you're\n"
			+ "looking for.");
		weapons[12].setLongDescription( //Pike
			"Take a spear and scale it up to borderline ridiculous\n"
			+ "length, and you've got what's basically a pike. Reach\n"
			+ "is a huge advantage in combat, and this polearm will\n"
			+ "give you reach. It can be a little tricky to wield,\n"
			+ "and is most effective in formations with other pike-\n"
			+ "wielders, but again, that reach is a major upside.");
		weapons[13].setLongDescription( //Poleaxe
			"A fairly complex weapon, the dominant feature of the\n"
			+ "poleaxe, as the name implies, is the axehead on one\n"
			+ "side of the end of this polearm, but it also includes\n"
			+ "a spike on the end for thrusting and another spike\n"
			+ "opposite the axehead. Overall, a good, solid,\n"
			+ "versatile weapon.");
		weapons[14].setLongDescription( //Quarterstaff
			"Proof that cheap doesn't necessarily mean terrible\n"
			+ "quality, quarterstaffs are inexpensive to make, and\n"
			+ "can produce a devastating amount of force. With that\n"
			+ "said, however, bear in mind that it is still made of\n"
			+ "wood, and a world bristling with sharp, metal weapons\n"
			+ "will, over time, take its toll on the staff, so be\n"
			+ "ready to replace your weapon periodically if you go\n"
			+ "with this.");
		weapons[15].setLongDescription( //Rapier
			"Made primarily as a weapon for dueling, the rapier is a\n"
			+ "sword that excels at thrusting, which can make it a\n"
			+ "bit more effective at finding the weak points in\n"
			+ "armor (though don't read too far into this; that's\n"
			+ "usually a moving target you're aiming for).");
		weapons[16].setLongDescription( //Shortsword
			"Your basic, garden-variety, one-handed sword.\n"
			+ "Relatively cheap to make, but still a versatile and\n"
			+ "effective weapon, though rather lacking in reach.");
		weapons[17].setLongDescription( //Spear
			"One of the most underappreciated weapons in our stock,\n"
			+ "the spear is cheap to produce (basically a sharp,\n"
			+ "pointy bit of metal on the end of a long length of\n"
			+ "wood), but gives you an often underappreciated\n"
			+ "advantage: reach. And it does so while still providing\n"
			+ "you with a sharp point to use.");
		weapons[18].setLongDescription( //War Pick
			"Axes and hammers can put a lot of power behind their\n"
			+ "strikes, but that force is dispersed over a\n"
			+ "relatively large area. The war pick seeks to take that\n"
			+ "idea and remove the downside. Here, you're working\n"
			+ "with a polearm with a slightly curved spike, but on\n"
			+ "the side, rather than the tip, allowing you those same\n"
			+ "powerful strikes from a hammer or axe, but concentrated\n"
			+ "into a much smaller point.");
		weapons[19].setLongDescription( //War Scythe
			"A modified form of the farming scythe, the war scythe is\n"
			+ "a long wooden haft with a slightly curved, single-\n"
			+ "edged blade on the end, not unlike a spear, but with\n"
			+ "a longer cutting edge.");
		weapons[20].setLongDescription( //Warhammer
			"Sharp edges will have a terribly difficult time against\n"
			+ "solid metal plates. In those situations, having a\n"
			+ "warhammer will be a huge advantage. Basically a tool\n"
			+ "for pounding on things, but given a fair bit more\n"
			+ "length, and augmented with a spike on the opposite\n"
			+ "side, the warhammer can deliver devastating blunt\n"
			+ "force.");
		weapons[21].setLongDescription( //Crossbow
			"A mechanically complex means of transferring a sharp\n"
			+ "bolt from your hand into your hapless target at\n"
			+ "blistering speed, the crossbow packs a lot of power,\n"
			+ "but comes at the cost of a very long reload time.\n"
			+ "Comes with twenty bolts.");
		weapons[22].setLongDescription( //Shortbow
			"A simple but elegant weapon, the bow is perhaps the\n"
			+ "best weapon available for killing an enemy without\n"
			+ "putting yourself in range for that enemy to kill you.\n"
			+ "Comes with twenty arrows.");
		weapons[23].setLongDescription( //Sling
			"Not much more than a simple strip of cloth, used\n"
			+ "to throw rocks, but with a lot more power than just\n"
			+ "using your hand. It takes practice to get good at\n"
			+ "aiming with it, but it is perhaps the cheapest ranged\n"
			+ "weapon on the market.");
		weapons[24].setLongDescription( //Throwing Axe
			"Ever wanted to stick an axe in an enemy, but been\n"
			+ "nervous about getting to close to him? Well look no\n"
			+ "farther. As the name implies, throwing axes are axes\n"
			+ "specially designed to be thrown.");
		weapons[25].setLongDescription( //Throwing Knife
			"It's like playing darts. Except instead of a dartboard,\n"
			+ "you're using an enemy's body. While there are\n"
			+ "certainly more dangerous weapons on the market,\n"
			+ "throwing knives have the advantage of range and speed.");
		weapons[26].setLongDescription( //Warbow
			"If you're looking for a weapon that's easy to use, this\n"
			+ "is decidedly not what you're looking for. Not because\n"
			+ "of complexity, but because of the sheer amount of\n"
			+ "upper body strength you need to fire the thing. If you\n"
			+ "do have the muscle for it, however, this thing\n"
			+ "delivers arrows with absolutely devastating force, and\n"
			+ "over huge distances. Comes with twenty arrows.");
		weapons[27].setLongDescription( //Arrows
			"Ammunition for a bow, arrows are essentially thin shafts\n"
			+ "of wood with sharp metal tips, specially designed to\n"
			+ "fly straight over long distances.\n"
			+ "(You get twenty of these already with the purchase of\n"
			+ "a bow; these packs are just extra ammunition");
		weapons[28].setLongDescription( //Bolts
			"Basically just short arrows designed for use with a\n"
			+ "crossbow.\n"
			+ "(You get twenty of these already with the purchase of\n"
			+ "a crossbow; these packs are just extra ammunition");
		weapons[29].setLongDescription( //Sling Bullets
			"Not going to lie to you: these are just bags of rocks.\n"
			+ "Specifically, rocks that make good slingstones, but if\n"
			+ "you'd rather just buy them than have to find them\n"
			+ "yourself, that's an option.");
		
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
		
		potions[0].setLongDescription(
			"");
		potions[1].setLongDescription(
			"");
		potions[2].setLongDescription(
			"");
		potions[3].setLongDescription(
			"");
		potions[4].setLongDescription(
			"");
		potions[5].setLongDescription(
			"");
		potions[6].setLongDescription(
			"");
		potions[7].setLongDescription(
			"");
		potions[8].setLongDescription(
			"");
		potions[9].setLongDescription(
			"");
		
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
			
			merch[i] = new Merchandise(name, cost);
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
