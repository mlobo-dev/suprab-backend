--DROP TABLE IF EXISTS TB_MEMBRO;
--CREATE TABLE TB_MEMBRO (
--    COD_MEMBRO BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
--    TX_STATUS VARCHAR(255),
--    TX_CGP VARCHAR(255),
--    TX_CPF VARCHAR(11),
--    TX_NOME VARCHAR(255),
--    TX_CIDADE VARCHAR(255),
--    TX_UF VARCHAR(255),
--    TX_CARGO VARCHAR(255),
--    TX_TITULO_HONORIFICO VARCHAR(255),
--    TX_GRAU VARCHAR(255),
--    TX_TIPO_SANGUINEO(2),
--    TX_CORPO_FILOSOFICO VARCHAR(255),
--    DT_GRAU VARCHAR(255),
--    DT_NASCIMENTO VARCHAR(255)
--);
--
--DROP TABLE IF EXISTS TB_NOTIFICACAO;
--CREATE TABLE TB_NOTIFICACAO (
--    COD_NOTIFICACAO BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
--    TX_TITULO VARCHAR(255),
--    TX_MENSAGEM TEXT
--);
--
--DROP TABLE IF EXISTS TB_USUARIO;
--CREATE TABLE TB_USUARIO (
--    COD_USUARIO BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
--    TX_NOME VARCHAR(255),
--    TX_CPF VARCHAR(255),
--    TX_SENHA VARCHAR(255),
--    TX_LOGIN VARCHAR(255)
--);