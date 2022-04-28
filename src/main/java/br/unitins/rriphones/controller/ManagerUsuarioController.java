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
	public void salvarUsuario() throws RepositoryException {
		UsuarioRepository u = new UsuarioRepository();
		if(u.findByEmail(getEntity().getEmail()) == null) { //se o email digitado não existir ele salva o obj
			salvar();
		}
	}
	public void alterarUsuario() throws RepositoryException {
		UsuarioRepository u = new UsuarioRepository();
		Usuario usuAux = u.findByEmail(getEntity().getEmail());
		if(usuAux == null) {// Se o email nao exite 
			salvar();
		}else if( usuAux.getId().equals(getEntity().getId())) { //se o email for o mesmo, porem o se o id for o mesmo quer dizer que o usuario é o mesmo
			salvar();
		}
	}
	
	public void abrirUsuarioListing() { //abir a lista de usuario
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
