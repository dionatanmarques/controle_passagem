package br.edu.fa7.controle_passagem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="companhia_aerea")
@SequenceGenerator(name="companhia_aerea_id_generator", sequenceName="companhia_aerea_id_seq")
public class CompanhiaAerea implements Serializable {

	private static final long serialVersionUID = -8349999902516526488L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="companhia_aerea_id_generator")
	private Integer id;

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

	@Override
	public String toString() {
		String s = this.getClass().getSimpleName() + " - id: " + getId() + "\n";
		return s;
	}
}