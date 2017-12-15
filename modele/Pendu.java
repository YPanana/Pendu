package com.oc.modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pendu {

	private File dictionnaire = new File("dictionnaire.txt");
	private String motSecret = "";
	private int[] lettresTrouvees;
	private boolean trouve = false;
	private int nbErreurs = 0;
	private Classement classement = new Classement();

	public void nouvellePartie() {

		Scanner sc = new Scanner(System.in);
		char lettre;
		
		System.out.println("Lancement d'une nouvelle partie...");
		piocherMotDico();
		System.out.println("Choix du mot cache effectue ! On commence !");

		//Boucle de partie
		while (!trouve && nbErreurs < 7) {

			/* TO DO :
			 * 1) Afficher le mot mystere en remplacant tous les caracteres par '*'
			 * 2) Inviter le joueur a entrer une lettre
			 * 3) Verifier si elle est presente dans le mot
			 * 4a) Si oui, reveler sa position
			 * 4b) Si non, commencer dessin du pendu (incrementer compteur d'erreur)
			 * 5) Si le joueur trouve le mot (nbErreurs < 7), on calcule son score.
			 * 6) Si il est dans le top 10, on lui demande un pseudo et on enregistre son score
			 * 7) Sinon au revient au menu principal
			 */
			afficherMotSecret();
			System.out.println("Nombre d'erreurs : " + this.nbErreurs + "/7");
			System.out.println("Veuillez entrer une lettre : ");
			lettre = sc.nextLine().toUpperCase().charAt(0);
			
			if (lettreCorrecte(lettre)) {
				System.out.println("Bravo ! Le mot cache contient bien la lettre " + lettre + " !");
			}
			else {
				System.out.println("Aie ! La lettre " + lettre + " n'est pas contenue dans le mot secret !");
				nbErreurs++;
			}
		}
		
		if (trouve) {
			System.out.println("Bravo vous avez trouve le mot cache en faisant " + nbErreurs + " erreurs ! Il s'agissait bien du mot " + this.motSecret.toUpperCase());
			int score = calculScore(this.nbErreurs);
			
			if (classement.checkTop10(score)) {
				System.out.println("--Nouveau top score !");
				System.out.println("--Veuillez entrer votre nom : ");
				String nomJoueur = sc.nextLine();
				Joueur j = new Joueur();
				j.setNomJoueur(nomJoueur);
				j.setScore(score);
				classement.ajouterJoueur(j);
				System.out.println(this.classement);
			}
		}
		else {
			System.out.println("Dommage vous n'avez pas reussi a trouver le mot cache. Il s'agissait du mot " + this.motSecret.toUpperCase());
		}
	}

	private void piocherMotDico() {
		try {
			//Flux pour lire notre fichier
			FileReader fr = new FileReader(this.dictionnaire);
			LineNumberReader lnr = new LineNumberReader(fr);

			//Choix d'un num. de ligne au hasard
			int nbre = (int)(Math.random()*336529);

			//Parcours du dico jusqu'a la ligne choisie
			while (lnr.getLineNumber() < nbre)
				lnr.readLine();

			//Sauvegarde du mot a cette ligne
			String temp = lnr.readLine();
			this.motSecret = temp;

			this.lettresTrouvees = new int[temp.length()];
			for (int i = 0 ; i < lettresTrouvees.length ; i++) {
				lettresTrouvees[i] = 0;
			}

			//On ferme nos flux
			fr.close();
			lnr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Fichier dictionnaire non trouve !");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de lecture dans le dictionnaire !");
		}
	}

	private void afficherMotSecret() {
		char[] tabCar = this.motSecret.toUpperCase().toCharArray();

		for (int i = 0 ; i < tabCar.length ; i++) {
			if (this.lettresTrouvees[i] == 0) {
				tabCar[i] = '*';
			}
			System.out.print(tabCar[i]);
		}
		System.out.print("\n");
	}
	
	private boolean lettreCorrecte(char lettre) {
		char[] tabCar = this.motSecret.toUpperCase().toCharArray();
		boolean trouve = false;
		
		for (int i = 0 ; i < tabCar.length ; i++) {
			if (tabCar[i] == lettre) {
				this.lettresTrouvees[i] = 1;
				trouve = true;
			}
		}
		return trouve;
	}
	
	private int calculScore(int erreurs) {
		int score = 0;
		
		switch(erreurs) {
		
		case 0 :
			score = 100;
			break;
		case 1 :
			score = 50;
			break;
		case 2 :
			score = 35;
			break;
		case 3 :
			score = 25;
			break;
		case 4 :
			score = 15;
			break;
		case 5 :
			score = 10;
			break;
		case 6 :
			score = 5;
			break;
		}
		return score;
	}

}
