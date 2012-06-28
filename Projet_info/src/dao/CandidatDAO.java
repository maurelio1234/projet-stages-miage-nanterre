package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import beans.Candidat;


public class CandidatDAO extends DAO<Candidat>{
	
	private String FIND_CANDIDAT = "SELECT * FROM candidat WHERE no_candidat=";
	private String CREATE_CANDIDAT = "INSERT INTO candidat VALUES (";
	private String DELETE_CANDIDAT = "DELETE FROM candidat WHERE no_candidat=";
	private String UPDATE_CANDIDAT = "UPDATE candidat SET ";
	private String LIST_CANDIDAT = "SELECT * FROM candidat";

	private Statement st;
	
	public CandidatDAO() throws SQLException{
		Connection cx=DriverManager.getConnection("jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:1521:MIAGE","xacouder","enhancer");
		st = (Statement) cx.createStatement();
	}

	@Override
	public Candidat create(Candidat candidat) {
		return candidat;
		
	}

	@Override
	public void delete(Candidat candidat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Candidat update(Candidat candidat) {
		return candidat;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Candidat find(int no_candidat) {
		return null;
		/*ResultSet rs = this.st.executeQuery(FIND_CANDIDAT + no_candidat);
		Candidat candidat = new Candidat();
		candidat.setNumeroCandidat(rs.getInt("no_candidat"));
		candidat.setNom(rs.getString("nom_candidat"));
		candidat.setPrenom(rs.getString("prenom_candidat"));
		candidat.setAdresse(rs.getString("adresse_candidat"));
		candidat.setTelephone(rs.getString("telephone_candidat"));
		GregorianCalendar date = new GregorianCalendar();
		candidat.setDateNaissance(date.setTime(rs.getDate("date_naissance")));
		candidat.setLogin(rs.getString("login_candidat"));
		candidat.setPassword(rs.getString("mdp_candidat"));
		candidat.setMail(rs.getString("email_candidat"));
		candidat.setEtatDuDossier(rs.getBoolean("etat_du_dossier"));
		
		return candidat;*/
	}

	public ArrayList<Candidat> getList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidat> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
