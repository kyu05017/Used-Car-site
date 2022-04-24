package dao;

import dto.DTO_Reply;
import dto.Reply;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAO_Reply extends Dao {
	
	public DAO_Reply() {}
	
	public static DAO_Reply rdao = new DAO_Reply();
	
	public boolean re_write(DTO_Reply reply) {
		try {
			String sql = "INSERT INTO reply(m_number,b_number,r_content) VALUES (?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1,reply.getM_number());
			ps.setInt(2,reply.getB_number());
			ps.setString(3,reply.getR_content());
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			System.out.println("댓글 저장 실패 " + e);
		}
		return false;
	}
	//댓글 호오출
	public ObservableList<Reply> list(int b_number){
		ObservableList<Reply> replyList = FXCollections.observableArrayList();
		try {
			String sql = "SELECT a.*,b.m_id FROM TEAM3.reply a left join TEAM3.member b on a.m_number = b.m_number where b_number = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_number);
			rs=ps.executeQuery();
			while(rs.next()) {
				Reply reply = new Reply(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6)
						);
				replyList.add(reply);
			}		
			return replyList;
		}catch(Exception e) {
			System.out.println( "댓글 호출 오류 "+e  );
		}
		return null;
	}
	//댓글수정
	public boolean re_update(int r_number,String r_content) {
		try {
			String sql = "update reply set r_content=? where r_number=?";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, r_content);
			ps.setInt(2, r_number);
			ps.executeUpdate();
			
			return true;
		}
		catch(Exception e) {
			System.out.println("댓글 수정 오류 " + e);
		}
		return false;
	}
	//댓글삭제
	public boolean re_delete(int r_number) {
		try {
			String sql ="delete from reply where r_number=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, r_number);
			ps.executeUpdate();
			return true;
		}
		catch(Exception e) {
			System.out.println("댓글 삭제 오류 " + e);
		}
		return false;
	}
}