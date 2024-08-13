--���� 1) ȸ�� ���̺��� ����ÿ�. �� �÷��� ���� ������ �ο� �Ͻÿ�. 
--���� ������ alter���� �̿��Ұ� , �������� ���̺� ���� �Ѵ� �ǽ��� ������.
--Table MEMBER
--================================
--user_num          not null          VARCHAR2(20)  
--USER_ID     	NOT NULL 	VARCHAR2(20)  
--USER_PW     	NOT NULL 	VARCHAR2(200) 
--USER_NAME   	NOT NULL 	VARCHAR2(40)  
--USER_BIRTH  	NOT NULL 	TIMESTAMP 
--USER_GENDER 	NOT NULL 	VARCHAR2(1)   
--USER_ADDR   	NOT NULL 	VARCHAR2(200) 
--USER_PH1    	NOT NULL 	VARCHAR2(13)  
--USER_PH2             		VARCHAR2(13)  
--USER_REGIST          		TIMESTAMP  
--USER_EMAIL           		VARCHAR2(200) 
--JOIN_OK              			VARCHAR2(500)
--
--ȸ�� ��������
--user_num     : primary key (MEMBER_USER_ID_PK)
--USER_EMAIL : unique (member_USER_EMAIL_UU)
--USER_ID : unique (member_USER_ID_UU)
--USER_REGIST  : ����Ʈ ���� sysdate
--USER_GENDER : M/F�� �����Ѵ�.
--USER_PH1  : 11���� 13�ڸ��� ���� �Ѵ�.

create table member(
    user_num varchar2(20),
    user_id varchar2(20),
    user_pw varchar2(200),
    user_name varchar2(40),
    user_birth timestamp,
    user_gender char(1),
    user_addr varchar2(200),
    user_ph1 varchar2(13),
    user_ph2 varchar2(13),
    user_regist timestamp default sysdate,
    user_email varchar2(200),
    join_ok varchar2(500)
);

alter table member
add(constraint MEMBER_USER_NUM_PK primary key(user_num)
);
alter table member
add (constraint member_GENDER_CK check(user_gender in ('F', 'M')),
    constraint member_PH1_CK check(length(user_ph1) >= 11 and length(user_ph1) <= 13));
alter table member
add(constraint member_USER_EMAIL_UU unique(user_email),
    constraint member_USER_ID_UU unique(user_id));

alter table member
modify(user_num not null, 
       user_id not null, 
       user_pw not null, 
       user_name not null, 
       user_birth not null,
       user_gender not null,
       user_addr not null,
       user_ph1 not null
       );
--����2) �Խ��� ���̺��� ����� �� �÷��� ���������� �ο� �Ͻÿ�.
--���� ������ alter���� �̿��Ұ� , �������� ���̺� ���� �Ѵ� �ǽ��� ������.
--Table BOARD
--====================================
--BOARD_NUM     	NOT NULL 	NUMBER         
--USER_num       	NOT NULL 	VARCHAR2(20)   
--BOARD_NAME    	NOT NULL 	VARCHAR2(20)    --- �� ���� 
--BOARD_PASS    	NOT NULL 	VARCHAR2(200)  
--BOARD_SUBJECT 	NOT NULL 	VARCHAR2(100)  -- ����
--BOARD_CONTENT          		VARCHAR2(2000) -- ����
--BOARD_DATE             		TIMESTAMP   
--IP_ADDR                		VARCHAR2(15)   
--READ_COUNT             		NUMBER      
--
--�Խ��� �������� 
--BOARD_NUM : primary key (BOARD_BOARD_NUM_PK)
--READ_COUNT ; ����Ʈ ���� 0
--USER_num : FOREIGN KEY (BOARD_USER_ID_FK)
drop table board;
create table board(
    board_num number,
    USER_num VARCHAR2(20), 
    board_name varchar2(20),
    board_pass varchar2(200),
    board_subject varchar2(100),
    board_content varchar2(2000),
    board_date timestamp,
    ip_addr varchar2(15),
    read_count number
);
alter table board
modify(
    read_count default 0
) ;

alter table board
add(
    constraint board_board_num_pk primary key(board_num)
);

alter table board
modify(constraint board_user_num_fk foreign key(user_num) references member(user_num) on delete set null);

drop 

alter table board
modify(
    board_num not null,
    USER_num NOT NULL, 
    board_name not null,
    board_pass not null,
    board_subject not null
);

--���� 3) ȸ�����̺� �Ʒ� ������ �����Ͽ� 5���� �����͸� �����ÿ�.
--ȸ����ȣ�� mem_100001���� �ο��ȴ�.
insert into member (USER_num, user_id,USER_PW,USER_NAME,USER_BIRTH,USER_GENDER,USER_ADDR ,USER_PH1,USER_PH2,USER_REGIST,USER_EMAIL)
values((select concat('mem_', nvl(max(substr(user_num, instr(user_num, '_') + 1)), 100000) + 1) from member), 'highland8','111111','�̼���','1999-12-12','F','����','010-1234-1234',null,default,null);

