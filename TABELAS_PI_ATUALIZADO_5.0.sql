CREATE DATABASE LIVRARIA;
USE LIVRARIA;

CREATE TABLE CLIENTE (
    ID_CLIENTE INT NOT NULL AUTO_INCREMENT,
    NOME VARCHAR(50) NOT NULL,
    CPF VARCHAR(50) UNIQUE NOT NULL,
    DATA_NASC DATE NOT NULL,
    SEXO VARCHAR(10) NOT NULL,
    EMAIL VARCHAR(50) NOT NULL,
    TELEFONE VARCHAR(14) NOT NULL,
    PRIMARY KEY(ID_CLIENTE)
);

CREATE TABLE FILIAL(
  ID_FILIAL INT NOT NULL AUTO_INCREMENT,
  NOME_FILIAL VARCHAR(20) NOT NULL,
  CIDADE VARCHAR(25) NOT NULL,
  PRIMARY KEY(ID_FILIAL)
);

CREATE TABLE DEPARTAMENTO(
  ID_DPT INT NOT NULL AUTO_INCREMENT,
  NOME_DPT VARCHAR(20) NOT NULL,  
  PRIMARY KEY(ID_DPT)  
);

CREATE TABLE FUNCIONARIO(
  ID_FUNCIONARIO INT NOT NULL AUTO_INCREMENT,
  LOGIN VARCHAR(20) NOT NULL,
  SENHA VARCHAR(100) NOT NULL,
  CPF VARCHAR(14) UNIQUE NOT NULL,
  NOME_FUNC VARCHAR(50) NOT NULL,
  CARGO VARCHAR(30) NOT NULL,
  FK_ID_DPT INT NOT NULL,
  FK_ID_FILIAL INT NOT NULL,
  PRIMARY KEY(ID_FUNCIONARIO),
  FOREIGN KEY(FK_ID_DPT) REFERENCES DEPARTAMENTO(ID_DPT),
  FOREIGN KEY(FK_ID_FILIAL) REFERENCES FILIAL(ID_FILIAL)
);

CREATE TABLE PRODUTO(
  ID_PRODUTO INT NOT NULL AUTO_INCREMENT,
  NOME_PRODUTO VARCHAR(150) NOT NULL,
  VALOR_UNIT NUMERIC(10,2) NOT NULL,
  IDIOMA VARCHAR(20),
  CATEGORIA VARCHAR(20),
  QTD INT NOT NULL,
  AUTOR VARCHAR(50),
  ISBN VARCHAR(50),
  PAGINAS INT,
  EDITORA VARCHAR(50),
  TEMPO VARCHAR(15),
  FK_ID_FILIAL INT NOT NULL,
  PRIMARY KEY(ID_PRODUTO),
  FOREIGN KEY(FK_ID_FILIAL) REFERENCES FILIAL(ID_FILIAL)
);


CREATE TABLE PEDIDOVENDA(
  ID_VENDA INT NOT NULL AUTO_INCREMENT,
  DATA DATE NOT NULL,
  VALOR_TOTAL NUMERIC(10,2) NOT NULL,
  FK_ID_CLIENTE INT,
  FK_ID_FILIAL INT,
  PRIMARY KEY(ID_VENDA),
  FOREIGN KEY(FK_ID_CLIENTE) REFERENCES CLIENTE(ID_CLIENTE),
  FOREIGN KEY(FK_ID_FILIAL) REFERENCES FILIAL(ID_FILIAL)
);


CREATE TABLE ITEMPEDIDO(
  ID_ITEM INT NOT NULL AUTO_INCREMENT,
  QTD INT NOT NULL,
  VALOR_ITEM NUMERIC(10,2) NOT NULL,
  FK_ID_PROD INT NOT NULL,
  FK_ID_VENDA INT ,
  PRIMARY KEY(ID_ITEM),
  FOREIGN KEY(FK_ID_PROD) REFERENCES PRODUTO(ID_PRODUTO),
  FOREIGN KEY(FK_ID_VENDA) REFERENCES PEDIDOVENDA(ID_VENDA)
);

CREATE TABLE DPT_FILIAL(
  ID INT NOT NULL AUTO_INCREMENT,
  FK_ID_DPT INT,
  FK_ID_FILIAL INT,
  PRIMARY KEY(ID),
  FOREIGN KEY(FK_ID_DPT) REFERENCES DEPARTAMENTO(ID_DPT),
  FOREIGN KEY(FK_ID_FILIAL) REFERENCES FILIAL(ID_FILIAL)
);

INSERT INTO LIVRARIA.FILIAL(NOME_FILIAL, CIDADE)
VALUES ('Matriz', 'São Paulo');
INSERT INTO LIVRARIA.FILIAL(NOME_FILIAL, CIDADE)
VALUES ('Brasilia','Brasilia');
INSERT INTO LIVRARIA.FILIAL(NOME_FILIAL, CIDADE)
VALUES ('Campina Grande','Campina Grande');
INSERT INTO LIVRARIA.FILIAL(NOME_FILIAL, CIDADE)
VALUES ('Joinville','Joinville');

