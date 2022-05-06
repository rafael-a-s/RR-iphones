package br.unitins.rriphones.model;

public class Chave {
	private Enum TipoChave;
	private String chaveDoPix;
	
	public Enum getTipoChave() {
		return TipoChave;
	}
	public void setTipoChave(Enum tipoChave) {
		TipoChave = tipoChave;
	}
	public String getChaveDoPix() {
		return chaveDoPix;
	}
	public void setChaveDoPix(String chaveDoPix) {
		this.chaveDoPix = chaveDoPix;
	}
	
	
	
}
