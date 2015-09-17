import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Iterator;

public class ONEPLAYA extends JPanel {
	public static final int COURT_WIDTH = 800;
	public static final int COURT_HEIGHT = 450;
	
	public static final int PIKACHU_VELOCITY = 4;
	public static final int INTERVAL = 20;
	private JLabel status;
	private Player Pikachu;
	private ImageIcon background = new ImageIcon("background.jpg");
	public boolean playing = true;
	public boolean shock = false;
	private int counter = 0;
	private int score = 0;
	
	private ArrayList<Bolt> arsenal;
	private ArrayList<Circle> targets;
	
	public ONEPLAYA(JLabel status) {
		
	Pikachu = new Player(COURT_WIDTH, COURT_HEIGHT);

	arsenal = new ArrayList<Bolt>();
	targets = new ArrayList<Circle>();
	targets.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 270, 200, 40));

	Timer timer = new Timer(INTERVAL, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			tick();
		}
	});
	timer.start(); // MAKE SURE TO START THE TIMER!
	setFocusable(true);
	requestFocusInWindow();
	addKeyListener(new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		        Pikachu.v_x = -PIKACHU_VELOCITY;
		    }
		    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
		    	arsenal.add(new Bolt(Pikachu.pos_x + (int) (Pikachu.width/2), 
		    			Pikachu.pos_y + (int) (Pikachu.height/2), COURT_WIDTH, COURT_HEIGHT));
		    }
		       else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		        Pikachu.v_x = PIKACHU_VELOCITY;
		}

		public void keyReleased(KeyEvent e) {
			Pikachu.v_x = 0;
			Pikachu.v_y = 0;
		}
	});

	this.status = status;

};

	void tick() {
		if (playing) {
			
			Pikachu.move();
			
			ArrayList<Circle> temp = new ArrayList<Circle>();
			
			Iterator<Circle> pokeballs = targets.iterator();
			while (pokeballs.hasNext()) {
				Circle c = pokeballs.next();
				c.move();
			}
			
			Iterator<Bolt> bolts = arsenal.iterator();
			
			while(bolts.hasNext()) {
				Bolt b = bolts.next();
				b.move();
				
				for(Circle pokeball: targets) {
				if (pokeball.intersects(b)) {
					pokeball.hits = false;
				}
			}
			}
			
			// add balls that haven't been hit to the temp array
			for (Circle pokeball: targets) {
				if (pokeball.hits) {
					temp.add(pokeball);
				}
			}
			targets = temp;
			
			// check for next level conditions
			if (targets.isEmpty()) {
				score += 2;
				status.setText("Score: " + score);
				counter += 1;
			}
			
			if (counter == 1 && targets.isEmpty()) {
				temp.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 270, 200, 40));
				temp.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 470, 200, 40));
				System.out.println(counter);
			}
			
			if (counter == 2 && targets.isEmpty()) {
				temp.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 150, 200, 40));
				temp.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 360, 80, 60));

			}
			
			if (counter == 3 && targets.isEmpty()) {
				temp.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 70, 50, 40));
				temp.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 220, 50, 40));
				temp.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 370, 50, 40));
			}
			
			if (counter == 3 && targets.size() == 1) {
				temp.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 150, 100, 40));
				temp.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 360, 180, 60));
			}
			
			if (counter == 4 && targets.isEmpty()) {
				temp.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 20, 290, 60));
				temp.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 150, 390, 60));
			}
			
			if (counter == 5 && targets.isEmpty()) {
				temp.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 70, 50, 40));
				temp.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 220, 50, 40));
				temp.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 370, 50, 40));
				temp.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 520, 50, 40));
				temp.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 670, 50, 40));
				temp.add(new Circle(COURT_WIDTH, COURT_HEIGHT, 790, 50, 40));
			}
			
			// make balls move with gravity
			for (Circle pokeball: targets) {
				pokeball.v_y += 1;

				// make the poke ball bounce off walls...
				pokeball.bounce(pokeball.hitWall());
			}
			
			// check for game end conditions
			
			for (Circle pokeball: targets) {
			if (pokeball.intersects(Pikachu)) {
				playing = false;
				status.setText("You didn't catch em all!");
				}
			}
			
			}
			requestFocusInWindow();
			repaint();
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, COURT_WIDTH, COURT_HEIGHT, null);
		Pikachu.paintComponent(g);
		
		Iterator<Circle> pokeballs = targets.iterator();
		while (pokeballs.hasNext()) {
			Circle c = pokeballs.next();
			c.paintComponent(g);
		}

		Iterator<Bolt> bolts = arsenal.iterator();
		
		while(bolts.hasNext()) {
			Bolt b = bolts.next();
			b.paintComponent(g);
		}
		
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(COURT_WIDTH, COURT_HEIGHT);
	}
}

