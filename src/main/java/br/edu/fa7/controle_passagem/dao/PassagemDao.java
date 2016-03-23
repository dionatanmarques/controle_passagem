package br.edu.fa7.controle_passagem.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.fa7.controle_passagem.model.Passagem;
import br.edu.fa7.controle_passagem.model.Pessoa;
import br.edu.fa7.controle_passagem.model.Voo;

@RequestScoped
public class PassagemDao extends GenericDao<Passagem> implements Serializable {

	private static final int PORCENTAGEM_DESCONTO_DEFAULT = 0;
	private static final int PORCENTAGEM_DESCONTO_FUNCIONARIO = 10;
	private static final long serialVersionUID = 6969455534250651466L;

	@Inject
	public PassagemDao(Session session) {
		super(Passagem.class, session);
	}

	public PassagemDao() {
		super(Passagem.class, null);
	}

	public void salvar(Pessoa pessoa, List<Voo> voos) {
		for (Voo voo : voos) {
			Passagem passagem = new Passagem();
			passagem.setPessoa(pessoa);
			passagem.setVoo(voo);
			if (isFuncionario(pessoa)) {
				passagem.setPorcentagemDesconto(PORCENTAGEM_DESCONTO_FUNCIONARIO);
			} else {
				passagem.setPorcentagemDesconto(PORCENTAGEM_DESCONTO_DEFAULT);
			}
			salvar(passagem);
		}
	}

	private boolean isFuncionario(Pessoa pessoa) {
		String hql = "SELECT COUNT(f) FROM Funcionario f WHERE f.id = :pessoa";
		Query query = session.createQuery(hql);
		query.setParameter("pessoa", pessoa.getId());
		long result = (long) query.uniqueResult();
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}
}