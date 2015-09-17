/**
 * CIS 120 HW10
 * (c) University of Pennsylvania
 * @version 2.0, Mar 2013
 * 
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * A basic game object displayed as a yellow circle, starting in the upper left
 * corner of the game court.
 * 
 */
public class Bolt extends GameObj {
	
	private static ImageIcon img;
	public static final int SIZE = 40;
	public static final int INIT_VEL_X = 0;
	public static final int INIT_VEL_Y = -5;

	public Bolt(int INIT_POS_X, int INIT_POS_Y, int courtWidth, int courtHeight) {
		super(INIT_VEL_X, INIT_VEL_Y, INIT_POS_X, INIT_POS_Y, SIZE, SIZE,
				courtWidth, courtHeight);

		try {
			if (img == null) {
				img = new ImageIcon("lightening.png");
			}
		} catch (Exception e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
	}
	@Override
	public void move() {
		pos_x += v_x;
		pos_y += v_y;
	}

	@Override
	public void paintComponent(Graphics g) {
		ImageIcon new_img = new ImageIcon("lightening.png");
		g.drawImage(new_img.getImage(), pos_x, pos_y, width, height, null);
	}

}