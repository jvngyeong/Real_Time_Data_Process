create table publisher(
    publisher_num varchar2(13) not null,
    publisher_name varchar2(50),
    publisher_tel varchar2(30),
    publisher_addr varchar2(255),
    bank_code varchar2(13),
    account_num varchar2(13)
);

alter table publisher
add constraint publisher_num_PK primary key(publisher_num);

create table contract(
    contract_num varchar2(13) not null,
    publisher_num varchar2(13),
    contract_date date,
    contract_text varchar2(2000),
    min_rate number(4, 2)
);

alter table contract
modify contract_num constraint contract_num_PK primary key; -- 열 레벨로 PK 지정

alter table contract
drop constraint contract_num_PK;        -- constraint를 DROP
        
alter table contract
add constraint contract_num_PK primary key(contract_num);   -- 테이블 레벨로 PK 지정

create table contract_book(
    contract_num varchar2(13) not null,     -- PK의 속성이 두 가지임. constract_num, book_num
    book_num varchar2(13) not null
);

alter table contract_book
add constraint contract_book_PK primary key(contract_num, book_num);

create table purchase(
    purchase_num varchar2(13) not null,
    member_num varchar2(13),
    purchase_date date,
    deli_addr varchar2(255),
    deli_tel varchar2(30),
    pay_method varchar2(255),
    total_price integer
);

alter table purchase
add constraint purchase_num_PK primary key(purchase_num);

create table purchase_book(
    purchase_num varchar2(13),
    book_num varchar2(13) not null,
    purchase_price integer,
    purchase_qty INTEGER
);

alter table purchase_book
add constraint purchase_book_PK primary key(purchase_num, book_num);

create table books(
    book_num varchar2(13) not null,
    book_name varchar2(50),
    book_category varchar2(2000),
    author varchar2(50),
    book_date DATE
);

alter table books
add constraint book_num_PK primary key(book_num);

create table offer(
    purchase_num varchar2(13) not null,
    delivery_num varchar2(13),
    invoice varchar2(13)
);

alter table offer
add constraint offer_PK primary key(purchase_num);

create table members(
    member_num varchar2(13) not null,
    member_name varchar2(50),
    member_addr varchar2(255),
    member_tel varchar2(30),
    member_point INTEGER
);

alter table members
add constraint member_num_PK primary key(member_num);

create table storage(
    book_num varchar2(13) not null,
    inventory INTEGER
);

alter table storage
add constraint storage_PK primary key(book_num);

create table deliverys(
    delivery_num varchar2(13) not null,
    delivery_name varchar2(50),
    delivery_tel varchar2(50)
);

alter table deliverys
add constraint delivery_num_PK primary key(delivery_num);

create table accounts(
    abjustment_num varchar2(13) not null,
    delivery_num varchar2(13),
    abjustment_price integer,
    abjustment_date date
);

alter table accounts
add constraint abjustment_num_PK primary key(abjustment_num);

create table books_check(
    member_num varchar2(13) not null,
    book_num varchar2(13),
    check_date date
);

alter table books_check
add constraint member_book_PK primary key(member_num, book_num);

create table indirect(
    delivery_num varchar2(13) not null,
    subway_num varchar2(13),
    subway_loc integer
);

alter table indirect
add constraint indirect_PK primary key(delivery_num);

create table direct(
    delivery_num varchar2(13) not null,
    delivery_addr varchar2(255)
);

alter table direct
add constraint direct_PK primary key(delivery_num);


------------------------ foreign key --------------------------
-- foreign key는 테이블 사이에 이어진 선의 개수와 같다.
alter table contract
add constraint publisher_num_FK foreign key(publisher_num) references publisher(publisher_num);

alter table contract_book
add (constraint contract_num_FK foreign key(contract_num) references contract(contract_num),
     constraint book_num_FK foreign key(book_num) references books(book_num));
     
     
alter table purchase
add constraint member_num_FK foreign key(member_num) references members(member_num);

alter table purchase_book
add (constraint purchase_num_FK foreign key(purchase_num) references purchase(purchase_num),
     constraint purchase_book_num_FK foreign key(book_num) references storage(book_num));
     
alter table offer
add (constraint offer_purchase_num_FK foreign key(purchase_num) references purchase(purchase_num),
     constraint offer_delivery_num_FK foreign key(delivery_num) references deliverys(delivery_num));
     
alter table storage
add constraint storage_book_num_FK foreign key(book_num) references books(book_num);

alter table accounts
add constraint accounts_delivery_num_FK foreign key(delivery_num) references deliverys(delivery_num);

alter table books_check
add (constraint bc_member_num_FK foreign key(member_num) references members,
     constraint bc_book_num_FK foreign key(book_num) references storage);
     
alter table indirect
add constraint indirect_delivery_num_FK foreign key(delivery_num) references deliverys(delivery_num);

alter table direct
add constraint direct_delivery_num_FK foreign key(delivery_num) references deliverys(delivery_num);