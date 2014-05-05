/**
* The <code>DayOverviewPanel</code> class creates an instance of a panel object which
* contains a table that provides an overview of all of the variables of all day objects
* held within a profile
* 
* @author Robert Massina
*    e-mail: Systemsfailed@gmail.com
**/
package systemsfailed.otrack.guicore;

import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JPanel;

import systemsfailed.otrack.corecomponents.Day;
import systemsfailed.otrack.corecomponents.Profile;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;




public class DayOverviewPanel extends JPanel {
	private Profile profile;
	private ArrayList<Day> days;
	private JTable table;
	private Object[][]data;  //Data container for table
	JScrollPane scrollPane;
	private String[] cols =  //Colum names for table
		{"Day",
        "Net Gains",
        "Total Metal",
        "Total Crystal",
        "Total Deut",
        "Losses",
        "Total Damage",
        "# of Raids"};



	/**
	 * Create the panel.
	 */
	public DayOverviewPanel(Profile profile)
	{
		this.profile = profile;
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		buildTable();  //Constructs the data necessary for the table
		table = new JTable(data, cols); //Constructs the table object
		scrollPane.setViewportView(table); //Sets the table to be visible
	
	}
	
	/**
	 * Constructs the multi dimensional array of Objects that a table requires to be built
	 * Iterates through all of the days in the profile and extracts the variables to be displayed
	 * 
	 */
	public void buildTable()
	{
		days = profile.getDays();
		data = new Object[days.size() + 1][8];
		for(int i = 0; i < days.size(); i++)
		{
	
			Day day = days.get(i);
			data[i][0] = day.getDate().getMonth() + "-" + day.getDate().getDate() + "-" + (day.getDate().getYear() + 1900);
			data[i][1] = NumberFormat.getIntegerInstance().format(day.getNetGains());
			data[i][2] = NumberFormat.getIntegerInstance().format(day.getMetal());
			data[i][3] = NumberFormat.getIntegerInstance().format(day.getCrystal());
			data[i][4] = NumberFormat.getIntegerInstance().format(day.getDeuterium());
			data[i][5] = NumberFormat.getIntegerInstance().format(day.getLosses());
			data[i][6] = NumberFormat.getIntegerInstance().format(day.getDamage());
			data[i][7] = NumberFormat.getIntegerInstance().format(day.getNumRaids());
		}
				
		
	}
	
	public void update() //Udates the table with the new data
	{
		buildTable();
		scrollPane.setViewportView(new JTable(data, cols));
	}

	public void setProfile(Profile profile) //Sets a new profile object to be used
	{
		this.profile = profile;
	}
	
}
