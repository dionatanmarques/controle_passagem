package br.edu.fa7.controle_passagem.model;

import java.util.List;

public class ControlePassagem {

	private Integer id;
	private String nome;
	private List<Aviao> avioes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aviao> getAvioes() {
		return avioes;
	}

	public void setAvioes(List<Aviao> avioes) {
		this.avioes = avioes;
	}
}