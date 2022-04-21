package dao;

import dto.DTO_Reply;
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
	public ObservableList<DTO_Reply> list(int b_number){
		ObservableList<DTO_Reply> replyList = FXCollections.observableArrayList();
		try {
			String sql = "select * from reply where b_number= ? order by r_number";
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_number);
			rs=ps.executeQuery();
			while(rs.next()) {
				DTO_Reply reply = new DTO_Reply(
						rs.getInt(1),
						rs.getInt(2),
						rs.getInt(3),
						rs.getString(4),
						rs.getString(5)
						);
				replyList.add(reply);
			}		
			return replyList;
		}catch(Exception e) {
			System.out.println( "DAO_Board 글호출 오류 "+e  );
		}
		return null;
	}
	public boolean re_update(int r_number,String r_content) {
		try {
			
		}
		catch(Exception e) {
			System.out.println("댓글 수정 오류 " + e);
		}
		return false;
	}
	public boolean re_delete() {
		try {
			
		}
		catch(Exception e) {
			System.out.println("댓글 삭제 오류 " + e);
		}
		return false;
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> refs/remotes/origin/master
