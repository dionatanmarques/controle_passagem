package br.edu.fa7.controle_passagem.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.edu.fa7.controle_passagem.dao.AssentoDao;
import br.edu.fa7.controle_passagem.model.Assento;
import br.edu.fa7.controle_passagem.model.Aviao;

public class GeradorDeAssento {

	private AssentoDao dao;
	private Aviao aviao;
	private final String[] colunasArea1 = { "A", "B", "E", "F" };
	private final String[] colunasArea2 = { "A", "B", "C", "D", "E", "F" };
	private int[] intervaloArea1 = { 1, 3 };
	private int[] primeiroIntervaloArea2 = { 5, 10 };
	private int[] segundoIntervaloArea2 = { 17, 29 };
	private HashMap<String, Integer> areaSemAcento;
	List<Assento> assentos;

	public GeradorDeAssento(Aviao aviao, AssentoDao dao) {
		this.aviao = aviao;
		this.dao = dao;
		areaSemAcento = new HashMap<String, Integer>();
		areaSemAcento.put("A", 17);
		areaSemAcento.put("F", 17);
		assentos = new ArrayList<Assento>();
	}

	public void gerarAssentos() {
		gerarArea(intervaloArea1, colunasArea1);
		gerarArea(primeiroIntervaloArea2, colunasArea2);
		gerarArea(segundoIntervaloArea2, colunasArea2);
		salvarTodo();
		
	}

	private void gerarArea(int[] intervalo, String[] colunas) {
		for (int i = intervalo[0]; i <= intervalo[1]; i++) {
			for (int j = 0; j < colunas.length; j++) {
				if (!(areaSemAcento.containsKey(colunas[j]) 
						&& areaSemAcento.containsValue(i))) {
					Assento assento = new Assento();
					assento.setAviao(aviao);
					assento.setNome(colunas[j] + i);
					assentos.add(assento);
				}
			}
		}
	}
	
	private void salvarTodo(){
		for (Assento assento : assentos) {
			dao.salvar(assento);
		}
	}

}
