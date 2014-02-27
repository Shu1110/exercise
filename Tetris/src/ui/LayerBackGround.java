package ui;

import java.awt.Graphics;


public class LayerBackGround extends Layer {
	
	public LayerBackGround(int x,int y,int w,int h){
		super(x,y,w,h);
	}

	@Override
	public void paint(Graphics g) {
		int bgIdx=this.dto.getNowLevel()%Img.BG_LIST.size();
		g.drawImage(Img.BG_LIST.get(bgIdx), 0, 0, 1156, 650, null);

	}

}
