-- DML : INSERT, SELECT, UPDATE, DELETE : CRUD : 데이터
-- DDL : CREATE, ALTER, DROP : OBJECT : 스키마 : 테이블, 뷰, index : object
-- TCL : COMMIT, ROLLBACK, SAVEPOINT

-- View
-- Departments 테이블 삭제 후 생성
drop table departments;
create table departments
as
select * from hr.departments;

-- Employees 테이블 삭제 후 생성
drop table employees;
create table employees
as
select * from hr.employees;

-- 사번, 이름, 직무, 급여, 입사일, 커미션을 포함한 연봉
-- (year_sal : 연봉은 null이 될 수 없음.)을 출력할 때,
-- 직무에 'REP'가 포함된 사원들만 출력하시오.
select employee_id, first_name, job_id, salary, hire_date, (nvl(commission_pct, 0) + 1) * salary * 12 as year_sal
from employees where job_id like '%REP%';

-- 위 예제를 View로 만들어보자 !
create view rep_view
as select employee_id, first_name, job_id, salary, hire_date, (nvl(commission_pct, 0) + 1) * salary * 12 as year_sal
from employees where job_id like '%REP%';

select * from rep_view;

-- View는 Alter문을 사용할 수 없음. 대신에 Create or Replace 구문을 사용!!
create or replace view rep_view
as select employee_id, first_name, job_id, salary, department_id, hire_date, (nvl(commission_pct, 0) + 1) * salary * 12 as year_sal
from employees where job_id like '%REP%';

select * from rep_view;

-- 부서가 80인 사원들을 담는 View 생성
create or replace view vw_80
as
select * from employees where department_id = 80;

select * from vw_80;        -- 데이터 은닉 가능.

-- 사원들의 정보를 담는 View 생성
create or replace view vw_emp
as
select employee_id, first_name, last_name, job_id, department_id
from employees;

select * from employees;    -- 모든 Column의 데이터 출력
select * from vw_emp;       -- View를 생성할 때, 선택한 Column의 데이터만 출력. !은닉!

-- 위의 View를 Replace할 때, 별칭을 줌.
-- 1번 방법 (select문의 Column 뒤에 별칭을 줌)
create or replace view vw_emp
as
select employee_id eid, first_name fname, last_name lname, job_id jid, department_id did
from employees;

select * from vw_emp;   -- 별칭을 줌으로써 Column명을 은닉시킬 수 있음.

-- 2번 방법 (View를 선언할 때, 각 Column 순서에 맞게 별칭을 줌)
create or replace view vw_emp (eid, fname, lname, jid, did)
as
select employee_id, first_name, last_name, job_id, department_id
from employees;

select * from vw_emp;

-- 각 부서의 급여의 합계, 최소 급여, 최대 급여, 급여의 평균, 부서의 사원 수를 출력하시오.
select department_id, sum(salary), min(salary), max(salary), trunc(avg(salary)), count(*)
from employees
group by department_id;

-- 위의 예제를 View로 만들어보자!
create or replace view vw_grp
as
select department_id, sum(salary) sumsal, min(salary) minsal, max(salary) maxsal, trunc(avg(salary)) avgsal, count(*) count
from employees
group by department_id;

select * from vw_grp;

-- 부서가 80인 사원들을 View로 생성
create or replace view vw_80
as
select * from employees where department_id = 80;

select * from vw_80;
-- Insert 예제 
-- (View의 조건에 부합하지 않는 행을 Insert 하면, 보이지는 않지만 정상적으로 Insert가 되는 것을 확인 가능함.)
insert into vw_80
values(210, '숭무', '이', 'high', '010-1234-1231', sysdate, 'PR_REP', 19000, null, null, 110);
select * from employees; -- Employees를 Select해보면 확인 가능.

-- Delete 예제
delete from vw_80   -- View에서 보이는 것만 삭제할 수 있음. 위에서 삽입한 210번 이숭무는 View에서 삭제 불가능.
where employee_id = 210;

delete from vw_80   -- 사원 번호가 149번인 사원은 80번 부서이기 때문에 View에 포함됨. 따라서 삭제 가능.
where employee_id = 149;

