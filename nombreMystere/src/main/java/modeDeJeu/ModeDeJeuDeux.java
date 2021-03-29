package modeDeJeu;

import java.util.Random;
import java.util.Scanner;

public class ModeDeJeuDeux extends ModeDeJeu{
	public static char[] nbrOrdinateur;
	
	public ModeDeJeuDeux() {
		
	}
	public static void start() 
	{
		System.out.println("Choisissez un nombre");
		char[] nbrMystere = saisie_utilisateur();
		char[] nbrOrdinateur = {'0','0','0','0'};
		char[] resultat = new char[4];
		char[] min_max = {'0','0','0','0','9','9','9','9'};
		do{
			nbrOrdinateur = choix_ordinateur(min_max, nbrOrdinateur, resultat);
			System.out.println(nbrOrdinateur);
			resultat = verif(nbrOrdinateur, nbrMystere);
			System.out.println(resultat);
			min_max = ajustement_min_max(resultat, min_max, nbrOrdinateur);
			trouver = verif_trouver(resultat);
			tentatives = tentatives + 1;
		}while(tentatives < 10 && !trouver);
		if (trouver)
			System.out.println("L'ordinateur a trouvé, le nombre mystère");
		else
			System.out.println("L'ordinateur n'a pas trouvé, le nombre mystere était ");
		
		int menu = menu_de_fin();
		if (menu == 1) 
			start();
		else if (menu == 2)
			jeu();
	}
	
	public static char[] choix_ordinateur(char[] min_max, char[] nbrOrdinateur, char[] resultat)
	{
		for (int i = 0; i < 4; i++) {
			if (resultat[i] != '=')
				nbrOrdinateur[i] = (char)(random_borne(min_max[i], min_max[i+4]));
		}
		return nbrOrdinateur;
	}
	
	public static int random_borne(int min, int max)
	{
		Random random = new Random();
		return random.nextInt(max-min) + min;
	}

	public static char[] ajustement_min_max(char[] resultat, char[] min_max, char[] nbrOrdinateur )
	{
		for (int i = 0; i < 4; i++) {
			if (resultat[i] == '+') 
				min_max[i] = nbrOrdinateur[i];
			else if (resultat[i] == '-') 
				min_max[i+4] = nbrOrdinateur[i];
		}
		return min_max;
	}
}

