use hrdb2019;
select database();
desc member;
select * from member;

select	member_id
		, name
		, email
		, create_at
from	member
where	name = '홍길동';

-- score member 테이블 생성
create table score_member(
	mid				char(5)			primary key			 -- 'M0001'형식의 트리거 적용
    , name			varchar(10)		not null
    , department	varchar(20)
    , kor			decimal(6, 2)	default 0.0
    , eng			decimal(6, 2)	default 0.0
    , math			decimal(6, 2) 	default 0.0
    , mdate			datetime
);

show tables;
desc score_member;

-- 트리거 생성
/*******************************************************************/
delimiter $$
create trigger trg_scroe_member_mid
before insert on score_member -- 테이블명
for each row
begin
declare max_code int;	-- 'M0001'

-- 현재 저장된 값 중 가장 큰 값을 가져옴
select	ifnull(max(cast(right(mid, 4) as unsigned)), 0)
into max_code
from score_member;

-- 'M0001' 형식으로 아이디 생성, lpad(값, 크기, 채워지는 문자형식) : M0001
set new.mid = concat('M', lpad((max_code + 1), 4, '0'));

end $$
delimiter ;
/*******************************************************************/
select * from information_schema.triggers;

select * from score_member;

select count(*) from score_member;
select row_number() over() as rno, mid, name, department, kor, eng, math, mdate
from score_member;


