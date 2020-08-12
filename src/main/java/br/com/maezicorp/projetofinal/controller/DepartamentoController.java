package br.com.maezicorp.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.maezicorp.projetofinal.dao.DepartamentoDAO;
import br.com.maezicorp.projetofinal.model.Departamento;


@RestController
@CrossOrigin("*")
public class DepartamentoController {
	@Autowired
	
	DepartamentoDAO dao;
	

	//lista todos os departamentos
	@GetMapping("/departamentos")
	
	public ArrayList<Departamento> getAll(){
	
		ArrayList<Departamento> lista;
	
		lista = (ArrayList<Departamento>)dao.findAll();
	
	return lista;
	}
		
	//lista um departamentos
	@GetMapping("/departamentos/{id}")
	public ResponseEntity<Departamento> getDepartamentoPeloId(@PathVariable int id) {
				Departamento resultado = dao.findById(id).orElse(null);
				if (resultado!=null) {
				return ResponseEntity.ok(resultado);
				}
				else {
					return ResponseEntity.status(401).build();
				}
			}
		
}
