package dao;

import java.util.ArrayList;

import dto.DTO_Car;

public class DAO_Car extends Dao {
	
	public static DAO_Car dao_Car = new DAO_Car();
	
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
			System.out.println("등록 오류 "+ e);
		}
		return false;
	}
	//제품출력
		public ArrayList<DTO_Car> list(String c_category) {
			ArrayList<DTO_Car> carlist = new ArrayList<>();
			try {
				String sql = null;
				if(c_category == null) {
					if(search == null) {
						sql = "select * from product order by p_num desc";	// SQL 작성
						ps = con.prepareStatement(sql);// SQL 연결 
					}
					else {
						sql = "select * from product where p_name like '%"+search+"%' order by p_num desc";	// SQL 작성
						ps = con.prepareStatement(sql);// SQL 연결 
					}
				}
				else  {
					if(search ==  null) {
						sql = "select * from product where p_category = ? order by p_num desc";	// SQL 작성
						ps = con.prepareStatement(sql);// SQL 연결 
						ps.setString(1, c_category);
					}
					else {
						sql = "select * from product where p_category = ? and p_name like '%"+search+"%' order by p_num desc";	// SQL 작성
						ps = con.prepareStatement(sql);// SQL 연결 
						ps.setString(1, c_category);
					}
				}
				rs = ps.executeQuery();					
				while( rs.next() ) {					
					DTO_Car car = new DTO_Car(
							rs.getInt(1) ,
							rs.getString(2),
							rs.getString(3), 
							rs.getString(4), 
							rs.getString(5),
							rs.getInt(6),
							rs.getInt(7),
							rs.getString(8),
							rs.getInt(9));
					carlist.add(car);			// 리스트에 객체 담기 
				}	
				return carlist;						// 리스트 반환
			}catch(Exception e ) { System.out.println( "[SQL 오류]"+e  ); }
		return null; // 만약에 실패시 NULL 반환
	}
		}
}
