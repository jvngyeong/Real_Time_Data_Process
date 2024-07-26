-- �������� : ���ϴ� ���� ���������� �Ѵ�.
-- ���� ����
select * from hr.employees;
-- 1. ������ȣ, �̸� , �̸���, �Ի��� 
select employee_id, first_name, email, hire_date from hr.employees;

-- 2. ������ȣ, �̸� , �޿�, �� ��� �޿��� 100���Ͻÿ�
select employee_id, first_name, salary + 100 from hr.employees;
-- 3. ������ȣ, ��, �Ի���, ����, ������ ����Ͻÿ�
-- ���࿡ �ִ� ���� ������ ��밡��
select employee_id, last_name, hire_date, job_id, salary * 12 from hr.employees;

-- �μ�����
select * from hr.departments;
--- 4. �ּ�, �μ���ȣ, �μ����ȣ, �μ�������� ���
-- �÷��� ������ �������� ��밡��
select location_id, department_id, manager_id, department_name from hr.departments;
-- 5. ������̺��� ������ȣ , �Ի���, ��, �޿������� ���
-- �÷��� ������ �������� ��밡��
select employee_id, hire_date, last_name, salary from hr.employees;
-- 6. ����:
-- ������̺��� �����ȣ, �μ���ȣ , ����, ������ ����ϴµ� 
-- �ſ� 300�� ���ʽ��� ������ �ȴ�.
select employee_id, department_id,job_id, (salary+300)*12 from hr.employees;

-- 7. ������̺��� �����ȣ, �μ���ȣ , ����, ������ ����ϴµ� 
-- ������ �޿� 300�� Ư�� ���ʽ��� ������ �ȴ�.
select employee_id, department_id, job_id, salary*12 + 300 from hr.employees;

-- 8. ������̺��� �����ȣ, ��, �̸��� , �޿��� ���� Ŀ�̼��� 30%�� �����̵� ��
-- Ŀ�̼� ���� ����Ͻÿ�.
select employee_id, last_name, email, salary, salary*0.3 as commission from hr.employees;

-- 9.  ������̺��� ������ȣ �̸��� �̸� �Ի��� �޿�, Ŀ�̼��ۼ�Ʈ�� ���
select employee_id, email, first_name, hire_date, salary, commission_pct from hr.employees;

-- 10.  ������̺��� ������ȣ �̸��� �̸� �Ի��� �޿�, Ŀ�̼��ۼ�Ʈ�� ����ϴµ�
-- �� ����� �޴� Ŀ�̼��� �ݾ׵� ���� ����Ͻÿ�.
select employee_id, email, first_name, hire_date, salary, commission_pct, salary*commission_pct from hr.employees;

-- 11. ������ȣ, �̸���, �̸�, �Ի���, ����ó, �μ���ȣ, �޿�, Ŀ�̼��ۼ�Ʈ, 
-- �׸��� Ŀ�̼��� ���ѵ� ������ ����Ͻÿ�,
select employee_id, email, first_name, hire_date, salary, commission_pct, (salary + salary*commission_pct)*12 from hr.employees;

