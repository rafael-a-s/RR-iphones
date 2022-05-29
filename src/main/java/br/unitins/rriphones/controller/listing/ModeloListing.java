package br.unitins.rriphones.controller.listing;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.model.Modelo;
import br.unitins.rriphones.repository.ModeloRepository;
@Named
@ViewScoped
public class ModeloListing extends Listing<Modelo>{
	
	private static final long serialVersionUID = 1L;
	private String nomePesquisa;
	public ModeloListing() {
		super("modeloListing", new ModeloRepository());
	}

	@Override
	public void pesquisar() {
		ModeloRepository repo = new ModeloRepository();
		
		try {
			setList(repo.findByModelo(getNomePesquisa()));
			
		} catch (RepositoryException e) {
			System.out.println("Erro na consulta");
			e.printStackTrace();
		}
		
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}
	
	
	
}
