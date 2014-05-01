/**
* The <code>Player</code> class returns an instance of a Player object
* which is used to store raids pertaining to an individual player.
* 
* The Player class contains an <code>ArrayList</code> for storing raids
* and other for storing the planet's of the player that have been raided.
* 
* @author Robert Massina
*    e-mail: Systemsfailed@gmail.com
**/

package systemsfailed.otrack.corecomponents;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
	
	private int metal,crystal,deuterium,damage;
	private ArrayList<String> planets;  //A list of all of the player's planets
	private ArrayList<Raid> raids; //A list containing all raids aginst this player
	private String name;
	
	public String getName() 
	{
		return name;
	}

	public int getMetal() 
	{
		return metal;
	}

	public int getCrystal() 
	{
		return crystal;
	}

	public int getDeuterium() 
	{
		return deuterium;
	}

	public int getDamage() 
	{
		return damage;
	}

	public ArrayList<String> getPlanets() 
	{
		return planets;
	}

	public ArrayList<Raid> getRaids()
	{
		return raids;
	}
	
	
	/**
	 * Adds a planet to this player
	 * 
	 * @param s
	 * 	String representation of a planet belonging to this player
	 */
	public void addPlanet(String s)
	{
		planets.add(s);
	}
	
	/**
	 * Checks the player object to see if it contains a planet in it's
	 * list
	 * 
	 * @param planet
	 * 	A string representation of a planet
	 * 
	 * @return
	 * 	Returns true if the player owns the requested planet
	 * 	Returns false if the player does now own requested planet
	 */
	public boolean containsPlanet(String planet)
	{
		if(planets.contains(planet))
			return true;
		else
			return false;
	}
	
	/**
	 * Adds a new raid to this player, as well as checks to see
	 * if the planet the raid occurred on is already in the player's
	 * list, if it is not it will be added.
	 * 
	 * @param raid
	 * 	A Raid object to be added to this player
	 */
	public void addRaid(Raid raid)
	{
		raids.add(raid);
		Collections.sort(raids, new RaidComparator());
		update();
		if(!planets.contains(raid.getPlanet()))
				planets.add(raid.getPlanet());
	}
	
	/**
	 * Removes a selected raid from this player
	 * 
	 * @param i
	 * 	Index of the raid to be removed
	 */
	public void removeRaid(int i)
	{
		raids.remove(i);
		update();
	}
	
	/**
	 * Updates all variables in this Player object by iterating through
	 * all of the raids and summing up all of their variables
	 * 
	 */
	public void update()
	{
		metal = crystal = deuterium = damage = 0;
		for(int i = 0; i < raids.size(); i++)
		{
			metal += raids.get(i).getMetal();
			crystal += raids.get(i).getCrystal();
			deuterium += raids.get(i).getDeuterium();
			damage += raids.get(i).getDamage();
		}
	}
	
	/**
	 * Creates a new instance of <code>Player</code>
	 * @param name
	 * 	Name of the player to be created
	 * @param raid
	 * 	Raid to be added to the player
	 */
	public Player(Raid raid)
	{
		name = raid.getPlayer();
		planets = new ArrayList<String>();
		raids = new ArrayList<Raid>();
		addRaid(raid);
	}
	
	

}
