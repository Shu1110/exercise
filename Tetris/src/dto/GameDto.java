package dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import config.GameConfig;

import entity.GameAct;

public class GameDto {
	
	/**
	 * ��Ϸ���
	 */
	public static final int GAMEZONE_W=GameConfig.getSystemConfig().getMaxX()+1;
	
	/**
	 * ��Ϸ�߶�
	 */
	public static final int GAMEZONE_H=GameConfig.getSystemConfig().getMaxY()+1;
	
	/**
	 * ���ݿ������
	 */
	private List<Player> dbRecode;
	/**
	 * ���ش�������
	 */
	private List<Player> diskRecode;
	/**
	 * ��Ϸ��������õķ���
	 */
	private boolean[][] gameMap;
	/**
	 * ���䷽��
	 */
	private GameAct gameAct;
	/**
	 * ��һ������
	 */
	private int next;
	/**
	 * �ȼ�
	 */
	private int nowLevel;
	/**
	 * �ȼ�
	 */
	private int nowPoint;
	/**
	 * ����
	 */
	private int nowRemoveLine;
	
	/**
	 * ��Ϸ�Ƿ��ǿ�ʼ״̬
	 */
	private boolean start;
	
	/**
	 * ���캯��
	 */
	public GameDto(){
		dtoInit();
	}
	
	public void dtoInit(){
		this.gameMap=new boolean[GAMEZONE_W][GAMEZONE_H];
	}
	public List<Player> getDbRecode() {
		return dbRecode;
	}

	public void setDbRecode(List<Player> dbRecode) {
		this.dbRecode = this.setFillRecode(dbRecode);
	}

	public List<Player> getDiskRecode() {
		return diskRecode;
	}

	public void setDiskRecode(List<Player> diskRecode) {
		this.diskRecode = this.setFillRecode(diskRecode);
	}
	
	private List<Player> setFillRecode(List<Player> players){
		//����������ǿգ���ô�ʹ���
		if(players==null){
			players=new ArrayList<Player>();
		}
		//�����¼��С��5����ô�ͼӵ�5��Ϊֹ
		while(players.size()<5){
			players.add(new Player("No Data",0));
		}
		Collections.sort(players);
		return players;
	}

	public boolean[][] getGameMap() {
		return gameMap;
	}

	public void setGameMap(boolean[][] gameMap) {
		this.gameMap = gameMap;
	}

	public GameAct getGameAct() {
		return gameAct;
	}

	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getNowLevel() {
		return nowLevel;
	}

	public void setNowLevel(int nowLevel) {
		this.nowLevel = nowLevel;
	}

	public int getNowPoint() {
		return nowPoint;
	}

	public void setNowPoint(int nowPoint) {
		this.nowPoint = nowPoint;
	}

	public int getNowRemoveLine() {
		return nowRemoveLine;
	}

	public void setNowRemoveLine(int nowRemoveLine) {
		this.nowRemoveLine = nowRemoveLine;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}
	
	
}
