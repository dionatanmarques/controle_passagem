package br.edu.fa7.controle_passagem.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "checkin")
@SequenceGenerator(name = "SEQUENCE", sequenceName = "checkin_id_seq")
public class CheckIn implements Serializable {

	private static final long serialVersionUID = -4732295406040363014L;

	private Passagem passagem;

	private Assento assento;

	public Passagem getPassagem() {
		return passagem;
	}

	public void setPassagem(Passagem passagem) {
		this.passagem = passagem;
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}
}