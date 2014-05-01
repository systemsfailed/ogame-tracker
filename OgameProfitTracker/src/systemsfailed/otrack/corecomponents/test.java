package systemsfailed.otrack.corecomponents;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JOptionPane;

import systemsfailed.otrack.guicore.DayOverviewPanel;


public class test {

	public static void main(String[] args) throws FileNotFoundException
	{
			
		Scanner scanner = new Scanner(new File("testin")).useDelimiter("//A");
		Profile pro = new Profile();
		pro.setName("TestProfile");
		
		Raid raid = new Raid(scanner.next());
		
		Path path = Paths.get(System.getProperty("user.home")+"\\My Documents\\OTracker");
		if(Files.exists(path))
				System.out.printf("Her");
		else
			new File(path.toString()).mkdir();
		
		Path path2 = Paths.get(System.getProperty("user.home")+"\\My Documents\\OTracker\\hax.txt");

		
		PrintWriter thinger;
		
		if(Files.exists(path2))
			System.out.printf("Kay");
		else
		{
		thinger = new PrintWriter(path2.toString());
		thinger.println("AWW YIS");
		thinger.close();
		}
		
		
	}
}

