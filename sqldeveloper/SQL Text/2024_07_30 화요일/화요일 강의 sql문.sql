select * from hr.employees;
select * from hr.departments;   -- employees ���̺�� departments ���̺��� ����� Column�� �ֱ� ������ �����͸� ������ �� ����.
select * from hr.locations;     -- employees ���̺�� locations ���̺��� ����� Column�� ���� ������ �����͸� ������ �� ����.
-- employes ���̺�         departments ���̺�      locations ���̺�
-- department_id   / department_id, location_id / location_id
-- employees ���̺�� locations ���̺� ����Ǵ� ���� ���� ������ 
-- �� �� �����ִ� departments ���̺��� �̿��ؼ� 3�� ������ ���!!

-- 2�� ���� ���� )
-- ��� ��ȣ, �̸�, �Ի���, �޿�, �μ� ��ȣ
-- �μ� ��ȣ, �μ���
select employee_id, first_name, hire_date, salary, em.department_id,
       de.department_id, department_name
from hr.employees em join hr.departments de
on em.department_id = de.department_id;

select * from hr.employees;
select * from hr.jobs;

-- ��� ��ȣ, �μ� ��ȣ, �̸�, ����ID
-- ����ID, ������
select employee_id, department_id, first_name, em.job_id
      ,jo.job_id, job_title
from hr.employees em join hr.jobs jo
on em.job_id = jo.job_id;

-- join�� ���ؼ��� ����� Column�̳� ���� �����ؾ� ��.
-- ���� ���� ����� ����)
select * from hr.departments;
select * from hr.employees;
-- �μ� ��ȣ, �μ���, �μ��� ��ȣ
-- ��� ��ȣ, �����, ����, �޿�
select de.department_id, department_name, de.manager_id,
       employee_id, first_name, job_id, salary
from hr.departments de join hr.employees em
on de.manager_id = em.employee_id;

-- table�� n�� ���� ��, join ������ �� ���ΰ�? --> n-1 �̻�

-- ��� ��ȣ, �̸�, �Ի���, �޿�, �μ� ��ȣ
-- �μ� ��ȣ, �μ���
-- inner join (���� ���� ���� ����� ��)
select employee_id, first_name, hire_date, salary, em.department_id
      ,de.department_id, department_name
from hr.employees em inner join hr.departments de
on em.department_id = de.department_id;

-- ��� ��ȣ, �μ� ��ȣ, �̸�, ���� ��ȣ
-- ���� ��ȣ, ���� ����
select employee_id, department_id, first_name,
       j.job_id, job_title
from hr.employees e join hr.jobs j
on e.job_id = j.job_id;
-- , = join = inner join

-- ��� ��ȣ, �̸�, ����, �μ� ��ȣ
select employee_id, first_name, job_id, department_id
from hr.employees;

select employee_id, first_name, job_id, e.department_id,
       department_name
from hr.employees e inner join hr.departments d
on e.department_id = d.department_id;

-- �μ� ��ȣ, �μ���, �μ��� ��ȣ
-- �����ȣ, �����, ����, �޿�
select count(manager_id) from hr.departments;

select d.department_id, department_name, d.manager_id,
       employee_id, first_name, job_id, salary
from hr.departments d join hr.employees e
on d.manager_id = e.employee_id;

-- natural ���� ����
-- ��� ��ȣ, �μ� ��ȣ, �̸�, ���� ��ȣ
-- ���� ��ȣ, ���� ����
-- natural ���ο����� ��Ī�� ������� �ʴ´�.
select employee_id, department_id, first_name, job_id,
       job_id, job_title
from hr.employees natural join hr.jobs;
--on e.job_id = j.job_id


-- ���� �μ��� �μ����� ���� �� �������� ������ �μ����� ����Ͻÿ�.
-- ��� ��ȣ, �̸�, ����, �޿�, ��� ��ȣ
-- �μ� ��ȣ, �μ���, �μ���
select employee_id, first_name, job_id, salary, e.manager_id,
       d.department_id, department_name, d.manager_id
from hr.employees e inner join hr.departments d
on e.department_id = d.department_id and e.manager_id = d.manager_id;

select employee_id, first_name, job_id, salary, manager_id,
       department_id, department_name, manager_id
from hr.employees natural join hr.departments;
--on e.department_id = d.department_id and e.manager_id = d.manager_id;

