package br.unitins.rriphones.model;

import javax.persistence.Entity;

@Entity
public class Cartao extends DefaultEntity {
	
	private String nomeCartao;
	
	private String numeroCartao;
	
	private String cvv;
	
	private String dataValidade;
	
	
	private Funcao funcao;
	
	
	public Cartao() {
		
	}
	
	
	

	public Cartao(String nomeCartao, String numeroCartao, String cvv, String dataValidade, Funcao funcao) {
		super();
		this.nomeCartao = nomeCartao;
		this.numeroCartao = numeroCartao;
		this.cvv = cvv;
		this.dataValidade = dataValidade;
		this.funcao = funcao;
	}




	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}


	public String getNomeCartao() {
		return nomeCartao;
	}


	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}


	public Funcao getFuncao() {
		return funcao;
	}


	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	
	
	
}
