package br.unitins.rriphones.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Estoque extends DefaultEntity implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Column(length = 100)
	private Integer quantidade;
	@Column
	private Date dataEntrada;
	private Boolean inStok;//se possui estoque do produto
	
	public Estoque() {
		
	}
	
	public Estoque(Integer quantidade, Date dataEntrada, Boolean inStok) {
		super();
		this.quantidade = quantidade;
		this.dataEntrada = dataEntrada;
		this.inStok = inStok;
	}

	@Override
	public String toString() {
		return "Estoque [quantidade=" + quantidade + ", dataEntrada=" + dataEntrada + ", inStok=" + inStok + "]";
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Boolean getInStok() {
		return inStok;
	}
	public void setInStok(Boolean inStok) {
		this.inStok = inStok;
	}
	
	
}
