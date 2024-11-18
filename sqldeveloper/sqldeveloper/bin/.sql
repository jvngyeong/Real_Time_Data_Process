--------------------------------------------------------
--  ������ ������ - ������-11��-11-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BOARD
--------------------------------------------------------

  CREATE TABLE "BOARD" ("BOARD_NUM" NUMBER, "BOARD_WRITER" VARCHAR2(50), "BOARD_SUBJECT" VARCHAR2(100), "BOARD_CONTENT" VARCHAR2(2000))
--------------------------------------------------------
--  DDL for Table CART
--------------------------------------------------------

  CREATE TABLE "CART" ("MEMBER_NUM" VARCHAR2(50), "GOODS_NUM" VARCHAR2(50), "CART_DATE" DATE, "CART_QTY" NUMBER(*,0), "CART_NUM" NUMBER GENERATED ALWAYS AS IDENTITY MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE )
--------------------------------------------------------
--  DDL for Table DELIVERY
--------------------------------------------------------

  CREATE TABLE "DELIVERY" ("PURCHASE_NUM" VARCHAR2(50), "DELIVERY_NUM" VARCHAR2(50), "DELIVERY_DATE" DATE, "DELIVERY_STATUS" VARCHAR2(50))
--------------------------------------------------------
--  DDL for Table EMPLOYEES
--------------------------------------------------------

  CREATE TABLE "EMPLOYEES" ("EMP_NUM" VARCHAR2(50), "EMP_ID" VARCHAR2(50), "EMP_PW" VARCHAR2(255), "EMP_NAME" VARCHAR2(50), "EMP_ADDR" VARCHAR2(255), "EMP_ADDR_DETAIL" VARCHAR2(255), "EMP_POST" NUMBER(*,0), "EMP_PHONE" VARCHAR2(30), "EMP_JUMIN" VARCHAR2(13), "EMP_EMAIL" VARCHAR2(40), "EMP_HIRE_DATE" DATE, "EMP_IMAGE" VARCHAR2(255))
--------------------------------------------------------
--  DDL for Table GOODS
--------------------------------------------------------

  CREATE TABLE "GOODS" ("GOODS_NUM" VARCHAR2(50), "GOODS_NAME" VARCHAR2(50), "GOODS_PRICE" NUMBER(*,0), "GOODS_CONTENTS" VARCHAR2(2000), "VISIT_COUNT" NUMBER(*,0), "GOODS_MAIN_IMAGE" VARCHAR2(255), "GOODS_MAIN_STORE_IMAGE" VARCHAR2(255), "GOODS_DETAIL_IMAGE" VARCHAR2(2000), "GOODS_DETAIL_STORE_IMAGE" VARCHAR2(2000), "EMP_NUM" VARCHAR2(50), "GOODS_REGIST" DATE, "UPDATE_EMP_NUM" VARCHAR2(50), "GOODS_UPDATE_DATE" DATE)
--------------------------------------------------------
--  DDL for Table GOODS_IPGO
--------------------------------------------------------

  CREATE TABLE "GOODS_IPGO" ("GOODS_NUM" VARCHAR2(50), "IPGO_NUM" VARCHAR2(50), "IPGO_QTY" NUMBER(*,0), "IPGO_DATE" DATE, "MADE_DATE" DATE, "IPGO_PRICE" NUMBER(*,0), "EMP_NUM" VARCHAR2(50))
--------------------------------------------------------
--  DDL for Table INQUIRE
--------------------------------------------------------

  CREATE TABLE "INQUIRE" ("INQUIRE_NUM" NUMBER(*,0), "MEMBER_NUM" VARCHAR2(50), "GOODS_NUM" VARCHAR2(50), "INQUIRE_SUBJECT" VARCHAR2(255), "INQUIRE_CONTENTS" VARCHAR2(2000), "INQUIRE_KIND" VARCHAR2(50), "INQUIRE_DATE" DATE, "INQUIRE_ANSWER" VARCHAR2(2000), "INQUIRE_ANSWER_DATE" DATE, "EMP_NUM" VARCHAR2(50))
