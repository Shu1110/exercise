package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer {	
	/**
	 *���ڱ��⣨������
	 */
	private static final Image IMG_POINT=new ImageIcon("Graphics/string/score.png").getImage();

	private static final int POINT_Y=PADDING;
	
	/**
	 *���ڱ��⣨���У�
	 */
	private static final Image IMG_RMLINE=new ImageIcon("Graphics/string/row_off.png").getImage();

	private static final int RMLINE_Y=IMG_RMLINE.getHeight(null)+(PADDING<<1);
	
	/**
	 * �������λ��
	 */
	private static final int POINT_BIT=5;
	
	private static int POINT_X=0;
	
	public LayerPoint(int x,int y,int w,int h){
		super(x, y, w, h);
		//��ʼ��������ʾ������
		POINT_X=this.w -IMG_NUMBER_W* POINT_BIT -PADDING;
	}
	public void paint(Graphics g){
		this.createWindow(g);
		//���ڱ��⣨������
		g.drawImage(IMG_POINT, this.x+PADDING,this.y+POINT_Y, null);
		this.drawNumberLeftPad(POINT_X, POINT_Y, this.dto.getNowPoint(), POINT_BIT, g);
		// ���ڱ��⣨���У�
		g.drawImage(IMG_RMLINE, this.x + PADDING, this.y + RMLINE_Y, null);
		this.drawNumberLeftPad(POINT_X, RMLINE_Y, this.dto.getNowRemoveLine(), POINT_BIT, g);

	}

}
