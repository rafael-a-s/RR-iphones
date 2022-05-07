package br.unitins.rriphones.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Telefone extends DefaultEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Column(length = 100)
	private String codigoArea;
	@Column(length = 100)
	private String numero;
	
	
	//construtor de telefone
	public Telefone() {
		
	}
	
	//contrutor para testes no packager de testes
	public Telefone(String codigoArea, String numero) {
		super();
		this.codigoArea = codigoArea;
		this.numero = numero;
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

	@Override
	public int hashCode() {
		return Objects.hash(codigoArea, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return Objects.equals(codigoArea, other.codigoArea) && Objects.equals(numero, other.numero);
	}
	
	
	
}
