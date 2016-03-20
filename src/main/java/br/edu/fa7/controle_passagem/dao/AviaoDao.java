package br.edu.fa7.controle_passagem.dao;

import org.hibernate.Session;

import br.edu.fa7.controle_passagem.model.Aviao;

public class AviaoDao extends GenericDao<Aviao>{

	public AviaoDao(Session session) {
		super(Aviao.class, session);
	}

}
