package dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.GameFunction;
import config.GameConfig;
import entity.GameAct;

public class GameDto {
	
	/**
	 * 游戏宽度
	 */
	public static final int GAMEZONE_W=GameConfig.getSystemConfig().getMaxX()+1;
	
	/**
	 * 游戏高度
	 */
	public static final int GAMEZONE_H=GameConfig.getSystemConfig().getMaxY()+1;
	
	/**
	 * 数据库层数据
	 */
	private List<Player> dbRecode;
	/**
	 * 本地磁盘数据
	 */
	private List<Player> diskRecode;
	/**
	 * 游戏主窗体放置的方块
	 */
	private boolean[][] gameMap;
	/**
	 * 下落方块
	 */
	private GameAct gameAct;
	/**
	 * 下一个方块
	 */
	private int next;
	/**
	 * 等级
	 */
	private int nowLevel;
	/**
	 * 等级
	 */
	private int nowPoint;
	/**
	 * 消行
	 */
	private int nowRemoveLine;
	
	/**
	 * 游戏是否是开始状态
	 */
	private boolean start;
	
	/**
	 * 暂停
	 */
	private boolean pause;
	
	/**
	 * 是否使用作弊
	 */
	private boolean cheat;
	
	/**
	 * 线程睡眠时间
	 */
	private long sleepTime;
	
	/**
	 * 构造函数
	 */
	public GameDto(){
		dtoInit();
	}
	
	public void dtoInit(){
		this.gameMap=new boolean[GAMEZONE_W][GAMEZONE_H];
		this.nowLevel=1;
		this.nowPoint=0;
		this.nowRemoveLine=0;
		this.pause=false;
		this.cheat=false;
		this.sleepTime=GameFunction.getSleepTimeByLevel(this.nowLevel);
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
		//如果进来的是空，那么就创建
		if(players==null){
			players=new ArrayList<Player>();
		}
		//如果记录数小于5，那么就加到5条为止
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
		//计算线程睡眠时间
		this.sleepTime=GameFunction.getSleepTimeByLevel(this.nowLevel);
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

	public boolean isPause() {
		return pause;
	}

	public void changePause() {
		this.pause = !this.pause;
	}

	public boolean isCheat() {
		return cheat;
	}

	public void setCheat(boolean cheat) {
		this.cheat = cheat;
	}

	public long getSleepTime() {
		return sleepTime;
	}
	
	
}
