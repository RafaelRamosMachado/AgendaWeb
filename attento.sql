create database dbagenda_atento;
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

