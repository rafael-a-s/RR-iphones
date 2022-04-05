package br.unitins.rriphones.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.model.Usuario;

public class UsuarioRepository extends Repository<Usuario> {

	
	
	public List<Usuario> findByName(String email) throws RepositoryException {
		try {
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append(" u ");
			jpql.append("FROM ");
			jpql.append(" Usuario u ");
			jpql.append("WHERE ");
			jpql.append(" u.email LIKE :email ");
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("email", "%" + email + "%");

			return query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RepositoryException("Erro ao executar o findByNome");
		}

	}
	public Usuario findByEmail(String email) throws RepositoryException {
		try {
			StringBuffer jpql = new StringBuffer();
			jpql.append(" SELECT u FROM Usuario u WHERE u.email = :email ");
			Query q = getEntityManager().createQuery(jpql.toString());
			q.setParameter("email", email);
			
			return (Usuario)q.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
	}

}
