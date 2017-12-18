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

		if (this.ecran.equals("ACCUEIL")) {
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
	}
}
