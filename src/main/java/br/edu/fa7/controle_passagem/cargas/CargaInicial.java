package br.edu.fa7.controle_passagem.cargas;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import br.edu.fa7.controle_passagem.dao.AssentoDao;
import br.edu.fa7.controle_passagem.dao.AviaoDao;
import br.edu.fa7.controle_passagem.dao.CompanhiaAereaDao;
import br.edu.fa7.controle_passagem.dao.FuncionarioDao;
import br.edu.fa7.controle_passagem.dao.LocalDao;
import br.edu.fa7.controle_passagem.factory.HibernateFactory;
import br.edu.fa7.controle_passagem.model.Assento;
import br.edu.fa7.controle_passagem.model.Aviao;
import br.edu.fa7.controle_passagem.model.CompanhiaAerea;
import br.edu.fa7.controle_passagem.model.Funcionario;
import br.edu.fa7.controle_passagem.model.Local;

public class CargaInicial {

	public static void main(String[] args) throws Exception {

		Session session = HibernateFactory.getHibernateSession();
		session.beginTransaction();

		CompanhiaAereaDao caDao = new CompanhiaAereaDao();

		// ------------ Cria o Companhia Aerea ---------
		CompanhiaAerea ca1 = new CompanhiaAerea();
		ca1.setNome("TAM");

		caDao.salvar(ca1);

		CompanhiaAerea ca2 = new CompanhiaAerea();
		ca2.setNome("GOL");

		caDao.salvar(ca2);

		CompanhiaAerea ca3 = new CompanhiaAerea();
		ca3.setNome("AZUL");

		caDao.salvar(ca3);

		AviaoDao aviDao = new AviaoDao();
		AssentoDao assDao = new AssentoDao();
		// ------------ Cria o Aviao ---------
		List<CompanhiaAerea> listaC = new ArrayList<CompanhiaAerea>();
		listaC.add(ca1);
		listaC.add(ca2);
		listaC.add(ca3);
		for (CompanhiaAerea companhiaAerea : listaC) {
			for (int e = 1; e <= 3; e++) {

				Aviao av = new Aviao();
				av.setCompanhia(companhiaAerea);
				av.setNome(companhiaAerea.getNome() + "-" + e);
				aviDao.salvar(av);

				for (int j = 0; j < 10; j++) {
					Assento assA = new Assento();
					assA.setAviao(av);
					assA.setNome("A" + j);
					assDao.salvar(assA);
					Assento assB = new Assento();
					assB.setAviao(av);
					assB.setNome("B" + j);
					assDao.salvar(assB);
					Assento assC = new Assento();
					assC.setAviao(av);
					assC.setNome("C" + j);
					assDao.salvar(assC);
					Assento assD = new Assento();
					assD.setAviao(av);
					assD.setNome("D" + j);
					assDao.salvar(assD);
				}
			}
		}

		LocalDao locDao = new LocalDao();
		String[] locais = { "FORTALEZA", "RECIFE", "NATAL", "ARACAJÚ",
				"SALVADOR", "RIO DE JANEIRO", "SÃO PAULO", "CAMPINAS",
				"FOZ DO IGUAÇU", "GRAMADOS", "FLORIANOPÓLIS" };
		for (int j = 0; j < locais.length; j++) {
			Local local = new Local();
			local.setNome(locais[j]);
			locDao.salvar(local);
		}

		FuncionarioDao funDao = new FuncionarioDao();

		Funcionario f1 = new Funcionario();
		f1.setCpf("12312312312");
		f1.setNome("Antonio Allan");
		f1.setSenha("1234");
		funDao.salvar(f1);
		Funcionario f2 = new Funcionario();
		f2.setCpf("12345678901");
		f2.setNome("DIONATAN");
		f2.setSenha("1234");
		funDao.salvar(f2);

		session.getTransaction().commit();
	}
}
