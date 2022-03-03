package br.unitins.rriphones.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.rriphones.dao.UsuarioDAO;
import br.unitins.rriphones.model.Usuario;

@Named
@ViewScoped
public class FormController implements Serializable {

	
	private static final long serialVersionUID = -5287069451950435141L;
	private Usuario usuario;
	
	public void  salvar() {
		UsuarioDAO dao = new UsuarioDAO();
		usuario.setId(1);
		dao.salvar(getUsuario());
	}
	
	public Usuario getUsuario() {
		if(usuario == null)
			usuario = new Usuario();
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
