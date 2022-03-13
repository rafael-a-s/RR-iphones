package br.unitins.rriphones.repository;

import java.util.List;

import javax.persistence.Query;

import br.unitins.rriphones.model.Usuario;

public class UsuarioRepository extends Repository<Usuario> {

	public List<Usuario> findByNome(String nome) throws RepositoryException {
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

}
