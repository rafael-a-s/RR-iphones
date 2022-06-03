package br.unitins.rriphones.model;

import java.util.Objects;

import javax.persistence.Entity;

@Entity
public class ItemVenda extends DefaultEntity{
	
	
	private Double valor;
	private Integer quantidade;
	private Iphone iphone;
	
	
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Iphone getIphone() {
		return iphone;
	}
	public void setIphone(Iphone iphone) {
		this.iphone = iphone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(iphone);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemVenda other = (ItemVenda) obj;
		return Objects.equals(iphone, other.iphone);
	}
	
	
	
	
	
}
