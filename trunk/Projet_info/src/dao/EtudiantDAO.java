package dao;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Candidat;
import beans.Etudiant;

public class EtudiantDAO extends DAO<Etudiant> {

	private Statement st;

	private String FIND_ETUDIANT = "SELECT * FROM candidat, etudiant WHERE candidat.no_candidat=etudiant.no_candidat AND etudiant.no_etudiant=";
	private String CREATE_ETUDIANT = "INSERT INTO etudiant(no_etudiant,no_candidat) VALUES (";
	private String DELETE_ETUDIANT = "DELETE FROM etudiant WHERE no_etudiant=";
	private String UPDATE_ETUDIANT = "UPDATE etudiant SET ";
	private String LIST_ETUDIANT = "SELECT * FROM candidat, etudiant WHERE candidat.no_candidat=etudiant.no_candidat";
	private String FIND_ID_ETUDIAND_BY_LOGIN_MDP = "SELECT e.no_etudiant FROM candidat c, etudiant e WHERE c.no_candidat=e.no_candidat AND c.login_candidat='";
	
	public EtudiantDAO() throws SQLException{
		this.connect = DriverManager.getConnection(
				"jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:",
				"", "");
		st = connect.createStatement();
	}

	public Etudiant find(int numEtudiant) throws SQLException {
		Etudiant etudiant = new Etudiant();
		Candidat candidat = new Candidat();
		try {
			ResultSet rs = this.st.executeQuery(FIND_ETUDIANT + numEtudiant);
			while(rs.next()){
				etudiant.setNumeroEtudiant(rs.getInt("no_candidat"));
				candidat.setNom(rs.getString("nom_candidat"));
				candidat.setPrenom(rs.getString("prenom_candidat"));
				candidat.setAdresse(rs.getString("adresse_candidat"));
				candidat.setTelephone(rs.getString("telephone_candidat"));
				candidat.setLogin(rs.getString("login_candidat"));
				candidat.setMail(rs.getString("email_candidat"));
				candidat.setPassword(rs.getString("mdp_candidat"));
				etudiant.setMonCandidat(candidat);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return etudiant;
	}

	public int AuthentificationEtudiant(String login, String mdp) throws SQLException {
		int id_etudiant=0;
		ResultSet rs = this.st.executeQuery(FIND_ID_ETUDIAND_BY_LOGIN_MDP + login + "'AND c.mdp_candidat='"+mdp + "'");
		while (rs.next()) {
			id_etudiant = rs.getInt("no_etudiant");
		}
		return id_etudiant;
	}

	
	public void create(Etudiant etudiant) throws SQLException {
			this.st.executeUpdate(CREATE_ETUDIANT + etudiant.getNumeroEtudiant() + "," + etudiant.getMonCandidat().getNumeroCandidat());
	}


	public void delete(Etudiant etudiant) {
		try {
			this.st.executeUpdate(DELETE_ETUDIANT + etudiant.getNumeroEtudiant());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void update(Etudiant etudiant) {
		try {
			this.st.executeUpdate(UPDATE_ETUDIANT + etudiant.getNumeroEtudiant());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		
	public List<Etudiant> findAll() throws SQLException {
	ArrayList<Etudiant> listEtudiants = new ArrayList<Etudiant>();
	Etudiant etudiant = new Etudiant();
	Candidat candidat = new Candidat();
	ResultSet rs = this.st.executeQuery(LIST_ETUDIANT);
	for (int i = 0; i < rs.getFetchSize(); i++) {
		while (rs.next()) {
			etudiant.setNumeroEtudiant(rs.getInt("no_candidat"));
			candidat.setNom(rs.getString("nom_candidat"));
			candidat.setPrenom(rs.getString("prenom_candidat"));
			candidat.setAdresse(rs.getString("adresse"));
			candidat.setTelephone(rs.getString("telephone"));
			candidat.setLogin(rs.getString("login"));
			candidat.setMail(rs.getString("mail"));
			candidat.setPassword(rs.getString("pasword"));
			etudiant.setMonCandidat(candidat);
		}
		listEtudiants.add(etudiant);
	}
	return listEtudiants;
	}
}
	
