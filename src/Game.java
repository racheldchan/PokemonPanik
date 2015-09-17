/**
 * CIS 120 HW10
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

// imports necessary libraries for Java swing
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Game Main class that specifies the frame and widgets of the GUI
 */
public class Game implements Runnable {
	private static JFrame frame;
	private static JPanel window;
	private static GameMode mode;
	public static JLabel status;
	public void run() {
		// NOTE : recall that the 'final' keyword notes inmutability
		// even for local variables.

		// Top-level frame in which game components live
		// Be sure to change "TOP LEVEL FRAME" to the name of your game
		frame = new JFrame("Pokeball Panic");
		frame.setLocation(300, 300);

		// Status panel
		final JPanel status_panel = new JPanel();
		frame.add(status_panel, BorderLayout.SOUTH); // position of it in the frame
		status = new JLabel("RUNNING...");
		status.setFont(new Font("Tahoma", Font.BOLD, 12));
		status_panel.add(status);

		// Main playing area
		window = new GameCourt();
		frame.add(window, BorderLayout.CENTER);

		// Put the frame on the screen
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void refresh() {
	frame.pack();
	}
	
	public static void changeMode(GameMode newMode) {
		switch(newMode) {
		case GameCourt: frame.remove(window);
						window = new GameCourt();
						frame.add(window);
						frame.pack();
						break;
		case ONEPLAYA: 	frame.remove(window);
						window = new ONEPLAYA(status);
						frame.add(window);
						frame.pack();
						break;
		case CONTROLS: 	frame.remove(window);
						window = new CONTROLS();
						frame.add(window);
						frame.pack();
						break;
		case TWOPLAYA: 	frame.remove(window);
						window = new TWOPLAYA(status);
						frame.add(window);
						frame.pack();
						break;
		case BONUS:		frame.remove(window);
						window = new BONUS();
						frame.add(window);
						frame.pack();
		default:
			break;
		}
	}

	/*
	 * Main method run to start and run the game Initializes the GUI elements
	 * specified in Game and runs it IMPORTANT: Do NOT delete! You MUST include
	 * this in the final submission of your game.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Game());
	}
}
