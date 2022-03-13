package br.unitins.rriphones.controller;

import br.unitins.rriphones.model.DefaultEntity;
import br.unitins.rriphones.repository.Repository;
import br.unitins.rriphones.repository.UsuarioRepository;

public abstract class Controller<T extends DefaultEntity> {
	private Repository<T> repo;
	protected T entity;
	public Controller(Repository<T > repo) {
		super();
	}

	public void salvar() {
		try {
			repo.save(getEntity());
			limpar();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void limpar() {
		entity = null;
	}

	public Repository<T> getRepo() {
		return repo;
	}

	public void setRepo(Repository<T> repo) {
		this.repo = repo;
	}

	public abstract T getEntity();

	public void setEntity(T entity) {
		this.entity = entity;
	}
	

}