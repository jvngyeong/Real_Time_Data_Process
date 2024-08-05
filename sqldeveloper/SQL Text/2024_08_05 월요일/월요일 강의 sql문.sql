create table member(
    member_num number,
    member_name varchar2(50),
    member_id varchar2(50),
    constraint member_num_PK primary key(member_num)
);

drop table member;
drop table board;

create table board(
    board_num number,
    board_writer varchar2(100),
    board_subject varchar2(100),
    board_content varchar2(2000),
    member_num number,
    constraint board_num_PK primary key(board_num),
    constraint member_num_FK foreign key(member_num) references member(member_num)
);

insert into member(member_num, member_name, member_id)
values(1, '����', 'high');

select * from member;

insert into board(board_num, board_writer, board_subject, board_content, member_num)
values(10, '�۾���', '����', '����', 1);

insert into board(board_num, board_writer, board_subject, board_content, member_num)
values(20, '�۾���', '����', '����', 1);

select * from board;
-- �θ� ������ ���� �ȵ�.
delete from member
where member_num = 1;

delete from board
where member_num = 1;

create table board(
    board_num number,
    board_writer varchar2(100),
    board_subject varchar2(100),
    board_content varchar2(2000),
    member_num number,
    constraint board_num_PK primary key(board_num),
    constraint member_num_FK foreign key(member_num)
    references member(member_num) on delete set null
);

select * from board;

-- not null, primary key, foreign key, unique
--- check constraint
drop table employees_1;
create table employees_1(
    employee_id number(6),
    first_name varchar2(50),
    last_name varchar2(20),
    email varchar2(50),
    salary number default 0,
    value1 number,
    value2 number,
    city varchar2(50),
    gender char(1),
    constraint employee_id_PK primary key(employee_id),
    constraint salary_CK check(salary>=0),
    constraint value1_value2_CK check(value2 > value1),
    constraint city_CK check(city in ('����', '��õ', '�λ�','�뱸','����')),
    constraint gender check (gender in ('F', 'M'))
);
select * from employees_1;
insert into employees_1(employee_id, first_name, last_name, email, salary)
values(1, '����', '��', 'high', 10);
insert into employees_1(employee_id, first_name, last_name, email, salary, value1, value2)
values(2, '����', '��', 'high', 10, 10, 11);
insert into employees_1(employee_id, first_name, last_name, email, salary, value1, value2, gender)
values(3, '����', '��', 'high', 10, 10, 11, 'M');
insert into employees_1(employee_id, first_name, last_name, email, salary, value1, value2, city, gender)
values(4, '����', '��', 'high', 10, 10, 11, '����', 'M');

drop table dept;

create table dept as select * from departments;  -- ���� 1�� ���

create table dept
(deptno, deptname, mngid, locid)                -- ���� 2�� ���(��Ī�� �ο��� / heading name ����)
as select * from departments;

select * from dept;

drop table departments;

desc hr.departments;

create table departments(
    department_id number(4) not null,
    department_name varchar2(30) not null,
    manager_id number(6)
);

insert into departments(department_id, department_name, manager_id)
values(100, '������', 200);

-- Alter Table
select * from departments;
-- �� �� �߰�
alter table departments
add (location_id number(4));

drop table departments;
desc departments;

create table departments(
    department_id number(4) not null,
    department_name varchar2(30) not null
);
alter table departments
add (location_id number(4),
     manager_id number(6));

-- ���� ���� ���� ����
desc departments;
select * from departments;
insert into departments
values(100, '������', 170, 1700);

alter table departments
modify (department_name number);    -- �����Ͱ� ������ ��, ������ ������ �ٲ� ���� ����.

alter table departments
modify (manager_id varchar2(50));   -- �����Ͱ� ������ ��, ������ ������ �ٲ� ���� ����.

alter table departments
modify (manager_id number(9, 3));   -- �������� ������ �ٲ��� �ʰ� ������.

alter table departments
modify (department_name varchar2(1000));    -- �������� ������ �ٲ��� �ʰ� ������.

truncate table departments;
drop table departments;

create table departments(
    department_id number(4),
    department_name varchar(100),
    manager_id number(6),
    location_id number(4)
);

alter table departments
modify (department_name number);        -- ���̺� �����Ͱ� �������� ���� ��, ������ ������ ���� ������!.

desc departments;

alter table departments
add(loc_id number(6) default 0);

insert into departments
values(100, 23, default, 1700, default);

select * from departments;

alter table departments
modify manager_id default 120;

desc departments;

alter table departments
rename column loc_id to location_id;

alter table departments
drop column location_id;

select * from departments;
select * from USER_constraints where table_name = 'DEPARTMENTS';
alter table departments
modify department_id constraint department_id_PK primary key;

alter table departments
rename constraint department_id_PK to dept_id_PK;
alter table departments
rename column department_id to dept_id;
desc departments;
truncate table departments;

alter table departments
add constraint dept_id_PK primary key(dept_id);

drop table board;

create table board(
    board_num number,
    board_writer varchar2(30),
    board_subject varchar2(100),
    board_content varchar2(2000),
    read_count number,
    member_num number
);

alter table board
add (constraint board_num_PK primary key(board_num),
    constraint member_num_FK foreign key(member_num) references member(member_num));
    
desc board;


create table A(
    a INTEGER
);

create table B(
    b integer,
    a integer
);

create table C(
    c integer,
    b integer,
    a integer
);

create table D(
    d integer,
    a integer
);

alter table A
add constraint a_PK primary key(a);

alter table B
add constraint a_b_PK primary key(a, b);

alter table C
add constraint a_b_c_PK primary key (a, b, c);

insert into B(a,b)
values(1,2);

select * from user_constraints where table_name = 'B';
select * from A;

insert into C
values(1,2,3);

select * from A;
select * from B;
select * from C;
truncate table A;
truncate table B;
truncate table C;
drop table a;
drop table b;
drop table c;
drop table d;

alter table D
add constraint d_PK primary key(D);
----------------------------------------------
alter table B
add constraint a_FK foreign key(a) references a(a) on delete cascade;

alter table C
add constraint a_b_FK foreign key(a, b) references b(a, b) on delete cascade;

alter table D
add constraint a_FK2 foreign key(a) references a(a) on delete set null;

drop table a;
drop table b;
drop table c;
drop table d;



create view emp_view_80
as
select * from employees where department_id = 80;

select * from emp_view_80;

create view emp_view_job
as
select * from employees where job_id = 'SA_REP';

select * from emp_view_job;

create view empvu80
as
select employee_id, salary, first_name, department_id
from employees
where department_id = 80;

select * from empvu80;
---- �� alias�� ����Ͽ� �並 ����
create view empvu50(empid, sal, email, jid)
as
select employee_id, salary, email, job_id
from employees where department_id = 50;

select * from empvu50;
select * from empvu50 where jid = 'SH_CLERK';
select * from empvu50 where jid like '%CLE%';

create or replace view empvu50(empid, sal, email, jid)
as
select employee_id, salary, email, job_id, department_id
from employees where department_id = 50;

create or replace view empsal5000
as
select * from employees where salary >= 5000;

drop table departments;
create table departments
as
select * from hr.departments;
-- �μ��� �ִ� ����� �μ����� �����ؼ� ���
create or replace view depnm as
select first_name, salary, e.department_id, department_name
from employees e join departments d
on e.department_id = d.department_id;

select * from depnm;