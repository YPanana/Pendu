package com.oc.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Fenetre extends JFrame {

	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu fichier = new JMenu("Fichier");
	private JMenu aPropos = new JMenu("A propos");
	
	private JMenuItem nouveau = new JMenuItem("Nouveau");
	private JMenuItem scores = new JMenuItem("Scores");
	private JMenuItem regles = new JMenuItem("Regles");
	private JMenuItem quitter = new JMenuItem("Quitter");
	private JMenuItem infos = new JMenuItem("?");
	
	private Panneau pan = new Panneau();
	
	private EcranListener eListener = new EcranListener();
	
	public Fenetre() {
		this.setTitle("Le Pendu");
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		initMenu();
		
		this.getContentPane().add(pan, BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public void actualiserAffichage() {
		this.getContentPane().removeAll();
		this.getContentPane().revalidate();
	}
	
	private void initMenu() {
		
		nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		nouveau.addActionListener(eListener);
		fichier.add(nouveau);
		
		scores.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
		scores.addActionListener(eListener);
		fichier.add(scores);
		
		regles.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_DOWN_MASK));
		regles.addActionListener(eListener);
		fichier.add(regles);
		
		fichier.addSeparator();
		
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		fichier.add(quitter);
		
		infos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_DOWN_MASK));
		infos.addActionListener(eListener);
		aPropos.add(infos);
		
		fichier.setMnemonic('F');
		aPropos.setMnemonic('A');
		
		menuBar.add(fichier);
		menuBar.add(aPropos);
		
		this.setJMenuBar(menuBar);
	}
	
	public class EcranListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String texte = ((JMenuItem)e.getSource()).getText();
			
			if (texte.equals("Nouveau"))
				pan.setEcran("JEU");
			else if (texte.equals("Scores"))
				pan.setEcran("SCORES");
			else if (texte.equals("Regles"))
				pan.setEcran("REGLES");
			else if (texte.equals("?"))
				pan.setEcran("INFOS");
			
			actualiserAffichage();
		}
	}
}
