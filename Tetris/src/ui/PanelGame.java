package ui;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
public class PanelGame extends JPanel{
	public PanelGame(){
		
	}
	
	public void paintComponent(Graphics g){
		Image img=new ImageIcon("Graphics/window/window.png").getImage();
		int size=7;//ͼƬ���ϽǴ�С
		int x=32;//panel�ϻ���ͼƬ����ʼ����
		int y=32;//panel�ϻ���ͼƬ����ʼ����
		int w=256;//panel�ϻ���ͼƬ�Ĵ�С
		int h=128;//panel�ϻ���ͼƬ�Ĵ�С
		int imgW=img.getWidth(null);
		int imgH=img.getHeight(null);	
		//����ͼƬ�����Ͻ�
		g.drawImage(img, x, y, x+size, y+size, 0, 0, size, size, null);
		//����ͼƬ������
		g.drawImage(img, x+size, y, x+w-size,y+size, size, 0, imgW-size, size, null);
		//����ͼƬ������
		g.drawImage(img, x+w-size, y, x+w, y+size, imgW-size, 0, imgW, size, null);
		//����
		g.drawImage(img, x, y+size, x+size, y+h-size, 0, size, size, imgH-size, null);
		//��
		g.drawImage(img, x+size, y+size, x+w-size, y+h-size, size, size, imgW-size, imgH-size, null);
		//����
		g.drawImage(img, x+w-size, y+size, x+w, y+h-size, imgW-size, size, imgW, imgH-size, null);
		//����
		g.drawImage(img, x,y+h-size ,x+size, y+h,0, imgH-size, size, imgH, null);
		//����
		g.drawImage(img, x+size, y+h-size, x+w-size, y+h, size, imgH-size, imgW-size, imgH, null);
		//����
		g.drawImage(img, x+w-size, y+h-size, x+w, y+h, imgW-size, imgH-size, imgW, imgH, null);
	}

}
