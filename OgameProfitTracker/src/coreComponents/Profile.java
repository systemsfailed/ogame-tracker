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
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void addRaid(Raid raid)
	{
		boolean added = false;
		
		
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
		}
		
	}
	
	public void addRaid(Raid[] raids)
	{
		boolean needsSorting = false;
		
		for(int i = 0; i < raids.length; i++)
		{
			boolean added = false;
		
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
		String[] in = input.split("@@");
		in[0] = name;
		in = in[1].split("Raid");
		
		for(int i = 0; i < in.length; i++)
		{
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
