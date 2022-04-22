package dao;

import control.board.board;
import dto.DTO_Board;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAO_Board extends Dao {
	
	public static DAO_Board bdao = new DAO_Board();
	
	//글작성
	public boolean write(DTO_Board dto_Board) {
		try {
			String sql = "insert into board(b_title, b_content, m_number, b_gr)values(?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto_Board.getB_title());
			ps.setString(2, dto_Board.getB_content());
			ps.setInt(3, dto_Board.getM_number());
			ps.setInt(4, dto_Board.getB_gr());
			ps.executeUpdate();
			return true;

		}catch(Exception e){
			System.out.println("DAO_Board 글작성 오류 " + e);
		}
		return false;
	}
	//자유게시판 글 호출 메소드
	public ObservableList<DTO_Board> list(int b_number){
		ObservableList<DTO_Board> boardlist = FXCollections.observableArrayList();
		try {
			String sql = "select * from board where b_gr= ? order by b_number desc";
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_number);
			rs=ps.executeQuery();
			while(rs.next()) {
				DTO_Board board = new DTO_Board(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getInt(7)
						);
				boardlist.add(board);
				
			}		
			return boardlist;
		}catch(Exception e) {
			System.out.println( "DAO_Board 글호출 오류 "+e  );
		}
		return null;
	}
	//자유게시판 글 삭제 메소드
	public boolean delete(int b_number) {
		try {
			String sql = "delete from board where b_number=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_number);
			ps.executeUpdate();
			
			return true;
			
		}catch(Exception e) {
			System.out.println( "DAO_Board 글삭제 오류 "+e  );
			return false;
		}
		
	}
	
	//4.글수정 **************
	
	public boolean update(int b_number, String b_content) {
		
		
		try {
			
			//1.sql 작성
			String sql = "update board set b_content=? where b_number=?";
			
			//2.sql 조작
			ps = con.prepareStatement(sql);
			ps.setString(1, b_content);
			ps.setInt(2, b_number);
			
			//3. 실행
			ps.executeUpdate();
			
			//4. 결과
			return true;
			
		} catch (Exception e) {	System.out.println( "DAO_Board 글수정 오류 "+ e); }
		
		return false;
	}
	public boolean view(int b_number,int b_view) {
		try {
			String sql = "update board set b_view=? where b_number=?";
			ps = con.prepareStatement(sql);
			int new_view = b_view + 1;
			board.board.setB_view(new_view);
			ps.setInt(1, new_view);
			ps.setInt(2, b_number);
			ps.executeUpdate();

			return true;
			
		}
		catch (Exception e) {	
			System.out.println( "DAO_Board 글수정 오류 "+ e); 
		}
		return false;
	}
}