package br.unitins.rriphones.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.model.Usuario;

public class UsuarioRepository extends Repository<Usuario> {

	
	public void removeCartao(Integer id, Integer idusuario) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("DELETE FROM Cartao c WHERE c.id  = :id and c.usuario_fk = :idusuario ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", id).setParameter("idusuario", idusuario).executeUpdate();
	}
	public List<Usuario> findByName(String nome) throws RepositoryException {
		try {
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT ");
			jpql.append(" u ");
			jpql.append("FROM ");
			jpql.append(" Usuario u ");
			jpql.append("WHERE ");
			jpql.append(" u.nome LIKE :nome ");
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("nome", "%" + nome + "%");

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
			return null;
		}
		
		
		
	}

}
