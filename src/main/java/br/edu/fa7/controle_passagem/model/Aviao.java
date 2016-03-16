package br.edu.fa7.controle_passagem.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="aviao")
@SequenceGenerator(name="SEQUENCE", sequenceName="aviao_id_seq")
public class Aviao implements Serializable {

	
	private static final long serialVersionUID = 7245709087922444742L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQUENCE")
	@Column(name="avi_id")
	private Integer id;
	
    @Column(name = "avi_nome")
    @Basic(optional = false)
	private String nome;
	
    
	private List<Assento> assentos;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="coa_id",nullable = false)    
	private CompanhiaAerea companhia;

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

	public List<Assento> getAssentos() {
		return assentos;
	}

	public void setAssentos(List<Assento> assentos) {
		this.assentos = assentos;
	}

	public CompanhiaAerea getCompanhia() {
		return companhia;
	}

	public void setCompanhia(CompanhiaAerea companhia) {
		this.companhia = companhia;
	}
}