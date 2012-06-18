import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Candidat;
import beans.Etudiant;


public class EtudiantDAO extends DAO<Etudiant>{

	public EtudiantDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	private String INFO_ETUDIANT = "SELECT * FROM candidat, etudiant WHERE candidat.no_candidat=etudiant.no_candidat AND candidat.no_etudiant=";
	
	public Etudiant find(int numEtudiant) throws SQLException{
		Etudiant etudiant = new Etudiant();
		Candidat candidat = new Candidat();
		ResultSet rs = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(INFO_ETUDIANT + numEtudiant);
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
		return etudiant;
	}

	@Override
	public boolean create(Etudiant obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Etudiant obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Etudiant obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
