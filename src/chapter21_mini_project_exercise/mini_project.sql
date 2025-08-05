use hrdb2019;
select database();
show tables;
select * from customer;
drop table book_market_member;

/***************************************
	book_market_books : 도서 테이블
    book_market_cart : 장바구니 테이블
    book_market_member : 회원 테이블
***************************************/

create table book_market_books(
	isbn		char(8)			primary key		not null
    , title 	varchar(50)		not null
    , author	varchar(20)		not null
    , price		int				not null
    , info		varchar(100)
    , category	varchar(50)
    , bdate		datetime		not  null
);
desc book_market_books;

create table book_market_cart(
	isbn			char(8)			not null
    , mid			varchar(30)		not null
    , title			varchar(50)		not null
    , author		varchar(20)		not null
    , price			int				not null
    , quantity		int				not null
    , total_due		int				not null
    , constraint	fk_isbn			foreign key(isbn)
				references book_market_books(isbn)
	, constraint 	fk_mid			foreign key(mid)
				references book_market_member(mid)
);
desc book_market_cart;

desc customer;
create table book_market_member(
	mid					varchar(30)		primary key		not null
    , mname				varchar(20) 	not null
    , phone				char(13)		not null
    , email				varchar(50)		not null
    , address			varchar(150)	
    , register_date		date			not null

);
desc book_market_member;

-- isbn 트리거 생성
/*******************************************************************/
delimiter $$
create trigger trg_book_market_books
before insert on book_market_books -- 테이블명
for each row
begin
declare max_code int;	-- 'E0001'

-- 현재 저장된 값 중 가장 큰 값을 가져옴
select	ifnull(max(cast(right(isbn, 4) as unsigned)), 0)
into max_code
from book_market_books;

-- 'E0001' 형식으로 아이디 생성, lpad(값, 크기, 채워지는 문자형식) : E0001
set new.isbn = concat('ISBN', lpad((max_code + 1), 4, '0'));

end $$
delimiter ;
/*******************************************************************/
select * from information_schema.triggers;
insert into book_market_books(title, author, price, info, category, bdate)
	values('자바의정석', '남궁성', 20000, '자바의 정석입니다', 'IT전문서', now());
insert into book_market_books(title, author, price, info, category, bdate)
	values('쉽게 배우는 JSP 웹 프로그래밍', '송미영', 27000, '단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍', 'IT전문서', now());
insert into book_market_books(title, author, price, info, category, bdate)
	values('안드로이드 프로그래밍', '우재남', 33000, '실습 단계별 명쾌한 멘토링!', 'IT전문서', now());

insert into book_market_member(mid, mname, phone, email, address, register_date)
	values('hong', '홍길동', '010-1234-5678', 'hong@mail.com', '서울 영등포구', curdate());
insert into book_market_member(mid, mname, phone, email, address, register_date)
	values('kim', '김유신', '010-9876-5678', 'shin@mail.com', '서울 강남구', curdate());
insert into book_market_member(mid, mname, phone, email, address, register_date)
	values('sun', '김민선', '010-7777-7777', 'sunny@mail.com', '대구 수성구', curdate());

select * from book_market_member;
select * from book_market_books;

drop trigger trg_book_market_books;

set sql_safe_updates = 0;
delete from book_market_books
	where author = '남궁성';
drop table book_market_member;