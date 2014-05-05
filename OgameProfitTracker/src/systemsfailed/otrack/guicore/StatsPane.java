/**
* The <code>StatsPane</code> class creates an instance of a panel object which
* is used to compute and display various bits of information generated from the
* current profile
* 
* @author Robert Massina
*    e-mail: Systemsfailed@gmail.com
**/

package systemsfailed.otrack.guicore;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import systemsfailed.otrack.corecomponents.Day;
import systemsfailed.otrack.corecomponents.Planet;
import systemsfailed.otrack.corecomponents.Player;
import systemsfailed.otrack.corecomponents.Profile;
import systemsfailed.otrack.corecomponents.Raid;

import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

public class StatsPane extends JPanel {

	private JPanel DayPanel, PlayerPanel, PlanetPanel, RaidPanel;
	private JLabel lblTotalNumberOf;
	private JLabel lblMostRaidsIn;
	private JLabel lblMostProfitableDay;
	private JLabel lblMostDamageIn;
	private JLabel lblMostLossesIn;
	private JLabel lblNumDay;
	private JLabel lblMostRaidsLabel;
	private JLabel lblMostProfitDay;
	private JLabel lblMostDamage;
	private JLabel lblMostLosses;
	private Day tempDay;
	private Raid tempRaid;
	private Player tempPlayer;
	private Planet tempPlanet;
	private Profile profile;
	private JLabel lblDayStatistics;
	private JLabel lblTotalNumberOf_1;
	private JLabel lblMostRaidedPlayer;
	private JLabel lblMostProfitablePlayer;
	private JLabel lblMostDamagedPlayer;
	private JLabel lblPlayerCausingHighest;
	private JLabel lblPlayerStatistics;
	private JLabel lblNumPlayers;
	private JLabel lblMostRaided;
	private JLabel lblMostProfitPlayer;
	private JLabel lblMostDamagePlayer;
	private JLabel lblMostLossPlayer;
	private JLabel lblTotalNumberOf_2;
	private JLabel lblMostRaidedPlanet;
	private JLabel lblMostProfitablePlanet;
	private JLabel lblMostDamagedPlanet;
	private JLabel lblPlanetWithMost;
	private JLabel lblPlanetStatistics;
	private JLabel lblNumPlanet;
	private JLabel lblMostProfitPlanet;
	private JLabel lblMostDamagePlanet;
	private JLabel lblMostLossesPlanet;
	private JLabel label;
	private JLabel lblTotalRaids;
	private JLabel lblRaidStatistics;
	private JLabel lblRaidsPerDay;
	private JLabel lblRaidsPerPlayer;
	private JLabel lblRaidsPerPlanet;
	private JLabel lblMostProfitableRaid;
	private JLabel lblMostDamagingRaid;
	private JLabel lblMostLossesOn;
	private JLabel sumTotalRaids;
	private JLabel lblTotalRaidProfit;
	private JLabel lblRaidPerDay;
	private JLabel lblRaidPerPlayer;
	private JLabel lblRaidPerPlanet;
	private JLabel lblMostProfitRaid;
	private JLabel lblMostDamageRaid;
	private JLabel lblMostLossRaid;
	private JLabel lblTotalProfit;
	private JLabel lblTotalRaidDamage;
	private JLabel lblRaidSumDamage;
	private JLabel lblProfitPerRaid;
	private JLabel lblDamagePerRaid;
	private JLabel lblProfitByRaid;
	private JLabel lblDamageByRaid;
	private JLabel lblMostRaid;
	
