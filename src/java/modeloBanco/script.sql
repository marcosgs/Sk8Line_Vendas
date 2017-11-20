create user sk8line identified by sk8line;

grant connect to sk8line;

grant all privilege to sk8line;

create table sk8line.TB_USERS(
    CD_USER numeric(18) not null primary key, --Código unico de identificação do usuário do usuário
    DC_NAME_USER varchar2(200) not null,      --Login do usuário
    DC_PASSWORD  varchar2(500) not null,      --Senha do Usuário Criptografada
    DC_NAME varchar(200) not null,            -- Nome completo do usuário
    IN_ADMIN_IND CHAR(1) not null,            --Indicador se administrador ou Usuário
    CD_CLIENT numeric(18)  ,                  --FK com tabela Cliente(Código do Cliente)
    DT_CREATE date not null,                  --Data de criação do registro
    DT_LAST_UPD date not null                 --Data da última atualização do Cliente
);

create sequence sk8line.USERS_SEQ increment by 1 start with 1 nocache nocycle;

insert into sk8line.TB_USERS(CD_USER, DC_NAME_USER, DC_PASSWORD, DC_NAME, IN_ADMIN_IND, DT_CREATE, DT_LAST_UPD) values(USERS_SEQ.NEXTVAL, 'root','root', 'Root Master', 'S',sysdate,sysdate);

create table sk8line.TB_PRODUCTS(
    CD_PRODUCT numeric(18) not null primary key, --Código único de identificação do produto
    DC_PRODUCT varchar2(200),                    --Descrição do produto
    NU_PRICE_SALE   numeric(18,2),               --Preço de Vendas do produto
    DT_CREATE date not null,
    DT_LAST_UPD date not null
);

create sequence  sk8line.PRODUCT_SEQ  increment by 1 start with 1 nocache nocycle;

create table sk8line.TB_CLIENTS(
    CD_CLIENT numeric(18) not null primary key,--Código do Cliente
    DC_CLIENT varchar(200) not null,
    IN_TYPE_CLIENT char(1) not null,
    DC_CPF_CNPJ varchar(20) not null,
    DT_BIRTH_DATE date not null,

);

create sequence  sk8line.CLIENT_SEQ  increment by 1 start with 1 nocache nocycle;

