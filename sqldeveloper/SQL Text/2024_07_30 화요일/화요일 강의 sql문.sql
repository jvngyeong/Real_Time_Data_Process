select * from hr.employees;
select * from hr.departments;   -- employees 테이블과 departments 테이블에는 공통된 Column이 있기 때문에 데이터를 가져올 수 있음.
select * from hr.locations;     -- employees 테이블과 locations 테이블에는 공통된 Column이 없기 때문에 데이터를 가져올 수 없음.
-- employes 테이블         departments 테이블      locations 테이블
-- department_id   / department_id, location_id / location_id
-- employees 테이블과 locations 테이블에 공통되는 값이 없기 때문에 
-- 둘 다 갖고있는 departments 테이블을 이용해서 3중 조인을 사용!!

-- 2중 조인 예제 )
-- 사원 번호, 이름, 입사일, 급여, 부서 번호
-- 부서 번호, 부서명
select employee_id, first_name, hire_date, salary, em.department_id,
       de.department_id, department_name
from hr.employees em join hr.departments de
on em.department_id = de.department_id;

select * from hr.employees;
select * from hr.jobs;

-- 사원 번호, 부서 번호, 이름, 직무ID
-- 직무ID, 직무명
select employee_id, department_id, first_name, em.job_id
      ,jo.job_id, job_title
from hr.employees em join hr.jobs jo
on em.job_id = jo.job_id;

-- join을 위해서는 공통된 Column이나 값이 존재해야 함.
-- 값이 같은 경우의 예제)
select * from hr.departments;
select * from hr.employees;
-- 부서 번호, 부서명, 부서장 번호
-- 사원 번호, 사원명, 직무, 급여
select de.department_id, department_name, de.manager_id,
       employee_id, first_name, job_id, salary
from hr.departments de join hr.employees em
on de.manager_id = em.employee_id;

-- table이 n개 있을 때, join 조건은 몇 개인가? --> n-1 이상

-- 사원 번호, 이름, 입사일, 급여, 부서 번호
-- 부서 번호, 부서명
-- inner join (서로 같은 값을 출력할 때)
select employee_id, first_name, hire_date, salary, em.department_id
      ,de.department_id, department_name
from hr.employees em inner join hr.departments de
on em.department_id = de.department_id;

-- 사원 번호, 부서 번호, 이름, 직무 번호
-- 직무 번호, 직무 내용
select employee_id, department_id, first_name,
       j.job_id, job_title
from hr.employees e join hr.jobs j
on e.job_id = j.job_id;
-- , = join = inner join

-- 사원 번호, 이름, 직무, 부서 번호
select employee_id, first_name, job_id, department_id
from hr.employees;

select employee_id, first_name, job_id, e.department_id,
       department_name
from hr.employees e inner join hr.departments d
on e.department_id = d.department_id;

-- 부서 번호, 부서명, 부서장 번호
-- 사원번호, 사원명, 직무, 급여
select count(manager_id) from hr.departments;

select d.department_id, department_name, d.manager_id,
       employee_id, first_name, job_id, salary
from hr.departments d join hr.employees e
on d.manager_id = e.employee_id;

-- natural 조인 예제
-- 사원 번호, 부서 번호, 이름, 직무 번호
-- 직무 번호, 직무 내용
-- natural 조인에서는 별칭을 사용하지 않는다.
select employee_id, department_id, first_name, job_id,
       job_id, job_title
from hr.employees natural join hr.jobs;
--on e.job_id = j.job_id


-- 같은 부서의 부서장을 상사로 둔 직원들의 정보와 부서명을 출력하시오.
-- 사원 번호, 이름, 직무, 급여, 상사 번호
-- 부서 번호, 부서명, 부서장
select employee_id, first_name, job_id, salary, e.manager_id,
       d.department_id, department_name, d.manager_id
from hr.employees e inner join hr.departments d
on e.department_id = d.department_id and e.manager_id = d.manager_id;

select employee_id, first_name, job_id, salary, manager_id,
       department_id, department_name, manager_id
from hr.employees natural join hr.departments;
--on e.department_id = d.department_id and e.manager_id = d.manager_id;

-- using 절
select employee_id, first_name, job_id, salary, manager_id,
       department_id, department_name, manager_id
from hr.employees join hr.departments
using(department_id, manager_id);


-- 사원 번호, 부서 번호, 이름, 직무 번호
-- 직무 번호, 직무 내용
select employee_id, department_id, first_name, e.job_id,
       j.job_id, job_title
from hr.employees e join hr.jobs j
on e.job_id = j.job_id;

select employee_id, department_id, first_name,
       job_id, job_title
from hr.employees join hr.jobs
using(job_id);
--on e.job_id = j.job_id;

-- 각 직원의 직원 번호, 직무 번호,
--         부서 번호, 부서명
-- 이 때, 20, 30, 50, 80인 부서만 출력
-- T-SQL Join, Ansi - Join, Using절
select employee_id, job_id,
       hr.employees.department_id, department_name
