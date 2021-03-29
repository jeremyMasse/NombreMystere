package modeDeJeu;

import java.util.Random;
import java.util.Scanner;

public class ModeDeJeuUn extends ModeDeJeu {
	
	
	public ModeDeJeuUn()
	{
		super();
		
	}
	
	public static void start() 
	{
		Random r = new Random();
		nbrMystere = new char[4]; 
		for (int i = 0; i < 4; i++) {
			nbrMystere[i] = (char)(r.nextInt(10) + 48);
		}
		char[] result = new char[4];
		do{
			System.out.println("Essayer de trouver le nombre de l'ordinateur qui contient maximum 4 chiffres : \n");
			System.out.println("Vous avez encore "+ (10 - tentatives) +" tentatives.");
			result = verif(saisie_utilisateur(), nbrMystere);
			System.out.println(result);
			tentatives = tentatives + 1;
			trouver = verif_trouver(result);
		}while(tentatives < 10 && !trouver);
		if (trouver)
			System.out.println("Bravo vous avez trouvé le nombre mystère était");
		else
			System.out.println("Vous n'avez pas trouvé le nombre était ");
			System.out.println(nbrMystere);
			
		int menu = menu_de_fin();
		if (menu == 1) {
			start();
			tentatives = 0;
		}
		else if (menu == 2)
			jeu();
	}
}
