package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayBackGround extends Lay {
	
	private static Image IMG_BG=new ImageIcon("Graphics/background/bg01.jpeg").getImage();
	
	public LayBackGround(int x,int y,int w,int h){
		super(x,y,w,h);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(IMG_BG, 0, 0, 1156, 650, null);
		// TODO Auto-generated method stub

	}

}
