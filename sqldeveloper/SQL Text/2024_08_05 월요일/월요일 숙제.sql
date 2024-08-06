-- 1. ������ ���������� ���������� ����ϴ� ���������� ����
-- ������ ����Ͻÿ�. job_history�� �̿�
select * from hr.job_history;
select e.employee_id, first_name, salary, start_date, end_date
from hr.employees e left outer join hr.job_history jh
on e.employee_id = jh.employee_id;

-- 2. ������ 4��°���� 6��°���� PRO�� �ִٸ� it_program���� ���
--                                 ACC�� �ִٸ� finance_account
--                                 �������� business�� ����Ͻÿ�.
select job_id,
case substr(job_id, 4, 3) when 'PRO' then 'it_program'
                          when 'ACC' then 'finance_account'
                          else 'business' end
from hr.employees;


-- 3. �޿��� 15000 �̻��̸� �ӿ����� ���
--             10000 �̻��̸� ����
--             7000  �̻��̸� ����
--             5000�̻��̸� �븮
--             �������� ������� ����Ͻÿ�.
select salary,
case when salary >= 15000 then '�ӿ�'
            when salary >= 10000 then '����'
            when salary >= 7000 then '����'
            when salary >= 5000 then '�븮'
            else '�븮' end
from hr.employees;

-- 4. �μ��� �޿��� ����� 5000�̻��� �μ��� ����Ͻÿ�.
select e.department_id, department_name, avg(salary)
from hr.employees e join hr.departments d
on e.department_id = d.department_id
group by e.department_id, department_name
having avg(salary) >= 5000;

-- 5. �޿��� 10000�̻��� ������� �μ��� �޿� ����� 16000�̻��� �μ��� ����Ͻÿ�
select e.department_id, department_name, avg(salary)
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where salary >= 10000
group by e.department_id, department_name
having avg(salary) >= 16000;

-- 6. �Ի����� 2005�⵵  ������ �Ի��� ����� �� �μ��� �ִ�޿��� 8000�̻��� �μ��� �ִ� �޿��� ����Ͻÿ�.
select e.department_id, department_name, max(salary)
from hr.employees e join hr.departments d
on e.department_id = d.department_id
where hire_date <= '05/01/01'
group by e.department_id, department_name
having max(salary) >= 8000;

-- 7. �μ��� �ִ� �޿��� 10000�̻��� �μ��� ����Ͻÿ�.
select e.department_id, department_name, max(salary)
from hr.employees e join hr.departments d
on e.department_id = d.department_id
group by e.department_id, department_name
having max(salary) >= 10000;

-- 8. ������ 'REP'�����ϰ� ���� ���� ������� ������ �޿��� �հ谡 3000�� �ʰ��ϴ� ������ �޿��� �հ踦 ����Ͻÿ�.
-- ���� �޿��� �հ踦 ������������ �����Ͽ� ���
select job_id, sum(salary)
from hr.employees
where job_id not like '%REP%'
group by job_id
having sum(salary) > 3000
order by sum(salary) desc;

-- 9.  ������ 25-10-2020������ �ٹ��ϼ��� ����Ͻÿ�.
-- ������ȣ, �μ���ȣ, �Ի���, �ٹ��ϼ�
select employee_id, department_id, hire_date, (to_date('25-10-2020', 'DD-MM-YYYY')-hire_date)
from hr.employees;

-- 10. '01-01-2005'�� �Ի��� ����� ����Ͻÿ�.
-- ������ȣ, �μ���ȣ, �Ի���, �ٹ��ϼ�
select employee_id, department_id, hire_date, sysdate - hire_date
from hr.employees where hire_date = to_date('01-01-2005', 'DD-MM-YYYY');

-- 11. ����(�޿�*12) : �޿��� Ŀ�̼Ǳ��� ���Եȴ�.
-- ������ ����� ���Ͻÿ�.
-- ������ȣ, �μ���ȣ, �޿�, ���
select employee_id, department_id, salary * nvl(commission_pct, 1), (nvl(commission_pct, 0) + 1) * salary * 12
from hr.employees;

