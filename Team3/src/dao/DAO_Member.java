package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import dto.DTO_Member;

public class DAO_Member extends Dao{
	
	public DAO_Member() {}
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static DAO_Member mdao = new DAO_Member();
	// 회원가입
	public boolean registration (DTO_Member member) {
		try {
			String sql = "insert into member(m_id,m_pw,m_name,m_email,m_phone,m_address,m_today,m_gr) values(?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getM_id());
			ps.setString(2, member.getM_pw());
			ps.setString(3, member.getM_name());
			ps.setString(4, member.getM_email());
			ps.setString(5, member.getM_phone());
			ps.setString(6, member.getM_address());
			ps.setString(7, member.getM_today());
			ps.setInt(8, member.getM_gr());
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member 회원가입 오류 " + e);
		}
		return false;
	}
	// 아이디 중복체크
	public boolean id_duplicat(String id) {
		try {
			String sql = "select * from member where m_id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch (Exception e) {
			System.out.println("DAO_Member 아이디 중복 체크 오류 " + e);
		}
		return false;
	}
	// 로그인
	public boolean login(String id, String pw) {
		try {
			String sql = "select * from member where m_id=? and m_pw=?";
			ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ps.setString(2,pw);
			rs = ps.executeQuery();
			if(rs.next()) {
				String today = sdf.format(new Date());
				String sql2 = "UPDATE member SET m_today=? where m_id=?";
				ps = con.prepareStatement(sql2);
				ps.setString(1,today);
				ps.setString(2,id);
				ps.executeUpdate(); 
				return true;
			}
		}
		catch (Exception e) {
			System.out.println("DAO_Member 로그인 오류 " + e);
		}
		return false;
	}
	// 회원정보 임시저장 
	public DTO_Member get_member (String id) {
		try {
			String sql = "select * from member where m_id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) { 
				DTO_Member member = new DTO_Member(
				rs.getInt(1),
				rs.getString(2),
				null,
				rs.getString(4),
				rs.getString(5),
				rs.getString(6),
				rs.getString(7),
				rs.getString(8),
				rs.getString(9),
				rs.getInt(10)
				);
				return member;
			}
		}
		catch(Exception e ) {
			System.out.println("DAO_Member 회원정보 호출 " + e);
		}
		return null;
	}
	// 아이디 찾기
	public String find_id(String name, String email) {
		try {
			String sql = "select * from member where m_name=? and m_email=?";
			ps = con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,email);
			rs = ps.executeQuery();
			if(rs.next()) { 
				return rs.getString(3);
			}
		}
		catch (Exception e) {
			System.out.println("DAO_Member 아이디 찾기 오류 " + e);
		}
		return null;
	}
	// 비밀번호 찾기
	public String find_pw(String id,String email) {
		try {
			String sql = "select * from member where m_id=? and m_email=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, email);
			rs = ps.executeQuery();
			if(rs.next()) { return rs.getString(3);
			}
		}
		catch (Exception e) {
			System.out.println("DAO_Member 비밀번호 찾기 오류 " + e);
		}
		return null;
	}
	// 비밀번호 체크
	public boolean check_pw(int num, String pw) {
		try {
			String sql = "select * from member where m_pw=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, pw);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		}
		catch (Exception e) {
			System.out.println("DAO_Member 비밀번호 변경 오류 " + e);
		}
		return false;
	}
	// 비밀번호 변경 [ 만들기 필요 ]
	public boolean change_pw(int num, String pw) {
		try {
			String sql = "select * from member where m_pw=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, pw);
			rs = ps.executeQuery();
			if(rs.next()) {
				Connection con2;
				PreparedStatement ps2;
				ResultSet rs2;

				String sql2 = "UPDATE member SET m_id=? where m_num=?";
				ps2 = con.prepareStatement(sql);
				ps2.setString(1, pw);
				ps2.setInt(2, num);
				return true;
			}
		}
		catch (Exception e) {
			System.out.println("DAO_Member 비밀번호 변경 오류 " + e);
		}
		return false;
	}
	// 회원 탈퇴 
	public boolean signout(int num) {
		try {
			String sql = "delete from member where m_num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member 회원탈퇴 호출 오류 " + e);
		}
		return false;
	}
}
