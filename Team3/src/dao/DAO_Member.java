package dao;

import java.sql.DriverManager;

public class DAO_Member extends Dao{
	
	public DAO_Member() {}
	
	public boolean registration () {
		try {
			String sql = "insert into (필드값)values(?,?)";
			ps = con.prepareStatement(sql);
			
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member 회원가입 오류 " + e);
		}
		return false;
	}
	public boolean login() {
		try {
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member 로그인 오류 " + e);
		}
		return false;
	}
	public boolean find_id() {
		try {
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member 아이디 찾기 오류 " + e);
		}
		return false;
	}
	public boolean find_pw() {
		try {
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member 비밀번호 찾기 오류 " + e);
		}
		return false;
	}
	public boolean change_pw() {
		try {
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member 비밀번호 변경 오류 " + e);
		}
		return false;
	}
}
