/**
* The <code>Planet</code> class returns an instance of planet,
* an extension of the <code>StorageBase</code> class.
* The planet object contains an <Code>ArrayList</code> of <code>Raid</code>
* objects that share the same planet coordinate.
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

public class Planet extends StorageBase {
	
	private String name; //Coordinate string of this planet
	
	/**
	 * @return
	 * 	Returns the name of this planet
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @param raid
	 * 	A raid object to initialize this day,
	 * 	provides a date to use as a base for the day
	 */
	public Planet(Raid raid)
	{
		super();
		raids.add(raid);
		update();
		name = raid.getPlanet();
	}

}
