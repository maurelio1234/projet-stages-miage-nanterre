import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import beans.Candidat;
import beans.ConventionStage;
import beans.Entreprise;
import beans.Etudiant;
import beans.Jours;
import beans.OffreDeStage;


public class EntrepriseDAO extends DAO<Entreprise>{
	
	private String FIND_ENTREPRISE = "SELECT * FROM ENTREPRISE WHERE LOGIN_ENTREPRISE = log and MDP_ENTREPRISE = mdp";
	private String CREATE_ENTREPRISE = "INSERT INTO Entreprise values (";
	private String DELETE_ENTREPRISE = "DELETE FROM Entreprise WHERE no_entreprise=";
	private String UPDATE_ENTREPRISE = "UPDATE Entreprise SET ";

	private String LIST_ENTREPRISE = "SELECT * FROM ENTREPRISE";

	private String LIST_OFFRESTAGE = "SELECT * FROM ENTREPRISE OFFRE_STAGE WHERE NO_ENTREPRISE =";
	
	private String FIND_OFFRESTAGE = "SELECT * FROM OFFRE_STAGE WHERE DESCRPTION_OFFRE = desc";
	private String CREATE_OFFRESTAGE = "INSERT INTO OFFRE_STAGE ...";
	private String DELETE_OFFRESTAGE = "DELETE FROM OFFRE_STAGE WHERE ...";
	private String UPDATE_OFFRESTAGE = "UPDATE OFFRE_STAGE SET ";
	

	
	//table = new hashtable();
	
	Connection newConnection() throws SQLException {
	    final String url = "jdbc:mysql://localhost/miage";
	    Connection conn = DriverManager.getConnection(url, "xacouder", "enhancer");
	    return conn;
	}
	
	public EntrepriseDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}
	
	public void EntrepriseConnexion(String log, String mdp){
		
		try{
			Connection conn = newConnection();
			Etudiant etudiant = new Etudiant();
			Candidat candidat = new Candidat();
			ResultSet rs = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(FIND_ENTREPRISE);
        
           //A MODIFIFER
        }
        
	      catch(SQLException ex){
	        System.err.println("Erreur lors de la connexion a la base");
	        System.exit(1);
	      }
		
	}
	
	
	public void ChargerOffreEnt(Entreprise ent){
		
		try{

	        ResultSet rs = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(LIST_ENTREPRISE + ent.getNumeroEntreprise());

	        List<OffreDeStage> listeOffre = new ArrayList<OffreDeStage>();
	        GregorianCalendar calendar = new GregorianCalendar();
	        OffreDeStage ods = new OffreDeStage();
	        ConventionStage cvst = new ConventionStage();
	        Jours jr = new Jours();
	        
	        
	        for(int i=0; i<rs.getFetchSize(); i++){
				while(rs.next()){
					
					
					ods.setDescriptionPoste(rs.getString("DESCRIPTION_OFFRE"));
					ods.setEtatOffre(rs.getString("ETAT_OFFRE"));
					ods.setNumeroOffreDeStage(rs.getInt("NO_OFFRE"));
					ods.setMonEntreprise(ent);
					
					ods.setMaConvention(cvst);
					
					//date
					GregorianCalendar jourDebut = asCalendar(rs.getDate("DATE_DEBUT_STAGE"));
					jr.setDate(jourDebut);
					ods.setDateDebutStage(jr);
					
//					//date
//					int day = calendar.get(calendar.DATE);
//					int month = calendar.get(calendar.MONTH);
//					int year = calendar.get(calendar.YEAR);
					
					GregorianCalendar jourFin = asCalendar(rs.getDate("DATE_FIN_STAGE"));
					jr.setDate(jourFin);
					ods.setDateDebutStage(jr);							
					
				}
				listeOffre.add(ods);
			}

	    }
	    
	      catch(SQLException ex){
	        System.err.println("Erreur lors de la cx a la base");
	        System.exit(1);
	      }
        
	}
	
	public static GregorianCalendar asCalendar(Date date) {
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
    public static void load() {
        // TODO code application logic here
        /**Chargement du driver JDBC=Etape1*/
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch(Exception ex){
            System.err.println("Erreur lors du chargement du driver");
            System.exit(1);
        }
                
    }

	@Override
	public void create(Entreprise entr) throws SQLException {
		// TODO Auto-generated method stub
		this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(CREATE_ENTREPRISE + entr.getNumeroEntreprise() + "," + entr.getNom() + "," + entr.getTelephone() + "," 
		+ entr.getMail() + "," + entr.getLogin() + "," + entr.getPassword());
		
	}

	@Override
	public void delete(Entreprise entr) throws SQLException {
		// TODO Auto-generated method stub
		this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(DELETE_ENTREPRISE + entr.getNumeroEntreprise());
	}

	@Override
	public void update(Entreprise entr) throws SQLException {
		// TODO Auto-generated method stub
		this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(UPDATE_ENTREPRISE + entr.getNumeroEntreprise());
	}

	@Override
	public Entreprise find(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = newConnection();
		return null;
	}

	@Override
	public ArrayList<Entreprise> getList() throws SQLException {
		ArrayList<Entreprise> listEntreprise = new ArrayList();
		Entreprise ent = new Entreprise();
		ResultSet rs = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(LIST_ENTREPRISE);
		for(int i=0; i<rs.getFetchSize(); i++){
			while(rs.next()){
				ent.setNumeroEntreprise(rs.getInt("NO_ENTREPRISE")); 
                ent.setNom(rs.getString("NOM"));
                ent.setAdresse(rs.getString("ADRESSE"));
                ent.setTelephone(rs.getString("TELEPHONE"));
                ent.setMail(rs.getString("MAIL"));
                ent.setLogin(rs.getString("LOGIN"));
                ent.setPassword(rs.getString("PASSWORD"));
			}
			listEntreprise.add(ent);
		}
		return listEntreprise;
	}
	

}
