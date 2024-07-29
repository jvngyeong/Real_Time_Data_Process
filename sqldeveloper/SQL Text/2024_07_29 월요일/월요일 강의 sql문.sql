-- ���� �� �Լ�(�׷� �Լ�) : null�� �������� �ʴ´�. (null�� ������ ����� �Ұ����ϱ� ������)
select count(department_id) from hr.employees;

-- �޿����� �޿��� ���� �޴� ������ �޿��� ���� ���� ����, �׸��� �� �� �޿��� ��հ�
-- �� �޵��� ���޵Ǵ� �޿��� �ݾ��� ����ϼ���.
select max(salary), min(salary), round(avg(salary)), sum(salary) from hr.employees;

-- ��ü ������ ��
select count(employee_id), count(last_name), count(first_name), count(email), count(hire_date) from hr.employees;

-- Ŀ�̼��� �޴� ������ ��
select count(commission_pct) from hr.employees;

-- �μ��� �ִ� ������ ��
select count(department_id) from hr.employees;

-- �μ��� ���� ����� ��
select count(*) from hr.employees where department_id is null;

-- 80�� �μ��� ���� ���� �ִ� �޿��� �ּ� �޿��� ���Ͻÿ�.
select count(*), max(salary), min(salary) from hr.employees where department_id = 80;

-- �μ��� ����ϼ���
select department_id from hr.employees;

-- �μ��� �� ������ ���
select distinct department_id from hr.employees;

-- �μ��� ���� ���
select count(distinct(department_id)) from hr.employees;

-- ������ RE�� ������ ������ ����Ͻÿ�.
select * from hr.employees where job_id like '%RE%';

-- ������ RE�� ������ ������ �ִ� �޿��� �ּ� �޿� �׸��� �����Ǽ��� ��� �޿��� ����Ͻÿ�.
select max(salary), min(salary), count(*), round(avg(salary)) from hr.employees where job_id like '%RE%';

-- ���� ���� �Ի��� ����� ���� �ʰ� �Ի��� ����� �Ի����� ����Ͻÿ�.
select min(hire_date), max(hire_date) from hr.employees;

-- commission_pct�� �޴� ����� commission_pct�� ����� ���Ͻÿ�
select round(avg(commission_pct), 2) from hr.employees where commission_pct is not null;
-- ��ü ������ commission_pct�� ����� ������
select avg(nvl(commission_pct, 0)) from hr.employees;
select sum(commission_pct) / count(*), avg(nvl(commission_pct, 0)) from hr.employees;

--80�� �μ����� ������ 'SA_MAN'�� ������ ���� Ŀ�̼��� ����� ���Ͻÿ�.
select count(*), nvl(avg(commission_pct), 0) from hr.employees where department_id = 80;


-- group by
select department_id, avg(salary), sum(salary), max(salary), min(salary)
from hr.employees
group by department_id;

-- job_id�� FI_ACCOUNT�� ������ �޿��� ���, �հ�, �ִ밪, �ּҰ�, ���� ���� ���
-- job_id�� IT_PROG�� ������ �޿��� ���, �հ�, �ִ밪, �ּҰ�, ���� ���� ���
-- job_id�� PU_CLERK�� ������ �޿��� ���, �հ�, �ִ밪, �ּҰ�, ���� ���� ���
select job_id, sum(salary), avg(salary), sum(salary), max(salary), min(salary), count(*)
from hr.employees
where job_id in('FI_ACCOUNT', 'IT_PROG', 'PU_CLERK')
group by job_id;

-- �������� ��� ������ ����� ��, �μ��� ������������ �����ϰ�
-- ���ĵ� ���� �μ� �ȿ��� �ٸ� ������ ���� ������ �ִٸ� ������ ������������
select * from hr.employees
order by department_id asc, job_id asc;

-- ���� �μ��� �ٸ� �������� �޿��� ���, �޿��� �հ�, �ִ밪, �ּҰ�
-- ���� �μ����� ���� ������ �ϴ� ������ ���� ����ϼ���.
select job_id, avg(salary), sum(salary), max(salary), min(salary), count(*)
from hr.employees
group by department_id, job_id
order by department_id, job_id;