-- using ��
select employee_id, first_name, job_id, salary, manager_id,
       department_id, department_name, manager_id
from hr.employees join hr.departments
using(department_id, manager_id);


-- ��� ��ȣ, �μ� ��ȣ, �̸�, ���� ��ȣ
-- ���� ��ȣ, ���� ����
select employee_id, department_id, first_name, e.job_id,
       j.job_id, job_title
from hr.employees e join hr.jobs j
on e.job_id = j.job_id;

select employee_id, department_id, first_name,
       job_id, job_title
from hr.employees join hr.jobs
using(job_id);
--on e.job_id = j.job_id;

-- �� ������ ���� ��ȣ, ���� ��ȣ,
--         �μ� ��ȣ, �μ���
-- �� ��, 20, 30, 50, 80�� �μ��� ���
-- T-SQL Join, Ansi - Join, Using��
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

-- �μ� ��ȣ, �μ���, �����ȣ(location_id)
-- �ּ�(street_address)�� ����� �� �����ȣ�� 1400�� ���
-- T-SQL Join, Ansi - Join, Natural Join, using ��
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

-- ���� ��ȣ, �̸�, �޿�, ����, �Ի���
-- �μ���ȣ, �μ����� ����� �� 50�� �μ��� 90�� �μ��� �����Ѵ�
select employee_id, first_name salary, job_id, hire_date,
       d.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id and e.department_id not in(50, 90);


-- ���� ��ȣ, ���� ����
-- ���� ��ȣ, ��� ��ȣ, �̸�, �μ���ȣ
-- �μ� ��ȣ, �μ���
-- T-SQL Join
select j.job_id, job_title,
       e.job_id, employee_id, first_name, e.department_id,
       d.department_id, department_name
from hr.jobs j, hr.employees e, hr.departments d
where j.job_id = e.job_id and e.department_id = d.department_id;

-- ANSI - JOIN
select j.job_id, job_title, -- jobs ���̺�
       e.job_id, employee_id, first_name, e.department_id, -- employees ���̺�
       d.department_id, department_name
from hr.jobs j join hr.employees e
on j.job_id = e.job_id
join hr.departments d on e.department_id = d.department_id;

-- ���� ��ȣ, ��� ��ȣ, �̸�, �޿�, �μ���ȣ
-- �μ� ��ȣ, �μ���, ���� ��ȣ
-- ������ȣ, �ּ�
select e.job_id, employee_id, first_name, salary, e.department_id,
       d.department_id, department_name, d.location_id,
       l.location_id, street_address,
       j.job_id, job_title
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.locations l on d.location_id = l.location_id
join hr.jobs j on j.job_id = e.job_id;

-- ���� ��ȣ, ���� ���� -- jobs ���̺�
-- ���� ��ȣ, ��� ��ȣ, �̸�, �޿�, �Ի��� -- employees ���̺�
-- �μ� ��ȣ, �μ���, ������ȣ -- departments ���̺�
-- ���� ��ȣ, �ּ�, ������ȣ  -- locations ���̺�
-- ���� ��ȣ, ������ -- countries ���̺�
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
-- David�� �����ȣ, �̸�, �޿�, ����, �̸���, ���, ��� �̸�
select e1.employee_id, e1.first_name, e1.salary, e1.job_id, e1.email, e1.manager_id,
        e2.first_name
from hr.employees e1, hr.employees e2
where e1.manager_id = e2.employee_id and e1.employee_id = 105;


-- ����(100)�� ����� �����(�����ȣ, �̸�, �޿�, ����, ����ȣ) �� ����Ͻÿ�
-- ������ �޿��� �Ի����� ����Ͻÿ�.
select e1.employee_id, e1.first_name, e1.salary, e1.job_id, e1.manager_id,
        e2.salary, e2.hire_date
from hr.employees e1 join hr.employees e2
on e1.manager_id = e2.employee_id;

-- �����ȣ, �̸�, �޿�, ����
-- ���� ��ȣ, ��������, �ּұݾ�, �ִ�ݾ�
select employee_id, first_name, salary, e.job_id,
       j.job_id, job_title, min_salary, max_salary
from hr.employees e join hr.jobs j
on salary between min_salary and max_salary;

-- �μ��� ���� ����� ��µ��� �ʾ���.
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