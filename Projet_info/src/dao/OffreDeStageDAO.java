package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import beans.Entreprise;
import beans.Jours;
import beans.OffreDeStage;

public class OffreDeStageDAO extends DAO<OffreDeStage>{
	
	private String FIND_OFFRESTAGE = "SELECT * FROM OFFRE_STAGE WHERE NO_OFFRE =";
	private String CREATE_OFFRESTAGE = "INSERT INTO OFFRE_STAGE";
	private String DELETE_OFFRESTAGE = "DELETE FROM OFFRE_STAGE WHERE ...";
	private String UPDATE_OFFRESTAGE = "UPDATE OFFRE_STAGE SET ";
	private String NO_ENT_OFFRESTAGE = "SELECT NO_ENTREPRISE FROM OFFRE_STAGE WHERE NO_OFFRE =";
	private String LIST_ENTREPRISE = "SELECT * FROM ENTREPRISE";
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
		EntrepriseDAO etpDAO = new EntrepriseDAO();
		Jours jr = new Jours();
		 
		ResultSet rs = st.executeQuery(FIND_OFFRESTAGE + id);
		ResultSet rs1 = st.executeQuery(NO_ENT_OFFRESTAGE + id);
		
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
		return ods;
	}
	
	public static GregorianCalendar asCalendar(Date date) {
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	@Override
	public ArrayList<OffreDeStage> getList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}