-- �μ��� ��� �޿��� ����ϼ���.
select department_id, avg(salary) from hr.employees
group by department_id;
-- �̶�, ��� �޿��� 8000�� �ʰ��� �μ��� �޿��� ����� ���
select department_id, avg(salary) from hr.employees
having avg(salary) > 8000
group by department_id;


--���� �� �ִ� �޿�, �ּ� �޿�, �޿��� �հ�,
--���� ���� ����� ��, ���� ���� 3 �̻��� �͸� ����Ͻÿ�.
select job_id, max(salary), min(salary), sum(salary), count(*)
from hr.employees
group by job_id
having count(*) >= 3 
order by job_id;

-- REP�� �����ϰ� ���� ���� ������ �߿��� �� ������ �ִ� �޿�, �ּ� �޿�, �޿� �հ踦 ���.
-- �̶� �޿� �հ谡 13000�̻��� �͸� ����Ͻÿ�.
-- ��, �޿��� �հ谡 ���� �ͺ��� ���.
select job_id, max(salary), min(salary), sum(salary)
from hr.employees
where job_id not like '%REP%'
group by job_id
having sum(salary) >= 13000
order by sum(salary) desc;


-- �� �μ��� �μ��� �޿��� �հ�, �ִ�, �ּ�, ����� ��, ����� ����ϴµ�
-- ����� �Ҽ��� 2�ڸ��� ���
select department_id, sum(salary), max(salary), min(salary), count(*), round(avg(salary), 2)
from hr.employees
group by department_id;

-- �μ����� ���� ������ �ϴ� ������� �ִ� �޿�, �ּ� �޿�,
-- ��� �޿�, �޿��� �հ�� ���� ������ �ϴ� ����� ���� ���.
select department_id, job_id, max(salary), min(salary), avg(salary), sum(salary), count(*)
from hr.employees
group by department_id, job_id;

select department_id, job_id, hire_date, count(*)
from hr.employees
where department_id = 80
group by department_id, job_id, hire_date
having count(*) >= 2
order by department_id, job_id, hire_date;

-- ��� �޿��� 7000 �̻��� �μ��� ����Ͻÿ�. ��� �޿��� ���� �� ���� ���
select department_id
from hr.employees
group by department_id
having avg(salary) >= 7000
order by avg(salary) desc;

-- �� �μ��� ��� �޿� �� �ִ� ��� �޿��� ���.
-- ��ø �׷� �Լ�
select max(avg(salary))
from hr.employees
group by department_id;

-- ���� : �� �� �̻��� ���̺�κ��� �����͸� �������� ��
select * from hr.employees;
select * from hr.departments;

-- �����ȣ, �̸�, �޿�, ����, �μ���ȣ, �μ���
select employee_id, first_name, salary, job_id, hr.employees.department_id, department_name
from hr.employees, hr.departments
where hr.employees.department_id = hr.departments.department_id;

select * from hr.jobs;

-- �����ȣ, �̸�, �޿�, ���� ��ȣ, �μ� ��ȣ, ������
select employee_id, first_name, salary, hr.employees.job_id, department_id
    ,job_title
from hr.employees, hr.jobs
where hr.employees.job_id = hr.jobs.job_id;


select employee_id, first_name, salary, job_id
, d.department_id, d.department_name, d.manager_id
from hr.employees e join hr.departments d
on e.employee_id = d.manager_id
where employee_id = 100;

select * from hr.job_history;

-- �����ȣ, �̸�, �޿�, ����, �μ� ��ȣ
-- ������, ��������. ���� ����
select a.employee_id, a.first_name, a.salary, a.job_id, a.department_id
    ,b.start_date, b.end_date, b.job_id
    from hr.employees a join hr.job_history b
    on a.employee_id = b.employee_id;
    
    
select * from hr.job_history;
select * from hr.jobs;
select * from hr.departments;
-- ������, �ּ� �޿�, �ִ� �޿�
-- ������, ������, ��ģ��
-- �μ� ��ȣ, �μ���
select a.job_id, a.min_salary, a.max_salary,
    b.job_id, b.start_date, b.end_date,
    c.department_id, c.department_name
    from hr.jobs a join hr.job_history b
    on a.job_id = b.job_id 
    join hr.departments c 
    on b.department_id = c.department_id;