package service;

import java.awt.Point;
import java.util.List;
import java.util.Map;
import java.util.Random;

import config.GameConfig;
import dto.GameDto;
import dto.Player;
import entity.GameAct;

public class GameTetris implements GameService{

	private GameDto dto;
	/**
	 * �����������
	 */
	private Random random=new Random();
	/**
	 * �����������
	 */
	private static final int MAX_TYPE=GameConfig.getSystemConfig().getTypeConfig().size()-1;
	
	/**
	 * ��������
	 */
	private static final int LEVEL_UP=GameConfig.getSystemConfig().getLevleUp();
	
	/**
	 * �������з�����
	 */
	private static final Map<Integer,Integer> PLUS_POINT=GameConfig.getSystemConfig().getPlusPoint();
	
	public GameTetris(GameDto dto) {
		this.dto = dto;
	}
	
	/**
	 * �������  ��
	 */
	public boolean keyUp() {
		this.dto.getGameAct().round(this.dto.getGameMap());
		return true;
	}
	/**
	 * �������   ��
	 */
	public boolean keyDown() {
		//���������ƶ������ж��Ƿ��ƶ��ɹ�
		if(this.dto.getGameAct().move(0, 1,this.dto.getGameMap())){
			return false;
		}
		//�����Ϸ��ͼ����
		boolean[][] map=this.dto.getGameMap();
		//��÷������
		Point[] act=this.dto.getGameAct().getActPoints();
		//������ѻ�����ͼ����
		for(int i=0;i<act.length;i++){
			map[act[i].x][act[i].y]=true;
		}
		//�ж����У��������þ���ֵ
		int plusExp=this.plusExp();
		//�����������
		if(plusExp>0){
			//���Ӿ���ֵ
			this.plusPoint(plusExp);
		}
		//ˢ���µķ���
		this.dto.getGameAct().init(this.dto.getNext());
		//�����������һ������
		this.dto.setNext(random.nextInt(MAX_TYPE));
		//�����Ϸ�Ƿ�ʧ��
		if(this.isLose()){
			this.afterLose();
		}
		return true;
	}

	/**
	 * ��Ϸʧ�ܺ�Ĵ���
	 */
	private void afterLose() {
		//������Ϸ��ʼ״̬Ϊfalse
		this.dto.setStart(false);
		//TODO �ر���Ϸ���߳�
	}

	/**
	 * �����Ϸ�Ƿ�ʧ��
	 */
	private boolean isLose() {
		//������ڵĻ����
		Point[] actPoints=this.dto.getGameAct().getActPoints();
		//������ڵ���Ϸ��ͼ
		boolean[][] map=this.dto.getGameMap();
		for(int i=0;i<actPoints.length;i++){
			if(map[actPoints[i].x][actPoints[i].y]){
				return true;
			}
		}
		return false;
	}

	/**
	 * �ӷ���������
	 */
	private void plusPoint(int plusExp) {
		int lv=this.dto.getNowLevel();
		int rmLine=this.dto.getNowRemoveLine();
		int point=this.dto.getNowPoint();
		if(rmLine % LEVEL_UP +plusExp>=LEVEL_UP){
			this.dto.setNowLevel(++lv);
		}
		this.dto.setNowRemoveLine(rmLine+plusExp);
		this.dto.setNowPoint(point+PLUS_POINT.get(plusExp));
	}

	/**
	 * �������   ��
	 */
	public boolean keyLeft() {
		this.dto.getGameAct().move(-1, 0,this.dto.getGameMap());
		return true;
	}
	/**
	 * �������  ��
	 */
	public boolean keyRight() {
		this.dto.getGameAct().move(1, 0,this.dto.getGameMap());
		return true;
	}
	
	/**
	 * ���в���
	 */
	private int plusExp() {
		//�����Ϸ��ͼ
		boolean[][] map=this.dto.getGameMap();
		int exp=0;
		//ɨ����Ϸ��ͼ���鿴�Ƿ��п�����
		for(int y=0;y<GameDto.GAMEZONE_H;y++){
			//�ж��Ƿ������
			if(this.isCanRemoveLine(y,map)){
				//����������У�������
				this.removeLine(y,map);
				//���к����Ӿ���ֵ
				exp++;
			}
		}
		return exp;
	}
	
	/**
	 * ���д���
	 */
	private void removeLine(int rowNumber, boolean[][] map) {
		for(int x=0;x<GameDto.GAMEZONE_W;x++){
			for(int y=rowNumber; y>0; y--){
				map[x][y]=map[x][y-1];
			}
			map[x][0]=false;
		}
		
	}

	/**
	 * �ж�ĳһ���Ƿ������
	 */
	private boolean isCanRemoveLine(int y,boolean[][] map){
		//�����ڶ�ÿһ����Ԫ�����ɨ��
		for(int x=0;x<GameDto.GAMEZONE_W;x++){
			if(!map[x][y]){
				//�����һ������Ϊfalse��ֱ��������һ��
				return false;
			}
		}
		return true;
	}
	
	/**
	 * ���׼�
	 */
	@Override
	public boolean keyFunUp() {
		//TODO ע��
		int point=this.dto.getNowPoint();
		int rmLine=this.dto.getNowRemoveLine();
		int lv=this.dto.getNowLevel();
		point+=10;
		rmLine+=1;
		if(rmLine % 20==0){
			lv+=1;
		}
		this.dto.setNowPoint(point);	
		this.dto.setNowLevel(lv);
		this.dto.setNowRemoveLine(rmLine);
		return true;
	}

	/**
	 * ˲�������
	 */
	@Override
	public boolean keyFunDown() {
		while(!this.keyDown());
		return true;
	}

	/**
	 * ��Ӱ���أ��ó���δʵ����Ӱ���ܣ�
	 */
	@Override
	public boolean keyFunLeft() {
		return true;
	}

	/**
	 * ��ͣ���ܼ�
	 */
	@Override
	public boolean keyFunRight() {
		//TODO ��ͣ
		return true;
	}

	public void setDbRecode(List<Player> players){
		this.dto.setDbRecode(players);
	}
	
	public void setDiskRecode(List<Player> players){
		this.dto.setDiskRecode(players);
	}

	@Override
	public void startMainThread() {
		//���������һ������
		this.dto.setNext(random.nextInt(MAX_TYPE));
		//����������ڷ���
		this.dto.setGameAct(new GameAct(random.nextInt(MAX_TYPE)));
		//����Ϸ״̬��Ϊ��ʼ
		this.dto.setStart(true);
		//TODO �ر��߳�
	}
}

