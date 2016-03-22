package br.edu.fa7.controle_passagem.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@SequenceGenerator(name = "local_id_generator", sequenceName = "local_id_seq")
public class Local implements Serializable {

	private static final long serialVersionUID = -8489148787239553658L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "local_id_generator")
	private Integer id;

	@Basic(optional = false)
	@NotNull(message = "nome não pode ser nulo")
	@NotEmpty(message = "nome não pode esta vazio")
	private String nome;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}