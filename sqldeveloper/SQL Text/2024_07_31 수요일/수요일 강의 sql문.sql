-- ��� �޿��� ���� ���� ������ ����Ͻÿ�.
select max(avg(salary)) -- 24000
from hr.employees
group by job_id;

select job_id, salary
from hr.employees
where salary = (select max(avg(salary)) -- 24000
from hr.employees
group by job_id);

-- Abel�� �޿��� ����Ͻÿ�.
select salary FROM hr.employees
where last_name = 'Abel';

-- Abel�� ���� �޿��� �޴� �������� ����Ͻÿ�
select * from hr.employees
where salary = (select salary from hr.employees where last_name = 'Abel');

-- ���� Kumar�� ����� ������ ����, Kumar�� ������� �Ի����� ���� �������
-- ��, �̸�, ����, �Ի���, �μ��� ���
select last_name, first_name, job_id, hire_date, department_id
from hr.employees where job_id = 
(select job_id from hr.employees where last_name = 'Kumar') 
and hire_date < (select hire_date from hr.employees where last_name = 'Kumar');

-- ����(100)���� ���� �Ի��� ������� ���
select * from hr.employees where
hire_date < (select hire_date from hr.employees where employee_id = 100);

-- 30�� �μ��� �ִ� ������ ���� �����ϴ� ������� ����Ͻÿ�.
select * from hr.employees where
job_id in (select job_id from hr.employees where department_id = 30);

-- ���� Taylor�� ����� ���� ������ �ϴ� ������� ���
select * from hr.employees where job_id in
(select job_id from hr.employees where last_name = 'Taylor');

-- �� �μ��� �ּ� �޿�
select department_id, min(salary) from hr.employees group by department_id;

-- 30, 60, 90�� �μ��� �ּ� �޿��� ���Ͻÿ�.
select min(salary) from hr.employees where department_id in (30,60,90)
group by department_id
order by department_id asc;

-- ������ 'RE'�� �����ϴ� ������ ������ ������ ������� ���
select * from hr.employees where job_id not like '%re%';

-- 30, 60, 90�� �μ��� �ּ� �޿��� ����, ������ 'RE'�� �����ϴ� ������ ���� ���� ���� ������� ���Ͻÿ�.
select * from hr.employees where salary in
(select min(salary) from hr.employees where department_id in (30,60,90) group by department_id) and
job_id not like '%RE%';

-- ���� ��ȣ�� 104�� ������ ������ ���� �� �μ��� �ִ� �޿��� �ش��ϴ�
-- ������ ��� ������ ���
select * from hr.employees where job_id = (select job_id from hr.employees where employee_id = 104) and
salary in (select max(salary) from hr.employees group by department_id);

-- FI_ACCOUNT�� ������ ���� �������
-- �ּ� �޿����� �� ���� �޴� ������� ����.
select * from hr.employees where salary <
(select min(Salary) from hr.employees where job_id = 'FI_ACCOUNT');

select min(salary) from hr.employees
where job_id ='FI_ACCOUNT'
group by job_id;

select * from hr.employees
where salary < (select min(salary) from hr.employees
where job_id ='FI_ACCOUNT'
group by job_id);

-- ������ FI_ACCOUNT�� ����� �޿��� ���
select salary from hr.employees where job_id = 'FI_ACCOUNT';

-- 9000, 8200, 7700, 7800, 6900 �޿��� �ش��ϴ� ������� ���
select * from hr.employees where salary in (9000, 8200, 7700, 7800, 6900);
select * from hr.employees where salary in 
(select salary from hr.employees where job_id = 'FI_ACCOUNT'); -- ���� �� ��������

select * from hr.employees 
where salary < (select max(salary) from hr.employees where job_id = 'FI_ACCOUNT');

-- < any : ���� ū ������ ���� ��
select * from hr.employees 
where salary < any(9000, 8200, 7700, 7800, 6900);

-- > any : ���� ���� ������ ū ��
select * from hr.employees 
where salary > any(9000, 8200, 7700, 7800, 6900);

-- = any : in
select * from hr.employees 
where salary = any(9000, 8200, 7700, 7800, 6900);

-- < all : ���� ���� ������ ���� ��
select * from hr.employees 
where salary < all(9000, 8200, 7700, 7800, 6900);

-- > all : ���� ū ������ ū ��
select * from hr.employees
where salary > all(9000, 8200, 7700, 7800, 6900);

-- ���������� �ִ� ����� ��� ���Ͻÿ�.
select distinct * from hr.employees where employee_id in (select manager_id from hr.employees);

-- ���������� ���� ����� ��� ���Ͻÿ�.
select * from hr.employees where employee_id not in(select manager_id from hr.employees
    where manager_id is not null);

-- A ����
select salary from hr.employees where job_id = 'ST_CLERK';
-- B ����
select salary from hr.employees where job_id = 'PU_CLERK';

-- ������
select salary from hr.employees where job_id = 'ST_CLERK'
union -- set ����
select salary from hr.employees where job_id = 'PU_CLERK';

-- ������
select salary from hr.employees where job_id = 'ST_CLERK'
intersect -- set ����
select salary from hr.employees where job_id = 'PU_CLERK';

-- ������
select salary from hr.employees where job_id = 'ST_CLERK'
minus -- set ����
select salary from hr.employees where job_id = 'PU_CLERK';

-- �ߺ��� ����ϴ� ������
select salary from hr.employees where job_id = 'ST_CLERK'
union all -- set ����, �������� �ߺ��ؼ� ���
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
-- A ����
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
