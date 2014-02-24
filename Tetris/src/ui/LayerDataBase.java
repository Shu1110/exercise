package ui;

import java.awt.Graphics;

public class LayerDataBase extends Layer {
	
	

	
	public LayerDataBase(int x,int y,int w,int h){
		super(x, y, w, h);
	}
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(Img.DB, this.x+PADDING, this.y+PADDING, null);
	}

}
