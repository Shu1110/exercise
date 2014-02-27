package ui;

import java.awt.Graphics;
import java.awt.Point;

public class LayerGame extends Layer {
	
	

	//Ӳ���� �����ļ�
	/**
	 * ��λ��ƫ����
	 */
	private static final int SIZE_ROL=5;
	
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
		//���Ƶ�ͼ
		boolean[][] map=this.dto.getGameMap();
		//���㵱ǰ�ѻ���ɫ
		int lv=this.dto.getNowLevel();
		int imgIdx=lv==0?0:(lv-1)%7+1;
		//TODO ����������� imgIdx=8
		for(int x=0;x<map.length;x++){
			for(int y=0;y<map[x].length;y++){
				if(map[x][y]){
					drawActByPoint(x,y,imgIdx,g);
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
		g.drawImage(Img.ACT, 
				this.x+(x<<SIZE_ROL)+5, 
				this.y+(y<<SIZE_ROL)+5,
				this.x+(x+1<<SIZE_ROL)+5,
				this.y+(y+1<<SIZE_ROL)+5,
				imgIdx<<SIZE_ROL, 0, (imgIdx+1)<<SIZE_ROL, 1<<SIZE_ROL, null);

	}

}
