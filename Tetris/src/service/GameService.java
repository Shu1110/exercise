package service;

import java.util.List;

import dto.Player;

public interface GameService {
	
	/**
	 * �������
	 */
	public void keyUp();
	
	/**
	 * �������
	 */
	public void keyDown();
	
	/**
	 * �������
	 */
	public void keyLeft();
	
	/**
	 * �������
	 */
	public void keyRight();
	
	/**
	 * ����
	 */
	public void keyFunUp();
	
	/**
	 * ���
	 */
	public void keyFunDown();
	
	/**
	 * ����
	 */
	public void keyFunLeft();
	
	/**
	 * ԲȦ
	 */
	public void keyFunRight();
	
	/**
	 * �������ݶ���
	 */
	public void setDbRecode(List<Player> players);
	
	/**
	 * �������ݶ��� 
	 */
	public void setDiskRecode(List<Player> players);
}