/*INSERT PARA DEPARTAMENTO PARA FILIAL MATRIZ - 1*/
INSERT INTO LIVRARIA.DEPARTAMENTO(NOME_DPT)
VALUES('DIRETORIA');
INSERT INTO LIVRARIA.DEPARTAMENTO(NOME_DPT)
VALUES('PRODUTOS/MARKETING');
INSERT INTO LIVRARIA.DEPARTAMENTO(NOME_DPT)
VALUES('TI');
INSERT INTO LIVRARIA.DEPARTAMENTO(NOME_DPT)
VALUES('VENDAS');


INSERT INTO DPT_FILIAL (FK_ID_DPT,FK_ID_FILIAL)VALUES(1,1);
INSERT INTO DPT_FILIAL (FK_ID_DPT,FK_ID_FILIAL)VALUES(2,1);
INSERT INTO DPT_FILIAL (FK_ID_DPT,FK_ID_FILIAL)VALUES(3,1);
INSERT INTO DPT_FILIAL (FK_ID_DPT,FK_ID_FILIAL)VALUES(4,1);
INSERT INTO DPT_FILIAL (FK_ID_DPT,FK_ID_FILIAL)VALUES(1,2);
INSERT INTO DPT_FILIAL (FK_ID_DPT,FK_ID_FILIAL)VALUES(2,2);
INSERT INTO DPT_FILIAL (FK_ID_DPT,FK_ID_FILIAL)VALUES(3,2);
INSERT INTO DPT_FILIAL (FK_ID_DPT,FK_ID_FILIAL)VALUES(4,2);
INSERT INTO DPT_FILIAL (FK_ID_DPT,FK_ID_FILIAL)VALUES(1,3);
INSERT INTO DPT_FILIAL (FK_ID_DPT,FK_ID_FILIAL)VALUES(2,3);
INSERT INTO DPT_FILIAL (FK_ID_DPT,FK_ID_FILIAL)VALUES(3,3);
INSERT INTO DPT_FILIAL (FK_ID_DPT,FK_ID_FILIAL)VALUES(4,3);
INSERT INTO DPT_FILIAL (FK_ID_DPT,FK_ID_FILIAL)VALUES(1,4);
INSERT INTO DPT_FILIAL (FK_ID_DPT,FK_ID_FILIAL)VALUES(2,4);
INSERT INTO DPT_FILIAL (FK_ID_DPT,FK_ID_FILIAL)VALUES(3,4);
INSERT INTO DPT_FILIAL (FK_ID_DPT,FK_ID_FILIAL)VALUES(4,4);

/*INSERT PARA FUNCIONARIOS INICIAIS*/
INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN,SENHA,CPF,NOME_FUNC,CARGO,FK_ID_DPT,FK_ID_FILIAL) VALUES('admin','$2a$10$RYBjpMPbvdcVMICq8BtiB.Q0yMy.ObnLD4znEVbb9HGVwl9Vq.cIu','1','admin','Analista','3','1');
INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN,SENHA,CPF,NOME_FUNC,CARGO,FK_ID_DPT,FK_ID_FILIAL) VALUES('diretor','$2a$10$RYBjpMPbvdcVMICq8BtiB.Q0yMy.ObnLD4znEVbb9HGVwl9Vq.cIu','2','diretor','Diretor','1','1');
INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN,SENHA,CPF,NOME_FUNC,CARGO,FK_ID_DPT,FK_ID_FILIAL) VALUES('vendedor','$2a$10$RYBjpMPbvdcVMICq8BtiB.Q0yMy.ObnLD4znEVbb9HGVwl9Vq.cIu','3','vendedor','Vendedor','4','1');
INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN,SENHA,CPF,NOME_FUNC,CARGO,FK_ID_DPT,FK_ID_FILIAL) VALUES('backoffice','$2a$10$RYBjpMPbvdcVMICq8BtiB.Q0yMy.ObnLD4znEVbb9HGVwl9Vq.cIu','4','backoffice','Backoffice','2','1');

INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN,SENHA,CPF,NOME_FUNC,CARGO,FK_ID_DPT,FK_ID_FILIAL) VALUES('admin2','$2a$10$RYBjpMPbvdcVMICq8BtiB.Q0yMy.ObnLD4znEVbb9HGVwl9Vq.cIu','5','admin2','Analista','3','2');
INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN,SENHA,CPF,NOME_FUNC,CARGO,FK_ID_DPT,FK_ID_FILIAL) VALUES('diretor2','$2a$10$RYBjpMPbvdcVMICq8BtiB.Q0yMy.ObnLD4znEVbb9HGVwl9Vq.cIu','6','diretor2','Diretor','1','2');
INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN,SENHA,CPF,NOME_FUNC,CARGO,FK_ID_DPT,FK_ID_FILIAL) VALUES('vendedor2','$2a$10$RYBjpMPbvdcVMICq8BtiB.Q0yMy.ObnLD4znEVbb9HGVwl9Vq.cIu','7','vendedor2','Vendedor','4','2');
INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN,SENHA,CPF,NOME_FUNC,CARGO,FK_ID_DPT,FK_ID_FILIAL) VALUES('backoffice2','$2a$10$RYBjpMPbvdcVMICq8BtiB.Q0yMy.ObnLD4znEVbb9HGVwl9Vq.cIu','8','backoffice2','Backoffice','2','2');

INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN,SENHA,CPF,NOME_FUNC,CARGO,FK_ID_DPT,FK_ID_FILIAL) VALUES('admin3','$2a$10$RYBjpMPbvdcVMICq8BtiB.Q0yMy.ObnLD4znEVbb9HGVwl9Vq.cIu','9','admin3','Analista','3','3');
INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN,SENHA,CPF,NOME_FUNC,CARGO,FK_ID_DPT,FK_ID_FILIAL) VALUES('diretor3','$2a$10$RYBjpMPbvdcVMICq8BtiB.Q0yMy.ObnLD4znEVbb9HGVwl9Vq.cIu','10','diretor3','Diretor','1','3');
INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN,SENHA,CPF,NOME_FUNC,CARGO,FK_ID_DPT,FK_ID_FILIAL) VALUES('vendedor3','$2a$10$RYBjpMPbvdcVMICq8BtiB.Q0yMy.ObnLD4znEVbb9HGVwl9Vq.cIu','11','vendedor3','Vendedor','4','3');
INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN,SENHA,CPF,NOME_FUNC,CARGO,FK_ID_DPT,FK_ID_FILIAL) VALUES('backoffice3','$2a$10$RYBjpMPbvdcVMICq8BtiB.Q0yMy.ObnLD4znEVbb9HGVwl9Vq.cIu','12','backoffice3','Backoffice','2','3');

INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN,SENHA,CPF,NOME_FUNC,CARGO,FK_ID_DPT,FK_ID_FILIAL) VALUES('admin4','$2a$10$RYBjpMPbvdcVMICq8BtiB.Q0yMy.ObnLD4znEVbb9HGVwl9Vq.cIu','13','admin','Analista','3','4');
INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN,SENHA,CPF,NOME_FUNC,CARGO,FK_ID_DPT,FK_ID_FILIAL) VALUES('diretor4','$2a$10$RYBjpMPbvdcVMICq8BtiB.Q0yMy.ObnLD4znEVbb9HGVwl9Vq.cIu','14','diretor','Diretor','1','4');
INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN,SENHA,CPF,NOME_FUNC,CARGO,FK_ID_DPT,FK_ID_FILIAL) VALUES('vendedor4','$2a$10$RYBjpMPbvdcVMICq8BtiB.Q0yMy.ObnLD4znEVbb9HGVwl9Vq.cIu','15','vendedor','Vendedor','4','4');
INSERT INTO LIVRARIA.FUNCIONARIO(LOGIN,SENHA,CPF,NOME_FUNC,CARGO,FK_ID_DPT,FK_ID_FILIAL) VALUES('backoffice4','$2a$10$RYBjpMPbvdcVMICq8BtiB.Q0yMy.ObnLD4znEVbb9HGVwl9Vq.cIu','16','backoffice','Backoffice','2','4');

