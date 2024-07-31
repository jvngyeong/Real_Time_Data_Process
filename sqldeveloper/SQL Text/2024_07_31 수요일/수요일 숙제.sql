-- 1. 이름에 'AN'이 들어가지 않는 직원의
-- 직원 번호, 이름, 부서, 부서명, 직무명, 직무내용을 출력하시오
-- 단, 이름은 소문자, 대문자 상관없음
select employee_id, first_name, department_id, j.job_id, job_title
from hr.employees e join hr.jobs j
on e.job_id = j.job_id and upper(first_name) not like upper('%AN%');
-- 2. 직원 정보 중 사원번호, 이름, 직무를 출력할 때 직무내용을 출력하고
-- 부서장과 지역번호를 출력하세요
select employee_id, first_name, 
       j.job_id, job_title, 
       d.manager_id, location_id
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.jobs j on e.job_id = j.job_id;

-- 3. 직원정보 사원번호, 이름 , 급여, 직무, 직무내용을 출력할때
-- 부서 정보 테이블에서 부서명, 부서장을 출력하시오.
select employee_id, first_name, salary, 
       j.job_id, job_title,
       d.department_id, d.manager_id
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.jobs j on e.job_id = j.job_id;

-- 4. 직원, 성, 급여, 직무, 직무내용을 출력하고 
-- 직무 히스토리 테이블에서 각 직무의 시작일과 마지막일 을 출력하시오.
select e.employee_id, last_name, salary,
       j.job_id, job_title,
       start_date, end_date
from hr.employees e join hr.jobs j
on e.job_id = j.job_id
join hr.job_history jh on e.employee_id = jh.employee_id;

-- 5. 직원, 직무, 부서, 부서명 using 사용하여 출력하시오.
select employee_id, job_id, department_id, department_name
from hr.employees e join hr.departments d
using(department_id);
-- 6.countries 테이블에서 국가번호 와 국가 이름 출력하고
-- regions 테이블에서 국가별 분류번호 와 분류이름을 출력하시오
select country_id, country_name,
       r.region_id, region_name
from hr.countries c join hr.regions r
on c.region_id = r.region_id;

-- 7. 직원번호, 성, 이름, 직무, 부서번호, 지역번호, 직무내용, 주소를 출력
select employee_id, last_name, first_name, e.job_id, e.department_id, d.location_id, job_title, street_address
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.jobs j on j.job_id = e.job_id
join hr.locations l on l.location_id = d.location_id;
-- 8. 커미션이 null인 사람의 부서명을 출력하시오
select department_name 
from hr.departments d join hr.employees e
on d.department_id = e.department_id and e.commission_pct is null;

-- 9. 부서장의 성, 이름, 커미션을 출력하시오.
select last_name, first_name, commission_pct
from hr.employees e join hr.departments d
on e.employee_id = d.manager_id;

-- 10. 부서장을 상사로 둔 직원들의 성, 이름, 이메일을 출력하시오.
select last_name, first_name, email
from hr.employees e join hr.departments d
on e.manager_id = d.manager_id;

-- 11. 직원이 없는 부서를 ansi join 방식으로 출력하시오.
select e.employee_id, d.department_id
from hr.employees e right outer join hr.departments d
on e.department_id = d.department_id
and employee_id is null;

-- 12. 해당 직무의 최저급여를 받는 사원의 정보를 출력하시오
--    사번, 이름, 직무, 급여, 최저급여
select employee_id, first_name, job_id, salary, min(salary)
from hr.employees
group by employee_id, first_name, job_id, salary;

-- 13.부서 위치가 1800인 부서의 국가코드, 국가명, 지역코드, 지역명을 출력하시오
select c.country_id, c.country_name, r.region_id, r.region_name
from hr.departments d join hr.locations l
on d.location_id = l.location_id
join hr.countries c on l.country_id = c.country_id
join hr.regions r on c.region_id = r.region_id;

-- 14. 부서장의 급여가 해당 직무의 최저 급여 이상인 부서장의 정보를 출력하시오
-- 사번, 성, 직무, 부서명, 상사, 급여, 최저급여
select employee_id, last_name, job_id, department_name, d.manager_id, salary, min(salary)
from hr.employees e join hr.departments d
on e.employee_id = d.manager_id
group by employee_id, last_name, job_id, department_name, d.manager_id, salary
having salary >= min(salary);

-- 15. 사번이 201번인 퇴사자와 사번 및 부서번호가 같은 사원의 정보를 출력하시오
--    사번, 이름, 부서번호, 부서명
select * from hr.job_history;
select e.employee_id, first_name, e.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.job_history jh on e.employee_id = jh.employee_id
and e.employee_id = 201;

-- 16. 상사가 부서장인 사원의 이름과 부서명을 출력하시오
select first_name, department_name
from hr.employees e right outer join hr.departments d
on e.manager_id = d.manager_id;

