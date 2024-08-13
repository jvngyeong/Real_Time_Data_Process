--문제 1) 회원 테이블을 만드시오. 각 컬럼에 제약 조건을 부여 하시오. 
--제약 조건은 alter문을 이용할것 , 열레벨과 테이블 레벨 둘다 실습해 보세요.
--Table MEMBER
--================================
--user_num          not null          VARCHAR2(20)  
--USER_ID     	NOT NULL 	VARCHAR2(20)  
--USER_PW     	NOT NULL 	VARCHAR2(200) 
--USER_NAME   	NOT NULL 	VARCHAR2(40)  
--USER_BIRTH  	NOT NULL 	TIMESTAMP 
--USER_GENDER 	NOT NULL 	VARCHAR2(1)   
--USER_ADDR   	NOT NULL 	VARCHAR2(200) 
--USER_PH1    	NOT NULL 	VARCHAR2(13)  
--USER_PH2             		VARCHAR2(13)  
--USER_REGIST          		TIMESTAMP  
--USER_EMAIL           		VARCHAR2(200) 
--JOIN_OK              			VARCHAR2(500)
--
--회원 제약조건
--user_num     : primary key (MEMBER_USER_ID_PK)
--USER_EMAIL : unique (member_USER_EMAIL_UU)
--USER_ID : unique (member_USER_ID_UU)
--USER_REGIST  : 디펄트 값은 sysdate
--USER_GENDER : M/F만 들어가야한다.
--USER_PH1  : 11에서 13자리만 들어가야 한다.

create table member(
    user_num varchar2(20),
    user_id varchar2(20),
    user_pw varchar2(200),
    user_name varchar2(40),
    user_birth timestamp,
    user_gender char(1),
    user_addr varchar2(200),
    user_ph1 varchar2(13),
    user_ph2 varchar2(13),
    user_regist timestamp default sysdate,
    user_email varchar2(200),
    join_ok varchar2(500)
);

alter table member
add(constraint MEMBER_USER_NUM_PK primary key(user_num)
);
alter table member
add (constraint member_GENDER_CK check(user_gender in ('F', 'M')),
    constraint member_PH1_CK check(length(user_ph1) >= 11 and length(user_ph1) <= 13));
alter table member
add(constraint member_USER_EMAIL_UU unique(user_email),
    constraint member_USER_ID_UU unique(user_id));

alter table member
modify(user_num not null, 
       user_id not null, 
       user_pw not null, 
       user_name not null, 
       user_birth not null,
       user_gender not null,
       user_addr not null,
       user_ph1 not null
       );
--문제2) 게시판 테이블을 만들고 각 컬럼에 제약조건을 부여 하시오.
--제약 조건은 alter문을 이용할것 , 열레벨과 테이블 레벨 둘다 실습해 보세요.
--Table BOARD
--====================================
--BOARD_NUM     	NOT NULL 	NUMBER         
--USER_num       	NOT NULL 	VARCHAR2(20)   
--BOARD_NAME    	NOT NULL 	VARCHAR2(20)    --- 글 쓴이 
--BOARD_PASS    	NOT NULL 	VARCHAR2(200)  
--BOARD_SUBJECT 	NOT NULL 	VARCHAR2(100)  -- 제목
--BOARD_CONTENT          		VARCHAR2(2000) -- 내용
--BOARD_DATE             		TIMESTAMP   
--IP_ADDR                		VARCHAR2(15)   
--READ_COUNT             		NUMBER      
--
--게시판 제약조건 
--BOARD_NUM : primary key (BOARD_BOARD_NUM_PK)
--READ_COUNT ; 디펄트 값은 0
--USER_num : FOREIGN KEY (BOARD_USER_ID_FK)
drop table board;
create table board(
    board_num number,
    USER_num VARCHAR2(20), 
    board_name varchar2(20),
    board_pass varchar2(200),
    board_subject varchar2(100),
    board_content varchar2(2000),
    board_date timestamp,
    ip_addr varchar2(15),
    read_count number
);
alter table board
modify(
    read_count default 0
) ;

alter table board
add(
    constraint board_board_num_pk primary key(board_num)
);

alter table board
modify(constraint board_user_num_fk foreign key(user_num) references member(user_num) on delete set null);

drop 

alter table board
modify(
    board_num not null,
    USER_num NOT NULL, 
    board_name not null,
    board_pass not null,
    board_subject not null
);

--문제 3) 회원테이블에 아래 내용을 포함하여 5개의 데이터를 넣으시오.
--회원번호는 mem_100001부터 부여된다.
insert into member (USER_num, user_id,USER_PW,USER_NAME,USER_BIRTH,USER_GENDER,USER_ADDR ,USER_PH1,USER_PH2,USER_REGIST,USER_EMAIL)
values((select concat('mem_', nvl(max(substr(user_num, instr(user_num, '_') + 1)), 100000) + 1) from member), 'highland8','111111','이숭무','1999-12-12','F','서울','010-1234-1234',null,default,null);

