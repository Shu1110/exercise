package service;

import java.awt.Point;

import dto.GameDto;
import entity.GameAct;

public class GameService {

	private GameDto dto;

	public GameService(GameDto dto) {
		this.dto = dto;
		GameAct act=new GameAct();
		dto.setGameAct(act);
	}
	
	/**
	 * 控制器方向  上
	 */
	public void keyUp() {
		// TODO 旋转
		if(this.canMove(0, -1)){
			this.dto.getGameAct().move(0, -1);
		}
	}
	/**
	 * 控制器方向   下
	 */
	public void keyDown() {
		if(this.canMove(0, 1)){
			this.dto.getGameAct().move(0, 1);
		}
		
	}
	/**
	 * 控制器方向   左
	 */
	public void keyLeft() {
		if(this.canMove(-1, 0)){
			this.dto.getGameAct().move(-1, 0);
		}
		
	}
	/**
	 * 控制器方向   右
	 */
	public void keyRight() {
		if(this.canMove(1, 0)){
			this.dto.getGameAct().move(1, 0);
		}
		
	}
	/**
	 * 判断是否可以移动
	 * @param moveX
	 * @param moveY
	 * @return
	 */
	private boolean canMove(int moveX,int moveY){
		Point[] nowPoints= this.dto.getGameAct().getActPoints();
		for(int i=0;i<nowPoints.length;i++){
			int newX=nowPoints[i].x+moveX;
			int newY=nowPoints[i].y+moveY;
			//TODO 配置
			if(newX<0||newX>9||newY<0||newY>17){
				return false;
			}
		}
		return true;
		
	}
}
