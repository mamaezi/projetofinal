package br.com.maezicorp.projetofinal.model;


import java.time.LocalDate;
import java.time.LocalTime;
//import java.util.Calendar;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="itmn032_agendamento")

public class Agendamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="num_seq")
	private int numSeq;
	
	@Column (name="nome_cli",length=100)
	private String nomeCliente;
	
	@Column (name="email_cli",length=100)
	private String emailCliente;

	
	@Column (name="celular_cli",length=20)
	private String celularCliente;
	
	@Column (name="data_agendamento")
	//@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataAgendamento;
	
	@Column (name="hora_agendamento")
	//@Temporal(TemporalType.TIME)
	@JsonFormat(pattern="HH:mm", shape=JsonFormat.Shape.STRING, timezone="America/Sao_Paulo")
	private LocalTime horaAgendamento;
	
	@Column (name="observacao", length=255)
	private String observacao;

	

	@ManyToOne
	@JoinColumn(name="id_agencia")
	@JsonIgnoreProperties("listaAgendamentos")
	private Agencia agencia;
	
	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

		public int getNumSeq() {
		return numSeq;
	}

	public void setNumSeq(int numSeq) {
		this.numSeq = numSeq;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getCelularCliente() {
		return celularCliente;
	}

	public void setCelularCliente(String celularCliente) {
		this.celularCliente = celularCliente;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public LocalTime getHoraAgendamento() {
		return horaAgendamento;
	}

	public void setHoraAgendamento(LocalTime horaAgendamento) {
		this.horaAgendamento = horaAgendamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
		
}
