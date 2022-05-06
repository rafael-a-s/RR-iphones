package br.unitins.rriphones.model;

public enum TipoChave {

	CPFCNPJ(1,"CPF/CNPJ"),
	CELULAR(2,"CELULAR"), 
	EMAIL(3,"EMAIL");
	
	TipoChave( int id, String label){
		this.id = id;
		this.nomeChave = label;
	}
	
	private int id;
	private String nomeChave;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeChave() {
		return nomeChave;
	}
	public void setNomeChave(String nomeChave) {
		this.nomeChave = nomeChave;
	}
	
	
}
