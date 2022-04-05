package br.unitins.rriphones.controller;

import java.io.Serializable;
import java.sql.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.application.Session;
import br.unitins.rriphones.application.Util;
import br.unitins.rriphones.model.Usuario;
import br.unitins.rriphones.repository.UsuarioRepository;
@Named
@ViewScoped
public class InitialregisterController extends Controller<Usuario> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String comparePassword;
	
	public boolean validationPassword() throws RepositoryException {
		UsuarioRepository u = new UsuarioRepository();
		if(entity.getSenha().equals(comparePassword)){
			if(u.findByEmail(getEntity().getEmail()) == null) {
				entity.setSenha(Util.hash(getEntity())); //Gereando hash da senha
				salvar();
				
				Util.redirect("login.xhtml");
			}else {
				Util.addErrorMessage("Email já pertence a um usuario!");
			}
			return true;
		}
		else {
			Util.addErrorMessage("Digite a mesma senha!");
		}
		return false;
	}

	public InitialregisterController() {
		super(new UsuarioRepository());
		
	}
	
	@Override
	public Usuario getEntity() {
		if(entity == null) {
			entity = new Usuario();
		}
		return entity;
	}

	public String getComparePassword() {
		return comparePassword;
	}

	public void setComparePassword(String comparePassword) {
		this.comparePassword = comparePassword;
	}

	

}