--12.  heading name�� ��Ī �ֱ� (as�� ����ϴ� �Ͱ� ������� �ʴ°��� ȥ���� ����) 
-- �����ȣ eid�� �̸���, ���� lname���� �Ի����� hd�� ����ó�� ph�� �μ���ȣ�� did�� �޿��� sal�� Ŀ�̼��� comm����
-- Ŀ�̼��� ������ ����� year_sal�� ��Ī�� �༭ ����Ͻÿ�. �� eamil�� ��Ī�� ���� �ʴ´�.
select employee_id eid, last_name lname, hire_date as hd, phone_number as ph, department_id as did,
salary as sal, commission_pct as comm, (salary + salary*commission_pct)*12 as year_sal from hr.employees;
-- 13. employee_id,  '���� ���� last_name' , first_name , �޿��� ����ϼ���.
select employee_id, '���� ���� ' || last_name, first_name, salary from hr.employees;
-- 14 �����ȣ, �̸� �޿� �μ���ȣ�� ����� ��  ���ͳ� ��¥ 2021-11-19�� ���� 35��  ���� ����ϼ���.,
select employee_id, first_name, salary, department_id, '2021-11-19', 35 from hr.employees;
--- 15. ������ȣ, last_name first_name(KingSteven),�޿�, ���� ���
select employee_id, last_name || first_name, salary, job_id from hr.employees;
--16. 15���������� ���� �̸��� ���鹮�ڸ� ����.
select employee_id, last_name || ' ' || first_name, salary, job_id from hr.employees;
-- 17. �����ȣ�� �޿��� ����ϴ� ���̿� �Ʒ� ������ ��µǰ� �Ͻÿ�. 
-- "KingSteven�� ������ AD_PRES�Դϴ�"�� �������.
select last_name || ' ' || first_name || '�� ������ ' || job_id || '�Դϴ�.' from hr.employees;
-- 18. ������ �μ���ȣ�� ����Ͻÿ�.
select department_id from hr.employees;
-- 19. ������ �μ��� ��� ������� ���� �ѹ����� ����Ͻÿ�.
--     ������ �����ִ� �μ��� ��� �μ������� �˰� �ʹ�.
select DISTINCT department_id from hr.employees;
-- 20.������ �μ��� ���� ���� ������ �ѹ��� ����Ͻÿ�.
select DISTINCT job_id, department_id from hr.employees;
---21. ������ �Ի����� �ߺ����� �ʰ� ����Ͻÿ�.
select DISTINCT job_id, hire_date from hr.employees;
-- 22. 90�� �μ��� ������� ����Ͻÿ�. 
select * from hr.employees where department_id = 90;
-- 23. �����ȣ, ��, �̸�, �޿��� ���
select employee_id, last_name, first_name, salary from hr.employees;
-- 24. 90�� �μ��� ������� ����� �� �����ȣ, �̸� , ��, �޿� ���
select employee_id, last_name, first_name, salary from hr.employees where department_id = 90;
-- 25. �̸��� 'Nancy'�� ����� �Ի��� , ����, �޿�, Ŀ�̼��ۼ�Ʈ�� ����ϼ���.
-- ���ڿ� ���ͳ��� ��쿡�� ��ҹ��ڸ� �����Ͽ� ����ؾ� �Ѵ�.
select hire_date, job_id, salary, commission_pct from hr.employees where first_name = 'Nancy';

-- 26. �Ի����� 06/01/03�� ����� ����Ͻÿ�.
select * from hr.employees where hire_date = '06.01.03';

-- �� ����(���迬��) :  =, >, >=, <, <=, <>, !=, ^=
-- 27. �޿��� 3000�̻��� ������� ��, �޿��� ����Ͻÿ�.
select last_name, salary from hr.employees where salary >= 3000;

-- 28. �Ի����� 06/01/03���� �ʰ� �Ի��� ������ �����ȣ �̸� �޿��� ����Ͻÿ�.
select employee_id, last_name, salary from hr.employees where hire_date > '06.01.03';
-- 30. �޿��� 3000�� �ƴ� ����� ��� ����Ͻÿ�.
select * from hr.employees where salary != 3000;
-- 31. �޿��� 2500���� 3500������ ����� �� �����ȣ�� �̸�, �޿�, ����, �Ի����� ���
select employee_id, last_name, salary, job_id, hire_date from hr.employees where salary between 2500 and 3500;
-- 32. ���� King����  Smith���̿� �ִ� ������� ����Ͻÿ�.
select * from hr.employees where last_name between 'King' and 'Smith';
-- 33. �Ի����� 02/06/07���� 06/01/03���̿� �Ի��� ������� ����Ͻÿ�.
select * from hr.employees where hire_date between '02.06.07' and '06.01.03';
-- 34. 50, 70, 90�� �μ��� ������� ����ϼ���.
select * from hr.employees where department_id in(50, 70, 90);
-- 35. ��簡 100,101,102�� ������� ���Ͻÿ�.
select * from hr.employees where manager_id in (100,101,102);
-- 36. ���� 'Hartstein', 'Vargas'�� ������� ����Ͻÿ�.
select * from hr.employees where last_name in('Hartstein', 'Vargas');

