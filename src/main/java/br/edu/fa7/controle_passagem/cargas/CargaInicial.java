package br.edu.fa7.controle_passagem.cargas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.edu.fa7.controle_passagem.dao.AssentoDao;
import br.edu.fa7.controle_passagem.dao.AviaoDao;
import br.edu.fa7.controle_passagem.dao.CompanhiaAereaDao;
import br.edu.fa7.controle_passagem.dao.FuncionarioDao;
import br.edu.fa7.controle_passagem.dao.LancheDao;
import br.edu.fa7.controle_passagem.dao.LocalDao;
import br.edu.fa7.controle_passagem.dao.PilotoDao;
import br.edu.fa7.controle_passagem.factory.HibernateFactory;
import br.edu.fa7.controle_passagem.model.Aviao;
import br.edu.fa7.controle_passagem.model.CompanhiaAerea;
import br.edu.fa7.controle_passagem.model.Funcionario;
import br.edu.fa7.controle_passagem.model.Lanche;
import br.edu.fa7.controle_passagem.model.Local;
import br.edu.fa7.controle_passagem.model.Piloto;
import br.edu.fa7.controle_passagem.util.GeradorDeAssento;

public class CargaInicial {

	public static void main(String[] args) throws Exception {

		Session session = HibernateFactory.getHibernateSession();
		session.beginTransaction();

		CompanhiaAereaDao caDao = new CompanhiaAereaDao(session);

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

		AviaoDao aviDao = new AviaoDao(session);
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

				GeradorDeAssento gerarAssento = new GeradorDeAssento(av, new AssentoDao(session));
				gerarAssento.gerarAssentos();
			}
		}

		LocalDao locDao = new LocalDao(session);
		String[] locais = { "FORTALEZA", "RECIFE", "NATAL", "ARACAJÚ",
				"SALVADOR", "RIO DE JANEIRO", "SÃO PAULO", "CAMPINAS",
				"FOZ DO IGUAÇU", "GRAMADOS", "FLORIANOPÓLIS" };
		for (int j = 0; j < locais.length; j++) {
			Local local = new Local();
			local.setNome(locais[j]);
			locDao.salvar(local);
		}
		
		LancheDao lancheDao = new LancheDao(session);
		String[] lanches = { "HAMBUGER", "SALADA", "SALGADO"};
		for (int j = 0; j < lanches.length; j++) {
			Lanche lanche = new Lanche();
			lanche.setNome(lanches[j]);
			lanche.setPreco(new BigDecimal(5.50));
			lancheDao.salvar(lanche);
		}
		
		PilotoDao pilotoDao = new PilotoDao(session);
		Piloto piloto = new Piloto();
		piloto.setCht("123456");
		piloto.setCpf("14725836912");
		piloto.setNome("José");
		pilotoDao.salvar(piloto);
		
		Piloto piloto1 = new Piloto();
		piloto1.setCht("654321");
		piloto1.setCpf("36925814778");
		piloto1.setNome("João");
		pilotoDao.salvar(piloto1);
		
		

		FuncionarioDao funDao = new FuncionarioDao(session);

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
