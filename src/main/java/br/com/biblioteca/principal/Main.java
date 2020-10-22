package br.com.biblioteca.principal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.biblioteca.Controllers.controllersAutor;
import br.com.biblioteca.Controllers.controllersEditora;
import br.com.biblioteca.Controllers.controllersLivro;
import br.com.biblioteca.modelo.Autor;
import br.com.biblioteca.modelo.Editora;
import br.com.biblioteca.modelo.Email;
import br.com.biblioteca.modelo.Livros;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
		EntityManager em = emf.createEntityManager();
		
		controllersAutor ca = new controllersAutor();
		controllersEditora ce = new controllersEditora(); 
		controllersLivro cl = new controllersLivro();
		
		em.getTransaction().begin();
	
			// Setando os Email
			Email email = new Email();
			Email email2 = new Email();
			email.setNome("gabriel@mina");		
			email2.setNome("mina@gabriel");
		
			Email email3 = new Email();
			Email email4 = new Email();
			email3.setNome("machado@assis");
			email4.setNome("MachadaoAfiado@assis");
		
			Email email5 = new Email();
			Email email6 = new Email();
			email5.setNome("RRMartin@martin");
			email6.setNome("caradogameofthores@got");
		
			Email email7 = new Email();
			Email email8 = new Email();
			email7.setNome("Eduardo@sporh");
			email8.setNome("spor@batalhadoapocalipse");
		
			Email email9 = new Email();
			Email email10 = new Email();
			email9.setNome("August@cury");
			email10.setNome("Augustcury@escritor");
		
			
			//Setando Autores
			Autor autor = new Autor();
			autor.setNome("gabrielMina");
			autor.email = new ArrayList<>();
			autor.email.add(email);
			autor.email.add(email2);
			
			Autor autor2 = new Autor();
			autor2.setNome("Machado de Assis");
			autor2.email = new ArrayList<>();
			autor2.email.add(email3);
			autor2.email.add(email4);
			
			Autor autor3 = new Autor();
			autor3.setNome("George R.R Martin");
			autor3.email = new ArrayList<>();
			autor3.email.add(email5);
			autor3.email.add(email6);
			
			Autor autor4 = new Autor();
			autor4.setNome("Eduardo Sporh");
			autor4.email = new ArrayList<>();
			autor4.email.add(email7);
			autor4.email.add(email8);
			
			Autor autor5 = new Autor();
			autor5.setNome("August Cury");
			autor5.email = new ArrayList<>();
			autor5.email.add(email9);
			autor5.email.add(email10);
		/*
			//Listando todos os autores
			List<Autor> autores1 = ca.listarAutores();
			
			for(int i =0;i < autores1.size();i++) {
				System.out.println(autores1.toString());
			}
			*/
			//Setando Editora
			Editora editora = new Editora();
			editora.setNome("Editora Gabriel Mina");
			
			Editora editora1 = new Editora();
			editora1.setNome("Editora machado de Assis");
			
			Editora editora2 = new Editora();
			editora2.setNome("Editora George R.R Martin");
			
			Editora editora3 = new Editora();
			editora3.setNome("Editora Eduardo Sporh");
			
			Editora editora4 = new Editora();
			editora4.setNome("Editora August cury");
			/*
			// Listando pelo ID
			List<Editora> listaEditora = ce.listar(1);
			
			for(int i = 0; i < listaEditora.size();i++) {
				System.out.println(listaEditora.toString());
			}
			
			// Listando Editora com id = 25
			List<Editora> listaEditorasId = ce.listarId(25);
			
			for(int i =0;i < listaEditorasId.size();i++) {
				System.out.println(listaEditorasId.toString());
			}
		*/
			
			//Setando livros
			Livros livro = new Livros();
			livro.setCusto(50.60);
			livro.setEdicao("Edicao machado assis e gabriel mina");
			livro.setTitulo("As aventuras de mina Gabriel");
			livro.setEditora(editora);
			
			Livros livro1 = new Livros();
			livro1.setCusto(50.60);
			livro1.setEdicao("Edicao machado assis ");
			livro1.setTitulo("As cronicas de machado afiado");
			livro1.setEditora(editora1);
			
			Livros livro2 = new Livros();
			livro2.setCusto(50.60);
			livro2.setEdicao("Edicao George R.R Martin");
			livro2.setTitulo("As cronicas do gelo e do fogo");
			livro2.setEditora(editora2);
			
			Livros livro3 = new Livros();
			livro3.setCusto(50.60);
			livro3.setEdicao("Edicao Eduardo Sphor");
			livro3.setTitulo("Filhos do eden. A Batalha do apocalipse");
			livro3.setEditora(editora3);
			
			Livros livro4 = new Livros();
			livro4.setCusto(50.60);
			livro4.setEdicao("Edicao August cury");
			livro4.setTitulo("O mestre da sensibilidade");
			livro4.setEditora(editora4);
			/*
			//Listar livros pelo ID
			List<Livros> listaLivros = cl.listar(1);
			
			for(int i = 0; i <listaLivros.size();i++) {
				System.out.println(listaLivros.toString());
			}
			*/
			try {
				em.persist(email);
				em.persist(email2);
				em.persist(email3);
				em.persist(email4);
				em.persist(email5);
				em.persist(email6);
				em.persist(email7);
				em.persist(email8);
				em.persist(email9);
				em.persist(email10);
				
				em.persist(autor);
				em.persist(autor2);
				em.persist(autor3);
				em.persist(autor4);
				em.persist(autor5);
				
				em.persist(editora);
				em.persist(editora1);
				em.persist(editora2);
				em.persist(editora3);
				em.persist(editora4);
				
				em.persist(livro);
				em.persist(livro1);
				em.persist(livro2);
				em.persist(livro3);
				em.persist(livro4);
				em.getTransaction().commit();
			}catch (Exception e) {
				em.getTransaction().rollback();
			}
			
	}
}
