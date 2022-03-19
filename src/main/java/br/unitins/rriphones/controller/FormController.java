package br.unitins.rriphones.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.model.Usuario;
import br.unitins.rriphones.repository.UsuarioRepository;

@Named
@ViewScoped
public class FormController extends Controller<Usuario> implements Serializable {

	
	private static final long serialVersionUID = -5287069451950435141L;
	private List<Usuario> listaUsuario;
	private String nomePesquisa;
	
	public FormController() {
		super(new UsuarioRepository());
	}
	public void pesquisar() {
		UsuarioRepository repo = new UsuarioRepository();
		try {
			listaUsuario = repo.findByNome(getNomePesquisa());
		}catch(RepositoryException e) {
			e.printStackTrace();
			listaUsuario = new ArrayList<Usuario>();
			
		}
	}
	public void editar(Usuario usu) {
		setEntity(usu);
	}
	public List<Usuario> getListaUsuario() {
		if(listaUsuario == null) {
			UsuarioRepository repo = new UsuarioRepository();
			try {
			listaUsuario = repo.findByNome("");
			}catch(RepositoryException e) {
				e.printStackTrace();
				listaUsuario = new ArrayList<Usuario>();
			}
		}
		return listaUsuario;
	}
	


	
	
	public String getNomePesquisa() {
		return nomePesquisa;
	}
	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}
	@Override
	public Usuario getEntity() {
		if(entity == null) {
			entity = new Usuario();
		}
		return entity;
	}

	
	
	
	
}
