package br.unitins.rriphones.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.model.Iphone;
import br.unitins.rriphones.model.Usuario;

public class IphoneRepository extends Repository<Iphone> {

	
	public List<Iphone> obterTodos(){
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT i FROM Iphone i"); // query jpql para consulta
		
		Query query = getEntityManager().createQuery(jpql.toString()); //creiando a query de consulta
		
		return query.getResultList(); //retornando toda a lista de iphones
	}
	public List<Iphone> findByModelo(String modelo) {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT i FROM Iphone i WHERE i.modelo.id = i.modelo.id and i.modelo.modeloLabel LIKE :modelo");
		
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("modelo","%" + modelo + "%");
		return query.getResultList();
	}
	
	

}
