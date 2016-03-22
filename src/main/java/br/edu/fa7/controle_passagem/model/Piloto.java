package br.edu.fa7.controle_passagem.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "piloto")
@PrimaryKeyJoinColumn(name = "id_pessoa")
public class Piloto extends Pessoa implements Serializable {

	private static final long serialVersionUID = -8225549709161298425L;

	@Basic(optional = false)
	@NotNull(message = "CHT não pode ser nulo")
	@NotEmpty(message = "CHT não pode esta vazio")
	private String cht;

	public String getCht() {
		return this.cht;
	}

	public void setCht(String cht) {
		this.cht = cht;
	}
}