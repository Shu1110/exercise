package service;

import dto.GameDto;

public class GameService {

	private GameDto dto;

	public GameService(GameDto dto) {
		this.dto = dto;
	}

	public void gameTest() {
		int temp=dto.getNowPoint();
		dto.setNowPoint(temp+1);
		
	}
	
	
}
