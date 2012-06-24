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

public class ContratApprentissageDAO extends DAO<ContratApprentissage> {
	public static String TABLE = "CONTRATAPPRENTISSAGE";
	@Override
	public ContratApprentissage create(ContratApprentissage obj) {

		// TODO Auto-generated method stub
		try {
			Statement request = this.connect.createStatement();
			String requete = "INSERT INTO " + ContratApprentissageDAO.TABLE + " (NUM_CONTRAT, "
					+ "DATESIGNATURECONTRAT, " + "SALAIRE, "+"DUREE ) " + "VALUES (" + "'"
					+ obj.getNumeroContrat() + "'," + obj.getDateSignatureContrat() + ","
					+ "'" + obj.getSalaire() + "'"+ "'," + "'"+ obj.getDuree() + "')";

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
	public void delete(ContratApprentissage obj) {
		// TODO Auto-generated method stub
		try {
			Statement request = this.connect.createStatement();
			request.executeUpdate("DELETE FROM " + ContratApprentissageDAO.TABLE +" WHERE NO_CONTRAT = " +obj.getNumeroContrat());
			request.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ContratApprentissage find(int id) {
		// TODO Auto-generated method stub
		ContratApprentissage obj = null;
		try {
			Statement request = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet result = request.executeQuery("SELECT * FROM " + ContratApprentissageDAO.TABLE + " WHERE NO_CONTRAT = " + id);

			if(result.first()){
			
				obj = new ContratApprentissage((result.getInt("NO_CONTRAT")),(result.getDate("DATE_SIGNATURE")),(result.getDouble("SALAIRE"),(result.getString("DUREE")));
				
			}
			request.close();
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	    return obj;
	}

	@Override
	public ContratApprentissage update(ContratApprentissage obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
