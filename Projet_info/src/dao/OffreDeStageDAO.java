package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Entreprise;
import beans.OffreDeStage;

public class OffreDeStageDAO extends DAO<OffreDeStage>{
	
	private String FIND_OFFRESTAGE = "SELECT * FROM OFFRE_STAGE WHERE DESCRPTION_OFFRE = desc";
	private String CREATE_OFFRESTAGE = "INSERT INTO OFFRE_STAGE ...";
	private String DELETE_OFFRESTAGE = "DELETE FROM OFFRE_STAGE WHERE ...";
	private String UPDATE_OFFRESTAGE = "UPDATE OFFRE_STAGE SET ";
	private Statement st;
	
	
	public OffreDeStageDAO() throws SQLException {
        Connection cx=DriverManager.getConnection("jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:"
                                                + "1521:MIAGE","ebkacouc","apprentis2010pw");
        
        st=cx.createStatement();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void create(OffreDeStage obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(OffreDeStage obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(OffreDeStage obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OffreDeStage find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OffreDeStage> getList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
