package br.unitins.rriphones.controller;

import br.unitins.rriphones.application.RepositoryException;
import br.unitins.rriphones.application.Util;
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
			Util.addInfoMessage("Inclusão realizada com sucesso !");
			limpar();
		}catch(Exception e) {
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		}
		
	}
	public void alterar() {
		try {
			getRepo().save(getEntity());
			Util.addInfoMessage("Alteração realizada com sucesso !");
			limpar();
		}catch(RepositoryException e){
			e.printStackTrace();
			Util.addErrorMessage(e.getMessage());
		}
	}
	public void excluir() {
		try {
			getRepo().delete(getEntity());
			Util.addInfoMessage("Exclusão realizada com sucesso !");
			limpar();
		} catch(RepositoryException e){
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