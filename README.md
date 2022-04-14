# Team3_04-13

#주제 중고차매물사이트

#테이블 - member<br/>
m_number int pk　　　　　　　#회원번호<br/>
m_id varchar(20),　　　　　　#id<br/>
m_pw varchar(20) not null,　# 비밀번호<br/>
m_name varchar(10),　　　　　#이름<br/>
m_email varchar(40),　　　　#이메일<br/>
m_date datetime default now(), #가입날짜<br/>
m_phone varchar(20),　　　　　# 전화번호<br/>
m_address varchar(100),　　　　#주소<br/>
m_today varchar(20),　　　　 #로그인날짜<br/>
m_gr int　　　　　　　　　　　 #회원등급<br/>

#테이블 - board<br/>
b_number int pk,　　　　　　　　　#게시물번호<br/>
b_title varchar(50),　　　　　　　#제목<br/>
b_content varchar(1000),　　　　　#내용<br/>
b_date datetime default now(),　　#날짜<br/>
m_number int,　　　　　　　　　　#회원번호<br/>
b_gr int,　　　　　　　　　　　　#글등급<br/>
b_view int　　　　　　　　　　　　#조회수<br/>
