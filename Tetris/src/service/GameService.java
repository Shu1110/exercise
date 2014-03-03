package service;

import java.util.List;

import dto.Player;

public interface GameService {
	
	/**
	 * �������
	 */
	public boolean keyUp();
	
	/**
	 * �������
	 */
	public boolean keyDown();
	
	/**
	 * �������
	 */
	public boolean keyLeft();
	
	/**
	 * �������
	 */
	public boolean keyRight();
	
	/**
	 * ����
	 */
	public boolean keyFunUp();
	
	/**
	 * ���
	 */
	public boolean keyFunDown();
	
	/**
	 * ����
	 */
	public boolean keyFunLeft();
	
	/**
	 * ԲȦ
	 */
	public boolean keyFunRight();
	
	/**
	 * �������ݶ���
	 */
	public void setDbRecode(List<Player> players);
	
	/**
	 * �������ݶ��� 
	 */
	public void setDiskRecode(List<Player> players);

	/**
	 * �������̣߳���ʼ��Ϸ
	 */
	public void startMainThread();
}
