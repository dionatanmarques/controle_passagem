package br.edu.fa7.controle_passagem.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.fa7.controle_passagem.model.Local;

@RequestScoped
public class LocalDao extends GenericDao<Local> implements Serializable {

	private static final long serialVersionUID = 6974457078775296962L;

	@Inject
	public LocalDao(Session session) {
		super(Local.class, session);
	}

	public LocalDao() {
		super(Local.class, null);
	}

	public List<Local> buscarPorNome(String nome) {
		return session.createCriteria(classe)
				.add(Restrictions.ilike("nome", nome, MatchMode.START))
				.list();
	}

	public Local carregar(int cod) {
		return (Local) session.createCriteria(classe)
				.add(Restrictions.eq("id", cod)).uniqueResult();
	}

}
