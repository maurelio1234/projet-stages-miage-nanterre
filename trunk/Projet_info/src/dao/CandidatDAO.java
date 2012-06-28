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
import beans.Etudiant;


public class CandidatDAO extends DAO<Candidat>{
	
	private String FIND_CANDIDAT = "SELECT * FROM candidat WHERE no_candidat=";
	private String CREATE_CANDIDAT = "INSERT INTO candidat VALUES (";
	private String DELETE_CANDIDAT = "DELETE FROM candidat WHERE no_candidat=";
	private String UPDATE_CANDIDAT = "UPDATE candidat SET ";
	private String LIST_CANDIDAT = "SELECT * FROM candidat";

	private Statement st;
	
	public CandidatDAO()throws SQLException{
		this.connect = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/MIAGE",
				"xacouder", "enhancer");
		st = connect.createStatement();
	}

	@Override
	public Candidat create(Candidat candidat) {
		return null;
	}

	@Override
	public void delete(Candidat candidat) {
		// TODO Auto-generated method stub
		
	}

	public Candidat update(Candidat candidat) {
		Candidat candidat_recup = new  Candidat();
		try {
			this.st.executeUpdate(UPDATE_CANDIDAT + "adresse_candidat='" + candidat.getAdresse() +"', telephone_candidat='" + candidat.getTelephone() + "' WHERE no_candidat=" +candidat.getNumeroCandidat() );
			candidat_recup = find(candidat.getNumeroCandidat());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return candidat_recup;
	}
	

	public Candidat find(int no_candidat) {
		return null;
		/*ResultSet rs = this.st.executeQuery(FIND_CANDIDAT + no_candidat);
>>>>>>> .r123
		Candidat candidat = new Candidat();
		try {
			rs = this.st.executeQuery(FIND_CANDIDAT + no_candidat);
			candidat.setNumeroCandidat(rs.getInt("no_candidat"));
			candidat.setNom(rs.getString("nom_candidat"));
			candidat.setPrenom(rs.getString("prenom_candidat"));
			candidat.setAdresse(rs.getString("adresse_candidat"));
			candidat.setTelephone(rs.getString("telephone_candidat"));
			//GregorianCalendar date = new GregorianCalendar();
			//candidat.setDateNaissance(date.setTime(rs.getDate("date_naissance")));
			candidat.setLogin(rs.getString("login_candidat"));
			candidat.setPassword(rs.getString("mdp_candidat"));
			candidat.setMail(rs.getString("email_candidat"));
			candidat.setEtatDuDossier(rs.getBoolean("etat_du_dossier"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return candidat;*/
	}

	public ArrayList<Candidat> findAll() {
		return null;
	}
	
	public ArrayList<Candidat> findAllByPromo(int numPromo){
		ArrayList<Candidat> candidantByPromo = new ArrayList<Candidat>();
		
		return candidantByPromo;
	}

}
