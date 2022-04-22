package br.unitins.rriphones.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.application.Util;
import br.unitins.rriphones.model.Usuario;
import br.unitins.rriphones.repository.UsuarioRepository;
@Named
@ViewScoped
public class UsuarioListing extends Listing<Usuario> {


	private static final long serialVersionUID = 1L;
	private String filtro;
	public UsuarioListing() {
		super("usuarioListing", new UsuarioRepository());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pesquisar() {
		UsuarioRepository repo = new UsuarioRepository();
		try {
			setList(repo.findByName(getFiltro()));
		} catch (RepositoryException e) {
			Util.addErrorMessage("Erro na consulta.");
			e.printStackTrace();
		}
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
