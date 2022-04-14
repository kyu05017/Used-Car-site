package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Dao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");// 1. DB 드라이버 가져오기
			con = DriverManager.getConnection("jdbc:mysql://주소","admin","비밀번호"); // 2. DB 주소 연결
			System.out.println("보드 DB연동 성공");
		} 
		catch (Exception e) {
			System.out.println("[SQL 모드 연동 실패 ] "+ e);
		}
	}	
	
	
	
}

