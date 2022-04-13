package dto;

public class dtoCar {
	//필드
	private int c_number; //매물번호
	private String c_title; //제목
	private String c_content; //내용
	private String c_date; //날짜
	private String c_img; //이미지경로
	private int c_category; //카테고리
	private int c_price; //가격
	private String c_cnumber; //차량번호
	private int c_view; //조회수
	private int c_condition; //사고유무 
	private int c_km; //주행거리
	private int c_fuel; //연료타입
	private int c_mission; //변속기
	private String c_com; //제조사
	private String c_year;
	private int m_number;
	//생성자
	public dtoCar() {
		
	}
	
	
	public dtoCar(int c_number, String c_title, String c_content, String c_date, String c_img, int c_category,
			int c_price, String c_cnumber, int c_view, int c_condition, int c_km, int c_fuel, int c_mission,
			String c_com, String c_year, int m_number) {
		super();
		this.c_number = c_number;
		this.c_title = c_title;
		this.c_content = c_content;
		this.c_date = c_date;
		this.c_img = c_img;
		this.c_category = c_category;
		this.c_price = c_price;
		this.c_cnumber = c_cnumber;
		this.c_view = c_view;
		this.c_condition = c_condition;
		this.c_km = c_km;
		this.c_fuel = c_fuel;
		this.c_mission = c_mission;
		this.c_com = c_com;
		this.c_year = c_year;
		this.m_number = m_number;
	}

	//메소드
	public int getC_number() {
		return c_number;
	}


	public void setC_number(int c_number) {
		this.c_number = c_number;
	}


	public String getC_title() {
		return c_title;
	}


	public void setC_title(String c_title) {
		this.c_title = c_title;
	}


	public String getC_content() {
		return c_content;
	}


	public void setC_content(String c_content) {
		this.c_content = c_content;
	}


	public String getC_date() {
		return c_date;
	}


	public void setC_date(String c_date) {
		this.c_date = c_date;
	}


	public String getC_img() {
		return c_img;
	}


	public void setC_img(String c_img) {
		this.c_img = c_img;
	}


	public int getC_category() {
		return c_category;
	}


	public void setC_category(int c_category) {
		this.c_category = c_category;
	}


	public int getC_price() {
		return c_price;
	}


	public void setC_price(int c_price) {
		this.c_price = c_price;
	}


	public String getC_cnumber() {
		return c_cnumber;
	}


	public void setC_cnumber(String c_cnumber) {
		this.c_cnumber = c_cnumber;
	}


	public int getC_view() {
		return c_view;
	}


	public void setC_view(int c_view) {
		this.c_view = c_view;
	}


	public int getC_condition() {
		return c_condition;
	}


	public void setC_condition(int c_condition) {
		this.c_condition = c_condition;
	}


	public int getC_km() {
		return c_km;
	}


	public void setC_km(int c_km) {
		this.c_km = c_km;
	}


	public int getC_fuel() {
		return c_fuel;
	}


	public void setC_fuel(int c_fuel) {
		this.c_fuel = c_fuel;
	}


	public int getC_mission() {
		return c_mission;
	}


	public void setC_mission(int c_mission) {
		this.c_mission = c_mission;
	}


	public String getC_com() {
		return c_com;
	}


	public void setC_com(String c_com) {
		this.c_com = c_com;
	}


	public String getC_year() {
		return c_year;
	}


	public void setC_year(String c_year) {
		this.c_year = c_year;
	}


	public int getM_number() {
		return m_number;
	}


	public void setM_number(int m_number) {
		this.m_number = m_number;
	}


	
	
	
	
}
