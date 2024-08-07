-- 사번, 이름, 급여, 직무, 입사일, 이메일, 부서번호를 출력
select employee_id, first_name, salary, hire_date, email, department_id
from employees;

-- View로 만들자
create or replace vw_emp
as
select employee_id, first_name, salary, hire_date, email, department_id
from employees;

-- Inline View (from 절에 있는 Subquery, 마치 View처럼 사용 가능하지만 View처럼 Object는 아님.)
select * from
(select employee_id, first_name, salary, hire_date, email, department_id
from employees);

-- 부서별 최소 급여에 해당하는 사원의 
-- 사번, 이름, 급여, 직무, 입사일, 이메일, 부서번호를 출력
select e.employee_id, e.first_name, e.salary, e.job_id, e.hire_Date, e.email, e.department_id
from employees e join (select department_id, min(salary) min_sal from employees group by department_id) e2
on e.department_id = e2.department_id
where e.salary = min_sal;

-- 각 부서에서 평균 급여보다 많이 받는 사원의 사번, 이름, 급여, 직무
-- 입사일, 이메일, 부서번호를 출력하시오.
select employee_id, first_name, salary, job_id, hire_date, email, e.department_id
from employees e join (select department_id, avg(salary) avg_sal from employees group by department_id) e2
on e.department_id = e2.department_id
where salary > avg_sal;

-- 각 직무에서 최소 급여를 받는 사원의 사번, 이름, 급여, 직무
-- 입사일, 이메일, 부서번호를 출력하시오.
select employee_id, first_name, salary, e.job_id, hire_date, email, department_id
from employees e join(select job_id, min(salary) min_sal from employees group by job_id) e2
on e.job_id = e2.job_id
where salary = min_sal
order by employee_id;


-- 다중 Insert
create table employees1(
    employee_id number(6),
    first_name varchar2(20),
    last_name varchar2(25)
);
create table employees2(
    employee_id number(6),
    hire_date date,
    job_id varchar2(100)
);
select employee_id, first_name, last_name, hire_date, job_id
from employees;

-- 한 개의 테이블에서 가져온 데이터를 두 개의 테이블에 나눠서 저장
insert all into employees1(employee_id, first_name, last_name)  
           values(employee_id, first_name, last_name)
           into employees2(employee_id, hire_date, job_id)
           values(employee_id, hire_date, job_id)
select employee_id, first_name, last_name, hire_date, job_id
from employees;

select * from employees1;
select * from employees2;
truncate table employees2;
-- 입사일 05/12/24 보다 작으면 employees1에 넣고,
-- 그렇지 않으면 employees2에 넣고자 한다.
insert all
       when hire_date < '05/12/24' then
            into employees1(employee_id, first_name, last_name)
            values(employee_id, first_name, last_name)
       else
            into employees2(employee_id, hire_date, job_id)
            values(employee_id, hire_date, job_id)
select employee_id, first_name, last_name, hire_date, job_id
from employees;

-- 입사일 05/12/24 보다 작은 사원들은 employees1에 넣고,
-- Commission_pct가 null인 사원은 employee2에 넣고자 한다.
insert all
       when hire_date < '05/12/24' then
       into employees1(employee_id, first_name, last_name)
            values(employee_id, first_name, last_name)
       when commission_pct is null then
            into employees2(employee_id, hire_date, job_id)
            values(employee_id, hire_date, job_id)
select * from employees;

-- 일괄처리
create table education(
    edu_id varchar2(10),
    school_year date,
    school varchar2(100)
);

insert all
    into education(edu_id, school_year, school)
    values('2222','24/05/28', '성결대학교')
    into education(edu_id, school_year, school)
    values('2223','24/05/28', '성결대')
select * from dual;   

-------------------------------------------------------
-- DML : SELECT, INSERT, UPDATE, DELETE, MERGE
-- DDL : CREATE, DROP, ALTER, TRUNCATE, RENAME 
-- DCL : GRANT, REVOKE
-- TCL : COMMIT, ROLLBACK

-- MERGE : 병합!
-- 있으면 Update, 없으면 Insert가 되도록 해줌
create table emp
as
select * from hr.employees
where 1 = 2;

select * from hr.employees
where employee_id = 100;

insert into emp
values(100, 'Steven', 'King', 'SKING', '515.123.4567', '03/06/17', 'AD_PRES', 24000, null, null, 90);

select * from emp;

merge into emp c
using hr.employees e
on(c.employee_id = e.employee_id)
    when matched then update set salary = c.salary * 1.1
    when not matched then Insert values(e.employee_id, e.first_name, e.last_name, e.email, e.phone_number, 
    e.hire_date, e.job_id, e.salary, e.commission_pct, e.manager_id, e.department_id);
        
truncate table emp;

--------------------------------------------------------------------------
insert into emp
values(100, 'Steven', 'King', 'SKING', '515.123.4567', '03/06/17', 'AD_PRES', 24000, null, null, 90);

