package ui;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
public class PanelGame extends JPanel{
	//创建窗体数组
	private Lay lays[]=null;
	
	public PanelGame(){
		lays=new Lay[]{
				new LayBackGround(0,0,0,0),
				new LayDataBase(41,32,330,277),
				new LayDisk(41,341,330,277),
				new LayGame(412,32,330,586),
				new LayButton(783,32,330,116),
				new LayNext(783,180,180,148),
				new LayLevel(963,180,150,148),
				new LayPoint(783,360,330,200)
		};
	}
	/**
	 * @Override
	 */
	public void paintComponent(Graphics g){
		
		for(int i=0;i<lays.length;i++){
		//构建窗体
			lays[i].paint(g);
		}
	}

}