-- 12.  'IT_PROG' �̸� �޿���  1.10*salary
--      'ST_CLERK' �̸� �޿���  1.15*salary
--      'SA_REP' �̸�  �޿��� 1.20*salary
--       ������ ������ salary �� �޿��� �����ϰ� heading name��      "REVISED_SALARY"�� �ǰ� �Ͻÿ�.
select SALARY, JOB_ID,
case job_id when 'IT_PROG' THEN SALARY*1.10
            WHEN 'ST_CLERK' THEN SALARY*1.15
            WHEN 'SA_REP' THEN SALARY*1.20
            ELSE SALARY END REVISED_SALARY
FROM HR.EMPLOYEES;

-- 13 Ŀ�̼��� ������ �޿��� ����� ���Ͻÿ�. Ŀ�̼��� �ٴ��� ���� ������ ����
SELECT AVG(SALARY * NVL(COMMISSION_PCT, 1))
FROM HR.EMPLOYEES;

-- 14. ���μ��� Ŀ�̼��� ������ �޿��� �հ踦 ���Ͻÿ�.
select department_id, avg(salary * nvl(commission_pct, 1))
from hr.employees
group by department_id;

-- 15. �� �μ��� �������� 5�� �̻��� �μ��� ����Ͻÿ�. (join�ƴ�)
select department_id
from hr.employees
group by department_id
having count(department_id) >= 5;

-- 16. �� �μ��� �ִ� ����� ������ �޿��� ����� ���Ͻÿ�.
select department_id, job_id, avg(salary)
from hr.employees
group by department_id, job_id;

-- 17. �����ȣ, �̸� , �޿�, �Ի��� , �μ���ȣ, �μ���, ������ȣ, �������� ����� �� 
-- ������� �ʴ� ������ ����ϰ� ����� ���� ������ ����Ͻÿ�.
select employee_id, first_name, salary, hire_date, d.department_id, department_name, j.job_id
from hr.employees e left outer join hr.departments d
on e.department_id = d.department_id
right join hr.jobs j
on e.job_id = j.job_id;

-- 18. ������̺��� ������ MAN�� �����ϰ� �޿��� 10000�̻��� 
-- ����� �����ȣ�� ���� ���� �׸��� �޿��� ����Ͻÿ�.
select employee_id, last_name, job_id, salary
from hr.employees
where job_id like '%MAN%' and salary >= 10000;

-- 19. ������ SA_REP�� AD_PRES �̸鼭 �޿��� 15000�� �ʰ��ϴ�  ����� ����Ͻÿ�.
-- ��, ��, ����, �޿��� ��� or�� and�� ���
select last_name, job_id, salary
from hr.employees 
where job_id = 'SA_REP' or job_id = 'AD_PRES';

-- 20. �� ������ in�����ڸ� ����Ͻÿ�.
select last_name, job_id, salary
from hr.employees 
where job_id in ('SA_REP', 'AD_PRES');

-- 21. �μ��� ������������ �����ϰ� �Ի��ϵ� ������������ ����
-- �μ���ȣ , �޿�, �Ի���, ��
select department_id, salary, hire_date, last_name
from hr.employees
order by department_id, hire_date desc;

-- 22. �μ��� ������������ �����ϰ� �Ի����� ������������ �����Ͽ� ���
-- �μ���ȣ , �޿�, �Ի���, ��
select department_id, salary, hire_date, last_name
from hr.employees
order by department_id desc, hire_Date asc;

-- 23. �μ��� ������������ �����ϰ� �Ի����� ������������ �����Ͽ� 
-- �޿��� ������������ �����Ͽ� ���
-- �μ���ȣ ,  �Ի���, �޿�, ��
select department_id, hire_date, salary, last_name
from hr.employees
order by department_id desc, hire_date asc, salary desc;