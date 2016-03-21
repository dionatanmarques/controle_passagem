package br.edu.fa7.controle_passagem.dao;

import java.util.List;

import org.hibernate.Session;

public abstract class GenericDao<T> {	
	
	protected final Class classe;
	protected final Session session;
	
    public GenericDao(Class classe, Session session) {
    	this.classe = classe;
    	this.session = session;
    }
    
    public void salvar(T bm){
    	session.saveOrUpdate(bm);
    }
    
    public void deletar(T bm){
    	session.delete(bm);
    }
    
    @SuppressWarnings({ "unchecked" })
	public List<T> listarTodos(){
    	return session.createCriteria(this.classe).list();
    }
    
    @SuppressWarnings({ "unchecked" })
	public List<T> listarTodosComLimite(Integer limite){
    	return session.createCriteria(this.classe).setMaxResults(limite).list();
    }
    
}
