package com.oc.vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.io.File;
import java.io.IOException;
import java.text.AttributedString;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Panneau extends JPanel {

	private char[] tableAlphabet;
	private ArrayList<JButton> boutonsAlphabet = new ArrayList<JButton>();
	private String ecran = "ACCUEIL";

	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		if (this.ecran.equals("ACCUEIL"))
			ecranAccueil(g);
		else if (this.ecran.equals("REGLES"))
			ecranRegles(g);
		else if (this.ecran.equals("INFOS"))
			ecranInfos(g);
	}
	
	public void setEcran(String ecran) {
		this.ecran = ecran;
	}

	private void ecranAccueil(Graphics g) {
		g.setFont(new Font("Tahoma", Font.BOLD, 20));
		g.setColor(Color.black);
		g.drawString("Bienvenue dans le jeu du Pendu !", 175, 50);

		try {
			Image img = ImageIO.read(new File("images/pendu.jpg"));
			g.drawImage(img, 100, 75, this);
		} catch (IOException e) {
			System.out.println("Probleme de lecture de l'image ! : " + e.getMessage());
		}

		g.setFont(new Font("Tahoma", Font.BOLD, 14));
		String str1 = "Vous avez 7 coups pour trouver le mot cache. Si vous reussissez... et bien on recommence !",
				str2 = "Plus vous avez trouve de mots, plus vous gagnez de points ! A vous de jouer !",
				str3 = "PROVERBE : 'Pas vu pas pris.",
				str4 = "Pris, PENDU !'";

		g.drawString(str1, 50, 525);
		g.drawString(str2, 50, 540);
		g.drawString(str3, 50, 570);
		g.drawString(str4, 145, 585);
	}

	private void ecranRegles(Graphics g) {
		g.setFont(new Font("Tahoma", Font.BOLD, 20));
		g.setColor(Color.black);
		g.drawString("Le jeu du Pendu :", 250, 50);
		
		String str1 = "Vous avez 7 coups pour trouver le mot cache. Si vous reussissez... et bien on recommence !",
			   str2 = "Plus vous avez trouve de mots, plus vous gagnez de points ! A vous de jouer !";
		
		g.setFont(new Font("Tahoma", Font.BOLD, 14));
		g.drawString(str1, 25, 100);
		g.drawString(str2, 25, 115);
		
		g.drawString("COMPTE DES POINTS :", 25, 155);
		g.drawString("Mot trouve sans erreur:............100Pts", 100, 195);
		g.drawString("Mot trouve avec 1 erreur:...........50Pts", 100, 210);
		g.drawString("Mot trouve avec 2 erreurs:..........35Pts", 100, 225);
		g.drawString("Mot trouve avec 3 erreurs:..........25Pts", 100, 240);
		g.drawString("Mot trouve avec 4 erreurs:..........15Pts", 100, 255);
		g.drawString("Mot trouve avec 5 erreurs:..........10Pts", 100, 270);
		g.drawString("Mot trouve avec 6 erreurs:............5Pts", 100, 285);
		
		g.drawString("Je vous souhaite bien du plaisir...", 25, 325);
		
		String str3 = "Et, si vous pensez pouvoir trouver un mot en un coup, c'est que vous pensez que le dictionnaire",
			   str4 = "est petit !",
			   str5 = "Or, pour votre information, il comprend plus de 336 000 mots... Donc bonne chance !! ;)";
		
		g.drawString(str3, 25, 340);
		g.drawString(str4, 25, 355);
		g.drawString(str5, 25, 370);
		
		
	}
	
	private void ecranInfos (Graphics g) {
		g.setFont(new Font("Tahoma", Font.BOLD, 40));
		g.setColor(Color.black);
		g.drawString("Le Pendu !", 250, 50);
		
		g.setFont(new Font("Tahoma", Font.BOLD, 20));
		g.drawString("Edite par : cysboy, OpenClassrooms.com", 25, 90);
		g.drawString("Developpe par : panana, PananaUnlimited technologies and co.", 25, 130);
		
		try {
			Image img = ImageIO.read(new File("images/panana.jpg"));
			g.drawImage(img, 150, 170, this);
		} catch (IOException e) {
			System.out.println("Probleme de lecture de l'image ! : " + e.getMessage());
		}
		
		g.drawString("Copyright 2017", 250, 600);
	}
}
