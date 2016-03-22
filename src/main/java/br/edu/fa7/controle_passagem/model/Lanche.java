package br.edu.fa7.controle_passagem.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "lanche")
@SequenceGenerator(name = "lanche_id_generator", sequenceName = "lanche_id_seq")
public class Lanche implements Serializable {

	private static final long serialVersionUID = -6654575878872952034L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lanche_id_generator")
	private Integer id;

	@NotNull(message = "nome não pode ser nulo")
	@NotEmpty(message = "nome não pode esta vazio")
	@Basic(optional = false)
	private String nome;

	@Column(scale = 2, precision = 15)
	@Basic(optional = false)
	private BigDecimal preco;

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

	public BigDecimal getPreco() {
		return this.preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}