package dao;

public class DAO_Member extends Dao{
	
	public DAO_Member() {}
	
	// 회원가입
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
	// 아이디 중복체크
	public boolean id_duplicat() {
		try {
			
		}
		catch (Exception e) {
			System.out.println("DAO_Member 아이디 중복 체크 오류 " + e);
		}
		return false;
	}
	// 로그인
	public boolean login() {
		try {
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member 로그인 오류 " + e);
		}
		return false;
	}
	// 아이디 찾기
	public boolean find_id() {
		try {
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member 아이디 찾기 오류 " + e);
		}
		return false;
	}
	// 비밀번호 찾기
	public boolean find_pw() {
		try {
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member 비밀번호 찾기 오류 " + e);
		}
		return false;
	}
	// 비밀번호 변경
	public boolean change_pw() {
		try {
			return true;
		}
		catch (Exception e) {
			System.out.println("DAO_Member 비밀번호 변경 오류 " + e);
		}
		return false;
	}
	// 회원 정보 저장
	public DAO_Member get_member () {
		try {
			
		}
		catch (Exception e) {
			System.out.println("DAO_Member 회원정보 호출 오류 " + e);
		}
		return null;
	}
	// 회원 탈퇴 
	public boolean signout() {
		try {
			
		}
		catch (Exception e) {
			System.out.println("DAO_Member 회원탈퇴 호출 오류 " + e);
		}
		return false;
	}
}
