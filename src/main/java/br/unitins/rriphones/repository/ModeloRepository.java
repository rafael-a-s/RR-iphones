package br.unitins.rriphones.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.model.Modelo;

public class ModeloRepository extends Repository<Modelo> {
	
	
	public List<Modelo> findByModelo(String nome, Integer maxResults)throws RepositoryException {
		try { 
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append("  m ");
			jpql.append("FROM ");
			jpql.append("  Modelo m ");
			jpql.append("WHERE ");
			jpql.append("  m.modeloLabel LIKE :nome ");
			
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("nome", "%" + nome + "%");
			
			if (maxResults != null)
				query.setMaxResults(maxResults);
			
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByModelo.");
		}
	}
		
	public List<Modelo> findByModelo(String nome) throws RepositoryException {
		return findByModelo(nome, null);
	}
	

}