--����4)�Խ��� ���̺� �����͸� �Ʒ� ���� ���� 6�� �̻��� �ִµ� �� ȸ������ �ּ� �Ѱ� �̻� �Խñ��� ��ϵǰ� �Ͻÿ�.
--BOARD_NUM�� �Է����� �ʰ� �ڵ��ο��� �ǰ� �ۼ��Ͻÿ�. 
select nvl(max(board_num), 0) + 1 from board;
insert into board(BOARD_NUM,USER_num,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values((select nvl(max(board_num), 0) + 1 from board), 'mem_100001', '����� �ƺ�', '1111','����', '����', '192.168.3.117');

insert into board(BOARD_NUM,USER_num,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values((select nvl(max(board_num), 0) + 1 from board), 'mem_100002', '����� �ƺ�', '1111','����', '����', '192.168.3.117');

insert into board(BOARD_NUM,USER_num,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values((select nvl(max(board_num), 0) + 1 from board), 'mem_100003', '����� �ƺ�', '1111','����', '����', '192.168.3.117');

insert into board(BOARD_NUM,USER_num,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values((select nvl(max(board_num), 0) + 1 from board), 'mem_100004', '����� �ƺ�', '1111','����', '����', '192.168.3.117');

insert into board(BOARD_NUM,USER_num,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,IP_ADDR)
values((select nvl(max(board_num), 0) + 1 from board), 'mem_100005', '����� �ƺ�', '1111','����', '����', '192.168.3.117');

desc board;

--����5) highland0ȸ���� ȸ�����̵�, ȸ����, �̸���, �Խñ� ��ȣ, �Խñ� ����, READ_COUNT�� ����Ͻÿ�.
select m.user_id, user_name, user_email, board_num, board_name, read_count
from member m join board b
on m.user_id = b.user_id where m.user_id = 'highland0';


--����6) �Խñ��� ������ READ_COUNT�� 1�� ���� �� ���̴�. 
--         update���� ���� �� ������ READ_COUNT 1���� �Ҽ� �ְ� update���� �ۼ��Ͻÿ�.
--         1�� �Խñ��� ���� ��Ű�ÿ�.
update board
set read_count = read_count + 1
where board_num = 1;

--���� 7) �Խñ� 2���� �ش��ϴ� ȸ���� ����Ͻÿ�.
select m.user_id, user_pw, user_name, user_birth from member m join board b
on m.user_id = b.user_id
where board_num = 2;

--���� 8) ��ϵ� �Խñ��� ������ ����Ͻÿ�.
select count(*) from board;

--���� 9) �� ȸ���� �Խñ��� ������ ����Ͻÿ�. (���� �ƴ�)
select user_id, count(*)
from board
group by user_id;

--���� 10) ȸ���� ���� ����Ͻÿ�.
select count(*) from member;
-- ���� 11) ���̵� 'highland0'�� ȸ���� ��ȭ��ȣ�� '02-9876-1234', 
-- �̸����� 'highland0@nate.com', ��й�ȣ�� '22222'�� �����Ͻÿ�.
update member
set user_ph1 = '02-9876-1234', user_email = 'highland0@nate.com', user_pw = '222222'
where user_id = 'highland0';

--���� 12) �Խñ� 1���� ������ '���� ������ �����ҷ�', ������ '������ �����ؼ� \n ���� ����� �� �� �ְ� ����ؾ���'��  �����Ͻÿ�.
update board
set board_subject = '���� ������ �����ҷ�', board_content = '������ �����ؼ� \n ���� ����� �� �� �ְ� ����ؾ���'
where board_num = 1;

-- ���� 13) 1�� �Խñ��� ����� �� ������ \n�� <br /> �� ��µǰ� �Ͻÿ�.
select replace(board_content, '\n', '<br \>') from board
where board_num = 1;

-- ���� 14)  �Խñ� ������ �ʹ� �� ȭ�鿡 �� ��µǱ� ��ƴ� . 
-- ������ ù��° ���� ���� 5���ڸ� ����ϰ� �ڿ��� *�� 5���� ��µǰ� �Ͻÿ�.
select rpad(substr(board_subject, 1, 5), 10, '*') from board;

--���� 15) '�̼���'ȸ���� ���̵� �ؾ���ȴٰ� �Ѵ�. 
--�̸��ϰ� ��ȭ��ȣ�� �̿��ؼ� ���̵� ����ϴ� �� ���̵�� ��� ����ؼ��� �ȵǰ� 
--ù���ں��� ������ �������� '*'�� ��µǰ� �Ͻÿ�.
select rpad(substr(user_id, 1, 3), length(user_id), '*') from member
where user_name = '�̼���' and user_email = 'highland0@nate.com' and user_ph1 = '02-9876-1234';

--���� 16) �Խ��� ���̺��� �Խñ��� ���� �� �Խñ��� user_id�� �Խñ� ������ ���� ����Ͻÿ�.
select rownum, user_id, count(user_id)
from board
group by user_id
having count(user_id) = (select max(count(user_id)) from board group by user_id);

-- ���� 17) ���ݱ����� �۾��� ��� ���� ���� ��Ű�ÿ�.
commit;
-- ���� 18) '�̼���'ȸ���� Ż���Ϸ��� �Ѵ�. �̼��� ȸ���� Ż�� �Ҽ� �ְ� �����Ͻÿ�.
delete from member
where user_name = '�̼���';

--���� 19) '�̼���' ȸ���� Ż���ϴ� ���� �ƴϾ��� �� �� �� ������ �Ͽ��� .
--���������� '�̼���'ȸ���� ���� ��� ������(�Խ��� ����) ���� �� �� �ְ� �Ͻÿ�.
rollback;

--���� 20) ��highland0���� ȸ���� �α����� �Ͽ� �ڽ��� �� ���� 1�� �Խñ��� �����Ϸ��� �Ѵ�.
--�ش� �Խù��� ���� �ǰ� �Ͻÿ�.
delete from board
where user_id = 'highland0' and board_num = 1;