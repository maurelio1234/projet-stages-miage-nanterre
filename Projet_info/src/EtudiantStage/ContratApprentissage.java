package EtudiantStage;

import java.util.GregorianCalendar;

	public class ContratApprentissage {
		private int numeroContrat;
		private GregorianCalendar dateSignatureA;
		private Double salaire;
		private int duree;
		private int numeroEtudiant;
		private int numeroEntreprise;
		
		/**
		 * 
		 */
		public ContratApprentissage() {
		}

		/**
		 * @param numeroContrat
		 * @param dateSignatureA
		 * @param salaire
		 * @param duree
		 * @param numeroEtudiant
		 * @param numeroEntreprise
		 */
		public ContratApprentissage(int numeroContrat,
				GregorianCalendar dateSignatureA, Double salaire, int duree,
				int numeroEtudiant, int numeroEntreprise) {
			this.numeroContrat = numeroContrat;
			this.dateSignatureA = dateSignatureA;
			this.salaire = salaire;
			this.duree = duree;
			this.numeroEtudiant = numeroEtudiant;
			this.numeroEntreprise = numeroEntreprise;
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
		 * @return the dateSignatureA
		 */
		public GregorianCalendar getDateSignatureA() {
			return dateSignatureA;
		}

		/**
		 * @param dateSignatureA the dateSignatureA to set
		 */
		public void setDateSignatureA(GregorianCalendar dateSignatureA) {
			this.dateSignatureA = dateSignatureA;
		}

		/**
		 * @return the salaire
		 */
		public Double getSalaire() {
			return salaire;
		}

		/**
		 * @param salaire the salaire to set
		 */
		public void setSalaire(Double salaire) {
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
		 * @return the numeroEntreprise
		 */
		public int getNumeroEntreprise() {
			return numeroEntreprise;
		}

		/**
		 * @param numeroEntreprise the numeroEntreprise to set
		 */
		public void setNumeroEntreprise(int numeroEntreprise) {
			this.numeroEntreprise = numeroEntreprise;
		}
		
	

}
