package br.unitins.rriphones.teste;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.application.Util;
import br.unitins.rriphones.model.Cartao;
import br.unitins.rriphones.model.Endereco;
import br.unitins.rriphones.model.Funcao;
import br.unitins.rriphones.model.Telefone;
import br.unitins.rriphones.model.Usuario;
import br.unitins.rriphones.repository.UsuarioRepository;

public class TestesJPA {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws RepositoryException {
		
		List<Endereco> listEnd = new ArrayList<Endereco>();
		listEnd.add(new Endereco("77022076","606 sul",6,"residencial"));
		
		List<Cartao> listCartao = new ArrayList<Cartao>();
		listCartao.add(new Cartao("Rafael Aguiar Silva", "54521 4623 55215","4548","15/28", Funcao.DEBITO));
		
		UsuarioRepository u = new UsuarioRepository();
		Usuario usu = new Usuario("rafael","rafaelaguiar@gmail.com","2512",
				 "07086036374", new Date(2001,12,14),"masculino", new Telefone("99","984232991"),
					listCartao,listEnd);
		
		usu.setSenha(Util.hash(usu));
		u.save(usu);
		
	}
}
