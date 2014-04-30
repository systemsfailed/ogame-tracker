/**
* The <code>Day</code> class returns an instance of day
* which contains an <Code>ArrayList</code> of <code>Raid</code>
* objects that share the same date.
* It is the class that is used as a container for individual raids and 
* is the basis on which they are sorted.
* 
* Also contains some values to store the sum total of all of the 
* values stored within each raid
* 
* @author Robert Massina
*    e-mail: Systemsfailed@gmail.com
**/

package systemsfailed.otrack.corecomponents;

import java.sql.Date;
import java.util.ArrayList;


public class Day {

	private ArrayList<Raid> raids; //ArrayList that holds every raid from this day
	private Date date; //Date object used in sorting
	
	private int gains; //Total resources gained on this day
	private int metal;
	private int crystal;
	private int deuterium;
	private int losses; //Total damage suffered in attacks
	private int damage; //Total damage done
	
	public ArrayList<Raid> getRaids() 
	{
		return raids;
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

	public int getLosses() 
	{
		return losses;
	}
	
	public int getNetGains()
	{
		return gains - losses;
	}
	
	public int getGains()
	{
		return gains;
	}
	
	public int getNumRaids()
	{
		return raids.size();
	}
	
	public int getDamage()
	{
		return damage;
	}
	
	public Date getDate()
	{
		return date;
	}

	/**
	 * Creates a new Day object from the information in a raid
	 * 
	 * @param raid
	 * 	The raid that is used to initialize the Day object, the date 
	 * 	of the raid will be used to set the date of this day
	 */
	
	public Day(Raid raid)
	{
		raids = new ArrayList<Raid>();
		raids.add(raid);
		this.date = raid.getDate();
		update();
		
	}
	
	/**
	 * Updates all of the variables by iterating through the
	 * array of raids and summing up all of their variables
	 */
	
	public void update()
	{
		metal = crystal = deuterium = losses = damage = 0;
		
		for(int i = 0; i < raids.size(); i++)
		{
			metal += raids.get(i).getMetal();
			crystal += raids.get(i).getCrystal();
			deuterium += raids.get(i).getDeuterium();
			losses += raids.get(i).getLosses();
			damage += raids.get(i).getDamage();
		}
		gains = metal+crystal+deuterium;
		
	}
	
	/**
	 * Removes a selected raid from the day
	 * 
	 * @param index
	 * 	The index within the ArrayList to be removed
	 */
	
	public void removeRaid(int index)
	{
		raids.remove(index);
		update();
	}
	
	/**
	 * Adds selected Raid to the day
	 * 
	 * @param raid
	 * 	A raid object to be added to this day
	 */
	
	public void addRaid(Raid raid)
	{
		raids.add(raid);
		update();
	}
	
	/**
	 * Creates a string representation of the day object. Used in
	 * creating a save file to be loaded at a later date
	 */
	
	public String toString()
	{
		String out = "";
		
		for(int i = 0; i < raids.size(); i++)
			out += raids.get(i).toString() + ",";
		
		return out;
	}
	

	
}
