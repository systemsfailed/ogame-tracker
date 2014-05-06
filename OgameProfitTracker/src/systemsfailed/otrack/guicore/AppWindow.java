/**
* The <code>AppWindow</code> class creates an instance of a frame object which is used 
* as the main container to hold all of the other GUI components for O-Track
* This object contains all other panels as well as implements a save/load system
* for the <code>Profile</code> objects that store all of the information
* 
* @author Robert Massina
*    e-mail: Systemsfailed@gmail.com
**/

package systemsfailed.otrack.guicore;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTabbedPane;

import systemsfailed.otrack.corecomponents.Profile;

import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


public class AppWindow extends JFrame {

	private JPanel contentPane;
	private CRInputPane inputPane; //Pane that handles user input of combat reports
    private OverviewContainer overviewContainer; //Container for the spreadsheet panels
	private StatsPane statsPane; //Panel that contains various statistics about the current profile
	private JMenuBar menuBar;
	private JMenu mnFile; //Menu option
	private JMenuItem mntmNewProfile; //Button to create a new profile
	private JMenuItem mntmSaveProfile;//Button to create a save file of the current Profile
	private JMenuItem mntmLoadProfile;//Button to load another profile object from a save file
	private JMenuItem mntmRenameProfile; //Button to rename the current profile
	private JTabbedPane tabbedPane;
	private JFileChooser fc; 
	private Scanner saveReader;
    private static File logDir; //File representation of log file directory
    private static File saveDir; //File representation of save file directory
	final static String EXTENSION = ".pro";//Extension of Profile object save files
	final static String LOG_EXTENSION = ".log";
    private Profile profile; //Currently selected profile object
    public static String ERROR_LOG;
    public static StringWriter errorLogWriter;
    public static PrintWriter errorLogPrint;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			try{ 
				saveDir = new File(new File(AppWindow.class.getProtectionDomain()
						.getCodeSource().getLocation().toURI().getPath()).toString()
						.replace("Otrack.jar", "")+"Saves\\");  //Checks to see if a save folder
				if (!saveDir.exists()) 							//Exists in the current directory
					saveDir.mkdir();  							//If not it will create one
					
				logDir = new File(new File(AppWindow.class.getProtectionDomain()
						.getCodeSource().getLocation().toURI().getPath()).toString()
						.replace("Otrack.jar", "")+"Logs\\"); //Checks to see if a logs folder		
				if (!logDir.exists()) 						  //Exists in the current directory
					logDir.mkdir();  						  //If not it will create one
					
				errorLogWriter = new StringWriter();			//Creates a method of printing exceptions
				errorLogPrint = new PrintWriter(errorLogWriter); //Reads exception stack traces
					
					Runtime.getRuntime().addShutdownHook(new Thread() //Creates a shutdown hook to print error logs
					{
						public void run() 
						{
							if(ERROR_LOG != null)
							{
								Calendar cal = Calendar.getInstance();
								DateFormat dateFormat = new SimpleDateFormat("MM-DD-yyy HH-mm");
								
								try {							//Creates a new file with error log contents
									FileWriter writer = new FileWriter(new File(getClass().getProtectionDomain()
											.getCodeSource().getLocation() + "\\Logs\\" + 
											dateFormat.format(cal.getTime()) + LOG_EXTENSION));
									writer.write(ERROR_LOG);
									writer.close();
									} catch (IOException e) 
									{
										e.printStackTrace();
									}
							}
						}
					});
					AppWindow frame = new AppWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(errorLogPrint);
					ERROR_LOG += errorLogWriter.toString() + "\n\n";
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppWindow() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		
		fc = new JFileChooser();		//Initialize file chooser for loading files
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Profiles", "pro")); //Sets filter on file chooser
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);			//So only .pro files will be shown
		fc.setCurrentDirectory(saveDir); //Sets the directory of the filechooser to the save folder checked before
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmNewProfile = new JMenuItem("New Profile");
		mntmNewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) //Asks user if destroying current profile is okay
			{	
				if(JOptionPane.showConfirmDialog(null, "Are you sure? Any Unsaved Changes will"
						+ " be lost", "Confirm new profile", 2) == 0)
						{
						
						setProfile(new Profile()); //Creates a new profile obeject
						String newName = JOptionPane.showInputDialog("Enter a name for profile: ");
						profile.setName(newName);
						
						if(profile.getName().length() == 0) // Ensures that the submitted name for the profile
							while(profile.getName().length() == 0)//Is not empty
							{
								profile.setName(JOptionPane.showInputDialog("Name must be longer"
									+ "than 0 Enter a name for profile: "));
							}	
						
						inputPane.setText("New Profile: " + profile.getName()); //Sets title of the program to
						setTitle(profile.getName());						//Match the current profile's name
						}
			}
		});
		mnFile.add(mntmNewProfile);
		
		mntmSaveProfile = new JMenuItem("Save Profile");
		mntmSaveProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try {
					if(profile.getName().equals("New Profile")) //Ensures that default profile name is not used
					{
						profile.setName(JOptionPane.showInputDialog("You need to" +
								"give the profile a name: "));
						while(profile.getName().length() == 0)
						{
							profile.setName(JOptionPane.showInputDialog("You need to" +
									"give the profile a name: "));
						}	
					}
					FileWriter writer = new FileWriter(System.getProperty("user.dir")+"\\Saves\\"+
				    profile.getName()+EXTENSION); //Creates a file writer within the save file folder
					writer.write(profile.toString());//Saves profile as a save file
					writer.close();
				} catch (IOException e) {
					e.printStackTrace(errorLogPrint);
					ERROR_LOG += errorLogWriter.toString() + "\n\n";
				}
			}
		});
		
		mntmRenameProfile = new JMenuItem("Rename Profile");
		mntmRenameProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				profile.setName(JOptionPane.showInputDialog("Enter a" +//Allows user to rename the profile
						"new name: "));
				setTitle(profile.getName());
				while(profile.getName().length() == 0) //Ensures that the new profile name is not empty
				{
					profile.setName(JOptionPane.showInputDialog("You need to" +
							"give the profile a name: "));
				}
			}
		});
		mnFile.add(mntmRenameProfile);
		mnFile.add(mntmSaveProfile);
		
		mntmLoadProfile = new JMenuItem("Load Profile");
		mntmLoadProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int returnVal = fc.showOpenDialog(null); //Gets a user selected file
				
				if (returnVal == JFileChooser.APPROVE_OPTION) //Checks if the file-type is correct
				{
		            File file = fc.getSelectedFile();  //Creates a file from the selected save
		        try
		        {
		        saveReader = new Scanner(file).useDelimiter("//A"); //Read until end of file
				setProfile(new Profile(saveReader.next())); // Passes the new profile to this window and -
				inputPane.setText("Saved File read sucessfully!");//all other windows in program
				setTitle(profile.getName());
				saveReader.close(); //Closes the scanner
		        }catch(Exception ex)
		        {
		        	inputPane.setText("Error in reading text file!\n");	
		        	ex.printStackTrace(errorLogPrint);
					ERROR_LOG += errorLogWriter.toString() + "\n\n";
		        }
				}
			}
		});
		mnFile.add(mntmLoadProfile);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		profile = new Profile();
		profile.setName("New Profile");
		
		overviewContainer = new OverviewContainer(profile);
		inputPane = new CRInputPane(profile, this);
		tabbedPane.addTab("CR Input Pane", null, inputPane, null);
		tabbedPane.addTab("Day Overview", null, overviewContainer, null);	
		
		statsPane = new StatsPane(profile);
		tabbedPane.addTab("Stats", null, statsPane, null);
	}
	
	/**
	 * @return
	 * 	Returns a reference to the OverviewContainer panel
	 */
	public OverviewContainer getOverviewPanel()
	{
		return overviewContainer;
	}
	/**
	 * @return
	 * 	Returns a reference to the CRInputPane
	 */
	public CRInputPane getInputPane()
	{
		return inputPane;
	}
	/**
	 * @return
	 * 	Returns a reference to the StatsPane
	 */
	public StatsPane getStatsPane()
	{
		return statsPane;
	}
	/**
	 * @param profile
	 * 	A new profile to be assigned to all windows of the
	 * 	program
	 */
	public void setProfile(Profile profile)
	{
		this.profile = profile;
		overviewContainer.setProfile(profile);
		inputPane.setProfile(profile);
		statsPane.setProfile(profile);

	}

}
