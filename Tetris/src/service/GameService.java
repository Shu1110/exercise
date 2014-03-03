package service;

import java.util.List;

import dto.Player;

public interface GameService {
	
	/**
	 * 方向键上
	 */
	public boolean keyUp();
	
	/**
	 * 方向键下
	 */
	public boolean keyDown();
	
	/**
	 * 方向键左
	 */
	public boolean keyLeft();
	
	/**
	 * 方向键右
	 */
	public boolean keyRight();
	
	/**
	 * 三角
	 */
	public boolean keyFunUp();
	
	/**
	 * 大叉
	 */
	public boolean keyFunDown();
	
	/**
	 * 方块
	 */
	public boolean keyFunLeft();
	
	/**
	 * 圆圈
	 */
	public boolean keyFunRight();
	
	/**
	 * 设置数据对象
	 */
	public void setDbRecode(List<Player> players);
	
	/**
	 * 设置数据对象 
	 */
	public void setDiskRecode(List<Player> players);

	/**
	 * 启动主线程，开始游戏
	 */
	public void startMainThread();
}
