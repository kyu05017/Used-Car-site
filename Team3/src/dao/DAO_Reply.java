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
			System.out.println("´ñ±Û ÀúÀå ½ÇÆÐ " + e);
		}
		return false;
	}
	//´ñ±Û È£¿ÀÃâ
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
			System.out.println( "DAO_Board ±ÛÈ£Ãâ ¿À·ù "+e  );
		}
		return null;
	}
	public boolean re_update(int r_number,String r_content) {
		try {
			
		}
		catch(Exception e) {
			System.out.println("´ñ±Û ¼öÁ¤ ¿À·ù " + e);
		}
		return false;
	}
	//´ñ±Û»èÁ¦
	public boolean re_delete() {
		try {
			
		}
		catch(Exception e) {
			System.out.println("´ñ±Û »èÁ¦ ¿À·ù " + e);
		}
		return false;
	}

}

