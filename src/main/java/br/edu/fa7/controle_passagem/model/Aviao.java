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
@Table(name = "aviao")
@SequenceGenerator(name = "aviao_id_generator", sequenceName = "aviao_id_seq")
public class Aviao implements Serializable {

	private static final long serialVersionUID = 4842733333188668037L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aviao_id_generator")
	private Integer id;

	@Basic(optional = false)
	@NotNull(message="nome não pode ser nulo")
	@NotEmpty(message="nome não pode esta vazio")
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_companhia_aerea", nullable = false)
	private CompanhiaAerea companhia;

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

	public CompanhiaAerea getCompanhia() {
		return this.companhia;
	}

	public void setCompanhia(CompanhiaAerea companhia) {
		this.companhia = companhia;
	}
}