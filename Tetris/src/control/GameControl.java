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
	
	public GameControl(JPanelGame panelGame){
		this.panelGame=panelGame;
	}
}
