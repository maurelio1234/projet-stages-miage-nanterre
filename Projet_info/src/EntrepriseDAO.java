import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import beans.Entreprise;


public class EntrepriseDAO {
	
	private Entreprise ent;
	private int numeroEnt;
	private Connection cx;
	//table = new hashtable();

	public EntrepriseDAO(){
		this.ent = new Entreprise();
	}
	
	
	public void EntrepriseConnexion(String log, String mdp){
		
		try{
            /**Connexion à la base= Etape2*/
            cx=DriverManager.getConnection("jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:"
                                                    + "1521:MIAGE","waabdou","apprentis2010pw");
            
            /** Creation et exécution d'une requete=Etape 3 & 4*/
            Statement st=cx.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM waabdou.ENTREPRISE WHERE LOGIN_ENTREPRISE = log " +
            										"and MDP_ENTREPRISE = mdp");
            
                       
            while(rs.next()){
            	this.ent.setNumeroEntreprise(rs.getInt("NO_ENTREPRISE")); 
                this.ent.setNom(rs.getString("NOM"));
                this.ent.setAdresse(rs.getString("ADRESSE"));
                this.ent.setTelephone(rs.getString("TELEPHONE"));
                this.ent.setMail(rs.getString("MAIL"));
                this.ent.setLogin(rs.getString("LOGIN"));
                this.ent.setPwd(rs.getString("PASSWORD"));
                this.numeroEnt = ent.getNumeroEntreprise();
                
            }
        }
        
	      catch(SQLException ex){
	        System.err.println("Erreur lors de la cx a la base");
	        System.exit(1);
	      }
		
	}
	
	
	public void ChargerOffreEnt(){
		
		try{
			/** Creation et exécution d'une requete=Etape 3 & 4*/
	        Statement st=cx.createStatement();
	        ResultSet rs=st.executeQuery("SELECT * FROM waabdou.OFFRE_STAGE WHERE NO_ENTREPRISE = numeroEnt");
	        List<OffreDeStage> listeOffre = new ArrayList<OffreDeStage>();
	        
	        while(rs.next()){
	        	OffreDeStage ods = (OffreDeStage) rs.next();
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
	

}
