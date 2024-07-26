--- 1. �̸��� 'steven'�� �����  ����Ͻÿ�.
select * from hr.employees where lower(first_name) = 'steven';
-- 2. ���� KING�� ������ ����ϼ���.
select * from hr.employees where upper(last_name) = 'KING';
-- 3. �̸��� ������ ������ 5�� ������� ����ϼ���.
select * from hr.employees where length(first_name) = 5;
-- 4.  �޿��� 5�ڸ� �̻��� ����� ���Ͻÿ�.
select * from hr.employees where length(salary) = 5;
-- 5. �̸��� 's'�� ���� ����� �� �̸��� ���°�� �ִ��� ����ϼ���.
select instr(first_name, 's') from hr.employees where first_name Like '%s%';
-- 6.  �̸��� 's'�� 3��°�� �ִ� ������� ����ϼ���.
select * from hr.employees where instr(first_name, 's') = 3;
-- 7. �̸��� ���� �޿��� ������ ����� �� �̸����� 3��° ���� ���� ����Ͻÿ�.
select first_name, last_name, salary, job_id, substr(email, 3) from hr.employees;
-- 8. �̸��Ͽ� 'S'���� ����ϰ�, �޿�, �Ի���, �̸� ,���� ����ϼ���.
select substr(email, instr(email, 'S')), salary, hire_date, first_name, last_name from hr.employees where email like '%S%';
-- 9. �̸� , �޿�, ����, �μ��� ����� �� �̸����� 3��° ���� 4��¥�� ����Ͻÿ�.
select first_name, salary, job_id, department_id, substr(email, 3, 4) from hr.employees;
--10. �̸��Ͽ� 3��°���� 4���ڿ� 'ARTS'�� �ִ� ����� ����ϼ���.
select * from hr.employees where substr(email, 3, 4) = 'ARTS';
--11.�̸��Ͽ� 's'�� 5��°�� �ִ� ����� ����Ͻÿ�.
select * from hr.employees where instr(email, 'S') = 5;
-- ���̵� ã�� highland0 : high*****
-- 12. �̸��Ͽ��� �տ��� 2���ڸ� ����ϰ� �������� �����ʿ� *�� ä���� ����ϼ���.
select rpad(substr(email, 1, 2), length(email), '*') from hr.employees;
-- 13. �Ի����� 03/06/17 ��ȭ��ȣ�� 515.123.4567�� ����� �̸����� 
--     �տ��� 3���ڸ� ����ϰ� �������� *�� ����ϼ���
select rpad(substr(email, 1, 3), length(email), '*') from hr.employees
where hire_date = '03/06/17' and phone_number = '515.123.4567';
-- 14. ������ _AS�� �ִٸ� abc�� �����Ͻÿ�,
select job_id, replace(job_id, '_AS', 'abc') from hr.employees where job_id like '%\_AS%' escape '\';
-- 15.�̸��Ͽ� 'A'�� ó���� ���� �ִٸ� �̸��Ͽ��� �����Ͽ� �������.
select email, trim('A' from email) from hr.employees;
-- 16. �̸��Ͽ��� �ڿ��� �ѱ��ڰ����� ���� �� �̸��Ͽ��� �ڿ��� ���� 2���� ������ ����,
--     �̸��Ͽ��� �ڿ��� 3��°���� 2���ڸ� ����ϼ���.
select email, substr(email, -1), substr(email, -2), substr(email, -3, 2) from hr.employees;

-- 16. �̸�, �Ի���, �μ���ȣ, �޿�, ����� ����ϼ���.
select first_name, hire_date, department_id, salary, salary * 12 from hr.employees;

-- 17. �̸�, �Ի���, �μ���ȣ, �޿� �׸��� ����� ����� �� 
-- ������� Ŀ�̼��� ���ԵǾ�� �Ѵ�.
select first_name, hire_date, department_id, salary, salary * (1 + commission_pct) * 12 from hr.employees;