-- 17. 직원들 중 직무가 AD_VP인 사원의 직무내용을 출력하시오.
--    직원 이름, 직원번호, 직업번호, 직무내용 출력
select first_name, employee_id, e.job_id, job_title
from hr.employees e join hr.jobs j
on e.job_id = j.job_id and e.job_id = 'AD_VP';

-- 18. 부서장이 상사인 직원의 부서이름과 최저연봉, 최고연봉을 구하시오.
--    이름, 부서장번호, 부서번호, 최저연봉, 최고연봉 출력
select d.department_id,
min((nvl(commission_pct, 0) + 1) * salary * 12),
max((nvl(commission_pct, 0) + 1) * salary * 12)
from hr.employees e join hr.departments d
on e.manager_id = d.manager_id
group by d.department_id;

select first_name, manager_id, department_id, min((nvl(commission_pct, 0) + 1) * salary * 12),
max((nvl(commission_pct, 0) + 1) * salary * 12)
-- 19. 입사일이 '03/06/17' 이후인 사원들의 부서와 지역번호를 출력
--    사원번호, 이름, 입사일, 부서번호, 부서명, 지역번호 출력
select employee_id, first_name, hire_date, d.department_id, department_name, location_id
from hr.employees e join hr.departments d
on e.department_id = d.department_id and e.hire_date > '03/06/17';

-- 20. 이름이 'Payam' 직원의 퇴사일을 구하시오.
--    사원번호, 이름, 부서번호, 부서이름, 퇴사일을 출력
select e.employee_id, first_name, d.department_id, department_name, end_date
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.job_history jh on e.employee_id = jh.employee_id
and first_name = 'Payam';

-- 21. 사원이 없는 부서의 주소를 출력하세요.
--     부서번호, 부서이름, 주소 출력
select department_id, department_name, street_address
from hr.departments d join hr.locations l
on d.location_id = l.location_id and manager_id is null;

-- 22. 상사가없는 사원의 부서명을 출력해주세요.
select department_name
from hr.departments d join hr.employees e
on d.department_id = e.department_id
and e.manager_id is null;

-- 23. 직원번호, 성, 이름, 직무번호, 직무명을 출력하고 최대급여가 20000이상인 직원을 출력해주세요.
select employee_id, last_name, first_name, e.job_id, job_title
from hr.employees e join hr.jobs j
on e.job_id = j.job_id
group by employee_id, last_name, first_name, e.job_id, job_title
having max(salary) >= 20000;

-- 24. 직원번호, 성, 이름, 부서번호, 지역번호, 우편번호를 출력하는데 우편번호가 없는 직원을 출력해주세요.
select e.employee_id, last_name, first_name, d.department_id, d.location_id, postal_code
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.locations l on d.location_id = l.location_id
where postal_code is null;

-- 25. 부서번호, 부서명, 지역번호, 도시를 출력하고 부서번호가 80인 도시를 출력해주세요
select department_id, department_name, d.location_id, city
from hr.departments d join hr.locations l
on d.location_id = l.location_id
and department_id = 80;

-- 26. 사원번호, 성, 이름, 부서번호, 부서명을 출력하고 이름이 'james'인 사람을 출력(문자함수사용)
select employee_id, last_name, first_name, e.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
and upper(first_name) = upper('james');

-- 27. 성, 이름, 부서번호, 부서명을 출력하고 03년부터 05년까지 오름차순으로 출력해주세요.
select last_name, first_name, e.department_id, department_name, hire_date
from hr.employees e join hr.departments d
on e.department_id = d.department_id
and hire_date between '03/01/01' and '05/12/31'
order by hire_date asc;

-- 28. 직무명, 사원번호, 성, 이름, 급여를 출력하고 급여가 3000에서 5000사이를 구하고 급여를 오름차순으로 나열하세요.
select job_id, employee_id, last_name, first_name, salary
from hr.employees where salary between 3000 and 5000
order by salary asc;

-- 29. 사원번호, 성, 이름, 급여, 부서, 부서명을 출력하고, 
-- 급여가 6000이상인 직원을 내림차순으로 정렬한 다음 이름을 앞에 3글자만 표기하고 나머지는 '*'로 표기하세요.
select employee_id, last_name, rpad(substr(first_name, 1, 3), length(first_name), '*'), salary, e.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
and salary >= 6000
order by salary desc;

-- 30.미국 출신이 아닌 직원의 성, 이름, 직무내용, 국가명, 주소, 우편 번호를 출력
select last_name, first_name, 
       job_title, --employees
       country_name, --countries
       street_address, postal_code   --locations
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.locations l on d.location_id = l.location_id
join hr.countries c on l.country_id = c.country_id
join hr.jobs j on e.job_id = j.job_id
and c.country_id != 'US';