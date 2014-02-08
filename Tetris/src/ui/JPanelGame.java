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
import control.GameControl;
import control.PlayerControl;
public class JPanelGame extends JPanel{
	//创建窗体数组
	private List<Layer> layers=null;
	
	public JPanelGame(){
		//初始化组件
		initComponent();
		//初始化层
		initLayer();
		
	}
	
	/**
	 * 初始化组件
	 */
	private void initComponent(){
		GameControl ctrl=new GameControl(this);
		this.addKeyListener(new PlayerControl(ctrl));
	}
	
	/**
	 * 初始化层
	 */
	private void initLayer(){
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
	}
	
	@Override 
	public void paintComponent(Graphics g){
		//调用基类方法
		super.paintComponent(g);
		//绘制游戏界面
		for(int i=0;i<layers.size();layers.get(i++).paint(g));
		//返回焦点
		this.requestFocus();
	}

}
