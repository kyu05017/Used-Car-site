package dto;

public class dtoReply {
	//필드
	private int r_number; //댓글번호
	private int m_number; //회원번호
	private int b_number; //게시글번호
	private String r_content; //내용
	private String r_date; //날짜
	//생성자
	public dtoReply() {
		// TODO Auto-generated constructor stub
	}

	public dtoReply(int r_number, int m_number, int b_number, String r_content, String r_date) {
		super();
		this.r_number = r_number;
		this.m_number = m_number;
		this.b_number = b_number;
		this.r_content = r_content;
		this.r_date = r_date;
	}
	//메소드
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
	
	
}
