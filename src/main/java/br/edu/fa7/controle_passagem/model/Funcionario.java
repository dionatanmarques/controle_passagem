package br.edu.fa7.controle_passagem.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name="id_pessoa")
public class Funcionario extends Pessoa {

	private static final long serialVersionUID = -4582232405871301402L;
	
	@Basic(optional=false)
	@NotNull(message="senha não pode ser nulo")
	@NotEmpty(message="senha não pode esta vazio")
	private String senha;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		String s = this.getClass().getSimpleName() + " - id: " + getId() + "\n";
		return s;
	}
}