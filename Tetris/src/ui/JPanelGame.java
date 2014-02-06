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
	//������������
	private List<Layer> layers=null;
	
	public JPanelGame(){
		try{
			//�����Ϸ����
			GameConfig cfg=ConfigFactory.getGameConfig();
			//��ò�����
			List<LayerConfig> layersCfg=cfg.getLayersConfig();
			//������Ϸ������
			layers=new ArrayList<Layer>(layersCfg.size());
			//�������в����
			for(LayerConfig layerCfg:layersCfg){
				//��������
				Class<?> cls=Class.forName(layerCfg.getClassName());
				//��ù��캯��
				Constructor<?> ctr=cls.getConstructor(int.class,int.class,int.class,int.class);
				//���ù��캯����������
				Layer l=(Layer)ctr.newInstance(
					layerCfg.getX(),layerCfg.getY(),layerCfg.getW(),layerCfg.getH()
				);
				//�Ѵ�����Layer������뼯��
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
		//��������
			layers.get(i).paint(g);
		}
	}

}
