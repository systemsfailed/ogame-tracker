/**
* The <code>Raid</code> class returns an instance of a 
* Raid object.
* The raid object is the smallest unit of storage within a profile, it contains
* all of the data contained within a combat report, and is sorted within
* Day and Player objects.
* 
* @author Robert Massina
*    e-mail: Systemsfailed@gmail.com
**/

package systemsfailed.otrack.corecomponents;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Date;


public class Raid {

	private int metal,crystal,deuterium;
	private int losses, damage;
	
	private String report;
	private String player, planet;
	public Date date;
	
	public int getMetal() {
		return metal;
	}

	public int getCrystal() {
		return crystal;
	}
	
	public int getDeuterium() {
		return deuterium;
	}

	public int getLosses() {
		return losses;
	}
	
	public int getDamage()
	{
		return damage;
	}
	
	public String getPlayer()
	{
		return player;
	}
	
	public String getPlanet()
	{
		return planet;
	}

	public Date getDate() {
		return date;
	}
	
	
	/**
	 * Creates a Raid object from a single combat report
	 * @param report
	 * 	String representation of a combat report
	 */
	public Raid(String report)
	{
		this.report = report;
		try {
			generateRaid();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Recreates a Raid object from the ToString method of another Raid object
	 * 
	 * @param in
	 * 	String array representation of a Raid toString method
	 */
	public Raid(String[] in)
	{
		date = new Date(Integer.parseInt(in[2]), Integer.parseInt(in[1]), Integer.parseInt(in[0]));
		metal = Integer.parseInt(in[3]);
		crystal = Integer.parseInt(in[4]);
		deuterium = Integer.parseInt(in[5]);
		losses = Integer.parseInt(in[6]);
		damage = Integer.parseInt(in[7]);
		player = in[8];
		planet = in[9];
		report = in[10];
	}
	
	/**
	 * This method takes the combat report stored within a newly initialized Raid
	 * and parses that report into all of the values held within the raid
	 *
	 * @throws IOException
	 * 	Throws an IOException if there is a problem with the report given to the Raid
	 */
	public void generateRaid() throws IOException, IllegalArgumentException
	{
		if(report.contains("Attacker")) //Checks to make sure that the report is a combat report
		{
			int year, month, day;
			planet = null;
			String temp;
			BufferedReader reader = new BufferedReader(new StringReader(report));
		
			temp = reader.readLine();
		
			day = Integer.parseInt(temp.substring(temp.indexOf("(")+1, temp.indexOf(".")));
		
			month = Integer.parseInt(temp.substring(temp.indexOf(".") + 1, temp.indexOf(".", temp.indexOf(".") + 1)));
		
			temp.replaceFirst(".", " ");
		
			year = Integer.parseInt(temp.substring(temp.indexOf(".", temp.indexOf(".") + 1) + 1, temp.indexOf(".", temp.indexOf(".") + 1) + 5)) - 1900;
		
			date = new Date(year, month, day);
		
		
			while((temp = reader.readLine())!= null)
			{
				if(temp.contains("vs."))
				{
					player = temp.substring(temp.indexOf("vs.") + 4, temp.length());
				}
				if(temp.contains(player + " [") & planet == null)
				{
					String[] location = temp.substring(temp.indexOf("[") + 1, temp.indexOf("]")).split(":");
					planet = location[0] + ":" + location[1] + ":" + location[2];
				}
				if(temp.contains("metal,"))
				{
					metal = Integer.parseInt((temp.substring(temp.indexOf("captured") + 9, temp.indexOf("metal") - 1)).replaceAll("[/.]", ""));
				}
				if(temp.contains("crystal and"))
				{
					crystal = Integer.parseInt((temp.substring(temp.indexOf("metal") + 7, temp.indexOf("crystal") - 1)).replaceAll("[/.]", ""));
				}
				if(temp.contains("deuterium"))
				{
					deuterium = Integer.parseInt((temp.substring(temp.indexOf("and") + 4, temp.indexOf("deuterium") - 1)).replaceAll("[/.]", ""));
				}
			
				if(temp.contains("attacker lost "))
				{
					losses = Integer.parseInt((temp.substring(temp.indexOf("of ") + 3, temp.indexOf("units") - 1)).replaceAll("[/.]", ""));
				}
				
				if(temp.contains("defender lost "))
				{
					damage = Integer.parseInt((temp.substring(temp.indexOf("of ") + 3, temp.indexOf("units") - 1)).replaceAll("[/.]", ""));
				}
			}
		}
		
		else
			throw new IllegalArgumentException();
	
	}
	
	/**
	 * Creates a string representation of the Raid object. Primarily used in 
	 * creating saves that can be loaded with the overloaded construcor
	 */
	public String toString()
	{
		return "Raid" + date.getDay() + "-" + date.getMonth() + "-" + date.getYear()
				+ "-" + metal + "-" + crystal + "-" + deuterium + "-"
				+ losses + "-" + damage + "-" + player + "-" + planet + "-" + report;
	}
	
	
}
