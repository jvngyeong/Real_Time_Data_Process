-- ���, �̸�, �޿�, ����, �Ի���, �̸���, �μ���ȣ�� ���
select employee_id, first_name, salary, hire_date, email, department_id
from employees;

-- View�� ������
create or replace vw_emp
as
select employee_id, first_name, salary, hire_date, email, department_id
from employees;

-- Inline View (from ���� �ִ� Subquery, ��ġ Viewó�� ��� ���������� Viewó�� Object�� �ƴ�.)
select * from
(select employee_id, first_name, salary, hire_date, email, department_id
from employees);

-- �μ��� �ּ� �޿��� �ش��ϴ� ����� 
-- ���, �̸�, �޿�, ����, �Ի���, �̸���, �μ���ȣ�� ���
select e.employee_id, e.first_name, e.salary, e.job_id, e.hire_Date, e.email, e.department_id
from employees e join (select department_id, min(salary) min_sal from employees group by department_id) e2
on e.department_id = e2.department_id
where e.salary = min_sal;

-- �� �μ����� ��� �޿����� ���� �޴� ����� ���, �̸�, �޿�, ����
-- �Ի���, �̸���, �μ���ȣ�� ����Ͻÿ�.
select employee_id, first_name, salary, job_id, hire_date, email, e.department_id
from employees e join (select department_id, avg(salary) avg_sal from employees group by department_id) e2
on e.department_id = e2.department_id
where salary > avg_sal;

-- �� �������� �ּ� �޿��� �޴� ����� ���, �̸�, �޿�, ����
-- �Ի���, �̸���, �μ���ȣ�� ����Ͻÿ�.
select employee_id, first_name, salary, e.job_id, hire_date, email, department_id
from employees e join(select job_id, min(salary) min_sal from employees group by job_id) e2
on e.job_id = e2.job_id
where salary = min_sal
order by employee_id;


-- ���� Insert
create table employees1(
    employee_id number(6),
    first_name varchar2(20),
    last_name varchar2(25)
);
create table employees2(
    employee_id number(6),
    hire_date date,
    job_id varchar2(100)
);
select employee_id, first_name, last_name, hire_date, job_id
from employees;

-- �� ���� ���̺��� ������ �����͸� �� ���� ���̺� ������ ����
insert all into employees1(employee_id, first_name, last_name)  
           values(employee_id, first_name, last_name)
           into employees2(employee_id, hire_date, job_id)
           values(employee_id, hire_date, job_id)
select employee_id, first_name, last_name, hire_date, job_id
from employees;

select * from employees1;
select * from employees2;
truncate table employees2;
-- �Ի��� 05/12/24 ���� ������ employees1�� �ְ�,
-- �׷��� ������ employees2�� �ְ��� �Ѵ�.
insert all
       when hire_date < '05/12/24' then
            into employees1(employee_id, first_name, last_name)
            values(employee_id, first_name, last_name)
       else
            into employees2(employee_id, hire_date, job_id)
            values(employee_id, hire_date, job_id)
select employee_id, first_name, last_name, hire_date, job_id
from employees;

-- �Ի��� 05/12/24 ���� ���� ������� employees1�� �ְ�,
-- Commission_pct�� null�� ����� employee2�� �ְ��� �Ѵ�.
insert all
       when hire_date < '05/12/24' then
       into employees1(employee_id, first_name, last_name)
            values(employee_id, first_name, last_name)
       when commission_pct is null then
            into employees2(employee_id, hire_date, job_id)
            values(employee_id, hire_date, job_id)
select * from employees;

-- �ϰ�ó��
create table education(
    edu_id varchar2(10),
    school_year date,
    school varchar2(100)
);

insert all
    into education(edu_id, school_year, school)
    values('2222','24/05/28', '������б�')
    into education(edu_id, school_year, school)
    values('2223','24/05/28', '�����')
select * from dual;   

-------------------------------------------------------
-- DML : SELECT, INSERT, UPDATE, DELETE, MERGE
-- DDL : CREATE, DROP, ALTER, TRUNCATE, RENAME 
-- DCL : GRANT, REVOKE
-- TCL : COMMIT, ROLLBACK

-- MERGE : ����!
-- ������ Update, ������ Insert�� �ǵ��� ����
create table emp
as
select * from hr.employees
where 1 = 2;

select * from hr.employees
where employee_id = 100;

insert into emp
values(100, 'Steven', 'King', 'SKING', '515.123.4567', '03/06/17', 'AD_PRES', 24000, null, null, 90);

select * from emp;

merge into emp c
using hr.employees e
on(c.employee_id = e.employee_id)
    when matched then update set salary = c.salary * 1.1
    when not matched then Insert values(e.employee_id, e.first_name, e.last_name, e.email, e.phone_number, 
    e.hire_date, e.job_id, e.salary, e.commission_pct, e.manager_id, e.department_id);
        
truncate table emp;

