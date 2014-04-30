package coreComponents;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class test {

	public static void main(String[] args)
	{
		
		String text = null;
		
		try {
			text = new Scanner( new File("test.txt") ).useDelimiter("\\A").next();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Raid raid = new Raid(text);
		
		Profile pro = new Profile();
		pro.setName("Gay");
		
		pro.addRaid(raid);
		
		System.out.printf("%s", pro.toString());

		
	}
}
