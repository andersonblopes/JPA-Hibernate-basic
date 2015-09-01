package com.algaworks.veiculos.dominio;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.algaworks.veiculos.util.JpaUtil;

public class ListandoVeiculo {
	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();

		List<Veiculo> veiculos = manager.createQuery("from Veiculo",Veiculo.class).getResultList();

		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getCodigo() + " - " + veiculo.getFabricante() + " " + veiculo.getModelo()
					+ ", ano " + veiculo.getAnoFabricacao() + "/" + veiculo.getAnoModelo() + " por " + "R$ "
					+ veiculo.getValor());
			
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
				System.out.println("Veículo não posui foto na pasta.");
			}
		}
		manager.close();
		JpaUtil.close();
	}
}
