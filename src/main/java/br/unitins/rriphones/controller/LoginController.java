package br.unitins.rriphones.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

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

	public LoginController() {
		super(new UsuarioRepository());
		
	}

	@Override
	public Usuario getEntity() {
		if(entity == null)
			entity = new Usuario();
		return entity;
	}

}
