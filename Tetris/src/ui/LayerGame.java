package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;


public class LayerGame extends Layer {
	
	private static Image ACT=new ImageIcon("Graphics/game/rect.png").getImage();

	//Ӳ���� �����ļ�
	/**
	 * ��λ��ƫ����
	 */
	private static int SIZE_ROL=5;
	
	public LayerGame(int x,int y,int w,int h){
		super(x, y, w, h);
	}
	public void paint(Graphics g){
		this.createWindow(g);
		//��÷������鼯��
		Point[] points=this.dto.getGameAct().getActPoints();
		//��÷������ͱ��
		int typeCode=this.dto.getGameAct().getTypeCode();
		//��ӡ����
		for(int i=0;i<points.length;i++){
			drawActByPoint(points[i].x,points[i].y,typeCode+1,g);
		}
		//��ӡ��ͼ
		boolean[][] map=this.dto.getGameMap();
		for(int x=0;x<map.length;x++){
			for(int y=0;y<map[x].length;y++){
				if(map[x][y]){
					drawActByPoint(x,y,0,g);
				}
			}
		}
	}
	/**
	 * ���������ο�
	 * @param x
	 * @param y
	 * @param imgIdx
	 * @param g
	 */
	private void drawActByPoint(int x,int y,int imgIdx,Graphics g){
		g.drawImage(ACT, 
				this.x+(x<<SIZE_ROL)+5, 
				this.y+(y<<SIZE_ROL)+5,
				this.x+(x+1<<SIZE_ROL)+5,
				this.y+(y+1<<SIZE_ROL)+5,
				imgIdx<<SIZE_ROL, 0, (imgIdx+1)<<SIZE_ROL, 1<<SIZE_ROL, null);

	}

}
