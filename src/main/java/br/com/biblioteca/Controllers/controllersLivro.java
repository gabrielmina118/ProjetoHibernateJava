package br.com.biblioteca.Controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import br.com.biblioteca.modelo.Livros;

public class controllersLivro {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
	EntityManager em = emf.createEntityManager();
	
	//INSERIR
	public void inserir(Livros livro) {
		em.getTransaction().begin();
			em.persist(livro);
		em.getTransaction().commit();
	}
	
	// REMOVER 
	public void remover(Livros livro) {
		em.getTransaction().begin();
			em.remove(livro);
		em.getTransaction().commit();
	}

	// LISTAR PELO ID
	public List<Livros> listar(int id) {
		em.getTransaction().begin();
			String consulta = ("SELECT TITULO FROM LIVROS WHERE ID ="+id);
			Query q = em.createQuery(consulta);
			List<Livros> result = q.getResultList();
		em.getTransaction().commit();
		return result;		
	}

}
