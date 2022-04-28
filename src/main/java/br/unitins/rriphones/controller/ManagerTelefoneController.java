package br.unitins.rriphones.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.controller.listing.TelefoneListing;
import br.unitins.rriphones.model.Endereco;
import br.unitins.rriphones.model.Telefone;
import br.unitins.rriphones.model.Usuario;
import br.unitins.rriphones.repository.TelefoneRepository;
@Named
@ViewScoped
public class ManagerTelefoneController extends Controller<Telefone> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Telefone> list;
	private String nomePesquisa;
	
	TelefoneRepository t = new TelefoneRepository();

	public ManagerTelefoneController() {
		super(new TelefoneRepository());

	}

	
	public void abrirTelefoneListing() { //abir a lista de usuario
		TelefoneListing listing = new TelefoneListing();
		listing.open();
	}
	public void obterTelefoneListing(SelectEvent<Telefone> event) {
		setEntity(event.getObject());
	}

	@Override
	public Telefone getEntity() {
		if (entity == null)
			entity = new Telefone();
		return entity;
	}

	public void pesquisar() throws RepositoryException {
		setList(t.findByNumero(getNomePesquisa()));
	}

	public List<Telefone> getList() throws RepositoryException {
		if (list == null)
			list = new ArrayList<Telefone>();
		return list;
	}

	public void setList(List<Telefone> list) {
		this.list = list;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}
}
