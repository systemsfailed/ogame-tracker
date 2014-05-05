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

public class Player extends StorageBase{
	
	private ArrayList<Planet> planets;  //A list of all of the player's planets
	private String name;
	
	/** 
	 * @return
	 * 	Returns the player's name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @return
	 * 	Returns an <code>ArrayList</code> of planet objects
	 */
	public ArrayList<Planet> getPlanets() 
	{
		return planets;
	}
	
	/**
	 * @return
	 * 	Returns an <code>ArrayList</code> of the raids on this
	 * 	planet
	 */
	public ArrayList<Raid> getRaids()
	{
		return raids;
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
		boolean found = false;
		raids.add(raid);
		Collections.sort(raids, new RaidComparator());
		update();
		
		for(int i = 0; i < planets.size(); i++)
		{
			if(planets.get(i).getName().equals(raid.getPlanet()))
			{
				planets.get(i).addRaid(raid);
				found = true;
			}
		}
		
		if(!found)
				planets.add(new Planet(raid));
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
	 * Creates a new instance of <code>Player</code>
	 * @param name
	 * 	Name of the player to be created
	 * @param raid
	 * 	Raid to be added to the player
	 */
	public Player(Raid raid)
	{
		name = raid.getPlayer();
		planets = new ArrayList<Planet>();
		raids = new ArrayList<Raid>();
		addRaid(raid);
	}

	
	
	

}
