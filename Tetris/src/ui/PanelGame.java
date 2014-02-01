package ui;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
public class PanelGame extends JPanel{
	private Lay lay=new Lay(128,32,320,576);
	private Lay lay1=new Lay(128,32,256,272);
	private Lay lay2=new Lay(128,336,256,272);
	private Lay lay3=new Lay(448,32,320,576);
	private Lay lay4=new Lay(832,32,256,64);
	private Lay lay5=new Lay(832,128,160,140);
	private Lay lay6=new Lay(992,128,96,140);
	private Lay lay7=new Lay(832,300,256,164);
	private Lay lay8=new Lay(832,496,256,112 );
	
	public PanelGame(){
		
	}
	
	public void paintComponent(Graphics g){
		lay1.createWindow(g);
		lay2.createWindow(g);
		lay3.createWindow(g);
		lay4.createWindow(g);
		lay5.createWindow(g);
		lay6.createWindow(g);
		lay7.createWindow(g);
		lay8.createWindow(g);
	}

}