-- 37. ������ ������ȣ�� 100���̴�. ������ ���ӻ���� �����?
select * from hr.employees where manager_id = 100;

-- like
-- 38. ���� s�� ���ԵǾ� �ִ� ������ ����ϼ���.
select * from hr.employees where last_name LIKE '%s%';
-- 39. ������ 'CL'�� �����ѵ� ������� ����Ͻÿ�.
select * from hr.employees where job_id LIKE '%CL%';
-- 40. ������ 'ST'�� �����ѵ� ������� ����Ͻÿ�
select * from hr.employees where job_id LIKE '%ST%';

-- 41. �̸��� 'B'�� �����ϴ� ������ ����ϼ���.
select * from hr.employees where first_name LIKE 'B%';
-- 42. �̸��� 'a'�� ������ ������ ����ϼ���.
select * from hr.employees where first_name LIKE '%a';

-- 43. 02�⵵�� �Ի��� ���?
select * from hr.employees where hire_date LIKE '02%';

-- 44. 02���� �Ի��� �����? --52���� ��
select * from hr.employees where hire_date LIKE '%/02/%';
-- 45. �̸��Ͽ� �ι�° ���ڰ� 'K'�� ����� ����Ͻÿ�.
select * from hr.employees where email LIKE '_K%';
-- 46. ���� �ι�° ���ڰ� 'o'�� ����� ����Ͻÿ�.
select * from hr.employees where last_name LIKE '_o%';
-- 47. �̸��Ͽ� ����° ���ڰ� 'A'�����ϴ� ���?
select * from hr.employees where email LIKE '__A%';
-- 48. �̸��Ͽ� ����° ���ڰ� 'O'�����ϴ� ���?
select * from hr.employees where email LIKE '__O%';
-- 49. �̸����� ���������� �ι�° ���� 'O'�� �����?
select * from hr.employees where email LIKE '%O_';

-- 50. �̸����� �տ��� �ι��簡 K�̰� �ڿ��� �ι�°�� 'O'�� ����� ����Ͻÿ�.
select * from hr.employees where email LIKE '_K%O_';

-- 51. IT_�� �����ϴ� ������ ���Ͻÿ�
select job_id from hr.employees where job_id LIKE 'IT\_%' escape '\';
-- 52. 02���� �Ի��� ������� ����ϼ���.
select * from hr.employees where hire_date LIKE '%/02/%';
-- null
-- 53. Ŀ�̼��� ���� ���ϴ� �������� ����Ͻÿ�.
select * from hr.employees where commission_pct is null;
-- 54. ��簡 ���� ������ ����Ͻÿ�.
select * from hr.employees where manager_id is null;
-- 55. �μ��� �μ����� ���� �μ������� ����ϼ���.
select * from hr.departments where manager_id is null;
---56. �μ��� ���� ������ ����Ͻÿ�.
select * from hr.employees where department_id is null;
--- �� ������.. or, and : �ο�Ÿ�԰��� ����
-- 57. ������ AD_VP�̸鼭 �μ���ȣ�� 90�� ������� ����ϼ���.
select * from hr.employees where job_id = 'AD_VP' and department_id = 90;
-- 58. �޿��� 10000�̻��̸鼭 ������ 'MAN'���ԵǾ� �ִ� �����?
select * from hr.employees where salary >= 10000 and job_id LIKE '%MAN%';
-- 59. �޿��� 5000�μ� 10000 ������ ����� ���Ͻÿ�.
select * from hr.employees where salary between 5000 and 10000;
-- 60. �Ի����� 03/06/17���� 05/09/21���̿� �Ի��� ����� ����Ͻÿ�.and���
select * from hr.employees where hire_date >= '03.06.17' and hire_date <= '05.09.21';
-- 61. �޿��� 10000�̻��� ����� ���
select * from hr.employees where salary >=10000;
-- 62. ������ 'MAN'�� �����ϰ� �ִ� ����� ���
select * from hr.employees where job_id LIKE '%MAN%';
-- 63. 61�� ����� 62�� ����� ���� ����ϼ���.
-- �޿��� 10000�̻��� ����� ������ MAN�� �����ϰ� �ִ� ����� ����ϼ���.
select * from hr.employees where salary >=10000 or job_id LIKE '%MAN%';
---64. �μ��� 100�� ����� ������ 'SA_REP'�� ����� ����Ͻÿ�.
select * from hr.employees where department_id = 100 or job_id = 'SA_REP';
-- 65.  �μ��� 100�̸鼭 ������ 'SA_REP'�� ����� ����Ͻÿ�.
select * from hr.employees where department_id = 100 and job_id = 'SA_REP';
-- 66. ������ 'AD_PRES', 'AD_VP', 'IT_PROG'�� ����� ����ϼ���
select * from hr.employees where job_id in('AD_PRES', 'AD_VP', 'IT_PROG');
--or
select * from employees where job_id='AD_PRES' or job_id='AD_VP' or job_id='IT_PROG';
--- ������ IT_PROG�̰ų� ������ ST_MAN�̸鼭 �޿��� 6000�̻��� ����� ����Ͻÿ�.
select * from hr.employees where job_id in('IT_PROG', 'ST_MAN') and salary >= 6000;

