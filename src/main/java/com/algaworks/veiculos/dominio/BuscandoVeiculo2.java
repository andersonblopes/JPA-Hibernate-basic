package com.algaworks.veiculos.dominio;

import javax.persistence.EntityManager;

import com.algaworks.veiculos.util.JpaUtil;

public class BuscandoVeiculo2 {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Veiculo veiculo = manager.getReference(Veiculo.class, 1l);
		System.out.println("Ve�culo de c�digo: " + veiculo.getCodigo() + " � um " + veiculo.getModelo());
		manager.close();
		JpaUtil.close();
	}

}
