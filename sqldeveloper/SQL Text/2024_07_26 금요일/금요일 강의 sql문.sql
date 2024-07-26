select * from hr.employees;

-- ���� �Լ�
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

-- ������ �޿��� 5000���� ���� �������� 2000���� 3000������ �������� ���Ͻÿ�.
select first_name, employee_id, last_name, hire_date, salary, mod(salary, 5000)
from hr.employees
where mod(salary, 5000) between 2000 and 3000;

--������ SA_REP�� ������� �޿��� 5000���� ���� �������� ���ΰ�.
--�����ȣ, �̸�, ����, �޿��� ���� ���
select employee_id, first_name, job_id, salary, mod(salary, 5000) from hr.employees
where job_id = 'SA_REP';

-- 2024/07/26
-- 20    24   07    26
-- ����  ����   ��    ��

-- ���� ��¥
select sysdate from dual;

select first_name, last_name, salary, job_id, '2024.05.27', sysdate from hr.employees;
--select now()  Mysql���� ����ϴ� ���� ��¥ ��� �Լ�

--'2024.05.27'�� ���� ��¥�κ��� �󸶳� ��������
select (sysdate - to_date('2024.05.27')) from dual;

--�Ի��Ϸκ��� ���� ��¥���� �󸶳� ��������
select (sysdate - hire_date) from hr.employees;

--�Ի��Ϸκ��� ���� ��¥���� �� �ְ� ��������
select (sysdate - hire_date)/7 from hr.employees;

--�Ի��Ϸκ��� ���� ��¥���� �� ���� ��������
select first_name, salary, job_id, department_id, months_between(sysdate, hire_date) from hr.employees;
--�Ի��� �� ������� �� �� ��������
select hire_date, (sysdate - hire_date)/12 from hr.employees;

-- �̹����� ������ ����?
select last_day(sysdate) from dual;

-- �Ի��� ���� ������ ����?
select first_name, employee_id, hire_date, last_day(sysdate)
from hr.employees;

-- �Ի��� ���� ������ ����� ����ϼ���.
select * from hr.employees where last_day(hire_date) like '%/02/29';

-- ���� ��¥���� 3���� �Ĵ� �����ΰ�?
select add_months(sysdate, 3) from dual;

-- �Ի��� ������ 5�� ���� ��¥�� 7���� ����� ���Ͻÿ�.
select * from hr.employees where add_months(hire_date, 5) Like '%/07/%';

-- ���� �ݿ����� �����ϱ�?
select next_day(sysdate, '��') from dual;

-- �Ի��� ������ ���� �ݿ����� 08�� 02���� ������?
-- �����ȣ, �̸�, ����, �Ի��ϵ� ���� ���
select employee_id, first_name, job_id, hire_date from hr.employees where next_day(hire_date, '��') Like '%/08/02';

-- ���� ��¥�� ���� �������� �Ͽ����� ��¥�� ������ ��¥�� ������� ��¥�� ���Ͻÿ�.
select sysdate from dual;
select next_day(sysdate-7, '��'), next_day(sysdate-7, '��') + 6 from dual;

-- ������ �Ի��� ���� �� ���� �� �Ϻ��� �� �� ���̿� �ִ� ������ ����ϼ���.
-- ��, �̸�, �Ի���, �Ի��� ���� �Ͽ���, �Ի��� ���� �����
select last_name as ��, first_name as �̸�, hire_date as �Ի���, next_day(hire_date - 7, '��') as "�Ի��� ���� �Ͽ���", next_day(hire_date - 7, '��') + 6 as "�Ի��� ���� �����" from hr.employees;

-- �� ��ȯ
select '30' + 30, to_number('30') + 30 from dual;

select '�̼���'||30, concat('�̼���', 30) from dual;

-- ���� ��¥�� ���� ���ϴ� ���·�
select to_char(sysdate, 'YY/MM/DD') from dual;
select to_char(sysdate, 'YYYY-MM-DD') from dual;
select to_char(sysdate, 'YYYY-MM-DD hh24:mi:ss PM') from dual;
--  yy-mm-dd�� ���� mm-dd-yy�� ��������� ���ڴ�.
select employee_id, job_id, first_name, to_char(hire_date, 'MM-DD-YY') from hr.employees;
--  yy-mm-dd�� ���� mm-dd-yy ���Ϸ� ��������� ���ڴ�.
select employee_id, job_id, first_name, to_char(hire_date, 'MM-DD-YY dy') from hr.employees;

