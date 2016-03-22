package br.edu.fa7.controle_passagem.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.edu.fa7.controle_passagem.model.Aviao;
import br.edu.fa7.controle_passagem.model.CompanhiaAerea;
@RequestScoped
public class AviaoDao extends GenericDao<Aviao> implements Serializable{

	private static final long serialVersionUID = 1899492640295919815L;

	@Inject
	public AviaoDao(Session session) {
		super(Aviao.class, session);
	}
	
	public AviaoDao() {
		super(Aviao.class, null);
	}

	public List<Aviao> buscaPorCompanhia(CompanhiaAerea companhia) {
		return session.createCriteria(classe)
				.add(Restrictions.eq("companhia", companhia))
				.list();
	}

	public Aviao carregar(int cod) {
		return (Aviao) session.createCriteria(classe)
				.add(Restrictions.eq("id", cod))
				.uniqueResult();
	}

}
