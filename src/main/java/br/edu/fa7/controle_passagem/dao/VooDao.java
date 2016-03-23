package br.edu.fa7.controle_passagem.dao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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

	@SuppressWarnings("unchecked")
	public List<Voo> buscarPorData(Voo voo) {
		StringBuilder hql = new StringBuilder();
		hql.append("SELECT v");
		hql.append("	FROM Voo v");
		hql.append("	WHERE v.localOrigem.id = :localOrigem");
		hql.append("	AND v.localDestino.id = :localDestino");
		hql.append("	AND CAST(v.dataEmbarque AS date) = :dataEmbarque");
		Query query = session.createQuery(hql.toString());
		query.setParameter("localOrigem", voo.getLocalOrigem().getId());
		query.setParameter("localDestino", voo.getLocalDestino().getId());
		query.setParameter("dataEmbarque", voo.getDataEmbarque());
		return query.list();
	}

}
