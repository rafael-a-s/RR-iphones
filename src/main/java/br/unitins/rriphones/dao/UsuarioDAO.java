package br.unitins.rriphones.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unitins.rriphones.model.Usuario;

public class UsuarioDAO {
	
	
	public Usuario salvar(Usuario usu) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("rriphones");
		EntityManager em = emf.createEntityManager();
		
		
		
		
		em.getTransaction().begin();
		em.merge(usu);
		em.getTransaction().commit();
		return usu;
		
	}
	public void  delete(Usuario usu) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("rriphones");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.remove(em.getReference(Usuario.class, usu.getId()));
		em.getTransaction().commit();
		em.close();
	}

}
