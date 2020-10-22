package br.com.biblioteca.Controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.biblioteca.modelo.Autor;
import br.com.biblioteca.modelo.Editora;

public class controllersEditora {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
	EntityManager em = emf.createEntityManager();
	//INSERIR
	public void inserir(Editora editora) {
		em.getTransaction().begin();
			em.persist(editora);
		em.getTransaction().commit();
	}
	
	// REMOVER 
	public void remover(Editora editora) {
		em.getTransaction().begin();
			em.remove(editora);
		em.getTransaction().commit();
	}


	// Listar editora
	public List<Editora> listar(int id) {
		em.getTransaction().begin();
			String consulta = ("SELECT ID,NOME FROM EDITORA WHERE ID ="+id);
			Query q = em.createQuery(consulta);
			List<Editora> result = q.getResultList();
		em.getTransaction().commit();
		return result;		
	}

	// LISTAR PELO ID pelo ID = 25
	public List<Editora> listarId(int id) {
		em.getTransaction().begin();
			String consulta = ("SELECT NOME FROM EDITORA WHERE ID = 25");
			Query q = em.createQuery(consulta);
			List<Editora> result = q.getResultList();
		em.getTransaction().commit();
		return result;		
	}
}
