package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class dao {

	protected Connection con;
	protected PreparedStatement ps;
	protected ResultSet rs;
	
	public dao() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://주소","admin","비밀번호");
			System.out.println("연결되었습니다.");
		} catch (Exception e) { System.out.println("연결실패");	}
		
		
	}
	
}
