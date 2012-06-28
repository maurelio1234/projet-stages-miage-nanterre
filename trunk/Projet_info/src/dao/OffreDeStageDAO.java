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
import java.util.List;

import beans.Entreprise;
import beans.Jours;
import beans.OffreDeStage;
import dao.DAO;

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
			String rs = "INSERT INTO" + OffreDeStageDAO.TABLE + "VALUES (" + ods.getNumeroOffreDeStage() + "," + ods.getDescriptionPoste() + "," + ods.getEtatOffre() + "," 
					+ ods.getMonEntreprise().getNumeroEntreprise() + "," + ods.getDateFinStage() + "," + ods.getDateDebutStage() + ")";
			
			st.executeUpdate(rs);
			st.close();
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

	@Override
	public OffreDeStage update(OffreDeStage ods) {
		ResultSet rs;
		try {
			rs = st.executeQuery(UPDATE_OFFRESTAGE + ods.getNumeroOffreDeStage());
			while(rs.next()){
				ods.setNumeroOffreDeStage(rs.getInt("NO_OFFRE")); 
				ods.setDescriptionPoste(rs.getString("DESCRIPTION_OFFRE"));
				ods.setEtatOffre(rs.getString("ETAT_OFFRE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ods;
		
	}

	@Override
	public OffreDeStage find(int id) {
		OffreDeStage ods = new OffreDeStage();

		Jours jr = new Jours();
		 
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
				jr.setDateDuJour(jourDebut);
				ods.setDateDebutStage(jr);
				System.out.println("Je fais Date debut: " + sf.format(jourDebut.getTime()));
				
				GregorianCalendar jourFin = asCalendar(rs.getDate("DATE_FIN_STAGE"));
				jr.setDateDuJour(jourFin);
				ods.setDateFinStage(jr);  
				String jourFinS = calendarToString(jourFin);
				System.out.println("Je fais Date fin: " + sf.format(jourFin.getTime()));
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
	
		try {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOffreStage;
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
