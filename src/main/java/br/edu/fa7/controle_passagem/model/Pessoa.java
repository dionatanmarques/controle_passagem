package br.edu.fa7.controle_passagem.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@SequenceGenerator(name = "pessoa_id_generator", sequenceName = "pessoa_id_seq")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = -5844168005591893705L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_id_generator")
	private Integer id;

	@Basic(optional = false)
	@NotNull(message = "cpf não pode ser nulo")
	@NotEmpty(message = "cpf não pode esta vazio")
	private String cpf;

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

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}