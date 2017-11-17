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
    CD_PRODUCT
    DC_PRODUCT
    NU_PRICE
    DT_CREATE
);
create sequence  PRODUCT_SEQ  ;