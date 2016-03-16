package br.edu.fa7.controle_passagem.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="companhia_aerea")
@SequenceGenerator(name="SEQUENCE", sequenceName="companhia_id_seq")
public class CompanhiaAerea implements Serializable {

	private static final long serialVersionUID = 4854022562608526175L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQUENCE")
	@Column(name="coa_id")
	private Integer id;
	
	@Column(name = "coa_nome")
    @Basic(optional = false)
	private String nome;

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
}