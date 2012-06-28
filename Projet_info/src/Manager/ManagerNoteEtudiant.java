package Manager;

import java.util.Hashtable;
import java.util.Iterator;

import beans.Etudiant;
import beans.Semestre;

public class ManagerNoteEtudiant {

	static Hashtable<Integer, Float> ue = new Hashtable<Integer, Float>();
	static Hashtable<Integer, Float> hSemestre = new Hashtable<Integer, Float>();
	
	public float noteFinal(Etudiant et) {
		float moyenne = 0;
		float note = 0;
		int coef = 0;
		Semestre semestre = new Semestre();
		Semestre semestrePrecedent = semestre;
		for (int k = 0; k < et.getMesPromotions().size(); ++k) {
			for (int i = 0; i < et.getMesPromotions().get(k).getMaFormation().getMesUE().size(); i++) {
				semestre = et.getMesPromotions().get(k).getMaFormation().getMesUE().get(i).getMonSemestre();
				if (semestre != semestrePrecedent) {
					semestrePrecedent = semestre;
					for (int j = 0; j < semestre.getMesUE().size(); ++j) {
						if (semestre.getMesUE().get(j).getMaFormation() == et.getMesPromotions().get(k).getMaFormation()) {
							note = ManagerNoteUE.calculMoyenneUE(semestre.getMesUE().get(j), et.getNumeroEtudiant());
							moyenne += note;
							coef += 1;
							ue.put(semestre.getMesUE().get(j).getNumeroUE(),note);
						}
						hSemestre.put(semestre.getNumeroSemestre(), moyenne /coef );
					}
				}
			}
		}
		return CalculnoteFinal();
	}
	
	@SuppressWarnings("rawtypes")
	public float CalculnoteFinal(){
		float moyenne = 0;
		int coef = 0;
	    Iterator itValue = hSemestre.values().iterator(); 
	    Iterator itKey = hSemestre.keySet().iterator();
		while (itValue.hasNext()){
			moyenne += (Float)itKey.next();
			coef ++;
		}
		return moyenne / coef;
		
	}
}