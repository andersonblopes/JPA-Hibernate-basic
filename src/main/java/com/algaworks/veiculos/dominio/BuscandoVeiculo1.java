package com.algaworks.veiculos.dominio;

import javax.persistence.EntityManager;

import com.algaworks.veiculos.util.JpaUtil;

public class BuscandoVeiculo1 {

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Veiculo veiculo = manager.find(Veiculo.class, 2L);
		System.out.println("Ve�culo de c�digo " + veiculo.getCodigo() + " � um " + veiculo.getModelo());
		manager.close();
		JpaUtil.close();
	}

}
