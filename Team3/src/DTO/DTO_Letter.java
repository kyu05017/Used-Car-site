package DTO;

public class DTO_Letter {
	
	private int l_number;
	private int m_number;
	private String m_id; 
	private String l_content;
	private String l_date;
	private int C_number;
	
	public DTO_Letter() {}

	public DTO_Letter(int l_number, int m_number, String m_id, String l_content, String l_date, int c_number) {
		this.l_number = l_number;
		this.m_number = m_number;
		this.m_id = m_id;
		this.l_content = l_content;
		this.l_date = l_date;
		C_number = c_number;
	}


	public int getL_number() {
		return l_number;
	}

	public void setL_number(int l_number) {
		this.l_number = l_number;
	}

	public int getM_number() {
		return m_number;
	}

	public void setM_number(int m_number) {
		this.m_number = m_number;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getL_content() {
		return l_content;
	}

	public void setL_content(String l_content) {
		this.l_content = l_content;
	}

	public String getL_date() {
		return l_date;
	}

	public void setL_date(String l_date) {
		this.l_date = l_date;
	}

	public int getC_number() {
		return C_number;
	}

	public void setC_number(int c_number) {
		C_number = c_number;
	}
}