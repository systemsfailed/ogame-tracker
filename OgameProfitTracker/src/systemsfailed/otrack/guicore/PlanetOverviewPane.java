/**
* The <code>PlanetOverview</code> class creates an instance of a panel object which
* creates and displays a table view of every day object within the profile
* 
* @author Robert Massina
*    e-mail: Systemsfailed@gmail.com
**/

package systemsfailed.otrack.guicore;

import java.awt.BorderLayout;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import systemsfailed.otrack.corecomponents.Player;
import systemsfailed.otrack.corecomponents.Profile;




public class PlanetOverviewPane extends JPanel {
	private Profile profile;
	private ArrayList<Player> players;
	private JTable table;
	private Object[][]data;
	JScrollPane scrollPane;
	private String[] cols =  //Names of all columns in the table
		{"Planet",
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
	public PlanetOverviewPane(Profile profile)
	{
		this.profile = profile;
		setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		buildTable();
		table = new JTable(data, cols);
		scrollPane.setViewportView(table);
	
	}
	
	/**
	 * Creates the data array that is used to build the table
	 * that displays the contents of all day objects
	 */
	public void buildTable()
	{
		int numPlan = 0;
		for(int i = 0; i < profile.getPlayers().size(); i++)
		{
			for(int k = 0; k < profile.getPlayers().get(i).getPlanets().size(); k++)
				numPlan++;
		}
		players = profile.getPlayers();
		data = new Object[numPlan][8];
	
		for(int i = 0; i < profile.getPlayers().size(); i++)
		{
			Player player = players.get(i);
			for(int k = 0; k < profile.getPlayers().get(i).getPlanets().size(); k++)
			{
				data[i][0] = player.getPlanets().get(k).getName();
				data[i][1] = NumberFormat.getIntegerInstance().format(player.getPlanets().get(k).getNetGains());
				data[i][2] = NumberFormat.getIntegerInstance().format(player.getPlanets().get(k).getMetal());
				data[i][3] = NumberFormat.getIntegerInstance().format(player.getPlanets().get(k).getCrystal());
				data[i][4] = NumberFormat.getIntegerInstance().format(player.getPlanets().get(k).getDeuterium());
				data[i][5] = NumberFormat.getIntegerInstance().format(player.getPlanets().get(k).getLosses());
				data[i][6] = NumberFormat.getIntegerInstance().format(player.getPlanets().get(k).getDamage());
				data[i][7] = NumberFormat.getIntegerInstance().format(player.getPlanets().get(k).getNumRaids());
			}
		}		
		
	}
	
	/**
	 * Calls the build method and then refreshes the pane to display
	 * the new table
	 */
	public void update()
	{
		buildTable();
		scrollPane.setViewportView(new JTable(data, cols));
	}

	/**
	 * Passes a new profile object to this panel to use as a 
	 * base for the table
	 * @param profile
	 * 	A new profile object to be used to create the table
	 */
	public void setProfile(Profile profile)
	{
		this.profile = profile;
	}

	
}
