package coreComponents;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Date;


public class Raid {

	private int metal,crystal,deuterium;
	private int losses, damage;
	
	private String report;
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

	public Date getDate() {
		return date;
	}
	
	
	public Raid(String report)
	{
		this.report = report;
		try {
			generateRaid(report);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Raid(String[] in)
	{
		date = new Date(Integer.parseInt(in[2]), Integer.parseInt(in[1]), Integer.parseInt(in[0]));
		metal = Integer.parseInt(in[3]);
		crystal = Integer.parseInt(in[4]);
		deuterium = Integer.parseInt(in[5]);
		losses = Integer.parseInt(in[6]);
		damage = Integer.parseInt(in[7]);
		report = in[8];
	}
	
	
	public void generateRaid(String raid) throws IOException
	{
		int year, month, day;
		String temp;
		BufferedReader reader = new BufferedReader(new StringReader(raid));
		
		temp = reader.readLine();
		
		day = Integer.parseInt(temp.substring(temp.indexOf("(")+1, temp.indexOf(".")));
		
		month = Integer.parseInt(temp.substring(temp.indexOf(".") + 1, temp.indexOf(".", temp.indexOf(".") + 1)));
		
		temp.replaceFirst(".", " ");
		
		year = Integer.parseInt(temp.substring(temp.indexOf(".", temp.indexOf(".") + 1) + 1, temp.indexOf(".", temp.indexOf(".") + 1) + 5));
		
		date = new Date(year, month, day);
		
		
		while((temp = reader.readLine())!= null)
		{
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
	
	public String toString()
	{
		return "Raid" + date.getDay() + "-" + date.getMonth() + "-" + date.getYear()
				+ "-" + metal + "-" + crystal + "-" + deuterium + "-"
				+ losses + "-" + damage + "-" + report;
	}
	
	
}
