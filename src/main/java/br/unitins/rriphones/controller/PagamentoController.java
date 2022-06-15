package br.unitins.rriphones.controller;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.application.Session;
import br.unitins.rriphones.application.Util;
import br.unitins.rriphones.application.VersionException;
import br.unitins.rriphones.model.Cartao;
import br.unitins.rriphones.model.CartaoPagamento;
import br.unitins.rriphones.model.Iphone;
import br.unitins.rriphones.model.ItemVenda;
import br.unitins.rriphones.model.Parcelas;
import br.unitins.rriphones.model.PixPagamento;
import br.unitins.rriphones.model.Venda;
import br.unitins.rriphones.repository.CartaoRepository;
import br.unitins.rriphones.repository.IphoneRepository;
import br.unitins.rriphones.repository.VendaRepository;

@Named
@ViewScoped
public class PagamentoController extends Controller<Venda> implements Serializable {

	private static final long serialVersionUID = 7402682861617273870L;

	private PixPagamento pix;
	private CartaoPagamento cartao;
	private Cartao cartaoUsuario;
	private List<Parcelas> listParcelas;
	private String cvv;

	public PagamentoController() {
		super(new VendaRepository());
		entity = (Venda) Session.getInstance().get("venda");

	}
	public void teste() {
		System.out.println("cvv");
	}
	public void pagamentoComPix() {
		getEntity().setPagamento(getPix());
		getEntity().getPagamento().setDataHoraPagamento(LocalDateTime.now());
		getPix().setSituação("Pagamento recebido");
	}

	public void pagamentoComCartao() throws RepositoryException, VersionException {
		System.out.println(getCartao().getIdCartao());
		CartaoRepository repo = new CartaoRepository();
		setCartaoUsuario(repo.findById(getCartao().getIdCartao()));
		if(validaCpf(getEntity())) {
				
				System.out.println("entrou no salvar");
				getEntity().setPagamento(new CartaoPagamento());
				getCartao().setDataHoraPagamento(LocalDateTime.now());
				getCartao().setNomePagador(getCartaoUsuario().getNomeCartao());
				getCartao().setCpfPagador(getEntity().getUsuario().getCpf());
				getEntity().setPagamento(getCartao());
				//atualiza o estoque de iphone por modelo
				atualizaEstoque(getEntity().getListItens());
				//Salvando a venda no banco de dados 
				salvar();
				Util.redirect("products.xhtml");
			
		}else {
			System.out.println("cpf");
			Util.addErrorMessage("Cpf diferente do pagador.");
		}
		
		
		

	}
	
	
	public void atualizaEstoque(List<ItemVenda> list) throws RepositoryException, VersionException {
		IphoneRepository repo = new IphoneRepository();
		for(ItemVenda i : list) {
			Iphone iphone = repo.findById(i.getIphone().getId());
			if(iphone.getEstoque().getQuantidade() < i.getQuantidade()) {
				Util.addErrorMessage("Infelizmente não temos esta quantidade de "+i.getIphone().getModelo().getModeloLabel()+" em estoque !" );
				return;
			}else {
				iphone.getEstoque().setQuantidade( iphone.getEstoque().getQuantidade() - i.getQuantidade());
				repo.save(iphone);
			}
				
		}
	}
	
	
	
	public boolean validaCpf(Venda v) {
		if(v.getUsuario().getCpf().equals(getCartao().getCpfPagador()) )
			return true;
		return false;
	}
	private List<Parcelas> ParelasDivididas(Venda v) {
		List<Parcelas> list = new ArrayList<Parcelas>();
		Parcelas p = new Parcelas();
		p.setParcelas(2);
		p.setValorParcela(v.getValorTotal() / 2);
		list.add(p);
		p = new Parcelas();
		p.setParcelas(3);
		p.setValorParcela(v.getValorTotal() / 3);
		list.add(p);
		return list;
	}

	public PixPagamento getPix() {
		pix = new PixPagamento();
		return pix;
	}

	public void setPix(PixPagamento pix) {
		this.pix = pix;
	}

	public CartaoPagamento getCartao() {
		if(cartao == null)
			cartao = new CartaoPagamento();
		return cartao;
	}

	public void setCartao(CartaoPagamento cartao) {
		this.cartao = cartao;
	}

	@Override
	public Venda getEntity() {
		if (entity == null)
			entity = new Venda();
		return entity;
	}

	public List<Parcelas> getListParcelas() {
		if(listParcelas == null)
			listParcelas = ParelasDivididas(getEntity());
		return listParcelas;
	}

	public void setListParcelas(List<Parcelas> listParcelas) {
		this.listParcelas = listParcelas;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public Cartao getCartaoUsuario() {
		if(cartaoUsuario == null)
			cartaoUsuario = new Cartao();
		return cartaoUsuario;
	}

	public void setCartaoUsuario(Cartao cartaoUsuario) {
		this.cartaoUsuario = cartaoUsuario;
	}

	

}
