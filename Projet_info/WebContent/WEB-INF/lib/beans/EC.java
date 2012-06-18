package beans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class EC implements Serializable, Comparable<EC>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3979268140005307652L;
	private int numeroEC;
	private UE monUE;
    private Formation maFormation;
    private String libelle;
    private double coefficient;
    private List<Enseignant> mesEnseignants = new ArrayList<Enseignant>();
    private List<Examen> mesExamens = new ArrayList<Examen>();
    private List<Necessite> mesNecessites = new ArrayList<Necessite>();
    private List<VoeuxEC> mesVoeuxEC = new ArrayList<VoeuxEC>();
    private List<Creneau> mesCreneaux = new ArrayList<Creneau>();
    private List<Service> mesServices = new ArrayList<Service>();
	
	/**
	 * 
	 */
    public EC() {
    	super();
	}
	
	/**
	 * @param numeroEC
	 * @param monUE
	 * @param maFormation
	 * @param libelle
	 * @param coefficient
	 */
    public EC(int numeroEC, UE monUE, Formation maFormation, String libelle, double coefficient) {
    	this();
		this.setNumeroEC(numeroEC);
		this.setMonUE(monUE);
		this.setMaFormation(maFormation);
		this.setLibelle(libelle);
		this.setCoefficient(coefficient);
	}
    
	/**
	 * @param numeroEC
	 * @param monUE
	 * @param maFormation
	 */
    public EC(int numeroEC,  UE monUE, Formation maFormation) {
    	this(numeroEC, monUE, maFormation, "", 0);
    }

	/**
	 * @return the numeroEC
	 */
	public int getNumeroEC() {
		return numeroEC;
	}

	/**
	 * @param numeroEC the numeroEC to set
	 */
	public void setNumeroEC(int numeroEC) {
		this.numeroEC = numeroEC;
	}

	/**
	 * @return the monUE
	 */
	public UE getMonUE() {
		return monUE;
	}

	/**
	 * @param monUE the monUE to set
	 */
	public void setMonUE(UE monUE) {
		this.monUE = monUE;
	}

	/**
	 * @return the maFormation
	 */
	public Formation getMaFormation() {
		return maFormation;
	}

	/**
	 * @param maFormation the maFormation to set
	 */
	public void setMaFormation(Formation maFormation) {
		this.maFormation = maFormation;
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
	 * @return the coefficient
	 */
	public double getCoefficient() {
		return coefficient;
	}

	/**
	 * @param coefficient the coefficient to set
	 */
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	/**
	 * @return the mesEnseignants
	 */
	public List<Enseignant> getMesEnseignants() {
		return mesEnseignants;
	}

	/**
	 * @param mesEnseignants the mesEnseignants to set
	 */
	public void setMesEnseignants(List<Enseignant> mesEnseignants) {
		this.mesEnseignants = mesEnseignants;
	}

	/**
	 * @return the mesExamens
	 */
	public List<Examen> getMesExamens() {
		return mesExamens;
	}

	/**
	 * @param mesExamens the mesExamens to set
	 */
	public void setMesExamens(List<Examen> mesExamens) {
		this.mesExamens = mesExamens;
	}

	/**
	 * @return the mesNecessites
	 */
	public List<Necessite> getMesNecessites() {
		return mesNecessites;
	}

	/**
	 * @param mesNecessites the mesNecessites to set
	 */
	public void setMesNecessites(List<Necessite> mesNecessites) {
		this.mesNecessites = mesNecessites;
	}

	/**
	 * @return the mesVoeuxEC
	 */
	public List<VoeuxEC> getMesVoeuxEC() {
		return mesVoeuxEC;
	}

	/**
	 * @param mesVoeuxEC the mesVoeuxEC to set
	 */
	public void setMesVoeuxEC(List<VoeuxEC> mesVoeuxEC) {
		this.mesVoeuxEC = mesVoeuxEC;
	}

	/**
	 * @return the mesCreneaux
	 */
	public List<Creneau> getMesCreneaux() {
		return mesCreneaux;
	}

	/**
	 * @param mesCreneaux the mesCreneaux to set
	 */
	public void setMesCreneaux(List<Creneau> mesCreneaux) {
		this.mesCreneaux = mesCreneaux;
	}

	/**
	 * @return the mesServices
	 */
	public List<Service> getMesServices() {
		return mesServices;
	}

	/**
	 * @param mesServices the mesServices to set
	 */
	public void setMesServices(List<Service> mesServices) {
		this.mesServices = mesServices;
	}

	@Override
	public int compareTo(EC o) {
		return this.getNumeroEC()-o.getNumeroEC();
	}
    
}
