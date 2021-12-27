create database dbagenda_atento;
show databases;
use dbagenda_atento;
create table atendimentos(
	id_atendimento int primary key auto_increment,
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
show tables;
describe atendimentos;

drop table atendimentos;

/* CRUD CREATE */
insert into atendimentos(nome_cliente,telefone_cliente,fisio,local_hospital,
nome_cirurgiao,procedimento_cirurgia,cor_tape,data_avaliacao,data_cirurgia,horario_cirurgia) values('Teste',
'33334444','Juliana','hospital','jose','lipo','azul','2021-10-10','2021-10-23','16:20');

/* CRUD READ */
select * from atendimentos; 
select * from atendimentos order by data_avaliacao;

select * from atendimentos where id_atendimento=1;

select nome_cliente,data_avaliacao,data_cirurgia, to_char(data_cirurgia, 'DD/MM/YYYY') from atendimentos;

DELETE FROM atendimentos WHERE id_atendimento = 2;

/* CRUD UPDATE */
