package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import config.ConfigFactory;
import config.GameConfig;
import dto.GameDto;

/** 
 * 绘制窗体；
 * 
 * @author xinting
 *
 */

public abstract class Layer {
	/**
	 * 绘制窗体时x坐标
	 */
	protected int x;	
	/**
	 * 绘制窗体时y坐标
	 */
	protected int y;	
	/**
	 * 绘制窗体的高度
	 */
	protected int w;	
	/**
	 * 绘制窗体的宽度
	 */
	protected int h;	
	/**
	 * 内边距
	 */
	protected static final int PADDING;
	/**
	 * 边框宽度
	 */
	protected static final int SIZE;

	/**
	 * 矩形值槽高度
	 */
	protected static final int IMG_RECT_H=Img.RECT.getHeight(null);
	/**
	 * 矩形值槽图片宽度
	 */
	private static final int IMG_RECT_W=Img.RECT.getWidth(null);
	/**
	 * 矩形值槽宽度
	 */
	private final int rectw;
	/**
	 * 默认字体
	 */
	private static final Font DEF_FONT=new Font("黑体",Font.BOLD,20);
	
	/**
	 * 单个数字的宽度
	 */
	protected static final int IMG_NUMBER_W=Img.NUMBER.getWidth(null)/10;
	/**
	 * 单个数字的高度
	 */
	private static final int IMG_NUMBER_H=Img.NUMBER.getHeight(null);

	/**
	 * dto数据源
	 */
	protected GameDto dto=null;
	
	static{
		//获得游戏配置
		GameConfig cfg=ConfigFactory.getGameConfig();
		PADDING=cfg.getPadding();
		SIZE=cfg.getWindowSize();
	}
	
	private static int WINDOW_W=Img.WINDOW.getWidth(null);
	private static int WINDOW_H=Img.WINDOW.getHeight(null);

	protected Layer(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.rectw=this.w-(PADDING<<1);
	}
	/**
	 * 绘制窗口方法
	 * @param g
	 */
	protected void createWindow(Graphics g){
		//绘制图片的左上角
		g.drawImage(Img.WINDOW, x, y, x+SIZE, y+SIZE, 0, 0, SIZE, SIZE, null);
		//绘制图片的中上
		g.drawImage(Img.WINDOW, x+SIZE, y, x+w-SIZE,y+SIZE, SIZE, 0, WINDOW_W-SIZE, SIZE, null);
		//绘制图片的右上
		g.drawImage(Img.WINDOW, x+w-SIZE, y, x+w, y+SIZE, WINDOW_W-SIZE, 0, WINDOW_W, SIZE, null);
		//左中
		g.drawImage(Img.WINDOW, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE, WINDOW_H-SIZE, null);
		//中
		g.drawImage(Img.WINDOW, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, WINDOW_W-SIZE, WINDOW_H-SIZE, null);
		//右中
		g.drawImage(Img.WINDOW, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WINDOW_W-SIZE, SIZE, WINDOW_W, WINDOW_H-SIZE, null);
		//左下
		g.drawImage(Img.WINDOW, x,y+h-SIZE ,x+SIZE, y+h,0, WINDOW_H-SIZE, SIZE, WINDOW_H, null);
		//中下
		g.drawImage(Img.WINDOW, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, WINDOW_H-SIZE, WINDOW_W-SIZE, WINDOW_H, null);
		//右下
		g.drawImage(Img.WINDOW, x+w-SIZE, y+h-SIZE, x+w, y+h, WINDOW_W-SIZE, WINDOW_H-SIZE, WINDOW_W, WINDOW_H, null);

		
	}
	
	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	/**
	 * 显示数字
	 * @param x 左上角x坐标
	 * @param y 左上角y坐标
	 * @param num 要显示的数字
	 * @param maxBit数字的位数
	 * @param g画笔对象
	 */
	protected void drawNumberLeftPad(int x,int y,int num,int maxBit,Graphics g){
		//把要打印的数字转换为字符串
		String strNum= Integer.toString(num);
		//循环绘制数字右对齐
		for(int i=0;i<maxBit;i++){
			//判断是否满足绘制条件
			if(maxBit-i <= strNum.length()){
				//获得数字在字符串中的下标
				int idx=i- maxBit + strNum.length();
				//把数字number中的每一位取出
				int bit=strNum.charAt(idx) - '0';
				//绘制数字
				g.drawImage(Img.NUMBER, 
						this.x+x+IMG_NUMBER_W*i, this.y+y, 
						this.x+x+IMG_NUMBER_W*(i+1), this.y+y+IMG_NUMBER_H, 
						bit*IMG_NUMBER_W, 0,
						(bit+1)*IMG_NUMBER_W, IMG_NUMBER_H, null);
			
			}
		}
	}
	/**
	 * 绘制值槽
	 */
	protected void drawRect(int y,String title,String number,double percent,Graphics g){
		//各种值初始化
		int rect_x=this.x+PADDING;
		int rect_y=this.y+y;
		//绘制背景
		g.setColor(Color.BLACK);
		g.fillRect(rect_x, rect_y, this.rectw , IMG_RECT_H+4);
		g.setColor(Color.WHITE);
		g.fillRect(rect_x+1, rect_y+1, this.rectw-2, IMG_RECT_H+2);
		g.setColor(Color.BLACK);
		g.fillRect(rect_x+2,rect_y+2, this.rectw-4 , IMG_RECT_H);
		//求出高度
		int w=(int)((percent* (this.rectw-4)));
		//求出颜色
		int subIdx= (int)(percent*IMG_RECT_W)-1;
		//绘制值槽
		g.drawImage(Img.RECT, 
				rect_x+2, rect_y+2, 
				rect_x+2+w, rect_y+2+IMG_RECT_H,
				subIdx, 0, subIdx+1, IMG_RECT_H,
				null);
		g.setColor(Color.WHITE);
		g.setFont(DEF_FONT);
		g.drawString(title,rect_x+4,rect_y+22);
		if(number!=null){
			g.drawString(number,rect_x+232,rect_y+22);
		}
	}
	/**
	 * 正中绘图
	 */
	protected void drawImageAtCenter(Image img,Graphics g){
		int imgW=img.getWidth(null);
		int imgH=img.getHeight(null);
		g.drawImage(img, this.x+(this.w-imgW>>1), this.y+(this.h-imgH>>1),null);
		
	}

	/**
	 * 具体绘制窗口
	 * @author xinting
	 * @param g
	 */
	abstract public void paint(Graphics g);
}
