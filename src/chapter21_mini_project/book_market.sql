use hrdb2019;
select database();
show tables;

/************************************************************************
	book_market_books : 도서 테이블
    book_market_cart : 장바구니 테이블
    book_market_member : 회원 테이블
    
    ** cart 테이블 생성 시 어떤 회원이 어떤 도서를 장바구니에 추가했는지 fk로 정의
************************************************************************/
-- 도서 테이블 생성 및 데이터 입력
create table book_market_books(
	bid			char(4)			primary key
    , title		varchar(50)		not null
    , author	varchar(10)
    , price		int
    , isbn		int
    , bdate		datetime
);
desc book_market_books;

select * from information_schema.triggers;
/*******************************************************************/
delimiter $$
create trigger trg_book_market_books_bid
before insert on book_market_books -- 테이블명
for each row
begin
declare max_code int;	-- 'B001'

-- 현재 저장된 값 중 가장 큰 값을 가져옴
select	ifnull(max(cast(right(bid, 3) as unsigned)), 0)
into max_code
from book_market_books;

-- 'B001' 형식으로 아이디 생성, lpad(값, 크기, 채워지는 문자형식) : B001
set new.bid = concat('B', lpad((max_code + 1), 3, '0'));

end $$
delimiter ;
/*******************************************************************/
select LPAD(FLOOR(RAND() * 10000), 4, '0') as isbn from dual;
set sql_safe_updates = 0;
delete from book_market_books;
drop trigger trg_book_market_books_bid;

insert into book_market_books(title, author, price, isbn, bdate)
	values('REACT', '양만춘', 3000, lpad(floor(rand() * 10000), 4, '0'), now());
insert into book_market_books(title, author, price, isbn, bdate)
	values('JAVA', '홍길동', 1000, lpad(floor(rand() * 10000), 4, '0'), now());
insert into book_market_books(title, author, price, isbn, bdate)
	values('HTML', '이순신', 2000, lpad(floor(rand() * 10000), 4, '0'), now());
insert into book_market_books(title, author, price, isbn, bdate)
	values('CSS', '김유신', 500, lpad(floor(rand() * 10000), 4, '0'), now());
insert into book_market_books(title, author, price, isbn, bdate)
	values('JS', '강감찬', 1500, lpad(floor(rand() * 10000), 4, '0'), now());
    
select * from book_market_books;

-- 회원 테이블 생성
create table book_market_member(
	mid			char(4)			primary key
    , name		varchar(10)		not null
	, address	varchar(50)
    , phone		char(13)
    , mdate		datetime
);
desc book_market_member;

/*******************************************************************/
delimiter $$
create trigger trg_book_market_member_mid
before insert on book_market_member -- 테이블명
for each row
begin
declare max_code int;	-- 'M001'

-- 현재 저장된 값 중 가장 큰 값을 가져옴
select	ifnull(max(cast(right(mid, 3) as unsigned)), 0)
into max_code
from book_market_member;

-- 'M001' 형식으로 아이디 생성, lpad(값, 크기, 채워지는 문자형식) : M001
set new.mid = concat('M', lpad((max_code + 1), 3, '0'));

end $$
delimiter ;
/*******************************************************************/

-- 장바구니 테이블 생성
create table book_market_cart(
	cid				char(4)		primary key
    , qty			int			not null
    , bid			char(4)
	, mid			char(4)
    , cdate			datetime
    , constraint 	fk_book_market_books	foreign key(bid)
			references book_market_books(bid)
				on delete cascade
                on update cascade
	, constraint 	fk_book_market_member	foreign key(mid)
			references book_market_member(mid)
				on delete cascade
                on update cascade
		
);
desc book_market_cart;

/*******************************************************************/
delimiter $$
create trigger trg_book_market_member_cid
before insert on book_market_cart -- 테이블명
for each row
begin
declare max_code int;	-- 'C001'

-- 현재 저장된 값 중 가장 큰 값을 가져옴
select	ifnull(max(cast(right(cid, 3) as unsigned)), 0)
into max_code
from book_market_cart;

-- 'C001' 형식으로 아이디 생성, lpad(값, 크기, 채워지는 문자형식) : C001
set new.cid = concat('C', lpad((max_code + 1), 3, '0'));

end $$
delimiter ;
/*******************************************************************/
select bid from book_market_books
				order by bdate desc
				limit 1;