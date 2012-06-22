package dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import beans.Candidat;
import beans.Etudiant;


public class EtudiantDAO extends DAO<Etudiant>{
	
	private Statement st;

	private String FIND_ETUDIANT = "SELECT * FROM candidat, etudiant WHERE candidat.no_candidat=etudiant.no_candidat AND candidat.no_etudiant=";
	private String CREATE_ETUDIANT = "INSERT INTO etudiant(no_etudiant,no_candidat) VALUES (";
	private String DELETE_ETUDIANT = "DELETE FROM etudiant WHERE no_etudiant=";
	private String UPDATE_ETUDIANT = "UPDATE etudiant SET ";
	private String LIST_ETUDIANT = "SELECT * FROM candidat, etudiant WHERE candidat.no_candidat=etudiant.no_candidat";
	private String FIND_ETU_LOG = "SELECT * FROM candidat, etudiant WHERE login_candidat =";
	private String FIND_ETU_LOG2 = "and mdp_candidat=";

	private Hashtable<String,String> identifetu=new Hashtable();
	private ArrayList<Etudiant> listEtudiants = new ArrayList();

	public EtudiantDAO() throws SQLException {
		Connection cx= DriverManager.getConnection("jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:1521:MIAGE","davay","apprentis2010pw");
		st = (Statement) cx.createStatement();
		Etudiant etudiant = new Etudiant();
		Candidat candidat = new Candidat();
		ResultSet rs = this.st.executeQuery(LIST_ETUDIANT);
		for(int i=0; i<rs.getFetchSize(); i++){
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
				identifetu.put(rs.getString("login_candidat"), rs.getString("mdp_candidat"));
				
			}
			listEtudiants.add(etudiant);
		}
		
	}


	public Etudiant find(int numEtudiant){
		Etudiant etudiant = new Etudiant();
		Candidat candidat = new Candidat();
		//ResultSet rs = this.st.executeQuery(FIND_ETUDIANT + numEtudiant);
		try {
			ResultSet rs = this.st.executeQuery(FIND_ETUDIANT + numEtudiant);
			while(rs.next()){
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return etudiant;
	}
	
	public Etudiant Etudiant_logger (String login, String mdp) throws SQLException{
		Etudiant etudiant = new Etudiant();
		Candidat candidat = new Candidat();
		ResultSet rs = this.st.executeQuery(FIND_ETU_LOG + "'"+login+"'"+ FIND_ETU_LOG2+"'"+mdp+"'");
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
		return etudiant;
	}
	
	public boolean AuthEtu(String login,String mdp){
		
		
		if(this.identifetu.containsKey(login)==false){
			return false;
		}
		else{
			if(identifetu.get(login).equals(mdp)){
				
				return true;
			}
			else{
				return false;
			}
		}
		
	}

	@Override
	public Etudiant create(Etudiant etudiant) {
		try {
			this.st.executeUpdate(CREATE_ETUDIANT + etudiant.getNumeroEtudiant() + "," + etudiant.getMonCandidat().getNumeroCandidat());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return etudiant;
	}

	@Override
	public void delete(Etudiant etudiant) {
		try {
			this.st.executeUpdate(DELETE_ETUDIANT + etudiant.getNumeroEtudiant());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Etudiant update(Etudiant etudiant) {
		try {
			this.st.executeUpdate(UPDATE_ETUDIANT + etudiant.getNumeroEtudiant());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return etudiant;	
	}

	public ArrayList<Etudiant> getList() throws SQLException {
		ArrayList<Etudiant> listEtudiants = new ArrayList();
		Etudiant etudiant = new Etudiant();
		Candidat candidat = new Candidat();
		ResultSet rs = this.st.executeQuery(LIST_ETUDIANT);
		for(int i=0; i<rs.getFetchSize(); i++){
			while(rs.next()){
				etudiant.setNumeroEtudiant(rs.getInt("no_candidat"));
				candidat.setNom(rs.getString("nom_candidat"));
				candidat.setPrenom(rs.getString("prenom_candidat"));
				candidat.setAdresse(rs.getString("adresse"));
				candidat.setTelephone(rs.getString("telephone"));
				candidat.setLogin(rs.getString("login"));
				candidat.setMail(rs.getString("mail"));
				candidat.setPassword(rs.getString("pasword"));
				etudiant.setMonCandidat(candidat);
				identifetu.put(rs.getString("login"), rs.getString("pasword"));
			}
			listEtudiants.add(etudiant);
		}
		return listEtudiants;
	}


	@Override
	public List<Etudiant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
