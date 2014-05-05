/**
* The <code>CRInputPane</code> class creates an instance of a panel object which
* is used to interact with the user in order to import combat reports to be converted
* to raids and sorted into days.
* 
* @author Robert Massina
*    e-mail: Systemsfailed@gmail.com
**/
package systemsfailed.otrack.guicore;

import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import systemsfailed.otrack.corecomponents.Profile;
import systemsfailed.otrack.corecomponents.Raid;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class CRInputPane extends JPanel {

	
	private JPanel ConsolePanel; //Panel which displayes output to user
	private JScrollPane ConsoleScrollPane; //Scroll panel which contains the console
	private JTextArea ConsoleTextArea; //Text area that displays output
	private JPanel CRInputPanel; //Panel to input CR's into
	private JScrollPane CRInputScrollPane; 
	private JTextArea CRTextArea;
	private JPanel InputButtonPanel;
	private JButton btnParse;
	private JButton btnClear;
	AppWindow app;
	Profile profile;
	
	/**
	 * Create the panel.
	 */
	public CRInputPane(Profile profile, AppWindow window) {
		this.profile = profile;
		app = window;
		
		setLayout(new GridLayout(1, 2, 0, 0));
		
		ConsolePanel = new JPanel();
		add(ConsolePanel);
		ConsolePanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		ConsoleScrollPane = new JScrollPane();
		ConsolePanel.add(ConsoleScrollPane);
		
		ConsoleTextArea = new JTextArea();
		ConsoleTextArea.setEditable(false);
		ConsoleScrollPane.setViewportView(ConsoleTextArea);
		
		CRInputPanel = new JPanel();
		add(CRInputPanel);
		CRInputPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		CRInputScrollPane = new JScrollPane();
		CRInputPanel.add(CRInputScrollPane);
		
		CRTextArea = new JTextArea();
		CRInputScrollPane.setViewportView(CRTextArea);
		
		InputButtonPanel = new JPanel();
		CRInputPanel.add(InputButtonPanel);
		
		btnParse = new JButton("Parse"); //Parse button to read combat reports
		btnParse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parseReports();
			}
		});

		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//Clear input text window
				CRTextArea.setText(null);
			}
		});
		GroupLayout gl_InputButtonPanel = new GroupLayout(InputButtonPanel);
		gl_InputButtonPanel.setHorizontalGroup(
			gl_InputButtonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_InputButtonPanel.createSequentialGroup()
					.addContainerGap(134, Short.MAX_VALUE)
					.addComponent(btnParse, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(51)
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addGap(123))
		);
		gl_InputButtonPanel.setVerticalGroup(
			gl_InputButtonPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InputButtonPanel.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_InputButtonPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnParse)
						.addComponent(btnClear))
					.addContainerGap(227, Short.MAX_VALUE))
		);
		InputButtonPanel.setLayout(gl_InputButtonPanel);

	}
	
		public void parseReports()
		{
			if(profile == null) //Checks for null profile to avoid exceptions
			{
				JOptionPane.showMessageDialog(null, "Cannot parse, no profile loaded");
			}
		
			else
			{
				String[] inRaids = null; 
				try{
					inRaids = CRTextArea.getText().split("On "); //Splits all input into individual
					System.out.printf("%s", inRaids.length);
					for(int i = 1; i < inRaids.length; i++)		//Combat reports to be parsed separately
					{										//Starts at to avoid blank space in front of the On(
						Raid raid = new Raid(inRaids[i]);
						if(!profile.contains(raid))  //Ensures the report hasn't already been entered
						{
							profile.addRaid(raid);
							ConsoleTextArea.setText(ConsoleTextArea.getText() + "\n#" + i + " Report Added Sucessfully");
						}
						else
							ConsoleTextArea.setText(ConsoleTextArea.getText() + "\n#" + i + " Duplicate report ignored");

						
					}
			
					}catch(Exception ex)
					{
						ex.printStackTrace(AppWindow.errorLogPrint);
						AppWindow.ERROR_LOG += AppWindow.errorLogWriter.toString() + "END EXCEPTION \n\n";
						ConsoleTextArea.setText(ConsoleTextArea.getText() + "\nError: Invalid CR format. Invalid text will be skipped");
					}
			
				CRTextArea.setText(null); //Clear input pane
				
				if(inRaids.length == 1) //Checks to see if any random text was input
				{
					ConsoleTextArea.setText(ConsoleTextArea.getText() + "\nError: Invalid CR format. Invalid text will be skipped");
				}
				
				app.getOverviewPanel().update();//Updates Tables
				app.getStatsPane().update();//Updates stats page
		
			}
		
		}
		
		/**
		 * Updates the profile with a reference to a new one
		 * @param profile
		 * 	New profile to be used
		 */
		public void setProfile(Profile profile)
		{
			this.profile = profile;
		}
		/**
		 * Clears the text in the input area
		 */
		public void clearText()
		{
			ConsoleTextArea.setText("");
		}
		/**
		 * Sets the text of the console to the input
		 * @param text
		 * 	New text for the console pane
		 */
		public void setText(String text)
		{
			ConsoleTextArea.setText(text);
		}
	}
	

