select * from board;
insert into board(BOARD_NUM, USER_ID, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT, BOARD_DATE, READ_COUNT)
values(2, 'high', '이상범', '제목1', '내용1', sysdate, 0);

desc board;

-- 마지막 글 번호를 출력하시오.
select max(board_num) from board;
-- 마지막 글 다음 번호를 출력
select max(board_num) + 1 from board;

insert into board(BOARD_NUM, USER_ID, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT, BOARD_DATE, READ_COUNT)
values((select max(board_num) + 1 from board), 'high', '이상범', '제목1', '내용1', sysdate, 0);

insert into board(BOARD_NUM, USER_ID, BOARD_NAME, BOARD_SUBJECT, BOARD_CONTENT, BOARD_DATE, READ_COUNT)
values(12, 'high', '이상범', '제목1', '내용1', sysdate, 0);

select * from board;

desc board;

drop table board;

create table board(
    BOARD_NUM        NUMBER not null primary key,
    USER_ID          VARCHAR2(20), 
    BOARD_NAME       VARCHAR2(20) not null, 
    BOARD_SUBJECT    VARCHAR2(50) not null,
    BOARD_CONTENT    VARCHAR2(500),
    BOARD_DATE       DATE default sysdate,        
    READ_COUNT       NUMBER default 0
);

insert into board(board_num, board_name, board_subject)
values(1, '이숭무', '주제1');
select * from board;
drop table board;

create table board(
    BOARD_NUM        NUMBER constraint BOARD_NUM_PK primary key,
    USER_ID          VARCHAR2(20), 
    BOARD_NAME       VARCHAR2(20) not null, 
    BOARD_SUBJECT    VARCHAR2(50) not null,
    BOARD_CONTENT    VARCHAR2(500),
    BOARD_DATE       DATE default sysdate,        
    READ_COUNT       NUMBER default 0
);
select * from board;
select * from dba_constraints where table_name = 'BOARD';
select * from dba_cons_columns where table_name = 'board';

insert into board(board_num, board_name, board_subject)
values(1, '이숭무', '주제1');

create table board(
    BOARD_NUM        NUMBER, -- 열 레벨
    USER_ID          VARCHAR2(20), 
    BOARD_NAME       VARCHAR2(20) not null, 
    BOARD_SUBJECT    VARCHAR2(50) not null,
    BOARD_CONTENT    VARCHAR2(500),
    BOARD_DATE       DATE default sysdate,        
    READ_COUNT       NUMBER default 0,
    member_num       NUMBER null,
    constraint BOARD_NUM_PK primary key(board_num),
    constraint MEMBER_NUM_FK foreign key(member_num) references member(member_num)
);

create table member(
    member_num NUMBER,
    member_name VARCHAR2(100),
    member_id VARCHAR2(50),
    member_email varchar2(100),
    member_phone varchar2(50),
    CONSTRAINT member_num_pk PRIMARY KEY(member_num)
);
drop table member;
drop table board;
select * from board;

insert into board(board_num, board_name, board_subject, member_num)
values(1, '이숭무', '제목1', 100);

insert into member(member_num, member_name, member_id, member_email, member_phone)
values(100, '이숭무', 'highland0', 'highland0@nate.com', '010-1234-1234');

select * from member;
select * from board;

select member_name, member_email,
       board_subject, board_date
from member m join board b
on m.member_num = b.member_num;

select first_name, last_name, salary, hire_date,
       d.department_id, department_name
from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id;

---------------------------------------------------------
-- jobs --- job_id : primary key
-- employees : job_id : foreign key,
--             department_id : foreign key
-- departments : department_id : primary key
desc member;
select e.manager_id, d.manager_id from hr.employees e join hr.departments d
on e.department_id = d.department_id;

create table board(
    BOARD_NUM        NUMBER,
    USER_ID          VARCHAR2(20), 
    BOARD_NAME       VARCHAR2(20) not null, 
    BOARD_SUBJECT    VARCHAR2(50) not null,
    BOARD_CONTENT    VARCHAR2(500),
    BOARD_DATE       DATE default sysdate,        
    READ_COUNT       NUMBER default 0,
    member_num       NUMBER CONSTRAINT member_num_FK REFERENCES MEMBER(MEMBER_NUM),
    constraint BOARD_NUM_PK primary key(board_num)
);
create table member(
    member_num NUMBER,
    member_name VARCHAR2(100),
    member_id VARCHAR2(50) constraint member_id_UK UNIQUE,
    member_email varchar2(100),
    member_phone varchar2(50),
    CONSTRAINT member_num_pk PRIMARY KEY(member_num)
);
drop table board;
drop table member;

insert into member
values(1, '이숭무', 'aaaa0', 'email0', '010-0101-0101');
select * from member;
insert into member
values(2, '이숭무', null, 'email1', '010-0101-0102');
insert into member
values(3, '이숭무', null, 'email2', '010-0101-0103');

create table member(
    member_num NUMBER,
    member_name VARCHAR2(100),
    member_id VARCHAR2(50) constraint member_id_UK UNIQUE,
    member_email varchar2(100) constraint member_email_UK UNIQUE,
    member_phone varchar2(50) constraint member_phone_UK UNIQUE,
    CONSTRAINT member_num_pk PRIMARY KEY(member_num)
);

create table member(
    member_num NUMBER,
    member_name VARCHAR2(100),
    member_id VARCHAR2(50),
    member_email varchar2(100),
    member_phone varchar2(50),
    CONSTRAINT member_num_pk PRIMARY KEY(member_num),
    constraint member_id_UK UNIQUE(member_id),
    constraint member_id_UK UNIQUE(member_email),
    constraint member_id_UK UNIQUE(member_phone)
);