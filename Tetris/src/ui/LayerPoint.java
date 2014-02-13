package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer {	
	/**
	 *窗口标题（分数）
	 */
	private static final Image IMG_POINT=new ImageIcon("Graphics/string/score.png").getImage();

	private static final int POINT_Y=PADDING;
	
	/**
	 *窗口标题（消行）
	 */
	private static final Image IMG_RMLINE=new ImageIcon("Graphics/string/row_off.png").getImage();

	private static final int RMLINE_Y=IMG_RMLINE.getHeight(null)+(PADDING<<1);
	
	/**
	 * 分数最大位数
	 */
	private static final int POINT_BIT=5;
	
	private static int POINT_X=0;
	
	public LayerPoint(int x,int y,int w,int h){
		super(x, y, w, h);
		//初始化分数显示的坐标
		POINT_X=this.w -IMG_NUMBER_W* POINT_BIT -PADDING;
	}
	public void paint(Graphics g){
		this.createWindow(g);
		//窗口标题（分数）
		g.drawImage(IMG_POINT, this.x+PADDING,this.y+POINT_Y, null);
		this.drawNumberLeftPad(POINT_X, POINT_Y, this.dto.getNowPoint(), POINT_BIT, g);
		// 窗口标题（消行）
		g.drawImage(IMG_RMLINE, this.x + PADDING, this.y + RMLINE_Y, null);
		this.drawNumberLeftPad(POINT_X, RMLINE_Y, this.dto.getNowRemoveLine(), POINT_BIT, g);

	}

}