-- 부서가 50인 사원들의 사원 번호, 성, 이메일, 입사일, 직무가 보이는 View를 생성해보자!
-- View의 이름은 emp50vw
create or replace view emp50vw
as
select employee_id, last_name, email, hire_date, job_id from employees
where department_id = 50;

select * from emp50vw;

insert into emp50vw
values(300, '장', 'jang', sysdate, 'ST_MAN', 100); -- View에서 보이지 않는 Column에는 값을 Insert할 수 없다.
insert into emp50vw
values(300, '장', 'jang', sysdate, 'ST_MAN');

update emp50vw
set salary = 300    -- View에는 salary가 없기 때문에 실행 안됨.
where employee_id = 50;

update emp50vw
set email = 'RHEE'
where employee_id = 120;

select * from emp50vw where employee_id = 120;

-- 부서 번호, 부서명, 사번, 이름, 급여 출력
select e.department_id, department_name, employee_id, first_name, salary
from departments d right outer join employees e
on d.department_id = e.department_id;

-- 위의 예제를 View로 만들어보자! (복합 View 예제)
create or replace view dep_emp_vw as
select e.department_id, department_name, employee_id, first_name, salary
from employees e join departments d  
on d.department_id = e.department_id;

select * from dep_emp_vw;

update dep_emp_vw
set salary = 100
where employee_id = 100;

select * from dep_emp_vw;

create table viewupd1(
    c1 number,      -- 1
    c2 int          -- 1
);
create table viewupd2(
    c1 number,      -- 1
    c3 number       -- 1
);

insert into viewupd1 values(1,1);
insert into viewupd2 values(1,1);

select v1.c1, c2, c3
from viewupd1 v1 join viewupd2 v2
on v1.c1 = v2.c1;

create or replace view v_viewupd
as
select v1.c1, c2, c3
from viewupd1 v1 join viewupd2 v2
on v1.c1 = v2.c1;
select * from v_viewupd;

update v_viewupd
set c2 = 10, c3 = 20        -- Join을 사용해서 만든 View를 Update할 때, 동시에 두 개의 테이블을 Update할 수는 없다.
where c1 = 1;

update v_viewupd
set c2 = 10             -- 복합 View도 하나의 테이블만 수정할 수는 있음.
where c1 = 1;

-- 부서가 10인 사원들의 View 생성
create or replace view empvu10
as
select employee_id, last_name, email, hire_date, job_id, department_id
from employees where department_id = 10;

insert into empvu10
values(300, '이','high', sysdate, 'AD_ASST', 10);

-- 위의 예제를 읽기 전용 View로 재생성
create or replace view empvu10
as
select employee_id, last_name, email, hire_date, job_id, department_id
from employees where department_id = 10
with read only;     -- 읽기 전용이 됨.
insert into empvu10
values(300, '이','high', sysdate, 'AD_ASST', 10);

-- View에 보이는 것만 DML을 할 수 있게 하자.
create or replace view empvu10
as
select employee_id, last_name, email, hire_date, job_id, department_id
from employees where department_id = 10
with check option;      -- View에 보이는 것에 대해서는 Insert 가능.

insert into empvu10
values(300, '이','high', sysdate, 'AD_ASST', 10);    -- 부서가 10인 데이터는 View에서 보이기 때문에 Insert 가능
insert into empvu10
values(300, '이','high', sysdate, 'AD_ASST', 20);    -- 부서가 20인 데이터는 View에서 보이지 않기 때문에 Insert 불가능

drop view empvu10;

------ 시퀀스 ------
create table goods(
    goods_num varchar2(10),
    goods_name varchar2(100),
    goods_price number
);
select * from goods;
insert into goods(goods_num, goods_name, goods_price)
values('miso_10000', '청바지', 1000);

insert into goods(goods_num, goods_name, goods_price)
values('miso_10001', '냉장고', 2000);

insert into board
values(1, '글쓴이', '제목', '내용', 0, 10);

