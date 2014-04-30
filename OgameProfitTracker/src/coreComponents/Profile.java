package coreComponents;

import java.util.ArrayList;
import java.util.Collections;



public class Profile {

	private String name;
	private ArrayList<Day> days;
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList<Day> getDays()
	{
		return days;
	}
	
	public int getGains()
	{
		int sum = 0;
		for(int i = 0; i < days.size(); i++)
		{
			sum += days.get(i).getGains();
		}
		
		return sum;
	}
	
	public int getNetGains()
	{
		int sum = 0;
		for(int i = 0; i < days.size(); i++)
		{
			sum += days.get(i).getNetGains();
		}
		
		return sum;
	}
	
	public int getLosses()
	{
		int sum = 0;
		for(int i = 0; i < days.size(); i++)
		{
			sum += days.get(i).getLosses();
		}
		
		return sum;
	}
	
	public int getDamage()
	{
		int sum = 0;
		for(int i = 0; i < days.size(); i++)
		{
			sum += days.get(i).getDamage();
		}
		
		return sum;
	}
	
	public int getMetal()
	{
		int sum = 0;
		for(int i = 0; i < days.size(); i++)
		{
			sum += days.get(i).getMetal();
		}
		
		return sum;
	}
	
	public int getCrystal()
	{
		int sum = 0;
		for(int i = 0; i < days.size(); i++)
		{
			sum += days.get(i).getCrystal();
		}
		
		return sum;
	}
	
	public int getDeuterium()
	{
		int sum = 0;
		for(int i = 0; i < days.size(); i++)
		{
			sum += days.get(i).getDeuterium();
		}
		
		return sum;
	}
	
	public int getRaids()
	{
		int sum = 0;
		for(int i = 0; i < days.size(); i++)
		{
			sum += days.get(i).getNumRaids();
		}
		
		return sum;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
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
		
	}
	
	public void addRaid(Raid[] raids)
	{
		boolean needsSorting = false;
		
		for(int i = 0; i < raids.length; i++)
		{
			boolean added = false;
		
			if(days.isEmpty())
				days.add(new Day(raids[i]));
			
			else
			{
				for(int k = 0; k < days.size(); k++)
				{
					if(raids[i].getDate() == days.get(k).getDate())
					{
						days.get(k).addRaid(raids[i]);
						added = true;
						break;
					}
			
				}
		
				if(!added)	
				{
					days.add(new Day(raids[i])); 
					needsSorting = true;
				}
			}
		}
		
		if(needsSorting)
			sortDays();
	}
	
	public void sortDays()
	{
		Collections.sort(days, new DateComparator());
	}
	
	
	public Profile()
	{
		days = new ArrayList<Day>();
		
	}
	
	
	public Profile(String input)
	{
		days = new ArrayList<Day>();
		
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
	
	public String toString()
	{
		String out = name + "@@";

		for(int i = 0; i < days.size(); i++)
			out += days.get(i).toString();

		return out;
	
	}
	
}
