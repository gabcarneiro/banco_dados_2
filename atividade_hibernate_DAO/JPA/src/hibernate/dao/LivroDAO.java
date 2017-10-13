package hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class LivroDAO implements Persistible<Livro>{


	@Override
	public void save(Livro livro) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(livro);
		tx.commit();
		em.close();
	}

	@Override
	public Livro getOne(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Livro result = em.find(Livro.class, id);
		tx.commit();
		em.close();
		return result;
	}

	@Override
	public List<Livro> getAll() {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
	    Query query = em.createQuery("SELECT e FROM Livro e");
	    return (List<Livro>) query.getResultList();
	}

	@Override
	public void delete(Livro livro) {
		
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.remove(em.merge(livro));
		tx.commit();
		em.close();	
	}

	@Override
	public void update(Livro livro) {
		
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Livro result = em.find(Livro.class, livro.getId());
		
		result.setTitulo(livro.getTitulo());
		result.setAutor(livro.getAutor());
		result.setAvaliacao(livro.getAvaliacao());
		result.setEditora(livro.getEditora());
		result.setIsbn(livro.getIsbn());
		result.setPaginas(livro.getPaginas());
		result.setAutor(livro.getAutor());
		
		tx.commit();
		em.close();
	}
	


}
