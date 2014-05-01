package systemsfailed.otrack.guicore;

import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import systemsfailed.otrack.corecomponents.Profile;
import systemsfailed.otrack.corecomponents.Raid;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CRInputPane extends JPanel {

	
	private JPanel ConsolePanel;
	private JScrollPane ConsoleScrollPane;
	private JTextArea ConsoleTextArea;
	private JPanel CRInputPanel;
	private JScrollPane CRInputScrollPane;
	private JTextArea CRTextArea;
	private JPanel InputButtonPanel;
	private JButton btnParse;
	private JButton btnClear;
	Profile profile;
	
	/**
	 * Create the panel.
	 */
	public CRInputPane(Profile profile) {
		this.profile = profile;
		
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
		
		btnParse = new JButton("Parse");
		btnParse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parseReports();
			}
		});

		
		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
			if(profile == null)
			{
				JOptionPane.showMessageDialog(null, "Cannot parse, no profile loaded");
			}
		
			else
			{
				String[] inRaids;
				try{
					inRaids = CRTextArea.getText().split("On ");
					for(int i = 1; i < inRaids.length; i++)
					{
						profile.addRaid(new Raid(inRaids[i]));
						ConsoleTextArea.setText(ConsoleTextArea.getText() + "\n" + i + " Report Added Sucessfully");
					}
			
					}catch(Exception ex)
					{
						ConsoleTextArea.setText(ConsoleTextArea.getText() + "\nError: Invalid CR format. Invalid text will be skipped");
					}
			
				CRTextArea.setText(null);
			}
		
		}

	}
	

