package br.unitins.rriphones.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.controller.listing.EnderecoListing;
import br.unitins.rriphones.model.Endereco;
import br.unitins.rriphones.model.Usuario;
import br.unitins.rriphones.repository.EnderecoRepository;

@Named
@ViewScoped
public class ManagerEnderecoController extends Controller<Endereco> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Endereco> list;
	private String nomePesquisa;
	
	EnderecoRepository e = new EnderecoRepository();

	public ManagerEnderecoController() {
		super(new EnderecoRepository());

	}

	
	public void abrirEnderecoListing() { //abir a lista de usuario
		EnderecoListing listing = new EnderecoListing();
		listing.open();
	}
	public void obterEnderecoListing(SelectEvent<Endereco> event) {
		setEntity(event.getObject());
	}

	@Override
	public Endereco getEntity() {
		if (entity == null)
			entity = new Endereco();
		return entity;
	}

	public void pesquisar() throws RepositoryException {
		setList(e.findByCep(getNomePesquisa()));
	}

	public List<Endereco> getList() throws RepositoryException {
		if (list == null)
			list = new ArrayList<Endereco>();
		return list;
	}

	public void setList(List<Endereco> list) {
		this.list = list;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}
}
