package com.oc.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
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

	private char[] tableAlphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	private ArrayList<JButton> boutonsAlphabet = new ArrayList<JButton>();

	private Panneau pan = new Panneau();

	private EcranListener eListener = new EcranListener();

	public Fenetre() {
		this.setTitle("Le Pendu");
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		initMenu();

		initBoutons();

		this.getContentPane().add(pan, BorderLayout.CENTER);

		this.setVisible(true);
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

	private void initBoutons() {
		System.out.println(this.tableAlphabet.length);
		for (int i = 0 ; i <26 ; i++) {
			this.boutonsAlphabet.add(new JButton(String.valueOf(this.tableAlphabet[i])));
		}
	}
	
	private void nouvellePartie() {
		
		this.getContentPane().removeAll();
		pan.setLayout(new BorderLayout());
		pan.setEcran("JEU");
		this.getContentPane().add(pan, BorderLayout.CENTER);
		this.setContentPane(pan);
		
		JPanel boutons = new JPanel();
		boutons.setBackground(Color.white);
		
		for (JButton b : this.boutonsAlphabet) {
			boutons.add(b);
		}
		pan.add(boutons, BorderLayout.CENTER);
		pan.revalidate();
	}

	public class EcranListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String texte = ((JMenuItem)e.getSource()).getText();

			if (texte.equals("Nouveau"))
				nouvellePartie();
			else if (texte.equals("Scores"))
				pan.setEcran("SCORES");
			else if (texte.equals("Regles"))
				pan.setEcran("REGLES");
			else if (texte.equals("?"))
				pan.setEcran("INFOS");

			pan.repaint();
		}
	}
}
