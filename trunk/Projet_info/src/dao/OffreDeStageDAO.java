package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import beans.Jours;
import beans.OffreDeStage;

public class OffreDeStageDAO extends DAO<OffreDeStage>{
	public static String TABLE = "OFFRE_STAGE";
	private String FIND_OFFRESTAGE = "SELECT * FROM OFFRE_STAGE WHERE NO_OFFRE =";
	private String LIST_OFFRESTAGE = "SELECT * FROM OFFRE_STAGE";

	

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
			Statement request = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			request.executeQuery("DELETE FROM"  + OffreDeStageDAO.TABLE + " WHERE NO_OFFRE =" + ods.getNumeroOffreDeStage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public OffreDeStage update(OffreDeStage ods) {
        int id = ods.getNumeroOffreDeStage();
        try {            
            Statement request = this.connect.createStatement();
			request.executeUpdate("UPDATE "+ OffreDeStageDAO.TABLE +" SET  DESCRIPTION_OFFRE  ='" + ods.getDescriptionPoste()
					+"', DATE_FIN_STAGE = " + DAO.dateFromJavaToOracle(ods.getDateFinStage().getDateDuJour()) 
					+", DATE_DEBUT_STAGE = " + DAO.dateFromJavaToOracle(ods.getDateDebutStage().getDateDuJour())
					+" WHERE NO_OFFRE = " + id);
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
		try {
			Statement request = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = request.executeQuery(FIND_OFFRESTAGE + id);
			while(rs.next()){
				ods.setNumeroOffreDeStage(rs.getInt("NO_OFFRE")); 
			    ods.setDescriptionPoste(rs.getString("DESCRIPTION_OFFRE"));
			    ods.setEtatOffre(rs.getString("ETAT_OFFRE"));
			    		    
			    GregorianCalendar jourDebut = dateFromOracleToJava(rs.getDate("DATE_DEBUT_STAGE"));
				jrD.setDateDuJour(jourDebut);
				ods.setDateDebutStage(jrD);	
				
				GregorianCalendar jourFin = dateFromOracleToJava(rs.getDate("DATE_FIN_STAGE"));
				jrF.setDateDuJour(jourFin);
				ods.setDateFinStage(jrF);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ods;
	}
	
		
		
		//Recupere toute les offres de stage de la base 
		@Override
		public List<OffreDeStage> findAll() {
			List<OffreDeStage> listOffreStage = new ArrayList<OffreDeStage>();
			OffreDeStage ods = new OffreDeStage();
			Jours jrD = new Jours();
			Jours jrF = new Jours();
			
			try {
				Statement request = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = request.executeQuery(LIST_OFFRESTAGE);
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
		
		public List<OffreDeStage> findOffresValides() {
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

}
