package br.edu.fa7.controle_passagem.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.fa7.controle_passagem.model.CompanhiaAerea;
import br.edu.fa7.controle_passagem.model.Lanche;
import br.edu.fa7.controle_passagem.model.Local;

@RequestScoped
public class LancheDao extends GenericDao<Lanche> implements Serializable {

	private static final long serialVersionUID = 6974457078775296962L;

	@Inject
	public LancheDao(Session session) {
		super(Lanche.class, session);
	}

	public LancheDao() {
		super(Lanche.class, null);
	}

	public List<Lanche> buscarPorNome(String nome) {
		return session.createCriteria(classe)
				.add(Restrictions.ilike("nome", nome, MatchMode.START))
				.list();
	}

	public Lanche carregar(int cod) {
		return (Lanche) session.createCriteria(classe)
				.add(Restrictions.eq("id", cod)).uniqueResult();
	}

}
