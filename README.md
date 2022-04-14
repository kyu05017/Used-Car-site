# Team3_04-13

#주제 중고차매물사이트

#테이블 - Member
m_number int pk #회원번호
m_id varchar(20), #id
m_pw varchar(20) not null, # 비밀번호
m_name varchar(10), #이름
m_email varchar(40), #이메일
m_date datetime default now(), #가입날짜
m_phone varchar(20), # 전화번호
m_address varchar(100), #주소
m_today varchar(20), #로그인날짜
m_gr int #회원등급
