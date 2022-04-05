package br.unitins.rriphones.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.application.Session;
import br.unitins.rriphones.application.Util;
import br.unitins.rriphones.model.Usuario;
import br.unitins.rriphones.repository.Repository;
import br.unitins.rriphones.repository.UsuarioRepository;
@Named
@ViewScoped
public class LoginController extends Controller<Usuario> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String senha;
	
	public LoginController() throws RepositoryException {
		super(new UsuarioRepository());
	}
	public void validationLogin() throws RepositoryException {
		
		UsuarioRepository u = new UsuarioRepository();
		setEntity( u.findByEmail(getEmail()));
		
		if(getEntity() != null & getEntity().getEmail().equals(getEmail()) & getEntity().getSenha().equals(getSenha())) {
			Util.addInfoMessage("Secesso ao efetuar login");
			Session.getInstance().set("UsuarioLogado", getEntity());
			Util.redirect("index.xhtml");
		}else {
			Util.addErrorMessage("Email ou senhas incorretos");
		}
	}

	@Override
	public Usuario getEntity() {
		if(entity == null)
			entity = new Usuario();
		return entity;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
