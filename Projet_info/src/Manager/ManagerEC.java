package Manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import beans.EC;

public class ManagerEC {

	public static float calculMoyenneEC(EC ec, int NumeroEtudiant) {
		float moyenne = 0;
		float coef = 0;
		for (int i = 0; i < ec.getMesExamens().size(); i++) {
			for (int j = 0; j < ec.getMesExamens().get(i).getMesNotes().size(); j++) {
				if ( ec.getMesExamens().get(i).getMesNotes().get(j).getMonEtudiant().getNumeroEtudiant() == NumeroEtudiant){
					if (ec.getMesExamens().get(i).getMesNotes().get(j).getNote() >= 0) {
						moyenne += ec.getMesExamens().get(i).getMesNotes().get(j).getNote() * ec.getMesExamens().get(i).getCoefficient();
						coef += ec.getMesExamens().get(i).getCoefficient();
					} else if (ec.getMesExamens().get(i).getMesNotes().get(j)
							.getNote() == -3) { // -3 = Absence non justifiée donc on prends en compte le coef
						coef += ec.getMesExamens().get(i).getCoefficient();
					}
				}
			}
		}
		return (moyenne / coef);
	}
}
