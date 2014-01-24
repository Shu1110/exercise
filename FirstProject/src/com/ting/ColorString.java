package com.ting;
import java.awt.*;
import java.applet.*;
import java.util.*;
public class ColorString extends Applet implements Runnable{
	private char[] c = {'我','要','去','旅','行','！'};
	private int red,green,blue;
	Thread t; 
	public void init() {
		t = new Thread(this);
		t.start();
	}

	public void paint(Graphics g) {
		g.setFont(new Font("宋体",1,28));
		for(int i = 0;i < c.length;i++) {
			red = (int)(Math.random()*255);
			green = (int)(Math.random()*255);
			blue = (int)(Math.random()*255);
			g.setColor(new Color(red,green,blue));
			g.drawChars(c, i, 1, 30+i*58, 35);
		}
	}

	public void run() {	
    		//for( ; ; ) {       // 显示banner 
    		try {
      			repaint();
      			Thread.sleep(1000);
      		
      			//if(stopFlag)break;
    		} catch(InterruptedException e) {}
 	   }
	//}	

}
