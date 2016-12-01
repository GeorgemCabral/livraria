package com.mb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.facade.LivroFacade;
import com.model.Livro;

@ManagedBean
@RequestScoped
public class LivroMB {
	
	@EJB
	private LivroFacade livroFacade;
	
	private static final String CREATE_LIVRO = "criarLivro";
	private static final String UPDATE_LIVRO = "alterarLivro";
	private static final String LIST_ALL_LIVROS = "listarTodosLivros";
	private static final String DELETE_LIVRO = "deletarLivro";
	private static final String STAY_IN_THE_SAME_PAGE = null;
	
	
	private Livro livro;
	
	public Livro getLivro(){
		if(livro == null){
			livro = new Livro();
		}
		return livro;
	}
	
	public void setLivro(Livro livro){
		this.livro = livro;
	}
	
	public List<Livro> getAllLivros(){
		return livroFacade.findAll();
	}
	
	public String updateDogStart(){
        return UPDATE_LIVRO;
    }
 
    public String updateLivroEnd(){
        try {
            livroFacade.update(livro);
        } catch (EJBException e) {
            sendErrorMessageToUser("Error. Check if the weight is above 0 or call the adm");
            return STAY_IN_THE_SAME_PAGE;
        }
 
        sendInfoMessageToUser("Operation Complete: Update");
        return LIST_ALL_LIVROS;
    }
 
    public String deleteLivroStart(){
        return DELETE_LIVRO;
    }
 
    public String deleteLivroEnd(){
        try {
            livroFacade.delete(livro);
        } catch (EJBException e) {
            sendErrorMessageToUser("Error. Call the ADM");
            return STAY_IN_THE_SAME_PAGE;
        }           
 
        sendInfoMessageToUser("Operation Complete: Delete");
 
        return LIST_ALL_LIVROS;
    }
 
    public String createLivroStart(){
        return CREATE_LIVRO;
    }
 
    public String createLivroEnd(){
        try {
            livroFacade.save(livro);
        } catch (EJBException e) {
            sendErrorMessageToUser("Error. Check if the weight is above 0 or call the adm");
 
            return STAY_IN_THE_SAME_PAGE;
        }       
 
        sendInfoMessageToUser("Operation Complete: Create");
 
        return LIST_ALL_LIVROS;
    }
 
    public String listAllLivros(){
        return LIST_ALL_LIVROS;
    }
 
    private void sendInfoMessageToUser(String message){
        FacesContext context = getContext();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
    }
 
    private void sendErrorMessageToUser(String message){
        FacesContext context = getContext();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
    }
 
    private FacesContext getContext() {
        FacesContext context = FacesContext.getCurrentInstance();
        return context;
    }

}
