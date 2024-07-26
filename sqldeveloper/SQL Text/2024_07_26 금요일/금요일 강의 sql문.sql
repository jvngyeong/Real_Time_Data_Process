select * from hr.employees;

-- 숫자 함수
select round(15.19345, 3), round(15.19355, 3)
      ,round(145.5553, 2), round(145.5553, 1)
      ,round(145.5553, 0), round(145.5553)
      ,round(145.5553, -1), round(145.5553, -2), round(155.5553, -2)
from dual;

select trunc(15.19345, 3), trunc(15.19355, 3)
      ,trunc(145.5553, 2), trunc(145.5553, 1)
      ,trunc(145.5553, 0), trunc(145.5553)
      ,trunc(145.5553, -1), trunc(145.5553, -2), trunc(155.5553, -2)
from dual;

select mod(salary, 5000)
from hr.employees;

-- 직원의 급여를 5000으로 나눈 나머지가 2000부터 3000사이인 직원들을 구하시오.
select first_name, employee_id, last_name, hire_date, salary, mod(salary, 5000)
from hr.employees
where mod(salary, 5000) between 2000 and 3000;

--직무가 SA_REP인 사원들의 급여를 5000으로 나눈 나머지가 얼마인가.
--사원번호, 이름, 직무, 급여를 같이 출력
select employee_id, first_name, job_id, salary, mod(salary, 5000) from hr.employees
where job_id = 'SA_REP';

-- 2024/07/26
-- 20    24   07    26
-- 세기  연도   월    일

-- 현재 날짜
select sysdate from dual;

select first_name, last_name, salary, job_id, '2024.05.27', sysdate from hr.employees;
--select now()  Mysql에서 사용하는 현재 날짜 출력 함수

--'2024.05.27'은 현재 날짜로부터 얼마나 지났을까
select (sysdate - to_date('2024.05.27')) from dual;

--입사일로부터 현재 날짜까지 얼마나 지났을까
select (sysdate - hire_date) from hr.employees;

--입사일로부터 현재 날짜까지 몇 주가 지났을까
select (sysdate - hire_date)/7 from hr.employees;

--입사일로부터 현재 날짜까지 몇 달이 지났을까
select first_name, salary, job_id, department_id, months_between(sysdate, hire_date) from hr.employees;
--입사한 후 현재까지 몇 년 지났을까
select hire_date, (sysdate - hire_date)/12 from hr.employees;

-- 이번달의 마지막 날은?
select last_day(sysdate) from dual;

-- 입사한 달의 마지막 날은?
select first_name, employee_id, hire_date, last_day(sysdate)
from hr.employees;

-- 입사한 달이 윤년이 사원을 출력하세요.
select * from hr.employees where last_day(hire_date) like '%/02/29';

-- 현재 날짜에서 3개월 후는 언제인가?
select add_months(sysdate, 3) from dual;

-- 입사한 직원이 5달 지난 날짜가 7월인 사원을 구하시오.
select * from hr.employees where add_months(hire_date, 5) Like '%/07/%';

-- 다음 금요일은 몇일일까?
select next_day(sysdate, '금') from dual;

-- 입사한 날에서 다음 금요일이 08월 02일인 직원은?
-- 사원번호, 이름, 직무, 입사일도 같이 출력
select employee_id, first_name, job_id, hire_date from hr.employees where next_day(hire_date, '월') Like '%/08/02';

-- 현재 날짜의 주의 시작일인 일요일의 날짜와 마지막 날짜인 토요일의 날짜를 구하시오.
select sysdate from dual;
select next_day(sysdate-7, '일'), next_day(sysdate-7, '일') + 6 from dual;

-- 직원이 입사한 날이 그 주의 몇 일부터 몇 일 사이에 있는 날인지 출력하세요.
-- 성, 이름, 입사일, 입사한 주의 일요일, 입사한 주의 토요일
select last_name as 성, first_name as 이름, hire_date as 입사일, next_day(hire_date - 7, '일') as "입사한 주의 일요일", next_day(hire_date - 7, '일') + 6 as "입사한 주의 토요일" from hr.employees;

-- 형 변환
select '30' + 30, to_number('30') + 30 from dual;

select '이숭무'||30, concat('이숭무', 30) from dual;

-- 현재 날짜를 내가 원하는 형태로
select to_char(sysdate, 'YY/MM/DD') from dual;
select to_char(sysdate, 'YYYY-MM-DD') from dual;
select to_char(sysdate, 'YYYY-MM-DD hh24:mi:ss PM') from dual;
--  yy-mm-dd인 것을 mm-dd-yy로 출력했으면 좋겠다.
select employee_id, job_id, first_name, to_char(hire_date, 'MM-DD-YY') from hr.employees;
--  yy-mm-dd인 것을 mm-dd-yy 요일로 출력했으면 좋겠다.
select employee_id, job_id, first_name, to_char(hire_date, 'MM-DD-YY dy') from hr.employees;

