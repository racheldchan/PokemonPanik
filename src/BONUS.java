import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

import javax.swing.*;

public class BONUS extends JPanel {
	// Game constants
	public static final int COURT_WIDTH = 800;
	public static final int COURT_HEIGHT = 450;


	private ImageIcon background = new ImageIcon("background.jpg");

	
	public BONUS() {
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
		
		JTextArea textArea = new JTextArea ("Electrify the ball with your lightening."
				+ " Avoid getting hit by the pokeball or else you will die.");
		textArea.setOpaque(false);
		
		panel.add(textArea);
		textArea.setFont(new Font("Tahoma", Font.BOLD, 12));
		textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
		

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