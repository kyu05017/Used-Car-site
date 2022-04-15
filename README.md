# 자바fx 프로젝트 3조

***
주제
---

중고차 매매 사이트


***
프로젝트 개요/목적
---
개요 : 중고차 구매 및 판매를 원하는 사람들에게 서비스를 제공한다.

목적 : 판매 목적을 지닌 딜러가 자신의 차량을 등록하고 판매할 수 있게 하고, 구매 목적을 지닌 방문자가 원하는 종류의 차종을 선택하여 딜러와 컨택하여 구매할 수 있게 한다.


#3.개발 일정[일 단위(+시간단위)]
| 일차 | 현황 | 내용 |
| ------ | --------- | ----------------------- |
| 1일차 | :ballot_box_with_check: | 주제선정 |
| 2일차 | :ballot_box_with_check: | DB 필드 구성 선정 |
| 3일차 | :ballot_box_with_check: | 회원 시스템 |
| 4일차 |  | 운영자 시스템 / 딜러 시스템 |
| 5일차 |  | 게시판, 공지사항, 상담관련 시스템 |
| 6일차 |  | 차량 등록 및 상담 시스템 |
| 7일차 |  | 차량 등록 및 상담 시스템 |
| 8일차 |  | 차량 등록 및 상담 시스템 |
| 9일차 |  | 기능 정검 및 디자인 |
| 10일차|  | 기능 점검 및 디자인 | 

#4.역할
| ------ | ------------------------------------- |
| 윤선기 | 아이디찾기,비밀번호찾기, |
| 김규석 | DTO,DAO 컨트롤러, |
| 윤지윤 | 메인홈, |
| 유희진 | 로그인, |
#5.개발 우선순위

#6. DB설계
#테이블 - member<br/>
m_number　　int (pk)　　　　　　　　　　#회원번호<br/>
m_id　　　　varchar(20),　　　　　　　#id<br/>
m_pw　　　　varchar(20) not null,　　#비밀번호<br/>
m_name　　　varchar(10),　　　　　　　#이름<br/>
m_email　　　varchar(40),　　　　　　　#이메일<br/>
m_date　　　datetime default now(), #가입날짜<br/>
m_phone　　　varchar(20),　　　　　　　#전화번호<br/>
m_address　　varchar(100),　　　　　　#주소<br/>
m_today　　　varchar(20),　　　　 　　#로그인날짜<br/>
m_gr　　　　　int　　　　　　　　　　　#회원등급<br/>

#테이블 - board<br/>
b_number　　　int (pk),　　　　　　　　　　　#게시물번호<br/>
b_title　　　　varchar(50),　　　　　　　　#제목<br/>
b_content　　　varchar(1000),　　　　　　　#내용<br/>
b_date　　　　datetime default now(),　　　#날짜<br/>
m_number　　　int (fk) not null,　　　　　　#회원번호<br/>
b_gr　　　　　int,　　　　　　　　　　　　#글등급<br/>
b_view　　　　int　　　　　　　　　　　　#조회수<br/>

#테이블 - reply<br/>
r_number　　　int (pk),　　　　　　　　　　　#댓글번호<br/>
m_number　　　int (fk) not null,　　　　　　#회원번호<br/>
b_number　　　int (fk) not null,　　　　　　#게시글번호<br/>
r_content　　　varchar(500),　　　　　　　#내용<br/>
r_date　　　　datetime default now()　　　#날짜<br/>

#테이블 - letter<br/>
l_number　　　int (pk),　　　　　　　　　　　#쪽지번호<br/>
m_number　　　int (fk) not null,　　　　　　#회원번호(보내는)<br/>
m_id　　　　　varchar(20) not null,　　　　#회원(딜러)아이디(받는)<br/>
l_content　　varchar(1000),　　　　　　　#내용<br/>
l_date　　　　datetime default now(),　　#날짜<br/>
c_number　　　int　(fk) not null　　　　　　#매물번호<br/>

#테이블 - car<br/>
c_number　　　　int (pk),　　　　　　　　　　　　#매물번호<br/>
c_title　　　　　varchar(20),　　　　　　　　　#제목<br/>
c_content　　　　varchar(1000),　　　　　　　　#내용<br/>
c_date　　　　　　datetime default now(),　　　#날짜<br/>
c_img　　　　　　varchar(1000),　　　　　　　　#이미지경로<br/>
c_category　　　int not null,　　　　　　　　　#카테고리<br/>
c_price　　　　　int,　　　　　　　　　　　　　#가격<br/>
c_cnumber　　　　varchar(10),　　　　　　　　　#차량번호<br/>
c_view　　　　　　int,　　　　　　　　　　　　　#조회수<br/>
c_condition　　　int,　　　　　　　　　　　　　# 사고유무 <br/>
c_km　　　　　　　int,　　　　　　　　　　　　　#주행거리<br/>
c_fuel　　　　　　int,　　　　　　　　　　　　　#연료타입<br/>
c_mission　　　　　int,　　　　　　　　　　　　#변속기<br/>
c_com　　　　　　　varchar(20),　　　　　　　　#제조사<br/>
c_year　　　　　　varchar(10) int,　　　　　　#연도<br/>
m_number　　　　　int not null,　　　　　　　　#회원번호<br/>

#7.컨트롤 구조도

#8.뷰[fxml] 프로토타입