-- 숫자를 문자로 : 999999 => $999,999
select to_char(123456789, '999,999,999') from dual;
select to_char(123456789, '099,999,999') from dual;
select to_char(123456789, '$099,999,999') from dual;
select to_char(123456789, '099,999,999L') from dual;
select to_char(-23456789, '09,999,999L') from dual;
select to_char(-23456789, 'L09,999,999mi') from dual;

--사원번호, 부서번호, 상사, 입사일, 급여를 출력할 때,
-- 급여를 3자리씩 표시해라
select employee_id, department_id, manager_id, hire_date, trim(to_char(salary, '$999,999,999')) from hr.employees;

select employee_id, department_id, manager_id, hire_date, trim(to_char(salary, '$999,999,999')),
trim(to_char(commission_pct, '999,999,990.999'))
from hr.employees;

-- 20-07-2004년에 입사한 사원을 출력
select * from hr.employees where hire_date = to_date('20-07-2004', 'DD-MM-YYYY');

-- 17/06/03(dd-mm-yy) 이후에 입사한 직원들 출력
select * from hr.employees where hire_date > to_date('17-06-03', 'DD-MM-YY');

-- 17/06/03(dd-mm-yy)의 주는 몇 일부터 몇 일 사이에 있나
select next_day(to_date('17/06/03', 'DD-MM-YY'), '일'), next_day(to_date('17/06/03', 'DD-MM-YY'), '일') + 6 from dual;

-- 사원번호, 이름, 직무, 급여, 커미션, 연봉
select employee_id, first_name, job_id, salary, nvl(commission_pct, 0), nvl((1 + commission_pct)* salary*12, 0) as year_sal from hr.employees;
select employee_id, first_name, job_id, salary, nvl(commission_pct, 0), COALESCE((1 + commission_pct)* salary*12, 0) as year_sal from hr.employees;

select nvl2(null, 10, 20), nvl2(10, 20, 30) from dual;

-- 사원번호, 이름, 직무, 급여, 커미션, 연봉 -- nvl2()
select * from hr.employees;
select employee_id, first_name, job_id, salary, commission_pct
    , salary * (1 + nvl(commission_pct, 0)) * 12 as year_sal1
    , salary * nvl2(commission_pct, 1 + commission_pct, 1) * 12 as year_sal2
    , salary * (1 + coalesce(commission_pct, 0)) * 12 as year_sal3
from hr.employees;

-- nullif
select nullif(1,1), nullif(1,2) from dual;

-- 이름과 성의 길이가 같은 사람만 출력하시오
select first_name, last_name, length(first_name), length(last_name) from hr.employees where nullif( length(first_name), length(last_name)) is null;

-- 조건문 : CASE, DECODE
-- 'IT_PROG'이면 급여를 10% 더 주고,
-- 'ST_CLERK'이면 급여를 15%더 주고
-- 'SA_REP'이면 급여를 20% 더 준다.
-- 나머지는 급여 그대로
SELECT LAST_NAME, JOB_ID, SALARY,
    CASE JOB_ID WHEN 'IT_PROG' THEN salary * 1.1
                WHEN 'ST_CLERK' THEN salary * 1.15
                WHEN 'SA_REP' THEN SALARY * 1.2
                else salary end as money from hr.employees;

SELECT LAST_NAME, JOB_ID, SALARY,
    CASE WHEN JOB_ID = 'IT_PROG' THEN salary * 1.1
         WHEN JOB_ID = 'ST_CLERK' THEN salary * 1.15
         WHEN JOB_ID = 'SA_REP' THEN SALARY * 1.2
    else salary end as money from hr.employees;     

--급여가 5000 이하면 low를 10000이하면 'Medium' 20000이하면 'Good'
-- 그 이상이면 'Excellent'가 출력되게 하세요.
select first_name,
    case when salary <= 5000 then 'low'
         when salary <= 10000 then 'Medium'
         when salary <= 20000 then 'Good'
         else 'Excellent' end as sal
from hr.employees;

-- salary / 2000 나눈 값의 몫이 0이면 0
--                       몫이 1이면 0.09
--                       몫이 2이면 0.20
--                       몫이 3이면 0.30
--                       몫이 4이면 0.40
--                       아니면 0.5
select salary, case trunc(salary / 2000) when 0 then 0
                                  when 1 then 0.09
                                  when 2 then 0.20
                                  when 3 then 0.30
                                  when 4 then 0.40
                                  else 0.5 end as "출력" 
from hr.employees;

select salary, decode (trunc(salary / 2000) ,0 ,0 
                                            ,1 ,0.09
                                            ,2 ,0.20
                                            ,3 ,0.30
                                            ,4 ,0.40
                                            ,0.50) as "출력" 
from hr.employees;
                                  
SELECT LAST_NAME, JOB_ID, SALARY,
    decode (JOB_ID , 'IT_PROG' , salary * 1.1
                , 'ST_CLERK' , salary * 1.15
                , 'SA_REP' , SALARY * 1.2
                , salary) as money from hr.employees;