package br.unitins.rriphones.repository;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

import javax.persistence.EntityManager;

import br.unitins.rriphones.application.JPAUtil;
import br.unitins.rriphones.model.DefaultEntity;

public class Repository<T extends DefaultEntity> {
	private EntityManager entityManager ;
	public Repository() {
		super();
		setEntityManager(JPAUtil.getEntityManager());
		}
	
	public void save(T entity) throws RepositoryException{
		try {
		getEntityManager().getTransaction().begin();
		getEntityManager().merge(entity);
		getEntityManager().getTransaction().commit();
		}catch(Exception e){
			System.out.println("Problema ao salvar.");
			e.printStackTrace();
			try {
			getEntityManager().getTransaction().rollback();
			}catch(Exception el) {
				el.printStackTrace();
			}
			throw new RepositoryException("Problema ao salvar.");
		}
	}
	public void save(T ... entitys) throws RepositoryException {
		
		try {
			getEntityManager().getTransaction().begin();
			for(T entity : entitys) {
				getEntityManager().merge(entity);
			}
			
			getEntityManager().getTransaction().commit();
			}catch(Exception e){
				System.out.println("Problema ao salvar.");
				e.printStackTrace();
				try {
				getEntityManager().getTransaction().rollback();
				}catch(Exception el) {
					el.printStackTrace();
				}
				throw new RepositoryException("Problema ao salvar.");
			}
		
	}
	public void alterar(T entity) {
		EntityManager em = JPAUtil.getEntityManager();
		
		
	}
	public void delete(T entity) throws RepositoryException {
		
		try {
			getEntityManager().getTransaction().begin();
			T obj = getEntityManager().merge(entity);
			getEntityManager().remove(obj);
			getEntityManager().getTransaction().commit();
			}catch(Exception e){
				System.out.println("Problema ao salvar.");
				e.printStackTrace();
				try {
				getEntityManager().getTransaction().rollback();
				}catch(Exception el) {
					el.printStackTrace();
				}
				throw new RepositoryException("Problema ao salvar.");
			}
	}
	
	public T findById(int id) throws RepositoryException {
		try {
		final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		Class<T> tClass = (Class<T>) (type).getActualTypeArguments()[0];
		
		T t = (T) getEntityManager().find(tClass, id);
		return t;
		}catch(Exception e){
			System.out.println("Erro no find.");
			e.printStackTrace();
			throw new RepositoryException("Erro ao busacar os dados");
		}
		
	}

		
		
		
	

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	protected void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
}
