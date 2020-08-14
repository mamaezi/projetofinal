package br.com.maezicorp.projetofinal.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.maezicorp.projetofinal.model.Agencia;
import br.com.maezicorp.projetofinal.model.Agendamento;

public interface AgendamentoDAO extends CrudRepository<Agendamento,Integer> {
public ArrayList<Agendamento> findAllByNomeClienteContaining(String nomeCliente);
public ArrayList<Agendamento> findAllByAgencia(Agencia agencia);
public ArrayList<Agendamento> findAllByAgenciaAndNomeClienteContaining(Agencia agencia, String nomeCliente);
public ArrayList<Agendamento> findAllByDataAgendamento(LocalDate dataAgendamento);
public ArrayList<Agendamento> findAllByNomeClienteAndAgenciaAndDataAgendamento(String nome, Agencia ag,	LocalDate data);
public ArrayList<Agendamento> findAllByNomeClienteAndAgencia(String nome, Agencia ag);
public ArrayList<Agendamento> findAllByNomeClienteAndDataAgendamento(String nome, LocalDate data);
public ArrayList<Agendamento> findAllByDataAgendamentoAndAgencia(LocalDate data, Agencia ag);



}



