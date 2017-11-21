create user SK8LINE identified by sk8line;

grant connect to SK8LINE;

grant all privilege to SK8LINE;

create table SK8LINE.TB_USERS(
    CD_USER       numeric(18) not null primary key, --Código unico de identificação do usuário do usuário
    DC_NAME_USER  varchar2(200) not null,      --Login do usuário
    DC_PASSWORD   varchar2(500) not null,      --Senha do Usuário Criptografada
    DC_NAME       varchar(200) not null,       -- Nome completo do usuário
    IN_TYPE_USER  CHAR(1) not null,            --Indicador se administrador ou Usuário
    CD_CLIENT     numeric(18),                  --FK com tabela Cliente(Código do Cliente)
    CD_EMPLOYEE   numeric(18),
    DT_CREATE     date not null,                --Data de criação do registro
    DT_LAST_UPD   date not null                 --Data da última atualização
);

create sequence SK8LINE.USERS_SEQ increment by 1 start with 1 nocache nocycle;

insert into SK8LINE.TB_USERS(CD_USER, DC_NAME_USER, DC_PASSWORD, DC_NAME, IN_TYPE_USER, DT_CREATE, DT_LAST_UPD) values(USERS_SEQ.NEXTVAL, 'admin','admin', 'Admin Master', 'A',sysdate,sysdate);

insert into SK8LINE.TB_USERS(CD_USER, DC_NAME_USER, DC_PASSWORD, DC_NAME, IN_TYPE_USER, DT_CREATE, DT_LAST_UPD) values(USERS_SEQ.NEXTVAL, 'marcos','1234', 'Marcos', 'A',sysdate,sysdate);

create table SK8LINE.TB_PRODUCTS(
    CD_PRODUCT      numeric(18) not null primary key, --Código único de identificação do produto
    DC_PRODUCT      varchar2(200),                    --Descrição do produto
    NU_PRICE_SALE   numeric(18,2),                    --Preço de Vendas do produto
    CD_CATEGORY     numeric(18) not null,
    DT_CREATE       date not null,                     --Data de criação do registro
    DT_LAST_UPD     date not null                      --Data da última atualização
);

create sequence  SK8LINE.PRODUCT_SEQ  increment by 1 start with 1 nocache nocycle;

create table SK8LINE.TB_CATEGORY(
    CD_CATEGORY numeric(18) not null primary key,
    DC_CATEGORY varchar2(200) not null
);

create sequence  SK8LINE.CATEGORY_SEQ  increment by 1 start with 1 nocache nocycle;

create table SK8LINE.TB_CLIENTS(
    CD_CLIENT numeric(18) not null primary key,--Código do Cliente
    DC_CLIENT varchar(200) not null,
    IN_TYPE_CLIENT char(1) not null,
    DC_CPF_CNPJ varchar(20) not null,
    DT_BIRTH_DATE date not null,
    DT_CREATE date not null,                  --Data de criação do registro
    DT_LAST_UPD date not null                 --Data da última atualização do Cliente
);

create sequence  SK8LINE.CLIENT_SEQ  increment by 1 start with 1 nocache nocycle;

create table SK8LINE.TB_UF(
    CD_UF numeric(18) not null primary key,  --Código
    CD_ABREV_UF CHAR(2) not null,
    DC_UF   varchar2(200) not null
);

create sequence  SK8LINE.UF_SEQ  increment by 1 start with 1 nocache nocycle;

create table SK8LINE.TB_CITY(
    CD_CITY numeric(18)   not null primary key,  --Código
    DC_CITY varchar2(200) not null, 
    CD_UF   numeric(18)   not null
);

create sequence  SK8LINE.CITY_SEQ  increment by 1 start with 1 nocache nocycle;

create table SK8LINE.TB_ADDRESS(
    CD_ADDRESS       numeric(18) not null primary key,  --Código
    DC_ADDRESS       varchar2(200) not null,
    CD_CLIENT        numeric(18) not null,
    IN_TYPE_ADDRESS  char(1),                           -- E- Endereço de Entrega, C - Cobrança e nulo sem tipo.
    CD_CITY          numeric(18) not null
);

create sequence  SK8LINE.ADDRESS_SEQ  increment by 1 start with 1 nocache nocycle;

create table SK8LINE.EMPLOYEE(
    CD_EMPLOYEE
    DC_EMPLOYEE
    DT_HIRE
    DT_BIRTH_DATE date not null,
);