-- 18. �Ի��Ϸκ��� ���ó�¥���� ������ �������� �Ϸ� ����ϼ���.
--  �Ի���, �̸�, ��, ������ ���� ���
select trunc(sysdate - hire_date) || '��', hire_date, first_name, last_name, job_id from hr.employees;
-- 19. �Ի���, �̸�, ��, ������ ����� �� �Ի��Ϸ� ���� �� �ְ� �������� ����Ͻÿ�.
select trunc((sysdate - hire_date) / 7) || '��', hire_date, first_name, last_name, job_id from hr.employees;
-- 20. �Ի���, �̸�, ��, ������ ����� �� �Ի��Ϸ� ���� �� �������� ����Ͻÿ�.
select trunc((sysdate - hire_date) / 365) || '��', hire_date, first_name, last_name, job_id from hr.employees;
-- 21.������ 17�� �̻��� ����� ����Ͻÿ�.
select * from hr.employees where trunc((sysdate - hire_date) / 365) >= 17;
-- 22. �̸�, ��, �Ի��� , �޿��� ����� �� �޿��� 400���� ���� �������� ����ϼ���.
select first_name, last_name, hire_date, salary, mod(salary, 400) as "������" from hr.employees;
-- 23. �޿��� 500���� ���� �������� 400 �̻��� ������� ����Ͻÿ�
select * from hr.employees where mod(salary, 500) >= 400;
--- ��¥ �Լ� 
--24. ���� ��¥���� ���� �ݿ����� �����Դϱ�?
select next_day(sysdate, '��') from dual;
-- 25. �̸� , ��, ����, �Ի����� ����� �� �Ի��Ϸκ��� ���� ������� ���������� ����ϼ���.
select first_name, last_name, job_id, hire_date, next_day(hire_date, '��') from hr.employees;
-- 26 ���ú��� 5�����Ĵ� �����Դϱ�?
select add_months(sysdate, 5) from hr.employees;
--27. Neena�� �Ի��ϰ� 3���� �İ� �������� �Ǵ� ���̴�.
--    �������� �Ǵ� ���� ��������, �̸� , �� , �Ի���, ����, �����ȣ�� ���� ����Ͻÿ�.
select first_name, last_name, hire_date, job_id, employee_id, add_months(hire_date, 3) from hr.employees where first_name = 'Neena';
-- 28. �Ի��� ���� ���� ������� '01/01/18'�λ���� ���Ͻÿ�.
select * from hr.employees where next_day(hire_date, '��') = '01/01/18';
-- 29 �̹� ���� ������ ���� ���
select last_day(sysdate) from dual;
-- 30. ���޿� �Ի��� ����� ����Ͻÿ�.
select * from hr.employees where last_day(hire_date) like '%/02/29';
-- 31. �Ի��Ϸ� ���� ������� ����� ��������, �̸�, ��, ����, �Ի��ϵ� ���� ���
select first_name, last_name, job_id, hire_date, trunc(months_between(sysdate, hire_date)) || '��' as "���� ����" from hr.employees;
-- 32 �� ����� ������ ����� ���� ������� ����Ͻÿ�.
select trunc(months_between(sysdate, hire_date)) || '��' from hr.employees;
-- 33. �Ի����� 200������ ���� ������� ����Ͻÿ�.
select * from hr.employees where trunc(months_between(sysdate, hire_date)) > 200;
--- 34. ���� ��� �ҹ����� grant�� ��� �빮���� 'GRANT'�� �������̺���
--- �ش� ����� ã���� �Ѵ�.
select * from hr.employees where lower(last_name) = 'grant' or upper(last_name) = 'GRANT';
---35. 'GranT'�� �Է������� ������̺��� ���� 'Grant'�� ����� ã���ÿ�.
select * from hr.employees where initcap('GranT') = 'Grant';

-- 36. ���� ��� �빮�ڷ� ��ȯ�ϰ� �̸� ��� �ҹ��ڷ� ��ȯ�Ͽ�
-- ���� �̸��� �ٿ� ����� �� ' ���� GRANT douglas �Դϴ�'�� 
-- ��µǰ� �Ͻÿ�
select '���� ' || upper(last_name) || ' ' || lower(first_name) || '�Դϴ�' from hr.employees;

-- 37. ���� �̸��� �ٿ� ���
select last_name||first_name from hr.employees;

--- 38. ���� Davies���� av�� ����Ͻÿ�.
select substr(last_name, 2, 2) from hr.employees; 
--- 39. ���� �ι�° ���ں��� ��� ����Ͻÿ�.
select substr(last_name, 2) from hr.employees; 

