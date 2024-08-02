desc hr.departments;

create table departments
as
select * from hr.departments;

select * from departments;
desc departments;

drop table departments;

create table departments
as
select * from hr.departments where 1=2;

create table employees
as
select * from hr.employees where 1=2;



select employee_id, first_name, salary, email, department_id
from hr.employees;

insert into departments(department_id, department_name, manager_id, location_id)
values(70, 'Public Relations', 100, 1700);

insert into departments(department_name, department_id, manager_id, location_id)
values('Public Relations', 70, 100, 1700);

select * from departments;

desc departments;

insert into departments(department_id, department_name)
values(30, 'Purchasing');

insert into departments
values(100, 'Finance', 100, 1700);

select * from departments;


insert into departments(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID)
values (100, 'Finance', NULL, NULL);
desc departments;

select * from employees;
desc employees;
insert into employees(employee_id,
            first_name, last_name,
            email, phone_number,
            hire_date, job_id, salary,
            commission_pct, manager_id,
            department_id)
            values(113,
             'Louis', 'Popp',
             'LPOPP', '515.124.4567',
             SYSDATE, 'AC_ACCOUNT', 6900, 
             NULL, 205, 110
            );
            
insert into employees(employee_id,
            first_name, last_name,
            email, phone_number,
            hire_date, job_id, salary,
            commission_pct, manager_id,
            department_id)
            values(114,
             '숭무', '이',
             'highland0', '010-7146-1970',
             to_date('30/07/24', 'DD/MM/YY'), 'AC_ACCOUNT', 6900, 
             NULL, 205, 110
            );
select * from employees;


create table jobs
as
select * from hr.jobs
where job_id like 'AD%';

select * from jobs;

insert into departments(department_id, department_name)
select department_id, department_name from hr.departments
where manager_id is not null;

select * from departments;

insert into employees
select * from hr.employees
where job_id not like 'AD%';

select * from employees;
UPDATE employees
 SET    department_id = 100
 WHERE  employee_id = 113;
 
update employees
set job_id = (select job_id from employees where employee_id = 205),
    salary = (select salary from employees where employee_id = 205)
    where employee_id = 113;
commit;

update employees
set employee_id = 100;

select * from employees;
rollback;

select department_id from employees where employee_id = 100;
-- 부서가 90인 사원의 직무를 'AD_ASST'로 변경하고싶다.
-- 100인 사원의 부서에 해당되는 모든 직원의 직무를 200인 사원의 직무로 변경
update employees
set job_id = 'AD_ASST'
where department_id = 90;

update employees
set job_id = (select job_id from employees where employee_id = 200)
where department_id = (select job_id from employees where employee_id = 100);

select job_id from employees where department_id = 90;


-- Delete
delete from employees;
select * from employees;
rollback;
select * from departments;
commit;
delete from departments;

delete from departments
where department_name = 'Finance';

select department_id from departments   -- 70
where department_name like '%Public%';

-- 70인 부서 삭제
delete from departments
where department_id = 70;

-- 부서명에 Public을 포함하고 있는 부서번호를 이용해서 삭제하고싶다.
delete from departments
where department_id = (select department_id from departments where department_name like '%Public%');



--class HireDate{
--    int id;
--    date hireDate;
--}

create table hire_date(
    id number, 
    hire_date date default sysdate -- 열 이름은 대소문자를 구분하지 않기 때문에 문자 사이마다 '_(언더바)'를 넣어줌.
);
insert into hire_date(id)
values(10);
select * from hire_date;
select * from hire_date1;
create table hire_date1(
    id number, 
    hire_date date default sysdate
);
insert into hire_date1(id)
values(10);
desc hire_date;
drop table hire_date;


create table dept(
    deptno number(2),
    dname varchar2(14),
    loc varchar2(13),
    create_date date default sysdate
);

desc dept;
insert into dept
values(10, '영업부', '1700', default);
select * from dept;

insert into dept(deptno, dname, loc)
values(20, '기술부', '1800');

--class Board{
--    int boardNum,
--    String userId,
--    String boardName,
--    String boardSubject,
--    String boardContent,
--    Date boardDate,
--    int readCount = 0
--}
create table board(
    board_num number,
    user_id varchar2(20),
    board_name varchar2(20),
    board_subject varchar2(50),
    board_content varchar2(500),
    board_date date,
    read_count number default 0
);

desc board;

insert into board
values(1, '이준경', '1번글', '1번주제', '1번내용', sysdate, default);

select * from board;

update board
set read_count = read_count + 1
where board_num = 1;