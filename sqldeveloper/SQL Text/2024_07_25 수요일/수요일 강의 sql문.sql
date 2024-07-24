select * from hr.employees;

select * from hr.employees;

select * from hr.departments;

select department_id, department_name, manager_id, location_id from hr.departments;

select department_name, manager_id from hr.departments;

select manager_id,department_name from hr.departments;

select * from hr.departments;

-- ���ͷ� ���
select manager_id, department_id, 30, '�̼���' from hr.departments;

select * from hr.employees;

select employee_id, first_name, salary, 30, salary+ 30, manager_id from hr.employees;

select employee_id, first_name, salary * 12, salary from hr.employees;

select employee_id, first_name, (salary+100) * 12 from hr.employees;

select null*10 from dual; -- �� �� ���� ���̴�.

select employee_id, last_name, hire_date, salary, commission_pct, department_id from hr.employees;

---�� ����� Ŀ�̼��� ������ ����ϼ���
select employee_id, last_name, hire_date, salary, commission_pct, salary * commission_pct, department_id from hr.employees;

-- �����ȣ, �̸�, ��, �޿�, Ŀ�̼�, Ŀ�̼��� ������ ������ ���� ����Ͻÿ�.
select employee_id,last_name, first_name, salary, commission_pct, ((salary * commission_pct) + salary) * 12 from hr.employees;

-- alias
select employee_id,last_name, first_name, salary, commission_pct, ((salary * commission_pct) + salary) * 12 �� from hr.employees;

-- ��ҹ��ڷ� heading name ���
select employee_id,last_name, first_name, salary, commission_pct comm, ((salary * commission_pct) + salary) * 12 "Year_Sal" from hr.employees;

-- heading name�� ���鹮�� ����
select employee_id,last_name, first_name, salary, commission_pct comm , ((salary * commission_pct) + salary) * 12 "Year _ Sal" from hr.employees;

--��Ī�� as �߰�
select employee_id,last_name, first_name, salary, commission_pct comm , ((salary * commission_pct) + salary) * 12 as "Year _ Sal" from hr.employees;

--���Ῥ����
select last_name, job_id, employee_id, salary, last_name || job_id from hr.employees;

--���ڿ� ���ͷ�
select last_name, 'is a ',job_id, employee_id, salary, last_name || ' is a ' || job_id from hr.employees;

--100�� �̸��� King�̰� ������ AD_PRES �Դϴ�.
select employee_id || '�� �̸��� ' || last_name || '�̰�,  ������ ' || job_id || '�Դϴ�.' employee from hr.employees;

--king 1���� ������ = 24000
select last_name || '�� 1���� ������ = ' || salary king from hr.employees;


select * from hr.departments;
-- Administration�� manager�� 200�Դϴ�.
select department_name || '�� manager�� ' || manager_id || '�Դϴ�.' manager from hr.departments;
-- Administration department's manager_id 200
select department_name || 'department''s manager_id' || manager_id from hr.departments;
select department_name || q'[ department's manager_id]' || manager_id from hr.departments;

--�ߺ� �� ����
select last_name, salary, job_id, department_id from hr.employees;
select distinct department_id from hr.employees;

select distinct department_id, job_id from hr.employees;

--table ���� Ȯ��
desc hr.employees;  --describe

--1. �μ����� �޿��� ���� ����� ������ �� ���� ����� ��, �μ��� �޿��� ����ϼ���
select distinct job_id as "�μ�", salary as "�޿�" from hr.employees;
--2. �Ի����� ���� ������ ���� ��� ������ �� ���� ����ϼ���. �Ի��ϰ� ������ ���
select distinct hire_date as "�Ի���", job_id as "����" from hr.employees;

--�����ȣ�� 100�� ����� ���
select * from hr.employees;
select * from hr.employees where employee_id = 100;
select * from hr.employees where EMPLOYEE_ID = 100;

select employee_id, first_name, salary, job_id from hr.employees where job_id = 'FI_Account'; --selection�� ��, ���ͷ��� ��ҹ��ڸ� ������.
-- yy/mm/dd
select * from hr.employees;

--�Ի����� 07/02/07 �� ������� ����Ͻÿ�.
select * from hr.employees where hire_date = '07/02/07';
select * from hr.employees where hire_date = '07.02.07';
select * from hr.employees where hire_date = '07-02-07';

