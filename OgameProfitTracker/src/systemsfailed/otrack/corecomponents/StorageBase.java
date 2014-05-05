package systemsfailed.otrack.corecomponents;

import java.util.ArrayList;

public class StorageBase {
	
	protected int metal,crystal,deuterium,losses,damage,gains; //Variables computed by summing list of raids
	protected ArrayList<Raid> raids; //Container for all raids held within this object
	
	/**
	 * @return
	 * 	Returns the metal variable
	 */
	public int getMetal() {
		return metal;
	}
	
	/** 
	 * @return
	 * 	Returns the crystal variable
	 */
	public int getCrystal() {
		return crystal;
	}

	/**
	 * @return
	 * 	Returns the deuterium variable
	 */
	public int getDeuterium() {
		return deuterium;
	}

	/**
	 * @return
	 * 	Returns the losses variable
	 */
	public int getLosses() {
		return losses;
	}

	/**
	 * @return
	 * 	Returns the damage variable
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @return
	 * 	Returns the sum of metal crystal and deuterium
	 */
	public int getGains() {
		return gains;
	}
	
	/**
	 * @return
	 * 	Returns gains - losses
	 */
	public int getNetGains()
	{
		return gains - losses;
	}

	/**
	 * @return
	 * 	Returns the <code>ArrayList</code> of raids
	 */
	public ArrayList<Raid> getRaids()
	{
		return raids;
	}
	
	/**
	 * @return
	 * 	Returns the amount of raids held within the
	 * 	<code>ArrayList</code>
	 */
	public int getNumRaids()
	{
		return raids.size();
	}
	
	/**
	 * A method to search for and return the raid contained within
	 * that has the highest net gain variable
	 * 
	 * @return
	 * 	Returns a raid object with the highest net gain
	 */
	public Raid getMostProfit()
	{
		Raid max = raids.get(0);
		for(int i = 0; i < raids.size(); i++)
		{
			if(raids.get(0).getNetGains() > max.getNetGains())
				max = raids.get(i);
		}
		return max;
	}
	
	/**
	 * A method to search for and return the raid contained within
	 * that has the highest damage variable
	 * 
	 * @return
	 * 	Returns a raid object with the highest damage
	 */
	public Raid getMostDamage()
	{
		Raid max = raids.get(0);
		for(int i = 0; i < raids.size(); i++)
		{
			if(raids.get(0).getDamage() > max.getDamage())
				max = raids.get(i);
		}
		return max;
	}
	
	/**
	 * A method to search for and return the raid contained within
	 * that has the highest loss variable
	 * 
	 * @return
	 * 	Returns a raid object with the highest losses
	 */
	public Raid getMostLoss()
	{
		Raid max = raids.get(0);
		for(int i = 0; i < raids.size(); i++)
		{
			if(raids.get(0).getLosses() > max.getLosses())
				max = raids.get(i);
		}
		return max;
	}
	
	/**
	 * A method to search for and check if this object
	 * contains a particular raid
	 * 
	 * @return
	 * 	Returns true if raid is found;
	 * 	False otherwise
	 */
	public boolean contains(Raid raid)
	{
		boolean contains = false;
		for(int i = 0; i < raids.size(); i++)
		{
			if(raids.get(i).equals(raid))
			{
				contains = true;
			}
		}
		return contains;
	}
	
	
	/**
	 * Adds selected Raid to the object
	 * 
	 * @param raid
	 * 	A raid object to be added to this object
	 */
	
	public void addRaid(Raid raid)
	{
		raids.add(raid);
		update();
	}
	
	/**
	 * Updates all variables in this Player object by iterating through
	 * all of the raids and summing up all of their variables
	 * 
	 */
	public void update()
	{
		metal = crystal = deuterium = damage = losses = 0;
		for(int i = 0; i < raids.size(); i++)
		{
			metal += raids.get(i).getMetal();
			crystal += raids.get(i).getCrystal();
			deuterium += raids.get(i).getDeuterium();
			damage += raids.get(i).getDamage();
			losses += raids.get(i).getLosses();
		}
		gains = metal + crystal + deuterium;
	}
	
	/**
	 * Default constructor for <code>StorageBase</code> objects
	 */
	public StorageBase()
	{
		raids = new ArrayList<Raid>();
	}

}
