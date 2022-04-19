package dao;




import dto.DTO_Board;

public class DAO_Board extends Dao {
	
	

	public static DAO_Board bdao = new DAO_Board();
	
	//글작성
	public boolean write(DTO_Board dto_Board) {
		try {
			String sql = "insert into board(b_number, b_title, b_content, b_date, m_number, b_gr, b_view)values(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, dto_Board.getB_number());
			ps.setString(2, dto_Board.getB_title());
			ps.setString(3, dto_Board.getB_content());
			ps.setString(4, dto_Board.getB_date());
			ps.setInt(5, dto_Board.getM_number());
			ps.setInt(6, dto_Board.getB_gr());
			ps.setInt(7, dto_Board.getB_view());
			ps.executeUpdate();
			return true;
			
			
			
		}catch(Exception e){
			System.out.println("DAO_Board 글작성 오류 " + e);
		}
		return false;
	}
	
}
