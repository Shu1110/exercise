package control;

import service.GameService;
import ui.JPanelGame;
/**
 *������Ҽ����¼�
 *���ƻ���
 *������Ϸ�߼�
 * @author xinting
 *
 */
public class GameControl {
	/**
	 * ��Ϸ�����
	 */
	private JPanelGame panelGame;
	/**
	 * ��Ϸ�߼���
	 */
	private GameService gameService;
	
	public GameControl(JPanelGame panelGame,GameService gameService){
		this.panelGame=panelGame;
		this.gameService=gameService;
	}
	/**
	 * ����������  ��
	 */
	public void keyUp() {
		this.gameService.keyUp();
		this.panelGame.repaint();
	}
	/**
	 * ����������   ��
	 */
	public void keyDown() {
		this.gameService.keyDown();
		this.panelGame.repaint();
	}
	/**
	 * ����������   ��
	 */
	public void keyLeft() {
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}
	/**
	 * ����������   ��
	 */
	public void keyRight() {
		this.gameService.keyRight();
		this.panelGame.repaint();
	}
	
	//TODO=====================���Է���=======================
	public void testLevelUp() {
		this.gameService.testLevelUp();
		this.panelGame.repaint();
	}

	
}
