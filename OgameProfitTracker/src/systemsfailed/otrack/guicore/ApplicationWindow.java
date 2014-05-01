package systemsfailed.otrack.guicore;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JTabbedPane;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import systemsfailed.otrack.corecomponents.Profile;
import systemsfailed.otrack.corecomponents.Raid;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class ApplicationWindow {

	private JFrame frame;
	private Profile profile;
	private String[] inRaids;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 960, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JPanel ReportInput = new JPanel();
		tabbedPane.addTab("Input CR's", null, ReportInput, null);
		ReportInput.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel ConsoleContainer = new JPanel();
		ConsoleContainer.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.BLACK, Color.GRAY));
		ReportInput.add(ConsoleContainer);
		ConsoleContainer.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		ConsoleContainer.add(scrollPane);
		
		final JTextArea consolePane = new JTextArea();
		consolePane.setEditable(false);
		scrollPane.setViewportView(consolePane);
		
		JPanel InputPane = new JPanel();
		ReportInput.add(InputPane);
		InputPane.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel InputTopPane = new JPanel();
		InputTopPane.setBorder(null);
		InputPane.add(InputTopPane);
		InputTopPane.setLayout(new GridLayout(1, 2, 0, 0));
		
		JScrollPane InputScrollContainer = new JScrollPane();
		InputTopPane.add(InputScrollContainer);
		
		final JTextArea inputTextArea = new JTextArea();
		InputScrollContainer.setViewportView(inputTextArea);
		
		JPanel buttonContainer = new JPanel();
		InputPane.add(buttonContainer);
		
		JButton btnParse = new JButton("Parse");
		btnParse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(profile == null)
				{
					JOptionPane.showMessageDialog(frame, "Cannot parse, no profile loaded");
				}
				
				else
				{
					try{
						inRaids = inputTextArea.getText().split("On ");
						for(int i = 1; i < inRaids.length; i++)
						{
							profile.addRaid(new Raid(inRaids[i]));
							consolePane.setText(consolePane.getText() + "\n" + i + " Report Added Sucessfully");
						}
					
						}catch(Exception ex)
						{
							consolePane.setText(consolePane.getText() + "\nError: Invalid CR format. Invalid text will be skipped");
						}
					
					inputTextArea.setText(null);
				}
				
			}
		});
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputTextArea.setText(null);
			}
		});
		GroupLayout gl_buttonContainer = new GroupLayout(buttonContainer);
		gl_buttonContainer.setHorizontalGroup(
			gl_buttonContainer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonContainer.createSequentialGroup()
					.addGap(128)
					.addComponent(btnParse, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(66)
					.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(118, Short.MAX_VALUE))
		);
		gl_buttonContainer.setVerticalGroup(
			gl_buttonContainer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_buttonContainer.createSequentialGroup()
					.addGap(75)
					.addGroup(gl_buttonContainer.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnParse)
						.addComponent(btnClear))
					.addContainerGap(191, Short.MAX_VALUE))
		);
		buttonContainer.setLayout(gl_buttonContainer);
		
		JPanel SummaryPane = new JPanel();
		tabbedPane.addTab("Daily Summaries", null, SummaryPane, null);
		SummaryPane.setLayout(new GridLayout(1, 0, 0, 0));
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane}));
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewProfile = new JMenuItem("New Profile");
		mntmNewProfile.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				if(profile == null)
				{
					profile = new Profile();
					profile.setName(JOptionPane.showInputDialog("Enter a name for profile: "));
					if(profile.getName().length() == 0)
						while(profile.getName().length() == 0)
						{
							profile.setName(JOptionPane.showInputDialog("Name must be longer"
									+ " than 0 Enter a name for profile: "));
						}
				}
				else
				{
					if(JOptionPane.showConfirmDialog(null, "Are you sure? Any Unsaved Changes will"
							+ " be lost", "Confirm new profile", 2) == 0)
					{
						profile = new Profile();
						profile.setName(JOptionPane.showInputDialog("Enter a name for profile: "));
						
						if(profile.getName().length() == 0)
							while(profile.getName().length() == 0)
							{
								profile.setName(JOptionPane.showInputDialog("Name must be longer"
										+ "than 0 Enter a name for profile: "));
							}
					}
					
				}
			}
			
		});
		mnFile.add(mntmNewProfile);
		
		JMenuItem mntmSaveProfile = new JMenuItem("Save Profile");
		mnFile.add(mntmSaveProfile);
		
		JMenuItem mntmLoadProfile = new JMenuItem("Load Profile");
		mnFile.add(mntmLoadProfile);
		
		
		
	}
}
