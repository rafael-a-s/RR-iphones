package br.unitins.rriphones.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unitins.rriphones.application.JPAUtil;
import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.model.Cartao;

public class CartaoRepository extends Repository<Cartao>{
	
	
	public void removeCartao(Integer id, Integer idusuario) throws RepositoryException {
		EntityManager em = null;
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			StringBuffer jpql = new StringBuffer();
			jpql.append("DELETE FROM Cartao c WHERE c.id  = :id and c.usuario_fk = :idusuario ");
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("id", id).setParameter("idusuario", idusuario).executeUpdate();
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		
	}
}
