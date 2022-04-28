package br.unitins.rriphones.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.model.Telefone;
import br.unitins.rriphones.model.Usuario;

public class TelefoneRepository  extends Repository<Telefone>{
	
	public List<Telefone> findByNumero(String numero) throws RepositoryException {
		try {
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append(" t ");
			jpql.append("FROM ");
			jpql.append(" Telefone t ");
			jpql.append("WHERE ");
			jpql.append(" t.numero LIKE :numero ");
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("numero", "%" + numero + "%");

			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome");
		}

	}
}
