package br.unitins.rriphones.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Iphone extends DefaultEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Column(length = 10)
	private Double preco;
	@Column(length = 500)
	private String Descricao;
	@ManyToOne
	private Modelo modelo;
	@Column(length = 20)
	private String cor;
	@OneToOne
	private Estoque estoque;
	
	public Iphone() {
		
	}
	
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public Modelo getModelo() {
		if(modelo == null)
			modelo = new Modelo();
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public Estoque getEstoque() {
		if(estoque == null)
			estoque = new Estoque();
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	
	
	
}
