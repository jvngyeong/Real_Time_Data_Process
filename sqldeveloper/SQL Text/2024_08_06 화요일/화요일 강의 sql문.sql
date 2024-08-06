-- DML : INSERT, SELECT, UPDATE, DELETE : CRUD : ������
-- DDL : CREATE, ALTER, DROP : OBJECT : ��Ű�� : ���̺�, ��, index : object
-- TCL : COMMIT, ROLLBACK, SAVEPOINT

-- View
-- Departments ���̺� ���� �� ����
drop table departments;
create table departments
as
select * from hr.departments;

-- Employees ���̺� ���� �� ����
drop table employees;
create table employees
as
select * from hr.employees;

-- ���, �̸�, ����, �޿�, �Ի���, Ŀ�̼��� ������ ����
-- (year_sal : ������ null�� �� �� ����.)�� ����� ��,
-- ������ 'REP'�� ���Ե� ����鸸 ����Ͻÿ�.
select employee_id, first_name, job_id, salary, hire_date, (nvl(commission_pct, 0) + 1) * salary * 12 as year_sal
from employees where job_id like '%REP%';

-- �� ������ View�� ������ !
create view rep_view
as select employee_id, first_name, job_id, salary, hire_date, (nvl(commission_pct, 0) + 1) * salary * 12 as year_sal
from employees where job_id like '%REP%';

select * from rep_view;

-- View�� Alter���� ����� �� ����. ��ſ� Create or Replace ������ ���!!
create or replace view rep_view
as select employee_id, first_name, job_id, salary, department_id, hire_date, (nvl(commission_pct, 0) + 1) * salary * 12 as year_sal
from employees where job_id like '%REP%';

select * from rep_view;

-- �μ��� 80�� ������� ��� View ����
create or replace view vw_80
as
select * from employees where department_id = 80;

select * from vw_80;        -- ������ ���� ����.

-- ������� ������ ��� View ����
create or replace view vw_emp
as
select employee_id, first_name, last_name, job_id, department_id
from employees;

select * from employees;    -- ��� Column�� ������ ���
select * from vw_emp;       -- View�� ������ ��, ������ Column�� �����͸� ���. !����!

-- ���� View�� Replace�� ��, ��Ī�� ��.
-- 1�� ��� (select���� Column �ڿ� ��Ī�� ��)
create or replace view vw_emp
as
select employee_id eid, first_name fname, last_name lname, job_id jid, department_id did
from employees;

select * from vw_emp;   -- ��Ī�� �����ν� Column���� ���н�ų �� ����.

-- 2�� ��� (View�� ������ ��, �� Column ������ �°� ��Ī�� ��)
create or replace view vw_emp (eid, fname, lname, jid, did)
as
select employee_id, first_name, last_name, job_id, department_id
from employees;

select * from vw_emp;

-- �� �μ��� �޿��� �հ�, �ּ� �޿�, �ִ� �޿�, �޿��� ���, �μ��� ��� ���� ����Ͻÿ�.
select department_id, sum(salary), min(salary), max(salary), trunc(avg(salary)), count(*)
from employees
group by department_id;

-- ���� ������ View�� ������!
create or replace view vw_grp
as
select department_id, sum(salary) sumsal, min(salary) minsal, max(salary) maxsal, trunc(avg(salary)) avgsal, count(*) count
from employees
group by department_id;

select * from vw_grp;

-- �μ��� 80�� ������� View�� ����
create or replace view vw_80
as
select * from employees where department_id = 80;

select * from vw_80;
-- Insert ���� 
-- (View�� ���ǿ� �������� �ʴ� ���� Insert �ϸ�, �������� ������ ���������� Insert�� �Ǵ� ���� Ȯ�� ������.)
insert into vw_80
values(210, '����', '��', 'high', '010-1234-1231', sysdate, 'PR_REP', 19000, null, null, 110);
select * from employees; -- Employees�� Select�غ��� Ȯ�� ����.

-- Delete ����
delete from vw_80   -- View���� ���̴� �͸� ������ �� ����. ������ ������ 210�� �̼����� View���� ���� �Ұ���.
where employee_id = 210;

delete from vw_80   -- ��� ��ȣ�� 149���� ����� 80�� �μ��̱� ������ View�� ���Ե�. ���� ���� ����.
where employee_id = 149;

