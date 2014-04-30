package systemsfailed.otrack.guicore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;

public class main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
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
	public main() {
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
		
		JTextArea consolePane = new JTextArea();
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
		
		JTextArea inputTextArea = new JTextArea();
		InputScrollContainer.setViewportView(inputTextArea);
		
		JPanel panel = new JPanel();
		InputPane.add(panel);
		
		JPanel SummaryPane = new JPanel();
		tabbedPane.addTab("Daily Summaries", null, SummaryPane, null);
		SummaryPane.setLayout(new GridLayout(1, 0, 0, 0));
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{tabbedPane}));
	}

}
