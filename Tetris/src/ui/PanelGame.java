package ui;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
public class PanelGame extends JPanel{
	private Lay lays[]=null;
	//private Lay lay=new Lay(128,32,320,576);
	private Lay lay1=new Lay(41,32,330,277); 
	private Lay lay2=new Lay(41,341,330,277);	
	private Lay lay3=new Lay(412,32,330,586);
	private Lay lay4=new Lay(783,32,330,116);
	private Lay lay5=new Lay(783,180,180,148);
	private Lay lay6=new Lay(963,180,150,148);
	private Lay lay7=new Lay(783,360,330,200);
	//private Lay lay8=new Lay(832,496,256,112 );
	
	public PanelGame(){
		lays=new Lay[]{
				
		};
	}
	/**
	 * @Override
	 */
	public void paintComponent(Graphics g){
		lay1.createWindow(g);
		lay2.createWindow(g);
		lay3.createWindow(g);
		lay4.createWindow(g);
		lay5.createWindow(g);
		lay6.createWindow(g);
		lay7.createWindow(g);
		//lay8.createWindow(g);
	}

}