merge into emp e1
using hr.employees e2
on(e1.employee_id = e2.employee_id)
when matched then update set salary = e1.salary * 1.1,
                             hire_date = sysdate,
                             email = e2.email
when not matched then insert(employee_id, last_name, email, hire_date, job_id) 
                      values(e2.employee_id, e2.last_name, e2.email, e2.hire_date, e2.job_id);    

select * from emp;      



merge into emp e1
using (select * from hr.employees where employee_id = 100) e2
on (e1.employee_id = e2.employee_id)
when matched then update set salary = e1.salary * 1.1
when not matched then insert values(e2.employee_id, e2.first_name, e2.last_name, e2.email, 
e2.phone_number, sysdate, e2.job_id, 17000, 0.35, e2.manager_id, e2.department_id);

select * from emp;


-- 있으면 Delete, 없으면 Insert
merge into emp e1
using (select * from hr.employees where employee_id = 100) e2
on (e1.employee_id = e2.employee_id)
when matched then update set hire_date = sysdate
                  delete where e1.employee_id = 100
when not matched then insert values(e2.employee_id, e2.first_name, e2.last_name, e2.email, 
e2.phone_number, sysdate, e2.job_id, 17000, 0.35, e2.manager_id, e2.department_id);

create table cart(
    goods_num varchar2(10),
    cart_date date not null,
    cart_qty integer not null
);
drop table cart;
merge into cart c
using (select * from hr.employees where employee_id = 100) e
on(goods_num = employee_id)
when matched then update set cart_qty = cart_qty + 1
when not matched then insert values(employee_id, sysdate, 10);

select * from cart;


-- Window 함수
-- 사원 번호, 이름, 직무, 그리고 부서와 급여의 합계를 출력하세요.
select employee_id, first_name, job_id, sum(salary) over (partition by department_id) sumsal, department_id 
from employees;

select employee_id, first_name, job_id, e1.department_id, sum_sal
from employees e1 join (select department_id, sum(salary) sum_sal from employees group by department_id) e2
on e1.department_id = e2.department_id;

-- 직무와 직무별 급여의 평균 그리고 사번, 이름, 급여를 출력
select job_id, employee_id, first_name, salary, avg(salary) over (partition by job_id)
from employees;

select e1.job_id, employee_id, first_name, salary, avg_sal
from employees e1 join (select job_id, avg(salary) avg_sal from employees group by job_id) e2
on e1.job_id = e2.job_id;

-- 부서와 부서별 최대 급여와 이름, 사번, 급여, 직무를 출력
select department_id, first_name, employee_id, salary, job_id, max(salary) over(partition by department_id)
from employees;

-- employees 테이블의 첫 행부터 마지막 행까지
-- 직원 번호, 이름, 급여, 급여의 총 합계를 출력하시오.
select employee_id, first_name, salary, 
sum(salary) over (order by salary rows between unbounded preceding
                                       and unbounded following) sum_sal
from employees;

select employee_id, first_name, salary, sum(salary) over () sum_sal
from employees;

-- employees 테이블의 첫 행부터 마지막 행까지
-- 직원 번호, 이름, 급여, 급여의 누적 합계를 출력하세요.
select employee_id, first_name, salary, 
sum(salary) over(order by salary rows between unbounded preceding
                                      and current row) sum_sal
from employees;

-- 역순으로
select employee_id, first_name, salary, 
sum(salary) over(order by salary rows between current row
                                      and unbounded following) sum_sal
from employees;


-- Rank() : 순위를 출력할 때 사용. 동순위일때는 같은 값이 출력됨. ex) 1등이 여러명이면 1,1,1 출력 후 4 출력
-- 각 부서에서 급여가 몇 위일까?
select employee_id, first_name, salary,
       rank() over (partition by department_id order by salary desc) rank
from employees;

-- Dense_Rank() -- 동순위일때 같은 값이 출력되고, 다음 등수가 그대로 출력. ex) 1등이 여러명이면 1,1,1 출력 후 2 출력
select employee_id, first_name, salary,
       Dense_Rank() over (partition by department_id order by salary desc) drank
from employees;

--------------------------------------------
-- 부서와 부서별 최대 급여와 이름, 사번, 급여, 직무를 출력
-- 1. Partition by 사용
select first_name, employee_id, salary, job_id, max(salary) over (partition by department_id) pt
from employees;
-- 2. max 대신 first_value 사용
select first_name, employee_id, salary, job_id, 
first_value(salary) over (partition by department_id order by salary desc) fv
from employees;

-- 부서와 부서별 최소 급여와 이름, 사번, 급여, 직무를 출력
select first_name, employee_id, salary, job_id, min(salary) over (partition by department_id)
from employees;
select first_name, employee_id, salary, job_id, 
first_value(salary) over (partition by department_id order by salary asc) fv
from employees;