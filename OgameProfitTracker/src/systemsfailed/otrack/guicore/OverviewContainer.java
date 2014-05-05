/**
* The <code>OverviewContainer</code> class creates an instance of a panel object which
* is used to contain other panels that contain tables based on the current profile.
* 
* @author Robert Massina
*    e-mail: Systemsfailed@gmail.com
**/
package systemsfailed.otrack.guicore;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import systemsfailed.otrack.corecomponents.Profile;

import java.awt.BorderLayout;

public class OverviewContainer extends JPanel {

	private DayOverviewPanel dayOverview;
	private PlayerOverviewPane playerOverview;
	private PlanetOverviewPane planetOverview;
	/**
	 * Create the panel.
	 */
	public OverviewContainer(Profile profile) {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		dayOverview = new DayOverviewPanel(profile);
		tabbedPane.addTab("Day Overview", null, dayOverview, null);
		
		playerOverview = new PlayerOverviewPane(profile);
		tabbedPane.addTab("Player Overview", null, playerOverview, null);
		
		planetOverview = new PlanetOverviewPane(profile);
		tabbedPane.addTab("Planet Overview", null, planetOverview, null);
		

	}
	
	/**
	 * Updates all of the containers held within
	 */
	public void update()
	{
		dayOverview.update();
		playerOverview.update();
		planetOverview.update();
	}
	
	/**
	 * Updates the sub panels with a new profile object
	 * 
	 * @param profile
	 * 	Profile to be passed to all of the sub panels
	 */
	public void setProfile(Profile profile)
	{
		dayOverview.setProfile(profile);
		playerOverview.setProfile(profile);
		planetOverview.setProfile(profile);
		update();
	}

}
