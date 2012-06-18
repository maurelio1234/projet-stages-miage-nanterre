package beans;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;


public class Enseignant {
    private int numeroEnseignant;
    private TypePoste monPoste;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private GregorianCalendar dateNaissance;
    private String login;
    private String password;
    private List<VoeuxEC> mesVoeuxEC = new ArrayList<VoeuxEC>();
    private List<Indisponibilite> mesIndispos = new ArrayList<Indisponibilite>();
    private List<Creneau> mesCreneaux = new ArrayList<Creneau>();
    private List<Service> mesServices = new ArrayList<Service>();
	
    /**
     * 
     */
    public Enseignant() {
    	super();
	}

    /**
     * @param numeroEnseignant
     * @param nom
     * @param prenom
     * @param adresse
     * @param telephone
     * @param dateNaissance
     * @param login
     * @param password
     */
	public Enseignant(int numeroEnseignant, String nom, String prenom,String adresse, String telephone, GregorianCalendar dateNaissance,String login, String password) {
		this();
		this.setNumeroEnseignant(numeroEnseignant);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdresse(adresse);
		this.setTelephone(telephone);
		this.setDateNaissance(dateNaissance);
		this.setLogin(login);
		this.setPassword(password);
	}

    /**
     * @param numeroEnseignant
     */
	public Enseignant(int numeroEnseignant) {
		this(numeroEnseignant, "","", "", "", new GregorianCalendar(), "", "");
	}

	/**
	 * @return the numeroEnseignant
	 */
	public int getNumeroEnseignant() {
		return numeroEnseignant;
	}

	/**
	 * @param numeroEnseignant the numeroEnseignant to set
	 */
	public void setNumeroEnseignant(int numeroEnseignant) {
		this.numeroEnseignant = numeroEnseignant;
	}

	/**
	 * @return the monPoste
	 */
	public TypePoste getMonPoste() {
		return monPoste;
	}

	/**
	 * @param monPoste the monPoste to set
	 */
	public void setMonPoste(TypePoste monPoste) {
		this.monPoste = monPoste;
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
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	 * @return the dateNaissance
	 */
	public GregorianCalendar getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(GregorianCalendar dateNaissance) {
		this.dateNaissance = dateNaissance;
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
	 * @return the mesVoeuxEC
	 */
	public List<VoeuxEC> getMesVoeuxEC() {
		return mesVoeuxEC;
	}

	/**
	 * @param mesVoeuxEC the mesVoeuxEC to set
	 */
	public void setMesVoeuxEC(List<VoeuxEC> mesVoeuxEC) {
		this.mesVoeuxEC = mesVoeuxEC;
	}

	/**
	 * @return the mesIndispos
	 */
	public List<Indisponibilite> getMesIndispos() {
		return mesIndispos;
	}

	/**
	 * @param mesIndispos the mesIndispos to set
	 */
	public void setMesIndispos(List<Indisponibilite> mesIndispos) {
		this.mesIndispos = mesIndispos;
	}

	/**
	 * @return the mesCreneaux
	 */
	public List<Creneau> getMesCreneaux() {
		return mesCreneaux;
	}

	/**
	 * @param mesCreneaux the mesCreneaux to set
	 */
	public void setMesCreneaux(List<Creneau> mesCreneaux) {
		this.mesCreneaux = mesCreneaux;
	}

	/**
	 * @return the mesServices
	 */
	public List<Service> getMesServices() {
		return mesServices;
	}

	/**
	 * @param mesServices the mesServices to set
	 */
	public void setMesServices(List<Service> mesServices) {
		this.mesServices = mesServices;
	}
	
}
