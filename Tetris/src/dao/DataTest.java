package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dto.Player;

public class DataTest implements Data{

	public DataTest(HashMap<String,String> param){
		
	}
	
	@Override
	public List<Player> loadData() {
		List<Player> players=new ArrayList<Player>();
		players.add(new Player(("����"),3224));
//		players.add(new Player(("����"),340));
//		players.add(new Player(("����"),3410));
		players.add(new Player(("����"),220));
		players.add(new Player(("����"),1430));
		return players;
	}

	@Override
	public void saveData(Player players) {
		System.out.println();
		
	}

}
