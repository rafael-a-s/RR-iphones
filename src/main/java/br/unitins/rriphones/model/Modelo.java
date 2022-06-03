package br.unitins.rriphones.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Modelo extends DefaultEntity implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Column(length = 20)
	private String modeloLabel;
	
	public Modelo() {
		
	}
	public Modelo(String modeloLabel) {
		super();
		this.modeloLabel = modeloLabel;
	}

	@Override
	public String toString() {
		return "Modelo [modeloLabel=" + modeloLabel + "]";
	}

	public String getModeloLabel() {
		return modeloLabel;
	}

	public void setModeloLabel(String modeloLabel) {
		this.modeloLabel = modeloLabel;
	}
	
	
	
}
