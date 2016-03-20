package br.edu.fa7.controle_passagem.dao;

import org.hibernate.Session;

import br.edu.fa7.controle_passagem.model.Local;

public class LocalDao extends GenericDao<Local> {

	public LocalDao(Session session) {
		super(Local.class, session);
	}
	
}
