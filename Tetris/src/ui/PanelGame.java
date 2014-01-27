package ui;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
public class PanelGame extends JPanel{
	public PanelGame(){
		
	}
	
	public void paintComponent(Graphics g){
		Image img=new ImageIcon("Graphics/window/window.png").getImage();
		int size=7;//图片左上角大小
		int x=32;//panel上绘制图片的起始坐标
		int y=32;//panel上绘制图片的起始坐标
		int w=256;//panel上绘制图片的大小
		int h=128;//panel上绘制图片的大小
		int imgW=img.getWidth(null);
		int imgH=img.getHeight(null);	
		//绘制图片的左上角
		g.drawImage(img, x, y, x+size, y+size, 0, 0, size, size, null);
		//绘制图片的中上
		g.drawImage(img, x+size, y, x+w-size,y+size, size, 0, imgW-size, size, null);
		//绘制图片的右上
		g.drawImage(img, x+w-size, y, x+w, y+size, imgW-size, 0, imgW, size, null);
		//左中
		g.drawImage(img, x, y+size, x+size, y+h-size, 0, size, size, imgH-size, null);
		//中
		g.drawImage(img, x+size, y+size, x+w-size, y+h-size, size, size, imgW-size, imgH-size, null);
		//右中
		g.drawImage(img, x+w-size, y+size, x+w, y+h-size, imgW-size, size, imgW, imgH-size, null);
		//左下
		g.drawImage(img, x,y+h-size ,x+size, y+h,0, imgH-size, size, imgH, null);
		//中下
		g.drawImage(img, x+size, y+h-size, x+w-size, y+h, size, imgH-size, imgW-size, imgH, null);
		//右下
		g.drawImage(img, x+w-size, y+h-size, x+w, y+h, imgW-size, imgH-size, imgW, imgH, null);
	}

}
