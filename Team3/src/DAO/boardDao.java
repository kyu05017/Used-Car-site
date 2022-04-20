package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.board;
import DTO.reply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class boardDao extends dao {
	

	//호출
	public static boardDao boarddao = new boardDao();
	
	
	//생성자
	public boardDao() {}	
	
	///////////////////////////////////////////
	//메소드
	
	//1.글쓰기
	
	public boolean write(board board) {
		
		//예외처리
		try {			//제목, 내용, 작성자(회원번호)
			String sql = "insert into board(b_title,b_content,m_number) values(?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getB_title());
			ps.setString(2, board.getB_content());
			ps.setInt(3, board.getM_number());
			
			
			//실행
			ps.executeQuery();
			
			return true; //성공값 리턴			
			
		} catch (Exception e) {	}

		return false; //t f
	}
	
	
	//2.글호출
	public ObservableList<board> blist() {
		ObservableList<board> boardlist = FXCollections.observableArrayList();
		
		try {
			
			String sql = "select * from board order by b_number desc";
			//정렬
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			//결과 반복문
			while(rs.next()) {
				
				//객체화
				board board = new board(rs.getInt(1),
						rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getInt(6), rs.getInt(7));
				
				//객체 담기
				boardlist.add(board);
								
			} //while end
			
			//성공할 경우
			return boardlist;
			
		} catch (Exception e) {	}
		
		return null; //실패할 경우
	}
	
	
	
	
	//3.글삭제
	
	public boolean delete(int b_number) {
		
		try {
			// 보드 테이블 안에서 b_num이 같은 걸 지운다.
			String sql = "delete from board where b_num=?";
			
			//sql조작
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_number);
			ps.executeQuery();
			
			return true; //성공시			
			
		} catch (Exception e) {	}

		return false;
	}
	
	
	
	
	
	//4.글수정
	
	public boolean update(int b_number, String b_title, String b_content) {
		
		try {
			// 보드 테이블 안에서 같은 걸 받아온다.
			String sql = "update board set b_title=?, b_content=? where b_number=?";
			
			//sql조작
			ps = con.prepareStatement(sql);
			
			ps.setString(1, b_title);
			ps.setString(2, b_content);
			ps.setInt(3, b_number);
			
			
			ps.executeQuery();
			
			return true; //성공시		

		} catch (Exception e) {	}
			
		return false;
	}
	
	
	////////////////
	
	
	
	
	//5. 댓글 작성
	
	public boolean boardreply(reply reply) {
		
		try {
			String sql = "insert into reply(r_content,r_date,b_number) values(?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, reply.getR_content());
			ps.setString(2, reply.getR_date());
			ps.setInt(3, reply.getB_number());
			
			ps.executeQuery();
			
			return true; //성공시		

		} catch (Exception e) {	}
			
		return false;
	}
	
	
	
	
	//6. 댓글 호출
	
	public ObservableList<reply> replylist (int b_number) {
		
		ObservableList<reply> replylist = FXCollections.observableArrayList();
			
		
		try {															// 오름차순
			String sql = "select * from reply where b_num=? order by b_number desc";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_number);
			rs = ps.executeQuery();
			
			//받아올 것들
				while(rs.next()) { reply reply = new reply
						(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getString(4), rs.getString(5));
						replylist.add(reply);
				}
			
			
			return replylist; //성공시		

		} catch (Exception e) {	}
			
		return null; //실패할 경우
	}
	
	
	
	
	
	
/////////////////////////////////
}
