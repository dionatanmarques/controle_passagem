package br.edu.fa7.controle_passagem.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.fa7.controle_passagem.model.Pessoa;

@RequestScoped
public class PessoaDao extends GenericDao<Pessoa> implements Serializable {

	private static final long serialVersionUID = 6617429248950734826L;

	@Inject
	public PessoaDao(Session session) {
		super(Pessoa.class, session);
	}

	public PessoaDao() {
		super(Pessoa.class, null);
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> buscarPorNome(String nome) {
		return session.createCriteria(classe)
				.add(Restrictions.ilike("nome", nome, MatchMode.START))
				.list();
	}

	public Pessoa carregar(int cod) {
		return (Pessoa) session.createCriteria(classe)
				.add(Restrictions.eq("id", cod))
				.uniqueResult();
	}

	public Pessoa buscarPorCpf(Pessoa pessoa) {
		String hql = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf";
		Query query = session.createQuery(hql);
		query.setParameter("cpf", pessoa.getCpf());
		try {
			return (Pessoa) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}
}