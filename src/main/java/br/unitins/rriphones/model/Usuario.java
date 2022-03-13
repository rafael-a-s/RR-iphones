package br.unitins.rriphones.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Usuario extends DefaultEntity implements Serializable {

	private static final long serialVersionUID = 264552829892031483L;
	@Column(length = 100)
	private String nome;
	@Column(length = 11)
	private String cpf;
	@Column(length = 3)
	private Integer idade;
	@Column(length = 24)
	private String senha;
	@Column(length = 30)
	private String apelido;
	
//	@Column
//	private Date dataNascimento;
	
//	private Endereco endereco;
//	private Genero genero;
//	private Telefone telefone;
	
	//construtor  de usuario
	public Usuario() {
		
	}
	
	//Metodos get e set
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
//	public Date getDataNascimento() {
//		return dataNascimento;
//	}
//	public void setDataNascimento(Date dataNascimento) {
//		this.dataNascimento = dataNascimento;
//	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

//	public Endereco getEndereco() {
//		return endereco;
//	}
//
//	public void setEndereco(Endereco endereco) {
//		this.endereco = endereco;
//	}
//
//	public Genero getGenero() {
//		return genero;
//	}
//
//	public void setGenero(Genero genero) {
//		this.genero = genero;
//	}
//
//	public Telefone getTelefone() {
//		return telefone;
//	}
//
//	public void setTelefone(Telefone telefone) {
//		this.telefone = telefone;
//	}
	
	
	
	

}
