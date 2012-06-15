import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



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
	
	public void AffichOffreStageEnt(Entreprise e){
		List<OffreDeStage> listeOffre = new ArrayList<OffreDeStage>();
		listeOffre = e.getMesOffres();
		
		Iterator it1 = listeOffre.iterator();
    	
    	while(it1.hasNext()){
    		OffreDeStage v = (OffreDeStage) it1.next();
    		System.out.println(" Vehicule numero" + v.getDescriptionPoste());
    	}
	}
	
	public void ValidationStage(OffreDeStage ods){
		
	}
	
	public void AffichOffreStageEt(Etudiant et){
		List<OffreDeStage> listeOffre = new ArrayList<OffreDeStage>();
		listeOffre = et.getMesOffres();
		
		Iterator it1 = listeOffre.iterator();
    	
    	while(it1.hasNext()){
    		OffreDeStage v = (OffreDeStage) it1.next();
    		System.out.println(" Vehicule numero" + v.getDescriptionPoste());
    	}
	}
	
}
