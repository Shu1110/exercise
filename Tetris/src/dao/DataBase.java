package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Player;

public class DataBase implements Data{
	
	private static String DRIVER="com.mysql.jdbc.Driver";
	
	private static String DB_URL="jdbc:mysql://127.0.0.1:3306/game_test";
	
	private static String DB_USER="root";
	
	private static String DB_PWD="shu1110";

	private static String LOAD_SQL="SELECT  user_name,POINT FROM (SELECT * FROM user_point ORDER BY  POINT DESC)AS tmp LIMIT 5";
	
	private static String SAVE_SQL="INSERT INTO user_point (user_name,POINT) VALUES (?,?)";
	
	static{
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Player> loadData() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Player> players=new ArrayList<Player>();
		try {
			conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
			stmt=conn.prepareStatement(LOAD_SQL);
			rs=stmt.executeQuery();
			while(rs.next()){
				players.add(new Player(rs.getString(1),rs.getInt(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return players;
	}

	@Override
	public void saveData(Player players) {
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PWD);
			stmt=conn.prepareStatement(SAVE_SQL);
			stmt.setObject(1, players.getName());
			stmt.setObject(2, players.getPoint());
			stmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String args[]){
		DataBase db=new DataBase();
		db.saveData(new Player("SHU",6540));
		System.out.println("ddd");
	}

}
