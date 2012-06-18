package beans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Entreprise implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -350229262121986549L;
	private int numeroEntreprise;
    private String nom;
    private String adresse;
    private String telephone;
    private String mail;
    private String login;
    private String password;
    private List<ContratApprentissage> mesContratsApprentissage = new ArrayList<ContratApprentissage>();
    private List<OffreDeStage> mesOffres = new ArrayList<OffreDeStage>();
	
    /**
	 * 
	 */
	public Entreprise() {
		super();
	}

	/**
	 * @param numeroEntreprise
	 * @param nom
	 * @param adresse
	 * @param telephone
	 * @param mail
	 * @param login
	 * @param password
	 */
	public Entreprise(int numeroEntreprise, String nom, String adresse,
			String telephone, String mail, String login, String password) {
		this();
		this.numeroEntreprise = numeroEntreprise;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.mail = mail;
		this.login = login;
		this.password = password;
	}
	
	public Entreprise(int numeroEntreprise){
		this(numeroEntreprise,"","","","","","");
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the mesContratsApprentissage
	 */
	public List<ContratApprentissage> getMesContratsApprentissage() {
		return mesContratsApprentissage;
	}

	/**
	 * @param mesContratsApprentissage the mesContratsApprentissage to set
	 */
	public void setMesContratsApprentissage(
			List<ContratApprentissage> mesContratsApprentissage) {
		this.mesContratsApprentissage = mesContratsApprentissage;
	}

	/**
	 * @return the mesOffres
	 */
	public List<OffreDeStage> getMesOffres() {
		return mesOffres;
	}

	/**
	 * @param mesOffres the mesOffres to set
	 */
	public void setMesOffres(List<OffreDeStage> mesOffres) {
		this.mesOffres = mesOffres;
	}
	
}
