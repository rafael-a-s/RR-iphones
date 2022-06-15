package br.unitins.rriphones.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
@Entity
public class PixPagamento extends Pagamento{
	
	private String situação;
	

	public String getSituação() {
		return situação;
	}

	public void setSituação(String situação) {
		this.situação = situação;
	}
	
	
	
}
