package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	protected Connection con;
	protected PreparedStatement ps;
	protected ResultSet rs;
	
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://database-1.cslkca43ufc7.ap-northeast-2.rds.amazonaws.com:3306/TEAM3?serverTimezone=UTC","admin","43397275");
			System.out.println("Main Dao DB 연결 완료");
		} 
		catch (Exception e) {
			System.out.println("Main Dao DB 연결 실패 "+ e);
		}
	}	
}

