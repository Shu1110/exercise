package control;

import service.GameService;
import ui.JPanelGame;
import dao.Data;
import dao.DataBase;
import dao.DataDisk;
import dao.DataTest;
/**
 *������Ҽ����¼�
 *���ƻ���
 *������Ϸ�߼�
 * @author xinting
 *
 */
public class GameControl {
	/**
	 * ���ݷ��ʽӿ�A
	 */
	private Data dataA;
	/**
	 * ���ݷ��ʽӿ�B
	 */
	private Data dataB;
	
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
		//�����ݽӿ�A������ݿ��¼
		this.dataA=new DataBase();
		//�������ݿ��¼����Ϸ
		this.gameService.setDbRecode(dataA.loadData());
		//�����ݽӿ�B��ñ��ش��̼�¼
		this.dataB=new DataDisk();
		//���ñ��ش��̼�¼����Ϸ
		this.gameService.setDiskRecode(dataB.loadData());
		
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
