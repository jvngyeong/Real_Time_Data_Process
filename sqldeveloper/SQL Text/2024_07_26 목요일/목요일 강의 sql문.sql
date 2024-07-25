--------------------------- ������ ���� ���� ---------------------------
select * from hr.employees; -- select�� �⺻ ���

select * from hr.departments;
select department_id, location_id from hr.departments; -- Projection

select salary, 300 from hr.employees;   -- ���ͷ��� ��� �࿡ ����Ǵ� ���� Ȯ��
select first_name, salary, salary + 300 from hr.employees;   -- �����

select first_name, salary * 12 from hr.employees;   -- ���� ���ϱ�
select first_name, (salary + 300) * 12 from hr.employees;   -- �Ŵ� 300�޷��� �߰��ؼ� ���� ���ϱ� (������ �켱����)

-- null : �� �� ���� ��. null + 100 = null
select null + 100 from dual;    -- table�� ������� ���� ��쿡�� dual ���!
select first_name, salary, commission_pct, salary * commission_pct, department_id, job_id
from hr.employees;  -- null * �� ����

select first_name, salary, commission_pct, salary * commission_pct as Year_Sal, department_id, job_id
from hr.employees;  -- Column��(Heading name) ���� ����

select '�̼���', '�̻��' from dual;      -- �Ϲ� ���
select '�̼���' || '�̻��' from dual;    -- ���� ������ ||
select first_name || ' : ' || last_name as name from hr.employees;  -- ���� ������ || 2

select '�ذ�''s cup' from dual;   -- ����ǥ ��� ����

select DISTINCT department_id from hr.employees;    -- DISTINCT�� Ȱ���� �ߺ� ����
select DISTINCT department_id, job_id from hr.employees;    -- DISTINCT�� Ȱ���� �ߺ� ���� 2

desc hr.employees;  -- ���̺� ���� ��� desc
describe hr.departments; -- ���̺� ���� ��� describe

select * from hr.employees where employee_id = 100; -- Selection
select * from hr.employees where employee_id in (100, 105, 110);    -- in ����
select first_name, salary from hr.employees where employee_id in (100, 105, 110);    -- Selection & Projection
select * from hr.employees where salary between 12000 and 24000;   -- between ����
select * from hr.employees where salary >= 18000;   -- �� ������ ����
---------------------------------------------------------------------

-- 1. �����ȣ(EMPLOYEE_ID), ��(LAST_NAME), ����(JOB_ID), �޿�(SALARY)�� ����� ��,
-- �޿��� 10000 �̻��̰�, ������ 'MK_MAN'�� ����� ����Ͻÿ�.
select employee_id, last_name, job_id, salary from hr.employees
where salary >= 10000 and job_id = 'MK_MAN';
select employee_id, last_name, job_id, salary from hr.employees
where salary >= 10000 and job_id LIKE '%MAN';   -- ���� 1
select employee_id, last_name, job_id, salary from hr.employees
where salary >= 10000 and job_id LIKE '%MAN%';  -- ���� 2

-- �켱 ���� ��Ģ : AND => OR
select last_name, job_id, salary from hr.employees
where job_id = 'SA_REP' or job_id = 'AD_PRES' and salary > 15000;
select last_name, job_id, salary from hr.employees
where (job_id = 'SA_REP' or job_id = 'AD_PRES') and salary > 15000;

-- ���� : Asceding(��������), Desceding(��������)
select * from hr.employees;
select * from hr.employees order by employee_id asc;    -- asc�� ������ �� �ִ�!!
select * from hr.employees order by employee_id desc;

-- �Ի��� ���� ������� ���
select * from hr.employees order by hire_date asc;

select last_name, job_id as jobs, department_id, hire_date from hr.employees
where jobs = 'SA_REP';  -- Where ������ ��Ī�� ����� �� ����.

select last_name, job_id as jobs, department_id, hire_date from hr.employees
order by jobs;  -- order by ������ ��Ī�� ����� �� �ִ�.

--          1           2               3            4
select last_name, job_id as jobs, department_id, hire_date from hr.employees
order by 2; -- order by ������ index ��ȣ�� ����� �� �ִ�.

-- 2. ���, �̸�, ������ ����� ��, ������ ���� ������� ����Ͻÿ�.
select job_id, first_name, salary * 12 from hr.employees order by salary*12;

-- 3. �̸�, �μ���ȣ, �޿��� ����ϴµ� �μ���ȣ�� ���������� �ϰ�, ���� �μ��� �ִ� ������
-- �޿��� ������������ �����Ͽ� ����Ͻÿ�.
select first_name, department_id, salary from hr.employees 
order by department_id asc, salary desc;

-- 4. 80�� �μ��� ������ �����ȣ, �̸�, �μ���ȣ, �Ի����� ����� �� �Ի����� ���� ������� ���
select employee_id, first_name, department_id, hire_date from hr.employees where department_id = 80
order by hire_date desc;

