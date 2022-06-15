package br.unitins.rriphones.model;

import javax.persistence.Entity;

@Entity
public class CartaoPagamento extends Pagamento{
	private Integer idCartao;
	private Integer numeroParcelas;
	private String cpfPagador;
	private String nomePagador;
	
	public Integer getIdCartao() {
		return idCartao;
	}
	public void setIdCartao(Integer idCartao) {
		this.idCartao = idCartao;
	}
	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}
	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
	public String getCpfPagador() {
		return cpfPagador;
	}
	public void setCpfPagador(String cpfPagador) {
		this.cpfPagador = cpfPagador;
	}
	public String getNomePagador() {
		return nomePagador;
	}
	public void setNomePagador(String nomePagador) {
		this.nomePagador = nomePagador;
	}
	
	
	
	
	
}
