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


public class Day extends StorageBase{

	private Date date; //Date object used in sorting
	
	/**
	 * @return
	 * returns the date representatin of this day
	 */
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
	 * Creates a string representation of the day object. Used in
	 * creating a save file to be loaded at a later date
	 */
	public String toString()
	{
		String out = "";
		
		for(int i = 0; i < raids.size(); i++)
			out += raids.get(i).toString();
		
		return out;
	}
	

	
}
