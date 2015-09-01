package com.algaworks.veiculos.dominio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.algaworks.veiculos.util.JpaUtil;

public class ExcluindoVeiculo {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		
		Veiculo veiculo = manager.find(Veiculo.class, 1l);
		
		manager.remove(veiculo);
		
		transaction.commit();
		manager.close();
		JpaUtil.close();
	}

}
