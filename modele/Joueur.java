package com.oc.modele;

import java.io.Serializable;

public class Joueur implements Serializable, Comparable {

	private String nomJoueur = "";
	private int score = 0;
	
	public String getNomJoueur() {
		return this.nomJoueur;
	}
	
	public void setNomJoueur(String nom) {
		this.nomJoueur = nom;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String toString() {
		String str = this.nomJoueur + (" (") + this.score + " points)";
		return str;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		int scoreJ2 = ((Joueur)o).getScore();
		
		return scoreJ2 - this.getScore();
	}
}
