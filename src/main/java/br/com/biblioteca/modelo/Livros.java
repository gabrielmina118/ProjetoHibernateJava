package br.com.biblioteca.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Livros {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String edicao;
	private Double custo;
	private String titulo;
	
	@OneToOne(cascade = javax.persistence.CascadeType.ALL)
	@JoinColumn(name= "IdFk_Editora")
	private Editora editora;
	
	 @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	 @JoinColumn(name = "IDFK_AUTOR")
	 public List<Autor> autor;

	public Livros() {
		this.autor = new ArrayList<>();
	}
	
	public List<Autor> getAutor() {
		return autor;
	}

	public void setAutor(List<Autor> autor) {
		this.autor = autor;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String toString() {
		return String.format("O livro é : %d - %f - %s - %s - ",
							this.id,this.custo,this.edicao,this.titulo);
	}
}
