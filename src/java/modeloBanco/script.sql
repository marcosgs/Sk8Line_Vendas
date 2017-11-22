create user SK8LINE identified by sk8line;

grant connect to SK8LINE;

grant all privilege to SK8LINE;

create table SK8LINE.TB_USERS(
    CD_USER       numeric(18) not null primary key, --Código unico de identificação do usuário do usuário
    DC_NAME_USER  varchar2(200) not null,      --Login do usuário
    DC_PASSWORD   varchar2(500) not null,      --Senha do Usuário Criptografada
    DC_NAME       varchar(200) not null,       -- Nome completo do usuário
    IN_ADMIN      CHAR(1) not null,            --Indicador se administrador
    CD_CLIENT     numeric(18),                 --FK com tabela Cliente(Código do Cliente)
    CD_EMPLOYEE   numeric(18),
    DT_CREATE     date not null,               --Data de criação do registro
    DT_LAST_UPD   date not null                --Data da última atualização
);

create sequence SK8LINE.USERS_SEQ increment by 1 start with 1 nocache nocycle;

alter table SK8LINE.TB_USERS add constraint CS_KEY_USER unique (DC_NAME_USER );

insert into SK8LINE.TB_USERS(CD_USER, DC_NAME_USER, DC_PASSWORD, DC_NAME, IN_ADMIN, DT_CREATE, DT_LAST_UPD) values(USERS_SEQ.NEXTVAL, 'admin','admin', 'Admin Master', 'S',sysdate,sysdate);

insert into SK8LINE.TB_USERS(CD_USER, DC_NAME_USER, DC_PASSWORD, DC_NAME, IN_ADMIN, DT_CREATE, DT_LAST_UPD) values(USERS_SEQ.NEXTVAL, 'marcos','1234', 'Marcos', 'N',sysdate,sysdate);

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
    CD_UF numeric(18) not null primary key,  --Código do uf
    CD_ABREV_UF CHAR(2) not null,            --Sigla do Estado
    DC_UF   varchar2(200) not null           --Descrição
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
    DC_DISTRICT      varchar2(200) not null,
    CD_CLIENT        numeric(18) not null,
    IN_TYPE_ADDRESS  char(1),                           -- E- Endereço de Entrega, C - Cobrança e nulo sem tipo.
    CD_CITY          numeric(18) not null
);

create sequence  SK8LINE.ADDRESS_SEQ  increment by 1 start with 1 nocache nocycle;

create table SK8LINE.TB_EMPLOYEE(
    CD_EMPLOYEE   numeric(18) not null primary key,  --Código
    DC_EMPLOYEE   varchar2(200) not null,
    DT_HIRE       date not null,
    DT_BIRTH_DATE date not null
);

create sequence  SK8LINE.EMPLOYEE_SEQ  increment by 1 start with 1 nocache nocycle;

create table SK8LINE.TB_ORDER(
    CD_ORDER       numeric(18)   not null primary key,  --Código do pedido
    DT_ORDER       date          not null,
    CD_CLIENT      numeric(18)   not null,
    CD_STATUS      char(1)       not null,              --Status do pedido: A - Aberto, P - Pendente, F - Finalizado
    VL_DISCOUNT    numeric(18,2) ,
    VL_TOTAL       numeric(18,2) not null
);

create sequence  SK8LINE.ORDER_SEQ  increment by 1 start with 1 nocache nocycle;

create table SK8LINE.TB_ORDER_ITEM(
    CD_ORDER_ITEM  numeric(18) not null primary key,  --Código
	CD_ORDER       numeric(18) not null, 
    CD_PRODUCT     numeric(18) not null, 
    NU_QUANTITY    numeric(18) not null,
    VL_UNIT        numeric(18,2) not null
);

create sequence  SK8LINE.ORDER_ITEM_SEQ  increment by 1 start with 1 nocache nocycle;

create table SK8LINE.TB_REVENUES(
    CD_REVENUES          numeric(18)   not null primary key,  --Código
    CD_ORDER            numeric(18)   not null,
    CD_CLIENT           numeric(18)   not null,
    CD_STATUS           char(1)       not null,              --Status do pedido: A - Aberto, F - Finalizado
    CD_STATUS_DELIVERY  char(1)       not null,              --Status do pedido: P - Pendente, S - Separação, T - Em Transito, E - Entregue
    DT_REVENUES         date          not null,
    DT_DELIVERY         date          not null,
    VL_DISCOUNT         numeric(18,2) ,
    VL_TOTAL            numeric(18,2) not null
);

create sequence  SK8LINE.REVENUES_SEQ  increment by 1 start with 1 nocache nocycle;

create table SK8LINE.TB_REVENUES_ITEM(
    CD_REVENUES_ITEM  numeric(18) not null primary key,  --Código
    CD_REVENUES       numeric(18) not null,
    CD_PRODUCT        numeric(18) not null, 
    NU_QUANTITY       numeric(18) not null,
    VL_UNIT           numeric(18,2) not null
);

create sequence  SK8LINE.REVENUES_ITEMS_SEQ  increment by 1 start with 1 nocache nocycle;

Alter table SK8LINE.TB_USERS add constraint FK_USERS_CLIENT foreign key (CD_CLIENT) references SK8LINE.TB_CLIENTS(CD_CLIENT);

Alter table SK8LINE.TB_USERS add constraint FK_USERS_EMPLOYEE foreign key (CD_EMPLOYEE) references SK8LINE.TB_EMPLOYEE(CD_EMPLOYEE);

alter table SK8LINE.TB_PRODUCTS add constraint FK_PRODUCTS_CATEGORY foreign key (CD_CATEGORY) references SK8LINE.TB_CATEGORY(CD_CATEGORY);

alter table SK8LINE.TB_CITY add constraint FK_CITY_UF foreign key (CD_UF) references SK8LINE.TB_UF(CD_UF);

alter table SK8LINE.TB_ORDER add constraint FK_ORDER_CLIENT foreign key (CD_CLIENT) references SK8LINE.TB_CLIENTS(CD_CLIENT);

alter table SK8LINE.TB_ORDER_ITEM add constraint FK_ORDER_ITEM_PRODUCT foreign key (CD_PRODUCT) references SK8LINE.TB_PRODUCTS(CD_PRODUCT);

alter table SK8LINE.TB_ORDER_ITEM add constraint FK_ORDER_ITEM_ORDER foreign key (CD_ORDER) references SK8LINE.TB_ORDER(CD_ORDER);


