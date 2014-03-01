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
	 * ����ǩ��
	 */
	public  static Image SIGN=new ImageIcon("Graphics/string/sign.png").getImage();
	/**
	 * ����ͼƬ
	 */
	public static Image WINDOW=new ImageIcon("Graphics/window/window.png").getImage();
	/**
	 * ����ͼƬ
	 */
	public static Image NUMBER=new ImageIcon("Graphics/string/number.png").getImage();
	/**
	 * ����ֵ��ͼƬ
	 */
	public static Image RECT=new ImageIcon("Graphics/window/rect.png").getImage();
	/**
	 * ���ݿⴰ�ڱ���
	 */
	public static Image DB=new ImageIcon("Graphics/string/db.png").getImage();
	/**
	 * ���ؼ�¼���ڱ���
	 */
	public static Image LOCAL=new ImageIcon("Graphics/string/local.png").getImage();
	/**
	 * ����ͼƬ
	 */
	public static Image ACT=new ImageIcon("Graphics/game/rect.png").getImage();
	/**
	 *�ȼ�����
	 */
	public static Image LEVEL=new ImageIcon("Graphics/string/level.png").getImage();
	/**
	 *���ڱ��⣨������
	 */
	public static Image POINT=new ImageIcon("Graphics/string/score.png").getImage();
	/**
	 *���ڱ��⣨���У�
	 */
	public static Image RMLINE=new ImageIcon("Graphics/string/row_off.png").getImage();
	/**
	 * ��һ��ͼƬ����
	 */
	public static Image[] NEXT_ACT;
	
	public static List<Image> BG_LIST;
	
	static{
		//��һ������ͼƬ
		NEXT_ACT=new Image[GameConfig.getSystemConfig().getTypeConfig().size()];
		for(int i=0;i<NEXT_ACT.length;i++){
			NEXT_ACT[i]=new ImageIcon("Graphics/game/"+ i +".png").getImage();
		}
		//����ͼƬ����
		File dir=new File("Graphics/background");
		File[] files=dir.listFiles();
		BG_LIST=new ArrayList<Image>();
		for(File file:files){
			if(!file.isDirectory()){
				BG_LIST.add(new ImageIcon(file.getPath()).getImage());
			}
		}
		
	}
	
	
}
