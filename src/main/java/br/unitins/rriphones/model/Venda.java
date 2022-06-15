package br.unitins.rriphones.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Venda extends DefaultEntity {
	
	private Double valorTotal;
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
	@OneToOne(cascade = CascadeType.ALL)
	private Pagamento pagamento;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemVenda> listItens;
	
	
	
	public Pagamento getPagamento() {
	
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Usuario getUsuario() {
		if(usuario == null)
			usuario = new Usuario();
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ItemVenda> getListItens() {
		return listItens;
	}

	public void setListItens(List<ItemVenda> listItens) {
		this.listItens = listItens;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
