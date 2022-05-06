package br.unitins.rriphones.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

public class Pix extends Pagamento{
	
	private List<Chave> listaDePix;

	public List<Chave> getListaDePix() {
		if(listaDePix == null)
			listaDePix = new ArrayList<Chave>();
		return listaDePix;
	}

	public void setListaDePix(List<Chave> listaDePix) {
		this.listaDePix = listaDePix;
	}
	
	
}
