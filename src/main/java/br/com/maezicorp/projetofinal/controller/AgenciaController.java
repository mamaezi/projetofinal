package br.com.maezicorp.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.maezicorp.projetofinal.dao.AgenciaDAO;
import br.com.maezicorp.projetofinal.model.Agencia;

@RestController
@CrossOrigin("*")
public class AgenciaController {
	@Autowired
	AgenciaDAO dao;

	@GetMapping("/agencias")
	public ArrayList<Agencia> getAll() {
		ArrayList<Agencia> lista;
		lista =dao.findAllByOrderByNomeAgencia();
		return lista;
	}

}
