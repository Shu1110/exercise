package control;

import service.GameService;
import ui.JPanelGame;
import dao.Data;
import dao.DataBase;
import dao.DataDisk;
import dao.DataTest;
/**
 *接收玩家键盘事件
 *控制画面
 *控制游戏逻辑
 * @author xinting
 *
 */
public class GameControl {
	/**
	 * 数据访问接口A
	 */
	private Data dataA;
	/**
	 * 数据访问接口B
	 */
	private Data dataB;
	
	/**
	 * 游戏界面层
	 */
	private JPanelGame panelGame;
	/**
	 * 游戏逻辑层
	 */
	private GameService gameService;
	
	public GameControl(JPanelGame panelGame,GameService gameService){
		this.panelGame=panelGame;
		this.gameService=gameService;
		//从数据接口A获得数据库记录
		this.dataA=new DataBase();
		//设置数据库记录到游戏
		this.gameService.setDbRecode(dataA.loadData());
		//从数据接口B获得本地磁盘记录
		this.dataB=new DataDisk();
		//设置本地磁盘记录到游戏
		this.gameService.setDiskRecode(dataB.loadData());
		
	}
	/**
	 * 控制器方向  上
	 */
	public void keyUp() {
		this.gameService.keyUp();
		this.panelGame.repaint();
	}
	/**
	 * 控制器方向   下
	 */
	public void keyDown() {
		this.gameService.keyDown();
		this.panelGame.repaint();
	}
	/**
	 * 控制器方向   左
	 */
	public void keyLeft() {
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}
	/**
	 * 控制器方向   右
	 */
	public void keyRight() {
		this.gameService.keyRight();
		this.panelGame.repaint();
	}
	
	//TODO=====================测试方法=======================
	public void testLevelUp() {
		this.gameService.testLevelUp();
		this.panelGame.repaint();
	}

	
}
