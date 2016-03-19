package br.edu.fa7.controle_passagem.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name="id_pessoa")
public class Funcionario extends Pessoa {

	private static final long serialVersionUID = -4582232405871301402L;
	
	@Basic(optional=false)
	private String senha;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