-- 67. ������ 'AD_PRES', 'AD_VP', 'IT_PROG'�� �ش����� ���� ����� ����ϼ���
select * from hr.employees where job_id NOT in('AD_PRES', 'AD_VP', 'IT_PROG');
-- 68. �޿��� 6000���� �۰ų�  10000���� ū ����� ����ϼ���.
select * from hr.employees where salary not between 6000 and 10000;
-- 69. Ŀ�̼��� �����ʴ� ������� ���Ͻÿ�.
select * from hr.employees where commission_pct is null;
-- Ŀ�̼��� �޴� ������� ����ϼ���.
select * from hr.employees where commission_pct is not null;
-- 70.  �μ����̺��� �μ����� �ִ� �μ��� ����Ͻÿ�.
select * from hr.departments where manager_id is not null;
-- 71. �޿��� �������� ������������ ���ĵǾ� �޿�, �����ȣ, �̸� �Ի����� ����ϼ���.
select salary, employee_id, last_name, hire_date from hr.employees order by salary asc;
-- 72. 80�� �μ��� ������� ����� �� �Ի����� ���� ���� ������� ����Ͻÿ�.
select * from hr.employees where department_id = 80 order by hire_date asc;
-- 73. 50�� �μ��� ������� ����� �� �Ի����� ���� ���� ������� ����Ͻÿ�.
select * from hr.employees where department_id = 50 order by hire_date desc;
-- 74. 50�� �μ��� ������� ����� ��  �޿��� ���� ���� ������� ����Ͻÿ�.
select * from hr.employees order by salary asc;
-- 75. �޿��� 6000�̻��̰� 10000������ ������� �Ի����� ���� ������� �������� ����ϼ���.
select * from hr.employees where salary between 6000 and 10000 order by hire_date asc;
-- 76. 
--- �����ȣ, �̸�, �Ի��� , �޿�, �μ���ȣ �� ����� �� �޿��� ���� ���� �޴� 
--- ������� ����Ͻÿ�. �޿��� sal�� ��Ī�� ����Ѵ�.
select employee_id, last_name, hire_date, salary as sal, department_id from hr.employees
order by sal asc;
-- 77. �μ��� ������������ ���ĵ� ���¿��� �μ����� �ִ� ������ ������������ ����������.
select * from hr.employees order by department_id asc, job_id asc;
-- 78. �μ��� ������������ ���ĵ� ���¿��� �μ����� �ִ� ������ ������������ ����
select * from hr.employees order by department_id asc, job_id desc;
-- 79. �μ��� ������������ �����ϰ� ���μ����� ������ ������������ ���ĵ� ���¿���
--- ������ ���� �޿��� ���� ���� �޴� ������� ��µǰ� �ϼ���.
select * from hr.employees order by department_id asc, job_id desc, salary desc;
-- 80 �μ��� ������������ �����Ͽ� ����ϰ� ���� �μ����� �ٸ� ������ ���� ������� �ִٸ�
--- ������ ������������ �����ϰ� ���� ���������� �޿��� ���� �ٸ��Ƿ� �޿��� ������������
--- �����ϵ� �޿��� �޴� ������� �Ի����� ������������ �����Ͻÿ�. 
select * from hr.employees order by department_id asc, job_id desc,salary asc, hire_date asc;
--- 81. �̸��� 'steven'�� �����  ����Ͻÿ�.
select * from hr.employees where lower(first_name) = 'steven';
-- 82. ���� KING�� ������ ����ϼ���.
select * from hr.employees where upper(last_name) = 'KING';
-- 83. �̸��� ������ ������ 5�� ������� ����ϼ���.
select * from hr.employees where length(last_name) = 5;
-- 84.  �޿��� 5�ڸ� �̻��� ����� ���Ͻÿ�.
select * from hr.employees where length(salary) = 5;
-- 85. �̸��� 's'�� ���� ����� �� �̸��� ���°�� �ִ��� ����ϼ���.
select instr(first_name, 's', 1) from hr.employees where first_name LIKE '%s%';
-- 86.  �̸��� 's'�� 3��°�� �ִ� ������� ����ϼ���.
select * from hr.employees where instr(first_name, 's', 1) = 3;
-- 87. �̸��� ���� �޿��� ������ ����� �� �̸����� 3��° ���� ���� ����Ͻÿ�.
select first_name, last_name, salary, job_id, substr(email, 3) from hr.employees;

