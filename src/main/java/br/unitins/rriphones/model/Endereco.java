package br.unitins.rriphones.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Endereco extends DefaultEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//variaveis
	@Column(length = 100)
	private String cep;
	@Column(length = 100)
	private String endereco; // A variavel ficou abreviada por causa do nome da class
	@Column(length = 100)
	private Integer numero;
	@Column(length = 100)
	private String complemento;
	
	public Endereco() { // construtor de Endereço
		
	}
	
	//construtor para testes no packager de testes
	public Endereco(String cep, String endereco, Integer numero, String complemento) {
		super();
		this.cep = cep;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
	}


	//metodos get e set
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String end) {
		this.endereco = end;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
}
