package br.edu.fa7.controle_passagem.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "piloto")
@PrimaryKeyJoinColumn(name="pes_id")
public class Piloto extends Pessoa implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3742179521600451256L;
	
	@Column(name = "pil_cht")
    @Basic(optional = false)
	private String cht;

	public String getCht() {
		return cht;
	}

	public void setCht(String cht) {
		this.cht = cht;
	}
}