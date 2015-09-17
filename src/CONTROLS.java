import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

import javax.swing.*;

public class CONTROLS extends JPanel {
	// Game constants
	public static final int COURT_WIDTH = 800;
	public static final int COURT_HEIGHT = 450;


	private ImageIcon background = new ImageIcon("background.jpg");

	
	public CONTROLS() {
		try {
		UIManager.setLookAndFeel (UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton back = new JButton("Back");
		back.setAlignmentX(Component.CENTER_ALIGNMENT);
		back.setPreferredSize(new Dimension (100, 65));
		back.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(back);
		panel.setOpaque(false);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.changeMode(GameMode.GameCourt);
			}
		});
		
		panel.add(Box.createRigidArea(new Dimension(0,30)));
		
		
		JButton one_player = new JButton("ONE  PLAYA", new ImageIcon("lurd-keyboard.png"));
		one_player.setAlignmentX(Component.CENTER_ALIGNMENT);
		one_player.setPreferredSize(new Dimension(200, 65));
		one_player.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(one_player);
		panel.setOpaque(false);
		
		JButton two_player = new JButton("TWO PLAYA", new ImageIcon("lurd-keyboard 2.png"));
		two_player.setAlignmentX(Component.CENTER_ALIGNMENT);
		two_player.setPreferredSize(new Dimension(200, 65));
		two_player.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(two_player);
		panel.setOpaque(false);
		
		
		panel.add(Box.createRigidArea(new Dimension(0, 45)));
		
		JPanel title_panel = new JPanel();
		ImageIcon icon = new ImageIcon("pikapokeball.gif");
		JLabel label = new JLabel(icon);
		title_panel.setOpaque(false);
		title_panel.add(label);
		panel.add(title_panel);

		add(panel);
		
	}
	
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
