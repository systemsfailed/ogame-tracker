package coreComponents;

import java.sql.Date;
import java.util.ArrayList;


public class Day {

	private ArrayList<Raid> raids;
	private Date date;
	
	private int gains;
	private int metal;
	private int crystal;
	private int deuterium;
	private int losses;
	private int damage;
	
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

	public Day(Raid raid)
	{
		raids = new ArrayList<Raid>();
		raids.add(raid);
		this.date = raid.getDate();
		update();
		
	}
	
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
	
	public void removeRaid(int index)
	{
		raids.remove(index);
		update();
	}
	
	public void addRaid(Raid raid)
	{
		raids.add(raid);
		update();
	}
	
	public String toString()
	{
		String out = "";
		
		for(int i = 0; i < raids.size(); i++)
			out += raids.get(i).toString() + ",";
		
		return out;
	}
	

	
}
