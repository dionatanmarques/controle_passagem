package br.edu.fa7.controle_passagem.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.fa7.controle_passagem.model.CompanhiaAerea;
@RequestScoped
public class CompanhiaAereaDao extends GenericDao<CompanhiaAerea> implements Serializable {

	private static final long serialVersionUID = 5902678534236587242L;

	@Inject
	public CompanhiaAereaDao(Session session) {
		super(CompanhiaAerea.class, session);
	}
	
	public CompanhiaAereaDao(){
		super(CompanhiaAerea.class, null);
	}

	public List<CompanhiaAerea> buscarPorNome(String nome) {	
		return session.createCriteria(classe)
				.add(Restrictions.ilike("nome", nome, MatchMode.START))
				.list();
	}

	public CompanhiaAerea carregar(int cod) {
		return (CompanhiaAerea)session.createCriteria(classe)
				.add(Restrictions.eq("id", cod))
				.uniqueResult();
	}
	
}
