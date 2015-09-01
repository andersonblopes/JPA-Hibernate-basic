package com.algaworks.veiculos.dominio;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.veiculos.util.JpaUtil;
import com.algaworks.veiculos.util.TipoCombustivel;

public class PersistindoVeiculo {

	public static void main(String[] args) throws IOException {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		// instancia acessórios
		Acessorio alarme = new Acessorio();
		alarme.setDescricao("Alarme");
		Acessorio arCondicionado = new Acessorio();
		arCondicionado.setDescricao("Ar condicionado");
		Acessorio bancosDeCouro = new Acessorio();
		bancosDeCouro.setDescricao("Bancos de couro");
		Acessorio direcaoHidraulica = new Acessorio();
		direcaoHidraulica.setDescricao("Direção hidráulica");

		// persiste acessórios
		manager.persist(alarme);
		manager.persist(arCondicionado);
		manager.persist(bancosDeCouro);
		manager.persist(direcaoHidraulica);

		StringBuilder especificacoes = new StringBuilder();
		especificacoes.append("Carro em excelente estado.\n");
		especificacoes.append("Completo, menos ar.\n");
		especificacoes.append("Primeiro dono, com manual de instrução ");
		especificacoes.append("e todas as revisões feitas.\n");
		especificacoes.append("IPVA pago, aceita financiamento.");

		// Ler foto do arquivo
		Path path = FileSystems.getDefault().getPath("D:/projetos/img/hb20.jpg");
		byte[] foto = Files.readAllBytes(path);

		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Anderson Lopes");
		proprietario.setTelefoone("(85) 99958-5404");
		proprietario.setEmail("anderson.lopes.2010@gmail.com");

		manager.persist(proprietario);

		Veiculo veiculo = new Veiculo();
		veiculo.setFabricante("HYUNDAY");
		veiculo.setModelo("HB20");
		veiculo.setAnoFabricacao(2015);
		veiculo.setAnoModelo(2016);
		veiculo.setValor(new BigDecimal(121_700));
		veiculo.setTipoCombustivel(TipoCombustivel.GASOLINA);
		veiculo.setDataCadastro(new Date());
		veiculo.setEspecificacoes(especificacoes.toString());
		veiculo.setFoto(foto);
		veiculo.setProprietario(proprietario);
		veiculo.getAcessorio().add(direcaoHidraulica);
		veiculo.getAcessorio().add(alarme);

		manager.persist(veiculo);

		// Ler foto do arquivo
		path = FileSystems.getDefault().getPath("D:/projetos/img/ix35.jpg");
		foto = Files.readAllBytes(path);

		Veiculo veiculo1 = new Veiculo();
		veiculo1.setFabricante("HYUNDAY");
		veiculo1.setModelo("ix35");
		veiculo1.setAnoFabricacao(2006);
		veiculo1.setAnoModelo(2006);
		veiculo1.setValor(new BigDecimal(111_000));
		veiculo1.setTipoCombustivel(TipoCombustivel.GASOLINA);
		veiculo1.setDataCadastro(new Date());
		veiculo1.setFoto(foto);
		veiculo1.setProprietario(proprietario);
		veiculo1.getAcessorio().add(arCondicionado);
		veiculo1.getAcessorio().add(bancosDeCouro);

		manager.persist(veiculo1);

		Veiculo veiculo2 = new Veiculo();

		// Ler foto do arquivo
		path = FileSystems.getDefault().getPath("D:/projetos/img/sf.jpg");
		foto = Files.readAllBytes(path);

		veiculo2.setFabricante("HYUNDAY");
		veiculo2.setModelo("Santa Fé");
		veiculo2.setAnoFabricacao(2015);
		veiculo2.setAnoModelo(2016);
		veiculo2.setValor(new BigDecimal(127_200));
		veiculo2.setTipoCombustivel(TipoCombustivel.BICOMBUSTIVEL);
		veiculo2.setDataCadastro(new Date());
		veiculo2.setFoto(foto);
		veiculo2.setProprietario(proprietario);
		veiculo2.getAcessorio().add(direcaoHidraulica);
		veiculo2.getAcessorio().add(bancosDeCouro);
		veiculo2.getAcessorio().add(alarme);
		veiculo2.getAcessorio().add(arCondicionado);

		manager.persist(veiculo2);

		tx.commit();
		JpaUtil.close();
	}

}
