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
	private String CREATE_ENTREPRISE = "INSERT INTO Entreprise ...";
	private String DELETE_ENTREPRISE = "DELETE FROM Entreprise WHERE ...";
	private String UPDATE_ENTREPRISE = "UPDATE Entreprise SET ";
	private String LIST_ENTREPRISE = "SELECT * FROM ENTREPRISE OFFRE_STAGE WHERE NO_ENTREPRISE =";
	
	private Entreprise ent;
	private int numeroEnt;
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
        
            while(rs.next()){
            	this.ent.setNumeroEntreprise(rs.getInt("NO_ENTREPRISE")); 
                this.ent.setNom(rs.getString("NOM"));
                this.ent.setAdresse(rs.getString("ADRESSE"));
                this.ent.setTelephone(rs.getString("TELEPHONE"));
                this.ent.setMail(rs.getString("MAIL"));
                this.ent.setLogin(rs.getString("LOGIN"));
                this.ent.setPassword(rs.getString("PASSWORD"));
                this.numeroEnt = ent.getNumeroEntreprise();
                
            }
        }
        
	      catch(SQLException ex){
	        System.err.println("Erreur lors de la connexion a la base");
	        System.exit(1);
	      }
		
	}
	
	
	public void ChargerOffreEnt(){
		
		try{
	        ResultSet rs = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(LIST_ENTREPRISE + numeroEnt);
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
					int day = calendar.get(calendar.DATE);
					int month = calendar.get(calendar.MONTH);
					int year = calendar.get(calendar.YEAR);
															
					jr.setDate(calendar);
					ods.setDateDebutStage(jr);
					
					jr.setDate(rs.getDate("DATE_JOUR"));
					ods.setDateFinStage(jr);								
					
				}
				listeOffre.add(ods);
			}

	    }
	    
	      catch(SQLException ex){
	        System.err.println("Erreur lors de la cx a la base");
	        System.exit(1);
	      }
        
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
	public void create(Entreprise obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Entreprise obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Entreprise obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entreprise find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Entreprise> getList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