--------------------------------------------------------------------------
insert into emp
values(100, 'Steven', 'King', 'SKING', '515.123.4567', '03/06/17', 'AD_PRES', 24000, null, null, 90);

merge into emp e1
using hr.employees e2
on(e1.employee_id = e2.employee_id)
when matched then update set salary = e1.salary * 1.1,
                             hire_date = sysdate,
                             email = e2.email
when not matched then insert(employee_id, last_name, email, hire_date, job_id) 
                      values(e2.employee_id, e2.last_name, e2.email, e2.hire_date, e2.job_id);    

select * from emp;      



merge into emp e1
using (select * from hr.employees where employee_id = 100) e2
on (e1.employee_id = e2.employee_id)
when matched then update set salary = e1.salary * 1.1
when not matched then insert values(e2.employee_id, e2.first_name, e2.last_name, e2.email, 
e2.phone_number, sysdate, e2.job_id, 17000, 0.35, e2.manager_id, e2.department_id);

select * from emp;


-- ������ Delete, ������ Insert
merge into emp e1
using (select * from hr.employees where employee_id = 100) e2
on (e1.employee_id = e2.employee_id)
when matched then update set hire_date = sysdate
                  delete where e1.employee_id = 100
when not matched then insert values(e2.employee_id, e2.first_name, e2.last_name, e2.email, 
e2.phone_number, sysdate, e2.job_id, 17000, 0.35, e2.manager_id, e2.department_id);

create table cart(
    goods_num varchar2(10),
    cart_date date not null,
    cart_qty integer not null
);
drop table cart;
merge into cart c
using (select * from hr.employees where employee_id = 100) e
on(goods_num = employee_id)
when matched then update set cart_qty = cart_qty + 1
when not matched then insert values(employee_id, sysdate, 10);

select * from cart;


-- Window �Լ�
-- ��� ��ȣ, �̸�, ����, �׸��� �μ��� �޿��� �հ踦 ����ϼ���.
select employee_id, first_name, job_id, sum(salary) over (partition by department_id) sumsal, department_id 
from employees;

select employee_id, first_name, job_id, e1.department_id, sum_sal
from employees e1 join (select department_id, sum(salary) sum_sal from employees group by department_id) e2
on e1.department_id = e2.department_id;

-- ������ ������ �޿��� ��� �׸��� ���, �̸�, �޿��� ���
select job_id, employee_id, first_name, salary, avg(salary) over (partition by job_id)
from employees;

select e1.job_id, employee_id, first_name, salary, avg_sal
from employees e1 join (select job_id, avg(salary) avg_sal from employees group by job_id) e2
on e1.job_id = e2.job_id;

-- �μ��� �μ��� �ִ� �޿��� �̸�, ���, �޿�, ������ ���
select department_id, first_name, employee_id, salary, job_id, max(salary) over(partition by department_id)
from employees;

-- employees ���̺��� ù ����� ������ �����
-- ���� ��ȣ, �̸�, �޿�, �޿��� �� �հ踦 ����Ͻÿ�.
select employee_id, first_name, salary, 
sum(salary) over (order by salary rows between unbounded preceding
                                       and unbounded following) sum_sal
from employees;

select employee_id, first_name, salary, sum(salary) over () sum_sal
from employees;

-- employees ���̺��� ù ����� ������ �����
-- ���� ��ȣ, �̸�, �޿�, �޿��� ���� �հ踦 ����ϼ���.
select employee_id, first_name, salary, 
sum(salary) over(order by salary rows between unbounded preceding
                                      and current row) sum_sal
from employees;

-- ��������
select employee_id, first_name, salary, 
sum(salary) over(order by salary rows between current row
                                      and unbounded following) sum_sal
from employees;


-- Rank() : ������ ����� �� ���. �������϶��� ���� ���� ��µ�. ex) 1���� �������̸� 1,1,1 ��� �� 4 ���
-- �� �μ����� �޿��� �� ���ϱ�?
select employee_id, first_name, salary,
       rank() over (partition by department_id order by salary desc) rank
from employees;

-- Dense_Rank() -- �������϶� ���� ���� ��µǰ�, ���� ����� �״�� ���. ex) 1���� �������̸� 1,1,1 ��� �� 2 ���
select employee_id, first_name, salary,
       Dense_Rank() over (partition by department_id order by salary desc) drank
from employees;

--------------------------------------------
-- �μ��� �μ��� �ִ� �޿��� �̸�, ���, �޿�, ������ ���
-- 1. Partition by ���
select first_name, employee_id, salary, job_id, max(salary) over (partition by department_id) pt
from employees;
-- 2. max ��� first_value ���
select first_name, employee_id, salary, job_id, 
first_value(salary) over (partition by department_id order by salary desc) fv
from employees;

-- �μ��� �μ��� �ּ� �޿��� �̸�, ���, �޿�, ������ ���
select first_name, employee_id, salary, job_id, min(salary) over (partition by department_id)
from employees;
select first_name, employee_id, salary, job_id, 
first_value(salary) over (partition by department_id order by salary asc) fv
from employees;