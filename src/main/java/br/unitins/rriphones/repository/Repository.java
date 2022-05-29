package br.unitins.rriphones.repository;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;

import br.unitins.rriphones.application.JPAUtil;
import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.application.VersionException;
import br.unitins.rriphones.model.DefaultEntity;

public class Repository<T extends DefaultEntity> {
	private EntityManager entityManager ;
	public Repository() {
		super();
		setEntityManager(JPAUtil.getEntityManager());
		}
	
	public T save(T entity) throws RepositoryException, VersionException{
		try {
			getEntityManager().getTransaction().begin();
			entity = getEntityManager().merge(entity);
			getEntityManager().getTransaction().commit();
			return entity;
		} catch (OptimisticLockException e) {
			// excecao do @version
			System.out.println("Problema com o controle de concorrencia.");
			e.printStackTrace();
			try {
				getEntityManager().getTransaction().rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			throw new VersionException("As informa��es est�o antigas, d� um refresh.");			
		} catch (Exception e) {
			System.out.println("Problema ao executar o save.");
			e.printStackTrace();
			try {
				getEntityManager().getTransaction().rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			throw new RepositoryException("Problema ao salvar.");
		}

	}
	public void save(T... entitys) throws RepositoryException {
		try {
			getEntityManager().getTransaction().begin();
			for (T entity : entitys) {
				getEntityManager().merge(entity);
			}
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Problema ao executar o save.");
			e.printStackTrace();
			try {
				getEntityManager().getTransaction().rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			throw new RepositoryException("Problema ao salvar.");
		}
	}

	
	public void remove(T entity) throws RepositoryException {
		try {
			getEntityManager().getTransaction().begin();
			T obj = getEntityManager().merge(entity);
			getEntityManager().remove(obj);
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Problema ao executar o save.");
			e.printStackTrace();
			try {
				getEntityManager().getTransaction().rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
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
