package br.edu.fa7.controle_passagem.dao;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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

	public List<Voo> buscarPorData(Date dataIda, Local origem, Local destino) {
		Calendar dataIdaInicio = Calendar.getInstance();
		dataIdaInicio.setTime(dataIda);
		dataIdaInicio.set(Calendar.HOUR, 0);
		dataIdaInicio.set(Calendar.MINUTE, 0);
		dataIdaInicio.set(Calendar.SECOND, 0);
		Date inicio = dataIdaInicio.getTime();
		dataIdaInicio.set(Calendar.HOUR, 23);
		dataIdaInicio.set(Calendar.MINUTE, 59);
		dataIdaInicio.set(Calendar.SECOND, 59);
		
		return session.createCriteria(classe)
				.add(Restrictions.ge("dataEmbarque", inicio))
				.add(Restrictions.le("dataEmbarque", dataIdaInicio.getTime()))
				.add(Restrictions.eq("localOrigem", origem))
				.add(Restrictions.eq("localDestino", destino))
				.list();
	}

}