--------------------------------------------------------
--  DDL for Table MEMBERS
--------------------------------------------------------

  CREATE TABLE "MEMBERS" ("MEMBER_NUM" VARCHAR2(50), "MEMBER_NAME" VARCHAR2(50), "MEMBER_ID" VARCHAR2(50), "MEMBER_PW" VARCHAR2(255), "MEMBER_ADDR" VARCHAR2(255), "MEMBER_ADDR_DETAIL" VARCHAR2(255), "MEMBER_POST" NUMBER(*,0), "MEMBER_REGIST" DATE, "GENDER" CHAR(1), "MEMBER_PHONE1" VARCHAR2(30), "MEMBER_PHONE2" VARCHAR2(30), "MEMBER_EMAIL" VARCHAR2(40), "MEMBER_BIRTH" DATE, "MEMBER_POINT" NUMBER(*,0), "MEMBER_EMAIL_CONF" CHAR(1))
--------------------------------------------------------
--  DDL for Table PAYMENT
--------------------------------------------------------

  CREATE TABLE "PAYMENT" ("PURCHASE_NUM" VARCHAR2(50), "CONFIRMNUMBER" VARCHAR2(50), "CARDNUM" VARCHAR2(50), "TID" VARCHAR2(50), "TOTALPRICE" NUMBER(*,0), "RESULTMESSAGE" VARCHAR2(2000), "PAYMETHOD" VARCHAR2(50), "APPLDATE" VARCHAR2(50), "APPTIME" VARCHAR2(50))
--------------------------------------------------------
--  DDL for Table PURCHASE
--------------------------------------------------------

  CREATE TABLE "PURCHASE" ("PURCHASE_NUM" VARCHAR2(50), "PURCHASE_DATE" DATE, "PURCHASE_PRICE" NUMBER(*,0), "DELIVERY_ADDR" VARCHAR2(255), "DELIVERY_ADDR_DETAIL" VARCHAR2(255), "DELIVERY_POST" NUMBER(*,0), "DELIVERY_PHONE" VARCHAR2(30), "MESSAGE" VARCHAR2(255), "PURCHASE_STATUS" VARCHAR2(50), "MEMBER_NUM" VARCHAR2(50), "DELIVERY_NAME" VARCHAR2(50), "PURCHASE_NAME" VARCHAR2(50))
--------------------------------------------------------
--  DDL for Table PURCHASE_LIST
--------------------------------------------------------

  CREATE TABLE "PURCHASE_LIST" ("GOODS_NUM" VARCHAR2(50), "PURCHASE_NUM" VARCHAR2(50), "PURCHASE_QTY" NUMBER(*,0), "GOODS_UNIT_PRICE" NUMBER(*,0))
--------------------------------------------------------
--  DDL for Table RETIRED
--------------------------------------------------------

  CREATE TABLE "RETIRED" ("EMP_NUM" VARCHAR2(50), "RETIRED_DATE" DATE, "REASON" VARCHAR2(2000), "JOB_TITLE" VARCHAR2(2000))
--------------------------------------------------------
--  DDL for Table REVIEWS
--------------------------------------------------------

  CREATE TABLE "REVIEWS" ("REVIEW_NUM" NUMBER(*,0), "GOODS_NUM" VARCHAR2(50), "PURCHASE_NUM" VARCHAR2(50), "REVIEW_DATE" DATE, "REVIEW_CONTENTS" VARCHAR2(2000), "MEMBER_ID" VARCHAR2(50))
--------------------------------------------------------
--  DDL for Table WISH
--------------------------------------------------------

  CREATE TABLE "WISH" ("MEMBER_NUM" VARCHAR2(50), "GOODS_NUM" VARCHAR2(50), "WISH_DATE" DATE)
