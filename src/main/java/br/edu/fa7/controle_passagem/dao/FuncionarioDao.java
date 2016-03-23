package br.edu.fa7.controle_passagem.dao;


import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.edu.fa7.controle_passagem.model.Funcionario;
@RequestScoped
public class FuncionarioDao extends GenericDao<Funcionario> implements Serializable {

	private static final long serialVersionUID = 5801664535845560327L;
	
	@Inject
	public FuncionarioDao(Session session) {
		super(Funcionario.class, session);
	}
	
	public FuncionarioDao() {
		super(Funcionario.class, null);
	}

	public Funcionario buscarComoUsuario(String cpf, String senha) {
		return (Funcionario) session.createCriteria(classe)
				.add(Restrictions.eq("cpf", cpf))
				.add(Restrictions.eq("senha", senha))
				.uniqueResult();
	}

	public List<Funcionario> buscarPorNome(String nome) {
		return session.createCriteria(classe)
				.add(Restrictions.ilike("nome",nome,MatchMode.START))
				.list();
	}

	public Funcionario carregar(int cod) {
		return (Funcionario) session.createCriteria(classe)
				.add(Restrictions.eq("id", cod))
				.uniqueResult();
	}

}
