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
public class ProductsController extends Controller<Iphone> implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Iphone> listIphone;

	// contador para contar a quantidade de intens que estão no carrinho
	private Integer contador;

	public ProductsController() {
		super(new IphoneRepository());
	}

	// Metodo para add produto ao carrinho
	public void adicionarAoCarrinho(Iphone iphone) {
		incrementador();
		@SuppressWarnings("unchecked")
		List<ItemVenda> listItemVenda =  (List<ItemVenda>) Session.getInstance().get("itensNaSessao");
	
		if (listItemVenda == null)
			listItemVenda = new ArrayList<ItemVenda>();

		ItemVenda item = new ItemVenda();
		item.setIphone(iphone);
		
		item.setQuantidade(1);
		item.setValor(iphone.getPreco());
		// caso o item ja exista ou seja
		// ja esteja no carrinho, devera entrar nesse if
		// existe a implementação do equals na classe ItemVenda
		if (listItemVenda.contains(item)) {
			Integer aux = pegaPosicaoLista(listItemVenda, item);
			listItemVenda.get(pegaPosicaoLista(listItemVenda, item))
					.setValor(listItemVenda.get(pegaPosicaoLista(listItemVenda, item)).getValor() + item.getValor());
			listItemVenda.get(aux).setQuantidade(listItemVenda.get(aux).getQuantidade() + item.getQuantidade());

		} else {
			listItemVenda.add(item);
		}

		Session.getInstance().set("itensNaSessao", listItemVenda);
		Session.getInstance().set("contadorCarrinho", getContador());
	}

	// metodo que retorna a posicao de um item da lista
	public int pegaPosicaoLista(List<ItemVenda> list, ItemVenda item) {
		return list.indexOf(item);
	}

	public void incrementador() {
		// ao entrar no metodo o contador de intens no carrinho e incrementado
		if (getContador() == null) {
			setContador(1);
			return;
		}
		setContador(getContador() + 1);
	}

	@Override
	public Iphone getEntity() {
		if (entity == null)
			entity = new Iphone();
		return entity;
	}

	public boolean inStok(Integer id) {
		for (Iphone i : listIphone) {
			if (i.getId() == id) {// entra no laço
				// Agora vou verificar se ha estoque
				if (i.getEstoque().getQuantidade() > 0)
					return true;
				else
					return false;
			}
		}
		return false;
	}

	public List<Iphone> getListIphone() {
		if (listIphone == null) {
			IphoneRepository repo = new IphoneRepository();
			listIphone = repo.obterTodos();

			if (listIphone == null)
				listIphone = new ArrayList<Iphone>();
		}
		return listIphone;
	}

	public void setListIphone(List<Iphone> listIphone) {
		this.listIphone = listIphone;
	}

	public Integer getContador() {
		if(contador == null)
			contador = (Integer) Session.getInstance().get("contadorCarrinho");
		if(contador == null)
			contador = 0;
		return contador;
	}

	public void setContador(Integer contador) {
		this.contador = contador;
	}

}
