-- 1. �̸��� 'AN'�� ���� �ʴ� ������
-- ���� ��ȣ, �̸�, �μ�, �μ���, ������, ���������� ����Ͻÿ�
-- ��, �̸��� �ҹ���, �빮�� �������
select employee_id, first_name, department_id, j.job_id, job_title
from hr.employees e join hr.jobs j
on e.job_id = j.job_id and upper(first_name) not like upper('%AN%');
-- 2. ���� ���� �� �����ȣ, �̸�, ������ ����� �� ���������� ����ϰ�
-- �μ���� ������ȣ�� ����ϼ���
select employee_id, first_name, 
       j.job_id, job_title, 
       d.manager_id, location_id
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.jobs j on e.job_id = j.job_id;

-- 3. �������� �����ȣ, �̸� , �޿�, ����, ���������� ����Ҷ�
-- �μ� ���� ���̺��� �μ���, �μ����� ����Ͻÿ�.
select employee_id, first_name, salary, 
       j.job_id, job_title,
       d.department_id, d.manager_id
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.jobs j on e.job_id = j.job_id;

-- 4. ����, ��, �޿�, ����, ���������� ����ϰ� 
-- ���� �����丮 ���̺��� �� ������ �����ϰ� �������� �� ����Ͻÿ�.
select e.employee_id, last_name, salary,
       j.job_id, job_title,
       start_date, end_date
from hr.employees e join hr.jobs j
on e.job_id = j.job_id
join hr.job_history jh on e.employee_id = jh.employee_id;

-- 5. ����, ����, �μ�, �μ��� using ����Ͽ� ����Ͻÿ�.
select employee_id, job_id, department_id, department_name
from hr.employees e join hr.departments d
using(department_id);
-- 6.countries ���̺��� ������ȣ �� ���� �̸� ����ϰ�
-- regions ���̺��� ������ �з���ȣ �� �з��̸��� ����Ͻÿ�
select country_id, country_name,
       r.region_id, region_name
from hr.countries c join hr.regions r
on c.region_id = r.region_id;

-- 7. ������ȣ, ��, �̸�, ����, �μ���ȣ, ������ȣ, ��������, �ּҸ� ���
select employee_id, last_name, first_name, e.job_id, e.department_id, d.location_id, job_title, street_address
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.jobs j on j.job_id = e.job_id
join hr.locations l on l.location_id = d.location_id;
-- 8. Ŀ�̼��� null�� ����� �μ����� ����Ͻÿ�
select department_name 
from hr.departments d join hr.employees e
on d.department_id = e.department_id and e.commission_pct is null;

-- 9. �μ����� ��, �̸�, Ŀ�̼��� ����Ͻÿ�.
select last_name, first_name, commission_pct
from hr.employees e join hr.departments d
on e.employee_id = d.manager_id;

-- 10. �μ����� ���� �� �������� ��, �̸�, �̸����� ����Ͻÿ�.
select last_name, first_name, email
from hr.employees e join hr.departments d
on e.manager_id = d.manager_id;

-- 11. ������ ���� �μ��� ansi join ������� ����Ͻÿ�.
select e.employee_id, d.department_id
from hr.employees e right outer join hr.departments d
on e.department_id = d.department_id
and employee_id is null;

-- 12. �ش� ������ �����޿��� �޴� ����� ������ ����Ͻÿ�
--    ���, �̸�, ����, �޿�, �����޿�
select employee_id, first_name, job_id, salary, min(salary)
from hr.employees
group by employee_id, first_name, job_id, salary;

-- 13.�μ� ��ġ�� 1800�� �μ��� �����ڵ�, ������, �����ڵ�, �������� ����Ͻÿ�
select c.country_id, c.country_name, r.region_id, r.region_name
from hr.departments d join hr.locations l
on d.location_id = l.location_id
join hr.countries c on l.country_id = c.country_id
join hr.regions r on c.region_id = r.region_id;

-- 14. �μ����� �޿��� �ش� ������ ���� �޿� �̻��� �μ����� ������ ����Ͻÿ�
-- ���, ��, ����, �μ���, ���, �޿�, �����޿�
select employee_id, last_name, job_id, department_name, d.manager_id, salary, min(salary)
from hr.employees e join hr.departments d
on e.employee_id = d.manager_id
group by employee_id, last_name, job_id, department_name, d.manager_id, salary
having salary >= min(salary);

-- 15. ����� 201���� ����ڿ� ��� �� �μ���ȣ�� ���� ����� ������ ����Ͻÿ�
--    ���, �̸�, �μ���ȣ, �μ���
select * from hr.job_history;
select e.employee_id, first_name, e.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.job_history jh on e.employee_id = jh.employee_id
and e.employee_id = 201;

-- 16. ��簡 �μ����� ����� �̸��� �μ����� ����Ͻÿ�
select first_name, department_name
from hr.employees e right outer join hr.departments d
on e.manager_id = d.manager_id;

