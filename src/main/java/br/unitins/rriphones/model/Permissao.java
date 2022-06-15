package br.unitins.rriphones.model;



public enum Permissao {
	ADM(0, "Administrador"),
	CLIENTE(1,"Cliente");
	
	Permissao(Integer id, String label){
		this.id = id;
		this.label = label;
	}
	
	
	private Integer id;
	private String label;
	
	public static Permissao valueOf(int id) {
		for (Permissao per : Permissao.values()) {
			if (per.getId() == id)
				return per;
		}
		return null;
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
