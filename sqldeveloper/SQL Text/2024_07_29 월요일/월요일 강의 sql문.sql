-- 다중 행 함수(그룹 함수) : null을 포함하지 않는다. (null이 있으면 계산이 불가능하기 때문에)
select count(department_id) from hr.employees;

-- 급여에서 급여를 많이 받는 직원과 급여가 제일 적은 직원, 그리고 한 달 급여의 평균과
-- 한 달동안 지급되는 급여의 금액을 출력하세요.
select max(salary), min(salary), round(avg(salary)), sum(salary) from hr.employees;

-- 전체 직원의 수
select count(employee_id), count(last_name), count(first_name), count(email), count(hire_date) from hr.employees;

-- 커미션을 받는 직원의 수
select count(commission_pct) from hr.employees;

-- 부서가 있는 직원의 수
select count(department_id) from hr.employees;

-- 부서가 없는 사원의 수
select count(*) from hr.employees where department_id is null;

-- 80인 부서의 직원 수와 최대 급여와 최소 급여를 구하시오.
select count(*), max(salary), min(salary) from hr.employees where department_id = 80;

-- 부서를 출력하세요
select department_id from hr.employees;

-- 부서를 한 번씩만 출력
select distinct department_id from hr.employees;

-- 부서의 수를 출력
select count(distinct(department_id)) from hr.employees;

-- 직무가 RE를 포함한 직원을 출력하시오.
select * from hr.employees where job_id like '%RE%';

-- 직무가 RE를 포함한 직원의 최대 급여와 최소 급여 그리고 직원의수와 평균 급여를 출력하시오.
select max(salary), min(salary), count(*), round(avg(salary)) from hr.employees where job_id like '%RE%';

-- 제일 먼저 입사한 사원과 제일 늦게 입사한 사원의 입사일을 출력하시오.
select min(hire_date), max(hire_date) from hr.employees;

-- commission_pct를 받는 사원의 commission_pct의 평균을 구하시오
select round(avg(commission_pct), 2) from hr.employees where commission_pct is not null;
-- 전체 직원의 commission_pct의 평균을 구하자
select avg(nvl(commission_pct, 0)) from hr.employees;
select sum(commission_pct) / count(*), avg(nvl(commission_pct, 0)) from hr.employees;

--80인 부서에서 직무가 'SA_MAN'인 직원의 수와 커미션의 평균을 구하시오.
select count(*), nvl(avg(commission_pct), 0) from hr.employees where department_id = 80;


-- group by
select department_id, avg(salary), sum(salary), max(salary), min(salary)
from hr.employees
group by department_id;

-- job_id가 FI_ACCOUNT인 직원의 급여의 평균, 합계, 최대값, 최소값, 직원 수를 출력
-- job_id가 IT_PROG인 직원의 급여의 평균, 합계, 최대값, 최소값, 직원 수를 출력
-- job_id가 PU_CLERK인 직원의 급여의 평균, 합계, 최대값, 최소값, 직원 수를 출력
select job_id, sum(salary), avg(salary), sum(salary), max(salary), min(salary), count(*)
from hr.employees
where job_id in('FI_ACCOUNT', 'IT_PROG', 'PU_CLERK')
group by job_id;

-- 직원들의 모든 정보를 출력할 때, 부서를 오름차순으로 정렬하고
-- 정렬된 같은 부서 안에서 다른 직무를 가진 직원이 있다면 직무를 오름차순으로
select * from hr.employees
order by department_id asc, job_id asc;

-- 같은 부서의 다른 직무들의 급여의 평균, 급여의 합계, 최대값, 최소값
-- 같은 부서에서 같은 직무를 하는 직원의 수를 출력하세요.
select job_id, avg(salary), sum(salary), max(salary), min(salary), count(*)
from hr.employees
group by department_id, job_id
order by department_id, job_id;

