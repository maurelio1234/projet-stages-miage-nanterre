package beans;
import java.io.Serializable;
import java.util.GregorianCalendar;

public class ContratApprentissage implements Serializable, Comparable<ContratApprentissage> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1037544576331343693L;
	private int numeroContrat;
	private GregorianCalendar dateSignatureContrat;
	private double salaire;
	private int duree;
	private Etudiant monEtudiant;
	private Entreprise monEntreprise;
	
	/**
	 * 
	 */
	public ContratApprentissage() {
		super();
	}

	/**
	 * @param numeroContrat
	 * @param dateSignatureContrat
	 * @param salaire
	 * @param duree
	 * @param numeroEtudiant
	 * @param numeroEntreprise
	 */
	public ContratApprentissage(int numeroContrat,
			GregorianCalendar dateSignatureContrat, double salaire, int duree) {
		this();
		this.numeroContrat = numeroContrat;
		this.dateSignatureContrat = dateSignatureContrat;
		this.salaire = salaire;
		this.duree = duree;
	}
	
	public ContratApprentissage(int numeroContrat){
		this(numeroContrat,new GregorianCalendar(),0,0);
	}

	/**
	 * @return the numeroContrat
	 */
	public int getNumeroContrat() {
		return numeroContrat;
	}

	/**
	 * @param numeroContrat the numeroContrat to set
	 */
	public void setNumeroContrat(int numeroContrat) {
		this.numeroContrat = numeroContrat;
	}

	/**
	 * @return the dateSignatureContrat
	 */
	public GregorianCalendar getDateSignatureContrat() {
		return dateSignatureContrat;
	}

	/**
	 * @param dateSignatureContrat the dateSignatureContrat to set
	 */
	public void setDateSignatureContrat(GregorianCalendar dateSignatureContrat) {
		this.dateSignatureContrat = dateSignatureContrat;
	}

	/**
	 * @return the salaire
	 */
	public double getSalaire() {
		return salaire;
	}

	/**
	 * @param salaire the salaire to set
	 */
	public void setSalaire(double salaire) {
		this.salaire = salaire;
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

	public Etudiant getMonEtudiant() {
		return monEtudiant;
	}

	public void setMonEtudiant(Etudiant monEtudiant) {
		this.monEtudiant = monEtudiant;
	}

	public Entreprise getMonEntreprise() {
		return monEntreprise;
	}

	public void setMonEntreprise(Entreprise monEntreprise) {
		this.monEntreprise = monEntreprise;
	}

	@Override
	public int compareTo(ContratApprentissage o) {
		return this.getNumeroContrat()-o.getNumeroContrat();
	}
	
}
