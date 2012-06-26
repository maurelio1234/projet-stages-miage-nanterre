package Manager;

import java.util.GregorianCalendar;

import beans.Etudiant;
import beans.Promotion;
import beans.Semestre;

public class ManagerEtudiant {

	public static void calculMoyenneSemestre (Etudiant et, GregorianCalendar datedebut, GregorianCalendar datedefin){
		float moyenne = 0;
		int coef = 0;
		Semestre semestre = new Semestre();
		Semestre semestrePrecedent = semestre;
		Promotion p = new Promotion ();
		p = chercheDernierePromotion (et, datedebut);
		for (int i = 0; i < p.getMaFormation().getMesUE().size(); i ++){
			semestre = p.getMaFormation().getMesUE().get(i).getMonSemestre();
			if (semestre != semestrePrecedent){
				semestrePrecedent = semestre;
				for (int j = 0; j < semestre.getMesUE().size() ; ++j){
					if (semestre.getMesUE().get(j).getMaFormation() == p.getMaFormation()){
						moyenne += ManagerUE.calculMoyenneUE(semestre.getMesUE().get(j), et.getNumeroEtudiant(), datedebut, datedefin);
						coef += 1;
					}
				}
			}
		}
	}

	private static Promotion chercheDernierePromotion(Etudiant et, GregorianCalendar datedebut) {
		Promotion p = new Promotion ();
		for (int i = 0; i < et.getMesPromotions().size(); ++i){
			for (int j = 0; j < et.getMesPromotions().get(i).getMonHistorique().size(); ++j){
				if (et.getMesPromotions().get(i).getMonHistorique().get(j).getDateHistorique().equals(datedebut)){
					return et.getMesPromotions().get(i);
				}
			}
		}
		return null;
	}
}
