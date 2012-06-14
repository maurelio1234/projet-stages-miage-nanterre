package EtudiantStage;

import java.util.ArrayList;
import java.util.GregorianCalendar;

	public class Examen {
	    private int numeroExamen;
	    private GregorianCalendar horaire;
	    private String libelle;
	    private Double coefficient;
	    private int numeroType;
	    private int numeroFormation;
		private int numeroUE;
	    private int numeroEC;
		
	    /**
		 * 
		 */
		public Examen() {
		}

		/**
		 * @param numeroExamen
		 * @param horaire
		 * @param libelle
		 * @param coefficient
		 * @param numeroType
		 * @param numeroFormation
		 * @param numeroUE
		 * @param numeroEC
		 */
		public Examen(int numeroExamen, GregorianCalendar horaire, String libelle,
				Double coefficient, int numeroType, int numeroFormation,
				int numeroUE, int numeroEC) {
			this.numeroExamen = numeroExamen;
			this.horaire = horaire;
			this.libelle = libelle;
			this.coefficient = coefficient;
			this.numeroType = numeroType;
			this.numeroFormation = numeroFormation;
			this.numeroUE = numeroUE;
			this.numeroEC = numeroEC;
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
		public Double getCoefficient() {
			return coefficient;
		}

		/**
		 * @param coefficient the coefficient to set
		 */
		public void setCoefficient(Double coefficient) {
			this.coefficient = coefficient;
		}

		/**
		 * @return the numeroType
		 */
		public int getNumeroType() {
			return numeroType;
		}

		/**
		 * @param numeroType the numeroType to set
		 */
		public void setNumeroType(int numeroType) {
			this.numeroType = numeroType;
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
		 * @return the numeroUE
		 */
		public int getNumeroUE() {
			return numeroUE;
		}

		/**
		 * @param numeroUE the numeroUE to set
		 */
		public void setNumeroUE(int numeroUE) {
			this.numeroUE = numeroUE;
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
	       

}
