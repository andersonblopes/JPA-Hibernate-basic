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

		System.out.println("Bucando ve�culo, ser� que j� executou o select?");

		System.out.println("Ve�culo de c�digo: " + veiculo.getCodigo() + " � um " + veiculo.getModelo());
		
		System.out.println("Ve�culo: " + veiculo.getModelo());
		System.out.println("-------"); 
		System.out.println(veiculo.getEspecificacoes());
		
		//Mostrando a foto do ve�culo
		if(veiculo.getFoto() != null){
			BufferedImage image;
			try {
				image = ImageIO.read(new ByteArrayInputStream(veiculo.getFoto()));
				JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(image)));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else{
			System.out.println("Ve�culo n�o posui foto.");
		}
		
		System.out.println("Ve�culo: " + veiculo.getModelo());
		for (Acessorio acessorio : veiculo.getAcessorio()) {
			System.out.println("Acess�rio: " + acessorio.getDescricao()); }

		
		manager.close();
		JpaUtil.close();
	}

}