/*INSERT PARA PRODUTOS INICIAIS*/
INSERT INTO LIVRARIA.PRODUTO (NOME_PRODUTO, VALOR_UNIT, IDIOMA, CATEGORIA, QTD, AUTOR, ISBN, PAGINAS, EDITORA, TEMPO, FK_ID_FILIAL) VALUES ('Harry Potter', 15, 'Português', 'Livro', 10, 'J. K. Rowling', '9780605039070', 432, 'Rocco',null, 1);
INSERT INTO LIVRARIA.PRODUTO (NOME_PRODUTO, VALOR_UNIT, IDIOMA, CATEGORIA, QTD, AUTOR, ISBN, PAGINAS, EDITORA, TEMPO, FK_ID_FILIAL) VALUES ('Batman', 35, 'Português', 'Hq__Manga', 20, 'Bill Finger', '5665878465487889', 250, 'DC Comics',null, 1);
INSERT INTO LIVRARIA.PRODUTO (NOME_PRODUTO, VALOR_UNIT, IDIOMA, CATEGORIA, QTD, AUTOR, ISBN, PAGINAS, EDITORA, TEMPO, FK_ID_FILIAL) VALUES ('Metallica', 50, 'Inglês', 'Cd_Dvd', 10, null, null, null, null, '2 Horas', 1);
INSERT INTO LIVRARIA.PRODUTO (NOME_PRODUTO, VALOR_UNIT, IDIOMA, CATEGORIA, QTD, AUTOR, ISBN, PAGINAS, EDITORA, TEMPO, FK_ID_FILIAL) VALUES ('Como eu Era Antes de Você', 70, 'Inglês', 'Livro', 35, 'Jojo Moyes', '32165498778', 500, 'Penguin Books', null, 2);
INSERT INTO LIVRARIA.PRODUTO (NOME_PRODUTO, VALOR_UNIT, IDIOMA, CATEGORIA, QTD, AUTOR, ISBN, PAGINAS, EDITORA, TEMPO, FK_ID_FILIAL) VALUES ('Jogos Vorazes', 120, 'Português', 'Livro', 80, 'Suzanne Collins','123564589789', 250, 'Rocco', null, 2);
INSERT INTO LIVRARIA.PRODUTO (NOME_PRODUTO, VALOR_UNIT, IDIOMA, CATEGORIA, QTD, AUTOR, ISBN, PAGINAS, EDITORA, TEMPO, FK_ID_FILIAL) VALUES ('Ansiedade', 30, 'Português', 'Livro', 80, 'Augusto Cury','123564589789', 300, 'Saraiva', null, 2);
INSERT INTO LIVRARIA.PRODUTO (NOME_PRODUTO, VALOR_UNIT, IDIOMA, CATEGORIA, QTD, AUTOR, ISBN, PAGINAS, EDITORA, TEMPO, FK_ID_FILIAL) VALUES ('Aerosmith', 50, 'Inglês', 'Cd_Dvd', 100, null, null, null, null, '1 Hora', 3);
INSERT INTO LIVRARIA.PRODUTO (NOME_PRODUTO, VALOR_UNIT, IDIOMA, CATEGORIA, QTD, AUTOR, ISBN, PAGINAS, EDITORA, TEMPO, FK_ID_FILIAL) VALUES ('Green Day', 50, 'Inglês', 'Cd_Dvd', 150, null, null, null, null, '2 Horas', 3);
INSERT INTO LIVRARIA.PRODUTO (NOME_PRODUTO, VALOR_UNIT, IDIOMA, CATEGORIA, QTD, AUTOR, ISBN, PAGINAS, EDITORA, TEMPO, FK_ID_FILIAL) VALUES ('Pearl Jam', 35, 'Inglês', 'Cd_Dvd', 120, null, null, null, null, '3 Horas', 3);
INSERT INTO LIVRARIA.PRODUTO (NOME_PRODUTO, VALOR_UNIT, IDIOMA, CATEGORIA, QTD, AUTOR, ISBN, PAGINAS, EDITORA, TEMPO, FK_ID_FILIAL) VALUES ('Homem-Aranha', 45, 'Espanhol', 'Hq__Manga', 200, 'Stan Lee', '54654232154874', 600, 'Marvel', null, 4);
INSERT INTO LIVRARIA.PRODUTO (NOME_PRODUTO, VALOR_UNIT, IDIOMA, CATEGORIA, QTD, AUTOR, ISBN, PAGINAS, EDITORA, TEMPO, FK_ID_FILIAL) VALUES ('Homem-Formiga', 45, 'Inglês', 'Hq__Manga', 250, 'Stan Lee', '5465457898456', 620, 'Marvel', null, 4);
INSERT INTO LIVRARIA.PRODUTO (NOME_PRODUTO, VALOR_UNIT, IDIOMA, CATEGORIA, QTD, AUTOR, ISBN, PAGINAS, EDITORA, TEMPO, FK_ID_FILIAL) VALUES ('U2', 60, 'Inglês', 'Cd_Dvd', 100, null, null, null, null, '4 Horas', 4);

/*INSERT PARA CLIENTES INICIAIS*/
INSERT INTO LIVRARIA.CLIENTE (NOME, CPF, DATA_NASC, SEXO, EMAIL, TELEFONE) VALUES ('Fulana da Silva', '051.485.568-11', '1983-01-26', 'feminino', 'fulana.silva@email.com', '(11)98746-3542');
INSERT INTO LIVRARIA.CLIENTE (NOME, CPF, DATA_NASC, SEXO, EMAIL, TELEFONE) VALUES ('Antonio Pereira', '123.456.845-25', '1989-06-13', 'masculino', 'antonio.s@email.com', '(11)95487-5657');
INSERT INTO LIVRARIA.CLIENTE (NOME, CPF, DATA_NASC, SEXO, EMAIL, TELEFONE) VALUES ('Elisa Analu Isabela da Conceição', '459.348.554-36', '1994-04-17', 'masculino', 'eaidac@email.com', '(11)94575-1597');