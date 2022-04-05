package br.unitins.rriphones.teste;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.model.Usuario;
import br.unitins.rriphones.repository.UsuarioRepository;

public class TestesJPA {
	public static void main(String[] args) throws RepositoryException {
		UsuarioRepository u = new UsuarioRepository();
		Usuario usu = new Usuario();
		usu = u.findByEmail("d@gmail.com");
		System.out.println(usu.getEmail());
	}
}
