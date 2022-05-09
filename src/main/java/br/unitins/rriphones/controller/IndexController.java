package br.unitins.rriphones.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.rriphones.application.Session;
import br.unitins.rriphones.application.Util;
import br.unitins.rriphones.model.Endereco;
import br.unitins.rriphones.model.Usuario;
import br.unitins.rriphones.repository.UsuarioRepository;
@Named
@ViewScoped
public class IndexController extends Controller<Usuario> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public IndexController() {
		super(new UsuarioRepository());
		entity = (Usuario) Session.getInstance().get("UsuarioLogado");
		
		teste();
	}
	
	public void teste()
	{
		for ( Endereco e : getEntity().getListaEndereco()) {
			System.out.println(e.getCep());
		}
	}
	public void alterarUsuarioLogado() {
		salvar();
		Util.redirect("profile.xhtml");
		
	}
	@Override
	public Usuario getEntity() {
			if(entity == null)
				entity = new Usuario();
		return entity;
	}
	

}
