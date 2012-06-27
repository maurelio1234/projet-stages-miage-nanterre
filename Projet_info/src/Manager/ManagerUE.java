package Manager;

import java.util.GregorianCalendar;

import beans.UE;

public class ManagerUE {


	
	public static float calculMoyenneUE (UE ue, int NumeroEtudiant){
		float moyenne = 0;
		double note = 0;
		float coef = 0;
		for (int i = 0; i < ue.getMesEC().size(); i++){
			note = ManagerEC.calculMoyenneEC (ue.getMesEC().get(i), NumeroEtudiant) * ue.getMesEC().get(i).getCoefficient();
			moyenne += note;
			coef += ue.getMesEC().get(i).getCoefficient();
			System.out.println("l'UC " +  ue.getMesEC().get(i).getLibelle() + " Coefficient  : " + ue.getMesEC().get(i).getCoefficient() + " Note : " + note  );
		}
		return (moyenne / coef);
	}
}

