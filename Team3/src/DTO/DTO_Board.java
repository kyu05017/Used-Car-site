package DTO;

public class DTO_Board {
	
	private int b_number;
	private String b_title;
	private String b_content; 
	private String b_date;
	private int m_number;
	private int b_gr;
	private int b_view;
	
	public DTO_Board() {}

	public DTO_Board(int b_number, String b_title, String b_content, String b_date, int m_number, int b_gr,
			int b_view) {
		this.b_number = b_number;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_date = b_date;
		this.m_number = m_number;
		this.b_gr = b_gr;
		this.b_view = b_view;
	}

	public int getB_number() {
		return b_number;
	}

	public void setB_number(int b_number) {
		this.b_number = b_number;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	public int getM_number() {
		return m_number;
	}

	public void setM_number(int m_number) {
		this.m_number = m_number;
	}

	public int getB_gr() {
		return b_gr;
	}

	public void setB_gr(int b_gr) {
		this.b_gr = b_gr;
	}

	public int getB_view() {
		return b_view;
	}

	public void setB_view(int b_view) {
		this.b_view = b_view;
	}
	
	
}
