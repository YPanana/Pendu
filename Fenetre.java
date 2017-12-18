package com.oc.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

public class Fenetre extends JFrame {

	private Panneau pan = new Panneau();
	
	public Fenetre() {
		this.setTitle("Le Pendu");
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		this.getContentPane().add(pan, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
}
