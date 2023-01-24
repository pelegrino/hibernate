package dao;

import java.util.List;

import javax.persistence.Query;

import model.UsuarioPessoa;

public class DaoUsuario<E> extends DaoGeneric<UsuarioPessoa> {
	
	
	
	public void removerUsuario(UsuarioPessoa pessoa) throws Exception {
		getEntityManager().getTransaction().begin();
		
		/*
		String sqlDeleteFone = "delete from telefoneuser where usuariopessoa_id = " + pessoa.getId();
		getEntityManager().createNativeQuery(sqlDeleteFone).executeUpdate();
		
		sqlDeleteFone = "delete from emailuser where usuariopessoa_id = " + pessoa.getId();
		getEntityManager().createNativeQuery(sqlDeleteFone).executeUpdate();
		 */
		
		getEntityManager().remove(pessoa);
		
		getEntityManager().getTransaction().commit();
		
		super.deletarPorId(pessoa);
	}

	public List<UsuarioPessoa> pesquisar(String campoPesquisa) {
		
		Query query = super.getEntityManager().createQuery("from UsuarioPessoa where nome like '%"+campoPesquisa+"%' ");
		
		return query.getResultList();
	}

}
