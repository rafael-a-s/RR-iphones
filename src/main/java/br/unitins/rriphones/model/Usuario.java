package br.unitins.rriphones.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Usuario extends DefaultEntity implements Serializable {

	private static final long serialVersionUID = 264552829892031483L;
	@Column(length = 100)
	private String nome;
	@Column(length = 60)
	private String email;
	@Column(length = 65)
	private String senha;
	@Column(length = 11)
	private String cpf;
	@Column(nullable = true)
	private Date dataNascimento;
	
	
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


}
