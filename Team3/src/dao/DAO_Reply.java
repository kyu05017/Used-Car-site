package dao;

import dto.DTO_Reply;

public class DAO_Reply extends Dao {
	
	public DAO_Reply() {}
	
	public static DAO_Reply rdao = new DAO_Reply();
	
	public boolean re_update(DTO_Reply reply) {
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
}
