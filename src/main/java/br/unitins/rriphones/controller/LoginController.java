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
	private Usuario usu;
	
	public LoginController() throws RepositoryException {
		super(new UsuarioRepository());
	}
	public void validationLogin() throws RepositoryException {
		
		UsuarioRepository u = new UsuarioRepository();
		setEntity( u.findByEmail(getUsu().getEmail()));
		
		//variavel que recebe o hash da senha 
		String senhaAux = Util.hash(getUsu());
		if(getEntity() != null & getEntity().getEmail().equals(getUsu().getEmail()) & getEntity().getSenha().equals(senhaAux)) {
			Util.addInfoMessage("Secesso ao efetuar login");
			Session.getInstance().set("UsuarioLogado", getEntity());
			Util.redirect("../products.xhtml");
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
	public Usuario getUsu() {
		if(usu == null)
			usu = new Usuario();
		return usu;
	}
	public void setUsu(Usuario usu) {
		this.usu = usu;
	}


	
	

}
