package config;

public class ConfigFactory {
	private static GameConfig GAME_CONFIG=null;
	
	static{
		try{
			GAME_CONFIG=new GameConfig();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static GameConfig getGameConfig(){
		return GAME_CONFIG;
	}

}
