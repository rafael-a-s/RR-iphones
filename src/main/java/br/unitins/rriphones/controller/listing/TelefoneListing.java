package br.unitins.rriphones.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.application.Util;
import br.unitins.rriphones.model.Telefone;
import br.unitins.rriphones.repository.TelefoneRepository;
@Named
@ViewScoped
public class TelefoneListing extends Listing<Telefone>{
	
	
	private static final long serialVersionUID = 1L;
	private String filtro;
	public TelefoneListing () {
		super("TelefoneListing", new TelefoneRepository());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pesquisar() {
		TelefoneRepository repo = new TelefoneRepository();
		try {
			setList(repo.findByNumero(getFiltro()));
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
