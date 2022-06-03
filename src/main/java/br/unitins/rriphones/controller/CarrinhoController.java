package br.unitins.rriphones.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.rriphones.application.Session;
import br.unitins.rriphones.model.Iphone;
import br.unitins.rriphones.model.ItemVenda;
import br.unitins.rriphones.repository.IphoneRepository;
@Named
@ViewScoped
public class CarrinhoController extends Controller<Iphone> implements Serializable{

	private static final long serialVersionUID = 1545865034740824521L;
	private List<ItemVenda> listItensCarrinho;

	
	public CarrinhoController() {
		super(new IphoneRepository());
	}
	
	public void remover(ItemVenda item) {
		Integer aux = (Integer) Session.getInstance().get("contadorCarrinho");
		Integer index = getListItensCarrinho().indexOf(item);
		
			
		if(getListItensCarrinho().get(index).getQuantidade() > 1) {
			getListItensCarrinho().get(index).setQuantidade( getListItensCarrinho().get(index).getQuantidade() - 1 );
			getListItensCarrinho().get(index).setValor(getListItensCarrinho().get(index).getValor() - getListItensCarrinho().get(index)
					.getIphone().getPreco());
			aux = aux -1;
		}else {
			if(aux == 1)
				aux = 0;
			getListItensCarrinho().remove(item);
			
		}
		
		Session.getInstance().set("contadorCarrinho", aux);
		
	}
	@Override
	public Iphone getEntity() {
		if(entity == null)
			entity = new Iphone();
		return entity;
	}

	public List<ItemVenda> getListItensCarrinho() {
		listItensCarrinho = (List<ItemVenda>) Session.getInstance().get("itensNaSessao");

		if(listItensCarrinho == null)
			listItensCarrinho = new ArrayList<ItemVenda>();
		return listItensCarrinho;
	}

	public void setListItensCarrinho(List<ItemVenda> listItensCarrinho) {
		this.listItensCarrinho = listItensCarrinho;
	}



	
	
	
}
