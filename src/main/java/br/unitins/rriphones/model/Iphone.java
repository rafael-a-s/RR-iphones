package br.unitins.rriphones.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Iphone extends DefaultEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Column(length = 10)
	private Double preco;
	@Column(length = 500)
	private String Descricao;
	@ManyToOne(cascade = CascadeType.ALL)
	private Modelo modelo;
	@Column(length = 20)
	private String cor;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Estoque estoque;
	
	public Iphone() {
		
	}
	
	@Override
	public String toString() {
		return "Iphone [preco=" + preco + ", Descricao=" + Descricao + ", modelo=" + modelo + ", cor=" + cor
				+ ", estoque=" + estoque + "]";
	}
	
	public Iphone(Double preco, String descricao, Modelo modelo, String cor, Estoque estoque) {
		super();
		this.preco = preco;
		Descricao = descricao;
		this.modelo = modelo;
		this.cor = cor;
		this.estoque = estoque;
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
