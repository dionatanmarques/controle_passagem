package br.edu.fa7.controle_passagem.util;

import java.util.Date;

public class PesquisaVoo {
	
	private boolean tipoIdaVolta;
	private boolean tipoIda;
	private int origem;
	private int destino;
	private Date dataIda;
	private Date dataVolta;
	public boolean isTipoIdaVolta() {
		return tipoIdaVolta;
	}
	public void setTipoIdaVolta(boolean tipoIdaVolta) {
		this.tipoIdaVolta = tipoIdaVolta;
	}
	public boolean isTipoIda() {
		return tipoIda;
	}
	public void setTipoIda(boolean tipoIda) {
		this.tipoIda = tipoIda;
	}
	public int getOrigem() {
		return origem;
	}
	public void setOrigem(int origem) {
		this.origem = origem;
	}
	public int getDestino() {
		return destino;
	}
	public void setDestino(int destino) {
		this.destino = destino;
	}
	public Date getDataIda() {
		return dataIda;
	}
	public void setDataIda(Date dataIda) {
		this.dataIda = dataIda;
	}
	public Date getDataVolta() {
		return dataVolta;
	}
	public void setDataVolta(Date dataVolta) {
		this.dataVolta = dataVolta;
	}

}
