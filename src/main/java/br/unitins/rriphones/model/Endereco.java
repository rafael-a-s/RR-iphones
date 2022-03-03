package br.unitins.rriphones.model;

public class Endereco {
	//variaveis
	private Integer id ;
	private String cep;
	private String end; // A variavel ficou abreviada por causa do nome da class
	private Integer numero;
	private String complemento;
	
	public Endereco() { // construtor de Endereço
		
	}
	
	//metodos get e set
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
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
