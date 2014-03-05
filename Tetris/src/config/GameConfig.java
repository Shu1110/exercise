package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig  implements Serializable{
	
	private static FrameConfig FRAME_CONFIG=null;
	
	private static DataConfig DATA_CONFIG=null;
	
	private static SystemConfig SYSTEM_CONFIG=null;
	
	private static final boolean IS_DEBUG=false;
	
	static{
		
		try {
			if(IS_DEBUG){
			// ����XML��ȡ��
			SAXReader reader = new SAXReader();
			// ���XML�ļ�
			Document doc = reader.read("data/cfg.xml");
			// ���XML�ļ����ڵ�
			Element game=doc.getRootElement();
			//�����������ö���
			FRAME_CONFIG=new FrameConfig(game.element("frame"));
			//����ϵͳ���ö���
			SYSTEM_CONFIG=new SystemConfig(game.element("system"));
			//�������ݷ������ö���
			DATA_CONFIG=new DataConfig(game.element("data"));
		}else{
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("data/framecfg.dat"));
			FRAME_CONFIG=(FrameConfig)ois.readObject();
			ois=new ObjectInputStream(new FileInputStream("data/systemcfg.dat"));
			SYSTEM_CONFIG=(SystemConfig)ois.readObject();
			ois=new ObjectInputStream(new FileInputStream("data/datacfg.dat"));
			DATA_CONFIG=(DataConfig)ois.readObject();
			ois.close();
		}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	/**
	 * ������˽�л�
	 */
	private GameConfig(){}
	
	/**
	 * ��ô�������
	 */
	public static FrameConfig getFrameConfig(){
		return FRAME_CONFIG;
	}

	/**
	 * ���ϵͳ����
	 */
	public static SystemConfig getSystemConfig() {
		return SYSTEM_CONFIG;
	}

	/**
	 * ������ݷ�������
	 */
	public static DataConfig getDataConfig() {
		return DATA_CONFIG;
	}


}
