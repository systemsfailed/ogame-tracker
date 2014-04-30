/**
* The <code>Profile</code> class returns an instance of a 
* profile object which is used as the main object to store all others.
* This object contains all <code>Raid</code>, <code>Player</code> and <code>Day</code>
* objects that are used within this program. The Profile object can be saved in string
* format for later use
* 
* @author Robert Massina
*    e-mail: Systemsfailed@gmail.com
**/

package systemsfailed.otrack.corecomponents;

import java.util.ArrayList;
import java.util.Collections;



public class Profile {

	private String name;
	private ArrayList<Day> days;
	private ArrayList<Player> players;
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList<Day> getDays()
	{
		return days;
	}

	public ArrayList<Player> getPlayers()
	{
		return players;
	}
	
	/**
	 * Iterates through all days and sums their gains together
	 * 
	 * @return
	 * 	Sum total of all contained Day object's gains
	 */
	public int getGains()
	{
		int sum = 0;
		for(int i = 0; i < days.size(); i++)
		{
			sum += days.get(i).getGains();
		}
		
		return sum;
	}
	
	/**
	 * Sums all day's gains and losses and subtracts them
	 * 
	 * @return
	 * 	Returns the sum total of all Day's gains subtracted with thier losses
	 */
	public int getNetGains()
	{
		int sum = 0;
		for(int i = 0; i < days.size(); i++)
		{
			sum += days.get(i).getNetGains();
		}
		
		return sum;
	}
	
	/**
	 * Sums losses from all contained Day objects
	 * @return
	 * 	Sum of all Days' losses
	 */
	public int getLosses()
	{
		int sum = 0;
		for(int i = 0; i < days.size(); i++)
		{
			sum += days.get(i).getLosses();
		}
		
		return sum;
	}
	
	/**
	 * Sums all contained Day's damages
	 * 
	 * @return
	 * 	Sum of all Days' inflicted damages
	 */
	
	public int getDamage()
	{
		int sum = 0;
		for(int i = 0; i < days.size(); i++)
		{
			sum += days.get(i).getDamage();
		}
		
		return sum;
	}
	
	/**
	 * Sums all metal gains from each Day
	 * @return
	 * 	Sum of all Day's metal gains
	 */
	public int getMetal()
	{
		int sum = 0;
		for(int i = 0; i < days.size(); i++)
		{
			sum += days.get(i).getMetal();
		}
		
		return sum;
	}
	/**
	 *Sums all crystal gains from each Day
	 *
	 * @return
	 * 	Sum of all Day's crystal gains
	 */
	public int getCrystal()
	{
		int sum = 0;
		for(int i = 0; i < days.size(); i++)
		{
			sum += days.get(i).getCrystal();
		}
		
		return sum;
	}
	
	/**
	 * Sums all deuterium gains from each Day
	 * 
	 * @return
	 * 	Sum of all Day's deuterium gains
	 */
	public int getDeuterium()
	{
		int sum = 0;
		for(int i = 0; i < days.size(); i++)
		{
			sum += days.get(i).getDeuterium();
		}
		
		return sum;
	}
	
	/**
	 * Displays the total amount of raids performed on thsi profile
	 * 
	 * @return
	 * 	Total number of raids done on this profile
	 */
	public int getRaids()
	{
		int sum = 0;
		for(int i = 0; i < days.size(); i++)
		{
			sum += days.get(i).getNumRaids();
		}
		
		return sum;
	}
	/**
	 * @return
	 * 	Returns the number of player's contained within the profile
	 */
	public int getNumPlayers()
	{
		return players.size();
	}
	/**
	 * @param name
	 * 	String containing the new name of the profile
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * Adds a given raid to the profile, sending it to both
	 * the Days array as well as the Player's array for sorting
	 * @param raid
	 * 	A raid object to be added to the profile. Added to both players and days array
	 */
	public void addRaid(Raid raid)
	{
		boolean added = false;
		
		if(days.isEmpty())
		{
			days.add(new Day(raid));
		}
		else
		{
			for(int i = 0; i < days.size(); i++)
			{
				if(raid.getDate().equals(days.get(i).getDate()))
				{
					days.get(i).addRaid(raid);
					added = true;
					break;
				}
			
			}
		
			if(!added)
			{ 
				days.add(new Day(raid));
				sortDays();
			}
		}
			boolean found = false;
			
			if(players.isEmpty())
				players.add(new Player(raid));

			else
			{
				for(int i = 0; i < players.size(); i++)
				{
					if(players.get(i).getName() == raid.getPlayer())
					{
						players.get(i).addRaid(raid);
						found = true;
					}
				}
				if(!found)
					players.add(new Player(raid));
			}
	}
	/**
	 * A helper array for the mass combat report input, same as AddRaid but with
	 * no sorting in order to prevent multiple sorts in a row
	 * 
	 * @param raid
	 *	Raid to be added to the profile
	 */
	public void addRaidHelper(Raid raid)
	{
		boolean added = false;
		
		if(days.isEmpty())
		{
			days.add(new Day(raid));
		}
		else
		{
			for(int i = 0; i < days.size(); i++)
			{
				if(raid.getDate().equals(days.get(i).getDate()))
				{
					days.get(i).addRaid(raid);
					added = true;
					break;
				}
			
			}
		
			if(!added)
			{ 
				days.add(new Day(raid));
			}
		}
			boolean found = false;
			
			if(players.isEmpty())
				players.add(new Player(raid));

			else
			{
				for(int i = 0; i < players.size(); i++)
				{
					if(players.get(i).getName() == raid.getPlayer())
					{
						players.get(i).addRaid(raid);
						found = true;
					}
				}
				if(!found)
					players.add(new Player(raid));
			}
	}
	
	/**
	 * An overloaded version of the <method>addRaid()</method> method
	 * it accepts an array of Raids to be input at once as opposed to a 
	 * single raid
	 * 
	 * @param raids
	 * 	An array of Raid objects to be added to the profile
	 */
	public void addRaid(Raid[] raids)
	{
		
		for(int i = 0; i < raids.length; i++)
			addRaidHelper(raids[i]);
		
			sortDays();
	}
	
	/**
	 * A method to sort all of the days contained in the array by date
	 */
	public void sortDays()
	{
		Collections.sort(days, new DateComparator());
	}
	
	/**
	 * Default constructor, initalizes the arrays
	 */
	public Profile()
	{
		days = new ArrayList<Day>();
		players = new ArrayList<Player>();
	}
	
	/**
	 * Constructor to be used when loading from a save file. Takes in a toString
	 * argument of a profile and will reconstruct it from that data
	 * @param input
	 * 	The toString representation of a profile
	 */
	public Profile(String input)
	{
		days = new ArrayList<Day>();
		players = new ArrayList<Player>();
		
		String[] in = input.split("@@");
		name = in[0];
		in = in[1].split("Raid");
				
		for(int i = 1; i < in.length; i++)
		{
			if(in[i] != null)
				addRaid(new Raid(in[i].split("-")));
		}
		
		sortDays();
	}
	
	/**
	 * Creates a string representation of the Profile object.
	 * Used to create a save file that can be used to reconstruct a profile
	 */
	
	public String toString()
	{
		String out = name + "@@";

		for(int i = 0; i < days.size(); i++)
			out += days.get(i).toString();

		return out;
	
	}
	
}
