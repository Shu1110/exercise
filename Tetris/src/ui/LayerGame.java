package ui;

import java.awt.Graphics;
import java.awt.Point;

public class LayerGame extends Layer {
	
	

	//硬编码 配置文件
	/**
	 * 左位移偏移量
	 */
	private static final int SIZE_ROL=5;
	
	public LayerGame(int x,int y,int w,int h){
		super(x, y, w, h);
	}
	public void paint(Graphics g){
		this.createWindow(g);
		//获得方块数组集合
		Point[] points=this.dto.getGameAct().getActPoints();
		//获得方法类型编号
		int typeCode=this.dto.getGameAct().getTypeCode();
		//打印方块
		for(int i=0;i<points.length;i++){
			drawActByPoint(points[i].x,points[i].y,typeCode+1,g);
		}
		//绘制地图
		boolean[][] map=this.dto.getGameMap();
		//计算当前堆积颜色
		int lv=this.dto.getNowLevel();
		int imgIdx=lv==0?0:(lv-1)%7+1;
		//TODO 如果是输的情况 imgIdx=8
		for(int x=0;x<map.length;x++){
			for(int y=0;y<map[x].length;y++){
				if(map[x][y]){
					drawActByPoint(x,y,imgIdx,g);
				}
			}
		}
	}
	/**
	 * 绘制正方形块
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
