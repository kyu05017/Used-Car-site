package DAO;

import DTO.member;

public class Dao_member extends dao {

	public Dao_member() {}
	//깡통
	
	public static Dao_member dmem = new Dao_member();
	//회원가입
	
	public boolean re (member member) {
		try {
			
			String sql = "insert into member(m_id,m_pw,m_name,m_email,m_date,m_phone,m_address,m_today,m_gr)"
					+ "values(?,?,?,?,?,?,?,?)";
			//왜 number는 제외?
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, member.getM_id());
			ps.setString(2, member.getM_pw());
			ps.setString(3, member.getM_name());
			ps.setString(4, member.getM_email());
			ps.setString(5, member.getM_date());
			ps.setString(6, member.getM_phone());
			ps.setString(7, member.getM_address());
			ps.setString(8, member.getM_today());
			ps.setString(9, member.getM_gr());
	
			return true;
		} catch (Exception e) {	}
		return false;
	}
	
	
	
	//로그인
	public boolean login(String id, String pw) {
		//로그인에 id랑 pw를 받아옴 
		
		try {
			String sql = "select * from member where m_id=? and m_pw=?";
						//sql에서 id랑 pw를 빼온다.
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery(); //의미?
			
			if(rs.next()) { //의미?
				return true;
			}
			
		} catch (Exception e) {	}
		
		return false;
	}
	
	
	
	//아이디 찾기
	public boolean findid(String name, String email) {
		
		try {
			String sql = "select * from member where m_name=? and m=email=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email); //왜 m이 안 붙고 그냥 name?
			rs = ps.executeQuery();
			
			if(rs.next()) {return true;}
					
		} catch (Exception e) { System.out.println("아이디 찾기 실패");	}
	
		return false;
	}
	
	
	
	
	
	//비밀번호 찾기
	
	public boolean findpw(String id, String email) {
		
		try {
			String sql = "select * from member where m_id=? and m=email=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, email);
			rs = ps.executeQuery();
			
			if(rs.next()) {return true;}
					
		} catch (Exception e) { System.out.println("비밀번호 찾기 실패");	}
	
		return false;
	}
	
	
	//비밀번호 체크
	
	
	//비밀번호 변경
	
	
	//코드 읽기???
	
	
	//회원정보 저장

	//회원정보 탈퇴
	
	
	
	
	
	
}
