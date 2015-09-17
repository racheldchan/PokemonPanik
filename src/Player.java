
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Player extends GameObj {
	private static ImageIcon img;
	public static final int SIZE = 100;
	public static final int INIT_X = 130;
	//public static final int INIT_Y = 130;
	public static final int INIT_VEL_X = 0;
	public static final int INIT_VEL_Y = 0;
	
	public Player (int courtWidth, int courtHeight) {
		super(INIT_VEL_X, INIT_VEL_Y, INIT_X, courtHeight - SIZE, SIZE, SIZE, courtWidth,
				courtHeight);
		try {
			if (img == null) {
				img = new ImageIcon("pikachu-f.png");
			}
		} catch (Exception e) {
			System.out.println("Internal Error:" + e.getMessage());
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if (super.v_x == 0) {
			ImageIcon new_img = new ImageIcon("pikachu-f.png");
			g.drawImage(new_img.getImage(), pos_x, pos_y, width + 25, height + 25, null);
		}
		else if (super.v_x > 0) {
			ImageIcon right_img = new ImageIcon("PikachuSideRunning.gif");
			g.drawImage(right_img.getImage(), pos_x, pos_y + 15, width - 10, height - 28, null);
		}
		else if (super.v_x < 0) {
			ImageIcon left_img = new ImageIcon("invertPikachu-ConvertImage.gif");
			g.drawImage(left_img.getImage(), pos_x, pos_y + 15, width - 10, height - 28, null);
		}
		else {
			ImageIcon new_img = new ImageIcon("pikachu-f.png");
			g.drawImage(new_img.getImage(), pos_x, pos_y, width, height, null);
		}
	}
}
