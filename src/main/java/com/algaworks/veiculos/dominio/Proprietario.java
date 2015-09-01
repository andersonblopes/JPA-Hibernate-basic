package com.algaworks.veiculos.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proprietario")
public class Proprietario {

	private long codigo;
	private String nome;
	private String telefoone;
	private String email;
	
	private List<Veiculo> veiculos; 

	@Id
	@Column(columnDefinition = "serial", name = "pkproprietario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	@Column(length = 60, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(length = 60, nullable = false)
	public String getTelefoone() {
		return telefoone;
	}

	public void setTelefoone(String telefoone) {
		this.telefoone = telefoone;
	}

	@Column(length = 255)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy = "proprietario")
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
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
