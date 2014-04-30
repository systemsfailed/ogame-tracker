package coreComponents;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class test {

	public static void main(String[] args)
	{
		
		String text = null;
		String text2 = null;
		
		try {
			text = new Scanner( new File("test.txt") ).useDelimiter("\\A").next();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			text2 = new Scanner( new File("testin") ).useDelimiter("\\A").next();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Raid raid = new Raid(text);
		Raid raid2 = new Raid(text2);
		
		Profile pro = new Profile();
		pro.setName("TestProfile");
		
		pro.addRaid(raid);
		pro.addRaid(raid2);

		
		Profile pro2 = new Profile(pro.toString());
		
		System.out.printf("%d", pro.getRaids());
		
	}
}
