package EtudiantStage;

import java.util.GregorianCalendar;


	public class ConventionStage {
	    private int numeroConvention;
	    private GregorianCalendar dateSignatureC;
	    private int dureeC;
	    private int numeroOffreDeStage;
	    private int numeroEtudiant;
		
	    /**
		 * 
		 */
		public ConventionStage() {
		}

		/**
		 * @param numeroConvention
		 * @param dateSignatureC
		 * @param dureeC
		 * @param numeroOffreDeStage
		 * @param numeroEtudiant
		 */
		public ConventionStage(int numeroConvention,
				GregorianCalendar dateSignatureC, int dureeC,
				int numeroOffreDeStage, int numeroEtudiant) {
			this.numeroConvention = numeroConvention;
			this.dateSignatureC = dateSignatureC;
			this.dureeC = dureeC;
			this.numeroOffreDeStage = numeroOffreDeStage;
			this.numeroEtudiant = numeroEtudiant;
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
		 * @return the dateSignatureC
		 */
		public GregorianCalendar getDateSignatureC() {
			return dateSignatureC;
		}

		/**
		 * @param dateSignatureC the dateSignatureC to set
		 */
		public void setDateSignatureC(GregorianCalendar dateSignatureC) {
			this.dateSignatureC = dateSignatureC;
		}

		/**
		 * @return the dureeC
		 */
		public int getDureeC() {
			return dureeC;
		}

		/**
		 * @param dureeC the dureeC to set
		 */
		public void setDureeC(int dureeC) {
			this.dureeC = dureeC;
		}

		/**
		 * @return the numeroOffreDeStage
		 */
		public int getNumeroOffreDeStage() {
			return numeroOffreDeStage;
		}

		/**
		 * @param numeroOffreDeStage the numeroOffreDeStage to set
		 */
		public void setNumeroOffreDeStage(int numeroOffreDeStage) {
			this.numeroOffreDeStage = numeroOffreDeStage;
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
		
	

}
