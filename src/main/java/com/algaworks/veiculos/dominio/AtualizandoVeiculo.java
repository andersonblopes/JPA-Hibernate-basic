package com.algaworks.veiculos.dominio;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.veiculos.util.JpaUtil;

public class AtualizandoVeiculo {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();

		Veiculo veiculo = manager.getReference(Veiculo.class, 1l);

		System.out.println("Valor atual: " + veiculo.getValor());
		veiculo.setValor(veiculo.getValor().add(new BigDecimal(500)));
		System.out.println("Novo valor: " + veiculo.getValor());

		transaction.commit();
		manager.close();
		JpaUtil.close();
	}

}
