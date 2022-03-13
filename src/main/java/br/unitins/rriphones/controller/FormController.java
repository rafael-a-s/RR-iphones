package br.unitins.rriphones.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.rriphones.dao.UsuarioDAO;
import br.unitins.rriphones.model.DefaultEntity;
import br.unitins.rriphones.model.Usuario;
import br.unitins.rriphones.repository.UsuarioRepository;

@Named
@ViewScoped
public class FormController extends Controller<Usuario> implements Serializable {

	
	private static final long serialVersionUID = -5287069451950435141L;
	
	
	public FormController() {
		super(new UsuarioRepository());
	}
	
	@Override
	public Usuario getEntity() {
		if(entity == null) {
			entity = new Usuario();
		}
		return entity;
	}

	
	
	
	
}
