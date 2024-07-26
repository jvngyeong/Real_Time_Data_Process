select * from hr.employees;

select * from hr.employees;

select * from hr.departments;

select department_id, department_name, manager_id, location_id from hr.departments;

select department_name, manager_id from hr.departments;

select manager_id,department_name from hr.departments;

select * from hr.departments;

-- 리터럴 출력
select manager_id, department_id, 30, '이숭무' from hr.departments;

select * from hr.employees;

select employee_id, first_name, salary, 30, salary+ 30, manager_id from hr.employees;

select employee_id, first_name, salary * 12, salary from hr.employees;

select employee_id, first_name, (salary+100) * 12 from hr.employees;

select null*10 from dual; -- 알 수 없는 값이다.

select employee_id, last_name, hire_date, salary, commission_pct, department_id from hr.employees;

---각 사원의 커미션이 얼마인지 출력하세요
select employee_id, last_name, hire_date, salary, commission_pct, salary * commission_pct, department_id from hr.employees;

-- 사원번호, 이름, 성, 급여, 커미션, 커미션을 포함한 연봉도 같이 출력하시오.
select employee_id,last_name, first_name, salary, commission_pct, ((salary * commission_pct) + salary) * 12 from hr.employees;

-- alias
select employee_id,last_name, first_name, salary, commission_pct, ((salary * commission_pct) + salary) * 12 돈 from hr.employees;

-- 대소문자로 heading name 출력
select employee_id,last_name, first_name, salary, commission_pct comm, ((salary * commission_pct) + salary) * 12 "Year_Sal" from hr.employees;

-- heading name에 공백문자 포함
select employee_id,last_name, first_name, salary, commission_pct comm , ((salary * commission_pct) + salary) * 12 "Year _ Sal" from hr.employees;

--별칭에 as 추가
select employee_id,last_name, first_name, salary, commission_pct comm , ((salary * commission_pct) + salary) * 12 as "Year _ Sal" from hr.employees;

--연결연산자
select last_name, job_id, employee_id, salary, last_name || job_id from hr.employees;

--문자열 리터럴
select last_name, 'is a ',job_id, employee_id, salary, last_name || ' is a ' || job_id from hr.employees;

--100의 이름은 King이고 직무는 AD_PRES 입니다.
select employee_id || '의 이름은 ' || last_name || '이고,  직무는 ' || job_id || '입니다.' employee from hr.employees;

--king 1달의 월급은 = 24000
select last_name || '의 1달의 월급은 = ' || salary king from hr.employees;


select * from hr.departments;
-- Administration의 manager는 200입니다.
select department_name || '의 manager는 ' || manager_id || '입니다.' manager from hr.departments;
-- Administration department's manager_id 200
select department_name || 'department''s manager_id' || manager_id from hr.departments;
select department_name || q'[ department's manager_id]' || manager_id from hr.departments;

--중복 행 제거
select last_name, salary, job_id, department_id from hr.employees;
select distinct department_id from hr.employees;

select distinct department_id, job_id from hr.employees;

--table 정보 확인
desc hr.employees;  --describe

--1. 부서에서 급여가 같은 사원의 정보를 한 번만 출력할 때, 부서와 급여만 출력하세요
select distinct job_id as "부서", salary as "급여" from hr.employees;
--2. 입사일이 같고 직무가 같은 사원 정보를 한 번만 출력하세요. 입사일과 직무만 출력
select distinct hire_date as "입사일", job_id as "직무" from hr.employees;

--사원번호기 100인 사원을 출력
select * from hr.employees;
select * from hr.employees where employee_id = 100;
select * from hr.employees where EMPLOYEE_ID = 100;

select employee_id, first_name, salary, job_id from hr.employees where job_id = 'FI_Account'; --selection할 때, 리터럴은 대소문자를 구분함.
-- yy/mm/dd
select * from hr.employees;

--입사일이 07/02/07 인 사원들을 출력하시오.
select * from hr.employees where hire_date = '07/02/07';
select * from hr.employees where hire_date = '07.02.07';
select * from hr.employees where hire_date = '07-02-07';

