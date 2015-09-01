package com.algaworks.veiculos.dominio;

import java.io.Serializable;

import javax.persistence.Embeddable;

//Classe criada para demostração de uso de chave composta no JPA
@Embeddable
public class VeiculoId implements Serializable {

	private static final long serialVersionUID = 1L;

	private String placa;
	private String cidade;

	public VeiculoId() {

	}

	public VeiculoId(String placa, String cidade) {
		super();
		this.placa = placa;
		this.cidade = cidade;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
}
