package beans;
import java.io.Serializable;


public class Creneau implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1130222760201225781L;
	private String horaire;
    private int duree;
    private EC monEC;
    private Type monType;
    private Enseignant monEnseignant;
    private Salle maSalle;
    private Jours dateCreneau;
	
	/**
	 * 
	 */
    public Creneau() {
    	super();
	}

	/**
	 * @param monEnseignant
	 * @param maSalle
	 * @param monEC
	 * @param monType
	 * @param horaire
	 * @param duree
	 */
	public Creneau(Enseignant monEnseignant, Salle maSalle, EC monEC, Type monType, String horaire, int duree) {
		this();
		this.horaire = horaire;
		this.duree = duree;
		this.monEnseignant = monEnseignant;
		this.maSalle = maSalle;
		this.monEC = monEC;
		this.monType = monType;
		this.monEnseignant.getMesCreneaux().add(this);
		this.maSalle.getMesCreneaux().add(this);
		this.monEC.getMesCreneaux().add(this);
		this.monType.getMesCreneaux().add(this);
	}

	/**
	 * @return the horaire
	 */
	public String getHoraire() {
		return horaire;
	}

	/**
	 * @param horaire the horaire to set
	 */
	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}

	/**
	 * @return the duree
	 */
	public int getDuree() {
		return duree;
	}

	/**
	 * @param duree the duree to set
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

	/**
	 * @return the monEC
	 */
	public EC getMonEC() {
		return monEC;
	}

	/**
	 * @param monEC the monEC to set
	 */
	public void setMonEC(EC monEC) {
		this.monEC = monEC;
	}

	/**
	 * @return the monType
	 */
	public Type getMonType() {
		return monType;
	}

	/**
	 * @param monType the monType to set
	 */
	public void setMonType(Type monType) {
		this.monType = monType;
	}

	/**
	 * @return the monEnseignant
	 */
	public Enseignant getMonEnseignant() {
		return monEnseignant;
	}

	/**
	 * @param monEnseignant the monEnseignant to set
	 */
	public void setMonEnseignant(Enseignant monEnseignant) {
		this.monEnseignant = monEnseignant;
	}

	/**
	 * @return the maSalle
	 */
	public Salle getMaSalle() {
		return maSalle;
	}

	/**
	 * @param maSalle the maSalle to set
	 */
	public void setMaSalle(Salle maSalle) {
		this.maSalle = maSalle;
	}

	/**
	 * @return the dateCreneau
	 */
	public Jours getDateCreneau() {
		return dateCreneau;
	}

	/**
	 * @param dateCreneau the dateCreneau to set
	 */
	public void setDateCreneau(Jours dateCreneau) {
		this.dateCreneau = dateCreneau;
	}

	    
}
