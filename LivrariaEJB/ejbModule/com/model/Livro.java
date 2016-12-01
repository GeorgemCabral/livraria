package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LIVROS")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String autor;
	private int avaliacao; 
	private String titulo;
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAvaliacao() {
		return avaliacao;
	}
	public void setAvaliacao(int avaliacao) {
		this.avaliacao = avaliacao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getId() {
		return 0;
	}
	
	@Override
	public int hashCode() {
		return getId();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Livro){
			Livro livro =  (Livro) obj;
			return livro.getId() == getId();
			
		}
		return false;
	}
}
