--------------------------- 수요일 강의 리뷰 ---------------------------
select * from hr.employees; -- select문 기본 출력

select * from hr.departments;
select department_id, location_id from hr.departments; -- Projection

select salary, 300 from hr.employees;   -- 리터럴이 모든 행에 적용되는 것을 확인
select first_name, salary, salary + 300 from hr.employees;   -- 산술식

select first_name, salary * 12 from hr.employees;   -- 연봉 구하기
select first_name, (salary + 300) * 12 from hr.employees;   -- 매달 300달러를 추가해서 연봉 구하기 (연산자 우선순위)

-- null : 알 수 없는 값. null + 100 = null
select null + 100 from dual;    -- table을 사용하지 않을 경우에는 dual 사용!
select first_name, salary, commission_pct, salary * commission_pct, department_id, job_id
from hr.employees;  -- null * 값 예제

select first_name, salary, commission_pct, salary * commission_pct as Year_Sal, department_id, job_id
from hr.employees;  -- Column명(Heading name) 설정 예제

select '이숭무', '이상범' from dual;      -- 일반 출력
select '이숭무' || '이상범' from dual;    -- 연결 연산자 ||
select first_name || ' : ' || last_name as name from hr.employees;  -- 연결 연산자 || 2

select '준경''s cup' from dual;   -- 따옴표 출력 예제

select DISTINCT department_id from hr.employees;    -- DISTINCT를 활용한 중복 제거
select DISTINCT department_id, job_id from hr.employees;    -- DISTINCT를 활용한 중복 제거 2

desc hr.employees;  -- 테이블 구조 출력 desc
describe hr.departments; -- 테이블 구조 출력 describe

select * from hr.employees where employee_id = 100; -- Selection
select * from hr.employees where employee_id in (100, 105, 110);    -- in 예제
select first_name, salary from hr.employees where employee_id in (100, 105, 110);    -- Selection & Projection
select * from hr.employees where salary between 12000 and 24000;   -- between 예제
select * from hr.employees where salary >= 18000;   -- 비교 연산자 예제
---------------------------------------------------------------------

-- 1. 사원번호(EMPLOYEE_ID), 성(LAST_NAME), 직무(JOB_ID), 급여(SALARY)를 출력할 때,
-- 급여가 10000 이상이고, 직무가 'MK_MAN'인 사원을 출력하시오.
select employee_id, last_name, job_id, salary from hr.employees
where salary >= 10000 and job_id = 'MK_MAN';
select employee_id, last_name, job_id, salary from hr.employees
where salary >= 10000 and job_id LIKE '%MAN';   -- 응용 1
select employee_id, last_name, job_id, salary from hr.employees
where salary >= 10000 and job_id LIKE '%MAN%';  -- 응용 2

-- 우선 순위 규칙 : AND => OR
select last_name, job_id, salary from hr.employees
where job_id = 'SA_REP' or job_id = 'AD_PRES' and salary > 15000;
select last_name, job_id, salary from hr.employees
where (job_id = 'SA_REP' or job_id = 'AD_PRES') and salary > 15000;

-- 정렬 : Asceding(오름차순), Desceding(내림차순)
select * from hr.employees;
select * from hr.employees order by employee_id asc;    -- asc는 생략할 수 있다!!
select * from hr.employees order by employee_id desc;

-- 입사일 빠른 사원부터 출력
select * from hr.employees order by hire_date asc;

select last_name, job_id as jobs, department_id, hire_date from hr.employees
where jobs = 'SA_REP';  -- Where 절에는 별칭을 사용할 수 없다.

select last_name, job_id as jobs, department_id, hire_date from hr.employees
order by jobs;  -- order by 절에는 별칭을 사용할 수 있다.

--          1           2               3            4
select last_name, job_id as jobs, department_id, hire_date from hr.employees
order by 2; -- order by 절에는 index 번호를 사용할 수 있다.

-- 2. 사번, 이름, 연봉을 출력할 때, 연봉이 낮은 사람부터 출력하시오.
select job_id, first_name, salary * 12 from hr.employees order by salary*12;

-- 3. 이름, 부서번호, 급여를 출력하는데 부서번호는 오름차순을 하고, 같은 부서의 있는 직원의
-- 급여는 내림차순으로 정렬하여 출력하시오.
select first_name, department_id, salary from hr.employees 
order by department_id asc, salary desc;

-- 4. 80인 부서의 직원의 사원번호, 이름, 부서번호, 입사일을 출력할 때 입사일이 높은 사람부터 출력
select employee_id, first_name, department_id, hire_date from hr.employees where department_id = 80
order by hire_date desc;

-- 5. 사원번호, 이름, 직무, 입사일, 급여, 부서번호를 출력할 때, 입사일이 02/08/17 이후인 사원을
-- 입사일이 빠른 직원부터 출력할 때 입사일이 같은 직원의 급여는 많이 받는 직원부터 출력
select employee_id, first_name, job_id, hire_date, salary, department_id from hr.employees where hire_date > '02/08/17'
order by hire_date asc, salary desc;

-- 대소문자 변환 함수 사용
select last_name, upper(last_name) from hr.employees;

