package ui;

import java.awt.Graphics;

public class LayerDisk extends Layer {
	
	

	public LayerDisk(int x,int y,int w,int h){
		super(x, y, w, h);
	}
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(Img.LOCAL, this.x+PADDING, this.y+PADDING,null);
	}

}
