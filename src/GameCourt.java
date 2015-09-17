/**
 * CIS 120 HW10
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Icon;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import java.awt.Image;


/**
 * GameCourt
 * 
 * This class holds the primary game logic for how different objects interact
 * with one another. Take time to understand how the timer interacts with the
 * different methods and how it repaints the GUI on every tick().
 * 
 */
@SuppressWarnings("serial")
public class GameCourt extends JPanel {

	public boolean playing = false; // whether the game is running
	private JLabel status; // Current status text (i.e. Running...)
	private GameMode mode; // mode that the player is in
	private ImageIcon background = new ImageIcon("background.jpg");

	// Game constants
	public static final int COURT_WIDTH = 800;
	public static final int COURT_HEIGHT = 450;


	public GameCourt() {
		
		try {
		UIManager.setLookAndFeel (UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(false);
		setVisible(true);
		
		JPanel title_panel = new JPanel();
		ImageIcon icon = new ImageIcon("temp-2.png");
		JLabel label = new JLabel(icon);
		title_panel.setOpaque(false);
		title_panel.add(label);
		
		JPanel one_player_panel = new JPanel();
		JButton one_player_button = new JButton("ONE PLAYER", new ImageIcon("PikachuStrolling.gif"));
		one_player_button.setRolloverIcon(new ImageIcon("Pokeball_Bounce.gif"));
		one_player_button.setRolloverEnabled(true);
		one_player_button.setPreferredSize(new Dimension(200, 65));
		one_player_button.setFont(new Font("Tahoma", Font.BOLD, 12));
		one_player_panel.add(one_player_button);
		one_player_panel.setOpaque(false);
		one_player_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.changeMode(GameMode.ONEPLAYA);
			}
		});
		
		JPanel two_player_panel = new JPanel();
		JButton two_player_button = new JButton("TWO PLAYER", new ImageIcon("KawaiiPika_and_Pichu.gif"));
		two_player_button.setRolloverIcon(new ImageIcon("Pikachu_and_Pichu2000 (1).gif"));
		two_player_button.setRolloverEnabled(true);
		two_player_button.setPreferredSize(new Dimension(200, 65));
		two_player_button.setFont(new Font("Tahoma", Font.BOLD, 12));
		two_player_panel.add(two_player_button);
		two_player_panel.setOpaque(false);
		two_player_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.changeMode(GameMode.TWOPLAYA);
			}
		});
		
		JPanel control_player_panel = new JPanel();
		JButton control_player_button = new JButton("CONTROLS", new ImageIcon("pikachuShrugs.gif"));
		control_player_button.setRolloverIcon(new ImageIcon("pikachuShrugs.gif"));
		control_player_button.setRolloverEnabled(true);
		control_player_button.setPreferredSize(new Dimension(200, 65));
		control_player_button.setFont(new Font("Tahoma", Font.BOLD, 12));
		control_player_panel.add(control_player_button);
		control_player_panel.setOpaque(false);
		control_player_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.changeMode(GameMode.CONTROLS);
			}
		});
		
		JPanel bonus_player_panel = new JPanel();
		JButton bonus_player_button = new JButton("INSTRUCTIONS", new ImageIcon("ThunderStone.png"));
		bonus_player_button.setRolloverIcon(new ImageIcon("ThunderStone.png"));
		bonus_player_button.setRolloverEnabled(true);
		bonus_player_button.setPreferredSize(new Dimension(200, 65));
		bonus_player_button.setFont(new Font("Tahoma", Font.BOLD, 12));
		bonus_player_panel.add(bonus_player_button);
		bonus_player_panel.setOpaque(false);
		bonus_player_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.changeMode(GameMode.BONUS);
			}
		});
		
		panel.add(title_panel);
		panel.add(one_player_panel);
		panel.add(two_player_panel);
		panel.add(control_player_panel);
		panel.add(bonus_player_panel);
		
		add(panel);		
	}

	/**
	 * This method is called every time the timer defined in the constructor
	 * triggers.
	 */

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, COURT_WIDTH, COURT_HEIGHT, null);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(COURT_WIDTH, COURT_HEIGHT);
	}
}
