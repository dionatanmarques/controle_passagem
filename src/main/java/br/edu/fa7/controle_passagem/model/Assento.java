package br.edu.fa7.controle_passagem.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "assento")
@SequenceGenerator(name = "assento_id_generator", sequenceName = "assento_id_seq")
public class Assento implements Serializable {

	private static final long serialVersionUID = 2444688172105901750L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assento_id_generator")
	private Integer id;

	@Basic(optional = false)
	@NotNull(message = "nome não pode ser nulo")
	@NotEmpty(message = "nome não pode esta vazio")
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_aviao", nullable = false)
	private Aviao aviao;

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

	public Aviao getAviao() {
		return this.aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

	@Override
	public String toString() {
		String s = this.getClass().getSimpleName() + " - id: " + getId() + "\n";
		return s;
	}
}