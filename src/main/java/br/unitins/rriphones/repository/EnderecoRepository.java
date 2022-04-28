package br.unitins.rriphones.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.model.Endereco;

public class EnderecoRepository extends Repository<Endereco> {
	
	public List<Endereco> findByCep(String cep) throws RepositoryException {
		try {
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append(" e ");
			jpql.append("FROM ");
			jpql.append(" Endereco e ");
			jpql.append("WHERE ");
			jpql.append(" e.cep LIKE :cep ");
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("cep", "%" + cep + "%");

			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByCep");
		}

	}
}
