package br.edu.fa7.controle_passagem.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.fa7.controle_passagem.model.Local;
import br.edu.fa7.controle_passagem.model.Voo;

@RequestScoped
public class VooDao extends GenericDao<Voo> implements Serializable {

	private static final long serialVersionUID = 6974457078775296962L;

	@Inject
	public VooDao(Session session) {
		super(Voo.class, session);
	}

	public VooDao() {
		super(Voo.class, null);
	}

	public Voo carregar(int cod) {
		return (Voo) session.createCriteria(classe)
				.add(Restrictions.eq("id", cod)).uniqueResult();
	}

}
