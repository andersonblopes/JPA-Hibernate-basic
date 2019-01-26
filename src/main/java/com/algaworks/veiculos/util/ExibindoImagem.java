package com.algaworks.veiculos.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.algaworks.veiculos.dominio.Veiculo;

public class ExibindoImagem {
	
	public static void main(String[] args) throws IOException {
		EntityManager manager = JpaUtil.getEntityManager();
		Veiculo veiculo = manager.find(Veiculo.class, 1L);
		
		if(veiculo != null && veiculo.getFoto() != null){
			BufferedImage image = ImageIO.read(new ByteArrayInputStream(veiculo.getFoto()));
			JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(image)));
		}else{
			System.out.println("Veículo não posui foto.");
		}
		manager.close();
		JpaUtil.close();
	}

}