	/**
	 * Create the panel.
	 */
	public StatsPane(Profile profile) {
		this.profile = profile;
		setLayout(new GridLayout(2, 2, 0, 0));
		
		DayPanel = new JPanel();
		add(DayPanel);
		DayPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblDayStatistics = new JLabel("Day Statistics");
		DayPanel.add(lblDayStatistics, "6, 2");
		
		lblTotalNumberOf = new JLabel("Total Number of Days:");
		DayPanel.add(lblTotalNumberOf, "4, 4");
		
		lblNumDay = new JLabel("");
		DayPanel.add(lblNumDay, "10, 4");
		
		lblMostRaidsIn = new JLabel("Most Raids In One Day:");
		DayPanel.add(lblMostRaidsIn, "4, 6");
		
		lblMostRaidsLabel = new JLabel("");
		DayPanel.add(lblMostRaidsLabel, "10, 6, default, top");
		
		lblMostProfitableDay = new JLabel("Most Profitable Day:");
		DayPanel.add(lblMostProfitableDay, "4, 8");
		
		lblMostProfitDay = new JLabel("");
		DayPanel.add(lblMostProfitDay, "10, 8");
		
		lblMostDamageIn = new JLabel("Most Damage In One Day:");
		DayPanel.add(lblMostDamageIn, "4, 10");
		
		lblMostDamage = new JLabel("");
		DayPanel.add(lblMostDamage, "10, 10");
		
		lblMostLossesIn = new JLabel("Most Losses In One Day:");
		DayPanel.add(lblMostLossesIn, "4, 12");
		
		lblMostLosses = new JLabel("");
		DayPanel.add(lblMostLosses, "10, 12");
		
		PlayerPanel = new JPanel();
		add(PlayerPanel);
		PlayerPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblPlayerStatistics = new JLabel("Player Statistics");
		PlayerPanel.add(lblPlayerStatistics, "6, 2");
		
		lblTotalNumberOf_1 = new JLabel("Total Number of Players:");
		PlayerPanel.add(lblTotalNumberOf_1, "4, 4");
		
		lblNumPlayers = new JLabel("");
		PlayerPanel.add(lblNumPlayers, "10, 4");
		
		lblMostRaidedPlayer = new JLabel("Most Raided Player:");
		PlayerPanel.add(lblMostRaidedPlayer, "4, 6");
		
		lblMostRaided = new JLabel("");
		PlayerPanel.add(lblMostRaided, "10, 6");
		
		lblMostProfitablePlayer = new JLabel("Most Profitable Player:");
		PlayerPanel.add(lblMostProfitablePlayer, "4, 8");
		
		lblMostProfitPlayer = new JLabel("");
		PlayerPanel.add(lblMostProfitPlayer, "10, 8");
		
		lblMostDamagedPlayer = new JLabel("Most Damaged Player:");
		PlayerPanel.add(lblMostDamagedPlayer, "4, 10");
		
		lblMostDamagePlayer = new JLabel("");
		PlayerPanel.add(lblMostDamagePlayer, "10, 10");
		
		lblPlayerCausingHighest = new JLabel("Player Causing Highest Damage:");
		PlayerPanel.add(lblPlayerCausingHighest, "4, 12");
		
		lblMostLossPlayer = new JLabel("");
		PlayerPanel.add(lblMostLossPlayer, "10, 12");
		
		PlanetPanel = new JPanel();
		add(PlanetPanel);
		PlanetPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblPlanetStatistics = new JLabel("Planet Statistics");
		PlanetPanel.add(lblPlanetStatistics, "6, 2");
		
		lblTotalNumberOf_2 = new JLabel("Total Number of Planets:");
		PlanetPanel.add(lblTotalNumberOf_2, "4, 4");
		
		lblNumPlanet = new JLabel("");
		PlanetPanel.add(lblNumPlanet, "10, 4");
		
		lblMostRaidedPlanet = new JLabel("Most Raided Planet:");
		PlanetPanel.add(lblMostRaidedPlanet, "4, 6");
		
		lblMostRaid = new JLabel("");
		PlanetPanel.add(lblMostRaid, "10, 6");
		
		lblMostProfitablePlanet = new JLabel("Most Profitable Planet:");
		PlanetPanel.add(lblMostProfitablePlanet, "4, 8");
		
		lblMostProfitPlanet = new JLabel("");
		PlanetPanel.add(lblMostProfitPlanet, "10, 8");
		
		lblMostDamagedPlanet = new JLabel("Most Damaged Planet:");
		PlanetPanel.add(lblMostDamagedPlanet, "4, 10");
		
		lblMostDamagePlanet = new JLabel("");
		PlanetPanel.add(lblMostDamagePlanet, "10, 10");
		
		lblPlanetWithMost = new JLabel("Planet With Most Losses:");
		PlanetPanel.add(lblPlanetWithMost, "4, 12");
		
		lblMostLossesPlanet = new JLabel("");
		PlanetPanel.add(lblMostLossesPlanet, "10, 12");
	
		RaidPanel = new JPanel();
		add(RaidPanel);
		RaidPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblRaidStatistics = new JLabel("Raid Statistics");
		RaidPanel.add(lblRaidStatistics, "6, 2");
		
		lblTotalRaids = new JLabel("Total Number of Raids:");
		RaidPanel.add(lblTotalRaids, "4, 4");
		
		sumTotalRaids = new JLabel("");
		RaidPanel.add(sumTotalRaids, "10, 4");
		
		lblRaidsPerDay = new JLabel("Raids Per Day:");
		RaidPanel.add(lblRaidsPerDay, "4, 6");
		
		lblRaidPerDay = new JLabel("");
		RaidPanel.add(lblRaidPerDay, "10, 6");
		
		lblRaidsPerPlayer = new JLabel("Raids Per Player:");
		RaidPanel.add(lblRaidsPerPlayer, "4, 8");
		
		lblRaidPerPlayer = new JLabel("");
		RaidPanel.add(lblRaidPerPlayer, "10, 8");
		
		lblRaidsPerPlanet = new JLabel("Raids Per Planet:");
		RaidPanel.add(lblRaidsPerPlanet, "4, 10");
		
		lblRaidPerPlanet = new JLabel("");
		RaidPanel.add(lblRaidPerPlanet, "10, 10");
		
		lblMostProfitableRaid = new JLabel("Most Profitable Raid:");
		RaidPanel.add(lblMostProfitableRaid, "4, 12");
		
		lblMostProfitRaid = new JLabel("");
		RaidPanel.add(lblMostProfitRaid, "10, 12, left, default");
		
		lblMostDamagingRaid = new JLabel("Most Damaging Raid:");
		RaidPanel.add(lblMostDamagingRaid, "4, 14");
		
		lblMostDamageRaid = new JLabel("");
		RaidPanel.add(lblMostDamageRaid, "10, 14");
		
		lblMostLossesOn = new JLabel("Most Losses on a Raid:");
		RaidPanel.add(lblMostLossesOn, "4, 16");
		
		lblMostLossRaid = new JLabel("");
		RaidPanel.add(lblMostLossRaid, "10, 16, left, default");
		
		lblTotalRaidProfit = new JLabel("Total Raid Profit:");
		RaidPanel.add(lblTotalRaidProfit, "4, 18");
		
		lblTotalProfit = new JLabel("");
		RaidPanel.add(lblTotalProfit, "10, 18, left, default");
		
		lblTotalRaidDamage = new JLabel("Total Raid Damage");
		RaidPanel.add(lblTotalRaidDamage, "4, 20");
		
		lblRaidSumDamage = new JLabel("");
		RaidPanel.add(lblRaidSumDamage, "10, 20");
		
		lblProfitPerRaid = new JLabel("Profit Per Raid");
		RaidPanel.add(lblProfitPerRaid, "4, 22");
		
		lblProfitByRaid = new JLabel("");
		RaidPanel.add(lblProfitByRaid, "10, 22");
		
		lblDamagePerRaid = new JLabel("Damage Per Raid");
		RaidPanel.add(lblDamagePerRaid, "4, 24");
		
		lblDamageByRaid = new JLabel("");
		RaidPanel.add(lblDamageByRaid, "10, 24");
		
		label = new JLabel("");
		RaidPanel.add(label, "4, 26");
		
	}
	
