package modeDeJeu;

import java.util.*;

public abstract class ModeDeJeu {
	protected static char[] nbrMystere;
	protected static int tentatives;
	protected static boolean trouver;
	
	
	public ModeDeJeu()
	{
		tentatives = 0;
	}
	
	public static void jeu() 
	{
		int choix = ModeDeJeu.choix_mode_de_jeu();
		if (choix == 1)
			ModeDeJeuUn.start();
		else
			ModeDeJeuDeux.start();
	}
	
	public static int choix_mode_de_jeu() 
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Bienvenue dans le jeu du nombre mystère \n");
		sb.append("Menu de choix de mode de jeu \n");
		sb.append("1- Trouver le nombre de l'ordinateur \n");
		sb.append("2- Choisir un nombre que l'ordinateur doit trouver \n");

		Scanner sc = new Scanner(System.in);
		int choix = 0; 
		do {
			System.out.println(sb);
			if (sc.hasNextInt())
				choix = sc.nextInt();
			else {
				while(!(sc.hasNextInt())) {
					sc = new Scanner(System.in);
					System.out.println("Vous devez choisir un chiffre \n");
				}
			 }
			if (choix != 1 && choix != 2)
				System.out.println("Vous devez choisir un chiffre valable");
		}while(choix != 1 && choix != 2);
		return choix;
	}
	
	public static int menu_de_fin()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Menu de fin de partie \n");
		sb.append("1- Refaire une partie \n");
		sb.append("2- Revenir au menu de choix de mode de jeu \n");
		sb.append("3- Quitter le jeu \n");
		
		Scanner sc = new Scanner(System.in);
		int choix = 0; 
		do {
			System.out.println(sb);
			if (sc.hasNextInt())
				choix = sc.nextInt();
			else {
				while(!(sc.hasNextInt())) {
					sc = new Scanner(System.in);
					System.out.println("Vous devez choisir un chiffre \n");
				}
			 }
			if (choix != 1 && choix != 2)
				System.out.println("Vous devez choisir un chiffre valable");
		}while(choix != 1 && choix != 2);
		
		return choix;
	}

	public static char[] verif(char[] nbr, char[] nbrMystere)
	{
		char[] resultat = new char[4];
		for (int i = 0; i < nbr.length; i++) {
			if (nbr[i] == nbrMystere[i])
				resultat[i] = '=';
			else if (nbr[i] > nbrMystere[i])
				resultat[i] = '-';
			else if (nbr[i] < nbrMystere[i])
				resultat[i] = '+';
		}
		return resultat;
	}
	
	public static boolean verif_trouver(char[] resultat)
	{
		for (int i = 0; i < 4; i++) {
			if (resultat[i] != '=')
				return false;
		}
		return true;
	}
	
	public static char[] saisie_utilisateur()
	{
		Scanner sc = new Scanner(System.in);
		String saisie;
		char[] nbrUtilisateur = new char[4];
		boolean verifAscii = true;
		do 
		{
			saisie = sc.nextLine();
			if (saisie.length() != 4)
				System.out.println("Le nombre doit contenir 4 chiffres");
			else {
				int ascii;
				for (int k = 0; k < saisie.length(); k++) {
					ascii = saisie.charAt(k);
					if (ascii <48 || ascii > 57) {
						verifAscii = false;
						System.out.println("Vous ne devez mettre que des chiffres");
					}
				}
			}
		}while(saisie.length() != 4 && !verifAscii);
		for (int j = 0; j < saisie.length(); j++) {
			nbrUtilisateur[j] = saisie.charAt(j);
		}
		return nbrUtilisateur;
	}
	
	public char[] getNbrMystere()
	{
		return this.nbrMystere;
	}
	
	public int getTentatives()
	{
		return this.tentatives;
	}

}
