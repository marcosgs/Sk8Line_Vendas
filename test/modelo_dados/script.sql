
create table TB_USERS(
    CD_USER numeric(18,2) not null primary key,
    DC_NAME_USER varchar2(200) not null,
    DC_PASSWORD  varchar2(200) not null,
    DC_NAME VARCHAR(200),
    IN_ADMIN_IND CHAR(1),
    DT_CREATE date,
    DT_LAST_UPD date
);

create sequence USERS_SEQ;

create table TB_PRODUCTS(
    CD_PRODUCT
    DC_PRODUCT
    NU_PRICE
    DT_CREATE
);
create sequence  PRODUCT_SEQ  