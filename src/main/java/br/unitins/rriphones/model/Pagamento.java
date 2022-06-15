package br.unitins.rriphones.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento extends DefaultEntity {
	@Column
	private LocalDateTime dataHoraPagamento;

	public LocalDateTime getDataHoraPagamento() {
		return dataHoraPagamento;
	}

	public void setDataHoraPagamento(LocalDateTime dataHoraPagamento) {
		this.dataHoraPagamento = dataHoraPagamento;
	}

	
	
	
	
}
