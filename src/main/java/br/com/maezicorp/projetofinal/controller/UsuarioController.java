
package br.com.maezicorp.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.maezicorp.projetofinal.dao.UsuarioDAO;
import br.com.maezicorp.projetofinal.model.Usuario;

@RestController
@CrossOrigin("*")
public class UsuarioController {
	
//

@Autowired

private UsuarioDAO dao;

// mapeia todos os usuarios
@GetMapping("/usuarios")
public ArrayList<Usuario> getAll(){
	ArrayList<Usuario> lista;
	lista = (ArrayList<Usuario>)dao.findAll();
	for (Usuario u:lista) {
		u.setSenha("*********");
	}
	return lista;			
}

//mapeia um unico usuario
@GetMapping("/usuarios/{id}")
public ResponseEntity<Usuario> getUsuarioPeloId(@PathVariable int id) {
	Usuario resultado = dao.findById(id).orElse(null);
	if (resultado!=null) {
	return ResponseEntity.ok(resultado);}
	else {
		return ResponseEntity.status(401).build();
	}
}

//outro metodo de login
@PostMapping("/login1")

public Usuario Login (@RequestBody Usuario dadosLogin) {
System.out.println("--> degub:" + dadosLogin);
Usuario resultado1 = dao.findByEmailAndSenha(dadosLogin.getEmail(), dadosLogin.getSenha());
if (resultado1 !=null) {
	System.out.println("ACHOU"+resultado1);
}

else {
	System.out.println("NAO ACHOU");
}
return null;
}

// metodo inicial
@PostMapping ("/login")
public ResponseEntity<Usuario> login (@RequestBody Usuario dadosLogin){
	Usuario resultado = dao.findByEmail(dadosLogin.getEmail());
	
if (resultado !=null)
{
	if (resultado.getSenha().equals(dadosLogin.getSenha())) {

		return ResponseEntity.ok(resultado);

	}

	else {

		// se as senhas não conferem, significa que o usuário existe, porém a senha está errada

		return ResponseEntity.status(401).build(); // retorna o código 401 - Unauthorized

	}

	

}

else {

	// se não encontrei, retorna um código de NOT FOUND (404)

	return ResponseEntity.notFound().build();

}
}
}
