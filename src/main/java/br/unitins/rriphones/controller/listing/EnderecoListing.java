package br.unitins.rriphones.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.application.Util;
import br.unitins.rriphones.model.Endereco;
import br.unitins.rriphones.repository.EnderecoRepository;
import br.unitins.rriphones.repository.UsuarioRepository;

@Named
@ViewScoped
public class EnderecoListing extends Listing<Endereco> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String filtro;
	public EnderecoListing() {
		super("EnderecoListing", new EnderecoRepository());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pesquisar() {
		EnderecoRepository repo = new EnderecoRepository();
		try {
			setList(repo.findByCep(getFiltro()));
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