-- ���ڸ� ���ڷ� : 999999 => $999,999
select to_char(123456789, '999,999,999') from dual;
select to_char(123456789, '099,999,999') from dual;
select to_char(123456789, '$099,999,999') from dual;
select to_char(123456789, '099,999,999L') from dual;
select to_char(-23456789, '09,999,999L') from dual;
select to_char(-23456789, 'L09,999,999mi') from dual;

--�����ȣ, �μ���ȣ, ���, �Ի���, �޿��� ����� ��,
-- �޿��� 3�ڸ��� ǥ���ض�
select employee_id, department_id, manager_id, hire_date, trim(to_char(salary, '$999,999,999')) from hr.employees;

select employee_id, department_id, manager_id, hire_date, trim(to_char(salary, '$999,999,999')),
trim(to_char(commission_pct, '999,999,990.999'))
from hr.employees;

-- 20-07-2004�⿡ �Ի��� ����� ���
select * from hr.employees where hire_date = to_date('20-07-2004', 'DD-MM-YYYY');

-- 17/06/03(dd-mm-yy) ���Ŀ� �Ի��� ������ ���
select * from hr.employees where hire_date > to_date('17-06-03', 'DD-MM-YY');

-- 17/06/03(dd-mm-yy)�� �ִ� �� �Ϻ��� �� �� ���̿� �ֳ�
select next_day(to_date('17/06/03', 'DD-MM-YY'), '��'), next_day(to_date('17/06/03', 'DD-MM-YY'), '��') + 6 from dual;

-- �����ȣ, �̸�, ����, �޿�, Ŀ�̼�, ����
select employee_id, first_name, job_id, salary, nvl(commission_pct, 0), nvl((1 + commission_pct)* salary*12, 0) as year_sal from hr.employees;
select employee_id, first_name, job_id, salary, nvl(commission_pct, 0), COALESCE((1 + commission_pct)* salary*12, 0) as year_sal from hr.employees;

select nvl2(null, 10, 20), nvl2(10, 20, 30) from dual;

-- �����ȣ, �̸�, ����, �޿�, Ŀ�̼�, ���� -- nvl2()
select * from hr.employees;
select employee_id, first_name, job_id, salary, commission_pct
    , salary * (1 + nvl(commission_pct, 0)) * 12 as year_sal1
    , salary * nvl2(commission_pct, 1 + commission_pct, 1) * 12 as year_sal2
    , salary * (1 + coalesce(commission_pct, 0)) * 12 as year_sal3
from hr.employees;

-- nullif
select nullif(1,1), nullif(1,2) from dual;

-- �̸��� ���� ���̰� ���� ����� ����Ͻÿ�
select first_name, last_name, length(first_name), length(last_name) from hr.employees where nullif( length(first_name), length(last_name)) is null;

-- ���ǹ� : CASE, DECODE
-- 'IT_PROG'�̸� �޿��� 10% �� �ְ�,
-- 'ST_CLERK'�̸� �޿��� 15%�� �ְ�
-- 'SA_REP'�̸� �޿��� 20% �� �ش�.
-- �������� �޿� �״��
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

--�޿��� 5000 ���ϸ� low�� 10000���ϸ� 'Medium' 20000���ϸ� 'Good'
-- �� �̻��̸� 'Excellent'�� ��µǰ� �ϼ���.
select first_name,
    case when salary <= 5000 then 'low'
         when salary <= 10000 then 'Medium'
         when salary <= 20000 then 'Good'
         else 'Excellent' end as sal
from hr.employees;

-- salary / 2000 ���� ���� ���� 0�̸� 0
--                       ���� 1�̸� 0.09
--                       ���� 2�̸� 0.20
--                       ���� 3�̸� 0.30
--                       ���� 4�̸� 0.40
--                       �ƴϸ� 0.5
select salary, case trunc(salary / 2000) when 0 then 0
                                  when 1 then 0.09
                                  when 2 then 0.20
                                  when 3 then 0.30
                                  when 4 then 0.40
                                  else 0.5 end as "���" 
from hr.employees;

select salary, decode (trunc(salary / 2000) ,0 ,0 
                                            ,1 ,0.09
                                            ,2 ,0.20
                                            ,3 ,0.30
                                            ,4 ,0.40
                                            ,0.50) as "���" 
from hr.employees;
                                  
SELECT LAST_NAME, JOB_ID, SALARY,
    decode (JOB_ID , 'IT_PROG' , salary * 1.1
                , 'ST_CLERK' , salary * 1.15
                , 'SA_REP' , SALARY * 1.2
                , salary) as money from hr.employees;