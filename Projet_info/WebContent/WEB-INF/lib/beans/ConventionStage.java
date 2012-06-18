package beans;
import java.io.Serializable;
import java.util.GregorianCalendar;


public class ConventionStage implements Serializable, Comparable<ConventionStage>{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1016777380511290117L;
	private int numeroConvention;
    private GregorianCalendar dateSignatureConvention;
    private int dureeConvention;
    private OffreDeStage monOffreDeStage;
    private Etudiant monEtudiant;
	
    /**
	 * 
	 */
	public ConventionStage() {
		super();
	}

	/**
	 * @param numeroConvention
	 * @param dateSignatureConvention
	 * @param dureeConvention
	 * @param numeroOffreDeStage
	 * @param numeroEtudiant
	 */
	public ConventionStage(int numeroConvention,GregorianCalendar dateSignatureConvention, int dureeConvention) {
		this();
		this.numeroConvention = numeroConvention;
		this.dateSignatureConvention = dateSignatureConvention;
		this.dureeConvention = dureeConvention;
	}
	
	/**
	 * @param numeroConvention
	 */
	public ConventionStage(int numeroConvention){
		this(numeroConvention, new GregorianCalendar(), 0);
	}
	
	/**
	 * @return the numeroConvention
	 */
	public int getNumeroConvention() {
		return numeroConvention;
	}

	/**
	 * @param numeroConvention the numeroConvention to set
	 */
	public void setNumeroConvention(int numeroConvention) {
		this.numeroConvention = numeroConvention;
	}

	/**
	 * @return the dateSignatureConvention
	 */
	public GregorianCalendar getDateSignatureConvention() {
		return dateSignatureConvention;
	}

	/**
	 * @param dateSignatureConvention the dateSignatureConvention to set
	 */
	public void setDateSignatureConvention(GregorianCalendar dateSignatureConvention) {
		this.dateSignatureConvention = dateSignatureConvention;
	}

	/**
	 * @return the dureeConvention
	 */
	public int getDureeConvention() {
		return dureeConvention;
	}

	/**
	 * @param dureeConvention the dureeConvention to set
	 */
	public void setDureeConvention(int dureeConvention) {
		this.dureeConvention = dureeConvention;
	}

	/**
	 * @return the monOffreDeStage
	 */
	public OffreDeStage getMonOffreDeStage() {
		return monOffreDeStage;
	}

	/**
	 * @param monOffreDeStage the monOffreDeStage to set
	 */
	public void setMonOffreDeStage(OffreDeStage monOffreDeStage) {
		this.monOffreDeStage = monOffreDeStage;
	}

	/**
	 * @return the monEtudiant
	 */
	public Etudiant getMonEtudiant() {
		return monEtudiant;
	}

	/**
	 * @param monEtudiant the monEtudiant to set
	 */
	public void setMonEtudiant(Etudiant monEtudiant) {
		this.monEtudiant = monEtudiant;
	}

	@Override
	public int compareTo(ConventionStage o) {
		return this.getNumeroConvention()-o.getNumeroConvention();
	}

	
}
