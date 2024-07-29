-- 1. Ŀ�̼��� null�̶�� Ŀ�̼� ���� 0���� �����Ͽ� �̸�, �μ�, �Ի���, ����,
--     �޿�, Ŀ�̼�, �׸��� ����� ����ϼ���.
select first_name, department_id, hire_date, job_id, salary, nvl(commission_pct, 0), salary * 12
from hr.employees;
---2. 03/06/17���Ŀ� �Ի��� �����?
select * from hr.employees where hire_date >= '03/06/17';
---3. 17/06/03(�Ͽ���)���Ŀ� �Ի��� �����?
select * from hr.employees where hire_date >= to_date('17/06/03', 'DD/MM/YY');
--4. 06/17/03(���ϳ�)���Ŀ� �Ի��� �����?
select * from hr.employees where hire_date >= to_date('06/17/03', 'MM/DD/YY');
--5.. ���� ��ȯ�Լ� : ��¥�� ���� ��ȯ
--   ���糯¥�� ��-��-��, ��-����, �����-��-��, �����-��-�� ��:��:�� ����/����, 
---  �����-��-�� 24��:��:�� ����/���� ������ ���
select to_char(sysdate, 'YY-MM-DD') from dual;
select to_char(sysdate, 'DD-MM-YY') from dual;
select to_char(sysdate, 'YYYY-MM-DD') from dual;
select to_char(sysdate, 'YYYY-MM-DD HH:mi:ss AM') from dual;
select to_char(sysdate, 'YYYY-MM-DD HH24:mi:ss AM') from dual;
-- 6. 25-04-2003 ���� �ʰ� �Ի��� ����� ����ϴ� �����̴� �� ������ ��� �ٸ��� ����Ͻÿ�. 
1)
SELECT * FROM EMPLOYEES WHERE TO_CHAR(HIRE_DATE, 'DD-MM-YYYY') > '25-04-2003';
-- DB�� hire_date column�� ������ ������ dd-mm-yyyy �������� �ٲ㼭 �˻� �� ���
2)
-- �Է¹��� ��¥�� ������ to_date()�� �Ἥ ��-��-�Ϸ� ����ȯ �� �˻� �� ���
SELECT * FROM EMPLOYEES WHERE HIRE_DATE > TO_DATE('25-04-2003', 'DD-MM-YYYY');

7. ���ڸ� ���ڿ���
--- 1,234,567�� W1,234,567, $1,234,567, $1,234,567- �������� ����Ͻÿ�. 
select to_char(1234567, 'L9,999,999') from dual;
select to_char(1234567, '$9,999,999') from dual;
select to_char(-1234567, '$9,999,999mi') from dual;
8. �̸�, ��, ���� �μ� �׸��� �޿��� ���ڸ��� ,�� ��� $�� ��µǰ� �Ͻÿ�.
select first_name, last_name, job_id, department_id,
to_char(salary, '$999,999,999') from hr.employees;
9. janette�Ǵ� JANETTE �Ǵ� jaNette ���� ���� �޾Ҵ�.
---   �̸��� 'Janette'�� ����� ����Ͻÿ�.
select * from hr.employees where first_name = INITCAP('janette');
select * from hr.employees where first_name = INITCAP('JANETTE');
select * from hr.employees where first_name = INITCAP('jaNette');
10. --- job_id�� 'IT_PROG' �޿��� 10%���
--                  'ST_CLERK' �޿��� 15%���
--                  'SA_REP' �޿��� 20%���
--                   ���ܴ̿� �޿�
-- ��, �̸�, �޿��� ���� ��� 
select last_name, first_name, salary,
case job_id when 'IT_PROG' then salary * 1.1
            when 'ST_CLERK' then salary * 1.15
            when 'SA_REP' then salary * 1.2
            else salary end as newsal
from hr.employees;

11. ��, �̸�, ����, �޿�, �޿��� ���� ��å�� ���� ����ϼ���.
--- �޿��� 3000�����̸� ��� 
--        5000�����̸� ����
--        7000�����̸� �븮
--        9000�����̸� ����
--       11000�����̸� ����
--       13000�����̸� ����
--       �� �̻� �̸� �ӿ�
select last_name, first_name, job_id, salary,
       case when salary <= 3000 then '���'
            when salary <= 5000 then '����'
            when salary <= 7000 then '�븮'
            when salary <= 9000 then '����'
            when salary <= 11000 then '����'
            when salary <= 13000 then '����'
            else '�ӿ�' end
from hr.employees;
12. �޿��� ���� ������ ����ϰ� �ʹ�. �̸� , ��, �޿�, ����, ������ ����Ͻÿ�.
---  �޿��� 2000���� ���� ���� 0�̸� �޿��� 0%
---                         1�̸� �޿��� 9%
---                         2�̸� �޿��� 20%
---                         3�̸� �޿��� 30%
---                         4�̸� �޿��� 40%
---                         5�̸� �޿��� 42%
---                         6�̸� �޿��� 44%
---                         �̿� �޿��� 45% �����̴�.
-- trunc(salary / 2000)
select first_name, last_name, salary, job_id,
case salary / 2000 when 0 then 0
                   when 1 then salary * 0.09
                   when 2 then salary * 0.2
                   when 3 then salary * 0.3
                   when 4 then salary * 0.4
                   when 5 then salary * 0.42
                   when 6 then salary * 0.44
                   else salary * 0.45 end as tax
