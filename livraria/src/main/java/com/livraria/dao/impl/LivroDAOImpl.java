package com.livraria.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.livraria.dao.LivroDAO;
import com.livraria.model.Livro;

//Implementacao da interface LivroDAO
public class LivroDAOImpl implements LivroDAO {
	
	//Sessao do hibernate
	private Session session;
	  
    public void setSession(Session session) {
        this.session = session;
    }

    //Metodo para salvar o livro
	public void save(Livro livro) {
		this.session.saveOrUpdate(livro);				
	}


	//Metodo para rerornar todos os livros
	public List<Livro> getAllLivros() {
		//Criacao de um objeto Query
		Query q = session.createQuery("from Livro");
		List<Livro> listaLivros = (List<Livro>) q.list();
		return listaLivros;
	}

	//Metodo para delecao do livro
	public void delete(Livro livro) {
		session.delete(livro);		
	}
	
	

}
