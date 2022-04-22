package br.unitins.rriphones.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.controller.listing.UsuarioListing;
import br.unitins.rriphones.model.Usuario;
import br.unitins.rriphones.repository.UsuarioRepository;

@Named
@ViewScoped
public class ManagerUsuarioController extends Controller<Usuario> implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Usuario> list;
	private String nomePesquisa;
	
	UsuarioRepository u = new UsuarioRepository();

	public ManagerUsuarioController() {
		super(new UsuarioRepository());

	}
	public void incluir() throws RepositoryException {
		
		
		salvar();
	}
	public void abrirUsuarioListing() {
		UsuarioListing listing = new UsuarioListing();
		listing.open();
	}
	public void obterUsuariListing(SelectEvent<Usuario> event) {
		setEntity(event.getObject());
	}
	
	
	
	
	
	
	
	
	
	@Override
	public Usuario getEntity() {
		if (entity == null)
			entity = new Usuario();
		return entity;
	}

	public void pesquisar() throws RepositoryException {
		setList(u.findByName(getNomePesquisa()));
	}

	public List<Usuario> getList() throws RepositoryException {
		if (list == null)
			list = new ArrayList<Usuario>();
		return list;
	}

	public void setList(List<Usuario> list) {
		this.list = list;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}

}