REM INSERTING into BOARD
SET DEFINE OFF;
REM INSERTING into CART
SET DEFINE OFF;
REM INSERTING into DELIVERY
SET DEFINE OFF;
Insert into DELIVERY (PURCHASE_NUM,DELIVERY_NUM,DELIVERY_DATE,DELIVERY_STATUS) values ('20240930123429254','45667867864534378',to_date('24/09/30','RR/MM/DD'),'��� �Ϸ�');
Insert into DELIVERY (PURCHASE_NUM,DELIVERY_NUM,DELIVERY_DATE,DELIVERY_STATUS) values ('202411061','123',to_date('24/11/07','RR/MM/DD'),'��� �Ϸ�');
Insert into DELIVERY (PURCHASE_NUM,DELIVERY_NUM,DELIVERY_DATE,DELIVERY_STATUS) values ('20240930165156678','123123124125',to_date('24/09/30','RR/MM/DD'),'��� �Ϸ�');
Insert into DELIVERY (PURCHASE_NUM,DELIVERY_NUM,DELIVERY_DATE,DELIVERY_STATUS) values ('20240930164639967','3463463',to_date('24/09/30','RR/MM/DD'),'��� �Ϸ�');
Insert into DELIVERY (PURCHASE_NUM,DELIVERY_NUM,DELIVERY_DATE,DELIVERY_STATUS) values ('20240930164531484','46346346346',to_date('24/09/30','RR/MM/DD'),'��� �Ϸ�');
Insert into DELIVERY (PURCHASE_NUM,DELIVERY_NUM,DELIVERY_DATE,DELIVERY_STATUS) values ('20240930121010032','67456845683568',to_date('24/09/30','RR/MM/DD'),'��� �Ϸ�');
Insert into DELIVERY (PURCHASE_NUM,DELIVERY_NUM,DELIVERY_DATE,DELIVERY_STATUS) values ('20240930115701472','4856585846856',to_date('24/09/30','RR/MM/DD'),'��� �Ϸ�');
Insert into DELIVERY (PURCHASE_NUM,DELIVERY_NUM,DELIVERY_DATE,DELIVERY_STATUS) values ('20240930114903609','456858645468',to_date('24/09/30','RR/MM/DD'),'��� �Ϸ�');
Insert into DELIVERY (PURCHASE_NUM,DELIVERY_NUM,DELIVERY_DATE,DELIVERY_STATUS) values ('20240930121815760','075467457',to_date('24/09/30','RR/MM/DD'),'��� �Ϸ�');
Insert into DELIVERY (PURCHASE_NUM,DELIVERY_NUM,DELIVERY_DATE,DELIVERY_STATUS) values ('20241001091611829','1234',to_date('24/10/01','RR/MM/DD'),'��� �Ϸ�');
REM INSERTING into EMPLOYEES
SET DEFINE OFF;
Insert into EMPLOYEES (EMP_NUM,EMP_ID,EMP_PW,EMP_NAME,EMP_ADDR,EMP_ADDR_DETAIL,EMP_POST,EMP_PHONE,EMP_JUMIN,EMP_EMAIL,EMP_HIRE_DATE,EMP_IMAGE) values ('emp_100002','1323','$2a$10$cm2VAg9DMqkCCR1zCMwUA.bNMtx6GZUmRP9P/Fdabol/AYcrCwxr6','2222222222','��� ȭ���� ������ 31.1������ 1','333333333',18568,'555555555555','555555555555','52@525252',to_date('24/10/17','RR/MM/DD'),null);
Insert into EMPLOYEES (EMP_NUM,EMP_ID,EMP_PW,EMP_NAME,EMP_ADDR,EMP_ADDR_DETAIL,EMP_POST,EMP_PHONE,EMP_JUMIN,EMP_EMAIL,EMP_HIRE_DATE,EMP_IMAGE) values ('emp_100001','1','12!@qwQW','123','���� ������ �������15�� 20-1 (�ڰ)',null,6369,'2222222222','2222222222','23123@2123',to_date('24/10/17','RR/MM/DD'),'dot.png');
REM INSERTING into GOODS
SET DEFINE OFF;
Insert into GOODS (GOODS_NUM,GOODS_NAME,GOODS_PRICE,GOODS_CONTENTS,VISIT_COUNT,GOODS_MAIN_IMAGE,GOODS_MAIN_STORE_IMAGE,GOODS_DETAIL_IMAGE,GOODS_DETAIL_STORE_IMAGE,EMP_NUM,GOODS_REGIST,UPDATE_EMP_NUM,GOODS_UPDATE_DATE) values ('goods_100008','557',557,'5757',15,'galic.jpg','43059e5561214acdbb671b30a8079667.jpg','event.jpg/fantasy.jpg/galic.jpg/','a3e901d49ea34f188ec433eec8b15183.jpg/9415deac77bf4c08815495c025fcd999.jpg/4604c3c3045342aeb16260bdb479b800.jpg/','emp_100002',to_date('24/11/07','RR/MM/DD'),'emp_100002',to_date('24/11/07','RR/MM/DD'));
Insert into GOODS (GOODS_NUM,GOODS_NAME,GOODS_PRICE,GOODS_CONTENTS,VISIT_COUNT,GOODS_MAIN_IMAGE,GOODS_MAIN_STORE_IMAGE,GOODS_DETAIL_IMAGE,GOODS_DETAIL_STORE_IMAGE,EMP_NUM,GOODS_REGIST,UPDATE_EMP_NUM,GOODS_UPDATE_DATE) values ('goods_100002','12',124,'124',17,null,null,null,null,'emp_100002',to_date('24/10/29','RR/MM/DD'),'emp_100002',to_date('24/10/29','RR/MM/DD'));
Insert into GOODS (GOODS_NUM,GOODS_NAME,GOODS_PRICE,GOODS_CONTENTS,VISIT_COUNT,GOODS_MAIN_IMAGE,GOODS_MAIN_STORE_IMAGE,GOODS_DETAIL_IMAGE,GOODS_DETAIL_STORE_IMAGE,EMP_NUM,GOODS_REGIST,UPDATE_EMP_NUM,GOODS_UPDATE_DATE) values ('goods_100003','124',412,'124',43,null,null,null,null,'emp_100002',to_date('24/10/29','RR/MM/DD'),'emp_100002',to_date('24/10/29','RR/MM/DD'));
Insert into GOODS (GOODS_NUM,GOODS_NAME,GOODS_PRICE,GOODS_CONTENTS,VISIT_COUNT,GOODS_MAIN_IMAGE,GOODS_MAIN_STORE_IMAGE,GOODS_DETAIL_IMAGE,GOODS_DETAIL_STORE_IMAGE,EMP_NUM,GOODS_REGIST,UPDATE_EMP_NUM,GOODS_UPDATE_DATE) values ('goods_100004','gweg',1234,'weg',14,null,null,null,null,'emp_100002',to_date('24/10/29','RR/MM/DD'),'emp_100002',to_date('24/10/29','RR/MM/DD'));
Insert into GOODS (GOODS_NUM,GOODS_NAME,GOODS_PRICE,GOODS_CONTENTS,VISIT_COUNT,GOODS_MAIN_IMAGE,GOODS_MAIN_STORE_IMAGE,GOODS_DETAIL_IMAGE,GOODS_DETAIL_STORE_IMAGE,EMP_NUM,GOODS_REGIST,UPDATE_EMP_NUM,GOODS_UPDATE_DATE) values ('goods_100005','512',125125,'515212',7,null,null,null,null,'emp_100002',to_date('24/10/29','RR/MM/DD'),'emp_100002',to_date('24/10/29','RR/MM/DD'));
Insert into GOODS (GOODS_NUM,GOODS_NAME,GOODS_PRICE,GOODS_CONTENTS,VISIT_COUNT,GOODS_MAIN_IMAGE,GOODS_MAIN_STORE_IMAGE,GOODS_DETAIL_IMAGE,GOODS_DETAIL_STORE_IMAGE,EMP_NUM,GOODS_REGIST,UPDATE_EMP_NUM,GOODS_UPDATE_DATE) values ('goods_100006','5345345',345345,'345345',0,null,null,null,null,'emp_100002',to_date('24/10/29','RR/MM/DD'),'emp_100002',to_date('24/10/29','RR/MM/DD'));
Insert into GOODS (GOODS_NUM,GOODS_NAME,GOODS_PRICE,GOODS_CONTENTS,VISIT_COUNT,GOODS_MAIN_IMAGE,GOODS_MAIN_STORE_IMAGE,GOODS_DETAIL_IMAGE,GOODS_DETAIL_STORE_IMAGE,EMP_NUM,GOODS_REGIST,UPDATE_EMP_NUM,GOODS_UPDATE_DATE) values ('goods_100007','52',5235,'5235',81,null,null,null,null,'emp_100002',to_date('24/10/29','RR/MM/DD'),'emp_100002',to_date('24/10/29','RR/MM/DD'));
REM INSERTING into GOODS_IPGO
SET DEFINE OFF;
Insert into GOODS_IPGO (GOODS_NUM,IPGO_NUM,IPGO_QTY,IPGO_DATE,MADE_DATE,IPGO_PRICE,EMP_NUM) values ('goods_100003','ipgo_100003',1,to_date('24/10/04','RR/MM/DD'),to_date('24/10/05','RR/MM/DD'),125,'emp_100002');
Insert into GOODS_IPGO (GOODS_NUM,IPGO_NUM,IPGO_QTY,IPGO_DATE,MADE_DATE,IPGO_PRICE,EMP_NUM) values ('goods_100005','ipgo_100001',1,to_date('24/10/08','RR/MM/DD'),to_date('24/10/05','RR/MM/DD'),22,'emp_100002');
Insert into GOODS_IPGO (GOODS_NUM,IPGO_NUM,IPGO_QTY,IPGO_DATE,MADE_DATE,IPGO_PRICE,EMP_NUM) values ('goods_100007','ipgo_100004',1,to_date('24/10/08','RR/MM/DD'),to_date('24/10/02','RR/MM/DD'),21,'emp_100002');
REM INSERTING into INQUIRE
SET DEFINE OFF;
REM INSERTING into MEMBERS
SET DEFINE OFF;
Insert into MEMBERS (MEMBER_NUM,MEMBER_NAME,MEMBER_ID,MEMBER_PW,MEMBER_ADDR,MEMBER_ADDR_DETAIL,MEMBER_POST,MEMBER_REGIST,GENDER,MEMBER_PHONE1,MEMBER_PHONE2,MEMBER_EMAIL,MEMBER_BIRTH,MEMBER_POINT,MEMBER_EMAIL_CONF) values ('mem_100001','�ذ�','12345678','$2a$10$Uxca8JH3oQDtzJPH.CUtvu9ycDuHe5NodytxW8dbqXSiqXe5hwXeC','���� ������ ������� 125 (���ﵿ)','2133',6133,to_date('24/10/31','RR/MM/DD'),'M','01001010101','02002020202','wnsrud1133@naver.com',to_date('24/10/01','RR/MM/DD'),0,'Y');
Insert into MEMBERS (MEMBER_NUM,MEMBER_NAME,MEMBER_ID,MEMBER_PW,MEMBER_ADDR,MEMBER_ADDR_DETAIL,MEMBER_POST,MEMBER_REGIST,GENDER,MEMBER_PHONE1,MEMBER_PHONE2,MEMBER_EMAIL,MEMBER_BIRTH,MEMBER_POINT,MEMBER_EMAIL_CONF) values ('mem_100002','1111','1111','$2a$10$ZWcgU1zeQIvS6yIHH0oaVufTJvdM23Nhgey28L7BYwpdimD5ppsmS','���� ������ ������� 125 (���ﵿ)','12121212',6133,to_date('24/10/31','RR/MM/DD'),'F','01049051500','01049051500','wnsrud1133@naver.com',to_date('24/10/11','RR/MM/DD'),0,'Y');
REM INSERTING into PAYMENT
SET DEFINE OFF;
Insert into PAYMENT (PURCHASE_NUM,CONFIRMNUMBER,CARDNUM,TID,TOTALPRICE,RESULTMESSAGE,PAYMETHOD,APPLDATE,APPTIME) values ('20240930121010032',null,null,'StdpayCARDINIpayTest20240930124529928247',12,'����ó���Ϸ�','Card','20240930','124530');
Insert into PAYMENT (PURCHASE_NUM,CONFIRMNUMBER,CARDNUM,TID,TOTALPRICE,RESULTMESSAGE,PAYMETHOD,APPLDATE,APPTIME) values ('20240930123429254',null,null,'StdpayCARDINIpayTest20240930124019551578',12,'����ó���Ϸ�','Card','20240930','124020');
Insert into PAYMENT (PURCHASE_NUM,CONFIRMNUMBER,CARDNUM,TID,TOTALPRICE,RESULTMESSAGE,PAYMETHOD,APPLDATE,APPTIME) values ('20240930121815760',null,null,'StdpayCARDINIpayTest20240930124309510855',12,'����ó���Ϸ�','Card','20240930','124309');
Insert into PAYMENT (PURCHASE_NUM,CONFIRMNUMBER,CARDNUM,TID,TOTALPRICE,RESULTMESSAGE,PAYMETHOD,APPLDATE,APPTIME) values ('20240930115701472',null,null,'StdpayCARDINIpayTest20240930135121538025',12,'����ó���Ϸ�','Card','20240930','135121');
Insert into PAYMENT (PURCHASE_NUM,CONFIRMNUMBER,CARDNUM,TID,TOTALPRICE,RESULTMESSAGE,PAYMETHOD,APPLDATE,APPTIME) values ('20240930114903609',null,null,'StdpayCARDINIpayTest20240930163832792072',12,'����ó���Ϸ�','Card','20240930','163833');
Insert into PAYMENT (PURCHASE_NUM,CONFIRMNUMBER,CARDNUM,TID,TOTALPRICE,RESULTMESSAGE,PAYMETHOD,APPLDATE,APPTIME) values ('202411061',null,'*********','StdpayCARDINIpayTest20241106144132833042',3412,'����ó���Ϸ�','Card','20241106','144133');
Insert into PAYMENT (PURCHASE_NUM,CONFIRMNUMBER,CARDNUM,TID,TOTALPRICE,RESULTMESSAGE,PAYMETHOD,APPLDATE,APPTIME) values ('20240930164531484',null,null,'StdpayCARDINIpayTest20240930164550824857',12,'����ó���Ϸ�','Card','20240930','164551');
Insert into PAYMENT (PURCHASE_NUM,CONFIRMNUMBER,CARDNUM,TID,TOTALPRICE,RESULTMESSAGE,PAYMETHOD,APPLDATE,APPTIME) values ('20240930165156678',null,null,'StdpayCARDINIpayTest20240930165223579990',12,'����ó���Ϸ�','Card','20240930','165224');
Insert into PAYMENT (PURCHASE_NUM,CONFIRMNUMBER,CARDNUM,TID,TOTALPRICE,RESULTMESSAGE,PAYMETHOD,APPLDATE,APPTIME) values ('20241001091611829',null,null,'StdpayCARDINIpayTest20241001091635095177',12,'����ó���Ϸ�','Card','20241001','091635');
REM INSERTING into PURCHASE
SET DEFINE OFF;
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('20240930115701472',to_date('24/09/30','RR/MM/DD'),12,null,null,null,null,null,'���� Ȯ��','mem_100001',null,'123 �� 0��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('20240930123429254',to_date('24/09/30','RR/MM/DD'),12,null,null,null,null,null,'���� Ȯ��','mem_100001',null,'123 �� 0��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('20240926170722961',to_date('24/09/26','RR/MM/DD'),50616,null,null,null,null,null,'���� �����','mem_100002',null,'44 �� 0��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('20240930121010032',to_date('24/09/30','RR/MM/DD'),12,null,null,null,null,null,'���� Ȯ��','mem_100001',null,'123 �� 0��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('20240926170923226',to_date('24/09/26','RR/MM/DD'),50616,null,null,null,null,null,'���� �����','mem_100002',null,'44 �� 0��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('202411052',to_date('24/11/05','RR/MM/DD'),258781222,null,null,null,null,null,'���� �����','mem_100002',null,'124�� 2��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('202411053',to_date('24/11/05','RR/MM/DD'),258781222,null,null,null,null,null,'���� �����','mem_100002',null,'124�� 2��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('202411054',to_date('24/11/05','RR/MM/DD'),258781222,null,null,null,null,null,'���� �����','mem_100002',null,'124�� 2��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('202411055',to_date('24/11/05','RR/MM/DD'),258781222,null,null,null,null,null,'���� �����','mem_100002',null,'124�� 2��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('20240930114823219',to_date('24/09/30','RR/MM/DD'),48,null,null,null,null,null,'���� �����','mem_100002',null,'123 �� 0��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('20240930121815760',to_date('24/09/30','RR/MM/DD'),12,null,null,null,null,null,'���� Ȯ��','mem_100001',null,'123 �� 0��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('20240930164531484',to_date('24/09/30','RR/MM/DD'),12,null,null,null,null,null,'���� Ȯ��','mem_100001',null,'123 �� 0��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('20240930165156678',to_date('24/09/30','RR/MM/DD'),12,null,null,null,null,null,'���� Ȯ��','mem_100001',null,'123 �� 0��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('202411051',to_date('24/11/05','RR/MM/DD'),258781222,null,null,null,null,null,'���� �����','mem_100002',null,'124�� 2��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('202411061',to_date('24/11/06','RR/MM/DD'),3412,'����','����',null,'111-1111-1111','�����Ϳ�','���� �����','mem_100002','�ذ�','124�� 0��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('20240926170552957',to_date('24/09/26','RR/MM/DD'),50616,null,null,null,null,null,'���� �����','mem_100002',null,'44 �� 0��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('20240930114903609',to_date('24/09/30','RR/MM/DD'),12,null,null,null,null,null,'���� Ȯ��','mem_100001',null,'123 �� 0��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('20240930164639967',to_date('24/09/30','RR/MM/DD'),12,null,null,null,null,null,'���� �����','mem_100002',null,'123 �� 0��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('20241001091611829',to_date('24/10/01','RR/MM/DD'),12,null,null,null,null,null,'���� Ȯ��','mem_100001',null,'123 �� 0��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('20241002151139735',to_date('24/10/02','RR/MM/DD'),144,null,null,null,null,null,'���� �����','mem_100002',null,'123 �� 0��');
Insert into PURCHASE (PURCHASE_NUM,PURCHASE_DATE,PURCHASE_PRICE,DELIVERY_ADDR,DELIVERY_ADDR_DETAIL,DELIVERY_POST,DELIVERY_PHONE,MESSAGE,PURCHASE_STATUS,MEMBER_NUM,DELIVERY_NAME,PURCHASE_NAME) values ('202411071',to_date('24/11/07','RR/MM/DD'),3412,'����','����',null,'111-1111-1111','�����Ϳ�','���� �����','mem_100001','�ذ�','124�� 0��');
REM INSERTING into PURCHASE_LIST
SET DEFINE OFF;
Insert into PURCHASE_LIST (GOODS_NUM,PURCHASE_NUM,PURCHASE_QTY,GOODS_UNIT_PRICE) values ('goods_100003','202411055',1,412);
Insert into PURCHASE_LIST (GOODS_NUM,PURCHASE_NUM,PURCHASE_QTY,GOODS_UNIT_PRICE) values ('goods_100003','202411053',1,412);
Insert into PURCHASE_LIST (GOODS_NUM,PURCHASE_NUM,PURCHASE_QTY,GOODS_UNIT_PRICE) values ('goods_100005','202411053',1059,125125);
Insert into PURCHASE_LIST (GOODS_NUM,PURCHASE_NUM,PURCHASE_QTY,GOODS_UNIT_PRICE) values ('goods_100007','202411053',24121,5235);
Insert into PURCHASE_LIST (GOODS_NUM,PURCHASE_NUM,PURCHASE_QTY,GOODS_UNIT_PRICE) values ('goods_100003','202411054',1,412);
Insert into PURCHASE_LIST (GOODS_NUM,PURCHASE_NUM,PURCHASE_QTY,GOODS_UNIT_PRICE) values ('goods_100005','202411054',1059,125125);
Insert into PURCHASE_LIST (GOODS_NUM,PURCHASE_NUM,PURCHASE_QTY,GOODS_UNIT_PRICE) values ('goods_100007','202411054',24121,5235);
Insert into PURCHASE_LIST (GOODS_NUM,PURCHASE_NUM,PURCHASE_QTY,GOODS_UNIT_PRICE) values ('goods_100005','202411055',1059,125125);
Insert into PURCHASE_LIST (GOODS_NUM,PURCHASE_NUM,PURCHASE_QTY,GOODS_UNIT_PRICE) values ('goods_100007','202411055',24121,5235);
Insert into PURCHASE_LIST (GOODS_NUM,PURCHASE_NUM,PURCHASE_QTY,GOODS_UNIT_PRICE) values ('goods_100003','202411061',1,412);
Insert into PURCHASE_LIST (GOODS_NUM,PURCHASE_NUM,PURCHASE_QTY,GOODS_UNIT_PRICE) values ('goods_100003','202411071',1,412);
REM INSERTING into RETIRED
SET DEFINE OFF;
REM INSERTING into REVIEWS
SET DEFINE OFF;
REM INSERTING into WISH
SET DEFINE OFF;
Insert into WISH (MEMBER_NUM,GOODS_NUM,WISH_DATE) values ('mem_100002','goods_100003',to_date('24/10/31','RR/MM/DD'));
Insert into WISH (MEMBER_NUM,GOODS_NUM,WISH_DATE) values ('mem_100002','goods_100004',to_date('24/11/04','RR/MM/DD'));