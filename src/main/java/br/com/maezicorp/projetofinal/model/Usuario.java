package br.com.maezicorp.projetofinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity                        //indica que usuario é uma entidade armazenavel no banco
@Table(name="tbl_usuario")     //sou associar esta clase a tabela de nome "tbl_usuario"
public class Usuario {

	@Id                                                      //atributo e pk
	@GeneratedValue(strategy=GenerationType.IDENTITY)         //auto increment
	@Column(name="id")                                       //nome da coluna e ID
	private int    id;
	
	@Column(name="nome",length=100)  //coluna varchar(100)
	private String nome;
	
	@Column(name="email",length=100, unique=true)  //coluna varchar(100)	
	private String email;
	
	@Column(name="senha",length=20)  //coluna varchar(100)
	private String senha;
	
	@Column(name="racf",length=7, unique=true)  //coluna varchar(100)
	private String racf;
	
	@Column(name="funcional",unique=true)  //coluna varchar(100)
	private int    funcional;
	
	@Column(name="link_foto", length=255)
	private String linkFoto;
	

		public String getLinkFoto() {
		return linkFoto;
	}
	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}

	@ManyToOne
	@JsonIgnoreProperties("listaUsers") // ignoro o atributo "listaUsers" do departamento
	
	private Departamento depto;
	
	public String getRacf() {
		return racf;
	}
	public void setRacf(String racf) {
		this.racf = racf;
	}
	public Departamento getDepto() {
		return depto;
	}
	public void setDepto(Departamento depto) {
		this.depto = depto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getFuncional() {
		return funcional;
	}
	public void setFuncional(int funcional) {
		this.funcional = funcional;
	}
	
	@Override

	public String toString() {

		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", racf=" + racf

				+ ", funcional=" + funcional + "]";

	}
	public Object getRackf() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
