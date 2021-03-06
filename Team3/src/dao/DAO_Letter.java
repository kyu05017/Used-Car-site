package dao;

import java.util.ArrayList;

import dto.DTO_Letter;
import dto.DTO_Reply;
import dto.Letter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DAO_Letter extends Dao{

	public static DAO_Letter dao_Letter = new DAO_Letter();

	public boolean send(DTO_Letter letter) {
		try {
			String sql = "INSERT INTO letter(m_number,m_id,l_content,C_number) VALUES (?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1,letter.getM_number());
			ps.setString(2,letter.getM_id());
			ps.setString(3,letter.getL_content());
			ps.setInt(4,letter.getC_number());
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			System.out.println("댓글 저장 실패 " + e);
		}
		return false;
	}
	
	public ObservableList<Letter> letters(int m_number,String id){
		ObservableList<Letter> letterlist = FXCollections.observableArrayList();
		try {
			String sql = "SELECT a.*,b.c_title FROM TEAM3.letter a left join TEAM3.car b on a.c_number = b.c_number where a.m_number = ? or m_id=? group by c_cnumber";
			ps = con.prepareStatement(sql);
			ps.setInt(1, m_number);
			ps.setString(2, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				Letter letter = new Letter(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6),
						rs.getString(7)
						);
				letterlist.add(letter);
				
			}		
			return letterlist;
		}catch(Exception e) {
			System.out.println( "쪽지 오류 "+ e  );
		}
		return null;
	}
	public ArrayList<DTO_Letter> get(int c_number,int m_number,String id) {
		
		try {

			ArrayList<DTO_Letter> datelsit = new ArrayList<>();

			String sql = "SELECT * FROM letter  where C_number = ? and ( m_number = ? or m_id = ? )";

			ps = con.prepareStatement(sql);
			ps.setInt(1, c_number);
			ps.setInt(2, m_number);
			ps.setString(3, id);
			rs =  ps.executeQuery();

			while(rs.next()) {
				
				DTO_Letter temp = new DTO_Letter(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getInt(6)
						);
				datelsit.add(temp);
			}

			return datelsit;
		}
		catch (Exception e) {
			System.out.println("[sql 연결 실패] : 사유 " + e);
		}
		return null;
	}
	
}