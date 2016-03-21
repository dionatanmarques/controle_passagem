package br.edu.fa7.controle_passagem.factory;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Produces;

import org.hibernate.Session;
@RequestScoped
public class SessionProducer implements Serializable {

	private static final long serialVersionUID = 7159251674020279717L;

	@Produces
	@Any
	public Session criarSession(){
		return HibernateFactory.getHibernateSession();
	}
}