-- �μ��� 50�� ������� ��� ��ȣ, ��, �̸���, �Ի���, ������ ���̴� View�� �����غ���!
-- View�� �̸��� emp50vw
create or replace view emp50vw
as
select employee_id, last_name, email, hire_date, job_id from employees
where department_id = 50;

select * from emp50vw;

insert into emp50vw
values(300, '��', 'jang', sysdate, 'ST_MAN', 100); -- View���� ������ �ʴ� Column���� ���� Insert�� �� ����.
insert into emp50vw
values(300, '��', 'jang', sysdate, 'ST_MAN');

update emp50vw
set salary = 300    -- View���� salary�� ���� ������ ���� �ȵ�.
where employee_id = 50;

update emp50vw
set email = 'RHEE'
where employee_id = 120;

select * from emp50vw where employee_id = 120;

-- �μ� ��ȣ, �μ���, ���, �̸�, �޿� ���
select e.department_id, department_name, employee_id, first_name, salary
from departments d right outer join employees e
on d.department_id = e.department_id;

-- ���� ������ View�� ������! (���� View ����)
create or replace view dep_emp_vw as
select e.department_id, department_name, employee_id, first_name, salary
from employees e join departments d  
on d.department_id = e.department_id;

select * from dep_emp_vw;

update dep_emp_vw
set salary = 100
where employee_id = 100;

select * from dep_emp_vw;

create table viewupd1(
    c1 number,      -- 1
    c2 int          -- 1
);
create table viewupd2(
    c1 number,      -- 1
    c3 number       -- 1
);

insert into viewupd1 values(1,1);
insert into viewupd2 values(1,1);

select v1.c1, c2, c3
from viewupd1 v1 join viewupd2 v2
on v1.c1 = v2.c1;

create or replace view v_viewupd
as
select v1.c1, c2, c3
from viewupd1 v1 join viewupd2 v2
on v1.c1 = v2.c1;
select * from v_viewupd;

update v_viewupd
set c2 = 10, c3 = 20        -- Join�� ����ؼ� ���� View�� Update�� ��, ���ÿ� �� ���� ���̺��� Update�� ���� ����.
where c1 = 1;

update v_viewupd
set c2 = 10             -- ���� View�� �ϳ��� ���̺� ������ ���� ����.
where c1 = 1;

-- �μ��� 10�� ������� View ����
create or replace view empvu10
as
select employee_id, last_name, email, hire_date, job_id, department_id
from employees where department_id = 10;

insert into empvu10
values(300, '��','high', sysdate, 'AD_ASST', 10);

-- ���� ������ �б� ���� View�� �����
create or replace view empvu10
as
select employee_id, last_name, email, hire_date, job_id, department_id
from employees where department_id = 10
with read only;     -- �б� ������ ��.
insert into empvu10
values(300, '��','high', sysdate, 'AD_ASST', 10);

-- View�� ���̴� �͸� DML�� �� �� �ְ� ����.
create or replace view empvu10
as
select employee_id, last_name, email, hire_date, job_id, department_id
from employees where department_id = 10
with check option;      -- View�� ���̴� �Ϳ� ���ؼ��� Insert ����.

insert into empvu10
values(300, '��','high', sysdate, 'AD_ASST', 10);    -- �μ��� 10�� �����ʹ� View���� ���̱� ������ Insert ����
insert into empvu10
values(300, '��','high', sysdate, 'AD_ASST', 20);    -- �μ��� 20�� �����ʹ� View���� ������ �ʱ� ������ Insert �Ұ���

drop view empvu10;

------ ������ ------
create table goods(
    goods_num varchar2(10),
    goods_name varchar2(100),
    goods_price number
);
select * from goods;
insert into goods(goods_num, goods_name, goods_price)
values('miso_10000', 'û����', 1000);

insert into goods(goods_num, goods_name, goods_price)
values('miso_10001', '�����', 2000);

insert into board
values(1, '�۾���', '����', '����', 0, 10);

create sequence seq_num -- �Ʒ� ������ ��� ���� ����. �����ϸ� �ʱⰪ 1, ������ 1, �ִ밪 999999
increment by 10     -- ������
start with 10       -- �ʱⰪ
maxvalue 9990       -- �ִ밪
NOCYCLE             -- �ݺ� ���� (maxValue�� �������� ��, �ٽ� �ʱⰪ���� ���ư� ������)
NOCACHE;            -- �޸𸮿� ��� ����

