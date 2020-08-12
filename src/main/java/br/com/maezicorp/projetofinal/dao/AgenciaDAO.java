package br.com.maezicorp.projetofinal.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.maezicorp.projetofinal.model.Agencia;

public interface AgenciaDAO extends CrudRepository<Agencia,Integer>{
public Agencia findByNomeAgencia(String nomeAgencia);
public ArrayList<Agencia> findAllByOrderByNomeAgencia();
}
