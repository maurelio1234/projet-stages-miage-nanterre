package beans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Formation implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7535003487189395864L;
	private int numeroFormation;
    private ContratQuadriennal monContrat;
    private List<UE> mesUE = new ArrayList<UE>();
    private List<Promotion> mesPromotions = new ArrayList<Promotion>();
    private String libelle;
    private String niveau;
    private String type;
    private String parcours;
	
    /**
	 * 
	 */
    public Formation() {
    	super();
	}

    /**
	 * @param numeroFormation
	 * @param libelle
	 * @param niveau
	 * @param type
	 * @param parcours
	 */
	public Formation(int numeroFormation, String libelle, String niveau, String type, String parcours) {
		this();
		this.numeroFormation = numeroFormation;
		this.libelle = libelle;
		this.niveau = niveau;
		this.type = type;
		this.parcours = parcours;
	}
	
    /**
	 * @param numeroFormation
	 */
	public Formation(int numeroFormation){
		this(numeroFormation, "","","","");
	}

	/**
	 * @return the numeroFormation
	 */
	public int getNumeroFormation() {
		return numeroFormation;
	}

	/**
	 * @param numeroFormation the numeroFormation to set
	 */
	public void setNumeroFormation(int numeroFormation) {
		this.numeroFormation = numeroFormation;
	}

	/**
	 * @return the monContrat
	 */
	public ContratQuadriennal getMonContrat() {
		return monContrat;
	}

	/**
	 * @param monContrat the monContrat to set
	 */
	public void setMonContrat(ContratQuadriennal monContrat) {
		this.monContrat = monContrat;
	}

	/**
	 * @return the mesUE
	 */
	public List<UE> getMesUE() {
		return mesUE;
	}

	/**
	 * @param mesUE the mesUE to set
	 */
	public void setMesUE(List<UE> mesUE) {
		this.mesUE = mesUE;
	}

	/**
	 * @return the mesPromotions
	 */
	public List<Promotion> getMesPromotions() {
		return mesPromotions;
	}

	/**
	 * @param mesPromotions the mesPromotions to set
	 */
	public void setMesPromotions(List<Promotion> mesPromotions) {
		this.mesPromotions = mesPromotions;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the niveau
	 */
	public String getNiveau() {
		return niveau;
	}

	/**
	 * @param niveau the niveau to set
	 */
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the parcours
	 */
	public String getParcours() {
		return parcours;
	}

	/**
	 * @param parcours the parcours to set
	 */
	public void setParcours(String parcours) {
		this.parcours = parcours;
	}
	
}
