package br.unitins.rriphones.model;

public enum Cor {
	
	VERMELHO(1,"Vermelho"),
	AZUL(2,"Azul"),
	AMARELO(1,"Amarelo"),
	PRETO(1,"Preto"),
	CINZA(1,"Cinza"),
	ROSE(1,"Rose");
	
	Cor(Integer id, String nomeCor){
		this.id = id;
		this.nomeCor = nomeCor;
	}
	
	private Integer id;
	private String nomeCor;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeCor() {
		return nomeCor;
	}
	public void setNomeCor(String nomeCor) {
		this.nomeCor = nomeCor;
	}
	
	
	
}