--88. �̸��Ͽ� 'S'���� ����ϰ�, �޿�, �Ի���, �̸� ,���� ����ϼ���.
select substr(email, instr(email, 'S', 1)), salary, hire_date, last_name, first_name from hr.employees where email Like '%S%';
--89. �̸� , �޿�, ����, �μ��� ����� �� �̸����� 3��° ���� 4��¥�� ����Ͻÿ�.
select first_name, salary, job_id, department_id, substr(email, 3, 4) from hr.employees;

--90. �̸��Ͽ� 3��°���� 4���ڿ� 'ARTS'�� �ִ� ����� ����ϼ���.
select * from hr.employees where substr(email, 3, 4) = 'ARTS';

--91.�̸��Ͽ� 's'�� 5��°�� �ִ� ����� ����Ͻÿ�.
select * from hr.employees where instr(email, 's', 1) = 5;
-- ���̵� ã�� highland0 : high*****
-- 92. �̸��Ͽ��� �տ��� 2���ڸ� ����ϰ� �������� �����ʿ� *�� ä���� ����ϼ���.
select rpad(substr(email,1,2), length(email), '*') from hr.employees;

-- 93. �Ի����� 03/06/17 ��ȭ��ȣ�� 515.123.4567�� ����� �̸����� 
--     �տ��� 3���ڸ� ����ϰ� �������� *�� ����ϼ���
select rpad(substr(email,1,3), length(email), '*') from hr.employees where hire_date = '03.06.17' and
phone_number = '515.123.4567';
-- 94. ������ _AS�� �ִٸ� abc�� �����Ͻÿ�,
select replace(job_id, '\_AS', 'abc') from hr.employees
where job_id LIKE '%\_AS%' ESCAPE '\';
-- 95.�̸��Ͽ� 'A'�� ó���� ���� �ִٸ� �̸��Ͽ��� �����Ͽ� �������.
select substr(email, 2, length(email)) from hr.employees where email Like 'A%A';

-- 96. �̸��Ͽ��� �ڿ��� �ѱ��ڰ����� ���� �� �̸��Ͽ��� �ڿ��� ���� 2���� ������ ����,
--     �̸��Ͽ��� �ڿ��� 3��°���� 2���ڸ� ����ϼ���.
select substr(email, length(email)), substr(email, length(email)-1), substr(email, length(email)-2, 2)  from hr.employees; 

--- 97. �̸�, �Ի���, �μ���ȣ, �޿�, ����� ����ϼ���.
select first_name, hire_date, department_id, salary, salary*12 from hr.employees;

-- 98. �̸�, �Ի���, �μ���ȣ, �޿� �׸��� ����� ����� �� 
-- ������� Ŀ�̼��� ���ԵǾ�� �Ѵ�.
select first_name, hire_date, department_id, salary, (salary + salary * commission_pct)*12 from hr.employees;