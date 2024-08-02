--1.'RE'�� ������ ���Ե��� ������ �ټ� ����� 10�� �̻��� ������� ����Ͻÿ�
--�̸�, �޿�, ����, ��������, �ּ�, ������, �����ȣ������ 
select first_name, salary, e.job_id, 
       job_title, 
       street_address,
       country_name,
       postal_code
from hr.employees e join hr.jobs j
on e.job_id = j.job_id
left join hr.departments d on e.department_id = d.department_id
left outer join hr.locations l on d.location_id = l.location_id
left outer join hr.countries c on l.country_id = c.country_id
where e.job_id not like '%RE%' and (sysdate - e.hire_date) / 365 >=  10;

-- 2.���������� ����ϴµ� Ŀ�̼��� null�� ��� 0.01%�� Ŀ�̼��� �ֱ�� �����Ͽ� 
-- �̸� YEARSAL�� $ǥ��� �Բ� ���ڸ��� �޿��� ����ϰ� ��������, �ּҿ� ��� ������ ����Ͻÿ�
-- ������ȣ, �̸�, ��, �޿�, Ŀ�̼��� ������ ����, ����, ��������, �ּ�, �������
select employee_id, first_name, last_name, salary, to_char(12*salary*(1 + nvl(commission_pct, 0.01)), '$999,999,999') as YEARSAL, e.job_id,
       job_title, l.location_id, state_province
       from hr.employees e join hr.jobs j
       on e.job_id = j.job_id
       join hr.departments d on e.department_id = d.department_id
       join hr.locations l on d.location_id = l.location_id;
       
--3.������ ����� ������ ��� ����Ͻÿ�
--������ȣ, ������, ������ȣ, �����
select c.country_id, country_name, l.location_id, region_name
from hr.countries c join hr.regions r
on c.region_id = r.region_id
join hr.locations l on c.country_id = l.country_id;

-- 4.������ 'AC_MGR'�� 'ST_CLERK'���̿��ִ� �̱��� ��� �������� ������ ����Ͻÿ�
-- �����ȣ, �̸�, ��, ����, ��������, �μ���ȣ, �μ���, ������
select employee_id, first_name, last_name, e.job_id, job_title, d.department_id, department_name, country_name
from hr.employees e join hr.jobs j
on e.job_id = j.job_id
join hr.departments d on e.department_id = d.department_id
join hr.locations l on l.location_id = d.location_id
join hr.countries c on c.country_id = l.country_id
where e.job_id between 'AC_MGR' and 'ST_CLERK' and c.country_id = 'US';

--5.���������� ����ϴµ� �����ȣ�� 128���� 188�����̸鼭 'R'�� ������ �����ϴ� ���������� �μ� ������ ����Ͻÿ�
select * from
hr.employees e join hr.departments d
on e.department_id = d.department_id
where employee_id between 128 and 188 and job_id like '%R%';

--6.�μ������� ����ϴµ� ����,�����ڵ�, �������� �����Ͽ� �μ������� ���� ���õ� �����Ͽ� ����Ͻÿ�
select department_id, department_name, city, l.country_id, country_name
from hr.departments d right outer join hr.locations l
on d.location_id = l.location_id
join hr.countries c on l.country_id = c.country_id;

-- 7. ��, �Ի���, ������, ��������, �μ���ȣ, �μ��� ���
-- �μ��� 60�� �����͸� �Ի��� �������� ����
select last_name, hire_date, e.job_id, job_title, d.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.jobs j on e.job_id = j.job_id
where d.department_id = 60
order by hire_Date asc;

-- 8. 50�� �μ��� ������ȣ�� ã��
-- �� ���� ��ȣ, ����, ���� ��ȣ, ������� ����Ͻÿ�
select l.location_id, city, c.country_id, country_name
from hr.countries c join hr.locations l
on c.country_id = l.country_id
join hr.departments d on d.location_id = l.location_id
where department_id = 50;

