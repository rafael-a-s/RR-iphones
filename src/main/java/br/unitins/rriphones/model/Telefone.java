package br.unitins.rriphones.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Telefone extends DefaultEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(length = 100)
	private String codigoArea;
	@Column(length = 100)
	private String numero;
	
	
	//construtor de telefone
	public Telefone() {
		
	}

	//metodos get e set
	
	public String getCodigoArea() {
		return codigoArea;
	}


	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
}
