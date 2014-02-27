package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import config.ConfigFactory;
import config.GameConfig;
import dto.GameDto;

/** 
 * ���ƴ��壻
 * 
 * @author xinting
 *
 */

public abstract class Layer {
	/**
	 * ���ƴ���ʱx����
	 */
	protected int x;	
	/**
	 * ���ƴ���ʱy����
	 */
	protected int y;	
	/**
	 * ���ƴ���ĸ߶�
	 */
	protected int w;	
	/**
	 * ���ƴ���Ŀ��
	 */
	protected int h;	
	/**
	 * �ڱ߾�
	 */
	protected static final int PADDING;
	/**
	 * �߿���
	 */
	protected static final int SIZE;

	/**
	 * ����ֵ�۸߶�
	 */
	protected static final int IMG_RECT_H=Img.RECT.getHeight(null);
	/**
	 * ����ֵ��ͼƬ���
	 */
	private static final int IMG_RECT_W=Img.RECT.getWidth(null);
	/**
	 * ����ֵ�ۿ��
	 */
	private final int rectw;
	/**
	 * Ĭ������
	 */
	private static final Font DEF_FONT=new Font("����",Font.BOLD,20);
	
	/**
	 * �������ֵĿ��
	 */
	protected static final int IMG_NUMBER_W=Img.NUMBER.getWidth(null)/10;
	/**
	 * �������ֵĸ߶�
	 */
	private static final int IMG_NUMBER_H=Img.NUMBER.getHeight(null);

	/**
	 * dto����Դ
	 */
	protected GameDto dto=null;
	
	static{
		//�����Ϸ����
		GameConfig cfg=ConfigFactory.getGameConfig();
		PADDING=cfg.getPadding();
		SIZE=cfg.getWindowSize();
	}
	
	private static int WINDOW_W=Img.WINDOW.getWidth(null);
	private static int WINDOW_H=Img.WINDOW.getHeight(null);

	protected Layer(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.rectw=this.w-(PADDING<<1);
	}
	/**
	 * ���ƴ��ڷ���
	 * @param g
	 */
	protected void createWindow(Graphics g){
		//����ͼƬ�����Ͻ�
		g.drawImage(Img.WINDOW, x, y, x+SIZE, y+SIZE, 0, 0, SIZE, SIZE, null);
		//����ͼƬ������
		g.drawImage(Img.WINDOW, x+SIZE, y, x+w-SIZE,y+SIZE, SIZE, 0, WINDOW_W-SIZE, SIZE, null);
		//����ͼƬ������
		g.drawImage(Img.WINDOW, x+w-SIZE, y, x+w, y+SIZE, WINDOW_W-SIZE, 0, WINDOW_W, SIZE, null);
		//����
		g.drawImage(Img.WINDOW, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE, WINDOW_H-SIZE, null);
		//��
		g.drawImage(Img.WINDOW, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, WINDOW_W-SIZE, WINDOW_H-SIZE, null);
		//����
		g.drawImage(Img.WINDOW, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WINDOW_W-SIZE, SIZE, WINDOW_W, WINDOW_H-SIZE, null);
		//����
		g.drawImage(Img.WINDOW, x,y+h-SIZE ,x+SIZE, y+h,0, WINDOW_H-SIZE, SIZE, WINDOW_H, null);
		//����
		g.drawImage(Img.WINDOW, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, WINDOW_H-SIZE, WINDOW_W-SIZE, WINDOW_H, null);
		//����
		g.drawImage(Img.WINDOW, x+w-SIZE, y+h-SIZE, x+w, y+h, WINDOW_W-SIZE, WINDOW_H-SIZE, WINDOW_W, WINDOW_H, null);

		
	}
	
	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	/**
	 * ��ʾ����
	 * @param x ���Ͻ�x����
	 * @param y ���Ͻ�y����
	 * @param num Ҫ��ʾ������
	 * @param maxBit���ֵ�λ��
	 * @param g���ʶ���
	 */
	protected void drawNumberLeftPad(int x,int y,int num,int maxBit,Graphics g){
		//��Ҫ��ӡ������ת��Ϊ�ַ���
		String strNum= Integer.toString(num);
		//ѭ�����������Ҷ���
		for(int i=0;i<maxBit;i++){
			//�ж��Ƿ������������
			if(maxBit-i <= strNum.length()){
				//����������ַ����е��±�
				int idx=i- maxBit + strNum.length();
				//������number�е�ÿһλȡ��
				int bit=strNum.charAt(idx) - '0';
				//��������
				g.drawImage(Img.NUMBER, 
						this.x+x+IMG_NUMBER_W*i, this.y+y, 
						this.x+x+IMG_NUMBER_W*(i+1), this.y+y+IMG_NUMBER_H, 
						bit*IMG_NUMBER_W, 0,
						(bit+1)*IMG_NUMBER_W, IMG_NUMBER_H, null);
			
			}
		}
	}
	/**
	 * ����ֵ��
	 */
	protected void drawRect(int y,String title,String number,double percent,Graphics g){
		//����ֵ��ʼ��
		int rect_x=this.x+PADDING;
		int rect_y=this.y+y;
		//���Ʊ���
		g.setColor(Color.BLACK);
		g.fillRect(rect_x, rect_y, this.rectw , IMG_RECT_H+4);
		g.setColor(Color.WHITE);
		g.fillRect(rect_x+1, rect_y+1, this.rectw-2, IMG_RECT_H+2);
		g.setColor(Color.BLACK);
		g.fillRect(rect_x+2,rect_y+2, this.rectw-4 , IMG_RECT_H);
		//����߶�
		int w=(int)((percent* (this.rectw-4)));
		//�����ɫ
		int subIdx= (int)(percent*IMG_RECT_W)-1;
		//����ֵ��
		g.drawImage(Img.RECT, 
				rect_x+2, rect_y+2, 
				rect_x+2+w, rect_y+2+IMG_RECT_H,
				subIdx, 0, subIdx+1, IMG_RECT_H,
				null);
		g.setColor(Color.WHITE);
		g.setFont(DEF_FONT);
		g.drawString(title,rect_x+4,rect_y+22);
		if(number!=null){
			g.drawString(number,rect_x+232,rect_y+22);
		}
	}
	/**
	 * ���л�ͼ
	 */
	protected void drawImageAtCenter(Image img,Graphics g){
		int imgW=img.getWidth(null);
		int imgH=img.getHeight(null);
		g.drawImage(img, this.x+(this.w-imgW>>1), this.y+(this.h-imgH>>1),null);
		
	}

	/**
	 * ������ƴ���
	 * @author xinting
	 * @param g
	 */
	abstract public void paint(Graphics g);
}
