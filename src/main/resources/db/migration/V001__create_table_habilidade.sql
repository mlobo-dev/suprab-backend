drop table if exists tb_membro;
create table tb_membro (
    cod_membro bigint not null auto_increment primary key,
    tx_cargo varchar(255),
    tx_cgp varchar(255),
    tx_cpf varchar(255),
    dt_nascimento varchar(255),
    tx_nome varchar(255),
    tx_status integer,
    tx_tipo_sanguineo varchar(255),
    tx_titulo_honorifico varchar(255),
    cod_endereco bigint
);

drop table if exists tb_usuario;
create table tb_usuario (
    cod_usuario bigint not null auto_increment primary key,
    tx_cpf varchar(255),
    tx_login varchar(255),
    tx_nome varchar(255),
    tx_senha varchar(255)
);

drop table if exists tb_notificacao;
create table tb_notificacao (
    cod_notificacao bigint not null auto_increment primary key,
    tx_mensagem varchar(255),
    tx_titulo varchar(255),
    TX_DATA_NOTIFICACAO varchar(255)
);

create table tb_endereco (
    cod_endereco bigint not null auto_increment primary key,
    tx_cep varchar(255),
    tx_cidade varchar(255),
    tx_cpf varchar(255),
    tx_uf varchar(255)
);

drop table if exists tb_corpo_filosofico;
create table tb_corpo_filosofico (
    cod_corpo_filosofico bigint not null auto_increment primary key,
    tx_corpo varchar(255),
    dt_grau varchar(255),
    tx_grau varchar(255)
);

drop table if exists tb_membro_corpo_filosofico;
create table tb_membro_corpo_filosofico (
    cod_membro bigint not null,
    cod_corpo_filosofico bigint not null
);