	/**
	 * Updates all of the labels in the page to reflect the new
	 * numbers based on the current profile
	 */
	public void update()
	{
		DateFormat dateFormat = new SimpleDateFormat("MM-DD-yyyy");
		lblNumDay.setText(NumberFormat.getIntegerInstance().format(profile.getDays().size()));
		tempDay = profile.mostRaids();
		lblMostRaidsLabel.setText(NumberFormat.getIntegerInstance().format(tempDay.getNetGains()) + " (" + tempDay.getDate().getMonth() + "-" + tempDay.getDate().getDate() + "-" + (tempDay.getDate().getYear() + 1900) + ")");
		tempDay = profile.mostProfit();
		lblMostProfitDay.setText(NumberFormat.getIntegerInstance().format(tempDay.getNetGains()) + " (" + tempDay.getDate().getMonth() + "-" + tempDay.getDate().getDate() + "-" + (tempDay.getDate().getYear() + 1900) + ")");
		tempDay = profile.mostDamage();
		lblMostDamage.setText(NumberFormat.getIntegerInstance().format(tempDay.getDamage()) + " (" + tempDay.getDate().getMonth() + "-" + tempDay.getDate().getDate() + "-" + (tempDay.getDate().getYear() + 1900) + ")");
		tempDay = profile.mostLoss();
		lblMostLosses.setText(NumberFormat.getIntegerInstance().format(tempDay.getLosses()) + " (" + tempDay.getDate().getMonth() + "-" + tempDay.getDate().getDate() + "-" + (tempDay.getDate().getYear() + 1900) + ")");
		
		lblNumPlayers.setText(NumberFormat.getIntegerInstance().format(profile.getPlayers().size()));
		tempPlayer = profile.playerMostRaids();
		lblMostRaided.setText(NumberFormat.getIntegerInstance().format(tempPlayer.getNumRaids()) + " (" + tempPlayer.getName() + ")");
		tempPlayer = profile.playerMostProfit();
		lblMostProfitPlayer.setText(NumberFormat.getIntegerInstance().format(tempPlayer.getNetGains()) + " (" + tempPlayer.getName() + ")");
		tempPlayer = profile.playerMostDamage();
		lblMostDamagePlayer.setText(NumberFormat.getIntegerInstance().format(tempPlayer.getDamage()) + " (" + tempPlayer.getName() + ")");
		tempPlayer = profile.playerMostLoss();
		lblMostLossPlayer.setText(NumberFormat.getIntegerInstance().format(tempPlayer.getLosses()) + " (" + tempPlayer.getName() + ")");
		
		lblNumPlanet.setText(NumberFormat.getIntegerInstance().format(profile.getNumPlanets()));
		tempPlanet = profile.planetMostRaids();
		lblMostRaid.setText(NumberFormat.getIntegerInstance().format(tempPlanet.getNumRaids()) + " (" + tempPlanet.getName() + ")");
		tempPlanet = profile.planetMostProfit();
		lblMostProfitPlanet.setText(NumberFormat.getIntegerInstance().format(tempPlanet.getNetGains()) + " (" + tempPlanet.getName() + ")");
		tempPlanet = profile.planetMostDamage();
		lblMostDamagePlanet.setText(NumberFormat.getIntegerInstance().format(tempPlanet.getDamage()) + " (" + tempPlanet.getName() + ")");
		tempPlanet = profile.planetMostLosses();
		lblMostLossesPlanet.setText(NumberFormat.getIntegerInstance().format(tempPlanet.getLosses()) + " (" + tempPlanet.getName() + ")");
		
		System.out.printf("%s", profile.getRaids() / profile.getPlayers().size());
		sumTotalRaids.setText(NumberFormat.getIntegerInstance().format(profile.getRaids()));
		lblRaidPerDay.setText(NumberFormat.getIntegerInstance().format(profile.getRaids() / profile.getDays().size()));
		lblRaidPerPlayer.setText(NumberFormat.getIntegerInstance().format(profile.getRaids() / profile.getNumPlayers()));
		lblRaidPerPlanet.setText(NumberFormat.getIntegerInstance().format(profile.getRaids() / profile.getNumPlanets()));
		tempRaid = profile.raidMostProfit();
		lblMostProfitRaid.setText(NumberFormat.getIntegerInstance().format(tempRaid.getNetGains()) + " (" + tempRaid.getPlayer() + " " + tempRaid.getPlanet() + ")");
		tempRaid = profile.raidMostDamage();
		lblMostDamageRaid.setText(NumberFormat.getIntegerInstance().format(tempRaid.getDamage()) + " (" + tempRaid.getPlayer() + " " + tempRaid.getPlanet() + ")");
		tempRaid = profile.raidMostLoss();
		lblMostLossRaid.setText(NumberFormat.getIntegerInstance().format(tempRaid.getLosses()) + " (" + tempRaid.getPlayer() + " " + tempRaid.getPlanet() + ")");
		lblTotalProfit.setText(NumberFormat.getIntegerInstance().format(profile.getNetGains()));
		lblRaidSumDamage.setText(NumberFormat.getIntegerInstance().format(profile.getDamage()));
		lblProfitByRaid.setText(NumberFormat.getIntegerInstance().format(profile.getNetGains() / profile.getRaids()));
		lblDamageByRaid.setText(NumberFormat.getIntegerInstance().format(profile.getDamage() / profile.getRaids()));
	}
	
	/**
	 * Updates the profile used to build this page with
	 * a new one
	 * @param profile
	 * 	New profile to be used to build statistics
	 */
	public void setProfile(Profile profile)
	{
		
		this.profile = profile;
		if(profile.getDays().size() != 0)
			update();
	}
}
