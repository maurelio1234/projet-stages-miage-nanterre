import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Candidat;
import beans.Etudiant;


public class EtudiantDAO extends DAO<Etudiant>{

	private String FIND_ETUDIANT = "SELECT * FROM candidat, etudiant WHERE candidat.no_candidat=etudiant.no_candidat AND candidat.no_etudiant=";
	private String CREATE_ETUDIANT = "INSERT INTO etudiant(no_etudiant,no_candidat) VALUES (";
	private String DELETE_ETUDIANT = "DELETE FROM etudiant WHERE no_etudiant=";
	private String UPDATE_ETUDIANT = "UPDATE etudiant SET ";
	private String LIST_ETUDIANT = "SELECT * FROM candidat, etudiant WHERE candidat.no_candidat=etudiant.no_candidat";
	
	Connection newConnection() throws SQLException {
	    final String url = "jdbc:mysql://localhost/miage";
	    Connection conn = DriverManager.getConnection(url, "xacouder", "enhancer");
	    return conn;
	}
	
	public EtudiantDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	public Etudiant find(int numEtudiant) throws SQLException{
		Connection conn = newConnection();
		Etudiant etudiant = new Etudiant();
		Candidat candidat = new Candidat();
		ResultSet rs = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(FIND_ETUDIANT + numEtudiant);
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
		conn.close();
		return etudiant;
	}

	@Override
	public void create(Etudiant etudiant) throws SQLException {
		this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(CREATE_ETUDIANT + etudiant.getNumeroEtudiant() + "," + etudiant.getMonCandidat().getNumeroCandidat());
	}

	@Override
	public void delete(Etudiant etudiant) throws SQLException {
		this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(DELETE_ETUDIANT + etudiant.getNumeroEtudiant());
	}

	@Override
	public void update(Etudiant etudiant) throws SQLException {
		this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(UPDATE_ETUDIANT + 
				etudiant.getNumeroEtudiant());	
	}

	@Override
	public ArrayList<Etudiant> getList() throws SQLException {
		ArrayList<Etudiant> listEtudiants = new ArrayList();
		Etudiant etudiant = new Etudiant();;
		Candidat candidat = new Candidat();;
		ResultSet rs = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(LIST_ETUDIANT);
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