-- 9. '02/06/07'���� '06/11/15' ���̿� �Ի��� ����� 
-- ������ȣ, ��, �̸�, �Ի糯¥, �μ���ȣ, �μ����� ����Ͻÿ�.
-- ��, �Ի����� �������� ������������ �����Ͻÿ�.
select employee_id, last_name, first_name, hire_date, d.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where hire_date between '02/06/07' and '06/11/15'
order by hire_date desc;

-- 10. ������ȣ, ��, �̸�, ��ȭ��ȣ, �μ���, ���� ��ȣ�� ����Ͻÿ�
-- ��ȭ��ȣ ���ڸ��� 515 �� ������ ������ ����ϼ���
select employee_id, last_Name, first_name, phone_number, d.department_id, d.location_id
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where substr(phone_number, 1, 3) = '515';

-- 11. �̸��� 'os'�� ���� ������
-- ���� ��ȣ, �̸�, ����, ���� ����, �μ� ��ȣ, �μ����� ����Ͻÿ�
select employee_id, first_name, e.job_id, job_title, d.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.jobs j on j.job_id = e.job_id
where first_name like '%os%';

-- 12. 50�μ��� ������ �޿� �հ�� ��� ���Ͻÿ�.
-- ������, �޿��� �հ�, ����� ����Ѵ�.
-- �޿��� ����� �������� �������� �����Ѵ�.
select job_id, sum(salary), avg(salary)
from hr.employees
where department_id = 50
group by job_id
order by avg(salary);

-- 13. �������� Ŀ�̼��� ������ ������ null ���� ������ �ʵ��� ����Ͻÿ�.
-- ����� ������ ��Ī�� year_sal�̶�� �ҹ��ڷ� ��µǵ��� �Ѵ�
-- ������ȣ, ��, �̸�, �޿�, Ŀ�̼�, ����� ������ ����Ѵ�
select employee_id, last_name, first_name, salary, commission_pct, 12*salary*(nvl(commission_pct, 0) + 1) as year_sal
from hr.employees;

-- 14. 'ST_CLERK' ������ ���� ������ 
-- ������ȣ, ��, �̸�, ����, ������ �޿�, �ش� ������ �ּ�/�ִ� �޿��� ����Ͻÿ�.
select employee_id, last_name, first_name, e.job_id, salary, min_salary, max_salary
from hr.employees e join hr.jobs j
on e.job_id = j.job_id
where e.job_id = 'ST_CLERK';

-- 15. ���� ��ȣ(region_id)�� 2�� 
-- ������(country_name), ������ȣ(country_id), ����(city)�� ����Ͻÿ�
select country_name, c.country_id, city
from hr.countries c join hr.locations l
on c.country_id = l.country_id
join hr.regions r on c.region_id = r.region_id
where r.region_id = 2;

-- 16. �μ����� 'IT'�� �μ��� ���� ���� ���
-- ������ȣ, ��, �̸�, �޿�, �μ���, ������, ���� ����
-- ���� ��ȣ�� �������� �������� ����
select employee_id, last_name, first_name, salary, e.department_id, e.job_id, job_title
from hr.employees e join hr.jobs j
on e.job_id = j.job_id
join hr.departments d on e.department_id = d.department_id
where department_name like '%IT%';

--17. �̸��� 'HA'�� ���� ����� ��� ��ȣ, �̸�, �μ�, �μ���, ������, ���� ������ ����Ͻÿ�.
select employee_id, first_name, e.department_id, department_name, job_title
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.jobs j on e.job_id = j.job_id
where upper(first_name) like '%HA%';

---18. ������ 'ACCOUNT'�� ���� �� �μ��� ����� 5000�̻��� �μ��� 
-- ��� �޿�, �հ� , �ּ� , �ִ븦 ���Ͻÿ�.
select department_id, avg(salary), sum(salary), min(salary), max(salary)
from hr.employees
where upper(job_id) like '%ACCOUNT%'
group by department_id
having avg(salary) >= 5000;

