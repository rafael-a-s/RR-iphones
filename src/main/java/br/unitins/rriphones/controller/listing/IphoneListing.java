package br.unitins.rriphones.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.application.Util;
import br.unitins.rriphones.model.Iphone;
import br.unitins.rriphones.repository.IphoneRepository;
import br.unitins.rriphones.repository.TelefoneRepository;
@Named
@ViewScoped
public class IphoneListing extends Listing<Iphone>{
	
	
	private static final long serialVersionUID = 1L;
	private String filtro;
	public IphoneListing () {
		super("iphoneListing", new IphoneRepository());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pesquisar() {
		IphoneRepository repo = new IphoneRepository();
		setList(repo.findByModelo(getFiltro()));
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
}
