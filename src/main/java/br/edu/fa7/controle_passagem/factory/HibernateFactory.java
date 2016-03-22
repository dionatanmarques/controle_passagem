package br.edu.fa7.controle_passagem.factory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateFactory {
	
	private static SessionFactory sf;
	
	public static synchronized Session getHibernateSession(){	
		if(sf == null){
			Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
             
            // builds a session factory from the service registry
            sf = configuration.buildSessionFactory(serviceRegistry);   
		}
		Session s = sf.getCurrentSession();		
		return s;
	}
}
