package com.livraria.dao.utils;

import com.livraria.dao.LivroDAO;
import com.livraria.dao.impl.LivroDAOImpl;

public class DAOFactory {
  
    public static LivroDAO createLivro(){
        LivroDAOImpl livroDaoImpl = new LivroDAOImpl();
        livroDaoImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return livroDaoImpl;
    }
}