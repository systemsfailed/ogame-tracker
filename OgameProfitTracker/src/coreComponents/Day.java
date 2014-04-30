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
	
	public Day(Raid raid)
	{
		raids = new ArrayList<Raid>();
		raids.add(raid);
		date = raid.getDate();
		metal = raid.getMetal();
		crystal = raid.getCrystal();
		deuterium = raid.getDeuterium();
		losses = raids.get(0).getLosses();
		
	}
	
	public void updateRes()
	{
		metal = crystal = deuterium = 0;
		
		for(int i = 0; i < raids.size(); i++)
		{
			metal += raids.get(i).getMetal();
			crystal += raids.get(i).getCrystal();
			deuterium += raids.get(i).getDeuterium();
		}
		
	}
	
	public void updateGains()
	{
		gains = metal+crystal+deuterium;
	}
	
	public void updateLosses()
	{
		losses = 0;
		for(int i = 0; i < raids.size(); i++)
		{
			losses += raids.get(i).getLosses();
		}
	}
	
	public int getNetGains()
	{
		return gains - losses;
	}
	
	public int getGains()
	{
		return gains;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public void removeRaid(int index)
	{
		raids.remove(index);
	}
	
	public void addRaid(Raid raid)
	{
		raids.add(raid);
		updateRes();
		updateGains();
	}
	
	public String toString()
	{
		String out = "";
		
		for(int i = 0; i < raids.size(); i++)
			out += raids.get(i).toString() + ",";
		
		return out;
	}
	

	
}
