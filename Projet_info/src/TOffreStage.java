import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import beans.Enseignant;
import beans.Entreprise;
import beans.Etudiant;
import beans.OffreDeStage;


public class TOffreStage {

private Entreprise uneEntreprise = new Entreprise();
	
private String Intitule;
private String Description;

	
	public TOffreStage(){
		super();
	}
	
	public TOffreStage(String Intitule, String Desc){
		this.Intitule = Intitule;
		this.Description = Desc;
	}
	
	public List<OffreDeStage> AffichOffreStageEnt(Entreprise e){
		List<OffreDeStage> listeOffre = new ArrayList<OffreDeStage>();
		listeOffre = e.getMesOffres();
		
		return listeOffre;
		
//		Iterator it1 = listeOffre.iterator();
//    	
//    	while(it1.hasNext()){
//    		OffreDeStage v = (OffreDeStage) it1.next();
//    		return v.getDescriptionPoste();
//    	}
//		return Description;
	}
	
	public void ValidationStage(String description){
		List<OffreDeStage> ttesLesOffres = new ArrayList<OffreDeStage>();
		Iterator<OffreDeStage> it = ttesLesOffres.iterator();
		while(it.hasNext()){
			OffreDeStage ods = (OffreDeStage) it.next();
			if(ods.getDescriptionPoste() == description)
				ods.setEtatOffre("Validée");
		}
	}
	
	public void RejetStage(String description){
		List<OffreDeStage> ttesLesOffres = new ArrayList<OffreDeStage>(); // liste de toutes les offres 
		//à charger de la base
		Iterator<OffreDeStage> it = ttesLesOffres.iterator();
		while(it.hasNext()){
			OffreDeStage ods = (OffreDeStage) it.next();
			if(ods.getDescriptionPoste() == description)
				ods.setEtatOffre("Rejettée");
		}
	}
	
	public List<OffreDeStage> AffichOffreStageEt(){
		List<OffreDeStage> listeOffres = new ArrayList<OffreDeStage>();// liste de toutes les offres 
		//à charger de la base
		List<OffreDeStage> listeOffresValidees = new ArrayList<OffreDeStage>();
		Iterator<OffreDeStage> it = listeOffres.iterator();
		while(it.hasNext()){
			OffreDeStage ods = (OffreDeStage) it.next();
			if(ods.getEtatOffre() == "Validée")
				listeOffresValidees.add(ods);  	
    	}
		return listeOffresValidees;
	}
	
	public void AffichOffreStageEns(Enseignant ens){
		List<OffreDeStage> listeOffres = new ArrayList<OffreDeStage>();// liste de toutes les offres 
		//à charger de la base
		listeOffreS = ens.getMesOffres();
		
		Iterator it1 = listeOffre.iterator();
    	
    	while(it1.hasNext()){
    		OffreDeStage v = (OffreDeStage) it1.next();
    		System.out.println(" Vehicule numero" + v.getDescriptionPoste());
    	}
	}
	
	
}
