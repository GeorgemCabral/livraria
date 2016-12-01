package com.livraria.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.livraria.business.LivroBusiness;
import com.livraria.model.Livro;

@ManagedBean(name = "cadastro")
@RequestScoped
public class LivroBean {
	
	private Livro livro;
	private List<Livro> listaLivros;
	
	LivroBusiness livroBusiness;
	
	@PostConstruct
    public void init() {
        livro = new Livro();
        livroBusiness = new LivroBusiness();	
    }
	
	public String save() {		
		livroBusiness.save(livro);
		limpar();
		return "/public/index";
	}
	
	public String novoLivro() {
		return "/public/cadastroLivros";
	}
	
	public String editarLivro(Livro livro) {
		this.livro = livro;
		return "/public/cadastroLivros";
	}
	
	public String voltar() {
		return "/public/index";
	}
	
	public void limpar(){
		livro = new Livro();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Livro> getListaLivros() {
		return livroBusiness.getAllLivros();
	}

	public void setListaLivros(List<Livro> listaLivros) {
		this.listaLivros = listaLivros;
	}
	
	public void deleteLivro(Livro livro){
		livroBusiness.delete(livro);
	}
	
	
	
	
}
