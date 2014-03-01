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
	 * 个人签名
	 */
	public  static Image SIGN=new ImageIcon("Graphics/string/sign.png").getImage();
	/**
	 * 窗口图片
	 */
	public static Image WINDOW=new ImageIcon("Graphics/window/window.png").getImage();
	/**
	 * 数字图片
	 */
	public static Image NUMBER=new ImageIcon("Graphics/string/number.png").getImage();
	/**
	 * 矩形值槽图片
	 */
	public static Image RECT=new ImageIcon("Graphics/window/rect.png").getImage();
	/**
	 * 数据库窗口标题
	 */
	public static Image DB=new ImageIcon("Graphics/string/db.png").getImage();
	/**
	 * 本地记录窗口标题
	 */
	public static Image LOCAL=new ImageIcon("Graphics/string/local.png").getImage();
	/**
	 * 方块图片
	 */
	public static Image ACT=new ImageIcon("Graphics/game/rect.png").getImage();
	/**
	 *等级标题
	 */
	public static Image LEVEL=new ImageIcon("Graphics/string/level.png").getImage();
	/**
	 *窗口标题（分数）
	 */
	public static Image POINT=new ImageIcon("Graphics/string/score.png").getImage();
	/**
	 *窗口标题（消行）
	 */
	public static Image RMLINE=new ImageIcon("Graphics/string/row_off.png").getImage();
	/**
	 * 下一个图片数组
	 */
	public static Image[] NEXT_ACT;
	
	public static List<Image> BG_LIST;
	
	static{
		//下一个方块图片
		NEXT_ACT=new Image[GameConfig.getSystemConfig().getTypeConfig().size()];
		for(int i=0;i<NEXT_ACT.length;i++){
			NEXT_ACT[i]=new ImageIcon("Graphics/game/"+ i +".png").getImage();
		}
		//背景图片数组
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
