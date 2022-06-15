package br.unitins.rriphones.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.rriphones.application.Session;
import br.unitins.rriphones.application.Util;
import br.unitins.rriphones.model.Iphone;
import br.unitins.rriphones.model.ItemVenda;
import br.unitins.rriphones.model.Usuario;
import br.unitins.rriphones.model.Venda;
import br.unitins.rriphones.repository.IphoneRepository;
@Named
@ViewScoped
public class CarrinhoController extends Controller<Iphone> implements Serializable{

	private static final long serialVersionUID = 1545865034740824521L;
	private List<ItemVenda> listItensCarrinho;
	private Double valorTotal;
	
	public CarrinhoController() {
		super(new IphoneRepository());
	}
	
	public void irParaPagamento() {
		System.out.println("Entrou");
		Venda venda = new Venda();
		Usuario usuario = (Usuario) Session.getInstance().get("UsuarioLogado");
		if(usuario == null) {
			Util.addInfoMessage("Faça login por favor !");
			Util.redirect("/login/login.xhtml");
			return;
		}
		if(aprovarUsuarioParaCompra(usuario)) {
			venda.setUsuario(usuario);
			venda.setListItens(getListItensCarrinho());
			venda.setValorTotal(getValorTotal());
			Session.getInstance().set("venda", venda);
			Util.redirect("pagamento.xhtml");
		}
		
	}
	public boolean aprovarUsuarioParaCompra(Usuario usu) {
		if(usu.getListaEndereco() == null && usu.getListaCartao() == null) {
			Util.addInfoMessage("Estão faltando dados muitos importante, atualize os Por Favor !");
			Util.redirect("profile.xhtml");
		}else
			return true;
			
		
		return false;
	}
	public void remover(ItemVenda item) {
		Integer aux = (Integer) Session.getInstance().get("contadorCarrinho");
		Integer index = getListItensCarrinho().indexOf(item);
		
			
		if(getListItensCarrinho().get(index).getQuantidade() > 1) {
			getListItensCarrinho().get(index).setQuantidade( getListItensCarrinho().get(index).getQuantidade() - 1 );
			getListItensCarrinho().get(index).setValor(getListItensCarrinho().get(index).getValor() - getListItensCarrinho().get(index)
					.getIphone().getPreco());
			
			setValorTotal(pegaValorTotal(getListItensCarrinho()));
			
		}else {
			
			getListItensCarrinho().remove(item);
			
		}
		aux = aux -1;
		Session.getInstance().set("contadorCarrinho", aux);
		
	}
	
	private Double pegaValorTotal(List<ItemVenda> list) {
		Double valor = 0.0;
		for(ItemVenda item: getListItensCarrinho()) {
			valor = valor + item.getValor();
		}
		
		return valor;
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

	public Double getValorTotal() {
		if(valorTotal == null)
			valorTotal = pegaValorTotal(getListItensCarrinho());
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
 


	
	
	
}
