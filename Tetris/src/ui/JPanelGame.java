package ui;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
public class JPanelGame extends JPanel{
	//创建窗体数组
	private Layer lays[]=null;
	
	public JPanelGame(){
		lays=new Layer[]{
				new LayerBackGround(0,0,0,0),
				new LayerDataBase(41,32,330,277),
				new LayerDisk(41,341,330,277),
				new LayerGame(412,32,330,586),
				new LayerButton(783,32,330,116),
				new LayerNext(783,180,180,148),
				new LayerLevel(963,180,150,148),
				new LayerPoint(783,360,330,200)
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
