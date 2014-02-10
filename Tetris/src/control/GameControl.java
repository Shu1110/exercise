package control;

import service.GameService;
import ui.JPanelGame;
/**
 *接收玩家键盘事件
 *控制画面
 *控制游戏逻辑
 * @author xinting
 *
 */
public class GameControl {
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
	}

	public void test() {
		this.gameService.gameTest();
		this.panelGame.repaint();
	}
}
