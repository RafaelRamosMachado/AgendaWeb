use test;
use dbagenda_atento;
use salesdb;
use teste;
use projetoIntegrador;
use gastos;

describe agendamento;
describe testando;
describe gasto;

SELECT `gasto`.`id_gasto`,
    `gasto`.`nome_gasto`,
    `gasto`.`valor_gasto`,
    `gasto`.`data_entrada_gasto`,
    `gasto`.`data_vencimento_gasto`,
    `gasto`.`nota_gasto`,
    `gasto`.`situacao_gasto`,
    `gasto`.`obs_gasto`,
    `gasto`.`num_parcelas`,
    `gasto`.`num_dias`
FROM `gastos`.`gasto`;


select * from agendamento;
select * from testando;
select * from atendimentos;

create database projetoIntegrador;
create database salesdb;
create database gastos;

create table users(
	 userid int primary key auto_increment,
     firstName varchar(45),
     lastName varchar(45),
     dob date,
     email varchar(45)
);

create table fornecedor(
	id_fornecedor int primary key auto_increment,
    nome_fornecedor varchar(45) not null
);
insert into fornecedor(nome_fornecedor) values('Supermercado');
insert into gasto(nome_gasto, valor_gasto, data_entrada_gasto, data_vencimento_gasto, nota_gasto, 
situacao_gasto, obs_gasto, num_parcelas, num_dias) values('Supermercado', 210, '2021-10-10', '2021-10-11',
'2389', 'Pago', 'Teste', '2', '10');
create table gasto(
	id_gasto int primary key auto_increment,
    nome_gasto varchar(100) not null,
    valor_gasto double not null,
    data_entrada_gasto date not null,
    data_vencimento_gasto date not null,
    nota_gasto varchar(50),
    situacao_gasto varchar(100) not null,
    obs_gasto varchar(200),
    num_parcelas varchar(20),
    num_dias varchar(20)
);

drop table gasto;

select * from fornecedor;
select * from gasto;


create table product(
	id int primary key auto_increment,
    nome varchar(45) not null,
    marca varchar(45) not null,
    pais varchar(45) not null,
    valor float not null
);

show tables;
select * from product;

create database dbagenda_atentoo;
show databases;
use dbagenda_atentoo;
create table atendimentos(
	idcon int primary key auto_increment,
    nome_cliente varchar(100) not null,
    telefone_cliente varchar(20) not null,
    fisio varchar(50),
    local_hospital varchar(300) not null,
    nome_cirurgiao varchar(100) not null,
    procedimento_cirurgia varchar(500) not null,
    cor_tape varchar(50) not null,
    data_avaliacao date not null,
    data_cirurgia date not null,
    horario_cirurgia varchar(50) not null
);
create database agenda;
use agenda;
drop table atendimentos;
create table atendimentos(
	id int primary key auto_increment,
    cliente varchar(100) not null,
    telefone varchar(20) not null,
    fisio varchar(50) not null,
    hospital varchar(300) not null,
    cirurgiao varchar(100) not null,
    procedimento varchar(500) not null,
    tape varchar(50) not null,
    data_avaliacao date not null,
    data_cirurgia date not null,
    horario_cirurgia varchar(50) not null
);
show tables;
describe atendimentos; 
use dbagenda_atento;
select * from atendimentos;


update atendimentos set nome_cliente="Teste",telefone_cliente="33332222",fisio="Ju",
local_hospital="HV", nome_cirurgiao="Paulo",procedimento_cirurgia="Barriga",cor_tape="Azul",
data_avaliacao="2021-09-08",data_cirurgia="2021-06-09",horario_cirurgia="10:00" where id_atendimento=14;