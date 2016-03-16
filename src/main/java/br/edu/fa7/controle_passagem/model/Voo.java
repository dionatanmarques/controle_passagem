package br.edu.fa7.controle_passagem.model;

import java.util.Date;

public class Voo {

	private Integer id;
	private Local localOrigem;
	private Local localDestino;
	private Aviao aviao;
	private Date dataEmbarque;
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