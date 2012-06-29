package Manager;


import java.util.Hashtable;


import dao.ECDAO;
import dao.ExamenDAO;
import dao.FormationDAO;
import dao.NoteDAO;
import dao.PromotionDAO;
import dao.UEDAO;
import beans.EC;
import beans.Etudiant;
import beans.Examen;
import beans.Formation;
import beans.Note;
import beans.Promotion;
import beans.UE;

import Manager.ManagerNoteEtudiant;
public class ManagerNoteEtudiant {

	private static  Hashtable<Integer, Float> hue = new Hashtable<Integer, Float>();
	static Hashtable<String, Double> hec = new Hashtable<String, Double>();
	
	public static float noteFinal(Etudiant et) {

		UEDAO ueDao = new UEDAO();
		FormationDAO formationDao = new FormationDAO();
		PromotionDAO promotionDao = new PromotionDAO ();	
		Promotion promotion = new Promotion();
		Formation formation = new Formation();
		UE ue = new UE();
		float moyenne = 0;
		float note = 0;
		int coef = 0;
		for (int l = 0; l < et.getMesPromotions().size(); ++l){
			try {
				promotion = promotionDao.find(et.getMesPromotions().get(l).getNumeroPromotion());

				for (int k = 0; k < et.getMesPromotions().size(); ++k) {
					formation = formationDao.find(promotion.getNumeroPromotion());
					formationDao.loadMesUE(formation);
					for (int i = 0; i < formation.getMesUE().size(); i++) {
							ue = ueDao.find(formation.getMesUE().get(i).getNumeroUE());
							ueDao.loadMesEC(ue);
							note = calculMoyenneUE(ue, et.getNumeroEtudiant());
							moyenne += note;
							coef += 1;
							hue.put(ue.getNumeroUE(), note);
						}
					}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}	
		return moyenne / coef;
	}
	

	public static Hashtable<Integer, Float> gethUe() {
		return hue;
	}

	
	public static float calculMoyenneEC(EC ec, int NumeroEtudiant) {
		float moyenne = 0;
		float coef = 0;
		ExamenDAO examenDao = new ExamenDAO();
		Note note = new Note();
		Examen examen = new Examen ();
		for (int i = 0; i < ec.getMesExamens().size(); i++) {
			for (int j = 0; j < ec.getMesExamens().get(i).getMesNotes().size(); j++) {
				examen = examenDao.find(ec.getMesExamens().get(i).getNumeroExamen());
				examenDao.LoadNote(examen);
				note = chercheNoteEtudiant (examen,NumeroEtudiant );
				if (note != null){
					if (note.getNote() >= 0) {
						moyenne += note.getNote() * examen.getCoefficient();
						coef += examen.getCoefficient();
					} else if (note.getNote()== -1) { // -1 = Absence non justifiée donc on prends en compte le coef
						coef += examen.getCoefficient();
					}
				}
			}
		}
		return (moyenne / coef);
	}
	
	public static float calculMoyenneUE (UE ue, int NumeroEtudiant){
		float moyenne = 0;
		double note = 0;
		float coef = 0;
		ECDAO ecDao = new ECDAO();
		EC ec = new EC();
		for (int i = 0; i < ue.getMesEC().size(); i++){
			ec = ecDao.find(ue.getMesEC().get(i).getNumeroEC());
			ecDao.loadMesExamens(ec);
			note = (calculMoyenneEC (ec, NumeroEtudiant) * ec.getCoefficient());
			moyenne += note;
			coef += ue.getMesEC().get(i).getCoefficient();	
			hec.put(ec.getLibelle(), note);
		}
		return (moyenne / coef);
	}
		public static Note chercheNoteEtudiant (Examen examen, int etudiant){
			NoteDAO noteDao = new NoteDAO();
			Note note = new Note();
			return note = noteDao.find(etudiant, examen.getNumeroExamen());
		}
	
}