--- 40. ���� ������ ���ڿ��� �α��ڸ� �������ÿ�.
select last_name, substr(last_name, -2, 2) from hr.employees; 
--- 41. ���� �ڿ� on���� ������ ����� ã���ÿ�
select * from hr.employees where substr(last_name, -2, 2) = 'on';
-- 42. ���� �ڿ� ����° ���ڰ� so�� ����� ����Ͻÿ�
select * from hr.employees where substr(last_name, -3, 2) = 'so';
-- 43. ���� ������ ����ϴµ� �̸����� ���ʿ��� 3���ڸ� ����Ͻÿ�.
--     ������ȣ, ��, �޿�, ����, �̸���
select employee_id, last_name, salary, job_id, substr(email, 1, 3) from hr.employees;
-- 44. ���� ������ ����ϴµ� �̸����� �����ʿ��� 3���ڸ� ����Ͻÿ�.
-- ������ȣ, ��, �޿�, ����, �̸���
select employee_id, last_name, salary, job_id, substr(email, -3) from hr.employees;
-- 45. ���� ������ ����ϴµ� �̸����� �����ʿ��� 3���ڸ� ����ϰ� �������� ��-���� ���
---    ������ȣ, ��, �޿�, ����, �̸���
select employee_id, last_name, salary, job_id, email, lpad(substr(email, -3), length(email), '-') from hr.employees;
--- 46. o�� �ִ� ���� o�� ���°�� �ִ� ��ġ���� ����Ͻÿ�. 
--      ������ȣ ��, ���� ��ġ, ����
select employee_id, last_name, instr(last_name, 'o'), job_id from hr.employees where last_name like '%o%';
--- 47. oc�� �ִ� ���� oc�� ���°�� �ִ� ��ġ���� ����Ͻÿ�.  
-- ������ȣ ��, ���� ��ġ, ����
select employee_id, last_name, instr(lower(last_name), 'oc'), job_id from hr.employees where lower(last_name) like '%oc%';
-- 48. ������ RE�� �ִ� ��� RE���� 3���ڸ� ����Ͻÿ�.
--    ������ȣ ��,  ����, ������ ����
select employee_id, last_name, job_id, substr(job_id, instr(job_id, 'RE'), 3) from hr.employees where job_id like '%RE%';
--- 49. ������ȣ, ��, �Ի��� , �޿�, 
--- �޿��� 10ĭ�� ����ϰ� ������ ���� �տ� * ǥ�ð� �ǰ� ����.
select employee_id, last_name, hire_date, lpad(salary, 10, '*') from hr.employees;
-- 50. ������ȣ, ��, �Ի��� , �޿�, 
--- �޿��� 10ĭ�� ����ϰ� ������ ���� �ڿ� * ǥ�ð� �ǰ� ����.
select employee_id, last_name, hire_date, rpad(salary, 10, '*') from hr.employees;
-- 51. ������ȣ, ��, �Ի���, ������ ����ϴµ� 
---    ������ RE�� �ִٸ� RE�� AB�� �����Ͽ� ���.
select employee_id, last_name, hire_date, job_id, replace(job_id, 'RE', 'AB') from hr.employees;
-- 52. ������ȣ, ����ó, Ŀ�̼�, �μ���ȣ,�޿�
-- �޿��� 3000���� �������� ���� �������� ����Ͻÿ�.
select employee_id, phone_number, commission_pct, department_id, salary, mod(salary, 3000) from hr.employees;
-- 53. 2002�⵵���� �Ի��� �������� ����Ͻÿ�
select * from hr.employees where hire_date >= '02/01/01';
-- 54. ���ش� ���ñ��� ���ְ� �������� Ȯ���Ͻÿ�.
select trunc((sysdate - to_date('24/01/01')) / 7) from dual;
-- 55. �������� ��� �ٹ������� ����Ͻÿ�. ������ȣ, ��, ����ó,�μ�, �ٹ����
select employee_id, phone_number, job_id, trunc((sysdate - hire_date) / 365) from hr.employees;
-- 56. �ټӳ�� 8�� �̻��� ����鸸 ����Ͻÿ�
select * from hr.employees where trunc((sysdate - hire_date) / 365) >= 8;

-----------------------------------------------------------------------
--- 57. ���� : �Խ��Ǹ���Ʈ���� ������ 5����****�� �� ó�� 
--- ������ ���� 3���ڸ� ��� �ڿ� *�� ������ ����Ͻÿ�.
--- ������ȣ, �Ի���, ��
select employee_id, hire_date, last_name, rpad(substr(last_name, 1, 3), length(substr(last_name, 1, 3)) + 3, '*')
from hr.employees;
--- 58. ȫ�浿�� ������Դϱ�?
select length('ȫ�浿') from dual;

--- 59. )"ȫ�浿 \n"���� �Ǿ� �ִ� ���� html���� �� �ٲ��̵ǵ���
---      "ȫ�浿 <br>"�����Ͻÿ�.
select replace('ȫ�浿 \n', '\n', '<br>') from dual;
--- 60.  ������ �̷���� �� ������ ī���ȣ�� ȭ�鿡 ����ؾ� �ϴ� �� ��� ��ȣ�� ����ϸ� �ȵȴ�.
---- ���� ī���ȣ�� 1234 5678 9874 6321�̶�� 1234 **** 9874 6321�� ��µǰ� �Ͻÿ�.
SELECT 
    rpad(SUBSTR('1234 5678 9874 6321', 1, INSTR('1234 5678 9874 6321', ' ')), 
    instr('1234 5678 9874 6321', ' ', INSTR('1234 5678 9874 6321', ' ') + 1) - 1, '*') ||
    substr('1234 5678 9874 6321', instr('1234 5678 9874 6321', ' ', '6'), instr('1234 5678 9874 6321', ' ', -1))
    from dual;
       