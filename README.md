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

#테이블 - reply<br/>
r_number int pk,　　　　　　　　#댓글번호<br/>
m_number int,　　　　　　　　　　#회원번호<br/>
b_number int,　　　　　　　　　　#게시글번호<br/>
r_content varchar(500),　　　　　#내용<br/>
r_date datetime default now()　　#날짜<br/>

#테이블 - letter<br/>
l_number int pk,　　　　　　　　　#쪽지번호<br/>
m_number int,　　　　　　　　　　　#회원번호(보내는)<br/>
m_id varchar(20),　　　　　　　　#회원아이디(받는)<br/>
l_content varchar(1000),　　　　#내용<br/>
l_date datetime default now(),　#날짜<br/>
c_number int　　　　　　　　　　　#매물번호<br/>

#테이블 - car<br/>
c_number int pk,　　　　　　　　#매물번호<br/>
c_title varchar(20),　　　　　　#제목<br/>
c_content varchar(1000),　　　　#내용<br/>
c_date datetime default now(),　#날짜<br/>
c_img varchar(1000),　　　　　　#이미지경로<br/>
c_category int not null,　　　　#카테고리<br/>
c_price int,　　　　　　　　　　　#가격<br/>
c_cnumver varchar(10),　　　　　#차량번호<br/>
c_view int,　　　　　　　　　　　#조회수<br/>
c_condition int,　　　　　　　　# 사고유무 <br/>
c_km int,　　　　　　　　　　　　#주행거리<br/>
c_fuel int,　　　　　　　　　　　#연료타입<br/>
c_mission int,　　　　　　　　　　#변속기<br/>
c_com varchar(20)　　　　　　　　#제조사<br/>