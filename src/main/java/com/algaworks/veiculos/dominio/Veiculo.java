package com.algaworks.veiculos.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.algaworks.veiculos.util.TipoCombustivel;

@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 6988843590835066781L;

	//Uso de chave primária composta
	//private VeiculoId id;

	private long codigo;
	private String fabricante;
	private String modelo;
	private Integer anoFabricacao;
	private Integer anoModelo;
	private BigDecimal valor;
	private TipoCombustivel tipoCombustivel;
	private Date dataCadastro;
	private String especificacoes;
	private byte[] foto;
	private Proprietario proprietario;
	private Set<Acessorio> acessorio = new HashSet<>();

	@Id
	@Column(columnDefinition = "serial", name = "pkveiculo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	/*
	 *Uso de chave primária composta
	 *@EmbeddedId
	 *public VeiculoId getId() {
		return id;
	}

	public void setId(VeiculoId id) {
		this.id = id;
	} 
	 */
	
	@Column(length = 60, nullable = false)
	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	@Column(length = 60, nullable = false)
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Column(name = "ano_fabricacao", nullable = false)
	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	@Column(name = "ano_modelo", nullable = false)
	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	@Column(precision = 10, scale = 2, nullable = true)
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Column(name = "tipo_combustivel", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false)
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	//Texto de tamanho indefinido
	@Column(columnDefinition = "TEXT")
	public String getEspecificacoes() {
		return especificacoes;
	}

	public void setEspecificacoes(String especificacoes) {
		this.especificacoes = especificacoes;
	}

	
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	// uso de objeto enbutido: @Embedded
	@ManyToOne
	@JoinColumn(name = "fkproprietario")
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	@ManyToMany
	@JoinTable(name = "rel_veiculo_acessorios", 
		joinColumns = @JoinColumn(name = "fkveiculo"),
		inverseJoinColumns = @JoinColumn(name = "pkacessorio"))
	public Set<Acessorio> getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Set<Acessorio> acessorio) {
		this.acessorio = acessorio;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	//Método de negócio
	@Transient
	public String getDescricao() {
		return this.getFabricante() + " " + this.getModelo() + " " + this.getAnoFabricacao() + "/" + this.getAnoModelo() + " por apenas " + this.getValor(); 
	}

}
