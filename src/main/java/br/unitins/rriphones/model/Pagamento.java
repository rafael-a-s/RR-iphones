package br.unitins.rriphones.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento extends DefaultEntity {
	@Column
	private Date dataHoraPagamento;
	
	

	public Date getDataHoraPagamento() {
		return dataHoraPagamento;
	}

	public void setDataHoraPagamento(Date dataHoraPagamento) {
		this.dataHoraPagamento = dataHoraPagamento;
	}
	
	
	
}
