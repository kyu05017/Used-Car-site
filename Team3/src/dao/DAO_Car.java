package dao;

import java.util.ArrayList;

import dto.DTO_Car;

public class DAO_Car extends Dao {
	
	public static DAO_Car dao_Car = new DAO_Car();
	//차저장하기
	public boolean add(DTO_Car car) {
		try {
			String sql = "insert into car( c_title, c_content,c_img, c_category, c_price, c_cnumber, c_condition, c_km, c_fuel, c_mission, c_com, c_year, m_number) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, car.getC_title());
			ps.setString(2, car.getC_content());
			ps.setString(3, car.getC_img());
			ps.setInt(4, car.getC_category());
			ps.setInt(5, car.getC_price());
			ps.setString(6, car.getC_cnumber());
			ps.setInt(7, car.getC_condition());
			ps.setInt(8, car.getC_km());
			ps.setInt(9, car.getC_fuel());
			ps.setInt(10, car.getC_mission());
			ps.setString(11, car.getC_com());
			ps.setString(12, car.getC_year());
			ps.setInt(13, car.getM_number());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("중고차 저장 실패 "+ e);
		}
		return false;
	}
	// 차 불러오기
	public ArrayList<DTO_Car> list() {
		ArrayList<DTO_Car> carlist = new ArrayList<>();
		try {
			
			String sql = "select * from car by c_number desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			return carlist;
		} catch (Exception e) {
			System.out.println("중고차 불러오기 실패 " + e);
		}
		return null;
	}
}