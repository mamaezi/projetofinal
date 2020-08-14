package br.com.maezicorp.projetofinal.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.maezicorp.projetofinal.dao.AgendamentoDAO;
import br.com.maezicorp.projetofinal.model.Agencia;
import br.com.maezicorp.projetofinal.model.Agendamento;

@RestController
@CrossOrigin("*")

public class AgendamentoController {
	@Autowired
	AgendamentoDAO dao;

	@PostMapping ("/agendamentos/novo")
	public ResponseEntity<Agendamento> inserirNovoAgendamento(@RequestBody Agendamento novo){
		try {
			//	System.out.println("DEBUG - HORA - "+novo.getHoraAgendamento().toString());
			//	System.out.println("DEBUG - DATA - "+novo.getDataAgendamento().toString());
		
				dao.save(novo);
				return ResponseEntity.status(201).body(novo);
				
		}
		catch (Exception ex){ 
				return ResponseEntity.status(400).build();
		}
	
	}
	
	@GetMapping ("/agendamentos/todos")
	public ArrayList <Agendamento> recuperarTodos(){
		ArrayList<Agendamento> lista;
	lista = (ArrayList<Agendamento>)dao.findAll();
	return lista;
	}
	
	@GetMapping ("/agendamentos/filtrarporcliente")
	public ArrayList <Agendamento> filtrarPorCliente(@RequestParam(name="nomeCliente") String nome){
		 System.out.println("nome do cliente = "+nome);
		return dao.findAllByNomeClienteContaining(nome);
	}
	
	
	@GetMapping ("/agendamentos/filtrarporagencia")
	public ArrayList <Agendamento> filtrarPorAgencia(@RequestParam(name="agencia") int agencia){
		 System.out.println("agencia = "+agencia);
		 Agencia ag = new Agencia();
		 ag.setId(agencia);
		return dao.findAllByAgencia(ag);
	}
	
	@GetMapping("/agendamentos/filtrarpordata")
	public ArrayList<Agendamento> filtrarPorData(@RequestParam(name = "dataAgendamento") String dataAgendamento) {
		System.out.println("Data = " + dataAgendamento);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(dataAgendamento, fmt);
		return dao.findAllByDataAgendamento(data);
	}
	@GetMapping("/agendamentos/filtrartodos")
	public ArrayList<Agendamento> filtrarPorTodos(@RequestParam(name = "nomeCliente") String nome,@RequestParam(name = "agencia") int agencia,@RequestParam(name = "dataAgendamento") String dataAgendamento){
		System.out.println("nome do cliente = " + nome);
		System.out.println("agencia = " + agencia);
		System.out.println("Data = " + dataAgendamento);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(dataAgendamento, fmt);
		Agencia ag = new Agencia();
		ag.setId(agencia);
		return dao.findAllByNomeClienteAndAgenciaAndDataAgendamento(nome,ag,data);
	}
	@GetMapping("/agendamentos/filtrarclienteagencia")
	public ArrayList<Agendamento> filtrarPorClienteAgencia(@RequestParam(name = "nomeCliente") String nome,@RequestParam(name = "agencia") int agencia){
		System.out.println("nome do cliente = " + nome);
		System.out.println("agencia = " + agencia);
		Agencia ag = new Agencia();
		ag.setId(agencia);
		return dao.findAllByNomeClienteAndAgencia(nome,ag);
	}
	@GetMapping("/agendamentos/filtrarporagenciadata")
	public ArrayList<Agendamento> filtrarPorDataAgencia(@RequestParam(name = "agencia") int agencia,@RequestParam(name = "dataAgendamento") String dataAgendamento){
		System.out.println("agencia = " + agencia);
		System.out.println("Data = " + dataAgendamento);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(dataAgendamento, fmt);
		Agencia ag = new Agencia();
		ag.setId(agencia);
		return dao.findAllByDataAgendamentoAndAgencia(data,ag);
	}
	
	@GetMapping("/agendamentos/filtrarclientedata")
	public ArrayList<Agendamento> filtrarPorClienteData(@RequestParam(name = "nomeCliente") String nome,@RequestParam(name = "dataAgendamento") String dataAgendamento){
		System.out.println("nome do cliente = " + nome);
		System.out.println("Data = " + dataAgendamento);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(dataAgendamento, fmt);
		return dao.findAllByNomeClienteAndDataAgendamento(nome,data);
	}

	
	
	
}