from hr.employees, hr.departments
where hr.employees.department_id = hr.departments.department_id and hr.employees.department_id in (20, 30, 50, 80);

select employee_id, job_id,
       hr.employees.department_id, department_name
from hr.employees join hr.departments
on hr.employees.department_id = hr.departments.department_id and hr.employees.department_id in (20, 30, 50, 80);

select employee_id, job_id,
       department_id, department_name
from hr.employees join hr.departments
using(department_id)
where department_id in (20, 30, 50, 80);

-- 부서 번호, 부서명, 우편번호(location_id)
-- 주소(street_address)를 출력할 때 우편번호가 1400만 출력
-- T-SQL Join, Ansi - Join, Natural Join, using 절
select department_id, department_name, d.location_id,
       street_address
from hr.departments d, hr.locations l
where d.location_id = l.location_id and d.location_id = 1400;

select department_id, department_name, d.location_id,
       street_address
from hr.departments d join hr.locations l
on d.location_id = l.location_id
where d.location_id = 1400;

select department_id, department_name, location_id,
       street_address
from hr.departments natural join hr.locations
where location_id = 1400;

select department_id, department_name, location_id,
       street_address
from hr.departments d join hr.locations l
using(location_id)
where location_id = 1400;

-- 직원 번호, 이름, 급여, 직무, 입사일
-- 부서번호, 부서명을 출력할 때 50인 부서와 90인 부서는 제외한다
select employee_id, first_name salary, job_id, hire_date,
       d.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id and e.department_id not in(50, 90);


-- 직무 번호, 직무 내용
-- 직무 번호, 사원 번호, 이름, 부서번호
-- 부서 번호, 부서명
-- T-SQL Join
select j.job_id, job_title,
       e.job_id, employee_id, first_name, e.department_id,
       d.department_id, department_name
from hr.jobs j, hr.employees e, hr.departments d
where j.job_id = e.job_id and e.department_id = d.department_id;

-- ANSI - JOIN
select j.job_id, job_title, -- jobs 테이블
       e.job_id, employee_id, first_name, e.department_id, -- employees 테이블
       d.department_id, department_name
from hr.jobs j join hr.employees e
on j.job_id = e.job_id
join hr.departments d on e.department_id = d.department_id;

-- 직무 번호, 사원 번호, 이름, 급여, 부서번호
-- 부서 번호, 부서명, 지역 번호
-- 지역번호, 주소
select e.job_id, employee_id, first_name, salary, e.department_id,
       d.department_id, department_name, d.location_id,
       l.location_id, street_address,
       j.job_id, job_title
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.locations l on d.location_id = l.location_id
join hr.jobs j on j.job_id = e.job_id;

-- 직무 번호, 직무 내용 -- jobs 테이블
-- 직무 번호, 사원 번호, 이름, 급여, 입사일 -- employees 테이블
-- 부서 번호, 부서명, 지역번호 -- departments 테이블
-- 지역 번호, 주소, 국가번호  -- locations 테이블
-- 국가 번호, 국가명 -- countries 테이블
select j.job_id, job_title, min_salary, max_salary,
       e.job_id, employee_id, first_name, salary, hire_date, e.department_id,
       d.department_id, department_name, d.location_id,
       l.location_id, street_address, l.country_id,
       c.country_id, country_name
from hr.jobs j join hr.employees e
on j.job_id = e.job_id
join hr.departments d on e.department_id = d.department_id
join hr.locations l on d.location_id = l.location_id
join hr.countries c on l.country_id = c.country_id;

-- Self Join
select * from hr.employees;
-- David의 사원번호, 이름, 급여, 직무, 이메일, 상사, 상사 이름
select e1.employee_id, e1.first_name, e1.salary, e1.job_id, e1.email, e1.manager_id,
        e2.first_name
from hr.employees e1, hr.employees e2
where e1.manager_id = e2.employee_id and e1.employee_id = 105;


-- 사장(100)이 상사인 사원들(사원번호, 이름, 급여, 직무, 상사번호) 을 출력하시오
-- 사장의 급여와 입사일을 출력하시오.
select e1.employee_id, e1.first_name, e1.salary, e1.job_id, e1.manager_id,
        e2.salary, e2.hire_date
from hr.employees e1 join hr.employees e2
on e1.manager_id = e2.employee_id;

-- 사원번호, 이름, 급여, 직무
-- 직무 번호, 직무내용, 최소금액, 최대금액
select employee_id, first_name, salary, e.job_id,
       j.job_id, job_title, min_salary, max_salary
from hr.employees e join hr.jobs j
on salary between min_salary and max_salary;

-- 부서가 없는 사원은 출력되지 않았음.
select employee_id, first_name, salary, e.department_id,
       department_name
from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id;

select employee_id, first_name, salary, e.department_id,
       department_name
from hr.departments d right outer join hr.employees e
on e.department_id = d.department_id;

select employee_id, first_name, salary,
       d.department_id, department_name
from hr.departments d full outer join hr.employees e
on e.department_id = d.department_id;

---------------------------------------------------------