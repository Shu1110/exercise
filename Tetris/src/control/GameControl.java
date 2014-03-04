package control;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import service.GameService;
import service.GameTetris;
import ui.JFrameGame;
import ui.JPanelGame;
import ui.config.FrameConfig;
import config.DataInterfaceConfig;
import config.GameConfig;
import dao.Data;
import dto.GameDto;
/**
 *������Ҽ����¼�
 *���ƻ���
 *������Ϸ�߼�
 * @author xinting
 *
 */
public class GameControl {
	/**
	 * ���ݷ��ʽӿ�A
	 */
	private Data dataA;
	/**
	 * ���ݷ��ʽӿ�B
	 */
	private Data dataB;
	
	/**
	 * ��Ϸ�����
	 */
	private JPanelGame panelGame;
	/**
	 * ��Ϸ�߼���
	 */
	private GameService gameService;
	
	/**
	 * ��Ϸ���ƴ���
	 */
	private FrameConfig frameConfig;
	
	/**
	 * ��Ϸ��Ϊ����
	 */
	private Map<Integer,Method> actionList;
	
	/**
	 * ��Ϸ�߳�
	 */
	private Thread gameThread =null;
	
	/**
	 * ��Ϸ����Դ
	 */
	private GameDto dto;
	
	public GameControl(){
		//������Ϸ����Դ
		this.dto=new GameDto();
		//������Ϸ�߼��飨������Ϸ����Դ��
		this.gameService=new GameTetris(dto);;
		//�������ݽӿ�A
		this.dataA=createDataObject(GameConfig.getDataConfig().getDataA());
		//�������ݿ��¼����Ϸ
		this.dto.setDbRecode(dataA.loadData());
		// �����ݽӿ�B��ñ��ش��̼�¼
		this.dataB = createDataObject(GameConfig.getDataConfig().getDataB());
		// ���ñ��ش��̼�¼����Ϸ
		this.dto.setDiskRecode(dataB.loadData());
		//������Ϸ���
		this.panelGame =new JPanelGame(this,dto);
		//��ȡ�û���������
		this.setControlConfig();
		//��ʼ���û����ô���
		this.frameConfig=new FrameConfig(this);
		//��ʼ����Ϸ�����ڣ���װ��Ϸ���
		new JFrameGame(this.panelGame);
	}
	
	/**
	 * ��ȡ�û���������
	 */
	private void setControlConfig(){
		//�����������뷽������ӳ������
		this.actionList=new HashMap<Integer,Method>();
		try {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("data/control.dat"));
			@SuppressWarnings("unchecked")
			HashMap<Integer,String> cfgSet=(HashMap<Integer,String>)ois.readObject();
			Set<Entry<Integer,String>> entryset=cfgSet.entrySet();
			for(Entry<Integer,String> e:entryset){
				actionList.put(e.getKey(), this.gameService.getClass().getMethod(e.getValue()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * �������ݶ���
	 */
	private Data createDataObject(DataInterfaceConfig cfg){
		try {
			//��������
			Class<?> cls=Class.forName(cfg.getClassName());
			//��ù�����
			Constructor<?> ctr=cls.getConstructor(HashMap.class);
			//��������
			return (Data)ctr.newInstance(cfg.getParam());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 *������ҿ�����������Ϊ
	 */
	public void actionByKeyCode(int keyCode) {
		try {
			if(this.actionList.containsKey(keyCode)){
				this.actionList.get(keyCode).invoke(this.gameService);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		this.panelGame.repaint();	
	}

	/**
	 * ��ʾ��ҿ��ƴ���
	 */
	public void showUserConfig() {
		this.frameConfig.setVisible(true);
	}

	/**
	 * �Ӵ��ڹر��¼�
	 */
	public void setOver() {
		this.panelGame.repaint();
		this.setControlConfig();
	}

	/**
	 * ��ʼ��ť�¼�
	 */
	public void start() {
		//��尴ť����Ϊ���ɵ��
		this.panelGame.buttonSwitch(false);
		//��Ϸ���ݳ�ʼ��
		this.gameService.startGame();
		//�����̶߳���
		this.gameThread=new Thread(){
			@Override
			public void run(){
				//ˢ�»���
				panelGame.repaint();
				//��ѭ��
				while(true){
					try {
						//�ȴ�0.5��
						Thread.sleep(500);
						//��Ϸ����Ϊ
						gameService.mainAction();
						//ˢ�»���
						panelGame.repaint();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//�����߳�
		this.gameThread.start();
		//ˢ�»���
		this.panelGame.repaint();
	}
}
