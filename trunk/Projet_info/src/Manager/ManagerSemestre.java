package Manager;

import java.util.GregorianCalendar;

import beans.Semestre;
import beans.UE;

public class ManagerSemestre {

	public static float calculMoyenneSemestre (Semestre s, int NumeroEtudiant, GregorianCalendar datedebut, GregorianCalendar datefin){
		float moyenne = 0;
		float coef = 0;
		for (int i = 0; i < s.getMesUE().size(); i++){
			moyenne += ManagerUE.calculMoyenneUE (s.getMesUE().get(i), NumeroEtudiant, datedebut, datefin);
			coef += 1;
		}
		return (moyenne / coef);
	}
	
}