-- 부서별 평균 급여를 출력하세요.
select department_id, avg(salary) from hr.employees
group by department_id;
-- 이때, 평균 급여가 8000을 초과한 부서와 급여의 평균을 출력
select department_id, avg(salary) from hr.employees
having avg(salary) > 8000
group by department_id;


--직무 별 최대 급여, 최소 급여, 급여의 합계,
--직원 수를 출력할 때, 직원 수가 3 이상인 것만 출력하시오.
select job_id, max(salary), min(salary), sum(salary), count(*)
from hr.employees
group by job_id
having count(*) >= 3 
order by job_id;

-- REP를 포함하고 있지 않은 직무들 중에서 각 직무별 최대 급여, 최소 급여, 급여 합계를 출력.
-- 이때 급여 합계가 13000이상인 것만 출력하시오.
-- 단, 급여의 합계가 많은 것부터 출력.
select job_id, max(salary), min(salary), sum(salary)
from hr.employees
where job_id not like '%REP%'
group by job_id
having sum(salary) >= 13000
order by sum(salary) desc;


-- 각 부서별 부서의 급여의 합계, 최대, 최소, 사원의 수, 평균을 출력하는데
-- 평균은 소수점 2자리만 출력
select department_id, sum(salary), max(salary), min(salary), count(*), round(avg(salary), 2)
from hr.employees
group by department_id;

-- 부서에서 같은 직무를 하는 사원들의 최대 급여, 최소 급여,
-- 평균 급여, 급여의 합계와 같은 직무를 하는 사원의 수를 출력.
select department_id, job_id, max(salary), min(salary), avg(salary), sum(salary), count(*)
from hr.employees
group by department_id, job_id;

select department_id, job_id, hire_date, count(*)
from hr.employees
where department_id = 80
group by department_id, job_id, hire_date
having count(*) >= 2
order by department_id, job_id, hire_date;

-- 평균 급여가 7000 이상인 부서만 출력하시오. 평균 급여가 높은 것 부터 출력
select department_id
from hr.employees
group by department_id
having avg(salary) >= 7000
order by avg(salary) desc;

-- 각 부서의 평균 급여 중 최대 평균 급여를 출력.
-- 중첩 그룹 함수
select max(avg(salary))
from hr.employees
group by department_id;

-- 조인 : 두 개 이상의 테이블로부터 데이터를 가져오는 것
select * from hr.employees;
select * from hr.departments;

-- 사원번호, 이름, 급여, 직무, 부서번호, 부서명
select employee_id, first_name, salary, job_id, hr.employees.department_id, department_name
from hr.employees, hr.departments
where hr.employees.department_id = hr.departments.department_id;

select * from hr.jobs;

-- 사원번호, 이름, 급여, 직무 번호, 부서 번호, 직무명
select employee_id, first_name, salary, hr.employees.job_id, department_id
    ,job_title
from hr.employees, hr.jobs
where hr.employees.job_id = hr.jobs.job_id;


select employee_id, first_name, salary, job_id
, d.department_id, d.department_name, d.manager_id
from hr.employees e join hr.departments d
on e.employee_id = d.manager_id
where employee_id = 100;

select * from hr.job_history;

-- 사원번호, 이름, 급여, 직무, 부서 번호
-- 시작일, 마지막일. 맡은 직무
select a.employee_id, a.first_name, a.salary, a.job_id, a.department_id
    ,b.start_date, b.end_date, b.job_id
    from hr.employees a join hr.job_history b
    on a.employee_id = b.employee_id;
    
    
select * from hr.job_history;
select * from hr.jobs;
select * from hr.departments;
-- 직무명, 최소 급여, 최대 급여
-- 직무명, 시작일, 마친일
-- 부서 번호, 부서명
select a.job_id, a.min_salary, a.max_salary,
    b.job_id, b.start_date, b.end_date,
    c.department_id, c.department_name
    from hr.jobs a join hr.job_history b
    on a.job_id = b.job_id 
    join hr.departments c 
    on b.department_id = c.department_id;