--���庸�� ���� �Ի��� ��������
select * from hr.employees where employee_id = 100;
select * from hr.employees where hire_date < '03/06/17';

--�޿��� 3000�޷� �̻��� ����� ����ϼ���
select * from hr.employees where salary >= 3000;

--��� ��ȣ, ��, �޿�, ������ ����ϴµ�, �޿��� �� �̸��� sal�� �Ѵ�.
--�̋� �޿��� 3000�̻��� ����� ���
select employee_id, first_name, salary as sal, job_id from hr.employees where salary >= 3000;

--�޿��� 2500���� 4000 ������ ��� ���
select * from hr.employees where 4000 >= salary and salary >= 2500;

--50, 70, 90�� �μ��� ������ ����Ͻÿ�.
select * from hr.employees where department_id = 50 or department_id = 70 or department_id = 90;
select * from hr.employees where department_id in (50, 70, 90);

-- ���� �̸��� 'Vance'�� ������ 90�� �μ��� ������ ����Ͻÿ�.
select * from hr.employees where first_name = 'Vance' or department_id = 90;

-- �� �̸��� 'Hartstein', 'Vargas'�� ������� ����Ͻÿ�.
select * from hr.employees where last_name in ( 'Hartstein', 'Vargas' );

--100, 101, 201�� ���(manager_id)�� �� �������� ��� ����Ͻÿ�.
select * from hr.employees where manager_id in (100, 101, 201);
--100, 101, 201�� ���(manager_id)�� �ƴ� �������� ��� ����Ͻÿ�.
select * from hr.employees where manager_id not in (100, 101, 201);
--50�� �μ��� 60�� �μ��� 70�� �μ��� ������ ���Ͻÿ�
select * from hr.employees where department_id in(50,60,70);
select * from hr.employees where department_id between 50 and 70;
--50�� �μ��� 60�� �μ��� 70�� �μ��� �ƴ� ������ ���Ͻÿ�
select * from hr.employees where department_id not in(50,60,70);
select * from hr.employees where department_id not between 50 and 70;
--03/05/17. 01/01/13, 07/03/17�� �Ի��� �������� ����Ͻÿ�.
select * from hr.employees where hire_date in('03.06.17', '01.01.13', '07.03.17');
--03/05/17. 01/01/13, 07/03/17�� �Ի簡 �ƴ� �������� ����Ͻÿ�.
select * from hr.employees where hire_date not in('03.06.17', '01.01.13', '07.03.17');
--�޿��� 3000�̸��̰� 10000�� �ʰ��� �������� ����Ͻÿ�.
select * from hr.employees where salary not between 3000 and 10000;
select * from hr.employees where salary < 3000 or salary > 10000;
--�μ��� ���� ������ ����Ͻÿ�.
select * from hr.employees where department_id is null;
--�μ��� ���� ������ ���
select * from hr.employees where department_id is not null;
--���� 'K'�� �����ϴ� ��� ������ ���
select * from hr.employees where last_name like 'K%';
--���� 'K'�� ������ ��� ������ ���
select * from hr.employees where last_name like '%K';
--���� 'K'�� �����ϴ� ��� ������ ��� : K%, %K, %K%
select * from hr.employees where last_name like '%K%';
--���� in�� ���Ե� �������� ���
select * from hr.employees where last_name like '%in%';
--���� ù ���ڴ� �ƹ� ���ڳ� ���������, �� ��° ���ڴ� 'u'�� ���� �������� ���
select * from hr.employees where last_name like '_u%';
--���� �� ��° ���ڿ� 's'�� ���� ������ ���
select * from hr.employees where last_name like '__s%';
--���� �ڿ��� �� ��° ���ڰ� 'i'�� ������ ���
select * from hr.employees where last_name like '%i_';
--���� u�� i���̿� �� ���ڸ� �����ϴ� ������� ���
select * from hr.employees where last_name like '%u_i%';

select job_id from hr.employees;

--������ AC_�� �����ϴ� ���� ���
select * from hr.employees where job_id like 'AC\_%' escape '\';

--������ D_P�� ������� ����Ͻÿ�.
select * from hr.employees where job_id like '%D\_P%' escape '\';