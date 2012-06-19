<<<<<<< .mine

=======
import java.beans.Statement;
>>>>>>> .r48
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Candidat;
import beans.Etudiant;


public class EtudiantDAO extends DAO<Etudiant>{
	
	private Statement st;

	private String FIND_ETUDIANT = "SELECT * FROM candidat, etudiant WHERE candidat.no_candidat=etudiant.no_candidat AND candidat.no_etudiant=";
	private String CREATE_ETUDIANT = "INSERT INTO etudiant(no_etudiant,no_candidat) VALUES (";
	private String DELETE_ETUDIANT = "DELETE FROM etudiant WHERE no_etudiant=";
	private String UPDATE_ETUDIANT = "UPDATE etudiant SET ";
	private String LIST_ETUDIANT = "SELECT * FROM candidat, etudiant WHERE candidat.no_candidat=etudiant.no_candidat";
<<<<<<< .mine

	public EtudiantDAO() throws SQLException {
		Connection cx=DriverManager.getConnection("jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:1521:MIAGE","xacouder","enhancer");
		st = (Statement) cx.createStatement();
	}
=======
	
>>>>>>> .r48
<<<<<<< .mine
=======
	
	public EtudiantDAO() throws SQLException {
		
		Connection cx = DriverManager.getConnection("jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:1521:MIAGE", "nadiop","finadiop");
        Statement st=(Statement) cx.createStatement();
		// TODO Auto-generated constructor stub
	}
>>>>>>> .r48

	public Etudiant find(int numEtudiant) throws SQLException{
		Etudiant etudiant = new Etudiant();
		Candidat candidat = new Candidat();
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
		return etudiant;
	}

	@Override
	public void create(Etudiant etudiant) throws SQLException {
		this.st.executeUpdate(CREATE_ETUDIANT + etudiant.getNumeroEtudiant() + "," + etudiant.getMonCandidat().getNumeroCandidat());
	}

	@Override
	public void delete(Etudiant etudiant) throws SQLException {
		this.st.executeUpdate(DELETE_ETUDIANT + etudiant.getNumeroEtudiant());
	}

	@Override
	public void update(Etudiant etudiant) throws SQLException {
		this.st.executeUpdate(UPDATE_ETUDIANT + etudiant.getNumeroEtudiant());	
	}

	@Override
	public ArrayList<Etudiant> getList() throws SQLException {
		ArrayList<Etudiant> listEtudiants = new ArrayList();
		Etudiant etudiant = new Etudiant();;
		Candidat candidat = new Candidat();;
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
			}
			listEtudiants.add(etudiant);
		}
		return listEtudiants;
	}
	
	
}