--문제4)게시판 테이블에 데이터를 아래 내용 포함 6개 이상을 넣는데 위 회원들은 최소 한개 이상 게시글이 등록되게 하시오.
--BOARD_NUM은 입력하지 않고 자동부여가 되게 작성하시오. 
select nvl(max(board_num), 0) + 1 from board;
insert into board(BOARD_NUM,USER_num,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values((select nvl(max(board_num), 0) + 1 from board), 'mem_100001', '상장범 아빠', '1111','제목', '내용', '192.168.3.117');

insert into board(BOARD_NUM,USER_num,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values((select nvl(max(board_num), 0) + 1 from board), 'mem_100002', '상장범 아빠', '1111','제목', '내용', '192.168.3.117');

insert into board(BOARD_NUM,USER_num,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values((select nvl(max(board_num), 0) + 1 from board), 'mem_100003', '상장범 아빠', '1111','제목', '내용', '192.168.3.117');

insert into board(BOARD_NUM,USER_num,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values((select nvl(max(board_num), 0) + 1 from board), 'mem_100004', '상장범 아빠', '1111','제목', '내용', '192.168.3.117');

insert into board(BOARD_NUM,USER_num,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values((select nvl(max(board_num), 0) + 1 from board), 'mem_100005', '상장범 아빠', '1111','제목', '내용', '192.168.3.117');

desc board;

--문제5) highland0회원의 회원아이디, 회원명, 이메일, 게시글 번호, 게시글 제목, READ_COUNT를 출력하시오.
select m.user_id, user_name, user_email, board_num, board_name, read_count
from member m join board b
on m.user_id = b.user_id where m.user_id = 'highland0';


--문제6) 게시글을 읽으면 READ_COUNT가 1씩 증가 할 것이다. 
--         update문을 실행 할 때마다 READ_COUNT 1증가 할수 있게 update문을 작성하시오.
--         1번 게시글을 증가 시키시오.
update board
set read_count = read_count + 1
where board_num = 1;

--문제 7) 게시글 2번에 해당하는 회원을 출력하시오.
select m.user_id, user_pw, user_name, user_birth from member m join board b
on m.user_id = b.user_id
where board_num = 2;

--문제 8) 등록된 게시글의 개수를 출력하시오.
select count(*) from board;

--문제 9) 각 회원의 게시글의 갯수를 출력하시오. (조인 아님)
select user_id, count(*)
from board
group by user_id;

--문제 10) 회원의 수를 출력하시오.
select count(*) from member;
-- 문제 11) 아이디가 'highland0'인 회원의 전화번호를 '02-9876-1234', 
-- 이메일을 'highland0@nate.com', 비밀번호를 '22222'로 변경하시오.
update member
set user_ph1 = '02-9876-1234', user_email = 'highland0@nate.com', user_pw = '222222'
where user_id = 'highland0';

--문제 12) 게시글 1번의 제목을 '나는 열심히 공부할래', 내용을 '열심히 공부해서 \n 빨리 취업이 될 수 있게 노력해야지'로  수정하시오.
update board
set board_subject = '나는 열심히 공부할래', board_content = '열심히 공부해서 \n 빨리 취업이 될 수 있게 노력해야지'
where board_num = 1;

-- 문제 13) 1번 게시글을 출력할 때 내용의 \n을 <br /> 로 출력되게 하시오.
select replace(board_content, '\n', '<br \>') from board
where board_num = 1;

-- 문제 14)  게시글 제목이 너무 길어서 화면에 다 출력되기 어렵다 . 
-- 제목을 첫번째 글자 부터 5글자를 출력하고 뒤에는 *를 5개가 출력되게 하시오.
select rpad(substr(board_subject, 1, 5), 10, '*') from board;

--문제 15) '이숭무'회원이 아이디를 잊어버렸다고 한다. 
--이메일과 전화번호를 이용해서 아이디를 출력하는 데 아이디는 모두 출력해서는 안되고 
--첫글자부터 세글자 나머지는 '*'로 출력되게 하시오.
select rpad(substr(user_id, 1, 3), length(user_id), '*') from member
where user_name = '이숭무' and user_email = 'highland0@nate.com' and user_ph1 = '02-9876-1234';

--문제 16) 게시판 테이블에서 게시글을 많이 쓴 게시글의 user_id를 게시글 갯수와 같이 출력하시오.
select rownum, user_id, count(user_id)
from board
group by user_id
having count(user_id) = (select max(count(user_id)) from board group by user_id);

-- 문제 17) 지금까지의 작업을 모두 정상 종료 시키시오.
commit;
-- 문제 18) '이숭무'회원이 탈퇴하려고 한다. 이숭무 회원이 탈퇴 할수 있게 삭제하시오.
delete from member
where user_name = '이숭무';

--문제 19) '이숭무' 회원이 탈퇴하는 것이 아니었는 데 잘 못 삭제를 하였다 .
--정상적으로 '이숭무'회원에 대한 모든 내용이(게시판 포함) 존재 할 수 있게 하시오.
rollback;

--문제 20) ‘highland0’인 회원이 로그인을 하여 자신이 쓴 글인 1번 게시글을 삭제하려고 한다.
--해당 게시물이 삭제 되게 하시오.
delete from board
where user_id = 'highland0' and board_num = 1;