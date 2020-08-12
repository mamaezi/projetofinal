package br.com.maezicorp.projetofinal.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.maezicorp.projetofinal.model.Usuario;

/*
  save    gravar
  delete  excluir
  findById encontrar
  findAll retornar todos
  count  quantos registros
 */
 public interface UsuarioDAO extends CrudRepository<Usuario,Integer>{

	 public Usuario findByEmailAndSenha(String email,String senha);
	 
	 public Usuario findByEmail(String email);

}
