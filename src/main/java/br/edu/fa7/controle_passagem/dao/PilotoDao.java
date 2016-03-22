package br.edu.fa7.controle_passagem.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.fa7.controle_passagem.model.Lanche;
import br.edu.fa7.controle_passagem.model.Piloto;

@RequestScoped
public class PilotoDao extends GenericDao<Piloto> implements Serializable {

	private static final long serialVersionUID = 6974457078775296962L;

	@Inject
	public PilotoDao(Session session) {
		super(Piloto.class, session);
	}

	public PilotoDao() {
		super(Piloto.class, null);
	}

	public List<Piloto> buscarPorNome(String nome) {
		return session.createCriteria(classe)
				.add(Restrictions.ilike("nome", nome, MatchMode.START))
				.list();
	}

	public Piloto carregar(int cod) {
		return (Piloto) session.createCriteria(classe)
				.add(Restrictions.eq("id", cod)).uniqueResult();
	}

}
