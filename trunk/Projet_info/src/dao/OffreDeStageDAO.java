package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import beans.Entreprise;
import beans.Jours;
import beans.OffreDeStage;

public class OffreDeStageDAO extends DAO<OffreDeStage>{
	
	private String FIND_OFFRESTAGE = "SELECT * FROM OFFRE_STAGE WHERE NO_OFFRE =";
	private String CREATE_OFFRESTAGE = "INSERT INTO OFFRE_STAGE";
	private String DELETE_OFFRESTAGE = "DELETE FROM OFFRE_STAGE WHERE NO_OFFRE =";
	private String UPDATE_OFFRESTAGE = "UPDATE OFFRE_STAGE SET ";
	private String NO_ENT_OFFRESTAGE = "SELECT NO_ENTREPRISE FROM OFFRE_STAGE WHERE NO_OFFRE =";
	private String LIST_OFFRESTAGE = "SELECT * FROM OFFRE_STAGE";
	private String FIND_ENTREPRISE = "SELECT * FROM ENTREPRISE WHERE NO_ENTREPRISE =";
	
	private Statement st;
	
	
	public OffreDeStageDAO() throws SQLException {
        Connection cx=DriverManager.getConnection("jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:"
                                                + "1521:MIAGE","ebkacouc","apprentis2010pw");
        
        st=cx.createStatement();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void create(OffreDeStage ods) throws SQLException {
		st.executeQuery(CREATE_OFFRESTAGE + ods.getNumeroOffreDeStage() + "," + ods.getDescriptionPoste() + "," + ods.getEtatOffre() + "," 
				+ ods.getMonEntreprise().getNumeroEntreprise() + "," + ods.getDateFinStage() + "," + ods.getDateDebutStage());
		
	}

	@Override
	public void delete(OffreDeStage ods) throws SQLException {
		st.executeQuery(DELETE_OFFRESTAGE + ods.getNumeroOffreDeStage());
		
	}

	@Override
	public void update(OffreDeStage ods) throws SQLException {
		st.executeQuery(UPDATE_OFFRESTAGE + ods.getNumeroOffreDeStage());
		
	}

	@Override
	public OffreDeStage find(int id) throws SQLException {
		OffreDeStage ods = new OffreDeStage();
		Entreprise ent = new Entreprise();
//		EntrepriseDAO etpDAO = new EntrepriseDAO();
		Jours jr = new Jours();
		 
		ResultSet rs = st.executeQuery(FIND_OFFRESTAGE + id);
//		ResultSet rs1 = st.executeQuery(NO_ENT_OFFRESTAGE + id);
		
		while(rs.next()){
			System.out.println("Je suis dans la 1ere boucle");
			ods.setNumeroOffreDeStage(rs.getInt("NO_OFFRE")); 
			System.out.println("Je fais no offre: " + rs.getInt("NO_OFFRE"));
            ods.setDescriptionPoste(rs.getString("DESCRIPTION_OFFRE"));
            System.out.println("Je fais description offre: " + rs.getString("DESCRIPTION_OFFRE"));
            ods.setEtatOffre(rs.getString("ETAT_OFFRE"));
            System.out.println("Je fais etat offre: " + rs.getString("ETAT_OFFRE"));
            
//    		ResultSet rs2 = st.executeQuery(FIND_ENTREPRISE + rs.getInt("NO_ENTREPRISE"));
//    		System.out.println("Je fais No entreprise: " + rs.getString("NO_NETREPRISE"));
//    		while(rs2.next()){
//    			System.out.println("Je suis dans la 2e boucle");
////    			ent.setNumeroEntreprise(rs.getInt("NO_ENTREPRISE")); 
//                ent.setNom(rs.getString("NOM_ENTREPRISE"));
//                ent.setTelephone(rs.getString("TELEPHONE_ENTREPRISE"));
//                ent.setMail(rs.getString("MAIL_ENTREPRISE"));
//                ent.setLogin(rs.getString("LOGIN_ENTREPRISE"));
//                ent.setPassword(rs.getString("MDP_ENTREPRISE"));
//    		}
//    		ods.setMonEntreprise(ent);
    		
//            Entreprise etp = etpDAO.find(rs.getInt("NO_ENTREPRISE"));
//            etp.setNumeroEntreprise(rs.getInt("NO_ENTREPRISE"));
//            ods.setMonEntreprise(etp);
            
            GregorianCalendar jourDebut = asCalendar(rs.getDate("DATE_DEBUT_STAGE"));
			jr.setDateDuJour(jourDebut);
			ods.setDateDebutStage(jr);
			
			GregorianCalendar jourFin = asCalendar(rs.getDate("DATE_FIN_STAGE"));
			jr.setDateDuJour(jourFin);
			ods.setDateFinStage(jr);       
		}
		
		System.out.println("Numero offre" + ods.getNumeroOffreDeStage());
		System.out.println("Description offre" + ods.getDescriptionPoste());
		System.out.println("Etat offre" + ods.getEtatOffre());
		System.out.println("Date debut" + ods.getDateDebutStage());
		
		return ods;
	}
	
	public static GregorianCalendar asCalendar(Date date) {
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	
	public static GregorianCalendar stringToCalendar(String sDate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = (Date) sdf.parse(sDate);
        return asCalendar(date);
	} 
	

	@Override
	public ArrayList<OffreDeStage> getList() throws SQLException {
		ArrayList<OffreDeStage> listOffreStage = new ArrayList();
		OffreDeStage ods = new OffreDeStage();
		Entreprise ent = new Entreprise();
		
		ResultSet rs = st.executeQuery(LIST_OFFRESTAGE);
		for(int i=0; i<rs.getFetchSize(); i++){
			while(rs.next()){
				ods.setNumeroOffreDeStage(rs.getInt("NO_OFFRE")); 
	            ods.setDescriptionPoste(rs.getString("DESCRIPTION_OFFRE"));
	            ods.setEtatOffre(rs.getString("ETAT_OFFRE"));
	            ResultSet rs2 = st.executeQuery(FIND_ENTREPRISE + rs.getInt("NO_ENTREPRISE"));
	    		while(rs2.next()){
	    			ent.setNumeroEntreprise(rs.getInt("NO_ENTREPRISE")); 
	                ent.setNom(rs.getString("NOM"));
	                ent.setAdresse(rs.getString("ADRESSE"));
	                ent.setTelephone(rs.getString("TELEPHONE"));
	                ent.setMail(rs.getString("MAIL"));
	                ent.setLogin(rs.getString("LOGIN"));
	                ent.setPassword(rs.getString("PASSWORD"));
	    		}
	    		ods.setMonEntreprise(ent);
	    		
			}
			listOffreStage.add(ods);
		}
		return listOffreStage;
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
