package br.unitins.rriphones.model;

import javax.persistence.Entity;


public enum Genero {

	
	FEMININO(1, "Feminino"),
	MASCULINO(2, "Masculino");
		
	private Integer id;
	private String label;
	
	Genero( Integer id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
