package EtudiantStage;
	

public class Entreprise {
    private int numeroEntreprise;
    private String nom;
    private String adresse;
    private String telephone;
    private String mail;
    private String login;
    private String pwd;
	
    /**
	 * 
	 */
	public Entreprise() {
	}

	/**
	 * @param numeroEntreprise
	 * @param nom
	 * @param adresse
	 * @param telephone
	 * @param mail
	 * @param login
	 * @param pwd
	 */
	public Entreprise(int numeroEntreprise, String nom, String adresse,
			String telephone, String mail, String login, String pwd) {
		this.numeroEntreprise = numeroEntreprise;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.mail = mail;
		this.login = login;
		this.pwd = pwd;
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
