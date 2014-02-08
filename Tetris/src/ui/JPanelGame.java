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
	//������������
	private List<Layer> layers=null;
	
	public JPanelGame(){
		//��ʼ�����
		initComponent();
		//��ʼ����
		initLayer();
		
	}
	
	/**
	 * ��ʼ�����
	 */
	private void initComponent(){
		GameControl ctrl=new GameControl(this);
		this.addKeyListener(new PlayerControl(ctrl));
	}
	
	/**
	 * ��ʼ����
	 */
	private void initLayer(){
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
	}
	
	@Override 
	public void paintComponent(Graphics g){
		//���û��෽��
		super.paintComponent(g);
		//������Ϸ����
		for(int i=0;i<layers.size();layers.get(i++).paint(g));
		//���ؽ���
		this.requestFocus();
	}

}
