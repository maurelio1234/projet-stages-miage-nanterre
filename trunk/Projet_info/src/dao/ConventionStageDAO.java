package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.sql.SQLException;
import java.sql.Statement;

import beans.ContratApprentissage;
import beans.ConventionStage;

public class ConventionStageDAO extends DAO<ConventionStage> {
	public static String TABLE = "CONVENTIONSTAGE";
	@Override
	public ConventionStage create(ConventionStage obj) {
		// TODO Auto-generated method stub
		try {
			Statement request = this.connect.createStatement();
			String requete = "INSERT INTO " + ConventionStageDAO.TABLE + " (NUM_CONVENTION, "
					+ "DATESIGNATURECONVENTION, " + "DUREECONVENTION ) " + "VALUES (" + "'"
					+ obj.getNumeroConvention() + "'," + obj.getDateSignatureConvention() + ","
					+ "'" + obj.getDureeConvention() + "')";

			request.executeUpdate(requete);

			if (debug)
				System.out.println(requete);

			request.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
		
		return null;
	}

	@Override
	public void delete(ConventionStage obj) {
		// TODO Auto-generated method stub
		try {
			Statement request = this.connect.createStatement();
			request.executeUpdate("DELETE FROM " + ConventionStageDAO.TABLE +" WHERE NO_CONVENTION= " +obj.getNumeroConvention());
			request.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ConventionStage find(int id) {
		// TODO Auto-generated method stub
		ConventionStage obj = null;
		try {
			Statement request = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet result = request.executeQuery("SELECT * FROM " + ConventionStageDAO.TABLE + " WHERE NO_CONVENTION = " + id);

			if(result.first()){
			
				obj = new ConventionStage((result.getInt("NO_CONTRAT")),(result.getDate("DATE_SIGNATURE")),(result.getInt("DUREE")));
				
			}
			request.close();
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
	}

	@Override
	public ConventionStage update(ConventionStage obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
