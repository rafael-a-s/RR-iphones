package br.unitins.rriphones.model;

public enum Funcao {
	CREDITO(1,"Crédito"),
	DEBITO(2,"Debito");
	
	Funcao(Integer id, String label){
		this.id = id;
		this.funcao = label;
	}
	
	private Integer id;
	private String funcao;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	
}
