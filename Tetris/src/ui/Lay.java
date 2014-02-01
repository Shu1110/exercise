package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/** 
 * ���ƴ��壻
 * 
 * @author xinting
 *
 */

public class Lay {
	private int x;	//���ƴ���ʱx����
	private int y;	//���ƴ���ʱy����
	private int w;	//���ƴ���Ŀ���
	private int h;	//���ƴ���ĸ߶�
	
	public static final int SIZE=5;
	public static Image WINDOW_IMG=new ImageIcon("Graphics/window/window.png").getImage();
	public static int WINDOW_W=WINDOW_IMG.getWidth(null);
	public static int WINDOW_H=WINDOW_IMG.getHeight(null);

	public Lay(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
	/**
	 * ���ƴ��ڷ���
	 * @param g
	 */
	public void createWindow(Graphics g){
		//����ͼƬ�����Ͻ�
		g.drawImage(WINDOW_IMG, x, y, x+SIZE, y+SIZE, 0, 0, SIZE, SIZE, null);
		//����ͼƬ������
		g.drawImage(WINDOW_IMG, x+SIZE, y, x+w-SIZE,y+SIZE, SIZE, 0, WINDOW_W-SIZE, SIZE, null);
		//����ͼƬ������
		g.drawImage(WINDOW_IMG, x+w-SIZE, y, x+w, y+SIZE, WINDOW_W-SIZE, 0, WINDOW_W, SIZE, null);
		//����
		g.drawImage(WINDOW_IMG, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE, WINDOW_H-SIZE, null);
		//��
		g.drawImage(WINDOW_IMG, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, WINDOW_W-SIZE, WINDOW_H-SIZE, null);
		//����
		g.drawImage(WINDOW_IMG, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WINDOW_W-SIZE, SIZE, WINDOW_W, WINDOW_H-SIZE, null);
		//����
		g.drawImage(WINDOW_IMG, x,y+h-SIZE ,x+SIZE, y+h,0, WINDOW_H-SIZE, SIZE, WINDOW_H, null);
		//����
		g.drawImage(WINDOW_IMG, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, WINDOW_H-SIZE, WINDOW_W-SIZE, WINDOW_H, null);
		//����
		g.drawImage(WINDOW_IMG, x+w-SIZE, y+h-SIZE, x+w, y+h, WINDOW_W-SIZE, WINDOW_H-SIZE, WINDOW_W, WINDOW_H, null);

		
	}
}