---19. ���� ��ȣ(location_id)�� 2000���� 2500�� ������ 
-- ������ȣ(location_id),�ּ�, �����ȣ, ����, ���� ��ȣ(country_id)
-- ���� �̸�(country_name) ,���� ��ȣ(region_id), ���� �̸� ���
-- �� ������ȣ�� ���� ��������
select location_id, street_address, postal_code, city, l.country_id,
       country_name, c.region_id, region_name
from hr.locations l join hr.countries c
on l.country_id = c.country_id
join hr.regions r on r.region_id = c.region_id
where location_id between 2000 and 2500
order by location_id asc;
       
-- 20. �ּ� �޿��� 10000�̻��� ������� ���� ������ ����Ͻÿ�.
-- �� ���� ���� ������������ �����Ͻÿ�.
select job_id, job_title
from hr.jobs
where min_salary >= 10000
order by job_id desc;

--21. 's'�� ���� �ʴ� ������ �����ȣ�� �ּ�,
-- ������� ������ȣ(region_id)�� ����Ͻÿ�.
select postal_code, street_address, country_name, region_id
from hr.locations l join hr.countries c
on l.country_id = c.country_id
where lower(city) not like '%s%';

-- 22.05/12/15 ���Ŀ� �Ի��� �����?
-- salary ������ ��������
select * from hr.employees
where hire_date >= '05/12/15'
order by salary desc;

--- 23. �ּұ޿��� �ּڰ�, �ִ� �޿��� �ִ�
-- ���� ���� ������(start_date)�� ���� ���� ������(end_date)�� ���Ͻÿ�.
select min(min_salary), max(max_salary), min(start_date), max(end_date)
from hr.job_history jh join hr.jobs j
on jh.job_id = j.job_id;

--24. ��簡 ���� ����� �μ� ��ȣ�� �μ� �̸�, �̸���, �޿��� ���Ͻÿ�.
select d.department_id, department_name, email, salary
from hr.departments d join hr.employees e
on d.department_id = e.department_id
where e.manager_id is null;

--25. �μ� ��ȣ�� 50�� 80�� ����� ���� ��ȣ, ��, �̸�, �޴��� ��ȣ, ������� ���Ͻÿ�.
select employee_id, last_name, first_name, phone_number, hire_date
from hr.employees
where department_id in (50, 80);

-- 26. �μ��� �ִ� ���� ��� ���
select * from hr.employees
where department_id is not null;

-- 27. countrys ���̺��� ��ȣ,�̸�, regoin_    id�� ����ϸ鼭
--     regions ���̺��� �з��̸��� ���� ����ϼ���
--     locations ���̺��� ������ȣ�� ���ø� ����ϼ���
select c.country_id, country_name, c.region_id,
       region_name,
       l.country_id, city
from hr.countries c join hr.regions r
on c.region_id = r.region_id
join hr.locations l on l.country_id = c.country_id;

-- 28. �μ���ȣ �μ����� ����ϸ鼭
--     �μ���ȣ�� 100�̳��̸鼭 ���� ��ȣ��  200�̻��ΰ͸� ����ϼ���
select d.department_id, department_name
from hr.departments d join hr.employees e
on d.department_id = e.department_id
where e.department_id <= 100 and e.employee_id >= 200;

-- 29. �μ� ���̺��� �μ���ȣ,�μ���, ������ȣ��
--     ���� ���̺��� ���� ������ȣ�� ����ϸ鼭
--     ���� ���̺��� ������ȣ ���� �̸��� ����ϼ���.
select department_id, manager_id, d.location_id,
       city, l.country_id,
       c.country_id, country_name
from hr.departments d join hr.locations l
on d.location_id = l.location_id
join hr.countries c on l.country_id = c.country_id;

-- 30. ������ȣ �� �̸��� ���� ���� ��������ϸ鼭
--     ������ȣ �� AD_PRES �̸鼭
--     �̸��� ���̰� 5�� ����� ����Ͻÿ�
select employee_id, last_name, email, e.job_id, job_title
from hr.employees e join hr.jobs j
on e.job_id = j.job_id
where e.job_id = 'AD_PRES' and length(email) = 5;