package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerDisk extends Layer {
	
	private static Image IMG_LOCAL=new ImageIcon("Graphics/string/local.png").getImage();

	public LayerDisk(int x,int y,int w,int h){
		super(x, y, w, h);
	}
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(IMG_LOCAL, this.x+PADDING, this.y+PADDING,null);
	}

}