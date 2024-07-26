alter session set "_ORACLE_SCRIPT" = true;

create user miso identified by 1234;

grant resource, create session, connect, dba to miso;

alter user miso default tablespace users quota unlimited on users;