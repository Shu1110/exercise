package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Player;

public class DataTest implements Data{

	@Override
	public List<Player> loadData() {
		List<Player> players=new ArrayList<Player>();
		players.add(new Player(("刘明"),3224));
//		players.add(new Player(("刘明"),340));
//		players.add(new Player(("刘明"),3410));
		players.add(new Player(("刘明"),220));
		players.add(new Player(("刘明"),1430));
		return players;
	}

	@Override
	public void saveData(Player players) {
		System.out.println();
		
	}

}
