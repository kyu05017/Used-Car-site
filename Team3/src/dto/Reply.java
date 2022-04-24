package dto;

public class Reply {
	private int r_number;
	private int m_number; 
	private int b_number;
	private String r_content;
	private String r_date;
	private String m_id;
	
	
	public Reply() {}

	
	
	public Reply(int r_number, int m_number, int b_number, String r_content, String r_date, String m_id) {
		super();
		this.r_number = r_number;
		this.m_number = m_number;
		this.b_number = b_number;
		this.r_content = r_content;
		this.r_date = r_date;
		this.m_id = m_id;
	}


	public int getR_number() {
		return r_number;
	}

	public void setR_number(int r_number) {
		this.r_number = r_number;
	}

	public int getM_number() {
		return m_number;
	}

	public void setM_number(int m_number) {
		this.m_number = m_number;
	}

	public int getB_number() {
		return b_number;
	}

	public void setB_number(int b_number) {
		this.b_number = b_number;
	}

	public String getR_content() {
		return r_content;
	}

	public void setR_content(String r_content) {
		this.r_content = r_content;
	}

	public String getR_date() {
		return r_date;
	}

	public void setR_date(String r_date) {
		this.r_date = r_date;
	}



	public String getM_id() {
		return m_id;
	}



	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
	
	
}
