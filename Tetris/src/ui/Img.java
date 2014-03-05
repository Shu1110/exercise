package ui;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import config.GameConfig;

public class Img {
	
	private Img(){}
	
	/**
	 * ͼƬ·��
	 */
	private static final String GRAPHICS_PATH="Graphics/";
	
	private static final String DEFAULT_PATH="default/";
	
	
	
	public static void setSkin(String path){
		String skinPath=GRAPHICS_PATH +path;
		
		//����ǩ�� 
		 SIGN=new ImageIcon(skinPath +"string/sign.png").getImage();
		 // ����ͼƬ
		WINDOW=new ImageIcon(skinPath +"window/window.png").getImage();
		//����ͼƬ
		NUMBER=new ImageIcon(skinPath +"string/number.png").getImage();
		//����ֵ��ͼƬ
		RECT=new ImageIcon(skinPath +"window/rect.png").getImage();
		//���ݿⴰ�ڱ���
		DB=new ImageIcon(skinPath +"string/db.png").getImage();
		//���ؼ�¼���ڱ���
		LOCAL=new ImageIcon(skinPath +"string/local.png").getImage();
		//����ͼƬ
		ACT=new ImageIcon(skinPath +"game/rect.png").getImage();
		//�ȼ�����
		LEVEL=new ImageIcon(skinPath +"string/level.png").getImage();
		//���ڱ��⣨������
		POINT=new ImageIcon(skinPath +"string/score.png").getImage();
		//���ڱ��⣨���У�
		RMLINE=new ImageIcon(skinPath +"string/row_off.png").getImage();
		//��ʼ��ť
		BTN_START=new ImageIcon(skinPath +"string/start.png");
		//���ð�ť
		BTN_CONFIG=new ImageIcon(skinPath +"string/config.png");
		// ��ͣͼƬ
		PAUSE=new ImageIcon(skinPath +"string/pause.png").getImage();
	
			//��һ������ͼƬ
			NEXT_ACT=new Image[GameConfig.getSystemConfig().getTypeConfig().size()];
			for(int i=0;i<NEXT_ACT.length;i++){
				NEXT_ACT[i]=new ImageIcon(skinPath +"game/"+ i +".png").getImage();
			}
			//����ͼƬ����
			File dir=new File(skinPath +"background");
			File[] files=dir.listFiles();
			BG_LIST=new ArrayList<Image>();
			for(File file:files){
				if(!file.isDirectory()){
					BG_LIST.add(new ImageIcon(file.getPath()).getImage());
				}
			}
	}
		
	
	
	/**
	 * ����ǩ��
	 */
	public  static Image SIGN=null;
	
	/**
	 * ����ͼƬ
	 */
	public static Image WINDOW=null;
	
	/**
	 * ����ͼƬ
	 */
	public static Image NUMBER=null;
	
	/**
	 * ����ֵ��ͼƬ
	 */
	public static Image RECT=null;
	
	/**
	 * ���ݿⴰ�ڱ���
	 */
	public static Image DB=null;
	
	/**
	 * ���ؼ�¼���ڱ���
	 */
	public static Image LOCAL=null;
	
	/**
	 * ����ͼƬ
	 */
	public static Image ACT=null;
	
	/**
	 *�ȼ�����
	 */
	public static Image LEVEL=null;
	
	/**
	 *���ڱ��⣨������
	 */
	public static Image POINT=null;
	
	/**
	 *���ڱ��⣨���У�
	 */
	public static Image RMLINE=null;

	/**
	 * ��ʼ��ť
	 */
	public static ImageIcon BTN_START=null;

	/**
	 * ���ð�ť
	 */
	public static ImageIcon BTN_CONFIG=null;
	
	/**
	 * ��ͣͼƬ
	 */
	public static Image PAUSE=null;
	
	/**
	 * ��һ��ͼƬ����
	 */
	public static Image[] NEXT_ACT=null;
	
	public static List<Image> BG_LIST=null;
	
	/**
	 * ��ʼ��ͼƬ
	 */
	static{
		setSkin(DEFAULT_PATH);
	}
	
}
