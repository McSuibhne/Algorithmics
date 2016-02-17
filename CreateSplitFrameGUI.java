/*
 * Algorithmics
 * 14708689 Orla Cullen
 * 05641349 Gavin Keaveney
 * 14343826 Jonathan Sweeney
 * 
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;





@SuppressWarnings("serial")
public class CreateSplitFrameGUI extends JFrame  implements UserInterface {


	private JSplitPane verticalSplit;
	private JSplitPane horizontalSplit;
	private JPanel textPanel;
	private JPanel graphPanel;
	private JPanel userInputPanel;

	private static final int FRAME_WIDTH = 1000; // must be even
	private static final int FRAME_HEIGHT = 600;



	private String play1 = "Player1";
	private String play2 = "Player2";

	public CreateSplitFrameGUI() {

		setTitle("WELCOME TO RISK");
		setBackground(Color.yellow);

		JPanel upperPanel = new JPanel();
		upperPanel.setLayout(new BorderLayout());

		getContentPane().add(upperPanel);

		createTextDisplay();
		createGraphPanel();
		createUserInputDialog();



		verticalSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		horizontalSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);


		/*
		 * adds the split to the container and sets the layout to border and
		 * center
		 */

		upperPanel.add(verticalSplit, BorderLayout.CENTER);

		horizontalSplit.setLeftComponent(textPanel);

		horizontalSplit.setRightComponent(graphPanel);
		verticalSplit.setLeftComponent(horizontalSplit);

		verticalSplit.setRightComponent(userInputPanel);// sets the userInput panel as the horizontal split

		addWindowListener(
				new WindowAdapter(){
					public void windowClosing(WindowEvent e){
						System.exit(0);
					}
				}

				);

		verticalSplit.setRightComponent(userInputPanel);
	}

	public void createTextDisplay() {
		textPanel = new JPanel();

		JScrollBar scrollBar = new JScrollBar();
		JTextArea displayArea = new JTextArea();
		JMenuBar menuBar= new JMenuBar();
		JMenu gameMenu= new JMenu("Game");

		menuBar.add(gameMenu);
		setJMenuBar(menuBar);

		JMenu gameMenu1 = new JMenu("Play Game");
		gameMenu.add( gameMenu1);
		JMenu gameMenu2 = new JMenu("Help");
		gameMenu.add( gameMenu2);
		JMenu gameMenu3 = new JMenu("ScoreBoard");
		gameMenu.add( gameMenu3);
		JMenu gameMenu4 = new JMenu("Exit Game");	
		gameMenu.add( gameMenu4);

		textPanel.setLayout(new BorderLayout());
		textPanel.add(scrollBar, BorderLayout.EAST);
		textPanel.add(displayArea, BorderLayout.CENTER);
		textPanel.add(menuBar, BorderLayout.NORTH);
		textPanel.setPreferredSize(new Dimension(200, 100));
		textPanel.setBackground(Color.white);
	}

	public void createGraphPanel() {
		graphPanel = new Map();
		graphPanel.setLayout(new FlowLayout());

		graphPanel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));// size of graph area



	}


	public void createUserInputDialog() {

		userInputPanel = new JPanel();
		userInputPanel.setLayout(new BorderLayout());
		userInputPanel.setPreferredSize(new Dimension(100, 50));
		userInputPanel.setMinimumSize(new Dimension(100, 50));

		JLabel label = new JLabel("Welcome to Risk");
		userInputPanel.add(label, BorderLayout.NORTH);
		userInputPanel.setBackground(Color.yellow);

		JTextField textArea = new JTextField();
		userInputPanel.add(textArea, BorderLayout.CENTER);
		JButton button = new JButton("Enter Player Names");
		userInputPanel.add(button, BorderLayout.WEST);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				play1 = JOptionPane.showInputDialog(null, "Enter Player 1 Name", "Risk", JOptionPane.INFORMATION_MESSAGE);
				play2 = JOptionPane.showInputDialog(null, "Enter Player 2 Name", "Risk", JOptionPane.INFORMATION_MESSAGE);
				button.setText("Submit");
				label.setText("Welcome to Risk " + play1 + " & " + play2);
			}
		});      
	}
	
	public static void main(String[] args) {
		CreateSplitFrameGUI interfaceFrame = new CreateSplitFrameGUI();
		interfaceFrame.pack();
		interfaceFrame.setVisible(true);

	}

	public static int getFrameHeight() {//getter for the frame height
		return FRAME_HEIGHT;
	}

	public static int getFrameWidth() {//getter for the frame width
		return FRAME_WIDTH;
	}
}
