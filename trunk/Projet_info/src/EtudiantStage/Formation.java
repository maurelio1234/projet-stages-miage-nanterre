package EtudiantStage;

public class Formation {
    private int numeroFormation;
    private int numeroContrat;
    private String libelle;
    private String niveau;
    private String type;
    private String parcours;
	
    public Formation() {
	}

	public Formation(int numeroFormation, int numeroContrat, String libelle, String niveau,String type, String parcours) {
		this.numeroFormation = numeroFormation;
		this.numeroContrat = numeroContrat;
		this.libelle = libelle;
		this.niveau = niveau;
		this.type = type;
		this.parcours = parcours;
	}

	public int getNumeroFormation() {
		return numeroFormation;
	}

	public void setNumeroFormation(int numeroFormation) {
		this.numeroFormation = numeroFormation;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParcours() {
		return parcours;
	}

	public void setParcours(String parcours) {
		this.parcours = parcours;
	}

	public int getNumeroContrat() {
		return numeroContrat;
	}

	public void setNumeroContrat(int numeroContrat) {
		this.numeroContrat = numeroContrat;
	}

}
