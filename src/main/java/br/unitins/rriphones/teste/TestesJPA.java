package br.unitins.rriphones.teste;

import java.util.Date;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.application.VersionException;
import br.unitins.rriphones.model.Cor;
import br.unitins.rriphones.model.Estoque;
import br.unitins.rriphones.model.Iphone;
import br.unitins.rriphones.model.Modelo;
import br.unitins.rriphones.repository.IphoneRepository;

public class TestesJPA {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws RepositoryException {
		
		
		
		
		Date data = new Date();
		Iphone ip = new Iphone(200.00, "otimo", new Modelo("Iphone Xr"), Cor.AZUL.getNomeCor(), new Estoque(10,data, true ));
		
		IphoneRepository repo = new IphoneRepository();
		try {
			repo.save(ip);
		} catch (RepositoryException | VersionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
