# Fantasy Shop Simulator

## Synopsis
A rough simulation of shopping in a fantasy RPG in preparation for going out and adventuring.

## How to Run
Shop.java contains the main method.
All files are required (the text files specifically for stocking the merchandise).

## Code Example
This was my first time properly utilizing a Scanner to read from a file.
Code like the following is what "stocks" items in the shop.

'''
    
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
'''
