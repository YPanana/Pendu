package com.oc.modele;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Classement implements Serializable {
	
	private File fichierClassement = new File("classement.txt");
	private ArrayList<Joueur> tableClassement = new ArrayList<Joueur>();
	
	public Classement() {
		
		FileInputStream fis;
		BufferedInputStream bis;
		ObjectInputStream ois;
		
		try {
			fis = new FileInputStream(fichierClassement);
			bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			Classement c;
			
			c = (Classement)ois.readObject();
			this.tableClassement = c.tableClassement;
			
			ois.close();
			bis.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Fichier classement inexistant !");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur de lecture/ecriture dans le fichier classements ! : " + e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Probleme de classe ! : " + e.getMessage());
		}
	}
	
	public String toString() {
		String str = "--Classement--\n";
		int tailleTableau = this.tableClassement.size();
		for (int i = 0 ; i < tailleTableau ; i++) {
			str += i+1 + ". " + this.tableClassement.get(i).toString() + "\n";
		}
		if (tailleTableau < 10) {
			for (int i = tailleTableau ; i < 10 ; i++) {
				str += i+1 + ". ----Vide----\n";
			}
		}
		str += "--------------\n";
		return str;
	}
	
	public boolean checkTop10(int score) {
		boolean top10 = false;
		//Si tableau vide ou score plus grand que celui du premier joueur du classement
		if (this.tableClassement.isEmpty() || (score > this.tableClassement.get(0).getScore()))
			top10 = true;
		else {
			for (int i = 0 ; i < 10 ; i++) {
				if (score > this.tableClassement.get(i).getScore()) {
					top10 = true;
				}
			}
		}
		return top10;
	}
	
	public void ajouterJoueur(Joueur j) {
		this.tableClassement.add(j);
		Collections.sort(this.tableClassement);
	}
	
	public void sauverClassement() {
		FileOutputStream fos;
		BufferedOutputStream bos;
		ObjectOutputStream oos;
		
		try {
			fos = new FileOutputStream("classement.txt", false); // (append =)false -> On ecrase a chaque fois le contenu
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			
			oos.writeObject(this);
			
			oos.close();
			bos.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Fichier de classement inexistant !");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur d'ecriture dans le fichier classement ! : " + e.getMessage());
		}
	}
	

}
