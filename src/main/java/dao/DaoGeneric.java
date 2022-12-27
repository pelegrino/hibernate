package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import hibernate.HibernateUtil;

public class DaoGeneric<E> {
	
	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	public void salvar(E entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);	
		transaction.commit();
	}
	
	public E pesquisar(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		E e = (E) entityManager.find(entidade.getClass(), id);
		return e;
	}
	
	public E pesquisar(Long id, Class<E> entidade) {
		E e = (E) entityManager.find(entidade, id);
		return e;
	}
	
	
}