from hr.employees;

13. ���� �̸��� �ٿ��� ����Ͻÿ�.
select '���� �̸��� ' || last_name || first_name || '�Դϴ�.'
from employees;
-- �� �ڵ带 concat�� ����ؼ� ���ȭ�ÿ�.
select concat(concat('���� �̸���', last_name), concat(first_name, '�Դϴ�')) from hr.employees;
14. nvl
-- ��, �̸�, ����, �޿�, Ŀ�̼��� ������ ���, null�� ��� 0���� 
select last_name, first_name, job_id, salary, nvl((1 + commission_pct) * salary * 12, 0)
from hr.employees;

15. nvl2
last_name, first_name, job_id, salary �� ����� �� nvl2�� �̿��ؼ� commission�� ������ ����� ���Ͻÿ�.
select last_name, first_name, job_id, salary, nvl2((1 + commission_pct) * salary * 12, (1 + commission_pct) * salary * 12, 0)
from hr.employees;

16. nullif 
�̸��� ũ��� �̸����� ũ�⸦ ���ؼ� ���� ������ null�� �ٸ��� �̸��� ũ�Ⱑ ��µǰ� �Ͻÿ�.
�̸��� �̸��ϵ� ���� ���
select nullif(length(first_name),length(email)) from hr.employees;
17.coalesce�Լ��� �̿��ؼ� ����� ���Ͻÿ�. �̸�, �޿� Ŀ�̼ǵ� ���� ���
select first_name, salary, commission_pct, coalesce((1 + commission_pct) * salary * 12, 0) from hr.employees;
--  ������ �Լ�
18. �޿��� ���� ���� �޴� ����� ���� �޴� ����� ���, �޿� ���
select max(salary), min(salary), avg(salary) from hr.employees;

19. �޿��� �޴� ����� ����, �μ��� ������ �ִ� ����� ���� ����Ͻÿ�.
select count(salary), count(department_id) from hr.employees;

20. Ŀ�̼��� �޴� ������� Ŀ�̼��� ��հ� ���� ��ü�� Ŀ�̼� ����� ���Ͻÿ�.
select count(commission_pct), avg(commission_pct), avg(nvl(commission_pct, 0)) from hr.employees;
21. ��ü�� ����� ���� ���Ͻÿ�. (�� ��ü�� ����)
select count(*) from hr.employees;
22. ���� �ʰ� �Ի��� ����� ���� ó���� �Ի��� ����� ����Ͻÿ�.
select max(hire_date), min(hire_date) from hr.employees;
23.������ 'REP'�� ������ �ִ� ����� �� ���� ���� �޴� �޿��� ���� �޴� �޿��� ���,
--    ��� �޿��� ����� ��, �޿��� �հ� 
select job_id, max(salary), min(salary),avg(salary), count(*), sum(salary) 
from hr.employees
group by job_id
having job_id like '%REP%';

24.80�� �μ����� Ŀ�̼��� �޴� ����� ���� �ִ� Ŀ�̼� ���� �ּ� Ŀ�̼� ���� ���
--     �μ��� ���� �ִ� ����� �� 
select department_id, count(commission_pct), max(commission_pct), min(commission_pct)
from hr.employees
group by department_id
having department_id = 80;
25. �ߺ����� ���� �μ����� ���?
select department_id 
from hr.employees
group by department_id
having count(department_id) = 1;
26. �ߺ����� ���� �μ��� ����?
select sum(count(department_id))
from hr.employees
group by department_id
having count(department_id) = 1;
27. Ŀ�̼��� �޴� ����� Ŀ�̼� ��հ� 
--    Ŀ�̼��� ���� �ʴ� ����� ������ Ŀ�̼��� ����� ���Ͻÿ�.
select avg(commission_pct), avg(nvl(commission_pct, 0))
from hr.employees;

28. 90�κμ��� �޿��� ���, �հ�, �ִ�, �ּ�, ����� ��
select avg(salary), sum(salary), max(salary), min(salary), count(*)
from hr.employees
group by department_id
having department_id = 90;
29. 80�κμ��� �޿��� ���, �հ�, �ִ�, �ּ�, ����� ��
select avg(salary), sum(salary), max(salary), min(salary), count(*)
from hr.employees
group by department_id
having department_id = 80;
30. 70�κμ��� �޿��� ���, �հ�, �ִ�, �ּ�, ����� ��
select avg(salary), sum(salary), max(salary), min(salary), count(*)
from hr.employees
group by department_id
having department_id = 70;