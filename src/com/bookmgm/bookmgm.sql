use hrdb2019;
select database();

-- 테이블 3개 생성, book_tj, book_yes24, book_aladin
-- bid : pk('B001', 트리거 생성), title, author, price, isbn(랜덤 정수 4자리 생성), bdate
create table book_tj(
	bid			char(4)			primary key
    , title		varchar(50)		not null
    , author	varchar(20)		not null
    , price		int				not null
    , isbn		int				unique
	, bdate		datetime
    
);
desc book_tj;

create table book_yes24(
	bid			char(4)			primary key
    , title		varchar(50)		not null
    , author	varchar(20)		not null
    , price		int				not null
    , isbn		int				unique
	, bdate		datetime
);
desc book_yes24;

create table book_aladin(
	bid			char(4)			primary key
    , title		varchar(50)		not null
    , author	varchar(20)		not null
    , price		int				not null
    , isbn		int				unique
	, bdate		datetime
);
desc book_aladin;

-- bid 트리거
/*******************************************************************/
delimiter $$
create trigger trg_book_tj_bid
before insert on book_tj -- 테이블명
for each row
begin
declare max_code int;	-- 'B001'

-- 현재 저장된 값 중 가장 큰 값을 가져옴
select	ifnull(max(cast(right(bid, 3) as unsigned)), 0)
into max_code
from book_tj;

-- 'B001' 형식으로 아이디 생성, lpad(값, 크기, 채워지는 문자형식) : B001
set new.bid = concat('B', lpad((max_code + 1), 3, '0'));

end $$
delimiter ;
/*******************************************************************/

/*******************************************************************/
delimiter $$
create trigger trg_book_yes24_bid
before insert on book_yes24 -- 테이블명
for each row
begin
declare max_code int;	-- 'B001'

-- 현재 저장된 값 중 가장 큰 값을 가져옴
select	ifnull(max(cast(right(bid, 3) as unsigned)), 0)
into max_code
from book_yes24;

-- 'B001' 형식으로 아이디 생성, lpad(값, 크기, 채워지는 문자형식) : B001
set new.bid = concat('B', lpad((max_code + 1), 3, '0'));

end $$
delimiter ;
/*******************************************************************/

/*******************************************************************/
delimiter $$
create trigger trg_book_aladin_bid
before insert on book_aladin -- 테이블명
for each row
begin
declare max_code int;	-- 'B001'

-- 현재 저장된 값 중 가장 큰 값을 가져옴
select	ifnull(max(cast(right(bid, 3) as unsigned)), 0)
into max_code
from book_aladin;

-- 'B001' 형식으로 아이디 생성, lpad(값, 크기, 채워지는 문자형식) : B001
set new.bid = concat('B', lpad((max_code + 1), 3, '0'));

end $$
delimiter ;
/*******************************************************************/

select * from information_schema.triggers;
select * from book_tj;
select * from book_aladin;
show tables;
drop trigger trg_book_yes24_bid;

-- Connection 확인
show status like 'Threads_connected';	-- 접속 커넥션 수
show processlist;						-- 활성중인 커넥션
show variables like 'max_connections';	-- 최대 접속 가능 커넥션 수

select count(*) as count from book_tj;