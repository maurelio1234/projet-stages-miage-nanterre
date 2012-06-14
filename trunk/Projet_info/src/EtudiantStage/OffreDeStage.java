package EtudiantStage;


	import java.util.GregorianCalendar;


	public class OffreDeStage {
	    private int numeroOffreDeStage;
	    private String descriptionPoste;
	    private String etatOffre;
	    private int numeroEntreprise;
	    private GregorianCalendar dateDebutStage;
	    private GregorianCalendar dateFinStage;
		
	    /**
		 * 
		 */
		public OffreDeStage() {
		}

		/**
		 * @param numeroOffreDeStage
		 * @param descriptionPoste
		 * @param etatOffre
		 * @param numeroEntreprise
		 * @param dateDebutStage
		 * @param dateFinStage
		 */
		public OffreDeStage(int numeroOffreDeStage, String descriptionPoste,
				String etatOffre, int numeroEntreprise,
				GregorianCalendar dateDebutStage, GregorianCalendar dateFinStage) {
			this.numeroOffreDeStage = numeroOffreDeStage;
			this.descriptionPoste = descriptionPoste;
			this.etatOffre = etatOffre;
			this.numeroEntreprise = numeroEntreprise;
			this.dateDebutStage = dateDebutStage;
			this.dateFinStage = dateFinStage;
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
		 * @return the descriptionPoste
		 */
		public String getDescriptionPoste() {
			return descriptionPoste;
		}

		/**
		 * @param descriptionPoste the descriptionPoste to set
		 */
		public void setDescriptionPoste(String descriptionPoste) {
			this.descriptionPoste = descriptionPoste;
		}

		/**
		 * @return the etatOffre
		 */
		public String getEtatOffre() {
			return etatOffre;
		}

		/**
		 * @param etatOffre the etatOffre to set
		 */
		public void setEtatOffre(String etatOffre) {
			this.etatOffre = etatOffre;
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

		/**
		 * @return the dateDebutStage
		 */
		public GregorianCalendar getDateDebutStage() {
			return dateDebutStage;
		}

		/**
		 * @param dateDebutStage the dateDebutStage to set
		 */
		public void setDateDebutStage(GregorianCalendar dateDebutStage) {
			this.dateDebutStage = dateDebutStage;
		}

		/**
		 * @return the dateFinStage
		 */
		public GregorianCalendar getDateFinStage() {
			return dateFinStage;
		}

		/**
		 * @param dateFinStage the dateFinStage to set
		 */
		public void setDateFinStage(GregorianCalendar dateFinStage) {
			this.dateFinStage = dateFinStage;
		}
	   
	
}
