package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import beans.Entreprise;
import beans.Jours;
import beans.OffreDeStage;

public class OffreDeStageDAO extends DAO<OffreDeStage>{
	
	public static String TABLE = "OFFRE_STAGE";
	private String FIND_OFFRESTAGE = "SELECT * FROM OFFRE_STAGE WHERE NO_OFFRE =";
	private String UPDATE_OFFRESTAGE = "UPDATE OFFRE_STAGE SET ";
	private String LIST_OFFRESTAGE = "SELECT * FROM OFFRE_STAGE";
	private String FIND_ENTREPRISE = "SELECT * FROM ENTREPRISE WHERE NO_ENTREPRISE =";
	
	private Statement st;
	private SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
	
	public OffreDeStageDAO() throws SQLException {
        st=this.connect.createStatement();
        
	}
	@Override
	public OffreDeStage create(OffreDeStage ods) {
		try {
			System.out.println("INSERT INTO "+ OffreDeStageDAO.TABLE +" (NO_OFFRE,DESCRIPTION_OFFRE,ETAT_OFFRE,NO_ENTREPRISE,DATE_FIN_STAGE,DATE_DEBUT_STAGE) " +
					"VALUES (SEQ_OFFRE_STAGE.NEXTVAL,'"+ods.getDescriptionPoste()+"','"+ods.getEtatOffre()+"',"+ods.getMonEntreprise().getNumeroEntreprise()
					+","+DAO.dateFromJavaToOracle(ods.getDateFinStage().getDateDuJour())
					+","+DAO.dateFromJavaToOracle(ods.getDateDebutStage().getDateDuJour())	+")");
			Statement request = this.connect.createStatement();
			request.executeUpdate("INSERT INTO "+ OffreDeStageDAO.TABLE +" (NO_OFFRE,DESCRIPTION_OFFRE,ETAT_OFFRE,NO_ENTREPRISE,DATE_FIN_STAGE,DATE_DEBUT_STAGE) " +
					"VALUES (SEQ_OFFRE_STAGE.NEXTVAL,'"+ods.getDescriptionPoste()+"','"+ods.getEtatOffre()+"',"+ods.getMonEntreprise().getNumeroEntreprise()
					+","+DAO.dateFromJavaToOracle(ods.getDateFinStage().getDateDuJour())
					+","+DAO.dateFromJavaToOracle(ods.getDateDebutStage().getDateDuJour())	+")");
		
			request.close();
			
			
//			String rs = "INSERT INTO" + OffreDeStageDAO.TABLE + "VALUES (" + ods.getNumeroOffreDeStage() + "," + ods.getDescriptionPoste() + "," + ods.getEtatOffre() + "," 
//					+ ods.getMonEntreprise().getNumeroEntreprise() + "," + ods.getDateFinStage() + "," + ods.getDateDebutStage() + ")";
//			
//			st.executeUpdate(rs);
//			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ods;

	}

	@Override
	public void delete(OffreDeStage ods) {
		try {
//			Statement request = this.connect.createStatement();
			st.executeUpdate("DELETE FROM"  + OffreDeStageDAO.TABLE + " WHERE NO_OFFRE =" + ods.getNumeroOffreDeStage());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	@Override
//	public OffreDeStage update(OffreDeStage ods) {
//		ResultSet rs;
//		try {
//			rs = st.executeQuery(UPDATE_OFFRESTAGE + ods.getNumeroOffreDeStage());
//			while(rs.next()){
//				ods.setNumeroOffreDeStage(rs.getInt("NO_OFFRE")); 
//				ods.setDescriptionPoste(rs.getString("DESCRIPTION_OFFRE"));
//				ods.setEtatOffre(rs.getString("ETAT_OFFRE"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return ods;
//		
//	}
	
	@Override
	public OffreDeStage update(OffreDeStage ods) {

        int id = ods.getNumeroOffreDeStage();
        try {            
            Statement request = this.connect.createStatement();
			request.executeUpdate("UPDATE "+ OffreDeStageDAO.TABLE +" SET  DESCRIPTION_OFFRE  ='" + ods.getDescriptionPoste()
					+"', DATE_FIN_STAGE = " + DAO.dateFromJavaToOracle(ods.getDateFinStage().getDateDuJour()) 
					+", DATE_DEBUT_STAGE = " + DAO.dateFromJavaToOracle(ods.getDateDebutStage().getDateDuJour())
					+" WHERE NO_OFFRE = " + ods.getNumeroOffreDeStage());
		request.close();            

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ods;
    }

	@Override
	public OffreDeStage find(int id) {
		OffreDeStage ods = new OffreDeStage();

		Jours jrD = new Jours();
		Jours jrF = new Jours();
		 
		ResultSet rs;
		try {
			rs = st.executeQuery(FIND_OFFRESTAGE + id);

		try {
			while(rs.next()){
				ods.setNumeroOffreDeStage(rs.getInt("NO_OFFRE")); 
				System.out.println("Je fais no offre: " + rs.getInt("NO_OFFRE"));
			    ods.setDescriptionPoste(rs.getString("DESCRIPTION_OFFRE"));
			    System.out.println("Je fais description offre: " + rs.getString("DESCRIPTION_OFFRE"));
			    ods.setEtatOffre(rs.getString("ETAT_OFFRE"));
			    System.out.println("Je fais etat offre: " + rs.getString("ETAT_OFFRE"));
			    		    
			    GregorianCalendar jourDebut = asCalendar(rs.getDate("DATE_DEBUT_STAGE"));
				jrD.setDateDuJour(jourDebut);
				ods.setDateDebutStage(jrD);
				String jourDebutS = calendarToString(jourDebut);
				System.out.println("Je fais Date fin avec fonction: " + jourDebutS);	
				
				GregorianCalendar jourFin = asCalendar(rs.getDate("DATE_FIN_STAGE"));
				jrF.setDateDuJour(jourFin);
				ods.setDateFinStage(jrF);  
				String jourFinS = calendarToString(jourFin);
				System.out.println("Je fais Date fin avec fonction: " + jourFinS);	
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ods;
	}
	
	//Conversion d'un type date en gregorianCalendar
	public static GregorianCalendar asCalendar(Date date) {
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	// Conversion d'une date de type gregorianCalendar en String
	public static String calendarToString(GregorianCalendar sDate) throws Exception {     
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(sDate.getTime());
        return date;
	} 
	
	
	
	
	//Recupere toute les offres de stage de la base 
	@Override
	public List<OffreDeStage> findAll() {
		List<OffreDeStage> listOffreStage = new ArrayList<OffreDeStage>();
		OffreDeStage ods = new OffreDeStage();
		Entreprise ent = new Entreprise();
		Jours jrD = new Jours();
		Jours jrF = new Jours();
		
		try {
			ResultSet rs = st.executeQuery(LIST_OFFRESTAGE);
				while(rs.next()){
					ods.setNumeroOffreDeStage(rs.getInt("NO_OFFRE")); 
			        ods.setDescriptionPoste(rs.getString("DESCRIPTION_OFFRE"));
			        ods.setEtatOffre(rs.getString("ETAT_OFFRE"));
			        GregorianCalendar jourDebut = DAO.dateFromOracleToJava(rs.getDate("DATE_DEBUT_STAGE"));
					jrD.setDateDuJour(jourDebut);
					ods.setDateDebutStage(jrD);
					GregorianCalendar jourFin = DAO.dateFromOracleToJava(rs.getDate("DATE_FIN_STAGE"));
					jrF.setDateDuJour(jourFin);
					ods.setDateFinStage(jrF);  	
					listOffreStage.add(ods);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("NB offre " + listOffreStage.size());
		return listOffreStage;
	}
	
	public List<OffreDeStage> FindOffresValides() {
		List<OffreDeStage> listOffreStage = new ArrayList<OffreDeStage>();
		List<OffreDeStage> listOffreValides = new ArrayList<OffreDeStage>();
		listOffreValides = findAll();
			for(int i=0; i<listOffreStage.size(); i++){
				if(listOffreStage.get(i).getEtatOffre()=="validé"){
					listOffreValides.add(listOffreStage.get(i));
				}
			}
				
		return listOffreValides;
		
	}
	
	
	 public static void load() {
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
