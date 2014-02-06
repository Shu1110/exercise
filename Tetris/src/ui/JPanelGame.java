package ui;
import java.awt.Graphics;
import java.awt.Image;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import config.ConfigFactory;
import config.GameConfig;
import config.LayerConfig;
public class JPanelGame extends JPanel{
	//创建窗体数组
	private List<Layer> layers=null;
	
	public JPanelGame(){
		try{
			//获得游戏配置
			GameConfig cfg=ConfigFactory.getGameConfig();
			//获得层配置
			List<LayerConfig> layersCfg=cfg.getLayersConfig();
			//创建游戏层数组
			layers=new ArrayList<Layer>(layersCfg.size());
			//创建所有层对象
			for(LayerConfig layerCfg:layersCfg){
				//获得类对象
				Class<?> cls=Class.forName(layerCfg.getClassName());
				//获得构造函数
				Constructor<?> ctr=cls.getConstructor(int.class,int.class,int.class,int.class);
				//调用构造函数创建对象
				Layer l=(Layer)ctr.newInstance(
					layerCfg.getX(),layerCfg.getY(),layerCfg.getW(),layerCfg.getH()
				);
				//把创建的Layer对象放入集合
				layers.add(l);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
//		lays=new Layer[]{
//				new LayerBackGround(0,0,0,0),
//				new LayerDataBase(41,32,330,277),
//				new LayerDisk(41,341,330,277),
//				new LayerGame(412,32,330,586),
//				new LayerButton(783,32,330,116),
//				new LayerNext(783,180,180,148),
//				new LayerLevel(963,180,150,148),
//				new LayerPoint(783,360,330,200)
//		};
	}
	/**
	 * @Override
	 */
	public void paintComponent(Graphics g){
		
		for(int i=0;i<layers.size();i++){
		//构建窗体
			layers.get(i).paint(g);
		}
	}

}
