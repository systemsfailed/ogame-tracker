package systemsfailed.otrack.guicore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

import systemsfailed.otrack.corecomponents.Day;
import systemsfailed.otrack.corecomponents.Profile;
import systemsfailed.otrack.corecomponents.Raid;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DayOverviewPanel extends JPanel {
	private JTable table;
	private Profile profile;

	/**
	 * Create the panel.
	 * @throws FileNotFoundException 
	 */
	public DayOverviewPanel(Profile profile) throws FileNotFoundException {
		this.profile =  new Profile();
		Scanner scanner = new Scanner(new File("testin")).useDelimiter("//A");
		Raid raid = new Raid(scanner.next());
		this.profile.addRaid(raid);
		buildTable();
		add(table);
		table.setEnabled(false);
	

	}
	
	public void buildTable()
	{
		ArrayList<Day> days = profile.getDays();
		Object[][] data = new Object[days.size() + 1][8];
		data[0][0] = "Date";
		data[0][1] = "Net Gain";
		data[0][2] = "Metal";
		for(int i = 0; i < days.size(); i++)
		{
			Day day = days.get(i);
			data[i+1][0] = day.getDate().getMonth() + "-" + day.getDate().getDate() + "-" + (day.getDate().getYear() + 1900);
			data[i+1][1] = day.getNetGains();
			data[i+1][2] = day.getMetal();
			data[i+1][3] = day.getCrystal();
			data[i+1][4] = day.getDeuterium();
			data[i+1][5] = day.getLosses();
			data[i+1][6] = day.getDamage();
			data[i+1][7] = day.getNumRaids();
			
		}
		
		String[] columnNames = {"Day",
                "Net_Gains",
                "Total_Metal",
                "Total_Crystal",
                "Total_Deut",
                "Losses",
                "Total_Damage",
                "# of Raids"};
		
		table = new JTable(data, columnNames);
		
	}

}