-- 17. ������ �� ������ AD_VP�� ����� ���������� ����Ͻÿ�.
--    ���� �̸�, ������ȣ, ������ȣ, �������� ���
select first_name, employee_id, e.job_id, job_title
from hr.employees e join hr.jobs j
on e.job_id = j.job_id and e.job_id = 'AD_VP';

-- 18. �μ����� ����� ������ �μ��̸��� ��������, �ְ����� ���Ͻÿ�.
--    �̸�, �μ����ȣ, �μ���ȣ, ��������, �ְ��� ���
select d.department_id,
min((nvl(commission_pct, 0) + 1) * salary * 12),
max((nvl(commission_pct, 0) + 1) * salary * 12)
from hr.employees e join hr.departments d
on e.manager_id = d.manager_id
group by d.department_id;

select first_name, manager_id, department_id, min((nvl(commission_pct, 0) + 1) * salary * 12),
max((nvl(commission_pct, 0) + 1) * salary * 12)
-- 19. �Ի����� '03/06/17' ������ ������� �μ��� ������ȣ�� ���
--    �����ȣ, �̸�, �Ի���, �μ���ȣ, �μ���, ������ȣ ���
select employee_id, first_name, hire_date, d.department_id, department_name, location_id
from hr.employees e join hr.departments d
on e.department_id = d.department_id and e.hire_date > '03/06/17';

-- 20. �̸��� 'Payam' ������ ������� ���Ͻÿ�.
--    �����ȣ, �̸�, �μ���ȣ, �μ��̸�, ������� ���
select e.employee_id, first_name, d.department_id, department_name, end_date
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.job_history jh on e.employee_id = jh.employee_id
and first_name = 'Payam';

-- 21. ����� ���� �μ��� �ּҸ� ����ϼ���.
--     �μ���ȣ, �μ��̸�, �ּ� ���
select department_id, department_name, street_address
from hr.departments d join hr.locations l
on d.location_id = l.location_id and manager_id is null;

-- 22. ��簡���� ����� �μ����� ������ּ���.
select department_name
from hr.departments d join hr.employees e
on d.department_id = e.department_id
and e.manager_id is null;

-- 23. ������ȣ, ��, �̸�, ������ȣ, �������� ����ϰ� �ִ�޿��� 20000�̻��� ������ ������ּ���.
select employee_id, last_name, first_name, e.job_id, job_title
from hr.employees e join hr.jobs j
on e.job_id = j.job_id
group by employee_id, last_name, first_name, e.job_id, job_title
having max(salary) >= 20000;

-- 24. ������ȣ, ��, �̸�, �μ���ȣ, ������ȣ, �����ȣ�� ����ϴµ� �����ȣ�� ���� ������ ������ּ���.
select e.employee_id, last_name, first_name, d.department_id, d.location_id, postal_code
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.locations l on d.location_id = l.location_id
where postal_code is null;

-- 25. �μ���ȣ, �μ���, ������ȣ, ���ø� ����ϰ� �μ���ȣ�� 80�� ���ø� ������ּ���
select department_id, department_name, d.location_id, city
from hr.departments d join hr.locations l
on d.location_id = l.location_id
and department_id = 80;

-- 26. �����ȣ, ��, �̸�, �μ���ȣ, �μ����� ����ϰ� �̸��� 'james'�� ����� ���(�����Լ����)
select employee_id, last_name, first_name, e.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
and upper(first_name) = upper('james');

-- 27. ��, �̸�, �μ���ȣ, �μ����� ����ϰ� 03����� 05����� ������������ ������ּ���.
select last_name, first_name, e.department_id, department_name, hire_date
from hr.employees e join hr.departments d
on e.department_id = d.department_id
and hire_date between '03/01/01' and '05/12/31'
order by hire_date asc;

-- 28. ������, �����ȣ, ��, �̸�, �޿��� ����ϰ� �޿��� 3000���� 5000���̸� ���ϰ� �޿��� ������������ �����ϼ���.
select job_id, employee_id, last_name, first_name, salary
from hr.employees where salary between 3000 and 5000
order by salary asc;

-- 29. �����ȣ, ��, �̸�, �޿�, �μ�, �μ����� ����ϰ�, 
-- �޿��� 6000�̻��� ������ ������������ ������ ���� �̸��� �տ� 3���ڸ� ǥ���ϰ� �������� '*'�� ǥ���ϼ���.
select employee_id, last_name, rpad(substr(first_name, 1, 3), length(first_name), '*'), salary, e.department_id, department_name
from hr.employees e join hr.departments d
on e.department_id = d.department_id
and salary >= 6000
order by salary desc;

-- 30.�̱� ����� �ƴ� ������ ��, �̸�, ��������, ������, �ּ�, ���� ��ȣ�� ���
select last_name, first_name, 
       job_title, --employees
       country_name, --countries
       street_address, postal_code   --locations
from hr.employees e join hr.departments d
on e.department_id = d.department_id
join hr.locations l on d.location_id = l.location_id
join hr.countries c on l.country_id = c.country_id
join hr.jobs j on e.job_id = j.job_id
and c.country_id != 'US';