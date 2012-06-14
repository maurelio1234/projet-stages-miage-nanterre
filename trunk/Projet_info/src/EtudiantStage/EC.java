package EtudiantStage;

public class EC {
    private int numeroEC;
    private int numeroFormation;
    private int numeroUE;
    private String libelle;
    private double coef;
	
    public EC() {
	}
	
    public EC(int numeroEC, int numeroUE, int numeroFormation, String libelle, double coef) {
		this.numeroEC = numeroEC;
		this.setNumeroUE(numeroUE);
		this.setNumeroFormation(numeroFormation);
		this.libelle = libelle;
		this.coef = coef;
	}

	public int getNumeroEC() {
		return numeroEC;
	}

	public void setNumeroEC(int numeroEC) {
		this.numeroEC = numeroEC;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getCoef() {
		return coef;
	}

	public void setCoef(double coef) {
		this.coef = coef;
	}

	public int getNumeroFormation() {
		return numeroFormation;
	}

	public void setNumeroFormation(int numeroFormation) {
		this.numeroFormation = numeroFormation;
	}

	public int getNumeroUE() {
		return numeroUE;
	}

	public void setNumeroUE(int numeroUE) {
		this.numeroUE = numeroUE;
	}
}


