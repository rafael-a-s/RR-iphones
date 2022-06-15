package br.unitins.rriphones.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cartao extends DefaultEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nomeCartao;
	
	private String numeroCartao;
	
	private String cvv;
	
	private String dataValidade;
	@ManyToOne
	@JoinColumn(name="usuario_fk", nullable = false)
	private Usuario usuario;
	
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




	public Usuario getUsuario() {
		return usuario;
	}




	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}




	@Override
	public int hashCode() {
		return Objects.hash(cvv, dataValidade, funcao, nomeCartao, numeroCartao);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartao other = (Cartao) obj;
		return Objects.equals(cvv, other.cvv) && Objects.equals(dataValidade, other.dataValidade)
				&& funcao == other.funcao && Objects.equals(nomeCartao, other.nomeCartao)
				&& Objects.equals(numeroCartao, other.numeroCartao);
	}
	
	
	
}
