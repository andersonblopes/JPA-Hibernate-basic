package com.algaworks.veiculos.dominio;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.algaworks.veiculos.util.JpaUtil;

public class BuscandoVeiculo3 {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();

		Veiculo veiculo = manager.getReference(Veiculo.class, 1l);

		System.out.println("Bucando veículo, será que já executou o select?");

		System.out.println("Veículo de código: " + veiculo.getCodigo() + " é um " + veiculo.getModelo());
		
		System.out.println("Veículo: " + veiculo.getModelo());
		System.out.println("-------"); 
		System.out.println(veiculo.getEspecificacoes());
		
		//Mostrando a foto do veículo
		if(veiculo.getFoto() != null){
			BufferedImage image;
			try {
				image = ImageIO.read(new ByteArrayInputStream(veiculo.getFoto()));
				JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(image)));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else{
			System.out.println("Veículo não posui foto.");
		}
		
		System.out.println("Veículo: " + veiculo.getModelo());
		for (Acessorio acessorio : veiculo.getAcessorio()) {
			System.out.println("Acessório: " + acessorio.getDescricao()); }

		
		manager.close();
		JpaUtil.close();
	}

}
