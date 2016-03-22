package br.edu.fa7.controle_passagem.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;

import br.edu.fa7.controle_passagem.model.Assento;
@RequestScoped
public class AssentoDao extends GenericDao<Assento> implements Serializable {

	private static final long serialVersionUID = 3579520014390775378L;

	@Inject
	public AssentoDao(Session session) {
		super(Assento.class, session);
	}
	
	public AssentoDao() {
		super(Assento.class, null);
	}

	
}
