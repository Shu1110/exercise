package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import dto.Player;

public abstract class LayerData extends Layer{

	//TODO ��ʾ����ֵ����  �����ļ�
	private static final int MAX_ROW = 5;

	/**
	 * ��ʼY����
	 */
	private static int STATR_Y = 0;

	private static final int RECT_H = IMG_RECT_H + 4;

	/**
	 * ���
	 * */
	private static int SPA=0;
	
	public LayerData(int x, int y, int w, int h) {
		super(x, y, w, h);
		//�����¼���Ƽ��
		SPA=(this.h - RECT_H * 5 - (PADDING << 1) - Img.DB.getHeight(null)) / MAX_ROW;
		//������ʼY����
		STATR_Y=PADDING+Img.DB.getHeight(null)+SPA;
	}
	
	/**
	 * ��������ֵ��
	 * @param imgTitle ����ͼƬ
	 * @param players ����Դ
	 * @param g ����
	 */
	public void showData(Image imgTitle,List<Player> players,Graphics g){
		//���Ʊ���
		g.drawImage(imgTitle, this.x+PADDING, this.y+PADDING, null);
		//������ڷ���
		int nowPoint=this.dto.getNowPoint();
		//ѭ�����Ƽ�¼
		for(int i=0;i<MAX_ROW;i++){
			//���һ����Ҽ�¼
			Player pla=players.get(i); 
			//��ø÷���
			int recodePoint = pla.getPoint();
			//�������ڷ������¼������ֵ
			double percent=(double)nowPoint/recodePoint;
			//������Ƽ�¼����ֵ��Ϊ100%
			percent=percent>1 ? 1.0:percent;
			//���Ƶ�����¼
			String strPoint =recodePoint==0 ? null:Integer.toString(recodePoint);
			this.drawRect(STATR_Y+i*(RECT_H+SPA),
					pla.getName(),strPoint, 
					percent, g);
		}
	}
	
	@Override
	abstract public void paint(Graphics g);

}
