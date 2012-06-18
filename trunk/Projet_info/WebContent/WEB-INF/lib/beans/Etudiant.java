package beans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Etudiant implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7798026999755813405L;
	private int numeroEtudiant;
	private Candidat monCandidat;
	private List<Promotion> mesPromotions = new ArrayList<Promotion>();
	private List<ContratApprentissage> mesContratsApprentissage = new ArrayList<ContratApprentissage>();
	private List<ConventionStage> mesConventions = new ArrayList<ConventionStage>();
	private List<Note> mesNotes = new ArrayList<Note>();
	
	/**
	 * 
	 */
	public Etudiant() {
		super();
	}

	/**
	 * @param numeroEtudiant
	 */
	public Etudiant(int numeroEtudiant) {
		this();
		this.numeroEtudiant = numeroEtudiant;
	}

	/**
	 * @return the numeroEtudiant
	 */
	public int getNumeroEtudiant() {
		return numeroEtudiant;
	}

	/**
	 * @param numeroEtudiant the numeroEtudiant to set
	 */
	public void setNumeroEtudiant(int numeroEtudiant) {
		this.numeroEtudiant = numeroEtudiant;
	}

	/**
	 * @return the monCandidat
	 */
	public Candidat getMonCandidat() {
		return monCandidat;
	}

	/**
	 * @param monCandidat the monCandidat to set
	 */
	public void setMonCandidat(Candidat monCandidat) {
		this.monCandidat = monCandidat;
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
	 * @return the mesContratsApprentissage
	 */
	public List<ContratApprentissage> getMesContratsApprentissage() {
		return mesContratsApprentissage;
	}

	/**
	 * @param mesContratsApprentissage the mesContratsApprentissage to set
	 */
	public void setMesContratsApprentissage(
			List<ContratApprentissage> mesContratsApprentissage) {
		this.mesContratsApprentissage = mesContratsApprentissage;
	}

	/**
	 * @return the mesConventions
	 */
	public List<ConventionStage> getMesConventions() {
		return mesConventions;
	}

	/**
	 * @param mesConventions the mesConventions to set
	 */
	public void setMesConventions(List<ConventionStage> mesConventions) {
		this.mesConventions = mesConventions;
	}

	/**
	 * @return the mesNotes
	 */
	public List<Note> getMesNotes() {
		return mesNotes;
	}

	/**
	 * @param mesNotes the mesNotes to set
	 */
	public void setMesNotes(List<Note> mesNotes) {
		this.mesNotes = mesNotes;
	}
}