-- 5. �����ȣ, �̸�, ����, �Ի���, �޿�, �μ���ȣ�� ����� ��, �Ի����� 02/08/17 ������ �����
-- �Ի����� ���� �������� ����� �� �Ի����� ���� ������ �޿��� ���� �޴� �������� ���
select employee_id, first_name, job_id, hire_date, salary, department_id from hr.employees where hire_date > '02/08/17'
order by hire_date asc, salary desc;

-- ��ҹ��� ��ȯ �Լ� ���
select last_name, upper(last_name) from hr.employees;

-- Abel : ��
select first_name, last_name, employee_id, salary
from hr.employees
where last_name LIKE INITCAP('abel');
select first_name, last_name, employee_id, salary
from hr.employees
where last_name LIKE INITCAP('ABEL');
select first_name, last_name, employee_id, salary
from hr.employees
where lower(last_name) LIKE 'abel'; -- ���������� �Լ��� ��� ����!!
select first_name, last_name, employee_id, salary
from hr.employees
where upper(last_name) LIKE 'ABEL'; -- ���������� �Լ��� ��� ����!!

-- ���� �����ȣ, ��, �̸�, �޿��� ����� �� ���� �̸��� �ٿ��� ����Ͻÿ�
select employee_id, last_name || ' ' || first_name, salary from hr.employees;
select employee_id, concat(last_name, first_name), salary from hr.employees;
-- ���� �����ȣ, ��, �̸�, �޿��� ����� �� ���� �޿��� �ٿ��� ����Ͻÿ�
select employee_id, first_name, last_name || salary from hr.employees;
select employee_id, first_name, 
concat(last_name, salary) from hr.employees; -- �������� �ڵ�����ȯ�� �ȵǴ� ��찡 ������ concat ���

-- ���� ������ ������ 5 �̻��� �����鸸 ���
select * from hr.employees where length(last_name) >= 5;

-- �ڸ���
select 'HelloWorld' from dual;
select substr('HelloWorld', 6, 2) from dual;    -- Wo
select substr('HelloWorld', 1, 5) from dual;    -- Hello
select substr('HelloWorld', -1, 2) from dual;    -- d
select substr('HelloWorld', -4, 1) from dual;    -- o
select substr('HelloWorld', -4, 4) from dual;    -- orld
select substr('HelloWorld', 7, 4) from dual;    -- orld

--�μ����� 2��°���� 5���ڸ� ����Ͻÿ�.
select department_name, substr(department_name, 2, 5) from hr.departments;

-- ������ 4��° ���ں��� 2���ڰ� 'PR'�� ������ ���� �������� ����Ͻÿ�
select * from hr.employees where substr(job_id, 4, 2) = 'PR';

-- �����ȣ, ��, �̸�, �޿��� ����� �� ���� 's'�� �ִ� ��� 's'�� index�� ����ϼ���.
select employee_id, last_name, first_name, salary, instr(last_name, 's') from hr.employees;

-- �����ȣ, ��, �̸�, �޿��� ����� �� ���� 's'�� �ִ� ��ġ���� 2���ڸ� ����ϼ���.
select employee_id, last_name, first_name, salary, substr(last_name,  instr(last_name, 's'), 2) from hr.employees where last_name LIKE '%s%';

-- 1. �̸����� 's'�� index�� 3�� �������� ����Ͻÿ�.
select * from hr.employees where instr(last_name, 's') = 3;

-- 2. �����ȣ, ��, �̸�, �޿��� ����� ��, �̸��� 3��°���� ���������ڱ��� ����Ͻÿ�.
select employee_id, last_name, substr(first_name, 3), salary from hr.employees;

-- instr
select instr('HelloWorld', 'o') from dual;  -- ù ��° ������ o�� ��ȯ
select instr('HelloWorld', 'o', 6) from dual;
select instr('HelloWorld', 'o', instr('HelloWorld', 'o') + 1) as result from dual;
select instr('HelloWorld', 'o', -1) from dual;
select instr('HelloWorld', 'z', 6) from dual;
select instr('HelloWorld', 'World') from dual;  -- ���ڿ��� ù ��° ���ڸ� ��ȯ

-- lpad
select lpad('hello', 10, '*') from dual;
select rpad(substr('highland0', 1, 4), length('highland0'), '*') from dual;
select rpad('hello', 10, '*') from dual;
select lpad(substr('highland0', 5, 8), length('highland0'), '*') from dual;

-- ���, �̸��� 3���ڸ� ����ϰ� ������ �ڿ��� ��ǥ, �޿�, ������ ���
select rpad(substr(first_name, 1, 3), length(first_name), '*'), 
salary, job_id from hr.employees;

--' Steven '
select * from hr.employees where first_name LIKE trim('  Steven  ');
select trim('  Steven   ') from dual;
select ltrim('  Steven   ') from dual;
select rtrim('  Steven   ') from dual;

--'JACK and JUE'���� 'J'�� 'BL'�� �����Ͻÿ�.
select replace('JACK and JUE', 'J', 'BL') from dual;

-- �����ȣ, �̸�, �޿�, ����, �μ���ȣ�� ����� �� ������ _AS�� abc�� �����ؼ� ���
-- ������ _AS�� ���Ե� ������ ����Ͻÿ�.
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