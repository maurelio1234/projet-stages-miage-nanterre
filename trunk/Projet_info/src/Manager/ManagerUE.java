package Manager;

import java.util.GregorianCalendar;

import beans.UE;

public class ManagerUE {


	
	public static float calculMoyenneUE (UE ue, int NumeroEtudiant){
		float moyenne = 0;
		float coef = 0;
		for (int i = 0; i < ue.getMesEC().size(); i++){
			moyenne += ManagerEC.calculMoyenneEC (ue.getMesEC().get(i), NumeroEtudiant) * ue.getMesEC().get(i).getCoefficient();
			coef += ue.getMesEC().get(i).getCoefficient();
		}
		return (moyenne / coef);
	}
}
