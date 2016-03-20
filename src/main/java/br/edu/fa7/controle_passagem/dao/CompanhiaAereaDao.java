package br.edu.fa7.controle_passagem.dao;

import org.hibernate.Session;

import br.edu.fa7.controle_passagem.model.CompanhiaAerea;

public class CompanhiaAereaDao extends GenericDao<CompanhiaAerea> {

	public CompanhiaAereaDao(Session session) {
		super(CompanhiaAerea.class, session);
	}
	
}
