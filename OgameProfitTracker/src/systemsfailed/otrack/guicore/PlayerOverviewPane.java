/**
* The <code>PlayerOverviewPane</code> class creates an instance of a panel object which
* creates and displays a table view of every Player object within the profile
* 
* @author Robert Massina
*    e-mail: Systemsfailed@gmail.com
**/

package systemsfailed.otrack.guicore;

import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JPanel;

import systemsfailed.otrack.corecomponents.Player;
import systemsfailed.otrack.corecomponents.Profile;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;




public class PlayerOverviewPane extends JPanel {
	private Profile profile;
	private ArrayList<Player> players;
	private JTable table;
	private Object[][]data;
	private JScrollPane scrollPane;
	private String[] cols =  //Column names for table
		{"Player Name",
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
	public PlayerOverviewPane(Profile profile)
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
	 * Constructs the multi dimensional array of Objects that a table requires to be built
	 * Iterates through all of the players in the profile and extracts the variables to be displayed
	 * 
	 */
	public void buildTable()
	{
		players = profile.getPlayers();
		data = new Object[players.size() + 1][8];
		for(int i = 0; i < players.size(); i++)
		{
	
			Player player = players.get(i);
			data[i][0] = player.getName();
			data[i][1] = NumberFormat.getIntegerInstance().format(player.getNetGains());
			data[i][2] = NumberFormat.getIntegerInstance().format(player.getMetal());
			data[i][3] = NumberFormat.getIntegerInstance().format(player.getCrystal());
			data[i][4] = NumberFormat.getIntegerInstance().format(player.getDeuterium());
			data[i][5] = NumberFormat.getIntegerInstance().format(player.getLosses());
			data[i][6] = NumberFormat.getIntegerInstance().format(player.getDamage());
			data[i][7] = NumberFormat.getIntegerInstance().format(player.getNumRaids());
		}
				
		
	}
	
	/**
	 * Calls the build method and refreshes the pane to display
	 * the new table
	 */
	public void update()
	{
		buildTable();
		scrollPane.setViewportView(new JTable(data, cols));
	}

	/**
	 * Passes a new profile object to the pane
	 * @param profile
	 * 	The new profile to be passed to the pane
	 */
	public void setProfile(Profile profile)
	{
		this.profile = profile;
	}
	
}
