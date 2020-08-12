package br.com.maezicorp.projetofinal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="itmn032_agencia")
public class Agencia {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column (name="id")
private int id;

@Column (name="nome_agencia",length=100)
private String nomeAgencia;

@Column (name="hora_inicio")
private int horaInicio;


@Column (name="hora_fim")
private int horaFim;

@OneToMany(mappedBy="agencia", cascade=CascadeType.ALL)
@JsonIgnoreProperties("agencia")
private List<Agendamento> listaAgendamentos;



public String getNomeAgencia() {
	return nomeAgencia;
}
public void setNomeAgencia(String nomeAgencia) {
	this.nomeAgencia = nomeAgencia;
}
public int getHoraInicio() {
	return horaInicio;
}
public void setHoraInicio(int horaInicio) {
	this.horaInicio = horaInicio;
}
public int getHoraFim() {
	return horaFim;
}
public void setHoraFim(int horaFim) {
	this.horaFim = horaFim;
}
public List<Agendamento> getListaAgendamentos() {
	return listaAgendamentos;
}
public void setListaAgendamentos(List<Agendamento> listaAgendamentos) {
	this.listaAgendamentos = listaAgendamentos;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
