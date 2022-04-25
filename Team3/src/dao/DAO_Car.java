package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import control.board.board;
import control.car.Carlist;
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
	public ArrayList<DTO_Car> list(String search) {
		try {
			ArrayList<DTO_Car> carlist = new ArrayList<>();
			String sql = null;
			
			if(search == null){
				sql = "select * from car";
			}
			else if(search.equals("pop5491pop")) {
				sql = "SELECT * FROM car order by c_view desc";
			}
			else if(search.equals("new5491new")) {
				sql = "SELECT * FROM TEAM3.car order by c_date desc";
			}
			else {
				sql = "select * from car where c_title like '%"+search+"%' order by c_number desc";
			}
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {	
				System.out.println("중고차 ");
				DTO_Car car = new DTO_Car(  
						rs.getInt(1) ,
						rs.getString(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5),
						rs.getInt(6),
						rs.getInt(7),
						rs.getString(8),
						rs.getInt(9),
						rs.getInt(10),
						rs.getInt(11),
						rs.getInt(12),
						rs.getInt(13),
						rs.getString(14),
						rs.getString(15),
						rs.getInt(16)
						);
				carlist.add(car);
			}	
			return carlist;
			
		} catch (Exception e) {
			System.out.println("중고차 불러오기 실패 " + e);
		}
		return null;
	}
	public boolean view(int c_number,int c_view) {
		try {
			String sql = "update car set c_view=? where c_number=?";
			ps = con.prepareStatement(sql);
			int new_view = c_view + 1;
			Carlist.select.setC_view(new_view);
			ps.setInt(1, new_view);
			ps.setInt(2, c_number);
			ps.executeUpdate();
			return true;
			
		}
		catch (Exception e) {	
			System.out.println( "조회수 수정 오류 "+ e); 
		}
		return false;
	}
	public boolean delete(int c_number) {
		try {
			String sql = "delete from car where c_number=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, c_number);
			ps.executeUpdate();
			
			return true;
			
		}catch(Exception e) {
			System.out.println( "차량 게시물 삭제 오류 "+e  );
			return false;
		}
		
	}
	//통계 //날짜별 등록한 매물의 총 개수 //막대
	public Map<String, Integer> datetotal( String 테이블명 , String 날짜필드명 ){
		Map<String, Integer> map  = new TreeMap<>();
		
		String sql = "select substring_index( "+날짜필드명+" , ' ' , 1 )  , count(*)"
					+ " from "+테이블명
					+ " group by substring_index( "+날짜필드명+" , ' ' , 1 )";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				map.put( rs.getString(1) , rs.getInt(2) );
				// 결과의 해당 레코드의 첫번째필드[날짜]   , 두번째 필드[가입자수] 
			}
			return map;
		}catch( Exception e ) {
			System.out.println("통계 오류(총매물막대)" + e);
		}
		return null;
	}
	//통계 //카테고리별 조회수 //막대
	public Map<String, Integer > datetotal2(){
		Map<String , Integer > map2 = new HashMap<String, Integer>();
		String sql = "select c.c_category, avg(c.c_view) from car as c group by c.c_category";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while( rs.next() ) {
				map2.put( rs.getString( 1 ) , rs.getInt( 2 ) );
			}
			return map2;
		}catch( Exception e ) {
			System.out.println("통계 오류(카테고리별조회수막대)" +e);
		}  return null;
	}
	//통계 //카테고리별 조회수 //원형
	public Map<String, Integer > category_view_piechart(){
		Map<String, Integer> map = new HashMap<>();
		String sql = "select c_category , c_view from car group by c_category";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				map.put(rs.getString(1),
				rs.getInt(2)		);
				
			}
			return map;
		}catch(Exception e) {
			System.out.println("통계 오류(카테고리별조회수원형)" +e);
		}
		return null;
		
	}
	
}