package br.edu.fa7.controle_passagem.dao;


import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import org.hibernate.Session;
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

}
