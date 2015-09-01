package com.algaworks.veiculos.util;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Proprietario {

	private String nome;
	private String telefoone;
	private String email;

	@Column(name = "nome_proprietario", nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "telefone_proprietario", nullable = false)
	public String getTelefoone() {
		return telefoone;
	}

	public void setTelefoone(String telefoone) {
		this.telefoone = telefoone;
	}

	@Column(name = "email_proprietario")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