select seq_num.nextval from dual;   -- seq_num�� ���� �� ���
select seq_num.currval from dual;   -- seq_num�� ���� �� ���

insert into goods
values(concat('miso_', 10000 + seq_num.nextval), '�����', 2000);
select * from goods;
drop table board;

create table board(
    board_num number generated always as identity(start with 1 increment by 1),
    board_writer varchar2(30),
    board_subject varchar2(100),
    board_content varchar2(2000),
    read_count number
);

insert into board(board_writer, board_subject, board_content, read_count)
values('�۾���', '����', '����', 0);

select * from board;

alter sequence seq_num
increment by 1
maxvalue 99999999;

drop sequence seq_num;
select seq_num.currval, seq_num.nextval from dual;


-- goods_num�� 10001���� 1�� �����ϴ� ���� �ο����ָ鼭 ��ǰ ������ �Է��ϰ�ʹ�.
-- Sequence�� ������� �ʴ´�.
-- miso_10001 -> miso_10002 .... �ڵ����� �����Ǿ�� �Ѵ�.
-- goods_num�� ����Ͻÿ�.
-- goods_num�� ó���� -> miso_10001
drop table goods;
create table goods(
    goods_num varchar2(10),
    goods_name varchar2(100),
    goods_price number
);
truncate table goods;
insert into goods(goods_num, goods_name, goods_price)
values(concat('miso_', nvl((select max(substr(goods_num, 6)) + 1 from goods), 10001)), 
'goods1',
1);
select * from goods;

create index idx_did
on departments(department_id);

select * from departments
where department_id = 90;

-- ��� ��ȣ, �̸�, �޿�, ����, �μ��� ����� ��, ������ 'REP'�� ���Ե� ����鸸 ���
select employee_id, first_name, salary, job_id, department_id
from employees where job_id like '%REP%';

create index emp_job_idx
on employees(job_id);
drop index emp_job_idx;

-- �̸��� �տ��� �� ���ڰ� 'Oc'�� ������ ���
select * from employees
where substr(first_name, 1, 2) = 'Oc';

create index sub_idx
on employees (substr(first_name, 1, 2));

-- �� �μ��� �޿��� ����� 10000�� �μ��� ��� �޿��� ����Ͻÿ�
select department_id, avg(salary) from employees
group by department_id
having avg(salary) = 10000;

create index avgsal
on employees(avg(salary));  -- �׷��Լ��� Index�� ���� �� ����.

-- �� �μ��� �ִ� �޿��� �ش��ϴ� ��� ������
-- �̸�, �޿�, ����, �Ի���, �ִ� �޿�, �μ��� ����Ͻÿ�.
select first_name, salary, job_id, hire_date, department_id
from employees;

select department_id, max(salary)
from employees
group by department_id;

select first_name, salary, job_id, hire_date, e1.department_id, max_sal
from employees e1 join (select department_id, max(salary) max_sal
                        from employees                  -- inline View
                        group by department_id) e2
on e1.department_id = e2.department_id
where salary = max_sal;

-- ���, �̸�, �޿�, �μ�, �� �μ��� ��� �޿��� ����� ��,
-- ��� �޿����� ���� �޴� ������� ���
select employee_id, first_name, salary, e1.department_id, avg_sal
from employees e1 join (select department_id, avg(salary) avg_sal from employees group by department_id) e2
on e1.department_id = e2.department_id
where salary > avg_sal;


-- ������ȣ(location_id)�� 1700�� �ش��ϴ� �μ��� �μ����
-- �� �μ����� �ٹ��ϴ� ����� �����ȣ, �̸�, �޿��� ���
select department_name, d.department_id, employee_id, first_name, salary
from departments d join employees e
on d.department_id = e.department_id
where location_id = 1700;

select department_name, d.department_id, employee_id, first_name, salary
from employees e join (select department_id, department_name from departments where location_id = 1700) d
on e.department_id = d.department_id;


-- ����� �����ȣ, �̸�, �޿�
select employee_id, first_name, salary
from employees
where department_id = 80;

select * from (select employee_id, first_name, salary
from employees
where department_id = 80);