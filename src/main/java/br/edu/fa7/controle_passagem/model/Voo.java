package br.edu.fa7.controle_passagem.model;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="voo")
@SequenceGenerator(name="SEQUENCE", sequenceName="voo_id_seq")
public class Voo implements Serializable {

	private static final long serialVersionUID = -2093323231173103850L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQUENCE")
	@Column(name="voo_id")
	private Integer id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="org_loc_id",nullable = false)
	private Local localOrigem;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="des_loc_id",nullable = false)
	private Local localDestino;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="avi_id",nullable = false)
	private Aviao aviao;
	
	@Temporal(TemporalType.DATE)
	@Basic(optional=false)
	@Column(name="voo_data_embarque")
	private Date dataEmbarque;
	
	@Temporal(TemporalType.DATE)
	@Basic(optional=false)
	@Column(name="voo_data_desembarque")
	private Date dataDesembarque;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Local getLocalOrigem() {
		return localOrigem;
	}

	public void setLocalOrigem(Local localOrigem) {
		this.localOrigem = localOrigem;
	}

	public Local getLocalDestino() {
		return localDestino;
	}

	public void setLocalDestino(Local localDestino) {
		this.localDestino = localDestino;
	}

	public Aviao getAviao() {
		return aviao;
	}

	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}

	public Date getDataEmbarque() {
		return dataEmbarque;
	}

	public void setDataEmbarque(Date dataEmbarque) {
		this.dataEmbarque = dataEmbarque;
	}

	public Date getDataDesembarque() {
		return dataDesembarque;
	}

	public void setDataDesembarque(Date dataDesembarque) {
		this.dataDesembarque = dataDesembarque;
	}
}