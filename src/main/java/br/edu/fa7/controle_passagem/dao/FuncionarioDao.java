package br.edu.fa7.controle_passagem.dao;


import javax.inject.Inject;

import org.hibernate.criterion.Restrictions;

import br.edu.fa7.controle_passagem.model.Funcionario;

public class FuncionarioDao extends GenericDao<Funcionario> {

	@Inject
	public FuncionarioDao() {
		super(Funcionario.class);
	}

	public Funcionario buscarComoUsuario(String cpf, String senha) {
		return (Funcionario) session.createCriteria(classe)
				.add(Restrictions.eq("cpf", cpf))
				.add(Restrictions.eq("senha", senha))
				.uniqueResult();
	}

}
