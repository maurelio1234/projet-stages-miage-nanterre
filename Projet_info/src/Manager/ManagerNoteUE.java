package Manager;

import java.util.Hashtable;

import beans.UE;

public class ManagerNoteUE {
	static Hashtable<String, Double> ec = new Hashtable<String, Double>();
	
	public static float calculMoyenneUE (UE ue, int NumeroEtudiant){
		float moyenne = 0;
		double note = 0;
		float coef = 0;
		for (int i = 0; i < ue.getMesEC().size(); i++){
			note = (ManagerNoteEC.calculMoyenneEC (ue.getMesEC().get(i), NumeroEtudiant) * ue.getMesEC().get(i).getCoefficient());
			moyenne += note;
			coef += ue.getMesEC().get(i).getCoefficient();	
			ec.put(ue.getMesEC().get(i).getLibelle(), note);
		}
		return (moyenne / coef);
	}
}

