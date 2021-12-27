package model;

import java.sql.Date;
//import java.util.Date;

public class JavaBeans {
	private String id_atendimento;
	private String nome_cliente; 
	private String telefone_cliente;
	private String fisio;
	private String local_hospital;
	private String nome_cirurgiao;
	private String procedimento_cirurgia;
	private String cor_tape;
	private Date data_avaliacao;
	private Date data_cirurgia;
	private String horario_cirurgia;
	
	public JavaBeans() {
		super();
		
	}
	
	public JavaBeans(String id_atendimento, String nome_cliente, String telefone_cliente, String fisio,
			String local_hospital, String nome_cirurgiao, String procedimento_cirurgia, String cor_tape,
			Date data_avaliacao, Date data_cirurgia, String horario_cirurgia) {
		super();
		this.id_atendimento = id_atendimento;
		this.nome_cliente = nome_cliente;
		this.telefone_cliente = telefone_cliente;
		this.fisio = fisio;
		this.local_hospital = local_hospital;
		this.nome_cirurgiao = nome_cirurgiao;
		this.procedimento_cirurgia = procedimento_cirurgia;
		this.cor_tape = cor_tape;
		this.data_avaliacao = data_avaliacao;
		this.data_cirurgia = data_cirurgia;
		this.horario_cirurgia = horario_cirurgia;
	}

	public String getId_atendimento() {
		return id_atendimento;
	}
	public void setId_atendimento(String id_atendimento) {
		this.id_atendimento = id_atendimento;
	}
	public String getNome_cliente() {
		return nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	public String getTelefone_cliente() {
		return telefone_cliente;
	}
	public void setTelefone_cliente(String telefone_cliente) {
		this.telefone_cliente = telefone_cliente;
	}
	public String getfisio() {
		return fisio;
	}
	public void setfisio(String fisio) {
		this.fisio = fisio;
	}
	public String getLocal_hospital() {
		return local_hospital;
	}
	public void setLocal_hospital(String local_hospital) {
		this.local_hospital = local_hospital;
	}
	public String getNome_cirurgiao() {
		return nome_cirurgiao;
	}
	public void setNome_cirurgiao(String nome_cirurgiao) {
		this.nome_cirurgiao = nome_cirurgiao;
	}
	public String getProcedimento_cirurgia() {
		return procedimento_cirurgia;
	}
	public void setProcedimento_cirurgia(String procedimento_cirurgia) {
		this.procedimento_cirurgia = procedimento_cirurgia;
	}
	public String getCor_tape() {
		return cor_tape;
	}
	public void setCor_tape(String cor_tape) {
		this.cor_tape = cor_tape;
	}
	public Date getData_avaliacao() {
		return data_avaliacao;
	}
	public void setData_avaliacao(Date data_avaliacao) {
		this.data_avaliacao = data_avaliacao;
	}
	public Date getData_cirurgia() {
		return data_cirurgia;
	}
	public void setData_cirurgia(Date data_cirurgia) {
		this.data_cirurgia = data_cirurgia;
	}
	public String getHorario_cirurgia() {
		return horario_cirurgia;
	}
	public void setHorario_cirurgia(String horario_cirurgia) {
		this.horario_cirurgia = horario_cirurgia;
	}	
}
