package beans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Examen implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1527418294403461045L;
	private int numeroExamen;
    private GregorianCalendar horaire;
    private String libelle;
    private double coefficient;
    private Type monType;
    private int maFormation;
	private int monUE;
    private int monEC;
    private Jours date;
    private List<Note> mesNotes = new ArrayList<Note>();
	
    /**
	 * 
	 */
	public Examen() {
		super();
	}

	/**
	 * @param numeroExamen
	 * @param horaire
	 * @param libelle
	 * @param coefficient
	 */
	public Examen(int numeroExamen, GregorianCalendar horaire, String libelle, double coefficient) {
		this();
		this.numeroExamen = numeroExamen;
		this.horaire = horaire;
		this.libelle = libelle;
		this.coefficient = coefficient;
	}
	
	/**
	 * @param numeroExamen
	 */
	public Examen(int numeroExamen){
		this(numeroExamen, new GregorianCalendar(), "",0);
	}

	/**
	 * @return the numeroExamen
	 */
	public int getNumeroExamen() {
		return numeroExamen;
	}

	/**
	 * @param numeroExamen the numeroExamen to set
	 */
	public void setNumeroExamen(int numeroExamen) {
		this.numeroExamen = numeroExamen;
	}

	/**
	 * @return the horaire
	 */
	public GregorianCalendar getHoraire() {
		return horaire;
	}

	/**
	 * @param horaire the horaire to set
	 */
	public void setHoraire(GregorianCalendar horaire) {
		this.horaire = horaire;
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
	 * @return the maFormation
	 */
	public int getMaFormation() {
		return maFormation;
	}

	/**
	 * @param maFormation the maFormation to set
	 */
	public void setMaFormation(int maFormation) {
		this.maFormation = maFormation;
	}

	/**
	 * @return the monUE
	 */
	public int getMonUE() {
		return monUE;
	}

	/**
	 * @param monUE the monUE to set
	 */
	public void setMonUE(int monUE) {
		this.monUE = monUE;
	}

	/**
	 * @return the monEC
	 */
	public int getMonEC() {
		return monEC;
	}

	/**
	 * @param monEC the monEC to set
	 */
	public void setMonEC(int monEC) {
		this.monEC = monEC;
	}

	/**
	 * @return the date
	 */
	public Jours getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Jours date) {
		this.date = date;
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
