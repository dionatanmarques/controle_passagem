package br.edu.fa7.controle_passagem.dao;

import org.hibernate.Session;

import br.edu.fa7.controle_passagem.model.Assento;

public class AssentoDao extends GenericDao<Assento> {

	
	public AssentoDao(Session session) {
		super(Assento.class, session);
	}

	
}
