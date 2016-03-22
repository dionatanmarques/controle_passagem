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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "lanche")
@SequenceGenerator(name = "SEQUENCE", sequenceName = "lanche_id_seq")
public class Lanche implements Serializable {

	private static final long serialVersionUID = 9009896738843915423L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQUENCE")
	private Integer id;

	@NotNull(message="nome não pode ser nulo")
	@NotEmpty(message="nome não pode esta vazio")
	@Basic(optional = false)
	private String nome;
	
	@Column(scale=2, precision=15)
	@Basic(optional = false)
	private BigDecimal preco;

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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}