create sequence seq_num -- 아래 조건은 모두 생략 가능. 생략하면 초기값 1, 증가값 1, 최대값 999999
increment by 10     -- 증가값
start with 10       -- 초기값
maxvalue 9990       -- 최대값
NOCYCLE             -- 반복 여부 (maxValue에 도달했을 때, 다시 초기값으로 돌아갈 것인지)
NOCACHE;            -- 메모리에 담는 여부

select seq_num.nextval from dual;   -- seq_num의 다음 값 출력
select seq_num.currval from dual;   -- seq_num의 현재 값 출력

insert into goods
values(concat('miso_', 10000 + seq_num.nextval), '냉장고', 2000);
select * from goods;
drop table board;

create table board(
    board_num number generated always as identity(start with 1 increment by 1),
    board_writer varchar2(30),
    board_subject varchar2(100),
    board_content varchar2(2000),
    read_count number
);

insert into board(board_writer, board_subject, board_content, read_count)
values('글쓴이', '제목', '내용', 0);

select * from board;

alter sequence seq_num
increment by 1
maxvalue 99999999;

drop sequence seq_num;
select seq_num.currval, seq_num.nextval from dual;


-- goods_num을 10001부터 1씩 증가하는 값을 부여해주면서 상품 정보를 입력하고싶다.
-- Sequence는 사용하지 않는다.
-- miso_10001 -> miso_10002 .... 자동으로 증가되어야 한다.
-- goods_num을 출력하시오.
-- goods_num의 처음은 -> miso_10001
drop table goods;
create table goods(
    goods_num varchar2(10),
    goods_name varchar2(100),
    goods_price number
);
truncate table goods;
insert into goods(goods_num, goods_name, goods_price)
values(concat('miso_', nvl((select max(substr(goods_num, 6)) + 1 from goods), 10001)), 
'goods1',
1);
select * from goods;

create index idx_did
on departments(department_id);

select * from departments
where department_id = 90;

-- 사원 번호, 이름, 급여, 직무, 부서를 출력할 때, 직무에 'REP'가 포함된 사원들만 출력
select employee_id, first_name, salary, job_id, department_id
from employees where job_id like '%REP%';

create index emp_job_idx
on employees(job_id);
drop index emp_job_idx;

-- 이름의 앞에서 두 글자가 'Oc'인 직원을 출력
select * from employees
where substr(first_name, 1, 2) = 'Oc';

create index sub_idx
on employees (substr(first_name, 1, 2));

-- 각 부서의 급여의 평균이 10000인 부서와 평균 급여를 출력하시오
select department_id, avg(salary) from employees
group by department_id
having avg(salary) = 10000;

create index avgsal
on employees(avg(salary));  -- 그룹함수는 Index로 만들 수 없다.

-- 각 부서의 최대 급여에 해당하는 사원 정보인
-- 이름, 급여, 직무, 입사일, 최대 급여, 부서를 출력하시오.
select first_name, salary, job_id, hire_date, department_id
from employees;

select department_id, max(salary)
from employees
group by department_id;

select first_name, salary, job_id, hire_date, e1.department_id, max_sal
from employees e1 join (select department_id, max(salary) max_sal
                        from employees                  -- inline View
                        group by department_id) e2
on e1.department_id = e2.department_id
where salary = max_sal;

-- 사번, 이름, 급여, 부서, 각 부서의 평균 급여를 출력할 때,
-- 평균 급여보다 많이 받는 사원들을 출력
select employee_id, first_name, salary, e1.department_id, avg_sal
from employees e1 join (select department_id, avg(salary) avg_sal from employees group by department_id) e2
on e1.department_id = e2.department_id
where salary > avg_sal;


-- 지역번호(location_id)가 1700에 해당하는 부서의 부서명과
-- 그 부서에서 근무하는 사원의 사원번호, 이름, 급여를 출력
select department_name, d.department_id, employee_id, first_name, salary
from departments d join employees e
on d.department_id = e.department_id
where location_id = 1700;

select department_name, d.department_id, employee_id, first_name, salary
from employees e join (select department_id, department_name from departments where location_id = 1700) d
on e.department_id = d.department_id;


-- 사원의 사원번호, 이름, 급여
select employee_id, first_name, salary
from employees
where department_id = 80;

select * from (select employee_id, first_name, salary
from employees
where department_id = 80);