--사장보다 먼저 입사한 직원들은
select * from hr.employees where employee_id = 100;
select * from hr.employees where hire_date < '03/06/17';

--급여가 3000달러 이상인 사원을 출력하세요
select * from hr.employees where salary >= 3000;

--사원 번호, 성, 급여, 직무를 출력하는데, 급여의 행 이름을 sal로 한다.
--이떄 급여가 3000이상인 사람만 출력
select employee_id, first_name, salary as sal, job_id from hr.employees where salary >= 3000;

--급여가 2500부터 4000 사이인 사원 출력
select * from hr.employees where 4000 >= salary and salary >= 2500;

--50, 70, 90인 부서의 직원을 출력하시오.
select * from hr.employees where department_id = 50 or department_id = 70 or department_id = 90;
select * from hr.employees where department_id in (50, 70, 90);

-- 직원 이름이 'Vance'인 직원과 90인 부서의 직원을 출력하시오.
select * from hr.employees where first_name = 'Vance' or department_id = 90;

-- 성 이름이 'Hartstein', 'Vargas'인 사원들을 출력하시오.
select * from hr.employees where last_name in ( 'Hartstein', 'Vargas' );

--100, 101, 201인 상사(manager_id)를 둔 직원들을 모두 출력하시오.
select * from hr.employees where manager_id in (100, 101, 201);
--100, 101, 201인 상사(manager_id)가 아닌 직원들을 모두 출력하시오.
select * from hr.employees where manager_id not in (100, 101, 201);
--50인 부서와 60인 부서와 70인 부서의 직원을 구하시오
select * from hr.employees where department_id in(50,60,70);
select * from hr.employees where department_id between 50 and 70;
--50인 부서와 60인 부서와 70인 부서가 아닌 직원을 구하시오
select * from hr.employees where department_id not in(50,60,70);
select * from hr.employees where department_id not between 50 and 70;
--03/05/17. 01/01/13, 07/03/17에 입사한 직원들을 출력하시오.
select * from hr.employees where hire_date in('03.06.17', '01.01.13', '07.03.17');
--03/05/17. 01/01/13, 07/03/17에 입사가 아닌 직원들을 출력하시오.
select * from hr.employees where hire_date not in('03.06.17', '01.01.13', '07.03.17');
--급여가 3000미만이고 10000을 초과한 직원들을 출력하시오.
select * from hr.employees where salary not between 3000 and 10000;
select * from hr.employees where salary < 3000 or salary > 10000;
--부서가 없는 직원을 출력하시오.
select * from hr.employees where department_id is null;
--부서를 가진 직원을 출력
select * from hr.employees where department_id is not null;
--성이 'K'로 시작하는 모든 직원을 출력
select * from hr.employees where last_name like 'K%';
--성이 'K'로 끝나는 모든 직원을 출력
select * from hr.employees where last_name like '%K';
--성이 'K'를 포함하는 모든 직원을 출력 : K%, %K, %K%
select * from hr.employees where last_name like '%K%';
--성에 in이 포함된 직원들을 출력
select * from hr.employees where last_name like '%in%';
--성의 첫 글자는 아무 문자나 관계없지만, 두 번째 글자는 'u'가 오는 직원들을 출력
select * from hr.employees where last_name like '_u%';
--성의 세 번째 글자에 's'가 오는 직원들 출력
select * from hr.employees where last_name like '__s%';
--성의 뒤에서 두 번째 글자가 'i'인 직원들 출력
select * from hr.employees where last_name like '%i_';
--성에 u와 i사이에 한 글자를 포함하는 사원들을 출력
select * from hr.employees where last_name like '%u_i%';

select job_id from hr.employees;

--직무가 AC_로 시작하는 직원 출력
select * from hr.employees where job_id like 'AC\_%' escape '\';

--직무가 D_P인 사원들을 출력하시오.
select * from hr.employees where job_id like '%D\_P%' escape '\';