-- Abel : 성
select first_name, last_name, employee_id, salary
from hr.employees
where last_name LIKE INITCAP('abel');
select first_name, last_name, employee_id, salary
from hr.employees
where last_name LIKE INITCAP('ABEL');
select first_name, last_name, employee_id, salary
from hr.employees
where lower(last_name) LIKE 'abel'; -- 조건절에도 함수를 사용 가능!!
select first_name, last_name, employee_id, salary
from hr.employees
where upper(last_name) LIKE 'ABEL'; -- 조건절에도 함수를 사용 가능!!

-- 직원 사원번호, 성, 이름, 급여를 출력할 때 성과 이름은 붙여서 출력하시오
select employee_id, last_name || ' ' || first_name, salary from hr.employees;
select employee_id, concat(last_name, first_name), salary from hr.employees;
-- 직원 사원번호, 성, 이름, 급여를 출력할 때 성과 급여는 붙여서 출력하시오
select employee_id, first_name, last_name || salary from hr.employees;
select employee_id, first_name, 
concat(last_name, salary) from hr.employees; -- 파이프로 자동형변환이 안되는 경우가 있으니 concat 사용

-- 성이 문자의 갯수가 5 이상인 직원들만 출력
select * from hr.employees where length(last_name) >= 5;

-- 자르기
select 'HelloWorld' from dual;
select substr('HelloWorld', 6, 2) from dual;    -- Wo
select substr('HelloWorld', 1, 5) from dual;    -- Hello
select substr('HelloWorld', -1, 2) from dual;    -- d
select substr('HelloWorld', -4, 1) from dual;    -- o
select substr('HelloWorld', -4, 4) from dual;    -- orld
select substr('HelloWorld', 7, 4) from dual;    -- orld

--부서명을 2번째부터 5글자만 출력하시오.
select department_name, substr(department_name, 2, 5) from hr.departments;

-- 직무가 4번째 글자부터 2글자가 'PR'인 직무를 가진 직원들을 출력하시오
select * from hr.employees where substr(job_id, 4, 2) = 'PR';

-- 사원번호, 성, 이름, 급여를 출력할 때 성에 's'가 있는 경우 's'의 index를 출력하세요.
select employee_id, last_name, first_name, salary, instr(last_name, 's') from hr.employees;

-- 사원번호, 성, 이름, 급여를 출력할 때 성에 's'가 있는 위치부터 2글자를 출력하세요.
select employee_id, last_name, first_name, salary, substr(last_name,  instr(last_name, 's'), 2) from hr.employees where last_name LIKE '%s%';

-- 1. 이름에서 's'의 index가 3인 직원들을 출력하시오.
select * from hr.employees where instr(last_name, 's') = 3;

-- 2. 사원번호, 성, 이름, 급여를 출력할 때, 이름은 3번째부터 마지막글자까지 출력하시오.
select employee_id, last_name, substr(first_name, 3), salary from hr.employees;

-- instr
select instr('HelloWorld', 'o') from dual;  -- 첫 번째 만나는 o를 반환
select instr('HelloWorld', 'o', 6) from dual;
select instr('HelloWorld', 'o', instr('HelloWorld', 'o') + 1) as result from dual;
select instr('HelloWorld', 'o', -1) from dual;
select instr('HelloWorld', 'z', 6) from dual;
select instr('HelloWorld', 'World') from dual;  -- 문자열의 첫 번째 글자를 반환

-- lpad
select lpad('hello', 10, '*') from dual;
select rpad(substr('highland0', 1, 4), length('highland0'), '*') from dual;
select rpad('hello', 10, '*') from dual;
select lpad(substr('highland0', 5, 8), length('highland0'), '*') from dual;

-- 사번, 이름의 3글자만 출력하고 나머지 뒤에는 별표, 급여, 직무를 출력
select rpad(substr(first_name, 1, 3), length(first_name), '*'), 
salary, job_id from hr.employees;

--' Steven '
select * from hr.employees where first_name LIKE trim('  Steven  ');
select trim('  Steven   ') from dual;
select ltrim('  Steven   ') from dual;
select rtrim('  Steven   ') from dual;

--'JACK and JUE'에서 'J'를 'BL'로 변경하시오.
select replace('JACK and JUE', 'J', 'BL') from dual;

-- 사원번호, 이름, 급여, 직무, 부서번호를 출력할 때 직무의 _AS를 abc로 변경해서 출력
-- 직무에 _AS가 포함된 직원만 출력하시오.
select employee_id, first_name, salary, replace(job_id, '\_AS', 'abc'), department_id
from hr.employees where job_id LIKE '%\_AS%' escape '\';

-- 010-7146-1970, 010-****-1970
-- 02-314-1970, 02-***-1970
select rpad(substr('010-7146-1970', 1, instr('010-7146-1970', '-', 1))
, length(substr('010-7146-1970', 1, instr('010-7146-1970', '-', -1))) - 1
, '*'
)
 || substr('010-7146-1970', instr('010-7146-1970', '-', -1), instr('010-7146-1970', '-', 1) + 1)
from dual;