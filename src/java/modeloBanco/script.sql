create user sk8line identified by sk8line;

grant connect to sk8line;

grant all privilege to sk8line

create table TB_USERS(
    CD_USER numeric(18) not null primary key, 
    DC_NAME_USER varchar2(200) not null, 
    DC_PASSWORD  varchar2(200) not null, 
    DC_NAME varchar(200),
    IN_ADMIN_IND CHAR(1),
    DT_CREATE date,
    DT_LAST_UPD date
);

create sequence USERS_SEQ increment by 1 start with 1 nocache nocycle;

insert into TB_USERS(CD_USER, DC_NAME_USER, DC_PASSWORD, DC_NAME) values(USERS_SEQ.NEXTVAL, 'root','root', 'Root Master');

create table TB_PRODUCTS(
    CD_PRODUCT numeric(18) not null primary key,
    DC_PRODUCT varchar2(200),
    NU_PRICE   numeric(18,2),
    DT_CREATE date
);

create sequence  PRODUCT_SEQ  increment by 1 start with 1 nocache nocycle;

create table TB_CLIENTS(
    CD_CLIENT numeric(18) not null primary key,
    DC_CLIENT varchar(200) not null,
    IN_TYPE_CLIENT char(1),
    DC_CPF_CNPJ varchar(20) not null,

);

create sequence  CLIENT_SEQ  increment by 1 start with 1 nocache nocycle;