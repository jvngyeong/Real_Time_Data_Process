-- 평균 급여가 가장 높은 직무를 출력하시오.
select max(avg(salary)) -- 24000
from hr.employees
group by job_id;

select job_id, salary
from hr.employees
where salary = (select max(avg(salary)) -- 24000
from hr.employees
group by job_id);

-- Abel의 급여를 출력하시오.
select salary FROM hr.employees
where last_name = 'Abel';

-- Abel과 같은 급여를 받는 직원들을 출력하시오
select * from hr.employees
where salary = (select salary from hr.employees where last_name = 'Abel');

-- 성이 Kumar인 사원의 직무와 같고, Kumar인 사원보다 입사일이 빠른 사원들의
-- 성, 이름, 직무, 입사일, 부서를 출력
select last_name, first_name, job_id, hire_date, department_id
from hr.employees where job_id = 
(select job_id from hr.employees where last_name = 'Kumar') 
and hire_date < (select hire_date from hr.employees where last_name = 'Kumar');

-- 사장(100)보다 먼저 입사한 사원들을 출력
select * from hr.employees where
hire_date < (select hire_date from hr.employees where employee_id = 100);

-- 30인 부서에 있는 직무와 같은 직무하는 사원들을 출력하시오.
select * from hr.employees where
job_id in (select job_id from hr.employees where department_id = 30);

-- 성이 Taylor인 사원과 같은 직무를 하는 사원들을 출력
select * from hr.employees where job_id in
(select job_id from hr.employees where last_name = 'Taylor');

-- 각 부서의 최소 급여
select department_id, min(salary) from hr.employees group by department_id;

-- 30, 60, 90인 부서의 최소 급여를 구하시오.
select min(salary) from hr.employees where department_id in (30,60,90)
group by department_id
order by department_id asc;

-- 직무가 'RE'를 포함하는 직무를 제외한 나머지 사원들을 출력
select * from hr.employees where job_id not like '%re%';

-- 30, 60, 90인 부서의 최소 급여와 같고, 직무가 'RE'를 포함하는 직무에 속해 있지 않은 사원들을 구하시오.
select * from hr.employees where salary in
(select min(salary) from hr.employees where department_id in (30,60,90) group by department_id) and
job_id not like '%RE%';

-- 직원 번호가 104인 직원의 직무와 같고 각 부서의 최대 급여에 해당하는
-- 직원의 모든 정보를 출력
select * from hr.employees where job_id = (select job_id from hr.employees where employee_id = 104) and
salary in (select max(salary) from hr.employees group by department_id);

-- FI_ACCOUNT인 직무를 가진 사원들의
-- 최소 급여보다 더 적게 받는 사원들의 정보.
select * from hr.employees where salary <
(select min(Salary) from hr.employees where job_id = 'FI_ACCOUNT');

select min(salary) from hr.employees
where job_id ='FI_ACCOUNT'
group by job_id;

select * from hr.employees
where salary < (select min(salary) from hr.employees
where job_id ='FI_ACCOUNT'
group by job_id);

-- 직무가 FI_ACCOUNT인 사원의 급여를 출력
select salary from hr.employees where job_id = 'FI_ACCOUNT';

-- 9000, 8200, 7700, 7800, 6900 급여에 해당하는 사원들을 출력
select * from hr.employees where salary in (9000, 8200, 7700, 7800, 6900);
select * from hr.employees where salary in 
(select salary from hr.employees where job_id = 'FI_ACCOUNT'); -- 다중 행 서브쿼리

select * from hr.employees 
where salary < (select max(salary) from hr.employees where job_id = 'FI_ACCOUNT');

-- < any : 가장 큰 값보다 작은 값
select * from hr.employees 
where salary < any(9000, 8200, 7700, 7800, 6900);

-- > any : 가장 작은 값보다 큰 값
select * from hr.employees 
where salary > any(9000, 8200, 7700, 7800, 6900);

-- = any : in
select * from hr.employees 
where salary = any(9000, 8200, 7700, 7800, 6900);

-- < all : 가장 작은 값보다 작은 값
select * from hr.employees 
where salary < all(9000, 8200, 7700, 7800, 6900);

-- > all : 가장 큰 값보다 큰 값
select * from hr.employees
where salary > all(9000, 8200, 7700, 7800, 6900);

-- 부하직원이 있는 사원을 모두 구하시오.
select distinct * from hr.employees where employee_id in (select manager_id from hr.employees);

-- 부하직원이 없는 사원을 모두 구하시오.
select * from hr.employees where employee_id not in(select manager_id from hr.employees
    where manager_id is not null);

-- A 집합
select salary from hr.employees where job_id = 'ST_CLERK';
-- B 집합
select salary from hr.employees where job_id = 'PU_CLERK';

-- 합집합
select salary from hr.employees where job_id = 'ST_CLERK'
union -- set 연산
select salary from hr.employees where job_id = 'PU_CLERK';

-- 교집합
select salary from hr.employees where job_id = 'ST_CLERK'
intersect -- set 연산
select salary from hr.employees where job_id = 'PU_CLERK';

-- 차집합
select salary from hr.employees where job_id = 'ST_CLERK'
minus -- set 연산
select salary from hr.employees where job_id = 'PU_CLERK';

-- 중복을 허용하는 합집합
select salary from hr.employees where job_id = 'ST_CLERK'
union all -- set 연산, 교집합은 중복해서 출력
select salary from hr.employees where job_id = 'PU_CLERK';

-------------------------------------------------------------------
select employee_id, job_id from hr.employees
union
select employee_id, job_id from hr.job_history
order by 1;

select employee_id, job_id from hr.employees
intersect
select employee_id, job_id from hr.job_history;
select employee_id from hr.employees;
-- A 집합
select employee_id, start_date, department_id
from hr.job_history
union all
select manager_id, hire_date, employee_id
from hr.employees;

select employee_id, start_date, department_id
from hr.job_history
intersect
select manager_id, hire_date, employee_id
from hr.employees;

select employee_id, job_id, salary
from hr.employees
union
select employee_id, job_id, 0
from hr.job_history;
