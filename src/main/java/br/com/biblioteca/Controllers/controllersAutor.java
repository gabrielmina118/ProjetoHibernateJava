package br.com.biblioteca.Controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.biblioteca.modelo.Autor;

public class controllersAutor {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
	EntityManager em = emf.createEntityManager();
	//INSERIR
	public void inserir(Autor autor) {
		em.getTransaction().begin();
			em.persist(autor);
		em.getTransaction().commit();
	}
	
	// REMOVER 
	public void remover(Autor autor) {
		em.getTransaction().begin();
			em.remove(autor);
		em.getTransaction().commit();
	}

	// LISTAR PELO ID
	public List<Autor> listar(int id) {
		em.getTransaction().begin();
			String consulta = ("SELECT AUTOR FROM AUTOR WHERE ID ="+id);
			Query q = em.createQuery(consulta);
			List<Autor> result = q.getResultList();
		em.getTransaction().commit();
			return result;		
	}
	public List<Autor> listarAutores(){
		em.getTransaction().begin();
			String consulta =("SELECT ID ,NOME FROM AUTOR");
			Query q = em.createQuery(consulta);
			List<Autor> result = q.getResultList();
		em.getTransaction().commit();
			return result;
	}
	
}
