package beans;
import java.io.Serializable;


public class Indisponibilite implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5892609409271626866L;
    private Enseignant monEnseignant;
    private Jours dateIndisponibilite;
    private int demiJournee;
    private int poids;
	
    /**
	 * 
	 */
    public Indisponibilite() {
    	super();
	}

    /**
	 * @param monEnseignant
	 * @param dateIndisponibilite
	 * @param demiJournee
	 * @param poids
	 */    
	public Indisponibilite(Enseignant monEnseignant, Jours dateIndisponibilite, int demiJournee, int poids) {
		this();
		this.demiJournee = demiJournee;
		this.poids = poids;		
		this.monEnseignant = monEnseignant;
		this.dateIndisponibilite = dateIndisponibilite;
		this.monEnseignant.getMesIndispos().add(this);
		this.dateIndisponibilite.getMesIndispos().add(this);
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
	 * @return the dateIndisponibilite
	 */
	public Jours getDateIndisponibilite() {
		return dateIndisponibilite;
	}

	/**
	 * @param dateIndisponibilite the dateIndisponibilite to set
	 */
	public void setDateIndisponibilite(Jours dateIndisponibilite) {
		this.dateIndisponibilite = dateIndisponibilite;
	}

	/**
	 * @return the demiJournee
	 */
	public int getDemiJournee() {
		return demiJournee;
	}

	/**
	 * @param demiJournee the demiJournee to set
	 */
	public void setDemiJournee(int demiJournee) {
		this.demiJournee = demiJournee;
	}

	/**
	 * @return the poids
	 */
	public int getPoids() {
		return poids;
	}

	/**
	 * @param poids the poids to set
	 */
	public void setPoids(int poids) {
		this.poids = poids;
	}

}
