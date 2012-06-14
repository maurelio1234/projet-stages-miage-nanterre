package EtudiantStage;


public class Promotion {
	private int numeroPromotion;
	private int numeroFormation;
	
	/**
	 * 
	 */
	public Promotion() {
	}

	/**
	 * @param numeroPromotion
	 * @param numeroFormation
	 */
	public Promotion(int numeroPromotion, int numeroFormation) {
		this.numeroPromotion = numeroPromotion;
		this.numeroFormation = numeroFormation;
	}

	/**
	 * @return the numeroPromotion
	 */
	public int getNumeroPromotion() {
		return numeroPromotion;
	}

	/**
	 * @param numeroPromotion the numeroPromotion to set
	 */
	public void setNumeroPromotion(int numeroPromotion) {
		this.numeroPromotion = numeroPromotion;
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
	
}


